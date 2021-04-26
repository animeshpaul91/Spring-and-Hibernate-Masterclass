import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { JPA_API_URL } from 'src/app/app.constants';
import { Todo } from 'src/app/todo';

@Injectable({
  providedIn: 'root'
})
export class TodoDataService {

  constructor(private httpClient: HttpClient) { }

  retrieveAllTodos(username: string) {
    return this.httpClient.get<Todo[]>(`${JPA_API_URL}/users/${username}/todos`);
  }

  deleteTodo(username: string, id: number) {
    return this.httpClient.delete(`${JPA_API_URL}/users/${username}/todos/${id}`);
  }

  retrieveTodo(username: string, id: number) {
    return this.httpClient.get<Todo>(`${JPA_API_URL}/users/${username}/todos/${id}`);
  }

  updateTodo(username: string, id: number, todo: Todo) {
    return this.httpClient.put<Todo>(
      `${JPA_API_URL}/users/${username}/todos/${id}`,
      todo);
  }

  createTodo(username: string, todo: Todo) {
    return this.httpClient.post(`${JPA_API_URL}/users/${username}/todos`, todo);
  }

}
