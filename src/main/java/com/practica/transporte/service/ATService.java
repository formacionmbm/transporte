package com.practica.transporte.service;

import com.practica.transporte.common.TipoDescuento;
import com.practica.transporte.common.Tipo;
import com.practica.transporte.entity.AbonoTransporte;

import java.util.List;

public interface ATService {
    public List<AbonoTransporte> listarTodas();
    public AbonoTransporte buscarPorId(int id);
    public List<AbonoTransporte> buscarPorTipo(Tipo tipo);
    public List<AbonoTransporte> buscarPorDescuento(TipoDescuento descuento);
    void crearAbono(AbonoTransporte abono);
}
