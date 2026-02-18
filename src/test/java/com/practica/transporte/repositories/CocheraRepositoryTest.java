package com.practica.transporte.repositories;

import com.practica.transporte.commons.EstadoCochera;
import com.practica.transporte.entities.Cochera;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CocheraRepositoryTest {

    @Autowired
    private CocheraRepository repository;

    @Test
    @DisplayName("Debe guardar una cochera correctamente")
    void save_deberiaGuardarCochera() {

        Cochera cochera = new Cochera(
                null,
                "Central",
                "Calle 1",
                "Madrid",
                100,
                20,
                EstadoCochera.ACTIVA
        );

        Cochera guardada = repository.save(cochera);

        assertNotNull(guardada.getId());
        assertEquals("Central", guardada.getNombre());
    }

    @Test
    @DisplayName("Debe buscar por estado")
    void findByEstado() {

        Cochera c1 = new Cochera(null, "C1", "Dir1", "Madrid", 50, 10, EstadoCochera.ACTIVA);
        Cochera c2 = new Cochera(null, "C2", "Dir2", "Sevilla", 60, 20, EstadoCochera.INACTIVA);

        repository.save(c1);
        repository.save(c2);

        List<Cochera> resultado = repository.findByEstado(EstadoCochera.ACTIVA);

        assertEquals(1, resultado.size());
        assertEquals(EstadoCochera.ACTIVA, resultado.get(0).getEstado());
    }

    @Test
    @DisplayName("Debe buscar por localidad ignorando mayúsculas")
    void findByLocalidadContainingIgnoreCase_deberiaFuncionar() {

        Cochera c1 = new Cochera(null, "C1", "Dir1", "Madrid", 50, 10, EstadoCochera.ACTIVA);

        repository.save(c1);

        List<Cochera> resultado = repository
                .findByLocalidadContainingIgnoreCase("madrid");

        assertFalse(resultado.isEmpty());
        assertEquals("Madrid", resultado.get(0).getLocalidad());
    }
}
