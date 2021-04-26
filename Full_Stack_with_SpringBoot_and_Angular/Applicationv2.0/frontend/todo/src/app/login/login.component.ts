import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BasicAuthenticationService } from '../services/basic-authentication.service';
import { HardcodedAuthenticationService } from '../services/hardcoded-authentication.service';

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
  
  // Inject Router as a dependency
  constructor(private router: Router, private hardcodedAuthenticationService: HardcodedAuthenticationService, 
              private basicAuthService: BasicAuthenticationService) { }

  ngOnInit(): void {
  }

  handleLogin(): void {
    // console.log(this.username);
    if (this.hardcodedAuthenticationService.authenticate(this.username, this.password)) {
      this.invalidLogin = false;
      this.router.navigate(["welcome", this.username]);
    }

    else {
      this.invalidLogin = true;
    }
  }

  handleBasicAuthLogin(): void {    
    this.basicAuthService.executeAuthenticationService(this.username, this.password).subscribe(
      data => {
        console.log(data);
        this.router.navigate(["welcome", this.username]);
        this.invalidLogin = false;
      }, 
      
      error => {
        console.log(error);
        this.invalidLogin = true;
      }
    );
  }

  handleJWTAuthLogin(): void {
    this.basicAuthService.executeJWTAuthenticationService(this.username, this.password).subscribe(
      data => {
        console.log(data);
        this.router.navigate(["welcome", this.username]);
        this.invalidLogin = false;
      }, 
      
      error => {        
        console.log(error);
        this.invalidLogin = true;
      }
    );
  }

}
