package com.practica.transporte.dto;

import com.practica.transporte.common.EstadoLinea;
import com.practica.transporte.common.TipoLinea;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class LineaDTO {
    private Long id;
    private String codigo;
    private String nombre;
    private Boolean sentido;
    private EstadoLinea estadoLinea;
    private TipoLinea tipoLinea;
}
