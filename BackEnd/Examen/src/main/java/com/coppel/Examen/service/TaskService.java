package com.coppel.Examen.service;

import com.coppel.Examen.model.Task;
import com.coppel.Examen.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class TaskService {


    @Autowired
    private TaskRepository taskRepository;


    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }


    public Task getTask(long taskId) {
        return taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Not Found"));
    }


    public List<Task> getTasks() {
        return taskRepository.findAll();
    }


    public Task updateTask(long taskId, Task task) {
        Task existingTask = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Not Found"));
        existingTask.setTarea(task.getTarea());
        existingTask.setCategoria(task.getCategoria());
        existingTask.setCompletado(task.getCompletado());
        taskRepository.save(existingTask);
        return existingTask;
    }


    public Task deletetask(long taskId) {
        Task existingTask = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Not Found"));
        taskRepository.deleteById(taskId);
        return existingTask;
    }


    public List<Task> getTasksByName(String taskName) {
        return taskRepository.getTasksByName(taskName);
    }
}