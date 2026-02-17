package com.practica.transporte.controller;

import com.practica.transporte.common.Descuento;
import com.practica.transporte.common.Tipo;
import com.practica.transporte.entity.AbonoTransporte;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@Slf4j
@RequestMapping("/at")
public class ATController {

    @Autowired
    ATService servicio;

    @GetMapping("/buscador")
    public String buscador(@RequestParam(required=false) Tipo tipo,
                           @RequestParam(required=false) Descuento descuento, Model model){
        log.info("[buscador]");
        log.debug("[tipo:{}]",tipo);

        if (tipo==null)
            return "/at/buscador";
        List<AbonoTransporte> list=servicio.busquedaPorTipo(tipo);

        model.addAttribute("list", list);

        return "/buscador/t_buscador";
    }






}
