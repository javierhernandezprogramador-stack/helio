package com.hernandezsanchez.dev.helio.subTareas.application.command.eliminar;

import com.hernandezsanchez.dev.helio.common.application.mediator.RequestHandler;
import com.hernandezsanchez.dev.helio.subTareas.domain.entity.SubTarea;
import com.hernandezsanchez.dev.helio.subTareas.domain.port.SubTareaRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EliminarSubTareaHandler implements RequestHandler<EliminarSubTareaRequest, Void> {

    private final SubTareaRepositorio subTareaRepositorio;

    @Override
    public Void handle(EliminarSubTareaRequest request) {

        log.info("Iniciando eliminación de subTarea en servicio: {}", request.getId());

        SubTarea subTarea = SubTarea.builder()
                .id(request.getId())
                .build();

        Optional<SubTarea> optionalSubTarea = subTareaRepositorio.buscarPorId(subTarea.getId());

        if(optionalSubTarea.isPresent()) {
            subTareaRepositorio.eliminar(subTarea.getId());
        }

        log.info("Finalizando eliminación de subTarea en servicio: {}", request.getId());

        return null;
    }

    @Override
    public Class<EliminarSubTareaRequest> getRequestType() {
        return EliminarSubTareaRequest.class;
    }
}
