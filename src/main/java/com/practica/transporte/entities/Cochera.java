package com.practica.transporte.entities;

import com.practica.transporte.commons.EstadoCochera;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "cocheras")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cochera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;
    private String localidad;
    private String codigoPostal;

    private int plazasTotales;
    private int plazasOcupadas;

    @Enumerated(EnumType.STRING)
    private EstadoCochera estado; // ACTIVA, INACTIVA, EN_OBRAS

    private int getPlazasDisponibles() {
        return this.plazasTotales - this.plazasOcupadas;
    }

}