package com.coppel.Examen.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tasks")
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    public long getId() { return id; }


    @Column(name = "categoria", nullable = false)
    private String categoria;
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    @Column(name = "tarea")
    private String tarea;
    public String getTarea() { return tarea; }
    public void setTarea(String tarea) { this.tarea = tarea; }


    @Column(name = "completado")
    private boolean completado;
    public boolean getCompletado() { return completado; }
    public void setCompletado(boolean completado) { this.completado = completado; }
}
