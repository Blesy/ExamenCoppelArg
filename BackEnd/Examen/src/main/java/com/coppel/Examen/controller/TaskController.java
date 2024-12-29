package com.coppel.Examen.controller;

import com.coppel.Examen.model.Task;
import com.coppel.Examen.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {


    @Autowired
    private TaskService taskService;


    // insert a task into database
    @PostMapping("/task")
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        Task savedTask = taskService.saveTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }


    //get a single task by its id
    @GetMapping("/task")
    public ResponseEntity<Task> getTask(@RequestParam(name = "taskId") long taskId) {
        Task task = taskService.getTask(taskId);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }


    //get all the tasks in the table in our database
    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }


    //update an existing task in the database
    @PatchMapping("/task")
    public ResponseEntity<Task> updateTask(@RequestParam(name = "taskId") long taskId, @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(taskId, task);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }


    // delete an existing task in the database
    @DeleteMapping("/task")
    public ResponseEntity<Task> deleteTask(@RequestParam(name = "taskId") long taskId) {
        Task deletedTask = taskService.deletetask(taskId);
        return new ResponseEntity<>(deletedTask, HttpStatus.OK);
    }


    // get task by name using a raw SQL statement
    @GetMapping("/tasks-by-name")
    public List<Task> getTasksByName(@RequestParam(name = "taskName") String taskName) {
        return taskService.getTasksByName(taskName);
    }


}
