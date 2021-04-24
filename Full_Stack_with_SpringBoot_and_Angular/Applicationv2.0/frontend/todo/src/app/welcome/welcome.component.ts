import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WelcomeDataService } from '../services/data/welcome-data.service';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  message: string = "Some welcome message";
  name: string = "";

  // Activated Route
  constructor(private route: ActivatedRoute, private service: WelcomeDataService) { }

  // Modern Javascript does not have the concept of interfaces. Every Typescript Component Class implements OnInit to implement the ngOnInit() method

  ngOnInit(): void {
    // This method runs when this component initializes
    // console.log(this.message);
    this.name = this.route.snapshot.params["name"];
  }

  getWelcomeMessage() {
    this.service.executeHelloWorldBeanService().subscribe();
  }

}
