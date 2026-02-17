package com.practica.transporte.autobuses.services.interfaces;

import com.practica.transporte.autobuses.entities.Autobus;

import java.util.List;

public interface ServicioBuscadores {
    List<Autobus> buscarAutobuses(String matricula);
}
