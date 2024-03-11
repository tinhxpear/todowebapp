package com.tinhxpear.springboot.todowebapp.todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@Service
public class ToDoService {
    private static List<ToDo> todos = new ArrayList<>();
    private static int todosCount = 0;
    static {
        todos.add(new ToDo(++ todosCount, "tinhxpear",
                "Learn Java 1", LocalDate.of(2024, 3, 20), false));

        todos.add(new ToDo(++ todosCount, "tinhxpear",
                "Learn Javascrip 1", LocalDate.of(2024, 3, 22), false));

        todos.add(new ToDo(++ todosCount, "tinhxpear",
                "Learn React JS 1", LocalDate.of(2024, 4, 20), false));

        todos.add(new ToDo(++ todosCount, "thaipt",
                "Learn React JS 1", LocalDate.of(2024, 4, 20), false));
        todos.add(new ToDo(++ todosCount, "duongnt",
                "Learn React JS 1", LocalDate.of(2024, 4, 20), false));
    }

    public List<ToDo> findByUserName(String userName){
        Predicate<? super ToDo> predicate = toDo -> toDo.getUserName().equals(userName) ;
        return todos.stream().filter(predicate).toList();
    }

    public void addToDo(String userName, String description, LocalDate targetDate, boolean done){
        ToDo toDo = new ToDo(++ todosCount, userName, description, targetDate, done);
        todos.add(toDo);
    }

    public void deleteTodo(int id){
        Predicate<? super ToDo> predicate = toDo -> toDo.getId() == id;
        todos.removeIf(predicate);
    }

    public ToDo findById(int id) {
        Predicate<? super ToDo> predicate = toDo -> toDo.getId() == id;
        ToDo toDo = todos.stream().filter(predicate).findFirst().get();
        return toDo;
    }

    public void updateTodo(ToDo toDo) {
        deleteTodo(toDo.getId());
        todos.add(toDo);
    }
}
