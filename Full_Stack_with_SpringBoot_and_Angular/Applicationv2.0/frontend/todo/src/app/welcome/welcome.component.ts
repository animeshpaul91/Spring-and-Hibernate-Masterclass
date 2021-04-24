import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HelloWorldBean, WelcomeDataService } from '../services/data/welcome-data.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  message: string = "Some welcome message";
  name: string = "";
  welcomeMessageFromService: string = "";

  // Activated Route
  constructor(private route: ActivatedRoute, private service: WelcomeDataService) { }

  // Modern Javascript does not have the concept of interfaces. Every Typescript Component Class implements OnInit to implement the ngOnInit() method

  ngOnInit(): void {
    // This method runs when this component initializes
    // console.log(this.message);
    this.name = this.route.snapshot.params["name"];
  }

  getWelcomeMessage() {
    this.service.executeHelloWorldBeanService().subscribe( //asynchronous functions always take a callback function as a parameter
        response => this.handleSuccessfullResponse(response), // do this when data returns. Do this when a succesful response returns back
        error => this.handleErrorResponse(error)
    );

    console.log("Last line of get Welcome Message"); // This might get called before beecause executeHelloWorldBeanService() is asynchronous
  }

  handleErrorResponse(error: any): void {
    this.welcomeMessageFromService = error.error.message;
  }

  handleSuccessfullResponse(response: HelloWorldBean) {
    this.welcomeMessageFromService = response.message;
  }

}
