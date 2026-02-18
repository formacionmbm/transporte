package com.practica.transporte.services;

import com.practica.transporte.entities.Parada;
import com.practica.transporte.repositories.ParadaRepository;
import com.practica.transporte.services.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)
public class ParadaServiceTest {

    @Mock
    private ParadaRepository repository;

    @InjectMocks
    private ParadaService service;

    @Test
    void buscarPorNumeroPararda_ok() throws ServiceException{
        log.info("[buscarPorNumeroPararda_ok]");

        //given
        Parada paradatest = new Parada();
        paradatest.setNumeroParada(101);
        paradatest.setNombre("oporto");
    }

    @Test
    void buscarPorNumeroParada_ko() {
        // Given
        when(repository.findByNumeroParada(999)).thenReturn(Optional.empty());

        // When & Then (Súper corto)
        assertThrows(ServiceException.class, () -> service.buscarPorNumero(999));
    }

}
