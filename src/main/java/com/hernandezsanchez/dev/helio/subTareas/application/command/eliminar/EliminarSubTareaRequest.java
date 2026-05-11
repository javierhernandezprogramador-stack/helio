package com.hernandezsanchez.dev.helio.subTareas.application.command.eliminar;

import com.hernandezsanchez.dev.helio.common.application.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EliminarSubTareaRequest implements Request<Void> {
    private Long id;
}
