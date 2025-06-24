package com.inmobilaria.modelo;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class AgenteComercial extends Persona{
    private String contrasena, loguin;

    //intacnia de conexion a la base de datos
    private ConexionDB conexionDB = new ConexionDB();

    //Contructor
    public AgenteComercial(String cedula, String correo, String direccion, String nombreCompleto, String telefono1, Date fechaNacimiento, Date fechaExpediccion,
                    String contrasena, String loguin) {
        super(cedula, correo, direccion, nombreCompleto, telefono1, fechaNacimiento, fechaExpediccion);
        this.contrasena = contrasena;
        this.loguin = loguin;
    }

    //Este metodo nos sirve para poder registrar un cliente
    public boolean createAgenteComercial(AgenteComercial agenteComercial) {
        String consulta = "INSERT INTO agente_comercial (\n" +
                "    Cedula,\n" +
                "    Contraseña,\n" +
                "    Loguin,\n" +
                "    Correo,\n" +
                "    Celular,\n" +
                "    Nombre_Completo,\n" +
                "    Fecha_Nacimiento,\n" +
                "    Fecha_Expedicion,\n" +
                "    Direccion\n" +
                ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

        try (PreparedStatement stmt = conexionDB.establecerConexion().prepareStatement(consulta)) {
            stmt.setString(1, String.valueOf(agenteComercial.getCedula())); // Asegúrate de que el tipo de dato sea correcto
            stmt.setString(2, agenteComercial.getContrasena()); // En producción, deberías encriptarla
            stmt.setString(3, agenteComercial.getLoguin());
            stmt.setString(4, agenteComercial.getCorreo());
            stmt.setString(5, agenteComercial.getTelefono1());
            stmt.setString(6, agenteComercial.getNombreCompleto());
            stmt.setDate(7, agenteComercial.getFechaNacimientoSQL());
            stmt.setDate(8, agenteComercial.getFechaExpediccionSQL());
            stmt.setString(9, agenteComercial.getDireccion());

            stmt.executeUpdate();
            System.out.println("Agente comercial registrado exitosamente.");
            return true;

        } catch (SQLException e) {
            System.err.println("Error al registrar el agente comercial: " + e.getMessage());
            return false;
        }
    }
    public  boolean mostarCliente(){

       return false;
    }
    //metodo elimianr agenteComercial
    public void eliminarAgente(String cedula){
        //consuta sql
        String consulta = "DELETE FROM agente_comercial WHERE Cedula = ?;";

        try (PreparedStatement stmt = conexionDB.establecerConexion().prepareStatement(consulta)) {
            stmt.setString(1, cedula);
            stmt.executeUpdate();
            System.out.println("Agente comercial eliminado exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error al eliminar el agente comercial: " + e.getMessage());
        }
    }
    public void modificarAgente(){

    }
    public void registarContratocliente(){

    }
    public void registarContratoPropietario(){

    }

    //getters and setters

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getLoguin() {
        return loguin;
    }

    public void setLoguin(String loguin) {
        this.loguin = loguin;
    }

}
