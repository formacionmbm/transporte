package com.practica.transporte.autobuses.services;

import com.practica.transporte.autobuses.entities.Autobus;
import com.practica.transporte.autobuses.repositories.AutobusRepository;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ServicioBuscadoresImplTest {

    private static final Logger log = LoggerFactory.getLogger(ServicioBuscadoresImplTest.class);

    AutobusRepository repositorio;
    ServicioBuscadoresImpl servicio;

    @BeforeAll
    static void antesDeTodos() {
        log.info("[antesDeTodos]");
    }

    @BeforeEach
    void antesDeCadaTest() {
        log.info("[antesDeCadaTest]");
        repositorio = Mockito.mock(AutobusRepository.class);
        servicio = new ServicioBuscadoresImpl(repositorio);
    }

    @Test
    void buscarAutobuses_matriculaVacia_devuelveAll_ok() {
        log.info("[buscarAutobuses_matriculaVacia_devuelveAll_ok]");

        when(repositorio.findAll()).thenReturn(List.of(new Autobus()));

        List<Autobus> res = servicio.buscarAutobuses("   ");

        assertEquals(1, res.size());
        verify(repositorio, times(1)).findAll();
        verify(repositorio, never()).findByMatriculaContainingIgnoreCase(anyString());
    }

    @Test
    void buscarAutobuses_matriculaConValor_filtra_ok() {
        log.info("[buscarAutobuses_matriculaConValor_filtra_ok]");

        Autobus a = new Autobus();
        a.setId(100L);
        a.setMatricula("1234ABC");

        when(repositorio.findByMatriculaContainingIgnoreCase("123")).thenReturn(List.of(a));

        List<Autobus> res = servicio.buscarAutobuses("123");

        assertEquals(1, res.size());
        assertEquals(100L, res.get(0).getId());
        verify(repositorio, times(1)).findByMatriculaContainingIgnoreCase("123");
        verify(repositorio, never()).findAll();
    }

    @AfterEach
    void despuesDeCadaTest() {
        log.info("[despuesDeCadaTest]");
    }

    @AfterAll
    static void despuesDeTodos() {
        log.info("[despuesDeTodos]");
    }
}
