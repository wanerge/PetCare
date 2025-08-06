import { Component } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { filter } from 'rxjs/operators';

@Component({
  selector: 'app-header',
  templateUrl: './header.html',
  styleUrls: ['./header.css']
})
export class Header {
  esInicio = false;

  constructor(private router: Router) {
    // Detectar la ruta actual
    this.router.events
      .pipe(filter(event => event instanceof NavigationEnd))
      .subscribe((event: NavigationEnd) => {
        this.esInicio = event.urlAfterRedirects === '/';
      });
  }

  irAlLogin() {
    this.router.navigate(['/login']);
  }

  iniciarSesion() {
    console.log('Iniciar sesión');
  }

}
