package com.practica.transporte.service;

import com.practica.transporte.dto.ConductorDTO;

import java.util.List;

public interface ConductorService {
    ConductorDTO findByNumeroEmpleado(String numeroEmpleado);
    List<ConductorDTO> findAll();
}
