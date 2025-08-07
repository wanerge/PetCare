import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';


interface LoginRequestDTO {
  correo: string;
  clave: string;
}

@Injectable({
  providedIn: 'root'
})
export class LoginServices {
  private apiUrl = 'http://localhost:8080/api/usuarios';

  constructor(private http: HttpClient) {}

  login(data: LoginRequestDTO): Observable<any> {
    return this.http.post(`${this.apiUrl}/auth/login`, data, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      responseType: 'text' // usa 'json' si tu backend devuelve JSON
    });
  }
}
