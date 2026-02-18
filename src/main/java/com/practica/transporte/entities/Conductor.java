package com.practica.transporte.entities;

import com.practica.transporte.common.EstadoConductor;
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
    private String nombre;
    private String apellidos;
    private LocalDate fechaIncorporacion;
    private String numEmpleado;
    @OneToOne
    @JoinColumn(name = "licencia_id", nullable = false, unique = true)
    private LicenciaConductor licencia;
    private Integer disponible;
    private EstadoConductor estadoConductor;
}
