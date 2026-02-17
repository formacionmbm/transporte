package com.practica.transporte.services;

import com.practica.transporte.common.TipoLinea;
import com.practica.transporte.entities.Linea;
import org.hibernate.service.spi.ServiceException;

import java.util.List;

public interface LineaService {

    List<Linea> busquedaLineaPorTipo(TipoLinea tipoLinea) throws ServiceException;

}
