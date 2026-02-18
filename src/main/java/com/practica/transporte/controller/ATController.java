package com.practica.transporte.controller;

import com.practica.transporte.common.Billete;
import com.practica.transporte.common.Descuento;
import com.practica.transporte.common.Tipo;
import com.practica.transporte.common.Validez;
import com.practica.transporte.entity.AbonoTransporte;
import com.practica.transporte.service.ATService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/at")
public class ATController {

    @Autowired
    ATService servicio;

    @GetMapping("/buscador")
    public String buscador(@RequestParam(required=false) Tipo tipo
                           , Model model){
        log.info("[buscador]");
        log.debug("[tipo:{}]",tipo);

        if (tipo==null) {
            List<AbonoTransporte> list = servicio.listarTodas();
            model.addAttribute("list", list);
            return "t_listado";
        }
        List<AbonoTransporte> listTipo=servicio.buscarPorTipo(tipo);

        model.addAttribute("listTipo", listTipo);

        return "t_listado";
    }



    @GetMapping("/form_at")
    public String mostrarFormularioAT(@PathVariable(required = false) Integer id, Model model) {
        log.info("[mostrarFormularioAT]");
        log.debug("[id: {}]", id);

        if (id != null){
            Optional<AbonoTransporte> atExistente=servicio.buscarPorId(id);
            log.debug("[abonotrasporte: {}]",atExistente);
            model.addAttribute("at", atExistente);
        }else {
            model.addAttribute("at", new AbonoTransporte());
        }
        model.addAttribute("tipos", Tipo.values());
        model.addAttribute("billetes", Billete.values());
        model.addAttribute("descuentos", Descuento.values());
        model.addAttribute("validez", Validez.values());

        return "/t_formcrear";
    }

    @PostMapping
    public String crear(AbonoTransporte ab) {
        log.info("[crear]");
        log.debug("[abonotrasporte: {}]",ab);

        servicio.crearAbono(ab);

        return "redirect:/form_at/" + ab.getId();
    }



}
