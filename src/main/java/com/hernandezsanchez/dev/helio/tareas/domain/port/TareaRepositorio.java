package com.hernandezsanchez.dev.helio.tareas.domain.port;

import com.hernandezsanchez.dev.helio.common.domain.PaginacionQuery;
import com.hernandezsanchez.dev.helio.common.domain.PaginacionResultado;
import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;

public interface TareaRepositorio {

    Tarea upsert(Tarea tarea);

    PaginacionResultado<Tarea> obtenerTodos(PaginacionQuery paginacionQuery);
}
