package com.practica.transporte.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Conductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "num_empleado", unique = true, nullable = false)
    private String numEmpleado;

    @Column(name="tipo_licencia")
    private String tipoLicencia;

    @Column(name="caducidad_licencia")
    private LocalDate caducidadLicencia;

    @Column(name="disponible")
    private boolean disponible;

}
