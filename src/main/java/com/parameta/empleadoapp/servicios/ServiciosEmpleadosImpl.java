package com.parameta.empleadoapp.servicios;

import com.parameta.empleadoapp.controladores.ExcepcionEmpleados;
import com.parameta.empleadoapp.modelos.Empleado;
import com.parameta.empleadoapp.persistencia.repositorios.PersistenciaEmpleados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementación de la capa de servicios de la aplicación de Empleados de Parameta S.A.S
 */
@Service
public class ServiciosEmpleadosImpl implements ServiciosEmpleados{

    @Autowired
    private PersistenciaEmpleados persistencia;

    @Override
    public void añadirEmpleado(Empleado empleado) throws ExcepcionEmpleados {
        persistencia.añadirEmpleado(empleado);
    }
}
