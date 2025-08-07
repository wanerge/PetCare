import { Component } from '@angular/core';
import { Header } from '../../../../layout/header/header';
import { Footer } from '../../../../layout/footer/footer';


@Component({
  selector: 'app-main',
  imports: [Header, Footer],
  templateUrl: './main.html',
  styleUrl: './main.css'
})
export class Main {

}
