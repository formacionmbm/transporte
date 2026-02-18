package com.practica.transporte.controllers;

import com.practica.transporte.entities.Parada;
import com.practica.transporte.services.interfaces.Busquedas;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import javax.swing.*;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(ParadaController.class)
@Slf4j
public class BusquedaParadaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private Busquedas servicio;

    @Test
    void busquedaPorNumeroParada_conNumeroParada() throws Exception{
        log.info("busquedaPorNumeroParada_conNumeroParada");
        Parada parada = new Parada();
        parada.setNumeroParada(101);

        when(servicio.busquedaParadaPorNumero(101)).thenReturn(parada);

        mockMvc.perform(get("/b/f").param("numeroParada","101"))
                .andExpect(status().isOk())
                .andExpect(view().name("/busqueda/parada"));


    }


}
