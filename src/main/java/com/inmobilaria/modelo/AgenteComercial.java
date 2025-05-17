package com.inmobilaria.modelo;

import java.util.ArrayList;
import java.util.List;

public class AgenteComercial extends Persona{
    private String password, loguin;
    private Persona cliente;

    public AgenteComercial(int cedula, String nombres,String apellidos, int fechaNacimiento, int fechaExpedicion, String correoElectronico, int telefono,
                           String password, String loguin) {
        super(cedula, nombres, fechaNacimiento, fechaExpedicion, correoElectronico, telefono, apellidos);
        this.password = password;
        this.loguin = loguin;
        this.cliente = new Persona(0,"",0 ,0,"",0,"");
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoguin() {
        return loguin;
    }

    public void setLoguin(String loguin) {
        this.loguin = loguin;
    }

    public void registrarCliente(int cedula, String nombres, int fechaNacimiento, int fechaExpedicion, String correoElectronico, int telefono, String apellidos){
        cliente.setCedula(cedula);
        cliente.setNombre(nombres);
        cliente.setApellidos(apellidos);
        cliente.setTelefono(telefono);
        cliente.setCorreoElectronico(correoElectronico);
        cliente.setFechaExpedicion(fechaExpedicion);
        cliente.setFechaNacimiento(fechaNacimiento);

    }
    public void registarContratocliente(){

    }
    public void registarContratoPropietario(){

    }

    @Override
    public String toString() {
        return " nombre = " + cliente.getNombre()+
                "\n Apellidos = " + cliente.getApellidos()+
                "\n cedula = " + cliente.getCedula()+
                "\n correo = " + cliente.getCorreoElectronico()+
                "\n telefono = " + cliente.getTelefono() +
                "\n fecha nacimiento = " + cliente.getFechaNacimiento() +
                "\n fecha Expedicion = " + cliente.getFechaExpedicion();
    }
}
