package com.practica.transporte.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConductorDTO {
    private Long id;
    private String nombre;
    private String apellidos;
    private String numEmpleado;
    private boolean disponible;
    private Long idAutobus;
}
