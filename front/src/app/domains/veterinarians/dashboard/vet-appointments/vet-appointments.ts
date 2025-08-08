import { ChangeDetectionStrategy, Component, inject, OnInit, signal } from '@angular/core';
import { VetApi } from '../../services/vet-api';

interface Appointment {
  id: number;
  fecha: string;
  hora: string;
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
  precio: number;
}

@Component({
  selector: 'app-vet-appointments',
  templateUrl: './vet-appointments.html',
  styleUrl: './vet-appointments.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
  host: {
    'class': 'vet-appointments-host',
  }
})
export class VetAppointments implements OnInit {
  private readonly vetApi = inject(VetApi);

  protected readonly pendingAppointments = signal<Appointment[]>([]);
  protected readonly loading = signal(true);
  protected readonly error = signal<string | null>(null);

  ngOnInit(): void {
    this.loading.set(true);
    this.error.set(null);

    this.vetApi.getPendingAppointments().subscribe({
      next: (pending: Appointment[]) => {
        this.pendingAppointments.set(pending);
        this.loading.set(false);
      },
      error: () => {
        this.error.set('Error fetching pending appointments');
        this.loading.set(false);
      }
    });
  }
}
