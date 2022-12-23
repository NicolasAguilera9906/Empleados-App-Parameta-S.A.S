package com.parameta.empleadoapp.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Manejador de excepciones para los controladores de la aplicacion de Empleados de Parameta S.A.S
 *
 * @author Error 418
 */
@RestControllerAdvice
public class ExcepcionEmpleadosHandler {

    /**
     * Metodo que maneja la ExcepcionEmpleados de los Controladores REST de la aplicacion de Empleados
     *
     * @param e excepcion causada
     * @return Una entidad de respuesta con la excepcion causada
     */
    @ExceptionHandler(ExcepcionEmpleados.class)
    private ResponseEntity<?> exceptionHandler(ExcepcionEmpleados e) {
        return new ResponseEntity<>(e.getMessage(), e.obtenerEstado());
    }

    /**
     * Metodo que maneja excepciones del tipo HttpMessageNotReadableException de los Controladores REST de la aplicacion
     * de Empleados
     *
     * @param e excepcion causada
     * @return Una entidad de respuesta con la excepcion causada
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<?> exceptionHandler(HttpMessageNotReadableException e) {
        return new ResponseEntity<>("Formato de fecha invalida. El formato correcto es yyyy/mm/dd", HttpStatus.BAD_REQUEST);
    }
}