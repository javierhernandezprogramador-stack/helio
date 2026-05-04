package com.hernandezsanchez.dev.helio.tareas.application.command.crear;

import com.hernandezsanchez.dev.helio.common.application.mediator.RequestHandler;
import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;
import com.hernandezsanchez.dev.helio.tareas.domain.port.TareaRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CrearTareaHandler implements RequestHandler<CrearTareaRequest, CrearTareaResponse> {

    private final TareaRepositorio tareaRepositorio;

    @Override
    public CrearTareaResponse handle(CrearTareaRequest request) {

        log.info("Iniciando almacenamiento de tarea en servicio");

        Tarea tarea = Tarea.builder()
                .nombre(request.getNombre())
                .estado(request.getEstado())
                .build();

        if(!tareaRepositorio.porId(tarea.getId()).isPresent()) {
            return null;
        }

        Tarea respuesta = tareaRepositorio.upsert(tarea);

        log.info("Finalizando almacenamiento de tarea en servicio");

        return new CrearTareaResponse(respuesta);
    }

    @Override
    public Class<CrearTareaRequest> getRequestType() {
        return CrearTareaRequest.class;
    }
}
