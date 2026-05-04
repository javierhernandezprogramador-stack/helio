package com.hernandezsanchez.dev.helio.tareas.application.command.eliminar;

import com.hernandezsanchez.dev.helio.common.application.mediator.RequestHandler;
import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;
import com.hernandezsanchez.dev.helio.tareas.domain.port.TareaRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EliminarTareaHandler implements RequestHandler<EliminarTareaRequest, Void> {

    private final TareaRepositorio tareaRepositorio;

    @Override
    public Void handle(EliminarTareaRequest request) {

        log.info("Iniciando eliminación de tarea con id: " + request.getId());

        Optional<Tarea> optionalTarea = tareaRepositorio.porId(request.getId());

        if(optionalTarea.isPresent()) {
            tareaRepositorio.eliminar(request.getId());
        }

        log.info("Finalizando eliminación de tarea con id: " + request.getId());

        return null;
    }

    @Override
    public Class<EliminarTareaRequest> getRequestType() {
        return EliminarTareaRequest.class;
    }
}
