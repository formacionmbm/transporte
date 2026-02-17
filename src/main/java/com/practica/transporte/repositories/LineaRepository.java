package com.practica.transporte.repositories;

import com.practica.transporte.entities.Linea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LineaRepository extends JpaRepository<Linea, Long> {
}
