import { Component, OnInit } from '@angular/core';
import { SalesPerson } from './sales-person';

@Component({
  selector: 'app-sales-person-list',
  templateUrl: './sales-person-list-bootstrap.component.html',
  styleUrls: ['./sales-person-list.component.css']
})
export class SalesPersonListComponent implements OnInit {

  // create an array of objects
  salesPersonList: SalesPerson[] = [
    new SalesPerson("Animesh", "Paul", "ani.nitmz@gmail.com", "70000"),
    new SalesPerson("John", "Doe", "jdoe@gmail.com", "65000"),
    new SalesPerson("Claire", "Murphy", "cmurphy@gmail.com", "30000"),
    new SalesPerson("Mai", "Trung", "mtrung@gmail.com", "60000")
  ];
  constructor() { }

  ngOnInit(): void {
  }

}
