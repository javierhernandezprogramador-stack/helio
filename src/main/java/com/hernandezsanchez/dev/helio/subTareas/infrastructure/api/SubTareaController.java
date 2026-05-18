package com.hernandezsanchez.dev.helio.subTareas.infrastructure.api;

import com.hernandezsanchez.dev.helio.common.application.mediator.Mediator;
import com.hernandezsanchez.dev.helio.common.domain.PaginacionQuery;
import com.hernandezsanchez.dev.helio.common.domain.PaginacionResultado;
import com.hernandezsanchez.dev.helio.subTareas.application.command.crear.CrearSubTareaRequest;
import com.hernandezsanchez.dev.helio.subTareas.application.command.crear.CrearSubTareaResponse;
import com.hernandezsanchez.dev.helio.subTareas.application.command.eliminar.EliminarSubTareaRequest;
import com.hernandezsanchez.dev.helio.subTareas.application.command.modificar.ModificarSubTareaRequest;
import com.hernandezsanchez.dev.helio.subTareas.application.command.modificar.ModificarSubTareaResponse;
import com.hernandezsanchez.dev.helio.subTareas.application.query.obtenerTodos.ObtenerTodosRequest;
import com.hernandezsanchez.dev.helio.subTareas.application.query.obtenerTodos.ObtenerTodosResponse;
import com.hernandezsanchez.dev.helio.subTareas.domain.entity.SubTarea;
import com.hernandezsanchez.dev.helio.subTareas.domain.entity.SubTareaFilter;
import com.hernandezsanchez.dev.helio.subTareas.infrastructure.api.dto.CrearSubTareaDto;
import com.hernandezsanchez.dev.helio.subTareas.infrastructure.api.dto.ModificarSubTareaDto;
import com.hernandezsanchez.dev.helio.subTareas.infrastructure.api.dto.SubTareaDto;
import com.hernandezsanchez.dev.helio.subTareas.infrastructure.api.mapper.SubTareaMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1/subtareas")
@RequiredArgsConstructor
@Slf4j
public class SubTareaController implements SubTareaApi {

    private final SubTareaMapper subTareaMapper;

    private final Mediator mediator;

    @PostMapping
    @Override
    public ResponseEntity<Void> guardar(@RequestBody CrearSubTareaDto crearSubTareaDto) {

        log.info("Iniciando petición para guardar subTarea");

        CrearSubTareaRequest request = subTareaMapper.mapToCrearSubTareaRequest(crearSubTareaDto);

        CrearSubTareaResponse response = mediator.dispatch(request);

        log.info("finalizando petición para guardar subTarea");

        return ResponseEntity.created(URI.create("/api/v1/subtareas/".concat(response.getSubTareaPaginado().getId().toString()))).build();
    }

    @GetMapping
    @Override
    public ResponseEntity<PaginacionResultado<SubTareaDto>> listar(
            @RequestParam(defaultValue = "0") int pagina,
            @RequestParam(defaultValue = "5") int cantidad,
            @RequestParam(defaultValue = "id") String ordenarPor,
            @RequestParam(defaultValue = "asc") String direccion,
            @RequestParam(required = true) Long idTarea) {

        PaginacionQuery paginacionQuery = new PaginacionQuery(pagina, cantidad, ordenarPor, direccion);

        SubTareaFilter subTareaFilter = new SubTareaFilter(idTarea);

        ObtenerTodosRequest request = new ObtenerTodosRequest(paginacionQuery, subTareaFilter);

        ObtenerTodosResponse response = mediator.dispatch(request);

        PaginacionResultado<SubTarea> subTareaPaginacionResultado = response.getSubTareas();

        PaginacionResultado<SubTareaDto> subTareaDtoPaginacionResultado = new PaginacionResultado<>(
                subTareaPaginacionResultado.getContenido().stream().map(subTareaMapper::mapToSubTareaDto).toList(),
                subTareaPaginacionResultado.getPagina(),
                subTareaPaginacionResultado.getCantidad(),
                subTareaPaginacionResultado.getTotalPaginas(),
                subTareaPaginacionResultado.getTotalElementos()
        );

        return ResponseEntity.ok(subTareaDtoPaginacionResultado);
    }

    @PutMapping
    @Override
    public ResponseEntity<Void> modificar(@RequestBody ModificarSubTareaDto modificarSubTareaDto) {

        log.info("Iniciando petición para modificar subTarea");

        ModificarSubTareaRequest request = subTareaMapper.mapToModificarSubTareaRequest(modificarSubTareaDto);

        ModificarSubTareaResponse response = mediator.dispatch(request);

        log.info("Finalizando petición para modificar subTarea");

        return ResponseEntity.created(URI.create("/api/v1/subtareas/".concat(response.getSubtTareaPaginacion().getId().toString()))).build();
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        log.info("Iniciando petición para eliminar subTarea");

        mediator.dispatchAsync(new EliminarSubTareaRequest(id));

        log.info("Finalizando petición para eliminar subTarea");

        return ResponseEntity.accepted().build();
    }

}
