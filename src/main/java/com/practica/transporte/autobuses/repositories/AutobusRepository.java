package com.practica.transporte.autobuses.repositories;

import com.practica.transporte.autobuses.entities.Autobus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AutobusRepository extends JpaRepository<Autobus, Long> {

    Optional<Autobus> findByMatricula(String matricula);

    List<Autobus> findByMatriculaContainingIgnoreCase(String matricula);
}
