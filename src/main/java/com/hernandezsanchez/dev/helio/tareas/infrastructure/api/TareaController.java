package com.hernandezsanchez.dev.helio.tareas.infrastructure.api;

import com.hernandezsanchez.dev.helio.common.application.mediator.Mediator;
import com.hernandezsanchez.dev.helio.tareas.application.command.crear.CrearTareaRequest;
import com.hernandezsanchez.dev.helio.tareas.application.command.crear.CrearTareaResponse;
import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.api.dto.CrearTareaDto;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.api.mapper.TareaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/tareas")
@RequiredArgsConstructor
public class TareaController {

    private final TareaMapper tareaMapper;

    private final Mediator mediator;

    @PostMapping
    public ResponseEntity<Void> guardar(CrearTareaDto crearTareaDto) {

        CrearTareaRequest request = tareaMapper.mapToCrearTareaRequest(crearTareaDto);

        CrearTareaResponse response = mediator.dispatch(request);

        Tarea tarea = response.getTareaPaginado();

        return ResponseEntity.created(URI.create("/api/v1/tareas/".concat(tarea.getId().toString()))).build();
    }
}
