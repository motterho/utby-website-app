package com.utby.springboot.web.service;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.utby.springboot.web.model.Todo;
import com.utby.springboot.web.service.dao.TodoRepository;

@RunWith(MockitoJUnitRunner.class)
public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;
    @InjectMocks
    private TodoService todoService;
    @Test
    public void testAddTodo() throws Exception {
        
        Date d = new Date();
        System.out.println("Date = " +d.toString());
        List<Todo> todoList = todoService.addTodo("testare", "test", d, false);
        assertNotNull("Error ", todoList);
        System.out.println("End");
    }

}
