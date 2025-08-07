import { RouterModule, Routes } from '@angular/router';
import { LoginCliente } from './core/login/login-cliente/login-cliente';
import { LoginVeterinario } from './core/login/login-veterinario/login-veterinario';


export const routes: Routes = [
  { path: 'login-cliente', component: LoginCliente },     
  { path: 'login-veterinario', component: LoginVeterinario }
];

