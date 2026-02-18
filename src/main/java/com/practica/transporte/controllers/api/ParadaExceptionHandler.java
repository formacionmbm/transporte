package com.practica.transporte.controllers.api;

import com.practica.transporte.services.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ParadaExceptionHandler {

    @ExceptionHandler(ServiceException.class)
    public ResponseEntity<String> manejarServiceException(ServiceException ex) {
        log.info("[handleServiceException] - Message: {}", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejarErrorGenerico(Exception ex) {
        log.error("[handleGenericException]", ex);
        return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}