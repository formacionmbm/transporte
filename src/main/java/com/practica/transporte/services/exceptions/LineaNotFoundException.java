package com.practica.transporte.services.exceptions;

import org.hibernate.service.spi.ServiceException;

public class LineaNotFoundException extends ServiceException {
    public LineaNotFoundException() {
        super("Linea no encontrada");
    }
}
