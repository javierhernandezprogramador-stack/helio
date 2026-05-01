package com.hernandezsanchez.dev.helio.tareas.infrastructure.api.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TareaDto {
    private Long id;
    private String nombre;
    private int estado;
}
