package com.hernandezsanchez.dev.helio.subTareas.application.command.modificar;

import com.hernandezsanchez.dev.helio.common.application.mediator.RequestHandler;
import com.hernandezsanchez.dev.helio.subTareas.domain.entity.SubTarea;
import com.hernandezsanchez.dev.helio.subTareas.domain.port.SubTareaRepositorio;
import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ModificarSubTareaHandler implements RequestHandler<ModificarSubTareaRequest, ModificarSubTareaResponse> {

    private final SubTareaRepositorio subTareaRepositorio;

    @Override
    public ModificarSubTareaResponse handle(ModificarSubTareaRequest request) {

        Tarea tarea = Tarea.builder()
                .id(request.getTarea().getId())
                .build();

        SubTarea subTarea = SubTarea.builder()
                .id(request.getId())
                .nombre(request.getNombre())
                .descripcion(request.getDescripcion())
                .prioridad(request.getPrioridad())
                .estado(request.getEstado())
                .tarea(tarea)
                .build();

        SubTarea response = subTareaRepositorio.upsert(subTarea);

        return new ModificarSubTareaResponse(response);
    }

    @Override
    public Class<ModificarSubTareaRequest> getRequestType() {
        return ModificarSubTareaRequest.class;
    }
}
