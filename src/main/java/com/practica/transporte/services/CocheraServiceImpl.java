package com.practica.transporte.services;


import com.practica.transporte.commons.EstadoCochera;
import com.practica.transporte.entities.Cochera;
import com.practica.transporte.repositories.CocheraRepository;
import com.practica.transporte.services.interfaces.CocheraService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CocheraServiceImpl implements CocheraService {

    CocheraRepository repositorio;

    public CocheraServiceImpl(CocheraRepository repositorio) {
        this.repositorio = repositorio;
    }


    @Override
    public List<Cochera> buscarTodos() {
        return repositorio.findAll();
    }

    @Override
    public List<Cochera> buscarPorLocalidad(String localidad) {
        return List.of();
    }

    @Override
    public List<Cochera> buscarPorEstado(EstadoCochera estado) {
        return List.of();
    }

    @Override
    public void crearCochera(Cochera cochera){

    }
}
