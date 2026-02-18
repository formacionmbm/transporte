package com.practica.transporte.autobuses.controllers;

import com.practica.transporte.autobuses.entities.Autobus;
import com.practica.transporte.autobuses.services.interfaces.ServicioBuscadores;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/buscador/autobuses")
@Slf4j

public class BuscadorAutobusesController {

    @Autowired
    ServicioBuscadores servicio;

    @GetMapping
    public String buscador(@RequestParam(required = false) String matricula, Model model){
        log.info("[buscador]");
        log.debug("[matricula:{}]", matricula);

        List<Autobus> autobuses = servicio.buscarAutobuses(matricula);

        model.addAttribute("listado", autobuses);
        model.addAttribute("matricula", matricula); // para que el input se quede con lo escrito

        return "buscadores/t_b_autobuses";
    }

}
