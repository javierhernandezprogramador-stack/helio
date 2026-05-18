package com.hernandezsanchez.dev.helio.tareas.domain.entity;

import com.hernandezsanchez.dev.helio.subTareas.domain.entity.SubTarea;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class Tarea {
    private Long id;
    private String nombre;
    private String descripcion;
    private int prioridad;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFinal;
    private int estado;

    private List<SubTarea> subTareas;
}
