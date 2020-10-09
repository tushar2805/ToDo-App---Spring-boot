package com.github.todo.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.todo.domain.ToDo;

public interface ToDoRepository extends CrudRepository<ToDo,String> {
    
}