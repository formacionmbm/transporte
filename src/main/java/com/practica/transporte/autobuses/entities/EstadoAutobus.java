package com.practica.transporte.autobuses.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="ESTADOS_AUTOBUS")
@Data
public class EstadoAutobus {

    @Id
    private Long id;

    private String nombre;
}
