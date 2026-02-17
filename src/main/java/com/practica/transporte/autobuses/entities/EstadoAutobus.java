package com.practica.transporte.autobuses.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ESTADOS_AUTOBUS")
public class EstadoAutobus {

    @Id
    private Long id;

    private String nombre;
}
