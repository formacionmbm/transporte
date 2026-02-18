package com.practica.transporte.autobuses.services;

import com.practica.transporte.autobuses.entities.Autobus;
import com.practica.transporte.autobuses.repositories.AutobusRepository;
import com.practica.transporte.autobuses.services.interfaces.ServicioBuscadores;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ServicioBuscadoresImpl implements ServicioBuscadores {

    private final AutobusRepository repositorio;

    public ServicioBuscadoresImpl(AutobusRepository repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public List<Autobus> buscarAutobuses(String matricula) {
        log.info("[buscarAutobuses]");
        log.debug("[matricula:{}]", matricula);

        try {
            // Si viene vacío, devolvemos todos
            if (matricula == null || matricula.trim().isEmpty()) {
                return repositorio.findAll();
            }

            // Si viene algo, buscamos por "contiene" ignorando mayúsculas/minúsculas
            return repositorio.findByMatriculaContainingIgnoreCase(matricula.trim());

        } catch (Exception e) {
            log.error("General Error", e);
            // Como tu interfaz NO permite throws, aquí no podemos lanzar ServiceException
            // Devolvemos lista vacía para no romper la app
            return List.of();
        }
    }
}