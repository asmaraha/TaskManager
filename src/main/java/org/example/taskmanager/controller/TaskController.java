package org.example.taskmanager.controller;

import org.example.taskmanager.model.Task;
import org.example.taskmanager.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @PostMapping("/tasks")
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable int id) {
        boolean isRemoved = taskService.deleteTask(id);
        return isRemoved ? ResponseEntity.ok("Task deleted") : ResponseEntity.notFound().build();
    }

    @GetMapping("/math")
    public ResponseEntity<Double> calculate(@RequestParam double a, @RequestParam double b, @RequestParam String operator) {
        try {
            return ResponseEntity.ok(taskService.calculate(a, b, operator));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/string/reverse")
    public String reverseString(@RequestParam String input) {
        return taskService.reverseString(input);
    }

    @GetMapping("/string/vowels")
    public long countVowels(@RequestParam String input) {
        return taskService.countVowels(input);
    }

    @GetMapping("/string/consonants")
    public long countConsonants(@RequestParam String input) {
        return taskService.countConsonants(input);
    }

    @GetMapping("/string/convert-case")
    public String convertCase(@RequestParam String input) {
        return taskService.convertCase(input);
    }
}
