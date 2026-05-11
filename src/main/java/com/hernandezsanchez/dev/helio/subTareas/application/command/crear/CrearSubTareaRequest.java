package com.hernandezsanchez.dev.helio.subTareas.application.command.crear;

import com.hernandezsanchez.dev.helio.common.application.mediator.Request;
import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class CrearSubTareaRequest implements Request<CrearSubTareaResponse> {
    private String nombre;
    private String descripcion;
    private int prioridad;
    private int estado;

    private Tarea tarea;
}
