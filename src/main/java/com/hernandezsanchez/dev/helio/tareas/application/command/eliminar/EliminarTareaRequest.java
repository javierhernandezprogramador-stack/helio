package com.hernandezsanchez.dev.helio.tareas.application.command.eliminar;

import com.hernandezsanchez.dev.helio.common.application.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EliminarTareaRequest implements Request<Void> {
    private Long id;
}
