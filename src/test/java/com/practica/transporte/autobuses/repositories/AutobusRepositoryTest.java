package com.practica.transporte.autobuses.repositories;

import com.practica.transporte.autobuses.entities.Autobus;
import com.practica.transporte.autobuses.entities.EstadoAutobus;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;


import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AutobusRepositoryTest {

    private static final Logger log = LoggerFactory.getLogger(AutobusRepositoryTest.class);

    @Autowired
    AutobusRepository repositorio;

    @BeforeAll
    static void antesDeTodos() {
        log.info("[antesDeTodos]");
    }

    @BeforeEach
    void antesDeCadaTest() {
        log.info("[antesDeCadaTest]");

        EstadoAutobus estado = new EstadoAutobus();
        estado.setId(1L);
        estado.setNombre("OPERATIVO");

        Autobus a1 = new Autobus();
        a1.setId(100L);
        a1.setMatricula("1234ABC");
        a1.setBastidor("BAST-001");
        a1.setFlota("URBANA");
        a1.setEstado(estado);

        repositorio.save(a1);
    }

    @Test
    void findByMatricula_ok() {
        log.info("[findByMatricula_ok]");

        Optional<Autobus> opt = repositorio.findByMatricula("1234ABC");

        assertTrue(opt.isPresent());
        assertEquals(100L, opt.get().getId());
        assertEquals("BAST-001", opt.get().getBastidor());
    }

    @Test
    @DisplayName("encontrar por matricula - fallido")
    void findByMatricula_ko() {
        log.info("[findByMatricula_ko]");

        Optional<Autobus> opt = repositorio.findByMatricula("XXXXXXX");

        assertTrue(opt.isEmpty());
    }

    @Test
    void findByMatriculaContainingIgnoreCase_ok() {
        log.info("[findByMatriculaContainingIgnoreCase_ok]");

        List<Autobus> res = repositorio.findByMatriculaContainingIgnoreCase("34");

        // como existe data.sql, puede haber más de 1
        assertTrue(res.size() >= 1);

        // comprobamos que al menos está el que metemos en @BeforeEach
        assertTrue(res.stream().anyMatch(a -> "1234ABC".equals(a.getMatricula())));
    }

    @ParameterizedTest
    @ValueSource(strings = { "abc", "ABC", "aBc" })
    void findByMatriculaContainingIgnoreCase_caseInsensitive_ok(String texto) {
        log.info("[findByMatriculaContainingIgnoreCase_caseInsensitive_ok][texto:{}]", texto);

        List<Autobus> res = repositorio.findByMatriculaContainingIgnoreCase(texto);

        // puede haber más de 1 por data.sql
        assertTrue(res.size() >= 1);

        // sigue teniendo que estar 1234ABC da igual mayúsculas/minúsculas
        assertTrue(res.stream().anyMatch(a -> "1234ABC".equals(a.getMatricula())));
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
