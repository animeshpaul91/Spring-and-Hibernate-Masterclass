import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = 'in28Minutes';
  password = '';
  errorMessage = 'Invalid Credentials';
  invalidLogin = false;

  constructor() { }

  ngOnInit(): void {
  }

  handleLogin(): void {
    // console.log(this.username);
    if (this.username === "in28Minutes" && this.password === "dummy") {
      this.invalidLogin = false;
    }

    else {
      this.invalidLogin = true;
    }
  }
}
