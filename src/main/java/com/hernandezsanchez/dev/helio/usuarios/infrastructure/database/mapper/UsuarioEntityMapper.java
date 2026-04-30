package com.hernandezsanchez.dev.helio.usuarios.infrastructure.database.mapper;

import com.hernandezsanchez.dev.helio.usuarios.domain.entity.Usuario;
import com.hernandezsanchez.dev.helio.usuarios.infrastructure.database.entity.UsuarioEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface UsuarioEntityMapper {
    UsuarioEntity mapToUsuarioEntity(Usuario usuario);

    Usuario mapToUsuario(UsuarioEntity usuarioEntity);
}
