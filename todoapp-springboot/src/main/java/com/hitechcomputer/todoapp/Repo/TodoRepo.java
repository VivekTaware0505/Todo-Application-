package com.hitechcomputer.todoapp.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hitechcomputer.todoapp.Entity.TodoEntity;

@Repository
public interface TodoRepo extends JpaRepository<TodoEntity, Long> {
    
}
