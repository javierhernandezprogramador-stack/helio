package com.hernandezsanchez.dev.helio.subTareas.domain.entity;

import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SubTarea {
    private Long id;
    private String nombre;
    private String descripcion;
    private int prioridad;
    private int estado;

    private Tarea tarea;
}
