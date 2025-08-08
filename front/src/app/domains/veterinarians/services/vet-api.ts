import { Injectable, inject } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class VetApi {
  private http = inject(HttpClient);
  private baseUrl = 'http://localhost:8080/api/citas/veterinario';

  private getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('vet_token');
    return new HttpHeaders({
      'Authorization': `Bearer ${token ?? ''}`
    });
  }

  getPendingAppointments(): Observable<any> {
    const headers = this.getAuthHeaders();
    return this.http.get(`${this.baseUrl}/pendientes`, { headers });
  }

  getCompletedAppointments(): Observable<any> {
    const headers = this.getAuthHeaders();
    return this.http.get(`${this.baseUrl}/completadas`, { headers });
  }
}
