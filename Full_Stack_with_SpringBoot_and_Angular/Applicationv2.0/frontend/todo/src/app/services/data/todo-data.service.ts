import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Todo } from 'src/app/todo';

@Injectable({
  providedIn: 'root'
})
export class TodoDataService {

  constructor(private httpClient: HttpClient) { }

  retrieveAllTodos(username: string) {
    return this.httpClient.get<Todo[]>(`http://localhost:8080/users/${username}/todos`);
  }

  deleteTodo(username: string, id: number) {
    return this.httpClient.delete(`http://localhost:8080/users/${username}/todos/${id}`);
  }

  retrieveTodo(username: string, id: number) {
    return this.httpClient.get<Todo>(`http://localhost:8080/users/${username}/todos/${id}`);
  }

  updateTodo(username: string, id: number, todo: Todo) {
    return this.httpClient.put<Todo>(
      `http://localhost:8080/users/${username}/todos/${id}`,
      todo);
  }

  createTodo(username: string, todo: Todo) {
    return this.httpClient.post(`http://localhost:8080/users/${username}/todos`, todo);
  }

}
