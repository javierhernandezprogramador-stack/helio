package com.hernandezsanchez.dev.helio.subTareas.infrastructure.api.dto;

import com.hernandezsanchez.dev.helio.tareas.infrastructure.api.dto.TareaDto;
import lombok.Data;

@Data
public class CrearSubTareaDto {
    private String nombre;
    private String descripcion;
    private int prioridad;
    private int estado;

    private TareaDto tarea;
}

