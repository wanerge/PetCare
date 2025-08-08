import { Injectable, inject, signal } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { environment } from '../../../enviroments/environment.prod';
import { catchError, Observable, tap, throwError } from 'rxjs';
import { Servicios } from '../models/servicios';


@Injectable({
  providedIn: 'root'
})


export class HomeApi {

  private readonly http = inject(HttpClient);
  private readonly apiUrl = `${environment.apiUrl}/servicios`;

  // Signal for reactive state management
  private readonly serviciosSignal = signal<Servicios[]>([]);
  private readonly isLoadingSignal = signal<boolean>(false);

  // Readonly signals for external consumption
  public readonly servicios = this.serviciosSignal.asReadonly();
  public readonly isLoading = this.isLoadingSignal.asReadonly();

  getAllServicios(): Observable<Servicios[]> {
    this.isLoadingSignal.set(true);

    return this.http.get<Servicios[]>(this.apiUrl)
      .pipe(
        tap(servicios => {
          this.serviciosSignal.set(servicios);
          this.isLoadingSignal.set(false);
        }),
        catchError(error => {
          this.isLoadingSignal.set(false);
          return this.handleError(error);
        })
      );
  }

  private handleError(error: HttpErrorResponse): Observable<never> {
    let errorMessage = 'An unknown error occurred';

    if (error.error instanceof ErrorEvent) {
      // Client-side error
      errorMessage = `Error: ${error.error.message}`;
    } else {
      // Server-side error
      switch (error.status) {
        case 400:
          errorMessage = 'Bad request. Please check your input.';
          break;
        case 401:
          errorMessage = 'Unauthorized. Please log in.';
          break;
        case 403:
          errorMessage = 'Forbidden. Admin access required for alumni operations.';
          break;
        case 404:
          errorMessage = 'Alumno not found.';
          break;
        case 409:
          errorMessage = 'Alumno already exists.';
          break;
        case 500:
          errorMessage = 'Internal server error. Please try again later.';
          break;
        default:
          errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
      }
    }

    console.error('ServicioService Error:', error);
    return throwError(() => new Error(errorMessage));
  }

}