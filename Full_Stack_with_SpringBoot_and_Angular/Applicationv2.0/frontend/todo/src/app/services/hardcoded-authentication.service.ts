// Use services when a common logic needs to be shared between multiple components

import { Injectable } from '@angular/core';

@Injectable({ // This can be injected to any Component class. Makes this component available for Dependency Injection
  providedIn: 'root' // Available at Root Level
})

export class HardcodedAuthenticationService {

  constructor() { }

  authenticate(username: string, password: string) {
    console.log("Before: " + this.isUserLoggedIn());

    if (username === "in28Minutes" && password === "dummy") {
      sessionStorage.setItem('authenticatedUser', username);
      console.log("After: " + this.isUserLoggedIn());
      return true;
    }

    else return false;
  }

  isUserLoggedIn(): boolean {
      let user = sessionStorage.getItem('authenticatedUser');
      return user != null;
  }
}
