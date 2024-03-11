package com.tinhxpear.springboot.todowebapp.todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("userName")
public class ToDoControllerJpa {

//    private ToDoService toDoService;
    private TodoRepository todoRepository;

    public ToDoControllerJpa(ToDoService toDoService, TodoRepository todoRepository) {
//        this.toDoService = toDoService;
        this.todoRepository = todoRepository;
    }

    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model){
        String userName = getLoggedInUserName(model);

        List<ToDo> todos = todoRepository.findByUserName(userName);
        model.addAttribute("todos", todos);
        return "listToDos";
    }



    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String showNewTodoPage(ModelMap model){
        String userName = getLoggedInUserName(model);
        ToDo toDo = new ToDo(0, userName, "",LocalDate.now().plusYears(1), false);
        model.put("toDo", toDo);
        return "addToDo";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.POST)
    public String addNewTodo(ModelMap model, @Valid @ModelAttribute("toDo") ToDo toDo, BindingResult result){
        if(result.hasErrors()){
            return "addToDo";
        }
        String userName = getLoggedInUserName(model);
        toDo.setUserName(userName);
        todoRepository.save(toDo);
        //toDoService.addToDo(userName,toDo.getDescription(), toDo.getTargetDate(),toDo.isDone());
        return "redirect:list-todos";
    }

    @RequestMapping("delete-todo")
    public String deleteTodo(@RequestParam int id){
        todoRepository.deleteById(id);
//        toDoService.deleteTodo(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(@RequestParam int id, ModelMap model){
        ToDo toDo = todoRepository.findById(id).get();
        model.addAttribute("toDo", toDo);
        return "addToDo";
    }

    @RequestMapping(value = "update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid @ModelAttribute("toDo") ToDo toDo, BindingResult result){
        if(result.hasErrors()){
            return "addToDo";
        }
        String userName = getLoggedInUserName(model);
        toDo.setUserName(userName);
        todoRepository.save(toDo);
//        toDoService.updateTodo(toDo);
        return "redirect:list-todos";
    }
    private String getLoggedInUserName(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
