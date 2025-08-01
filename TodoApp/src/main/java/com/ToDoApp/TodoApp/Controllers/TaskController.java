package com.ToDoApp.TodoApp.Controllers;

import com.ToDoApp.TodoApp.Models.Tasks;
import com.ToDoApp.TodoApp.Service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping
    public String getTasks(Model model){
        List<Tasks> tasks = taskService.getAllTasks();
        model.addAttribute("tasks" ,tasks );
        return "tasks";
    }
    @PostMapping
    public String CreateTask(@RequestParam String title){
        taskService.createTask(title);
        return "redirect:/";
    }
    @PostMapping("/{id}/delete")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }

    @PostMapping("/{id}/toggle")
    public String toggleTask(@PathVariable Long id) {
        taskService.toggleTask(id);
        return "redirect:/";
    }

}
