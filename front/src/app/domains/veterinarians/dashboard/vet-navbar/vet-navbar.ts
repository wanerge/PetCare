import { ChangeDetectionStrategy, Component } from '@angular/core';
import { RouterLink, RouterLinkActive } from '@angular/router';

@Component({
  selector: 'app-vet-navbar',
  standalone: true,
  imports: [RouterLink, RouterLinkActive],
  templateUrl: './vet-navbar.html',
  styleUrl: './vet-navbar.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
  host: {
    'class': 'vet-navbar-host',
  }
})
export class VetNavbar {

}
