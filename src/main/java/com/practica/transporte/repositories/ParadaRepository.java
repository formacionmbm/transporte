package com.practica.transporte.repositories;

import com.practica.transporte.entities.Parada;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParadaRepository extends JpaRepository<Parada,Long> {

    Optional<Parada> findByNumeroParada(int numeroParada);

}
