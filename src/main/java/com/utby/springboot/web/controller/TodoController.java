package com.utby.springboot.web.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.utby.springboot.web.service.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    TodoService service;

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model) {
        String name = (String) model.get("name");
        model.put("todos", service.retrieveTodos(name));
        return "list-todos";
    }

    
    @RequestMapping(value="/add-todos", method = RequestMethod.GET)
    public String addTodos(ModelMap model){
        return "add-todos";
    }
    
    @RequestMapping(value = "/add-todos", method = RequestMethod.POST)
    public String addTodos(ModelMap model, @RequestParam String note, @RequestParam String StringTargetDate, @RequestParam(defaultValue = "false") boolean isDone) {
        String name = (String) model.get("name");
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date targetDate = null;
        try {
            targetDate = sdf.parse(StringTargetDate);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String date=sdf.format(targetDate );
        System.out.println(date);
        
                
        model.put("todos", service.addTodo(name, note, targetDate, isDone ? isDone : false ));
        return "add-todos";
    }

}
