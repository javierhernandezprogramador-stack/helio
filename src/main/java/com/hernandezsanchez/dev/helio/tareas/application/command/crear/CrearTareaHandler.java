package com.hernandezsanchez.dev.helio.tareas.application.command.crear;

import com.hernandezsanchez.dev.helio.common.application.mediator.RequestHandler;
import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;
import com.hernandezsanchez.dev.helio.tareas.domain.port.TareaRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrearTareaHandler implements RequestHandler<CrearTareaRequest, CrearTareaResponse> {

    private final TareaRepositorio tareaRepositorio;

    @Override
    public CrearTareaResponse handle(CrearTareaRequest request) {

        Tarea tarea = Tarea.builder()
                .nombre(request.getNombre())
                .estado(request.getEstado())
                .build();

        Tarea respuesta = tareaRepositorio.upsert(tarea);

        return new CrearTareaResponse(respuesta);
    }

    @Override
    public Class<CrearTareaRequest> getRequestType() {
        return CrearTareaRequest.class;
    }
}
