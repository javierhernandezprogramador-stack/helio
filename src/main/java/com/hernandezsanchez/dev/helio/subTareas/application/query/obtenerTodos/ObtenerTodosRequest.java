package com.hernandezsanchez.dev.helio.subTareas.application.query.obtenerTodos;

import com.hernandezsanchez.dev.helio.common.application.mediator.Request;
import com.hernandezsanchez.dev.helio.common.domain.PaginacionQuery;
import com.hernandezsanchez.dev.helio.subTareas.domain.entity.SubTareaFilter;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ObtenerTodosRequest implements Request<ObtenerTodosResponse> {
    private PaginacionQuery paginacionQuery;
    private SubTareaFilter subTareaFilter;
}
