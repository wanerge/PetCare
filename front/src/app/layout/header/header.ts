import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginButtonComponent } from '../../login-button/login-button';


@Component({
  selector: 'app-header',
  templateUrl: './header.html',
  styleUrls: ['./header.css'],
  imports: [LoginButtonComponent]
})

export class Header {
  constructor(private router: Router) {}

  get isLoginRoute(): boolean {
    const url = this.router.url;
    return url === '/login' || url === '/admin/login';
  }

}
