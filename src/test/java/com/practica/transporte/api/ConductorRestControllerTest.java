package com.practica.transporte.api;

import com.practica.transporte.common.EstadoConductor;
import com.practica.transporte.dto.ConductorDTO;
import com.practica.transporte.service.ConductorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(ConductorRestController.class)
class ConductorRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ConductorService conductorService;

    @Test
    void findAll_deberiaRetornarListaConductores() throws Exception {

        ConductorDTO conductor1 = new ConductorDTO(
                1L, "Juan", "Pérez", "EMP001",
                10L, 1, EstadoConductor.ACTIVO);

        ConductorDTO conductor2 = new ConductorDTO(
                2L, "Ana", "García", "EMP002",
                11L, 0, EstadoConductor.VACACIONES);

        when(conductorService.findAll()).thenReturn(List.of(conductor1, conductor2));

        mockMvc.perform(get("/api/v1/conductores"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].estadoConductor").value("ACTIVO"))
                .andExpect(jsonPath("$[1].estadoConductor").value("VACACIONES"));
    }

    @Test
    void findByNumeroEmpleado_deberiaRetornarConductor() throws Exception {

        ConductorDTO conductor = new ConductorDTO(
                1L, "Juan", "Pérez", "EMP001",
                10L, 1, EstadoConductor.BAJA);

        when(conductorService.findByNumeroEmpleado("EMP001"))
                .thenReturn(conductor);

        mockMvc.perform(get("/api/v1/conductores/EMP001"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Juan"))
                .andExpect(jsonPath("$.estadoConductor").value("BAJA"));
    }
}