package com.practica.transporte.repositories;

import com.practica.transporte.entities.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConductorRepository extends JpaRepository<Conductor, Long> {
    Optional<Conductor> findByNumeroEmpleado(String numeroEmpleado);
}
