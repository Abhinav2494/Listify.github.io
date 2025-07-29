package com.ToDoApp.TodoApp.Repositories;

import com.ToDoApp.TodoApp.Models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Tasks, Long> {
}
