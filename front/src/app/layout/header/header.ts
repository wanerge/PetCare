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
  currentRoute: string = '';

  constructor(private router: Router) {}

  ngOnInit(): void {
    this.router.events
      .pipe(
        // Filtramos para quedarnos solo con NavigationEnd
        filter((event: Event): event is NavigationEnd => event instanceof NavigationEnd)
      )
      .subscribe(event => {
        this.currentRoute = event.urlAfterRedirects;
      });
  }

  isLoginRoute(): boolean {
    return this.currentRoute.includes('login-cliente') ||
           this.currentRoute.includes('login-veterinario') ||
           this.currentRoute.includes('client-dashboard') ||
           this.currentRoute.includes('vet-dashboard')

          
  }

  isDashboardRoute(): boolean {
    return this.currentRoute.includes('client-dashboard') ||
           this.currentRoute.includes('vet-dashboard');
  }

  logout(): void {
    console.log('Sesión cerrada');
    this.router.navigate(['']);
  }

}
