package com.inmobilaria.modelo;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class Cliente extends Persona{

    private String telefono2;
    private final ConexionDB conexionDB = new ConexionDB();

    // contructores
    public Cliente(){}

    public Cliente(String cedula, String correo, String direccion, String nombreCompleto, String telefono1, Date fechaNacimiento, Date fechaExpediccion,
                   String telefon2){
        super(cedula, correo, direccion, nombreCompleto, telefono1, fechaNacimiento, fechaExpediccion);
        this.telefono2 = telefono2;
    }

    //metodos
    // agregar cliente
    public void agregar(JTextField cedula,
                        JTextField nombre,
                        JTextField direccion,
                        JTextField telefono1,
                        JTextField telefono2,
                        JTextField email,
                        JDateChooser fechanacimiento,
                        JDateChooser fechaExpedicion) {

        try {
            // Cambia esta línea si tu clase de conexión es diferente

            String sql = "INSERT INTO cliente (cedula, nombre_completo, correo, direccion, fecha_nacimiento, fecha_expedicion, telefono1, telefono2) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conexionDB.establecerConexion().prepareStatement(sql);

            // Convierte java.util.Date a java.sql.Date
            setFechaNacimiento(fechanacimiento.getDate());
            setFechaExpediccion(fechaExpedicion.getDate());

            //enviar los datos a sql
            ps.setString(1, cedula.getText());
            ps.setString(2, nombre.getText());
            ps.setString(3, email.getText());
            ps.setString(4, direccion.getText());
            ps.setDate(5, getFechaNacimientoSQL());
            ps.setDate(6, getFechaExpediccionSQL());
            ps.setString(7, telefono1.getText());
            ps.setString(8, telefono2.getText());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Cliente registrado exitosamente.");
            } else {
                System.out.println("No se pudo registrar el cliente.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // metodo actuliazar
    public void actualizar(JTextField cedula,
                           JTextField nombre,
                           JTextField direccion,
                           JTextField telefono1,
                           JTextField telefono2,
                           JTextField email,
                           JDateChooser fechanacimiento,
                           JDateChooser fechaExpedicion) {

        try {
            String sql = "UPDATE cliente SET nombre_completo=?, correo=?, direccion=?, fecha_nacimiento=?, fecha_expedicion=?, telefono1=?, telefono2=? WHERE cedula=?";
            PreparedStatement ps = conexionDB.establecerConexion().prepareStatement(sql);

            // Convierte java.util.Date a java.sql.Date
            setFechaNacimiento(fechanacimiento.getDate());
            setFechaExpediccion(fechaExpedicion.getDate());

            ps.setString(1, nombre.getText());
            ps.setString(2, email.getText());
            ps.setString(3, direccion.getText());
            ps.setDate(4, getFechaNacimientoSQL());
            ps.setDate(5, getFechaExpediccionSQL());
            ps.setString(6, telefono1.getText());
            ps.setString(7, telefono2.getText());
            ps.setString(8, cedula.getText());

            int filas = ps.executeUpdate();
            if (filas > 0) {
                JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente.");
            } else {
                System.out.println("No se pudo actualizar el cliente.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //metodo borrar
    public void eliminar(JTextField cedula) {
        try {
            setCedula(cedula.getText());

            String consulta = "DELETE FROM cliente WHERE cedula=?";

            PreparedStatement ps = conexionDB.establecerConexion().prepareCall(consulta);
            ps.setString(1, getCedula());

            int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar el cliente?",
                    "Confimación de elimnar cliente",JOptionPane.YES_NO_OPTION);

            if (respuesta == 0){
                ps.executeUpdate();
                JOptionPane.showMessageDialog(null,"Elimino Correctamente");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


    // getters and setters
    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }
}
