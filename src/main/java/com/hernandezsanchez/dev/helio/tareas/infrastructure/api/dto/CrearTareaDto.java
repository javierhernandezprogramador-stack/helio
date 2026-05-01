package com.hernandezsanchez.dev.helio.tareas.infrastructure.api.dto;

import lombok.Data;

@Data
public class CrearTareaDto {
    private String nombre;
    private int estado;
}
