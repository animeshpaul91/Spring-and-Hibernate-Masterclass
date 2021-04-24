// Use services when a common logic needs to be shared between multiple components

import { Injectable } from '@angular/core';

@Injectable({ // This can be injected to any Component class. Makes this component available for Dependency Injection
  providedIn: 'root'
})

export class HardcodedAuthenticationService {

  constructor() { }

  authenticate(username: string, password: string) {
    if (username === "in28Minutes" && password === "dummy") return true;
    else return false;
  }
}
