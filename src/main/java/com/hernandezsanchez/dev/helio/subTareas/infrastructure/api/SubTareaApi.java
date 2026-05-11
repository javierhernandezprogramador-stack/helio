package com.hernandezsanchez.dev.helio.subTareas.infrastructure.api;

import com.hernandezsanchez.dev.helio.subTareas.infrastructure.api.dto.CrearSubTareaDto;
import com.hernandezsanchez.dev.helio.subTareas.infrastructure.api.dto.ModificarSubTareaDto;
import org.springframework.http.ResponseEntity;

public interface SubTareaApi {

    ResponseEntity<Void> guardar(CrearSubTareaDto crearSubTareaDto);

    ResponseEntity<Void> modificar(ModificarSubTareaDto modificarSubTareaDto);

    ResponseEntity<Void> eliminar(Long id);
}
