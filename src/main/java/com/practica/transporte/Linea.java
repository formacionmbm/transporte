package com.practica.transporte;

import com.practica.transporte.common.EstadoLinea;
import com.practica.transporte.common.TipoLinea;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor

public class Linea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private String nombre;
    private Boolean sentido;
    @Enumerated(EnumType.STRING)
    private EstadoLinea estadoLinea;
    private TipoLinea tipoLinea;
}
