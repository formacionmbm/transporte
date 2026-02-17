package com.practica.transporte.services;

import com.practica.transporte.common.TipoLinea;
import com.practica.transporte.entities.Linea;
import org.hibernate.service.spi.ServiceException;

import java.util.List;

public interface LineaService {

    List<Linea> busquedaPorTipo(TipoLinea tipo) throws ServiceException;

    Linea busquedaLineaPorCodigo(String codigo) throws ServiceException;

    List<Linea> busquedaPorNombre(String nombre) throws ServiceException;
}
