package com.practica.transporte.controllers.api;

import com.practica.transporte.entities.Parada;
import com.practica.transporte.services.ParadaService;
import com.practica.transporte.services.exception.ServiceException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/paradas")
public class ParadaRestController {
    private final ParadaService service;

    public ParadaRestController(ParadaService service) {
        this.service = service;
    }


    @GetMapping("/{numero}")
    public Parada obtenerParada(@PathVariable int numero) throws ServiceException {
        return service.buscarPorNumero(numero);
    }


    @PostMapping
    public Parada crearParada(@RequestBody Parada parada) {
        return service.guardarParada(parada);
    }
}
