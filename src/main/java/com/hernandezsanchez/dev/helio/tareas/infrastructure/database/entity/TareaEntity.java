package com.hernandezsanchez.dev.helio.tareas.infrastructure.database.entity;

import com.hernandezsanchez.dev.helio.subTareas.infrastructure.database.entity.SubTareaEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tareas")
@Data
public class TareaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private int prioridad;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private int estado;

    @OneToMany(mappedBy = "tareaEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SubTareaEntity> subTareaEntities;
}
