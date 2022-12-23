package com.parameta.empleadoapp.controladores;

import com.parameta.empleadoapp.modelos.Empleado;
import com.parameta.empleadoapp.servicios.ServiciosEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


/**
 * Controlador API REST de la aplicación de Empleados de Parameta S.A.S
 */
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/v1/")
public class ControladorEmpleados {
    @Autowired
    private ServiciosEmpleados servicios;

    /**
     * Agrega un nuevo empleado dentro de la aplicación de Empleados
     *
     * @param empleado información del nuevo empleado
     * @return Entidad de Respuesta con el estado de la solicitud y en caso de fallo, el mensaje de la excepcion
     */
    @PostMapping(value = "/empleados")
    public ResponseEntity<?> añadirEmpleado(@RequestBody Empleado empleado) {
        try {
            servicios.añadirEmpleado(empleado);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(empleado, HttpStatus.CREATED);
    }
}