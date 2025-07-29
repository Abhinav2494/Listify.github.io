package com.ToDoApp.TodoApp.Service;

import com.ToDoApp.TodoApp.Models.Tasks;
import com.ToDoApp.TodoApp.Repositories.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Controller
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public List<Tasks> getAllTasks(){
        return taskRepository.findAll();
    }

    public void createTask(String title) {
        Tasks task = new Tasks();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public void toggleTask(Long id) {
      Tasks task =  taskRepository.findById(id).orElseThrow( ( ) -> new IllegalAccessError("Task Not Found") );
      task.setCompleted(!task.isCompleted());

      taskRepository.save(task);

    }
}
