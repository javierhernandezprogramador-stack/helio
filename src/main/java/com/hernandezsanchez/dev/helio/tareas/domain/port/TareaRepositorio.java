package com.hernandezsanchez.dev.helio.tareas.domain.port;

import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;

public interface TareaRepositorio {

    Tarea upsert(Tarea tarea);
}
