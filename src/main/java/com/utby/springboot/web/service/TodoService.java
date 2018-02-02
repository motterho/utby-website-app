package com.utby.springboot.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utby.springboot.web.model.Todo;
import com.utby.springboot.web.service.dao.TodoRepository;

@Service
public class TodoService {
//    private static List<Todo> todos = new ArrayList<Todo>();
//    private static int todoCount = 3;

    @Autowired
    TodoRepository todoRepository;

//    private void getTodos() {
//        for (Todo todo : todoRepository.findAll()) {
//            System.out.println(todo);
//        }
//    }

    public List<Todo> retrieveTodos(String user) {
        List<Todo> filteredTodos = new ArrayList<Todo>();
        for (Todo todo : todoRepository.findAll()) {
            if (todo.getUser().equals(user)) {
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public List<Todo> addTodo(String name, String note, Date targetDate, boolean isDone) {
        Todo todo = new Todo();
        //todo.setId(4);
        todo.setUser(name);
        todo.setNote(note);
        todo.setTargetDate(targetDate);
        todo.setDone(isDone);
        try {
            todoRepository.save(todo);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        return retrieveTodos(todo.getUser());
    }

    public List<Todo> delete(Long id) {
        Iterator<Todo> iterator = todoRepository.findById(new Long(id).intValue()).iterator();
        Todo todo = null;
        while (iterator.hasNext()) {
            todo = iterator.next();
            if (todo.getId() == id) {
                todoRepository.delete(todo);
            }
        }
        return retrieveTodos(todo != null ? todo.getUser() : null);
    }
}