import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-login-button',
  imports: [RouterLink],
  templateUrl: './login-button.html',
  styleUrl: './login-button.css'
})
export class LoginButtonComponent {
mostrarOpciones: boolean = false;
  toggleOpciones(): void {
    this.mostrarOpciones = !this.mostrarOpciones;
  }
}
