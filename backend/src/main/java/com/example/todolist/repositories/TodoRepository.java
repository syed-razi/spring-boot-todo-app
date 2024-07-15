package com.example.todolist.repositories;

import com.example.todolist.model.Todo;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Integer> {

    @Modifying
    @Query("INSERT INTO todo (title, description, completed) VALUES (:title, :description, :completed)")
    void storeTodo(String title, String description, boolean completed);

    @Query("SELECT * FROM todo")
    List<Todo> getTodos();
}
