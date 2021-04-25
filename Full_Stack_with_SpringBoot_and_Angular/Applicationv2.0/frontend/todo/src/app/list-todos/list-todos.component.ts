import { Component, OnInit } from '@angular/core';
import { TodoDataService } from '../services/data/todo-data.service';
import { Todo } from '../todo';

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {

  todos: Todo[] = [];
  // [
  //   new Todo(1, 'Learn to Dance', false, new Date()),
  //   new Todo(2, 'Become an expert at Angular 8', false, new Date()),
  //   new Todo(3, 'Visit the USA', true, new Date())
  // ];

  constructor(private todoService: TodoDataService) { }

  ngOnInit(): void {
    this.todoService.retrieveAllTodos("in28minutes").subscribe(
      response => {
        console.log(response);
        this.todos = response;
      }
    );
  }

}
