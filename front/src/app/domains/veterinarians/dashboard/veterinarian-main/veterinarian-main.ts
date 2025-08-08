import { ChangeDetectionStrategy, Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { VetNavbar } from '../vet-navbar/vet-navbar';

@Component({
  selector: 'app-veterinarian-main',
  standalone: true,
  imports: [VetNavbar, RouterOutlet],
  templateUrl: './veterinarian-main.html',
  styleUrl: './veterinarian-main.css',
  changeDetection: ChangeDetectionStrategy.OnPush,
  host: {
    'class': 'veterinarian-main-host'
  }
})
export class VeterinarianMain {

}
