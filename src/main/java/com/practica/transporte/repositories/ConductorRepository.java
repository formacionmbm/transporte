package com.practica.transporte.repositories;

import com.practica.transporte.entities.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequestMapping
public interface ConductorRepository extends JpaRepository<Conductor, Long> {
    Optional<Conductor> findByNumeroEmpleado(String numeroEmpleado);
}
