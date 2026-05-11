package com.hernandezsanchez.dev.helio.tareas.domain.entity;

import com.hernandezsanchez.dev.helio.subTareas.domain.entity.SubTarea;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Tarea {
    private Long id;
    private String nombre;
    private int estado;

    private List<SubTarea> subTareas;
}
