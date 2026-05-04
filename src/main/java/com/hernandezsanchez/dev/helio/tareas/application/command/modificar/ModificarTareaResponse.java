package com.hernandezsanchez.dev.helio.tareas.application.command.modificar;

import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ModificarTareaResponse {
    private Tarea tareaPaginado;
}
