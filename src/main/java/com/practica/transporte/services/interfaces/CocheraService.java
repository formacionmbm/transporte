package com.practica.transporte.services.interfaces;

import com.practica.transporte.commons.EstadoCochera;
import com.practica.transporte.entities.Cochera;

import java.util.List;

public interface CocheraService {

    public List<Cochera> buscarTodos();
    public List<Cochera> buscarPorLocalidad(String localidad);
    public List<Cochera> buscarPorEstado(EstadoCochera estado);
    public List<Cochera> buscarPorCodigoPostal(String codigoPostal);
    public List<Cochera> buscarPorNombre(String nombre);

    public void crearCochera(Cochera cochera);


}
