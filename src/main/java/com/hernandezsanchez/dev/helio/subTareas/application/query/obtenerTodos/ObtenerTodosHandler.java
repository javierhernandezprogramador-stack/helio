package com.hernandezsanchez.dev.helio.subTareas.application.query.obtenerTodos;

import com.hernandezsanchez.dev.helio.common.application.mediator.RequestHandler;
import com.hernandezsanchez.dev.helio.common.domain.PaginacionResultado;
import com.hernandezsanchez.dev.helio.subTareas.domain.entity.SubTarea;
import com.hernandezsanchez.dev.helio.subTareas.domain.port.SubTareaRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ObtenerTodosHandler implements RequestHandler<ObtenerTodosRequest, ObtenerTodosResponse> {

    private final SubTareaRepositorio subTareaRepositorio;

    @Override
    public ObtenerTodosResponse handle(ObtenerTodosRequest request) {

        log.info("Iniciando a obtener todas las subTareas en servicio");

        PaginacionResultado<SubTarea> subTareaPaginacionResultado = subTareaRepositorio.listar(request.getPaginacionQuery(), request.getSubTareaFilter());

        log.info("Finalizando de obtener todas las subTareas en servicio");
        return new ObtenerTodosResponse(subTareaPaginacionResultado);
    }

    @Override
    public Class<ObtenerTodosRequest> getRequestType() {
        return ObtenerTodosRequest.class;
    }
}
