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
@Slf4j
@RequestMapping("/api/lineas")
public class BusquedasLineasRestController {

    @Autowired
    LineaService lineaService;

    @GetMapping("/{code}")
    public LineaDTO busquedaPorCodigo(@PathVariable(name="codigo") String codigo) throws ServiceException {
        log.info("[busquedaPorCodigo]",codigo);
        log.debug("[codigo:{}]", codigo);
        return lineaService.busquedaLineaCodigo(codigo);
    }


    @GetMapping("/tipo/{tipo}")
    public List<LineaDTO> busquedaporTipo(@PathVariable TipoLinea tipo) throws ServiceException {
        log.info("[busquedaporTipo]");
        log.debug("[tipo:{}]", tipo);
        return lineaService.busquedaLineaPorTipo(tipo);
    }


    @GetMapping("/buscar")
    public List<LineaDTO> busquedaPorNombre(NombreLineaDTO nombreDTO) throws ServiceException {
        log.info("[busquedaPorNombre]");
        log.debug("[nombreDTO:{}]", nombreDTO);
        return lineaService.busquedaPorNombre(nombreDTO);
    }
}


}

