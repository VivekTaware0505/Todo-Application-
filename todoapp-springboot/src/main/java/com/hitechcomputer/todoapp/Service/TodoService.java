package com.hitechcomputer.todoapp.Service;

import java.util.List;

import com.hitechcomputer.todoapp.Entity.TodoEntity;

public interface TodoService {

    public List<TodoEntity> getAllTodos();

    public TodoEntity getTodoById(Long id);

    public boolean saveTodoEntity(TodoEntity todoEntity);

    public boolean deleteTodoEntity(Long id);

    public boolean updateTodoEntity(TodoEntity todoEntity);

   

}
