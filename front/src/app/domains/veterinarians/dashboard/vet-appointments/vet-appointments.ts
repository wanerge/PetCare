import { ChangeDetectionStrategy, Component, inject, OnInit, signal } from '@angular/core';
import { VetApi } from '../../services/vet-api';
import { DatePipe } from '@angular/common';

interface Appointment {
  id: number;
  fecha: string; // o Date si la parseas, pero normalmente llega como string ISO
  hora: string;  // normalmente string, ej: "14:30"
  clienteNombre: string;
  mascotaNombre: string;
  veterinarioNombre: string;
  estado: string;
  servicios: ServiciosDTO[];
}

interface ServiciosDTO {
  id: number;
  nombre: string;
  descripcion: string;
  precio: number; // BigDecimal se serializa como number en JSON
}

@Component({
  selector: 'app-vet-appointments',
  templateUrl: './vet-appointments.html',
  styleUrl: './vet-appointments.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
  host: {
    'class': 'vet-appointments-host',
  },
  imports: [DatePipe]
})
export class VetAppointments implements OnInit {
  private readonly vetApi = inject(VetApi);

  protected readonly pendingAppointments = signal<Appointment[]>([]);
  protected readonly completedAppointments = signal<Appointment[]>([]);
  protected readonly loading = signal(true);
  protected readonly error = signal<string | null>(null);

  ngOnInit(): void {
    this.loading.set(true);
    this.error.set(null);

    this.vetApi.getPendingAppointments().subscribe({
      next: (pending: Appointment[]) => {
        this.pendingAppointments.set(pending);
        this.vetApi.getCompletedAppointments().subscribe({
          next: (completed: Appointment[]) => {
            this.completedAppointments.set(completed);
            this.loading.set(false);
          },
          error: (err) => {
            this.error.set('Error fetching completed appointments');
            this.loading.set(false);
          }
        });
      },
      error: (err) => {
        this.error.set('Error fetching pending appointments');
        this.loading.set(false);
      }
    });
  }
}
