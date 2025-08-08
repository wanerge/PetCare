import { RouterModule, Routes } from '@angular/router';
import { LoginCliente } from './core/login/login-cliente/login-cliente';
import { LoginVeterinario } from './core/login/login-veterinario/login-veterinario';
import { Home } from './layout/home/home';
import { Main } from './domains/veterinarians/dashboard/main/main';
import { ClientMain } from './domains/clients/dashboard/client-main/client-main';



export const routes: Routes = [
  { path: '', component: Home },            
  { path: 'login-cliente', component: LoginCliente },     
  { path: 'login-veterinario', component: LoginVeterinario },
  { path: 'client-main', component: ClientMain },
  {path: 'vet-dashboard', component: Main }
];


