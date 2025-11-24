import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { ParentComponent } from './components/parent-component/parent-component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ParentComponent], //If you ever want to use a component in a component, you must import it.
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('MyAngular');
}
