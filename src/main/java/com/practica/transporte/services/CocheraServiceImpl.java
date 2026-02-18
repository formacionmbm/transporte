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
        log.info("[buscar]");
        return repositorio.findAll();
    }

    @Override
    public List<Cochera> buscarPorLocalidad(String localidad) {
        log.info("[buscarPorLocalidad]");
        log.debug("[localidad:{}]", localidad);

        localidad = localidad.trim().toUpperCase();

        return repositorio.findByLocalidadContainingIgnoreCase(localidad);

    }

    @Override
    public List<Cochera> buscarPorEstado(EstadoCochera estado) {
        log.info("[buscarPorEstado]");
        log.debug("[estado:{}]", estado);

        List<Cochera> cocheras = repositorio.findAll();

        return cocheras.stream().filter(f -> f.getEstado()==estado).toList();

    }

    @Override
    public List<Cochera> buscarPorCodigoPostal(String codigoPostal) {
        log.info("[buscarPorCodigoPostal]");
        log.debug("[codigoPostal:{}]", codigoPostal);

        codigoPostal = codigoPostal.trim();

        return repositorio.findByCodigoPostal(codigoPostal);
    }

    @Override
    public List<Cochera> buscarPorNombre(String nombre) {
        log.info("[buscarPorNombre]");
        log.debug("[nombre:{}]", nombre);

        nombre = nombre.trim().toUpperCase();

        return repositorio.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public void crearCochera(Cochera cochera){
        log.info("[crearCochera]");
        log.debug("[cochera:{}]",cochera);

        //TODO agregar validaciones

        repositorio.save(cochera);
    }


}
