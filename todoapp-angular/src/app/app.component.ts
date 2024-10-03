import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';
import { TodoserviceService } from './Service/todoservice.service';
import { TodoModel } from './Model/todo_model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, FormsModule, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'todoapp-angular';
  task: string = '';
  tasks: TodoModel[] = [];

  constructor(private service: TodoserviceService) {

    this.getTodo();

  }


  getTodo() {
    this.service.getTodo().subscribe({
      next: (res: any) => {
        console.log(res);
        this.tasks = res;
      }
    })
  }

  addTask() {


    let data: TodoModel = {
      id: Math.random(),
      title: this.task,
      date: new Date(),
      status: false
    }

    this.service.addTodo(data).subscribe({
      next: (res: any) => {

        console.log(res);
        this.getTodo();


      }

    })



  }

  deleteTask(id: number) {
    this.service.deleteTodo(id).subscribe({
      next: (res: any) => {
        console.log(res);
        this.getTodo();
      }
    })

  }

  updateTask(data: TodoModel) {

    let str = prompt('Enter the new task', data.title);
    if (str == null) {
      return;
    }
    data.title = str;


    this.service.editTodo(data).subscribe({
      next: (res: any) => {
        console.log(res);
        this.getTodo();
      }
    })

  }

  taskDone(data: TodoModel) {

    data.status = !data.status;

    this.service.editTodo(data).subscribe({
      next: (res: any) => {
        console.log(res);
        this.getTodo();
      }
    });

  }


}
