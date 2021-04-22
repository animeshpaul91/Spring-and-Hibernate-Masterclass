import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  constructor() { }

  // Modern Javascript does not have the concept of interfaces. Every Typescript Component Class implements OnInit to implement the ngOnInit() method

  ngOnInit(): void {
    // This method runs when this component initializes
  }

}
