package com.hernandezsanchez.dev.helio.tareas.application.command.crear;

import com.hernandezsanchez.dev.helio.common.application.mediator.Request;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CrearTareaRequest implements Request<CrearTareaResponse> {
    private String nombre;
    private int estado;
}
