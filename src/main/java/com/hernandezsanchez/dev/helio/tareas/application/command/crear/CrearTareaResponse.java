package com.hernandezsanchez.dev.helio.tareas.application.command.crear;

import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CrearTareaResponse {
    private Tarea tareaPaginado;
}
