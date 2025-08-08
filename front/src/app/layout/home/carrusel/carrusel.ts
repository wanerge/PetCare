import { Servicios } from './../models/servicios';
import { Component, inject, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeApi } from '../services/Home-api';

/*
interface Carrusel {
  titulo: string;
  descripcion: string;
  precio: string;
  icono: string;
} 
*/

@Component({
  selector: 'app-carrusel',
  imports: [CommonModule],
  templateUrl: './carrusel.html',
  styleUrl: './carrusel.css'
})
export class CarruselComponent {

  private servicioService = inject(HomeApi);

  servicio : Servicios[] = [];

  ngOnInit(): void {
    this.loadServicios();
  }

  private loadServicios(): void {
    this.servicioService.getAllServicios().subscribe(servicios => {
      this.servicio = servicios;
      console.log(this.servicio);
      console.log(this.servicioService);
    });
  }


  /*
    servicios: Carrusel[] = [
    {
      titulo: 'Hospitalización',
      descripcion: 'Cuidado y monitoreo intensivo 24/7 para mascotas enfermas',
      precio: '$150.000 - $300.000',
      icono: 'bed'
    },
    {
      titulo: 'Consulta General',
      descripcion: 'Examen completo y chequeo de rutina.',
      precio: '$50.000 - $100.000',
      icono: 'stethoscope'
    },
    {
      titulo: 'Cirugía Mayor y Menor',
      descripcion: 'Procedimientos quirúrgicos especializados',
      precio: '$400.000 - $1.000.000',
      icono: 'medical_services'
    },
    {
      titulo: 'Vacunación',
      descripcion: 'Protege a tu mascota contra enfermedades comunes',
      precio: '$30.000 - $60.000',
      icono: 'vaccines'
    },
    {
      titulo: 'Desparasitación',
      descripcion: 'Protege a tu mascota contra enfermedades comunes',
      precio: '$25.000',
      icono: 'vaccines'
    },
    {
      titulo: 'Exámenes de Laboratorio',
      descripcion: 'Diagnóstico preciso a través de análisis clínicos',
      precio: '$80.000',
      icono: 'medical'
    },
    {
      titulo: 'Urgencias Médicas',
      descripcion: 'Atención inmediata para casos críticos. Horario de Atención: 24/7',
      precio: '',
      icono: 'medical'
    },
    {
      titulo: 'Ecografía y Tomografía',
      descripcion: 'Diagnóstico por imagen no invasivo para evaluar órganos internos y detectar anomalías.',
      precio: '$70.000',
      icono: ''
    }
  ]; 

  */
  indiceActual = 0;

  irAnterior() {
    if (this.indiceActual > 0) {
      this.indiceActual--;
    }
  }

  irSiguiente() {
    if (this.indiceActual < this.servicio.length - 1) {
      this.indiceActual++;
    }
  }
  
}
