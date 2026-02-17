package com.practica.transporte.controllers;

import com.practica.transporte.commons.EstadoCochera;
import com.practica.transporte.entities.Cochera;
import com.practica.transporte.services.exceptions.ServiceException;
import com.practica.transporte.services.interfaces.CocheraService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/inicio")
public class CocheraController {

    @Autowired
    CocheraService servicio;

    // Listado general (el que pide el botón de inicio)
    @GetMapping("/l/c")
    public String findAll(Model model) throws ServiceException {
        log.info("[findAll]");
        List<Cochera> list = servicio.buscarTodos();

        model.addAttribute("listaCocheras", list);
        model.addAttribute("estados", EstadoCochera.values());
        return "t_l_cochera";
    }

    // Listado con filtros (el que dispara el formulario)
    @GetMapping("/r/c")
    public String searchCochera(@RequestParam(required = false) String localidad,
                                @RequestParam(required = false) EstadoCochera estado,
                                Model model) throws ServiceException {
        log.info("[searchCochera]");
        log.debug("[localidad: {}]", localidad);
        log.debug("[estado: {}]", estado);

        List<Cochera> list;

        // Lógica similar a la de la profe:
        // Si hay localidad busca por ella, si no por estado, si no todos.
        if (localidad != null && !localidad.isEmpty()) {
            list = servicio.buscarPorLocalidad(localidad);
        } else if (estado != null) {
            list = servicio.buscarPorEstado(estado);
        } else {
            list = servicio.buscarTodos();
        }

        log.debug("[Cocheras List: {}]", list);
        model.addAttribute("listaCocheras", list);
        model.addAttribute("estados", EstadoCochera.values());

        return "t_l_cochera";
    }
}
