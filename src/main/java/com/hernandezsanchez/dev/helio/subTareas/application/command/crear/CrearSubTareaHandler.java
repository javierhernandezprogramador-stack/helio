package com.hernandezsanchez.dev.helio.subTareas.application.command.crear;

import com.hernandezsanchez.dev.helio.common.application.mediator.RequestHandler;
import com.hernandezsanchez.dev.helio.subTareas.domain.entity.SubTarea;
import com.hernandezsanchez.dev.helio.subTareas.domain.port.SubTareaRepositorio;
import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrearSubTareaHandler implements RequestHandler<CrearSubTareaRequest, CrearSubTareaResponse> {

    private final SubTareaRepositorio subTareaRepositorio;

    @Override
    public CrearSubTareaResponse handle(CrearSubTareaRequest request) {

        Tarea tarea = Tarea.builder()
                .id(request.getTarea().getId())
                .build();

        SubTarea subTarea = SubTarea.builder()
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .prioridad(request.getPrioridad())
                .estado(request.getEstado())
                .tarea(tarea)
                .build();

        SubTarea response = subTareaRepositorio.upsert(subTarea);

        CrearSubTareaResponse crearSubTareaResponse = new CrearSubTareaResponse(response);

        return crearSubTareaResponse;
    }

    @Override
    public Class<CrearSubTareaRequest> getRequestType() {
        return CrearSubTareaRequest.class;
    }
}
