package com.practica.transporte.api;

import com.practica.transporte.entities.Cochera;
import com.practica.transporte.services.exceptions.ServiceException;
import com.practica.transporte.services.interfaces.CocheraService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api")
public class CocheraRestController {

    @Autowired
    CocheraService servicio;

    @GetMapping("/l/c")
    public List<Cochera> findAll() throws ServiceException {
        log.info("[findAll]");
        List<Cochera> lista = servicio.buscarTodos();
        log.debug("[Cocheras list: {}]", lista);
        return lista;
    }

    @GetMapping("/l/c/{loc}")
    public List<Cochera> findCocherasByLocalidad(@PathVariable(name="loc") String localidad) throws ServiceException {
        log.info("[findCocherasByLocalidad]");
        log.debug("[localidad:{}]", localidad);

        List<Cochera> list = servicio.buscarPorLocalidad(localidad);
        log.debug("[Cocheras lista por localidad:{}", list);

        return list;
    }
}