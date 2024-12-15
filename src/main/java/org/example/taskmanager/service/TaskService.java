package org.example.taskmanager.service;

import org.example.taskmanager.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task addTask(Task task) {
        tasks.add(task);
        return task;
    }

    public boolean deleteTask(int id) {
        return tasks.removeIf(task -> task.getId() == id);
    }

    public double calculate(double a, double b, String operator) {
        return switch (operator) {
            case "add" -> a + b;
            case "subtract" -> a - b;
            case "multiply" -> a * b;
            case "divide" -> a / b;
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }

    public String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public long countVowels(String input) {
        return input.chars().filter(ch -> "aeiouAEIOU".indexOf(ch) != -1).count();
    }

    public long countConsonants(String input) {
        return input.chars().filter(ch -> Character.isLetter(ch) && "aeiouAEIOU".indexOf(ch) == -1).count();
    }

    public String convertCase(String input) {
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            sb.append(Character.isUpperCase(c) ? Character.toLowerCase(c) : Character.toUpperCase(c));
        }
        return sb.toString();
    }
}
