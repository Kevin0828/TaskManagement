import { Component, OnInit } from '@angular/core';
import { TaskService } from '../../services/task.service';
import { Tasks } from "../../Tasks"
import { TASKS } from "../../mocks-tasks";


@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.css']
})
export class TasksComponent implements OnInit {

  tasks: Tasks[] = TASKS;

  constructor(private taskService: TaskService) {
    
  }

  ngOnInit(): void {
    this.taskService.getTasks().subscribe((tasks) => this.tasks = tasks);
  }

  deleteTask(tasks: Tasks) {
    this.taskService.deleteTask(tasks).subscribe(() => this.tasks = this.tasks.filter(
      t => t.id !== tasks.id)
    );
  }

  toggleReminder(tasks: Tasks) {
    tasks.reminder = !tasks.reminder;
    this.taskService.updateTaskReminder(tasks).subscribe();
  }

  addTask(task: Tasks) {
    this.taskService.addTask(task).subscribe((task) => this.tasks.push(task));
  }

}
