import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterOutlet } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { GoogleAppComponent } from "./google-app/google-app.component";

@Component({
    selector: 'app-root',
    standalone: true,
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css'],
    imports: [CommonModule, RouterOutlet, GoogleAppComponent]
})
export class AppComponent {
  title = 'frontend';

  constructor(private http: HttpClient) {
  }
}
