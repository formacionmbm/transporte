package com.practica.transporte.autobuses.entities;


import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name="AUTOBUSES")
@Data
public class Autobus {
    @Id
    @Column(name="AUTOBUS_ID")
    private long id;

    @Column(name="MATRICULA")
    private String matricula;

    @Column(name="BASTIDOR")
    private String bastidor;

    @ManyToOne
    private EstadoAutobus estado;

    @Column(name="FLOTA")
    private String flota;





}
