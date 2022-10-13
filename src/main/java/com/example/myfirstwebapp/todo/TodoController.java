package com.example.myfirstwebapp.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping("/list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUsername("bindu");
        model.addAttribute("todos", todos);
        return "listTodos";
    }

    @GetMapping("/add-todo")
    public String showNewTodoPage(){
        return "todo";
    }

    @PostMapping("/add-todo")
    public String addNewTodo(@RequestParam String description, ModelMap model){
        String username = (String)model.get("name");
        todoService.addTodo(username, description,
                LocalDate.now().plusYears(1), false);
        return "redirect:list-todos";
    }


}
