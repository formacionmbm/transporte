package com.practica.transporte.services;

import com.practica.transporte.entities.Parada;
import com.practica.transporte.repositories.ParadaRepository;
import com.practica.transporte.services.exception.ServiceException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParadaService {


    private ParadaRepository repository;

    public ParadaService(ParadaRepository repository) {
        this.repository = repository;
    }

    public Parada buscarPorNumero(int numeroParada) throws ServiceException{
        Optional<Parada> resultado = repository.findByNumeroParada(numeroParada);

        if(resultado.isPresent()){
            return resultado.get();
        }else {
            throw new ServiceException("No se encuentra la parada con numero: " + numeroParada);
        }
    }

    public Parada guardarParada(Parada parada){
        return repository.save(parada);
    }

}
