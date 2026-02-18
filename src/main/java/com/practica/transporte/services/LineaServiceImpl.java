package com.practica.transporte.services;

import com.practica.transporte.common.TipoLinea;
import com.practica.transporte.dto.LineaDTO;
import com.practica.transporte.dto.NombreLineaDTO;
import com.practica.transporte.entities.Linea;
import com.practica.transporte.repositories.LineaRepository;
import com.practica.transporte.services.exceptions.LineaNotFoundException;
import com.practica.transporte.services.exceptions.ServicesUtil;
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
    public List<LineaDTO> busquedaLineaPorTipo(TipoLinea tipoLinea) throws ServiceException {
        log.info("[busquedaLineaPorTipo]");
        log.debug("[tipo:{}]", tipoLinea);
        try {
            List<Linea> resultado = lineaRepository.findByTipoLinea(tipoLinea);
            log.debug("resultado:{}",resultado);

            return resultado.stream().map(LineaServiceImpl::toDTO).toList();
        } catch (Exception e) {
            log.error("Error al buscar por tipo", e);
            throw new ServiceException("Error técnico al recuperar líneas por tipo");
        }
    }


    @Override
    public LineaDTO busquedaLineaCodigo(String codigo) throws ServiceException {
        log.info("[busquedaLineaCodigo]");
        log.debug("[codigo:{}]", codigo);
        try {
            Linea linea = lineaRepository.findAllByCodigo(codigo).orElseThrow(LineaNotFoundException::new);
            log.debug("linea:{}", linea);
            return ServicesUtil.toDTO(linea);
        } catch (ServiceException se) {
            log.error("Error al buscar por codigo", se);
            throw se;
        } catch (Exception e) {
            log.error("Error al buscar por codigo", e);
            throw new ServiceException("Error al buscar el codigo" + codigo);
        }
    }

        @Override
        public List<Linea> busquedaPorNombre (NombreLineaDTO nombre) throws ServiceException {
            log.info("[busquedaPorNombre]");
            log.debug("[nombre:{}]", nombre);
            try {
                List<Linea> todas = lineaRepository.findAll();
                List<Linea> resultado = new ArrayList<>();
            return null;
            } catch (Exception e) {
                log.error("Error al buscar por codigo", e);
                throw new ServiceException("Error al buscar el codigo" + codigo);
            }
        }
        private static LineaDTO toDTO(Linea linea){
           LineaDTO lineaDTO = new LineaDTO();
           lineaDTO.setId(linea.getId());
           return lineaDTO;
        }

    private static Linea toDTO(LineaDTO lineaDTO){
        Linea linea = new Linea();
        linea.setId(lineaDTO.getId());
        return linea;
    }
    }
