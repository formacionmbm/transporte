package com.practica.transporte.service;

import com.practica.transporte.dto.ConductorDTO;
import com.practica.transporte.entities.Conductor;
import com.practica.transporte.mapper.ConductorMapper;
import com.practica.transporte.repositories.ConductorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ConductorServiceImpl implements ConductorService {

    @Autowired
    private ConductorRepository conductorRepository;

    @Autowired
    private ConductorMapper conductorMapper;

    @Override
    public ConductorDTO findByNumeroEmpleado(String numeroEmpleado) {
        log.info("findByNumeroEmpleado | Recuperando conductor con numEmpleado={}", numeroEmpleado);

        Conductor conductor = conductorRepository.findByNumeroEmpleado(numeroEmpleado)
                .orElseThrow(() -> new RuntimeException(
                        "Conductor no encontrado con numEmpleado: " + numeroEmpleado));

        ConductorDTO dto = conductorMapper.toDTO(conductor);

        log.debug("findByNumeroEmpleado | Conductor encontrado: {}", dto);

        return dto;
    }

    @Override
    public List<ConductorDTO> findAll() {
        log.info("findAll | Recuperando todos los conductores");

        List<ConductorDTO> conductores = conductorRepository.findAll()
                .stream()
                .map(conductorMapper::toDTO)
                .collect(Collectors.toList());

        log.debug("findAll | Resultados: {}", conductores);

        return conductores;
    }
}
