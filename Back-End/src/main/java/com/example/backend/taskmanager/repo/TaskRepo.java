package com.example.backend.taskmanager.repo;

import com.example.backend.taskmanager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long>  {//Pass the class and the primary key's data type.//{

    void deleteTaskById(Long id);
}
