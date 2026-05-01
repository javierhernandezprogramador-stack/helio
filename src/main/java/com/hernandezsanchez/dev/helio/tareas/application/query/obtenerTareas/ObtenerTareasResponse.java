package com.hernandezsanchez.dev.helio.tareas.application.query.obtenerTareas;

import com.hernandezsanchez.dev.helio.common.domain.PaginacionResultado;
import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ObtenerTareasResponse {
    private PaginacionResultado<Tarea> tareas;
}
