import { Component, OnInit } from '@angular/core';
import { CommonModule, CurrencyPipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { ClientService, Service, Pet, Veterinario } from '../../../jobs/services/client-service';

export interface AppointmentData {
  fecha: string;
  hora: string;
  idCliente: number;
  idMascota: number;
  idVeterinario: number;
  idEstado: number;
  idServicios: number[];
}

export interface AvailableSlot {
  date: string;
  time: string;
  available: boolean;
}

@Component({
  selector: 'app-client-dashboard',
  standalone: true,
  imports: [CommonModule, FormsModule, CurrencyPipe],
  templateUrl: './client-dashboard.html',
  styleUrls: ['./client-dashboard.css']
})
export class ClientDashboard implements OnInit {
  services: Service[] = [];
  selectedService: Service | null = null;
  availableSlots: AvailableSlot[] = [];
  pets: Pet[] = [];
  veterinarios: Veterinario[] = [];
  selectedPetId: string = '';
  selectedVeterinarioId: string = '';
  appointmentData!: AppointmentData;

  loading = false;
  error = '';
  success = '';

  constructor(private clientService: ClientService) { }

  ngOnInit(): void {
    this.loadServices();
    this.loadPets();
    this.loadVeterinarios();
    this.resetForm();
  }

  loadPets(): void {
    this.clientService.getPets().subscribe({
      next: (pets) => this.pets = pets,
      error: (error) => console.error('Error cargando mascotas', error)
    });
  }

  loadVeterinarios(): void {
    this.clientService.getVeterinarios().subscribe({
      next: (veterinarios) => this.veterinarios = veterinarios,
      error: (error) => console.error('Error cargando veterinarios', error)
    });
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
      this.appointmentData.idServicios = [Number(this.selectedService.id)];
      this.loadAvailableSlots();
    }
  }

  loadAvailableSlots(): void {
    this.availableSlots = [
      { date: '2025-08-08', time: '10:00:00', available: true },
      { date: '2025-08-08', time: '14:00:00', available: true },
      { date: '2025-08-09', time: '09:00:00', available: true },
      { date: '2025-08-09', time: '11:00:00', available: true },
      { date: '2025-08-10', time: '10:00:00', available: true }
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
    if (!this.appointmentData.fecha) return [];
    return this.availableSlots.filter(slot =>
      slot.date === this.appointmentData.fecha && slot.available
    );
  }

  handleScheduleAppointment(event: Event): void {
    event.preventDefault();

    // Validaciones
    if (!this.selectedService) {
      alert("Debes seleccionar un servicio.");
      return;
    }
    if (!this.appointmentData.fecha || !this.appointmentData.hora) {
      alert("Debes seleccionar una fecha y hora.");
      return;
    }
    if (!this.selectedPetId) {
      alert("Debes seleccionar una mascota.");
      return;
    }
    if (!this.selectedVeterinarioId) {
      alert("Debes seleccionar un veterinario.");
      return;
    }

    const parsedPetId = Number(this.selectedPetId);
    const parsedVetId = Number(this.selectedVeterinarioId);
    if (isNaN(parsedPetId) || isNaN(parsedVetId)) {
      alert("Mascota o veterinario seleccionados no son válidos.");
      return;
    }

    // Armar datos de cita
    this.appointmentData.idMascota = parsedPetId;
    this.appointmentData.idVeterinario = parsedVetId;

    console.log('Datos de la cita a enviar:', this.appointmentData);

    // Llamar al servicio para crear cita
    this.clientService.createAppointment(this.appointmentData).subscribe({
      next: (response) => {
        console.log('Cita creada correctamente', response);
        this.success = '¡Cita creada con éxito!';
        this.error = '';
        this.resetForm();
      },
      error: (error) => {
        console.error('Error creando cita:', error);
        this.error = 'No se pudo crear la cita. Intenta de nuevo.';
        this.success = '';
      }
    });
  }

  resetForm(): void {
    const idCliente = this.getClientIdFromToken();
    this.appointmentData = {
      fecha: '',
      hora: '',
      idCliente,
      idMascota: 0,
      idVeterinario: 0,
      idEstado: 1,
      idServicios: []
    };
    this.selectedPetId = '';
    this.selectedVeterinarioId = '';
    this.selectedService = null;
    this.availableSlots = [];
  }

  getClientIdFromToken(): number {
    const token = localStorage.getItem('token');
    if (!token) return 0;

    try {
      const payload = JSON.parse(atob(token.split('.')[1]));
      return parseInt(payload.sub);
    } catch (error) {
      console.error('Error decodificando token:', error);
      return 0;
    }
  }

  sendReminder(): void {
    console.log('Enviando recordatorio... (pendiente)');
  }

  formatDate(dateString: string): string {
    const date = new Date(dateString);
    return date.toLocaleDateString('es-ES', {
      day: 'numeric',
      month: 'long',
      year: 'numeric'
    });
  }

  validateForm(): boolean {
    if (!this.selectedService) {
      this.error = 'Debes seleccionar un servicio.';
      return false;
    }

    if (!this.appointmentData.fecha || !this.appointmentData.hora) {
      this.error = 'Debes seleccionar una fecha y hora.';
      return false;
    }

    if (!this.selectedPetId) {
      this.error = 'Debes seleccionar una mascota.';
      return false;
    }

    if (!this.selectedVeterinarioId) {
      this.error = 'Debes seleccionar un veterinario.';
      return false;
    }

    const parsedPetId = Number(this.selectedPetId);
    const parsedVetId = Number(this.selectedVeterinarioId);

    if (isNaN(parsedPetId) || isNaN(parsedVetId)) {
      this.error = 'Mascota o veterinario seleccionados no son válidos.';
      return false;
    }

    // Si todo está bien, asignamos
    this.appointmentData.idMascota = parsedPetId;
    this.appointmentData.idVeterinario = parsedVetId;

    return true;
  }


  confirmAppointment(event: Event): void {
    event.preventDefault();

    // Validar formulario antes de crear la cita
    if (!this.validateForm()) {
      alert(this.error);
      return;
    }

    this.loading = true;
    this.error = '';
    this.success = '';

    this.clientService.createAppointment(this.appointmentData).subscribe({
      next: (response) => {
        this.loading = false;
        this.success = 'Cita creada exitosamente.';
        console.log('Cita creada:', response);
        this.resetForm();
      },
      error: (err) => {
        this.loading = false;
        this.error = 'Error al crear la cita.';
        console.error('Error al crear cita:', err);
      }
    });
  }

}

