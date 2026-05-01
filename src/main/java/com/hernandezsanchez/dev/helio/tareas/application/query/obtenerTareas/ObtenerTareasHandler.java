package com.hernandezsanchez.dev.helio.tareas.application.query.obtenerTareas;

import com.hernandezsanchez.dev.helio.common.application.mediator.RequestHandler;
import com.hernandezsanchez.dev.helio.common.domain.PaginacionQuery;
import com.hernandezsanchez.dev.helio.common.domain.PaginacionResultado;
import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;
import com.hernandezsanchez.dev.helio.tareas.domain.port.TareaRepositorio;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ObtenerTareasHandler implements RequestHandler<ObtenerTareasRequest, ObtenerTareasResponse> {

    private final TareaRepositorio tareaRepositorio;

    @Override
    public ObtenerTareasResponse handle(ObtenerTareasRequest request) {

        log.info("Iniciando a obtener todas las tareas en servicio");

        PaginacionQuery paginacionQuery = request.getPaginacionQuery();

        PaginacionResultado<Tarea> paginacionResultado = tareaRepositorio.obtenerTodos(paginacionQuery);

        ObtenerTareasResponse obtenerTareasResponse = new ObtenerTareasResponse(paginacionResultado);

        log.info("Finalizando de obtener todas las tareas en servicio");

        return obtenerTareasResponse;
    }

    @Override
    public Class<ObtenerTareasRequest> getRequestType() {
        return ObtenerTareasRequest.class;
    }
}
