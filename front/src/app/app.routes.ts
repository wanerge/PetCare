import { RouterModule, Routes } from '@angular/router';
import { LoginCliente } from './core/login/login-cliente/login-cliente';
import { LoginVeterinario } from './core/login/login-veterinario/login-veterinario';
import { Home } from './layout/home/home';
import { ClientDashboard } from './domains/clients/dashboard/client-dashboard/client-dashboard';
import { Main } from './domains/veterinarians/dashboard/main/main';



export const routes: Routes = [
  { path: '', component: Home },            
  { path: 'login-cliente', component: LoginCliente },     
  { path: 'login-veterinario', component: LoginVeterinario },
  { path: 'client-dashboard', component: ClientDashboard },
  {path: 'vet-dashboard', component: Main },
  {path: '*', redirectTo: '' } // Redirige cualquier ruta desconocida a Home
];


