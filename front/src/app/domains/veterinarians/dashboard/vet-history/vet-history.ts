import { ChangeDetectionStrategy, Component, inject, OnInit, signal } from '@angular/core';
import { VetApi } from '../../services/vet-api';

interface ServiciosDTO {
  id: number;
  nombre: string;
  descripcion: string;
  precio: number;
}

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

@Component({
  selector: 'app-vet-history',
  templateUrl: './vet-history.html',
  styleUrl: './vet-history.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
  host: {
    'class': 'vet-history-host',
  }
})
export class VetHistory implements OnInit {
  private readonly vetApi = inject(VetApi);

  protected readonly history = signal<Appointment[]>([]);
  protected readonly loading = signal(true);
  protected readonly error = signal<string | null>(null);

  ngOnInit(): void {
    this.loading.set(true);
    this.error.set(null);

    this.vetApi.getCompletedAppointments().subscribe({
      next: (data: Appointment[]) => {
        this.history.set(data);
        this.loading.set(false);
      },
      error: (err) => {
        this.error.set('Error fetching history');
        this.loading.set(false);
      }
    });
  }
}