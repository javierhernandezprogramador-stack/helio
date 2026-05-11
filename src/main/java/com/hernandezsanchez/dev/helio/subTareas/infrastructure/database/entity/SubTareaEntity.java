package com.hernandezsanchez.dev.helio.subTareas.infrastructure.database.entity;

import com.hernandezsanchez.dev.helio.tareas.infrastructure.database.entity.TareaEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "subtareas")
@Data
public class SubTareaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private int prioridad;
    private int estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tarea_id")
    private TareaEntity tareaEntity;
}
