import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-client-dashboard',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './client-dashboard.html',
  styleUrls: ['./client-dashboard.css']
})

export class ClientDashboard {
  appointmentData = {
    service: '',
    date: '',
    time: '',
    petName: '',
    petType: '',
    ownerName: '',
    email: '',
    phone: ''
  };

  selectedService: any = null;

  services = [
    { name: 'Revisión General', price: 60000, description: 'Chequeo completo de salud' },
    { name: 'Vacunación', price: 45000, description: 'Vacunas según calendario' },
    { name: 'Hemograma', price: 80000, description: 'Análisis completo de sangre' },
    { name: 'Radiografía', price: 120000, description: 'Diagnóstico por imágenes' },
    { name: 'Cirugía Menor', price: 300000, description: 'Procedimientos quirúrgicos menores' }
  ];

  availableSlots = [
    { date: '2024-01-15', time: '10:00 AM', available: true },
    { date: '2024-01-15', time: '11:30 AM', available: false },
    { date: '2024-01-15', time: '2:00 PM', available: true },
    { date: '2024-01-16', time: '9:00 AM', available: true },
    { date: '2024-01-16', time: '10:30 AM', available: true },
    { date: '2024-01-16', time: '3:00 PM', available: false }
  ];

handleServiceSelect(event: Event) {
  const selectElement = event.target as HTMLSelectElement;
  const selectedValue = selectElement?.value; // uso seguro

  // ahora puedes usar selectedValue
  console.log('Servicio seleccionado:', selectedValue);
}

  handleScheduleAppointment(event: Event) {
    event.preventDefault();
    if (!this.selectedService) return;

    const partialPayment = this.selectedService.price * 0.3;
    alert(
      `Cita programada exitosamente!\nAnticipo requerido: $${partialPayment.toLocaleString()}\nSe enviará confirmación a ${this.appointmentData.email}`
    );
  }

  sendReminder() {
    alert(`Recordatorio enviado a ${this.appointmentData.email}`);
  }
}
