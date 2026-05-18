package com.hernandezsanchez.dev.helio.subTareas.domain.port;

import com.hernandezsanchez.dev.helio.common.domain.PaginacionQuery;
import com.hernandezsanchez.dev.helio.common.domain.PaginacionResultado;
import com.hernandezsanchez.dev.helio.subTareas.domain.entity.SubTarea;
import com.hernandezsanchez.dev.helio.subTareas.domain.entity.SubTareaFilter;

import java.util.List;
import java.util.Optional;

public interface SubTareaRepositorio {

    SubTarea upsert(SubTarea subTarea);

    PaginacionResultado<SubTarea> listar(PaginacionQuery paginacionQuery, SubTareaFilter subTareaFilter);

    Optional<SubTarea> buscarPorId(Long id);

    void eliminar(Long id);
}