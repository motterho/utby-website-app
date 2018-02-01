package com.utby.springboot.web.service.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.utby.springboot.web.model.Todo;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    public List<Todo> findById(int id);

    //@Query("select s from Student s where s.age <= ?")
    public List<Todo> findAll();

}
