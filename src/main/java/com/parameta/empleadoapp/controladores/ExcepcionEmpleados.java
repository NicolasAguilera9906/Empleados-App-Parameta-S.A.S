package com.parameta.empleadoapp.controladores;

import org.springframework.http.HttpStatus;

public class ExcepcionEmpleados extends Exception {

    public static final String NOMBRE_NULO = "El nombre del empleado no puede ser nulo";
    public static final String APELLIDO_NULO = "El apellido del empleado no puede ser nulo";
    public static final String TIPO_DOCUMENTO_NULO = "El tipo de documento del empleado no puede ser nulo";
    public static final String NUMERO_DOCUMENTO_NULO = "El numero de documento del empleado no puede ser nulo";
    public static final String FECHA_NACIMIENTO_NULO = "La fecha de nacimiento del empleado no puede ser nula";
    public static final String FECHA_VINCULACION_COMPAÑIA_NULO = "La fecha de vinculacion del empleado no puede ser nula";
    public static final String CARGO_NULO = "El cargo del empleado no puede ser nulo";
    public static final String SALARIO_NULO = "El salario del empleado no puede ser nulo";
    public static final String MENOR_DE_EDAD = "El empleado no puede ser menor de 18 años";
    public static final String FECHA_FUTURA_INVALIDA = "La fecha no puede estar en el futuro";
    private final HttpStatus estado;


    /**
     * Constructor para ExcepcionEmpleados.
     *
     * @param message El mensaje de error de la excepcion.
     * @param cause   La causa del error.
     * @param estado  El codigo de estado HTTP de la excepcion
     */
    public ExcepcionEmpleados(String message, Throwable cause, HttpStatus estado) {
        super(message, cause);
        this.estado = estado;
    }

    /**
     * Constructor de la clase ExcepcionEmpleados
     *
     * @param msg - Mensaje de la excepción
     * @param estado - El codigo de estado HTTP de la excepcion
     */
    public ExcepcionEmpleados(String msg, HttpStatus estado) {
        super(msg);
        this.estado = estado;
    }

    /**
     * Retorna el codigo de estado HTTP De la excepcion
     *
     * @return El codigo de estado HTTP De la excepcion
     */
    public HttpStatus obtenerEstado() {
        return estado;
    }

}
