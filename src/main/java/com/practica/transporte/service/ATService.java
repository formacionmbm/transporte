package com.practica.transporte.service;

import com.practica.transporte.common.Descuento;
import com.practica.transporte.common.Tipo;
import com.practica.transporte.entity.AbonoTransporte;

import java.util.List;
import java.util.Optional;

public interface ATService {
    public List<AbonoTransporte> listarTodas();
    public Optional<AbonoTransporte> buscarPorId(int id);
    public List<AbonoTransporte> buscarPorTipo(Tipo tipo);
    public List<AbonoTransporte> buscarPorDescuento(Descuento descuento);
    void crearAbono(AbonoTransporte abono);
}
