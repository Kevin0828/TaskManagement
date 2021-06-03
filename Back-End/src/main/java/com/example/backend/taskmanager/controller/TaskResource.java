package com.example.backend.taskmanager.controller;

import com.example.backend.taskmanager.model.Task;
import com.example.backend.taskmanager.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class TaskResource {

    private final TaskService taskService;

    public TaskResource(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> employees = taskService.findAllTasks();

        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Task> addEmployee(@RequestBody Task task) {
        Task newTask = taskService.addTask(task);

        return new ResponseEntity<>(newTask, HttpStatus.CREATED); //Created something in the server response.
    }

    @PutMapping("/update")
    public ResponseEntity<Task> updateEmployee(@RequestBody Task task) {
        Task updateReminder = taskService.updateReminder(task);

        return new ResponseEntity<>(updateReminder, HttpStatus.OK); //Created something in the server response.
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable("id") Long id)//? does not return anything
    {
        taskService.deleteTaskById(id);

        return new ResponseEntity<>(HttpStatus.OK); //Created something in the server response.
    }
}
