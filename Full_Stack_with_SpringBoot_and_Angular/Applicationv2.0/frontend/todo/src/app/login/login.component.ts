import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = 'in28Minutes';
  password = '';

  constructor() { }

  ngOnInit(): void {
  }

  handleLogin(): void {
    console.log(this.username);
  }
}
