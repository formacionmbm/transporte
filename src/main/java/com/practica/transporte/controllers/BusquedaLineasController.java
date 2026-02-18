package com.practica.transporte.controllers;



import com.practica.transporte.common.TipoLinea;
import com.practica.transporte.dto.NombreLineaDTO;
import com.practica.transporte.entities.Linea;
import com.practica.transporte.services.LineaService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/b/l")
public class BusquedaLineasController {


    LineaService servicio;
    public BusquedaLineasController(LineaService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public String busquedaPorCodigo(String codigo, Model model) throws ServiceException {
        log.info("[busquedaPorCodigo]");
        log.debug("[codigo:{}]", codigo);

        model.addAttribute("tipos", TipoLinea.values());
        if(codigo==null)
            return "/busqueda/t_linea";


        Linea linea = servicio.busquedaLineaCodigo(codigo);

        log.debug("[Linea:{}]", linea);
        model.addAttribute("linea", linea);

        return "/busqueda/t_linea";
    }

    @GetMapping("/t")
    public String busquedaPorTipo(TipoLinea tipo, Model model) throws ServiceException {
        log.info("[busquedaPorTipo]");
        log.debug("[tipo:{}]", tipo);

        List<Linea> list=servicio.busquedaLineaPorTipo(tipo);

        log.debug("[Linea List:{}]", list);
        model.addAttribute("list", list);

        return "/busqueda/t_linea";
    }




    @PostMapping("/n")
    public String busquedaPorNombre(NombreLineaDTO nombre, Model model) throws ServiceException{
        log.info("[busquedaPorNombre -POST]");
        log.debug("[recibido:{}]",nombre);

        List<Linea> listado = servicio.busquedaPorNombre(nombre.getNombre());
        log.debug("[Linea List:{}]", listado);
        model.addAttribute("listado", listado);
        return "/busqueda/t_linea_nombre";
    }


}