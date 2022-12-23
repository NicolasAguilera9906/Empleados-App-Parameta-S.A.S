package com.parameta.empleadoapp.persistencia.repositorios;

import com.parameta.empleadoapp.controladores.ExcepcionEmpleados;
import com.parameta.empleadoapp.modelos.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Implementación de la capa de persistencia de la aplicación de empleados de Parameta S.A.S
 */
@Service
public class PersistenciaEmpleadosImpl implements PersistenciaEmpleados {

    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    /**
     * @param empleado Empleado de la empresa Parameta S.A.S
     * @throws ExcepcionEmpleados - cuando alguno de los atributos del empleado es nulo u ocurra algún error
     * al añadir al empleado a la base de datos
     */
    @Override
    public void añadirEmpleado(Empleado empleado) throws ExcepcionEmpleados {
        validarNombre(empleado.getNombre());
        validarApellido(empleado.getApellido());
        validarTipoDeDocumento(empleado.getTipoDeDocumento());
        validarNumeroDeDocumento(empleado.getNumeroDeDocumento());
        validarFechaDeNacimiento(empleado.getFechaDeNacimiento());
        validarMayoriaDeEdad(empleado.getFechaDeNacimiento());
        validarFechaDeVinculacionALaCompañia(empleado.getFechaDeVinculacion());
        validarCargo(empleado.getCargo());
        validarSalario(empleado.getSalario());

        try{
            empleadoRepositorio.save(empleado);
        } catch(Exception exc){
            throw new ExcepcionEmpleados(exc.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Valida que el nombre del Empleado no sea nulo o vacío
     * @param nombre nombre del Empleado de Parameta S.A.S
     * @throws ExcepcionEmpleados - cuando el nombre del Empleado es nulo o vacío
     */
    private void validarNombre(String nombre) throws ExcepcionEmpleados {
        if(nombre == null || nombre.equals("")){
            throw new ExcepcionEmpleados(ExcepcionEmpleados.NOMBRE_NULO, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Valida que el apelliido del Empleado no sea nulo o vacío
     * @param apellido apellido del Empleado de Parameta S.A.S
     * @throws ExcepcionEmpleados - cuando el apellido del Empleado es nulo o vacío
     */
    private void validarApellido(String apellido) throws ExcepcionEmpleados {
        if(apellido == null || apellido.equals("")){
            throw new ExcepcionEmpleados(ExcepcionEmpleados.APELLIDO_NULO, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Valida que el tipo de documento del Empleado no sea nulo o vacío
     * @param tipoDeDocumento apellido del Empleado de Parameta S.A.S
     * @throws ExcepcionEmpleados - cuando el tipo de documento del Empleado es nulo o vacío
     */
    private void validarTipoDeDocumento(String tipoDeDocumento) throws ExcepcionEmpleados {
        if(tipoDeDocumento == null || tipoDeDocumento.equals("")){
            throw new ExcepcionEmpleados(ExcepcionEmpleados.TIPO_DOCUMENTO_NULO, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Valida que el numero de documento del Empleado no sea nulo o vacío
     * @param numeroDeDocumento numero de documento del Empleado de Parameta S.A.S
     * @throws ExcepcionEmpleados - cuando el numero de documento del Empleado es nulo o vacío
     */
    private void validarNumeroDeDocumento(String numeroDeDocumento) throws ExcepcionEmpleados {
        if(numeroDeDocumento == null || numeroDeDocumento.equals("")){
            throw new ExcepcionEmpleados(ExcepcionEmpleados.NUMERO_DOCUMENTO_NULO, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Valida que la persona tenga más de 18 años.
     * @param fechaDeNacimiento fecha de nacimiento del Empleado de Parameta S.A.S
     * @throws ExcepcionEmpleados - Cuando el empleado es menor a 18 años
     */
    private void validarMayoriaDeEdad(Date fechaDeNacimiento) throws ExcepcionEmpleados {
        Calendar calendar = GregorianCalendar.getInstance();
        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 18);
        if(!(calendar.getTime().after(fechaDeNacimiento))){
            throw new ExcepcionEmpleados(ExcepcionEmpleados.MENOR_DE_EDAD, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Valida que la fecha de nacimiento del Empleado no sea nula y tenga un formato valido.
     * También valida que la persona tenga más de 18 años.
     * @param fechaDeNacimiento fecha de nacimiento del Empleado de Parameta S.A.S
     * @throws ExcepcionEmpleados - cuando la fecha de nacimiento del Empleado es nula o vacía, o tiene
     * un formato inválido
     */
    private void validarFechaDeNacimiento(Date fechaDeNacimiento) throws ExcepcionEmpleados {
        if(fechaDeNacimiento == null){
            throw new ExcepcionEmpleados(ExcepcionEmpleados.FECHA_NACIMIENTO_NULO, HttpStatus.BAD_REQUEST);
        }
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaLocalDeNacimiento = fechaDeNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if(fechaActual.isBefore(fechaLocalDeNacimiento)){
            throw new ExcepcionEmpleados("La fecha de nacimiento es invalida porque: "+ ExcepcionEmpleados.FECHA_FUTURA_INVALIDA, HttpStatus.BAD_REQUEST);
        };
    }

    /**
     * Valida que la fecha de vinculacion del Empleado no sea nula y que tenga un formato valido
     * @param fechaDeVinculacion fecha de vinculacion a la compañia del Empleado de Parameta S.A.S
     * @throws ExcepcionEmpleados - cuando la fecha de vinculacion del Empleado es nula o vacía, o tiene
     * un formato inválido
     */
    private void validarFechaDeVinculacionALaCompañia(Date fechaDeVinculacion) throws ExcepcionEmpleados {
        if(fechaDeVinculacion == null){
            throw new ExcepcionEmpleados(ExcepcionEmpleados.FECHA_VINCULACION_COMPAÑIA_NULO, HttpStatus.BAD_REQUEST);
        }
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaLocalDeNacimiento = fechaDeVinculacion.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if(fechaActual.isBefore(fechaLocalDeNacimiento)){
            throw new ExcepcionEmpleados("La fecha de vinculacion es invalida porque: "+ ExcepcionEmpleados.FECHA_FUTURA_INVALIDA, HttpStatus.BAD_REQUEST);
        };
    }

    /**
     * Valida que el cargo del Empleado no sea nulo
     * @param cargo cargo del Empleado de Parameta S.A.S
     * @throws ExcepcionEmpleados - cuando el cargo del Empleado de Parameta S.A.S es nulo o vacío
     */
    private void validarCargo(String cargo) throws ExcepcionEmpleados {
        if(cargo == null){
            throw new ExcepcionEmpleados(ExcepcionEmpleados.CARGO_NULO, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Valida que el salario del Empleado de Parameta S.A.S no sea nulo
     * @param salario salario del Empleado de Parameta S.A.S
     * @throws ExcepcionEmpleados - cuando el salario del Empleado de Parameta S.A.S es nulo o vacío
     */
    private void validarSalario(Double salario) throws ExcepcionEmpleados {
        if(salario == null){
            throw new ExcepcionEmpleados(ExcepcionEmpleados.SALARIO_NULO, HttpStatus.BAD_REQUEST);
        }
    }
}
