package com.hitechcomputer.todoapp.Api;

import org.springframework.web.bind.annotation.RestController;

import com.hitechcomputer.todoapp.Entity.TodoEntity;
import com.hitechcomputer.todoapp.Service.TodoService;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@CrossOrigin(origins = "*")
public class TodoApi {

    private final TodoService todoService;

    public TodoApi(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo")
    public List<TodoEntity> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping("/todo")
    public boolean saveTodoEntity(@RequestBody TodoEntity todoEntity) {
        return todoService.saveTodoEntity(todoEntity);
    }

    @PutMapping("/todo")
    public boolean updateTodoEntity(@RequestBody TodoEntity todoEntity) {
        return todoService.updateTodoEntity(todoEntity);
    }

    @DeleteMapping("/todo")
    public boolean deleteTodoEntity(@RequestParam Long id) {
        return todoService.deleteTodoEntity(id);
    }

}
