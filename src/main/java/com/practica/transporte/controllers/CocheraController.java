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
public class CocheraController {
    @Autowired
    CocheraService servicio;

    @GetMapping("/inicio")
    public String showHome(Model model) throws ServiceException {

        log.info("[showHome]");
        return "t_inicio";

    }

    @GetMapping("/l/c")
    public String buscadorCochera(@RequestParam(required=false)String localidad,
                                  @RequestParam(required=false)String codigoPostal,
                                  @RequestParam(required=false)String nombre,
                                  @RequestParam(required=false)EstadoCochera estado,
                                  Model model) throws ServiceException {
        log.info("[buscadorCochera]");
        List<Cochera> list = servicio.buscarTodos();
        if (nombre != null && !nombre.isEmpty()) {
            list = servicio.buscarPorNombre(nombre);
        }else if (localidad != null && !localidad.isEmpty()) {
            list = servicio.buscarPorLocalidad(localidad);
        } else if (estado != null) {
            list = servicio.buscarPorEstado(estado);
        } else if (codigoPostal != null && !codigoPostal.isEmpty()) {
            list = servicio.buscarPorCodigoPostal(codigoPostal);
        }
        model.addAttribute("listaCocheras", list);
        return "t_l_cochera";
    }


@GetMapping("/r/c")
public String mostrarFormularioRegistro(Model model) {
    log.info("[mostrarFormularioRegistro]");
    model.addAttribute("estados", EstadoCochera.values());
    return "t_r_cochera";
}

@PostMapping("/r/c")
public String guardarNuevaCochera(Cochera cochera) throws ServiceException {
    log.info("[guardarNuevaCochera]:{}", cochera);
    servicio.crearCochera(cochera);
    return "redirect:/l/c";
}
}
