package com.practica.transporte.services;

import com.practica.transporte.entities.Parada;
import com.practica.transporte.repositories.ParadaRepository;
import com.practica.transporte.services.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ParadaService {


    private ParadaRepository repository;

    public ParadaService(ParadaRepository repository) {
        this.repository = repository;
    }

    public Parada buscarPorNumero(int numeroParada) throws ServiceException{
        Parada parada = repository.findByNumeroParada(numeroParada)
                .orElseThrow(()->new ServiceException("No se encuentra la parada con numero: " + numeroParada));

        log.debug("[parada:{}",parada);
        return parada;
    }

    public Parada guardarParada(Parada parada){
        return repository.save(parada);
    }

}
