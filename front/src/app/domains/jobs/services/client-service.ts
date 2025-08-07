import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';

export interface Service {
  id: string;
  name: string;
  description: string;
  price: number;
  duration?: number;
  category?: string;
}

export interface AppointmentData {
  serviceId: string;
  date: string;
  time: string;
  petName: string;
  petType: string;
  ownerName: string;
  email: string;
  phone: string;
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

  // ========== MÉTODOS DE SERVICIOS ==========
  
  getServices(): Observable<Service[]> {
    // Primero intenta obtener del backend
    //return this.http.get<Service[]>(`${this.apiUrl}/api/servicios`);
    
    // Si falla, puedes descomentar esto para datos de prueba:
    
    return of([
      {
        id: '1',
        name: 'Consulta General',
        description: 'Examen médico completo para tu mascota',
        price: 50000,
        duration: 30,
        category: 'consulta'
      },
      {
        id: '2',
        name: 'Vacunación',
        description: 'Aplicación de vacunas preventivas',
        price: 35000,
        duration: 15,
        category: 'preventivo'
      },
      {
        id: '3',
        name: 'Cirugía Menor',
        description: 'Procedimientos quirúrgicos ambulatorios',
        price: 150000,
        duration: 60,
        category: 'cirugia'
      },
      {
        id: '4',
        name: 'Baño y Peluquería',
        description: 'Servicio completo de estética canina',
        price: 40000,
        duration: 45,
        category: 'estetica'
      }
    ]);
  
  }

  getServiceById(id: string): Observable<Service> {
    return this.http.get<Service>(`${this.apiUrl}/services/${id}`);
  }

  // ========== MÉTODOS DE CITAS ==========
  getAvailableSlots(serviceId?: string): Observable<AvailableSlot[]> {
    const url = serviceId ? 
      `${this.apiUrl}/appointments/available-slots?serviceId=${serviceId}` : 
      `${this.apiUrl}/appointments/available-slots`;
    
    return this.http.get<AvailableSlot[]>(url);
  }

  createAppointment(appointmentData: AppointmentData): Observable<Appointment> {
    return this.http.post<Appointment>(`${this.apiUrl}/appointments`, appointmentData);
  }

  getUserAppointments(email: string): Observable<Appointment[]> {
    return this.http.get<Appointment[]>(`${this.apiUrl}/appointments/user/${email}`);
  }

  sendReminder(appointmentId: string): Observable<any> {
    return this.http.post(`${this.apiUrl}/appointments/${appointmentId}/reminder`, {});
  }

  // ========== MÉTODOS DE UTILIDAD ==========
  // Método para datos de prueba mientras desarrollas
  getTestServices(): Observable<Service[]> {
    return of([
      {
        id: '1',
        name: 'Consulta General',
        description: 'Examen médico completo para tu mascota',
        price: 50000,
        duration: 30,
        category: 'consulta'
      },
      {
        id: '2',
        name: 'Vacunación',
        description: 'Aplicación de vacunas preventivas',
        price: 35000,
        duration: 15,
        category: 'preventivo'
      },
      {
        id: '3',
        name: 'Cirugía Menor',
        description: 'Procedimientos quirúrgicos ambulatorios',
        price: 150000,
        duration: 60,
        category: 'cirugia'
      },
      {
        id: '4',
        name: 'Baño y Peluquería',
        description: 'Servicio completo de estética canina',
        price: 40000,
        duration: 45,
        category: 'estetica'
      }
    ]);
  }
}