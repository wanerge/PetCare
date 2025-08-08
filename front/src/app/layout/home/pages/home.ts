import { Component, Injectable, inject } from '@angular/core';
import { CarruselComponent } from '../carrusel/carrusel';



@Component({
  selector: 'app-home',
  imports: [CarruselComponent],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class Home {
  rutaImage = "imagenes/icono.png";

}


