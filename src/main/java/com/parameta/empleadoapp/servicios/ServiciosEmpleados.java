package com.parameta.empleadoapp.servicios;

import com.parameta.empleadoapp.controladores.ExcepcionEmpleados;
import com.parameta.empleadoapp.modelos.Empleado;

/**
 * Interfaz de la capa de servicios de la aplicación de Empleados de Parameta S.A.S
 */
public interface ServiciosEmpleados {

    /**
     * Permite agregar un nuevo Empleado
     *
     * @param empleado - El nuevo empleado que se va a añadir
     * @throws ExcepcionEmpleados  - Cuando ocurra un error al añadir al Empleado
     */
    void añadirEmpleado(Empleado empleado) throws ExcepcionEmpleados;

}
