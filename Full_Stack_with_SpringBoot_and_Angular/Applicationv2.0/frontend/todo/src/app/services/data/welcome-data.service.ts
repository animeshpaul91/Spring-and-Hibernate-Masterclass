import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';


export class HelloWorldBean {
  constructor(public message: string) {

  }
}


@Injectable({
  providedIn: 'root'
})
export class WelcomeDataService {

  constructor(private httpClient: HttpClient) { }

  createBasicAuthHttpHeader(): string {
    let username: string = "in28minutes";
    let password: string = "dummy";
    let basicAuth: string = "Basic " + window.btoa(username + ":" + password);
    return basicAuth;
  }

  executeHelloWorldBeanService() {
    return this.httpClient.get<HelloWorldBean>("http://localhost:8080/hello-world-bean");
  }

  executeHelloWorldServiceWithPathVariable(name: string) {    
    let basicAuthHeaderString: string = this.createBasicAuthHttpHeader();
    let header = new HttpHeaders({
      Authorization: basicAuthHeaderString
    });

    const URL = `http://localhost:8080/hello-world/path-variable/${name}`;
    return this.httpClient.get<HelloWorldBean>(URL, {headers: header});
  }
}
