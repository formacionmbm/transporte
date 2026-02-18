package com.practica.transporte.repository;

import com.practica.transporte.common.TipoDescuento;
import com.practica.transporte.common.Tipo;
import com.practica.transporte.entity.AbonoTransporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ATRepository extends JpaRepository<AbonoTransporte, Integer> {

    public List<AbonoTransporte> findByTipo(@Param ("Tipo") Tipo tipo);
    public List<AbonoTransporte> findByTipodescuento(@Param ("Desc") TipoDescuento tipodescuento);

}

