package com.practica.transporte.services;

import com.practica.transporte.common.TipoLinea;
import com.practica.transporte.dto.NombreLineaDTO;
import com.practica.transporte.entities.Linea;
import com.practica.transporte.repositories.LineaRepository;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sound.sampled.Line;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class LineaServiceImpl implements LineaService {

    @Autowired
    LineaRepository lineaRepository;


    @Override
    public List<Linea> busquedaLineaPorTipo(TipoLinea tipoLinea) throws ServiceException {
        log.info("[busquedaLineaPorTipo]");
        log.debug("[tipo:{}]", tipoLinea);
        try {
            List<Linea> resultado = lineaRepository.findByTipoLinea(tipoLinea);
            if (resultado.isEmpty()) {
                throw new ServiceException("No se encontraron líneas para el tipo: " + tipoLinea);
            }
            return resultado;
        } catch (Exception e) {
            log.error("Error al buscar por tipo", e);
            throw new ServiceException("Error técnico al recuperar líneas por tipo");
        }
    }


    @Override
    public List<Linea> busquedaLineaCodigo(String codigo) throws ServiceException {
        log.info("[busquedaLineaCodigo]");
        log.debug("[codigo:{}]", codigo);
        try {
            return lineaRepository.findAllByCodigo(codigo);
        } catch (Exception e){
        log.error("Error al buscar por codigo", e);

        throw new ServiceException("Error al buscar el codigo" + codigo);
    }

    @Override
    public List<Linea> busquedaPorNombre(NombreLineaDTO nombre) throws ServiceException {
            log.info("[busquedaPorNombre]");
            log.debug("[nombre:{}]", nombre);
            try {
                List<Linea> todas = lineaRepository.findAll();
                List<Linea> resultado = new ArrayList<>();

        }