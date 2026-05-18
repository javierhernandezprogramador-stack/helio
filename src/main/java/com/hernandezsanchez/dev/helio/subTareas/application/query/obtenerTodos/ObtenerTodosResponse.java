package com.hernandezsanchez.dev.helio.subTareas.application.query.obtenerTodos;

import com.hernandezsanchez.dev.helio.common.domain.PaginacionResultado;
import com.hernandezsanchez.dev.helio.subTareas.domain.entity.SubTarea;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ObtenerTodosResponse {
    private PaginacionResultado<SubTarea> subTareas;
}
