package com.hernandezsanchez.dev.helio.tareas.infrastructure.database;

import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;
import com.hernandezsanchez.dev.helio.tareas.domain.port.TareaRepositorio;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.database.entity.TareaEntity;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.database.mapper.TareaEntityMapper;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.database.repository.QueryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TareaReposoitorioImpl implements TareaRepositorio {

    private final TareaEntityMapper tareaEntityMapper;

    private final QueryRepository repository;

    @Override
    public Tarea upsert(Tarea tarea) {
        TareaEntity tareaEntity = tareaEntityMapper.mapToTareaEntity(tarea);

        TareaEntity respuesta = repository.save(tareaEntity);

        return tareaEntityMapper.mapToTarea(respuesta);
    }
}
