package com.inmobilaria.modelo;

public class AgenteComercial extends Persona{
    private String password, loguin;

    public AgenteComercial(int cedula, String nombres, int fechaNacimiento, int fechaExpedicion, String correoElectronico, int telefono, String apellidos,
                           String password, String loguin) {
        super(cedula, nombres, fechaNacimiento, fechaExpedicion, correoElectronico, telefono, apellidos);

        this.password = password;
        this.loguin = loguin;
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
}
