package com.parameta.empleadoapp.modelos;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.parameta.empleadoapp.controladores.ExcepcionEmpleados;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

/**
 * Clase que representa un empleado de Parameta S.A.S
 */
@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @JsonProperty("nombre")
    @Column(name = "nombre", length = 255, nullable=false)
    private String nombre;

    @JsonProperty("apellido")
    @Column(name = "apellido", length = 255, nullable = false)
    private String apellido;

    @JsonProperty("tipo_documento")
    @Column(name = "tipo_documento", length = 255, nullable = false)
    private String tipoDeDocumento;

    @JsonProperty("numero_documento")
    @Column(name = "numero_documento", length = 255, nullable = false)
    private String numeroDeDocumento;

    @JsonProperty("fecha_nacimiento")
    @Column(name = "fecha_nacimiento", nullable = false)
    private Date fechaDeNacimiento;

    @JsonProperty("fecha_vinculacion")
    @Column(name = "fecha_vinculacion", nullable = false)
    private Date fechaDeVinculacion;

    @JsonProperty("cargo")
    @Column(name = "cargo", length = 255, nullable = false)
    private String cargo;

    @JsonProperty("salario")
    @Column(name = "salario", nullable = false)
    private Double salario;

    @JsonProperty("edad_actual")
    private String edadActual;

    @JsonProperty("tiempo_vinculacion_compañia")
    private String tiempoVinculacionALaCompañia;

    /**
     * Constructor por defecto de la entidad Empleado
     */
    public Empleado() {
    }

    /**
     * Constructor por defecto de la entidad Empleado
     *
     * @param nombre - nombre del empleado
     * @param apellido - apellido del empleado
     * @param tipoDeDocumento - tipo de documento del empleado
     * @param numeroDeDocumento - numero de documento del empleado
     * @param fechaDeNacimiento - Representa la fecha de nacimiento del empleado
     * @param fechaDeVinculacion - Representa la fecha de vinculación a la compañia del empleado
     * @param cargo - cargo del empleado
     * @param salario - salario del empleado
     */
    public Empleado(long id, String nombre, String apellido, String tipoDeDocumento, String numeroDeDocumento, Date fechaDeNacimiento, Date fechaDeVinculacion, String cargo, Double salario, String edadActual, String tiempoVinculacionALaCompañia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDeDocumento = tipoDeDocumento;
        this.numeroDeDocumento = numeroDeDocumento;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.fechaDeVinculacion = fechaDeVinculacion;
        this.cargo = cargo;
        this.salario = salario;
        this.edadActual = edadActual;
        this.tiempoVinculacionALaCompañia = tiempoVinculacionALaCompañia;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDeDocumento() {
        return tipoDeDocumento;
    }

    public void setTipoDeDocumento(String tipoDeDocumento) {
        this.tipoDeDocumento = tipoDeDocumento;
    }

    public String getNumeroDeDocumento() {
        return numeroDeDocumento;
    }

    public void setNumeroDeDocumento(String numeroDeDocumento) {
        this.numeroDeDocumento = numeroDeDocumento;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) throws ExcepcionEmpleados {
        this.fechaDeNacimiento = fechaDeNacimiento;
        calcularEdadActual();
    }

    public Date getFechaDeVinculacion() {
        return this.fechaDeVinculacion;
    }

    public void setFechaDeVinculacion(Date fechaDeVinculacion) throws ExcepcionEmpleados {
        this.fechaDeVinculacion = fechaDeVinculacion;
        calcularTiempoVinculacionALaCompañia();
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    private void calcularEdadActual(){
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaDeNacimiento = this.fechaDeNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period periodo = Period.between(fechaDeNacimiento, fechaActual);
        this.edadActual = periodo.getYears() + " años, "+ periodo.getMonths() + " meses, " + periodo.getYears()+ " dias" ;
    }

    private void calcularTiempoVinculacionALaCompañia(){
        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaDeVinculacion = this.fechaDeVinculacion.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period periodo = Period.between(fechaDeVinculacion, fechaActual);
        this.tiempoVinculacionALaCompañia = periodo.getYears() + " años, "+ periodo.getMonths() + " meses, " + periodo.getYears()+ " dias" ;
    }
}