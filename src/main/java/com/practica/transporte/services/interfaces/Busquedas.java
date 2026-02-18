package com.practica.transporte.services.interfaces;

import com.practica.transporte.entities.Parada;
import com.practica.transporte.services.exception.ServiceException;

public interface Busquedas {

    public Parada busquedaParadaPorNumero(int numeroParada) throws ServiceException;

}
