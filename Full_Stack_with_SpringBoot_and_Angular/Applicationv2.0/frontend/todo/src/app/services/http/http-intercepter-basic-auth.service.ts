import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HttpIntercepterBasicAuthService implements HttpInterceptor{

  constructor() { }
  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let username: string = "in28minutes";
    let password: string = "dummy";
    let basicAuth: string = "Basic " + window.btoa(username + ":" + password);

    request = request.clone(
      {
        setHeaders: {
          Authorization: basicAuth
        }
      }); // mutating the request with Authorization header

      return next.handle(request);
  }
}
