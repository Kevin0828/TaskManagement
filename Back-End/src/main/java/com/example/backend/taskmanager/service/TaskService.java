package com.example.backend.taskmanager.service;

import com.example.backend.taskmanager.model.Task;
import com.example.backend.taskmanager.repo.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TaskService {

    private final TaskRepo taskRepo;

    @Autowired
    public TaskService(TaskRepo taskRepo) {
        this.taskRepo = taskRepo;
    }

    public Task addTask(Task task) {

        return this.taskRepo.save(task);
    }

    public List<Task> findAllTasks() {
        return this.taskRepo.findAll();
    }

    public void deleteTaskById(Long id) {
        this.taskRepo.deleteTaskById(id);
    }

    public Task updateReminder(Task task) {
       return this.taskRepo.save(task);
    }
}
