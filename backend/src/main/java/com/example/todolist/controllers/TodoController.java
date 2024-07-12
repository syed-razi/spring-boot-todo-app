package com.example.todolist.controllers;

import com.example.todolist.model.Todo;
import com.example.todolist.services.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todos")
    public List<Todo> getTodolist() {
        return todoService.getTodoList();
    }

    @PostMapping("/todos")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        todoService.addTodo(todo);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(todo);
    }
}
