import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { App } from '../../../app';
import { LoginServices } from '../../../domains/jobs/services/login-services';

@Component({
  selector: 'app-login-veterinario',
  standalone: true, 
  imports: [FormsModule, App],
  templateUrl: './login-veterinario.html',
  styleUrls: ['./login-veterinario.css']
})
export class LoginVeterinario {
  email: string = '';
  password: string = '';
  isLoading: boolean = false;
  errorMessage: string = '';

  constructor(
    private router: Router,
    private loginServices: LoginServices
  ) {}

  handleLogin(event: Event): void {
    event.preventDefault();
    
    // Limpiar mensaje de error previo
    this.errorMessage = '';

    // Validación básica
    if (!this.email || !this.password) {
      this.errorMessage = 'Completa los campos de inicio de sesión.';
      return;
    }

    // Validación de formato de email
    if (!this.isValidEmail(this.email)) {
      this.errorMessage = 'Ingresa un correo electrónico válido.';
      return;
    }

    // Preparar datos para el backend
    const loginData = {
      correo: this.email,
      clave: this.password
    };

    this.isLoading = true;

    // Llamar al servicio
    this.loginServices.login(loginData).subscribe({
      next: (response) => {
        console.log('Login veterinario exitoso:', response);
        this.isLoading = false;
        
        this.router.navigate(['/admin/dashboard']);
      },
      error: (error) => {
        console.error('Error en login veterinario:', error);
        this.isLoading = false;
        
        if (error.status === 401) {
          this.errorMessage = 'Credenciales incorrectas.';
        } else if (error.status === 400) {
          this.errorMessage = 'Datos de login inválidos.';
        } else if (error.status === 0) {
          this.errorMessage = 'No se puede conectar con el servidor.';
        } else {
          this.errorMessage = 'Error al iniciar sesión. Intenta nuevamente.';
        }
      }
    });
  }

  private isValidEmail(email: string): boolean {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
  }
}