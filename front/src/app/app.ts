import { Component} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Header } from './layout/header/header';
import { Footer } from './layout/footer/footer';
import { Home } from './home/home';
import { LoginCliente } from './core/login/login-cliente/login-cliente';
import { LoginVeterinario } from "./core/login/login-veterinario/login-veterinario";

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Footer, Header, Home, LoginCliente, LoginVeterinario],
  templateUrl: './app.html',
  styleUrls: ['./app.css'],
})
export class App {}
