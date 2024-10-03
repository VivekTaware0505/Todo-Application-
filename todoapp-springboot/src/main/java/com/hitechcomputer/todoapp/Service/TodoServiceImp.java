package com.hitechcomputer.todoapp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hitechcomputer.todoapp.Entity.TodoEntity;
import com.hitechcomputer.todoapp.Repo.TodoRepo;

@Service
public class TodoServiceImp implements TodoService {

    private TodoRepo todoRepo;

    public TodoServiceImp(TodoRepo todoRepo) {
        this.todoRepo = todoRepo;
    }

    @Override
    public List<TodoEntity> getAllTodos() {

        return todoRepo.findAll();
    }

    @Override
    public TodoEntity getTodoById(Long id) {

        return todoRepo.findById(id).get();
    }

    @Override
    public boolean saveTodoEntity(TodoEntity todoEntity) {
        todoRepo.save(todoEntity);
        return true;
    }

    @Override
    public boolean deleteTodoEntity(Long id) {
        todoRepo.deleteById(id);
        return true;
    }

    @Override
    public boolean updateTodoEntity(TodoEntity todoEntity) {
        todoRepo.save(todoEntity);
        return true;
    }

 

}
