package com.hernandezsanchez.dev.helio.tareas.infrastructure.database;

import com.hernandezsanchez.dev.helio.common.domain.PaginacionQuery;
import com.hernandezsanchez.dev.helio.common.domain.PaginacionResultado;
import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;
import com.hernandezsanchez.dev.helio.tareas.domain.port.TareaRepositorio;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.database.entity.TareaEntity;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.database.mapper.TareaEntityMapper;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.database.repository.QueryTareaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
@Slf4j
public class TareaRepositorioImpl implements TareaRepositorio {

    private final TareaEntityMapper tareaEntityMapper;

    private final QueryTareaRepository repository;

    @Override
    public Tarea upsert(Tarea tarea) {

        log.info("Iniciando almacenamiento de tarea en repositorio");

        TareaEntity tareaEntity = tareaEntityMapper.mapToTareaEntity(tarea);

        TareaEntity respuesta = repository.save(tareaEntity);

        log.info("Finalizado almacenamiento de tarea en repositorio");

        return tareaEntityMapper.mapToTarea(respuesta);
    }

    @Override
    public PaginacionResultado<Tarea> obtenerTodos(PaginacionQuery paginacionQuery) {

        log.info("Iniciando obteniendo todos en repositorio");

        PageRequest pageRequest = PageRequest.of(
                paginacionQuery.getPagina(),
                paginacionQuery.getCantidad(),
                Sort.by(Sort.Direction.fromString(paginacionQuery.getDireccion()), paginacionQuery.getOrdenarPor())
        );

        Page<TareaEntity> page = repository.findAll(pageRequest);

        PaginacionResultado paginacionResultado = new PaginacionResultado<>(
                page.getContent().stream().map(tareaEntityMapper::mapToTarea).toList(),
                page.getNumber(),
                page.getSize(),
                page.getTotalPages(),
                page.getTotalElements()
        );

        log.info("Finalizadon de obtener todos en repositorio");

        return paginacionResultado;
    }
}
