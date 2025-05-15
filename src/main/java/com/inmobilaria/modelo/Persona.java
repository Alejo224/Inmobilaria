package com.inmobilaria.modelo;

public class Persona {
    private int cedula, fechaNacimiento, fechaExpedicion, telefono;
    private String nombres, apellidos, correoElectronico;

    public Persona(int cedula, String nombres, int fechaNacimiento, int fechaExpedicion, String correoElectronico, int telefono, String apellidos) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaExpedicion = fechaExpedicion;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.apellidos = apellidos;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombre) {
        this.nombres = nombre;
    }

    public int getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(int fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getFechaExpedicion() {
        return fechaExpedicion;
    }

    public void setFechaExpedicion(int fechaExpedicion) {
        this.fechaExpedicion = fechaExpedicion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}