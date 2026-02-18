package com.practica.transporte.controller;

import com.practica.transporte.dto.ConductorDTO;
import com.practica.transporte.service.ConductorService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/buscador")
public class ConductorController {

    @Autowired
    ConductorService service;

    @GetMapping("/numEmple")
    public String buscarPorNumEmple(@RequestParam String numEmple, Model model) throws ServiceException {
        log.info("[buscarPorNumEmple]");
        log.debug("[numEmple:{}]", numEmple);

        ConductorDTO conductorDTO = service.findByNumeroEmpleado(numEmple);

        log.debug("[ConductorDTO:{}]", conductorDTO);
        model.addAttribute("conductorDTO", conductorDTO);
        model.addAttribute("numEmple", numEmple);

        return "t_buscador_conductores";
    }

    @GetMapping
    public String findAll(Model model) throws ServiceException {
        log.info("[findAll]");
        List<ConductorDTO> list = service.findAll();
        log.debug("[Lista de Conductores:{}]", list);
        model.addAttribute("list", list);
        return "t_buscador_conductores";
    }
}
