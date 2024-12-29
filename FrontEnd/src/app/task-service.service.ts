import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Task } from './interfaces/task.interface';

@Injectable({
  providedIn: 'root'
})
export class TaskServiceService {
  private apiUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

  getTasks(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/tasks`);
  }

  getTask(taskId: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/task?taskId=${taskId}`);
  }

  addTask(task: Task | any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/task`, task);
  }

  deleteTask(taskId: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/task?taskId=${taskId}`);
  }

  patchTask(taskId: number, task: Task): Observable<any> {
    return this.http.patch<any>(`${this.apiUrl}/task?taskId=${taskId}`, task);
  }

}