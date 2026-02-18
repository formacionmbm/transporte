package com.practica.transporte.dto;

import com.practica.transporte.common.EstadoConductor;
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
    private Long licenciaId;
    private Integer disponible;
    private EstadoConductor estadoConductor;
}
