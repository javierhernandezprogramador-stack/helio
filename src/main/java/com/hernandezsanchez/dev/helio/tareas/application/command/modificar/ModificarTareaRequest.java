package com.hernandezsanchez.dev.helio.tareas.application.command.modificar;

import com.hernandezsanchez.dev.helio.common.application.mediator.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ModificarTareaRequest implements Request<ModificarTareaResponse> {
    private Long id;
    private String nombre;
    private int estado;
}
