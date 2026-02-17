package com.practica.transporte.repositories;

import com.practica.transporte.common.TipoLinea;
import com.practica.transporte.entities.Linea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LineaRepository extends JpaRepository<Linea, Long> {
    List<Linea> findByTipoLinea(TipoLinea tipoLinea);

    List<Linea> findAllByCodigo(String codigo);

    Linea findByNombre(String nombre);
}
