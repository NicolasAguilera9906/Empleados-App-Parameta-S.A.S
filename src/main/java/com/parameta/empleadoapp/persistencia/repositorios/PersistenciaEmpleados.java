package com.parameta.empleadoapp.persistencia.repositorios;

import com.parameta.empleadoapp.controladores.ExcepcionEmpleados;
import com.parameta.empleadoapp.modelos.Empleado;

/**
 * Interfaz de la capa de persistencia de la aplicación de Empleados de Parameta S.A.S
 */
public interface PersistenciaEmpleados {


    /**
     * @param empleado Empleado de la empresa Parameta S.A.S
     * @throws ExcepcionEmpleados - cuando alguno de los atributos del empleado es nulo u ocurra algún error
     * al añadir al empleado a la base de datos
     */
    void añadirEmpleado(Empleado empleado) throws ExcepcionEmpleados;
}
