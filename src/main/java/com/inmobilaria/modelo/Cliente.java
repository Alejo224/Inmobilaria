package com.inmobilaria.modelo;

import java.util.Date;

public class Cliente extends Persona{

    private String telefono2;

    // contructores
    public Cliente(){}

    public Cliente(String cedula, String correo, String direccion, String nombreCompleto, String telefono1, Date fechaNacimiento, Date fechaExpediccion,
                   String telefon2){
        super(cedula, correo, direccion, nombreCompleto, telefono1, fechaNacimiento, fechaExpediccion);
        this.telefono2 = telefono2;
    }

    //metodos

    // getters and setters
    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }
}
