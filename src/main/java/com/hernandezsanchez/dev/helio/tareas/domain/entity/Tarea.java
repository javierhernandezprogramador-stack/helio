package com.hernandezsanchez.dev.helio.tareas.domain.entity;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Tarea {
    private Long id;
    private String nombre;
    private int estado;
}
