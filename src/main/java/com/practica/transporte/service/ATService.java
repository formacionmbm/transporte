package com.practica.transporte.service;

import com.practica.transporte.common.Descuento;
import com.practica.transporte.common.Tipo;
import com.practica.transporte.entity.AbonoTransporte;

import java.util.List;

public interface ATService {
    public List<AbonoTransporte> listarTodas(Tipo tipo);

    public List<AbonoTransporte> findByTipoo(Tipo tipo);
    public List<AbonoTransporte> findByDescuento(Descuento descuento);
    public void crearAbono(AbonoTransporte abono);

}
