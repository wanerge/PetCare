import { Component } from '@angular/core';
import { Router, NavigationEnd, Event } from '@angular/router';
import { filter } from 'rxjs/operators';
import { LoginButtonComponent } from '../../login-button/login-button';


@Component({
  selector: 'app-header',
  templateUrl: './header.html',
  styleUrls: ['./header.css'],
  imports: [LoginButtonComponent]
})
export class Header {

   constructor(public router: Router) {}

  logout() {
    // Aquí limpias sesión, token, etc.
    console.log('Sesión cerrada');
    this.router.navigate(['/']);
  }
}
