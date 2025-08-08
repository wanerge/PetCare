import { RouterModule, Routes } from '@angular/router';
import { LoginCliente } from './core/login/login-cliente/login-cliente';
import { LoginVeterinario } from './core/login/login-veterinario/login-veterinario';
import { ClientMain } from './domains/clients/dashboard/client-main/client-main';
import { VeterinarianMain } from './domains/veterinarians/dashboard/veterinarian-main/veterinarian-main';
import { VetAppointments } from './domains/veterinarians/dashboard/vet-appointments/vet-appointments';
import { VetHistory } from './domains/veterinarians/dashboard/vet-history/vet-history';
import { Home } from './layout/home/pages/home';



export const routes: Routes = [
  { path: '', component: Home },
  { path: 'login-cliente', component: LoginCliente },
  { path: 'login-veterinario', component: LoginVeterinario },
  { path: 'client-main', component: ClientMain },
  {
    path: 'veterinarian-main',
    component: VeterinarianMain,
    children: [
      { path: '', redirectTo: 'appointments', pathMatch: 'full' }, // Redirige a citas por defecto
      { path: 'appointments', component: VetAppointments },
      { path: 'history', component: VetHistory },
    ]
  },

  { path: '*', redirectTo: '' } // Redirige cualquier ruta desconocida a Home
];


