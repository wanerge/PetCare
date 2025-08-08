import { ChangeDetectionStrategy, Component, inject, OnInit, signal } from '@angular/core';
import { VetApi } from '../../services/vet-api';
import { DatePipe } from '@angular/common';

interface Appointment {
  id: number;
  clientName: string;
  petName: string;
  date: Date;
  service: string;
}

@Component({
  selector: 'app-vet-appointments',
  standalone: true,
  imports: [DatePipe],
  templateUrl: './vet-appointments.html',
  styleUrl: './vet-appointments.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
  host: {
    'class': 'vet-appointments-host',
  }
})
export class VetAppointments implements OnInit {
  private vetApi = inject(VetApi);
  protected appointments = signal<Appointment[]>([]);

  ngOnInit(): void {
    this.vetApi.getPendingAppointments().subscribe(
      (data: Appointment[]) => {
        this.appointments.set(data);
      },
      (error) => {
        console.error('Error fetching appointments:', error);
      }
    );
  }
}
