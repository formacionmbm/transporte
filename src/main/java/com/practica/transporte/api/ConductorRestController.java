package com.practica.transporte.api;

import com.practica.transporte.dto.ConductorDTO;
import com.practica.transporte.service.ConductorService;
import com.practica.transporte.service.ConductorServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/v1")

public class ConductorRestController {

    @Autowired
    ConductorService conductorService;

    @GetMapping("/conductores")
    public List<ConductorDTO> findAll() {
        log.info("[findAll]-Obteniendo lista de conductores");
        List<ConductorDTO> listaDTO = conductorService.findAll();
        log.debug("[findAll]-Lista de Conductores {}",listaDTO);
        return listaDTO;
    }

    @GetMapping("/conductores/{numEmple}")
    public ConductorDTO findByNumeroEmpleado(@PathVariable(name="numEmple") String numEmpleado) {
        log.info("[findByNumeroEmpleado]-Obteniendo lista de conductores");
        ConductorDTO conductorDTO = conductorService.findByNumeroEmpleado(numEmpleado);
        log.debug("[findByNumeroEmpleado]-Conductor: {}", conductorDTO);
        return conductorDTO;
    }

}
