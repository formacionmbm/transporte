package com.practica.transporte.entities;

import com.practica.transporte.common.EstadoLinea;
import com.practica.transporte.common.TipoLinea;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
