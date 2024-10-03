import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environments/environment';
import { TodoModel } from '../Model/todo_model';

@Injectable({
  providedIn: 'root'
})
export class TodoserviceService {

  endpoint = "todo";

  url = environment.API_URL + this.endpoint;



  constructor(private http: HttpClient) { }

  addTodo(date: TodoModel) {
    return this.http.post(this.url, date);
  }

  getTodo() {
    return this.http.get(this.url);
  }

  editTodo(data: TodoModel) {
    return this.http.put(this.url, data);
  }

  deleteTodo(id: number) {
    return this.http.delete(this.url + '?id=' + id);
  }

}
