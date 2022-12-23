package com.parameta.empleadoapp.persistencia.repositorios;
import com.parameta.empleadoapp.modelos.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * Repositorio de Conexión con base de Datos para la clase "Empleado"
 */
@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long> {
}