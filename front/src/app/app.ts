import { Component} from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { Header } from './layout/header/header';
import { Footer } from './layout/footer/footer';
import { Home } from './home/home';


@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Footer, Header, Home],
  templateUrl: './app.html',
  styleUrls: ['./app.css'],
})
export class App {}
