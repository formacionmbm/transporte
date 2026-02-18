package com.practica.transporte.repositories;

import com.practica.transporte.common.TipoLinea;
import com.practica.transporte.entities.Linea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LineaRepository extends JpaRepository<Linea, Long> {
    List<Linea> findByTipoLinea(TipoLinea tipoLinea);

    Optional<Linea> findAllByCodigo(String codigo);

    Optional<Linea> findByNombre(String nombre);
}
