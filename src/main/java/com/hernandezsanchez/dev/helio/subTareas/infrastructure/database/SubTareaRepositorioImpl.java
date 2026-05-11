package com.hernandezsanchez.dev.helio.subTareas.infrastructure.database;

import com.hernandezsanchez.dev.helio.common.domain.PaginacionQuery;
import com.hernandezsanchez.dev.helio.common.domain.PaginacionResultado;
import com.hernandezsanchez.dev.helio.subTareas.domain.entity.SubTarea;
import com.hernandezsanchez.dev.helio.subTareas.domain.port.SubTareaRepositorio;
import com.hernandezsanchez.dev.helio.subTareas.infrastructure.database.entity.SubTareaEntity;
import com.hernandezsanchez.dev.helio.subTareas.infrastructure.database.mapper.SubTareaEntityMapper;
import com.hernandezsanchez.dev.helio.subTareas.infrastructure.database.repository.QuerySubTareaRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class SubTareaRepositorioImpl implements SubTareaRepositorio {

    private final QuerySubTareaRepositorio repository;

    private final SubTareaEntityMapper subTareaEntityMapper;

    @CachePut(value = "subTareas", key = "#subTarea.id", condition = "#subTarea.id != null")
    @Override
    public SubTarea upsert(SubTarea subTarea) {

        log.info("Iniciando guardado de subTarea en repositorio");

        SubTareaEntity subTareaEntity = subTareaEntityMapper.mapToSubTareaEntity(subTarea);

        SubTareaEntity response = repository.save(subTareaEntity);

        log.info("Finalizando guardado de subTarea en repositorio");

        return subTareaEntityMapper.mapToSubTarea(response);
    }

    @Cacheable(value = "subTareas", key = "#id")
    @Override
    public Optional<SubTarea> buscarPorId(Long id) {

        log.info("Iniciando la busque de subTarea por Id en repositorio: {}", id);

        return repository.findById(id).map(subTareaEntityMapper::mapToSubTarea);
    }

    @CacheEvict(value = "subTareas", key = "#id")
    @Override
    public void eliminar(Long id) {

        log.info("Iniciando la eliminación de subTarea en repositorio: {}", id);

        Optional<SubTareaEntity> optionalSubTareaEntity = buscarPorId(id).map(subTareaEntityMapper::mapToSubTareaEntity);

        log.info("Iniciando la eliminación de subTarea en repositorio: {}", id);

        repository.delete(optionalSubTareaEntity.get());
    }

}
