package com.utby.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.utby.springboot.web.model.Todo;
import com.utby.springboot.web.service.dao.TodoRepository;

@SpringBootApplication
@ComponentScan("com.utby.springboot.web")
public class SpringBootFirstWebApplication implements CommandLineRunner{
    
    @Autowired
    TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootFirstWebApplication.class, args);
	}
	
	     
    @Override
	    public void run(String... args) throws Exception
	    {
	        // Getting all Students
	        System.out.println("***** All Todos *******");
	        for(Todo todo : todoRepository.findAll())
	        {
	            System.out.println(todo);
	        }
	        
	    }
}
