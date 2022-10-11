package com.example.demo.controller;

import com.example.demo.domain.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/todo")
@CrossOrigin

public class TestController {
    List<Task> tasks = new ArrayList<>();

    @GetMapping("/all")
    public List<Task> showTask(){
        return tasks;
    }


    @PostMapping("/save")
    public Task saveTask(@RequestBody Task t){
        tasks.add(t);
        return t;
    }

    @GetMapping("/{id}")
    public Task showOneTask(@PathVariable  Integer id){
        Task taskFound = tasks.stream().filter(t->t.getId().equals(id)).findAny().orElse(null);
        return taskFound;
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Integer id){
        Task taskFound = tasks.stream().filter(t->t.getId().equals(id)).findAny().orElse(null);
        tasks.remove(taskFound);
    }

    @PutMapping("/update/{id}")
    public  Task update(@RequestBody Task tk, @PathVariable Integer id){
        Task taskFound = tasks.stream().filter(t->t.getId().equals(id)).findAny().orElse(null);
        if (taskFound != null){
            taskFound.setId(tk.getId());
            taskFound.setTask(tk.getTask());
            taskFound.setStatus(tk.getStatus());
        }
        return taskFound;
    }






}
