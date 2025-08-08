import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';

export interface Service {
  id: string;
  name: string;
  description: string;
  price: number;
  duration?: number;
  category?: string;
}

export interface Pet {
  idMascota: string;
  nombre: string;
  especie: string;
}

export interface Veterinario {
  id: string;
  nombre: string;
  especialidad: string;
}

export interface AppointmentData {
  fecha: string; // "YYYY-MM-DD"
  hora: string;  // "HH:mm"
  idCliente: number;
  idMascota: number;
  idVeterinario: number;
  idEstado: number;
  idServicios: number[];
}

export interface Appointment extends AppointmentData {
  id: string;
  status: 'pending' | 'confirmed' | 'completed' | 'cancelled';
  createdAt: Date;
  anticipo: number;
}

export interface AvailableSlot {
  date: string;
  time: string;
  available: boolean;
}

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  // =================== MÉTODOS DE SERVICIOS ===================

  getServices(): Observable<Service[]> {
    return this.http.get<Service[]>(`${this.apiUrl}/api/servicios`);
  }

  getServiceById(id: string): Observable<Service> {
    return this.http.get<Service>(`${this.apiUrl}/servicios/${id}`);
  }

  getHttpOptions(): any {
    const token = localStorage.getItem('token');
    const headers = token
      ? new HttpHeaders().set('Authorization', `Bearer ${token}`)
      : new HttpHeaders();
    return { headers };
  }

  // =================== MÉTODOS DE MASCOTAS ===================

  getPets(): Observable<Pet[]> {
    const token = localStorage.getItem('token') || '';
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    });
    return this.http.get<Pet[]>(`${this.apiUrl}/api/mascotas/clientes`, { headers });
  }

  // =================== MÉTODOS DE VETERINARIOS ===================

  getVeterinarios(): Observable<Veterinario[]> {
    const token = localStorage.getItem('token') || '';
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    });
    return this.http.get<Veterinario[]>(`${this.apiUrl}/api/veterinarios/all`, { headers });
  }

  // =================== MÉTODOS DE CITAS ===================

  createAppointment(appointmentData: AppointmentData): Observable<Appointment> {
    console.log("Cita Creada")
    const token = localStorage.getItem('token') || '';
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    });
    return this.http.post<Appointment>(`${this.apiUrl}/api/citas`, appointmentData, { headers });
  }

  getUserAppointments(clienteId: number): Observable<Appointment[]> {
    const token = localStorage.getItem('token') || '';
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    });
    return this.http.get<Appointment[]>(`${this.apiUrl}/api/citas/cliente/${clienteId}`, { headers });
  }

  sendReminder(appointmentId: string): Observable<any> {
    const token = localStorage.getItem('token') || '';
    const headers = new HttpHeaders({
      'Authorization': `Bearer ${token}`,
      'Content-Type': 'application/json',
      'Accept': 'application/json'
    });
    return this.http.post(`${this.apiUrl}/appointments/${appointmentId}/reminder`, {}, { headers });
  }

  // =================== MÉTODO SIMULADO PARA HORARIOS DISPONIBLES ===================

  getAvailableSlots(vetId: number, fecha: string): Observable<AvailableSlot[]> {
    // 🔥 Aquí estás devolviendo datos quemados como simulación.
    // Cuando tu backend esté listo, reemplaza por:
    // return this.http.get<AvailableSlot[]>(`${this.apiUrl}/api/horarios/disponibles?fecha=${fecha}&idVeterinario=${vetId}`, { headers });
    const fakeSlots: AvailableSlot[] = [
      { date: fecha, time: '09:00:00', available: true },
      { date: fecha, time: '10:00:00', available: true },
      { date: fecha, time: '11:00:00', available: true },
      { date: fecha, time: '14:00:00', available: true },
      { date: fecha, time: '15:00:00', available: false }, // ocupado
      { date: fecha, time: '16:00:00', available: true }
    ];
    return of(fakeSlots);
  }
}
