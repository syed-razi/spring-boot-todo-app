package com.example.todolist.repositories;

import com.example.todolist.model.Todo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodoRepository {

    private final JdbcTemplate jdbc;

    public TodoRepository(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void storeTodo(Todo todo) {
        String sql =
                "INSERT INTO todo VALUES (DEFAULT, ?, ?, ?)";

        jdbc.update(sql,
                todo.getTitle(),
                todo.getDescription(),
                todo.isCompleted());
    }

    public List<Todo> getTodos() {
        String sql =
                "SELECT * FROM todo";

        RowMapper<Todo> todoRowMapper = (r, i) -> {
            Todo rowObject = new Todo();
            rowObject.setId(r.getInt("id"));
            rowObject.setTitle(r.getString("title"));
            rowObject.setDescription(r.getString("description"));
            rowObject.setCompleted(r.getBoolean("completed"));
            return rowObject;
        };

        return jdbc.query(sql, todoRowMapper);
    }
}
