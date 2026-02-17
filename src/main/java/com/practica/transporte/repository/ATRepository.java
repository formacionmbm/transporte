package com.practica.transporte.repository;

import com.practica.transporte.common.Descuento;
import com.practica.transporte.common.Tipo;
import com.practica.transporte.entity.AbonoTransporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ATRepository extends JpaRepository<AbonoTransporte, Integer> {

    public Optional<AbonoTransporte> findById(@Param ("Id") Tipo tipo);
    public List<AbonoTransporte> findByTipo(@Param ("Tipo") Tipo tipo);
    public List<AbonoTransporte> findByDescuento(@Param ("Desc") Descuento descuento);

}

