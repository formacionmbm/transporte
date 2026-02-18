package com.practica.transporte.api;

import com.practica.transporte.dto.LineaDTO;
import com.practica.transporte.entities.Linea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import javax.swing.*;


@Mapper(componentModel = Spring)
public interface LineaMapper {
    @Mapping(source = "linea.id", target = "lineaId")
    LineaDTO toDTO(Linea linea);
    @Mapping(source = "lineaId", target = "linea.id")
    Linea toEntity(LineaDTO lineaDTO);
}

