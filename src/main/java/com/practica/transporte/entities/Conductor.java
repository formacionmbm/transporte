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

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellidos")
    private String apellidos;

    @Column(name="fecha_incorporacion")
    private LocalDate fechaIncorporacion;

    @Column(name = "num_empleado")
    private String numEmpleado;

    @Column(name="tipo_licencia")
    private String tipoLicencia;

    @Column(name="caducidad_licencia")
    private LocalDate caducidadLicencia;

    @Column(name="disponible")
    private boolean disponible;

    @Column(name="id_autobus")
    private Long idAutobus;

}
