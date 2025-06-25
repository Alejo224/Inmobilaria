package com.inmobilaria.modelo;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AgenteComercial extends Persona{
    private String contrasena, loguin;
    private Propietario propietario;
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

    public java.sql.Date getFechaNacimientoSQL() {
        Date fechaNacimiento = getFechaNacimiento(); // Use the getter from Persona
        return fechaNacimiento != null ? new java.sql.Date(fechaNacimiento.getTime()) : null;
    }

    public java.sql.Date getFechaExpediccionSQL() {
        Date fechaExpediccion = getFechaExpediccion(); // Use the getter from Persona
        return fechaExpediccion != null ? new java.sql.Date(fechaExpediccion.getTime()) : null;
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
    public boolean registrarPropietario(String cedula, String correo, String direccion, String nombreCompleto, String telefono1, String telefono2,
                                     Date fechaNacimiento, Date fechaExpediccion){

        String consulta= "INSERT INTO propietario (cedula, correo, direccion, nombre_completo, telefono1, telefono2, fecha_nacimiento, fecha_expedicion) " +
                       "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        propietario = new Propietario(cedula,correo,direccion,nombreCompleto,telefono1,telefono2,fechaNacimiento,fechaExpediccion);

        try(Connection conn = conexionDB.establecerConexion();
            PreparedStatement statement = conn.prepareStatement(consulta)) {

            statement.setString(1,propietario.getCedula());
            statement.setString(2,propietario.getCorreo());
            statement.setString(3,propietario.getDireccion());
            statement.setString(4,propietario.getNombreCompleto());
            statement.setString(5,propietario.getTelefono1());
            statement.setString(6,propietario.getTelefono2());
            statement.setDate(7,new java.sql.Date(propietario.getFechaNacimiento().getTime()));
            statement.setDate(8,new java.sql.Date(propietario.getFechaExpediccion().getTime()));

            int filaInsertada = statement.executeUpdate();

            if(filaInsertada > 0){
                JOptionPane.showMessageDialog(null,"Registro guardado","Exito",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Se registro Propietario");
                return true;
            }
            else{
                System.out.println("No se registro");
            }

        }catch (SQLException e){
            System.out.println("Error al registrar" + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    public List<Propietario> obtenerListaPropietarios() {
        List<Propietario> lista = new ArrayList<>();
        String sql = "SELECT * FROM propietario";

        try (Connection conn = conexionDB.establecerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Propietario p = new Propietario(
                        rs.getString("cedula"),
                        rs.getString("correo"),
                        rs.getString("direccion"),
                        rs.getString("nombre_completo"),
                        rs.getString("telefono1"),
                        rs.getString("telefono2"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getDate("fecha_expedicion")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore al guardar");
        }

        return lista;
    }

    public boolean EliminarRegistroPropietario(String cedula){

        String consulta= "DELETE FROM propietario WHERE cedula =?";

        try(Connection conn = conexionDB.establecerConexion();
            PreparedStatement ps = conn.prepareStatement(consulta)){

            ps.setString(1,cedula);
            int filaInsertada = ps.executeUpdate();

            if(filaInsertada > 0 ){
                JOptionPane.showMessageDialog(null,"Eliminado Correctamente","Eliminado",JOptionPane.PLAIN_MESSAGE);
                System.out.println("Eliminado");
                return true;
            }
            else {
                System.out.println("No se encontro esa ccedula");
            }

        }catch (SQLException e){
            System.out.println("Error al Eliminar el propietario");
        }
        return false;
    }
    public boolean regisrto(Propietario propietario){
        String consulta= "INSERT INTO propietario (cedula, correo, direccion, nombre_completo, telefono1, telefono2, fecha_nacimiento, fecha_expedicion) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try(Connection conn = conexionDB.establecerConexion();
            PreparedStatement statement = conn.prepareStatement(consulta)) {

            statement.setString(1,propietario.getCedula());
            statement.setString(2,propietario.getCorreo());
            statement.setString(3,propietario.getDireccion());
            statement.setString(4,propietario.getNombreCompleto());
            statement.setString(5,propietario.getTelefono1());
            statement.setString(6,propietario.getTelefono2());
            statement.setDate(7,new java.sql.Date(propietario.getFechaNacimiento().getTime()));
            statement.setDate(8,new java.sql.Date(propietario.getFechaExpediccion().getTime()));

            int filaInsertada = statement.executeUpdate();

            if(filaInsertada > 0){
                JOptionPane.showMessageDialog(null,"Registro guardado","Exito",JOptionPane.INFORMATION_MESSAGE);
                System.out.println("Se registro Propietario");
                return true;
            }
            else{
                System.out.println("No se registro");
            }

        }catch (SQLException e){
            System.out.println("Error al registrar" + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

      public List<Cliente> obtenerListaClientes() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM propietario";

        try (Connection conn = conexionDB.establecerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                    Cliente c = new Cliente(
                        rs.getString("cedula"),
                        rs.getString("correo"),
                        rs.getString("direccion"),
                        rs.getString("nombre_completo"),
                        rs.getString("telefono1"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getDate("fecha_expedicion"),
                            rs.getString("telefono2")
                );
                lista.add(c);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Errore al guardar");
        }

        return lista;
    }

}
