package com.practica.transporte.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConductorDTO {
    private Long id;
    private String nombre;
    private String apellidos;
    private LocalDate fechaIncorporacion;
    private String numEmpleado;
    private String tipoLicencia;
    private LocalDate caducidadLicencia;
    private boolean disponible;
    private Long idAutobus;
}
