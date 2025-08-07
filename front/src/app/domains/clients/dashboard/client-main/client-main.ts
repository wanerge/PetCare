import { Component } from '@angular/core';
import { ClientDashboard } from '../client-dashboard/client-dashboard';
import { ClientDashboardFooter } from '../client-dashboard-footer/client-dashboard-footer';
import { ClientDashboardHeader } from '../client-dashboard-header/client-dashboard-header';

@Component({
  selector: 'app-client-main',
  imports: [ClientDashboard, ClientDashboardFooter, ClientDashboardHeader],
  templateUrl: './client-main.html',
  styleUrl: './client-main.css'
})
export class ClientMain {

}
