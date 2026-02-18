package com.practica.transporte.api;


import com.practica.transporte.common.TipoLinea;
import com.practica.transporte.dto.LineaDTO;
import com.practica.transporte.dto.NombreLineaDTO;
import com.practica.transporte.entities.Linea;
import com.practica.transporte.repositories.LineaRepository;
import com.practica.transporte.services.LineaService;
import com.practica.transporte.services.exceptions.LineaNotFoundException;
import com.practica.transporte.services.exceptions.ServicesUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Service
@Slf4j
public class BusquedasLineasRestController {

    @Autowired
    LineaService lineaService;

    @GetMapping("/{code}")
    public LineaDTO findByCodigo(@PathVariable(name="codigo") String codigo) throws ServiceException {
        log.info("[findByCodigo]",codigo);
        log.debug("[codigo:{}]", codigo);
        return lineaService.busquedaLineaCodigo(codigo);
    }


    @GetMapping("/tipo/{tipo}")
    public List<LineaDTO> findByTipo(@PathVariable TipoLinea tipo) throws ServiceException {
        log.info("[findByTipo]");
        log.debug("[tipo:{}]", tipo);
        return lineaService.busquedaLineaPorTipo(tipo);
    }


    @GetMapping("/buscar")
    public List<LineaDTO> findByNombre(NombreLineaDTO nombreDTO) throws ServiceException {
        log.info("[findByNombre]");
        log.debug("[nombreDTO:{}]", nombreDTO);
        return lineaService.busquedaPorNombre(nombreDTO);
    }
}


