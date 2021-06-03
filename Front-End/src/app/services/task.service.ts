import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs'
import { Tasks } from "../Tasks";
import { TASKS } from "../mocks-tasks";

const httpOptions = {
  headers: new HttpHeaders ( {
    'Content-Type': 'application/json'
  })
}

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private apiUrl = "http://localhost:8080/"

  constructor(private http: HttpClient) { }

  getTasks(): Observable<Tasks[]> {
    return this.http.get<Tasks[]>(this.apiUrl);
  }

  deleteTask(task: Tasks): Observable <Tasks> {
    const url = `${this.apiUrl}/delete/${task.id}`;
    return this.http.delete<Tasks>(url);
  }

  updateTaskReminder(task: Tasks): Observable <Tasks> {
    const url = `${this.apiUrl}/update`;
    return this.http.put<Tasks>(url, task, httpOptions);
  }

  addTask(task: Tasks) : Observable<Tasks> {
    const url = `${this.apiUrl}/add`;
    return this.http.post<Tasks>(url, task, httpOptions);
  }
}
