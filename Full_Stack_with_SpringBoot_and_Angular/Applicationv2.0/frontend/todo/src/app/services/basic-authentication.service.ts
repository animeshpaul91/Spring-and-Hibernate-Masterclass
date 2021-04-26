// Use services when a common logic needs to be shared between multiple components

import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { API_URL } from '../app.constants';


// use string literals for storage keys
export const TOKEN: string = "token";
export const AUTHENTICATED_USER: string = "authenticatedUser";

@Injectable({ // This can be injected to any Component class. Makes this component available for Dependency Injection
  providedIn: 'root' // Available at Root Level
})


export class BasicAuthenticationService {

  constructor(private httpClient: HttpClient) { }

  isUserLoggedIn(): boolean {
    let user = sessionStorage.getItem(AUTHENTICATED_USER);
    return user != null;
  }

  logout(): void {
    sessionStorage.removeItem(AUTHENTICATED_USER);
    sessionStorage.removeItem(TOKEN);
  }

  executeAuthenticationService(username: string, password: string): Observable<AuthenticationBean> {
    let basicAuthHeaderString: string = "Basic " + window.btoa(username + ":" + password);

    let header = new HttpHeaders({
      Authorization: basicAuthHeaderString
    })

    const URL = `${API_URL}/basicauth`;
    return this.httpClient.get<AuthenticationBean>(URL, { headers: header }).pipe( // pipe allows to declare what should be done if the request succeeds or fails 
      map((data: AuthenticationBean) => {
        sessionStorage.setItem(AUTHENTICATED_USER, username);
        sessionStorage.setItem(TOKEN, basicAuthHeaderString);
        return data;
      })
    );
  }

  executeJWTAuthenticationService(username: string, password: string): Observable<AuthenticationBean> {
    const URL = `${API_URL}/authenticate`;

    return this.httpClient.post<any>(URL, {username, password}).pipe( // Javascript shortcut to create object with same key name and the value that the variable stores
      map(data => {      
        sessionStorage.setItem(AUTHENTICATED_USER, username);
        sessionStorage.setItem(TOKEN, `Bearer ${data.token}`);
        console.log(`Bearer ${data.token}`);
        return data;
      })
    );
  }

  getAuthenticatedUser() {
    return sessionStorage.getItem(AUTHENTICATED_USER);
  }

  getAuthenticatedToken() {
    return sessionStorage.getItem(TOKEN);
  }

}


export class AuthenticationBean {
  constructor(public message: string) {

  }
}