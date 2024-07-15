package com.example.todolist.controllers;

import com.example.todolist.model.Todo;
import com.example.todolist.repositories.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/todos")
    public List<Todo> getTodos() {
        return todoRepository.getTodos();
    }

    @PostMapping("/todos")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        todoRepository.storeTodo(
                todo.getTitle(),
                todo.getDescription(),
                todo.isCompleted()
        );
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(todo);
    }
}
