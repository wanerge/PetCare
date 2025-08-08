import { Component, OnInit } from '@angular/core';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { ClientService, Service } from '../../../jobs/services/client-service';

// Interfaces para el componente
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

export interface AvailableSlot {
  date: string;
  time: string;
  available: boolean;
}

// ... (imports sin cambios)
@Component({
  selector: 'app-client-dashboard',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    CurrencyPipe
  ],
  templateUrl: './client-dashboard.html',
  styleUrls: ['./client-dashboard.css']
})
export class ClientDashboard implements OnInit {
  services: Service[] = [];
  selectedService: Service | null = null;
  availableSlots: AvailableSlot[] = [];

  appointmentData: AppointmentData = {
    serviceId: '',
    date: '',
    time: '',
    petName: '',
    petType: 'perro',
    ownerName: '',
    email: '',
    phone: ''
  };

  loading = false;
  error = '';
  success = '';

  constructor(private clientService: ClientService) {}

  ngOnInit(): void {
    this.loadServices();
  }

loadServices(): void {
  this.loading = true;
  this.clientService.getServices().subscribe({
    next: (services: any[]) => {
      this.services = services.map(s => ({
        id: s.id,
        name: s.nombre,              
        description: s.descripcion,  
        price: s.precio,       
        duration: s.duracion,
        category: s.categoria
      }));
      this.loading = false;
    },
    error: (error) => {
      this.error = 'Error al cargar servicios';
      this.loading = false;
      console.error('Error:', error);
    }
  });
}


  handleServiceSelect(event: Event): void {
    const target = event.target as HTMLSelectElement;
    const serviceName = target.value;
    this.selectedService = this.services.find(s => s.name === serviceName) || null;

    if (this.selectedService) {
      this.appointmentData.serviceId = this.selectedService.id;
      this.loadAvailableSlots(); // Esta parte se simulará por ahora
    }
  }

  loadAvailableSlots(): void {
    // ⚠️ Esto se simula, ya que tu backend no tiene esta funcionalidad
    this.availableSlots = [
      { date: '2025-08-08', time: '10:00 AM', available: true },
      { date: '2025-08-08', time: '2:00 PM', available: true },
      { date: '2025-08-09', time: '9:00 AM', available: true },
      { date: '2025-08-09', time: '11:00 AM', available: true },
      { date: '2025-08-10', time: '10:00 AM', available: true }
    ];
  }

  get availableDates(): AvailableSlot[] {
    return this.availableSlots
      .filter(slot => slot.available)
      .filter((slot, index, self) =>
        index === self.findIndex(s => s.date === slot.date)
      );
  }

  get availableTimes(): AvailableSlot[] {
    if (!this.appointmentData.date) return [];
    return this.availableSlots.filter(slot =>
      slot.date === this.appointmentData.date && slot.available
    );
  }

  handleScheduleAppointment(event: Event): void {
    event.preventDefault();

    if (!this.validateForm()) return;

    this.loading = true;
    this.error = '';
    this.success = '';

    this.clientService.createAppointment(this.appointmentData).subscribe({
      next: (appointment) => {
        this.success = 'Cita programada exitosamente';
        this.loading = false;
        this.resetForm();
        console.log('Cita creada:', appointment);
      },
      error: (error) => {
        this.error = 'Error al programar la cita. Intenta nuevamente.';
        this.loading = false;
        console.error('Error:', error);
      }
    });
  }

  validateForm(): boolean {
    if (!this.selectedService) {
      this.error = 'Selecciona un servicio';
      return false;
    }

    if (!this.appointmentData.date || !this.appointmentData.time) {
      this.error = 'Selecciona fecha y hora';
      return false;
    }

    if (!this.appointmentData.petName || !this.appointmentData.ownerName) {
      this.error = 'Completa todos los campos obligatorios';
      return false;
    }

    if (!this.appointmentData.email || !this.appointmentData.phone) {
      this.error = 'Completa email y teléfono';
      return false;
    }

    return true;
  }

  sendReminder(): void {
    console.log('Enviando recordatorio...');
    // Pendiente de implementar en backend
  }

  resetForm(): void {
    this.appointmentData = {
      serviceId: '',
      date: '',
      time: '',
      petName: '',
      petType: 'perro',
      ownerName: '',
      email: '',
      phone: ''
    };
    this.selectedService = null;
    this.availableSlots = [];
  }

  formatDate(dateString: string): string {
    const date = new Date(dateString);
    return date.toLocaleDateString('es-ES', {
      day: 'numeric',
      month: 'long',
      year: 'numeric'
    });
  }
}
