package com.hernandezsanchez.dev.helio.tareas.application.command.modificar;

import com.hernandezsanchez.dev.helio.common.application.mediator.RequestHandler;
import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;
import com.hernandezsanchez.dev.helio.tareas.domain.port.TareaRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ModificarTareaHandler implements RequestHandler<ModificarTareaRequest, ModificarTareaResponse> {

    private final TareaRepositorio tareaRepositorio;

    @Override
    public ModificarTareaResponse handle(ModificarTareaRequest request) {

        log.info("Inicio modificación de tarea en servicio");

        Tarea tarea = Tarea.builder().
                id(request.getId())
                .nombre(request.getNombre())
                .estado(request.getEstado()).build();

        Tarea tareaRespuesta = tareaRepositorio.upsert(tarea);

        ModificarTareaResponse respuesta = new ModificarTareaResponse(tareaRespuesta);

        log.info("Finalizando modificación de tarea en servicio");

        return respuesta;
    }

    @Override
    public Class<ModificarTareaRequest> getRequestType() {
        return ModificarTareaRequest.class;
    }
}
