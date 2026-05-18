package com.hernandezsanchez.dev.helio.subTareas.infrastructure.database;

import com.hernandezsanchez.dev.helio.common.domain.PaginacionQuery;
import com.hernandezsanchez.dev.helio.common.domain.PaginacionResultado;
import com.hernandezsanchez.dev.helio.subTareas.domain.entity.SubTarea;
import com.hernandezsanchez.dev.helio.subTareas.domain.entity.SubTareaFilter;
import com.hernandezsanchez.dev.helio.subTareas.domain.port.SubTareaRepositorio;
import com.hernandezsanchez.dev.helio.subTareas.infrastructure.database.entity.SubTareaEntity;
import com.hernandezsanchez.dev.helio.subTareas.infrastructure.database.mapper.SubTareaEntityMapper;
import com.hernandezsanchez.dev.helio.subTareas.infrastructure.database.repository.QuerySubTareaRepositorio;
import com.hernandezsanchez.dev.helio.subTareas.infrastructure.database.specification.SubTareaSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public class SubTareaRepositorioImpl implements SubTareaRepositorio {

    private final QuerySubTareaRepositorio repository;

    private final SubTareaEntityMapper subTareaEntityMapper;

    @Override
    public SubTarea upsert(SubTarea subTarea) {

        log.info("Iniciando guardado de subTarea en repositorio");

        SubTareaEntity subTareaEntity = subTareaEntityMapper.mapToSubTareaEntity(subTarea);

        SubTareaEntity response = repository.save(subTareaEntity);

        log.info("Finalizando guardado de subTarea en repositorio");

        return subTareaEntityMapper.mapToSubTarea(response);
    }

    @Override
    public PaginacionResultado<SubTarea> listar(PaginacionQuery paginacionQuery, SubTareaFilter subTareaFilter) {

        log.info("Iniciando a obtener todas la subTareas en repositorio");

        PageRequest pageRequest = PageRequest.of(
                paginacionQuery.getPagina(),
                paginacionQuery.getCantidad(),
                Sort.by(Sort.Direction.fromString(paginacionQuery.getDireccion()), paginacionQuery.getOrdenarPor())
        );

        Specification<SubTareaEntity> specification = Specification.allOf(
                SubTareaSpecification.byTarea(subTareaFilter.getIdTarea())
        );

        Page<SubTareaEntity> page = repository.findAll(specification, pageRequest);

        log.info("Finalizando a obtener todas las subTareas en repositorio");

        return new PaginacionResultado<>(
                page.getContent().stream().map(subTareaEntityMapper::mapToSubTarea).toList(),
                page.getNumber(),
                page.getSize(),
                page.getTotalPages(),
                page.getTotalElements()
        );
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
