import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TodoDataService } from '../services/data/todo-data.service';
import { Todo } from '../todo';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  id: number = 0;
  todo: Todo;

  constructor(private todoService: TodoDataService, private activatedRoute: ActivatedRoute, private router: Router) {
    this.todo = new Todo(-1, "", false, new Date());
  }

  ngOnInit(): void {
    this.id = this.activatedRoute.snapshot.params['id'];
    this.todoService.retrieveTodo("in28minutes", this.id)
      .subscribe(
        data => this.todo = data
      );
  }

  saveTodo() {
    this.todoService.updateTodo("in28minutes", this.id, this.todo)
      .subscribe(
          data => {
            this.todo = data;
            this.router.navigate(['/todos']);
          }
      );
  }

}
