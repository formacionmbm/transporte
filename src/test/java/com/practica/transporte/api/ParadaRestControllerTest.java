package com.practica.transporte.api;

import com.practica.transporte.controllers.api.ParadaRestController;
import com.practica.transporte.entities.Parada;
import com.practica.transporte.services.ParadaService;
import com.practica.transporte.services.exception.ServiceException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ParadaRestControllerTest {

    @Mock
    private ParadaService service;

    @InjectMocks
    private ParadaRestController controller;

    @Test
    void obtenerParada_ok() throws ServiceException {
        Parada p = new Parada();
        p.setNumeroParada(101);
        p.setNombre("Oporto");

        when(service.buscarPorNumero(101)).thenReturn(p);

        Parada resultado = controller.obtenerParada(101);

        assertThat(resultado.getNombre()).isEqualTo("Oporto");
        assertThat(resultado.getNumeroParada()).isEqualTo(101);
    }

    @Test
    void obtenerParada_ko() throws ServiceException {

        when(service.buscarPorNumero(999))
                .thenThrow(new ServiceException("No existe"));

        assertThrows(ServiceException.class, () -> {
            controller.obtenerParada(999);
        });
    }
}