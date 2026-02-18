package com.practica.transporte.controllers;

import com.practica.transporte.entities.Parada;
import com.practica.transporte.services.exception.ServiceException;
import com.practica.transporte.services.interfaces.Busquedas;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequestMapping("/b/f")
public class ParadaController {

    @Autowired
    Busquedas servicio;

    @GetMapping
    public String busquedaParadaPorNumero(@RequestParam int numeroParada, Model model)throws ServiceException{
        log.info("[busquedaParadaPorNumero]");
        log.debug("[numeroParada:{}]",numeroParada);

        Parada parada = servicio.busquedaParadaPorNumero(numeroParada);

        log.debug("[Parada]:{}",parada);
        model.addAttribute("parada",parada);

        return "/busqueda/parada";
    }


}
