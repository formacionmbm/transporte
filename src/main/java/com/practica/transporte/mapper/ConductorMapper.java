package com.practica.transporte.mapper;

import com.practica.transporte.dto.ConductorDTO;
import com.practica.transporte.entities.Conductor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConductorMapper {
    ConductorDTO toDTO(Conductor conductor);

    Conductor toEntity(ConductorDTO dto);
}
