import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { LoginServices } from '../../../domains/jobs/services/login-services';

@Component({
  selector: 'app-login-cliente',
  imports: [FormsModule],
  templateUrl: './login-cliente.html',
  styleUrl: './login-cliente.css'
})
export class LoginCliente {
  activeTab: 'login' | 'register' = 'login';

  loginEmail: string = '';
  loginPassword: string = '';
  isLoading: boolean = false; 
  errorMessage: string = ''; 

  constructor(
    private router: Router,
    private loginServices: LoginServices  
  ) {}

  handleLogin() {
    this.errorMessage = '';

    if (!this.loginEmail || !this.loginPassword) {
      this.errorMessage = 'Completa los campos de inicio de sesión.';
      return;
    }

    if (!this.isValidEmail(this.loginEmail)) {
      this.errorMessage = 'Ingresa un correo electrónico válido.';
      return;
    }

    const loginData = {
      correo: this.loginEmail,
      clave: this.loginPassword
    };

    this.isLoading = true;

    this.loginServices.login(loginData).subscribe({
      next: (response) => {
      console.log('Login exitoso:', response);
    
      localStorage.setItem('token', response); 
      this.isLoading = false;
      this.router.navigate(['MainClient']);

      },
      error: (error) => {
        console.error('Error en login:', error);
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