package com.hernandezsanchez.dev.helio.subTareas.infrastructure.api.dto;

import lombok.Data;

@Data
public class SubTareaDto {
    private Long id;
    private String nombre;
    private String descripcion;
    private int prioridad;
    private int estado;
}
