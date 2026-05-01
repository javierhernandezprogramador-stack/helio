package com.hernandezsanchez.dev.helio.tareas.infrastructure.database;

import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;
import com.hernandezsanchez.dev.helio.tareas.domain.port.TareaRepositorio;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.database.entity.TareaEntity;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.database.mapper.TareaEntityMapper;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.database.repository.QueryTareaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TareaRepositorioImpl implements TareaRepositorio {

    private final TareaEntityMapper tareaEntityMapper;

    private final QueryTareaRepository repository;

    @Override
    public Tarea upsert(Tarea tarea) {
        TareaEntity tareaEntity = tareaEntityMapper.mapToTareaEntity(tarea);

        TareaEntity respuesta = repository.save(tareaEntity);

        return tareaEntityMapper.mapToTarea(respuesta);
    }
}
