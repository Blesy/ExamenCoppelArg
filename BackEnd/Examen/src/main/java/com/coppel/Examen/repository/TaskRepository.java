package com.coppel.Examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.coppel.Examen.model.Task;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "SELECT * FROM tasks WHERE tarea = ?1", nativeQuery = true)
    List<Task> getTasksByName(String tarea);
}
