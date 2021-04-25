import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TodoDataService } from '../services/data/todo-data.service';
import { Todo } from '../todo';

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {

  todos: Todo[] = [];
  message: string = "";
  // [
  //   new Todo(1, 'Learn to Dance', false, new Date()),
  //   new Todo(2, 'Become an expert at Angular 8', false, new Date()),
  //   new Todo(3, 'Visit the USA', true, new Date())
  // ];

  constructor(private todoService: TodoDataService, private router: Router) { }

  ngOnInit(): void {
    this.refreshTodos();
  }

  private refreshTodos() {
    this.todoService.retrieveAllTodos("in28minutes").subscribe(
      response => {
        console.log(response);
        this.todos = response;
      }
    );
  }

  deleteTodo(id: number) {
    console.log("Delete todo");
    this.todoService.deleteTodo("in28minutes", id).subscribe(
      response => {
          console.log(response);
          this.message = `Delete of Todo with id: ${id} Successful!`;
          this.refreshTodos();
      }
    );
  }

  updateTodo(id: number) {
    console.log("Update todo");
    this.router.navigate(["/todos/update", id]);
  }

  addTodo() {
    this.router.navigate(["/todos/update", -1]); // when id is -1 new todo creation is required. This is used to reuse the same functionality for update
  }

}
