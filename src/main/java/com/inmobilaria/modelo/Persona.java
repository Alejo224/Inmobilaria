package com.inmobilaria.modelo;

import java.util.Date;

public class Persona {

    private String cedula, correo, direccion, nombreCompleto, telefono1;
    private Date fechaNacimiento, fechaExpediccion;

    public Persona(){}

    public Persona(String cedula, String correo, String direccion, String nombreCompleto, String telefono1, Date fechaNacimiento, Date fechaExpediccion) {
        this.cedula = cedula;
        this.correo = correo;
        this.direccion = direccion;
        this.nombreCompleto = nombreCompleto;
        this.telefono1 = telefono1;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaExpediccion = fechaExpediccion;
    }

    // Convierte java.util.Date a java.sql.Date
    public java.sql.Date getFechaNacimientoSQL() {
        Date fechaNacimiento = getFechaNacimiento(); // Use the getter from Persona
        return fechaNacimiento != null ? new java.sql.Date(fechaNacimiento.getTime()) : null;
    }

    public java.sql.Date getFechaExpediccionSQL() {
        Date fechaExpediccion = getFechaExpediccion(); // Use the getter from Persona
        return fechaExpediccion != null ? new java.sql.Date(fechaExpediccion.getTime()) : null;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono1() {
        return telefono1;
    }

    public void setTelefono1(String telefono1) {
        this.telefono1 = telefono1;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaExpediccion() {
        return fechaExpediccion;
    }

    public void setFechaExpediccion(Date fechaExpediccion) {
        this.fechaExpediccion = fechaExpediccion;
    }
}