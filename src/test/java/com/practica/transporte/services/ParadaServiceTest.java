package com.practica.transporte.services;

import com.practica.transporte.entities.Parada;
import com.practica.transporte.repositories.ParadaRepository;
import com.practica.transporte.services.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@Slf4j
public class ParadaServiceTest {

    @Mock
    private ParadaRepository repository;

    @InjectMocks
    private ParadaService service;

    @Test
    void buscarPorNumero_ok() throws ServiceException{
        log.info("[buscarPorNumero]");

        //given
        Parada paradatest = new Parada();
        paradatest.setNumeroParada(101);
        paradatest.setNombre("oporto");
    }

}
