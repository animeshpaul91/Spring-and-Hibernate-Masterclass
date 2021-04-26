// Use services when a common logic needs to be shared between multiple components

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({ // This can be injected to any Component class. Makes this component available for Dependency Injection
  providedIn: 'root' // Available at Root Level
})

export class BasicAuthenticationService {

  constructor(private httpClient: HttpClient) { }

  isUserLoggedIn(): boolean {
    let user = sessionStorage.getItem('authenticatedUser');
    return user != null;
  }

  logout(): void {
    sessionStorage.removeItem('authenticatedUser');
    sessionStorage.removeItem('token');
  }

  executeAuthenticationService(username: string, password: string): Observable<AuthenticationBean> {
    let basicAuthHeaderString: string = "Basic " + window.btoa(username + ":" + password);

    let header = new HttpHeaders({
      Authorization: basicAuthHeaderString
    })

    const URL = `http://localhost:8080/basicauth`;
    return this.httpClient.get<AuthenticationBean>(URL, { headers: header }).pipe( // pipe allows to declare what should be done if the request succeeds or fails 
      map((data: AuthenticationBean) => {
        sessionStorage.setItem('authenticatedUser', username);
        sessionStorage.setItem('token', basicAuthHeaderString);
        return data;
      })
    );
  }

  getAuthenticatedUser() {
    return sessionStorage.getItem('authenticatedUser');
  }

  getAuthenticatedToken() {
    return sessionStorage.getItem('token');
  }

}


export class AuthenticationBean {
  constructor(public message: string) {

  }
}