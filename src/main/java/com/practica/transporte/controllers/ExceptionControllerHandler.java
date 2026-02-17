package com.practica.transporte.controllers;


import com.practica.transporte.common.CodeError;
import com.practica.transporte.common.TipoLinea;
import com.practica.transporte.services.exceptions.LineaNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.service.spi.ServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(annotations = Controller.class)
@Slf4j
public class ExceptionControllerHandler {

    @ExceptionHandler(LineaNotFoundException.class)
    public String handleEmployeeNotFoundException(
            LineaNotFoundException ex,
            Model model
    ) {
        log.info("[handleEmployeeNotFoundException]");

        model.addAttribute("error",CodeError.LINEA_NOT_FOUND.getMessage());
        log.debug("[error {}]", CodeError.LINEA_NOT_FOUND.getMessage());

        model.addAttribute("tipos", TipoLinea.values());
        return "/busqueda/t_linea";
    }

    @ExceptionHandler(ServiceException.class)
    public String handleServiceException(
            ServiceException ex,
            Model model
    ) {
        log.info("[handleServiceException]");
        model.addAttribute("error",CodeError.SERVICE.getMessage());
        log.debug("[error {}]",CodeError.SERVICE.getMessage());
        return "error/error";
    }

    @ExceptionHandler(Exception.class)
    public String handleGenericException(
            Exception ex,
            Model model
    ) {
        log.info("[handleGenericException]");
        model.addAttribute("error","ERROR_500");
        log.debug("[error ERROR_500]");
        return "error/500";
    }
}

