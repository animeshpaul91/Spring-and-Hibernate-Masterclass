// Use services when a common logic needs to be shared between multiple components

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {map} from 'rxjs/operators';

@Injectable({ // This can be injected to any Component class. Makes this component available for Dependency Injection
  providedIn: 'root' // Available at Root Level
})

export class BasicAuthenticationService {

  constructor(private httpClient: HttpClient) { }

  authenticate(username: string, password: string) {
    // console.log("Before: " + this.isUserLoggedIn());

    if (username === "in28Minutes" && password === "dummy") {
      sessionStorage.setItem('authenticatedUser', username);
      // console.log("After: " + this.isUserLoggedIn());
      return true;
    }

    else return false;
  }

  isUserLoggedIn(): boolean {
    let user = sessionStorage.getItem('authenticatedUser');
    return user != null;
  }

  logout(): void {
    sessionStorage.removeItem('authenticatedUser');
  }

  executeAuthenticationService(username: string, password: string): Observable<AuthenticationBean> {
    let basicAuthHeader: string = "Basic " + window.btoa(username + ":" + password);

    let header = new HttpHeaders({
      Authorization: basicAuthHeader
    })

    const URL = `http://localhost:8080/basicauth`;
    return this.httpClient.get<AuthenticationBean>(URL, {headers: header}).pipe( // pipe allows to declare what should be done if the request succeeds or fails 
      map((data: AuthenticationBean) => {
        sessionStorage.setItem('authenticatedUser', username);
        return data;
      })
    );
  }
}


export class AuthenticationBean {
  constructor(public message: string) {

  }
}