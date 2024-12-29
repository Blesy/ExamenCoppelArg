import { Component } from '@angular/core';
import { TaskServiceService } from '../../task-service.service';
import { Task } from '../../interfaces/task.interface';

@Component({
  selector: 'app-task-list',
  standalone: false,
  
  templateUrl: './task-list.component.html',
  styleUrl: './task-list.component.css'
})
export class TaskListComponent {
  tasks: Task[] | any[] = [];
  newTaskTitle: string = '';
  inputVacio: boolean = false;

  constructor(private taskService: TaskServiceService) {}

  ngOnInit() {
    this.loadTasks();
  }

  loadTasks() {
    this.taskService.getTasks().subscribe(
      (data) => {
        this.tasks = data;
      },
      (error) => {
        console.error('Error fetching tasks', error);
      }
    );
  }

  addTask() {
    if (!this.newTaskTitle) {
      this.inputVacio = true;
      return;
    }
    this.inputVacio = false;
    const task = {
      categoria: 'General',
      tarea: this.newTaskTitle,
      completado: false
    }
    this.taskService.addTask(task).subscribe(
      (data) => {
        this.tasks.push(data);
        this.newTaskTitle = '';
      },
      (error) => {
        console.error('Error adding task', error);
      }
    );
  }

  deleteTask(taskId: number) {
    this.tasks = this.tasks.filter(task => task.id !== taskId);
  }

}
 