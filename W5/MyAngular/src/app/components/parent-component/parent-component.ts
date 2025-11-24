import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ChildComponent } from '../child-component/child-component';
@Component({
  selector: 'app-parent-component',
  //common module: *ngFor and *ngIf
  imports: [CommonModule, FormsModule, ChildComponent], 
  templateUrl: './parent-component.html',
  styleUrl: './parent-component.css',
})

//make class not local
export class ParentComponent {

  // The .ts file of an angular component defines the data/behaviors of the component.

  // Defining an array that we will use to render multiple child components.
  arr:number[] = [1, 2, 3, 4, 5]

  // This function will be called via event binding in parent html
  showSurprise() {
    alert("Surprise!!!!");
    // member of class = this. only one hideElement exists though
    this.hideElement = !this.hideElement
  }

  // This variable will show or hide the H1 in our parent html
  hideElement:boolean = true


  // This variable will hold the user's inputted name.
  nameInput:string = ""

}

