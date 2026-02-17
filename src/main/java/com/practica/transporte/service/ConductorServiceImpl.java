package com.practica.transporte.service;

import com.practica.transporte.dto.ConductorDTO;
import com.practica.transporte.repositories.ConductorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ConductorServiceImpl implements ConductorService {
    @Autowired
    private ConductorRepository conductorRepository;

    @Override
    public ConductorDTO findByNumeroEmpleado(String numeroEmpleado) {
        log.info("findByNumeroEmpleado | Recuperando conductor");
        Optional conductor = conductorRepository.findByNumeroEmpleado(numeroEmpleado);

        log.debug("findByNumeroEmpleado | Iniciando conductor por numeroEmpleado {}", numeroEmpleado);

        return null;
    }

    @Override
    public List<ConductorDTO> findAll() {
        log.info("findAll | Recuperando todos los conductores");
        return List.of();
    }
}
