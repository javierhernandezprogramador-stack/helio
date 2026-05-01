package com.hernandezsanchez.dev.helio.tareas.infrastructure.api;

import com.hernandezsanchez.dev.helio.common.application.mediator.Mediator;
import com.hernandezsanchez.dev.helio.common.domain.PaginacionQuery;
import com.hernandezsanchez.dev.helio.common.domain.PaginacionResultado;
import com.hernandezsanchez.dev.helio.tareas.application.command.crear.CrearTareaRequest;
import com.hernandezsanchez.dev.helio.tareas.application.command.crear.CrearTareaResponse;
import com.hernandezsanchez.dev.helio.tareas.application.query.obtenerTareas.ObtenerTareasRequest;
import com.hernandezsanchez.dev.helio.tareas.application.query.obtenerTareas.ObtenerTareasResponse;
import com.hernandezsanchez.dev.helio.tareas.domain.entity.Tarea;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.api.dto.CrearTareaDto;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.api.dto.TareaDto;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.api.mapper.TareaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/tareas")
@RequiredArgsConstructor
@Slf4j
public class TareaController implements TareaAPI{

    private final TareaMapper tareaMapper;

    private final Mediator mediator;


    @PostMapping
    public ResponseEntity<Void> guardar(@RequestBody CrearTareaDto crearTareaDto) {

        log.info("Iniciando petición para guardar");

        CrearTareaRequest request = tareaMapper.mapToCrearTareaRequest(crearTareaDto);

        CrearTareaResponse response = mediator.dispatch(request);

        Tarea tarea = response.getTareaPaginado();

        log.info("Finalizando petición para guardar");

        return ResponseEntity.created(URI.create("/api/v1/tareas/".concat(tarea.getId().toString()))).build();
    }

    @GetMapping
    public ResponseEntity<PaginacionResultado<TareaDto>> listar(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "5") int cantidad,
            @RequestParam(defaultValue = "id") String ordenarPor,
            @RequestParam(defaultValue = "asc") String direccion
    ) {

        log.info("Iniciando petición para listar");

        PaginacionQuery paginacionQuery = new PaginacionQuery(pagina, cantidad, ordenarPor, direccion);

        ObtenerTareasRequest request = new ObtenerTareasRequest(paginacionQuery);

        ObtenerTareasResponse response = mediator.dispatch(request);

        PaginacionResultado<Tarea> tareasPaginacion = response.getTareas();

        PaginacionResultado<TareaDto> resultado = new PaginacionResultado<>(
                tareasPaginacion.getContenido().stream().map(tareaMapper::mapToTareaDto).toList(),
                tareasPaginacion.getPagina(),
                tareasPaginacion.getCantidad(),
                tareasPaginacion.getTotalPaginas(),
                tareasPaginacion.getTotalElementos()
        );

        log.info("Finalizando petición para listar");

        return ResponseEntity.ok(resultado);
    }
}
