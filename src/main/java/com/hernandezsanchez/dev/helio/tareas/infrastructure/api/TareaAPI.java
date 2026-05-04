package com.hernandezsanchez.dev.helio.tareas.infrastructure.api;

import com.hernandezsanchez.dev.helio.common.domain.PaginacionResultado;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.api.dto.CrearTareaDto;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.api.dto.ModificarTareaDto;
import com.hernandezsanchez.dev.helio.tareas.infrastructure.api.dto.TareaDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface TareaAPI {

    ResponseEntity<Void> guardar(@RequestBody CrearTareaDto crearTareaDto);

    ResponseEntity<PaginacionResultado<TareaDto>> listar(int pagina, int cantidad, String ordenarPor, String direccion);

    ResponseEntity<Void> modificar(@RequestBody ModificarTareaDto modificarTareaDto);

    ResponseEntity<Void> eliminar(@PathVariable Long id);
}
