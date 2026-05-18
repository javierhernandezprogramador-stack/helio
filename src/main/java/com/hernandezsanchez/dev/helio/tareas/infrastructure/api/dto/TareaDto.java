package com.hernandezsanchez.dev.helio.tareas.infrastructure.api.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class TareaDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private int prioridad;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private int estado;
}
