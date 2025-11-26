import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import {Auth} from '../../services/auth';

@Component({
  selector: 'app-login',
  imports: [FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})

export class Login {
  
  
  constructor(private router:Router, private authService:Auth){}
  username:string = ""
  password:string = ""


  login(){
    if (this.username === "username" && this.password === "password"){
      this.authService.authenticateUser();
      this.router.navigateByUrl("/dashboard")
    }
    else{
      alert("Invalid username or password")
    }}

  pikachu(){
     alert("Pika.................chu")
  }
}

/*
HTTP Post request:
  //if 200 success then 400 failure
  //return this.http.post("URL_TO_API", {username, password})

  //post(): method body (the login credentials)
  //third parameter I didn't show, config object
  // hdeader, content-type, Authentication tokens
}
*/




