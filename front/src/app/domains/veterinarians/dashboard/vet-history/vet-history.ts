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
  selector: 'app-vet-history',
  standalone: true,
  imports: [DatePipe],
  templateUrl: './vet-history.html',
  styleUrl: './vet-history.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
  host: {
    'class': 'vet-history-host',
  }
})
export class VetHistory implements OnInit {
  private VetApi = inject(VetApi);
  protected history = signal<Appointment[]>([]);

  ngOnInit(): void {
    this.VetApi.getCompletedAppointments().subscribe(
      (data: Appointment[]) => {
        this.history.set(data);
      },
      (error) => {
        console.error('Error fetching history:', error);
      }
    );
  }
}