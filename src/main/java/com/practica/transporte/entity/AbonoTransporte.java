package com.practica.transporte.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AbonoTransporte {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;
    private double precio;
    private LocalDate fechaemision;
    private boolean activo;
    @Enumerated(EnumType.STRING)
    private Validez validez;
    @Enumerated(EnumType.STRING)
    private Descuento descuento;
    @Enumerated(EnumType.STRING)
    private Billete billete;


}
