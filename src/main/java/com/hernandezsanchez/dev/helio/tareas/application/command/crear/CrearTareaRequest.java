package com.hernandezsanchez.dev.helio.tareas.application.command.crear;

import com.hernandezsanchez.dev.helio.common.application.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CrearTareaRequest implements Request<CrearTareaResponse> {
    private String nombre;
    private int estado;
}
