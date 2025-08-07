import { RouterModule, Routes } from '@angular/router';
import { LoginCliente } from './core/login/login-cliente/login-cliente';
import { LoginVeterinario } from './core/login/login-veterinario/login-veterinario';
import { MainClient } from './domains/clients/main-client/main-client';


export const routes: Routes = [
  { path: 'login-cliente', component: LoginCliente },     
  { path: 'login-veterinario', component: LoginVeterinario },
  { path: 'MainClient', component: MainClient}

];

