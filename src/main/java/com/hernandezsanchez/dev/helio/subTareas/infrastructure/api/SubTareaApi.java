package com.hernandezsanchez.dev.helio.subTareas.infrastructure.api;

import com.hernandezsanchez.dev.helio.common.domain.PaginacionResultado;
import com.hernandezsanchez.dev.helio.subTareas.infrastructure.api.dto.CrearSubTareaDto;
import com.hernandezsanchez.dev.helio.subTareas.infrastructure.api.dto.ModificarSubTareaDto;
import com.hernandezsanchez.dev.helio.subTareas.infrastructure.api.dto.SubTareaDto;
import org.springframework.http.ResponseEntity;

public interface SubTareaApi {

    ResponseEntity<Void> guardar(CrearSubTareaDto crearSubTareaDto);

    ResponseEntity<PaginacionResultado<SubTareaDto>> listar(int pagina, int cantidad, String ordenarPor, String direccion, Long idTarea);

    ResponseEntity<Void> modificar(ModificarSubTareaDto modificarSubTareaDto);

    ResponseEntity<Void> eliminar(Long id);
}
