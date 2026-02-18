package com.practica.transporte.services;

import com.practica.transporte.common.TipoLinea;
import com.practica.transporte.dto.LineaDTO;
import com.practica.transporte.dto.NombreLineaDTO;
import com.practica.transporte.entities.Linea;
import org.hibernate.service.spi.ServiceException;

import java.util.List;

public interface LineaService {

    //List<LineaDTO> busquedaPorTipo(TipoLinea tipo) throws ServiceException;
    List<LineaDTO> busquedaLineaPorTipo(TipoLinea tipoLinea) throws ServiceException;

    //LineaDTO busquedaLineaPorCodigo(String codigo) throws ServiceException;
    LineaDTO busquedaLineaCodigo(String codigo) throws ServiceException;

    //LineaDTO busquedaPorNombre(String nombre) throws ServiceException;
    List<Linea> busquedaPorNombre (NombreLineaDTO nombre) throws ServiceException;
}
