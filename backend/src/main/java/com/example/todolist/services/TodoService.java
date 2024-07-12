package com.example.todolist.services;

import com.example.todolist.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    private List<Todo> todoList = new ArrayList<>();

    public void addTodo(Todo todo) {
        todoList.add(todo);
    }

    public List<Todo> getTodoList() {
        return todoList;
    }
}
