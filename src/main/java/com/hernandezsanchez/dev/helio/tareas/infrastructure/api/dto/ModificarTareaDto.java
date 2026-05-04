package com.hernandezsanchez.dev.helio.tareas.infrastructure.api.dto;

import lombok.Data;

@Data
public class ModificarTareaDto {
    private Long id;
    private String nombre;
    private int estado;
}
