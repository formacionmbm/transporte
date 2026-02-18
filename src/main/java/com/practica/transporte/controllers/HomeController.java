package com.practica.transporte.controllers;

import com.practica.transporte.services.exceptions.ServiceException;
import com.practica.transporte.services.interfaces.CocheraService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    CocheraService servicio;

    @GetMapping("/inicio")
    public String showHome(Model model) throws ServiceException {
        log.info("[showHome]");
        return "t_inicio";
    }
}