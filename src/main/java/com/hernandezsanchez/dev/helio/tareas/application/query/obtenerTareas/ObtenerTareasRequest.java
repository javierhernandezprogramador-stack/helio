package com.hernandezsanchez.dev.helio.tareas.application.query.obtenerTareas;

import com.hernandezsanchez.dev.helio.common.application.mediator.Request;
import com.hernandezsanchez.dev.helio.common.domain.PaginacionQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ObtenerTareasRequest implements Request<ObtenerTareasResponse> {
    private PaginacionQuery paginacionQuery;
}
