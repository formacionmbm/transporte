package com.practica.transporte.controller.api;

import com.practica.transporte.common.Tipo;
import com.practica.transporte.common.TipoDescuento;
import com.practica.transporte.entity.AbonoTransporte;
import com.practica.transporte.service.interfaces.ATService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
@RequestMapping ("/api")
public class ATRestController {

    private final ATService atService;

    public ATRestController(ATService atService) {
        this.atService = atService;
    }

    //GET ("/api/listar")
    @GetMapping("/tlistar")
    public List<AbonoTransporte> listarTodoAT() {
        log.info("[listarTodoAT]");
        return atService.listarTodas();
    }

    //GET ("/api/abonos/{id}")
    @GetMapping ("/id/{id}")
    public AbonoTransporte obtenerPorId(@PathVariable int id) {
        log.info("[obtenerPorId]");
        return atService.buscarPorId(id);
    }

    //GET ("/api/abonos/{tipo}")
    @GetMapping ("/tipo/{tipo}")
    public List<AbonoTransporte> obtenerPorTipo(@PathVariable Tipo tipo ) {
        log.info("[obtenerPorTipo]");
        return atService.buscarPorTipo(tipo);

    }

    //GET ("/api/abonos/{descuento}")
    @GetMapping ("/descuento/{descuento}")
    public List<AbonoTransporte> obtenerPorDescuento(@PathVariable TipoDescuento tipodescuento ) {
        log.info("[obtenerPorDescuento]");
        return atService.buscarPorDescuento(tipodescuento);

    }

    //POST ("/api/abonos")
    @PostMapping
    public void abonoCreado(@PathVariable AbonoTransporte abono) {
        log.info("[abonoCreado]");
        atService.crearAbono(abono);
    }

}



