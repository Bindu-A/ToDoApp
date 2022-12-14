//package com.example.myfirstwebapp.todo;
//
//import jakarta.validation.Valid;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDate;
//import java.util.List;
//
////@Controller
//@SessionAttributes("name")
//public class TodoController {
//    @Autowired
//    private TodoService todoService;
//
//    @GetMapping("/list-todos")
//    public String listAllTodos(ModelMap model) {
//        var name = getLoggedInUsername();
//        List<Todo> todos = todoService.findByUsername(name);
//        model.addAttribute("todos", todos);
//        return "listTodos";
//    }
//
//    private String getLoggedInUsername() {
//        return SecurityContextHolder.getContext().getAuthentication().getName();
//    }
//
//    @GetMapping("/add-todo")
//    public String showNewTodoPage(ModelMap model) {
//        String username = getLoggedInUsername();
//        Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
//        model.put("todo", todo);
//        return "todo";
//    }
//
//    @PostMapping("/add-todo")
//    public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
//        if (result.hasErrors()) {
//            return "todo";
//        }
//        String username = getLoggedInUsername();
//        todoService.addTodo(username, todo.getDescription(),
//                todo.getTargetDate(), false);
//        return "redirect:list-todos";
//    }
//
//    @RequestMapping("/delete-todo")
//    public String deleteToDo(@RequestParam int id) {
//        todoService.deleteById(id);
//        return "redirect:list-todos";
//    }
//
//    @GetMapping("/update-todo")
//    public String showUpdateTodoPage(@RequestParam int id, ModelMap model) {
//        Todo todo = todoService.findById(id);
//        model.addAttribute("todo", todo);
//        return "todo";
//    }
//
//    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
//    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
//
//        if (result.hasErrors()) {
//            return "todo";
//        }
//
//        String username = getLoggedInUsername();
//        todo.setUsername(username);
//        todoService.updateTodo(todo);
//        return "redirect:list-todos";
//    }
//}
