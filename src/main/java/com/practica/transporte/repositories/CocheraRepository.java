package com.practica.transporte.repositories;

import com.practica.transporte.entities.Cochera;
import com.practica.transporte.commons.EstadoCochera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CocheraRepository extends JpaRepository<Cochera, Long> {

    // (ACTIVA, INACTIVA, EN_OBRAS)
    List<Cochera> findByEstado(EstadoCochera estado);

    List<Cochera> findByLocalidadContainingIgnoreCase(String localidad);
    List<Cochera> findByCodigoPostal(String codigoPostal);
    List<Cochera> findByNombreContainingIgnoreCase(String nombre);

}