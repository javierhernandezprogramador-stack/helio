package com.hernandezsanchez.dev.helio.subTareas.application.command.modificar;

import com.hernandezsanchez.dev.helio.common.application.mediator.Request;
import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ModificarSubTareaRequest implements Request<ModificarSubTareaResponse> {
    private Long id;
    private String nombre;
    private String descripcion;
    private int prioridad;
    private int estado;

    private  Tarea tarea;
}
