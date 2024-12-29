import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Task } from '../../interfaces/task.interface';
import { TaskServiceService } from '../../task-service.service';

@Component({
  selector: 'app-task-item',
  standalone: false,
  
  templateUrl: './task-item.component.html'
})
export class TaskItemComponent {
  @Input() task: Task | any;
  @Output() taskDeleted = new EventEmitter<number>();

  ngOnInit() {  }

  constructor(private taskService: TaskServiceService) { }

  markAsCompleted() {
    this.task.completado = !this.task.completado;
    this.taskService.patchTask(this.task.id, this.task).subscribe(
      (data) => {
        console.log('Task marked as completed', data);
      },
      (error) => {
        console.error('Error marking task as completed', error);
      }
    )
  }

  deleteTask() {
    this.taskService.deleteTask(this.task.id).subscribe(
      (data) => {
        console.log('Task deleted', data);
        this.taskDeleted.emit(this.task.id);
      },
      (error) => {
        console.error('Error deleting task', error);
      }
    );
  }
}
