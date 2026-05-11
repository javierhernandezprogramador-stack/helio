package com.hernandezsanchez.dev.helio.subTareas.domain.port;

import com.hernandezsanchez.dev.helio.subTareas.domain.entity.SubTarea;

import java.util.Optional;

public interface SubTareaRepositorio {

    SubTarea upsert(SubTarea subTarea);

    Optional<SubTarea> buscarPorId(Long id);

    void eliminar(Long id);
}