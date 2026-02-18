package com.practica.transporte.mapper;

import com.practica.transporte.dto.ConductorDTO;
import com.practica.transporte.entities.Conductor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ConductorMapper {
    @Mapping(source = "licencia.id", target = "licenciaId")
    ConductorDTO toDTO(Conductor conductor);
    @Mapping(source = "licenciaId", target = "licencia.id")
    Conductor toEntity(ConductorDTO dto);
}
