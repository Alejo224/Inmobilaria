package com.inmobilaria.modelo;

import java.util.ArrayList;
import java.util.List;

public class AgenteComercial extends Persona{
    private String password, loguin;
    private ArrayList<Persona> cliente;

    public AgenteComercial(int cedula, String nombres,String apellidos, int fechaNacimiento, int fechaExpedicion, String correoElectronico, int telefono,
                           String password, String loguin) {
        super(cedula, nombres, fechaNacimiento, fechaExpedicion, correoElectronico, telefono, apellidos);
        this.password = password;
        this.loguin = loguin;

        cliente = new ArrayList<>();
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

    //Este metodo nos sirve para poder registrar un cliente
    public void registrarCliente(int cedula, String nombres, int fechaNacimiento, int fechaExpedicion, String correoElectronico, int telefono, String apellidos){

        cliente.add(new Persona(cedula,nombres,fechaNacimiento,fechaExpedicion,correoElectronico,telefono,apellidos));
    }
    public  boolean mostarCliente(){
        for (int i = 0; i < cliente.size(); i++) {
            System.out.println(
                    " Nombre = " + cliente.get(i).getNombre() +
                   "\n Apellidos = " + cliente.get(i).getApellidos()+ "\n Fecha nacimento = " + cliente.get(i).getFechaNacimiento() +
                    "\n Fecha expedicion = " + cliente.get(i).getFechaExpedicion()+
                    "\n Correo = " + cliente.get(i).getCorreoElectronico() +
                    "\n Telefono = " + cliente.get(i).getTelefono());
            return true;
        }
       return false;
    }
    public void borrarcliente(int index){

    }
    public void modificarCliente(){

    }
    public void registarContratocliente(){

    }
    public void registarContratoPropietario(){

    }

}
