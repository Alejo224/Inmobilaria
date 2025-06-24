package com.inmobilaria.modelo;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente extends Persona{

    private String telefono2, apellido;
    private final ConexionDB conexionDB = new ConexionDB();

    // contructores
    public Cliente(){}

    public Cliente(String cedula, String correo, String direccion, String nombreCompleto, String apellido, String telefono1, Date fechaNacimiento, Date fechaExpediccion,
                   String telefon2){
        super(cedula, correo, direccion, nombreCompleto, telefono1, fechaNacimiento, fechaExpediccion);
        this.telefono2 = telefono2;
        this.apellido = apellido;
    }

    //metodos
    // agregar cliente
    public void agregar(JTextField cedula,
                        JTextField nombre,
                        JTextField apellido,
                        JTextField direccion,
                        JTextField telefono1,
                        JTextField telefono2,
                        JTextField email,
                        JDateChooser fechanacimiento,
                        JDateChooser fechaExpedicion) {

        try {
            // Cambia esta línea si tu clase de conexión es diferente

            String sql = "INSERT INTO cliente (cedula, nombres, apellidos, correo, direccion, fecha_nacimiento, fecha_expedicion, telefono1, telefono2) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
            PreparedStatement ps = conexionDB.establecerConexion().prepareStatement(sql);

            setFechaNacimiento(fechanacimiento.getDate());
            setFechaExpediccion(fechaExpedicion.getDate());

            //enviar los datos a sql
            ps.setString(1, cedula.getText());
            ps.setString(2, nombre.getText());
            ps.setString(3, apellido.getText());
            ps.setString(4, email.getText());
            ps.setString(5, direccion.getText());
            ps.setDate(6, getFechaNacimientoSQL());
            ps.setDate(7, getFechaExpediccionSQL());
            ps.setString(8, telefono1.getText());
            ps.setString(9, telefono2.getText());

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
                           JTextField apellido,
                           JTextField direccion,
                           JTextField telefono1,
                           JTextField telefono2,
                           JTextField email,
                           JDateChooser fechanacimiento,
                           JDateChooser fechaExpedicion) {

        try {
            String sql = "UPDATE cliente SET nombres=?, apellidos=?, correo=?, direccion=?, fecha_nacimiento=?, fecha_expedicion=?, telefono1=?, telefono2=? WHERE cedula=?";
            PreparedStatement ps = conexionDB.establecerConexion().prepareStatement(sql);

            // Convierte java.util.Date a java.sql.Date
            setFechaNacimiento(fechanacimiento.getDate());
            setFechaExpediccion(fechaExpedicion.getDate());

            ps.setString(1, nombre.getText());
            ps.setString(2, apellido.getText());
            ps.setString(3, email.getText());
            ps.setString(4, direccion.getText());
            ps.setDate(5, getFechaNacimientoSQL());
            ps.setDate(6, getFechaExpediccionSQL());
            ps.setString(7, telefono1.getText());
            ps.setString(8, telefono2.getText());
            ps.setString(9, cedula.getText());

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

    //mostrar clientes
    public void mostrar(JTable tablaCliente) {
        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Cédula");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Correo");
        modelo.addColumn("Dirección");
        modelo.addColumn("Fecha Nacimiento");
        modelo.addColumn("Fecha Expedición");
        modelo.addColumn("Teléfono 1");
        modelo.addColumn("Teléfono 2");

        if (tablaCliente == null) {
            tablaCliente = new JTable();
        }

        tablaCliente.setModel(modelo);
        String consulta = "SELECT * FROM cliente;";

        try {
            Statement st = conexionDB.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {
                // Si quieres, puedes tener métodos set... y get...,
                // pero aquí lo hago directo para mayor claridad:
                Object[] fila = new Object[] {
                        rs.getString("cedula"),
                        rs.getString("nombres"),
                        rs.getString("apellidos"),
                        rs.getString("correo"),
                        rs.getString("direccion"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getDate("fecha_expedicion"),
                        rs.getString("telefono1"),
                        rs.getString("telefono2")
                };
                modelo.addRow(fila);
            }
            tablaCliente.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        } finally {
            conexionDB.cerrarConexion();
        }
    }

    //selecionar fila de la tabla
    public void seleccionar(JTable tablaCliente,
                            JTextField cedula,
                            JTextField nombre,
                            JTextField apellido,
                            JTextField direccion,
                            JTextField telefono1,
                            JTextField telefono2,
                            JTextField email,
                            JDateChooser fechanacimiento,
                            JDateChooser fechaExpedicion) {
        int fila = tablaCliente.getSelectedRow(); // Obtener la fila seleccionada
        if (fila >= 0) {
            // Obtener los valores de la fila seleccionada y asignarlos a los campos correspondientes
            cedula.setText(tablaCliente.getValueAt(fila, 0).toString());
            nombre.setText(tablaCliente.getValueAt(fila, 1).toString());
            apellido.setText(tablaCliente.getValueAt(fila, 2).toString());
            email.setText(tablaCliente.getValueAt(fila, 3).toString());
            direccion.setText(tablaCliente.getValueAt(fila, 4).toString());
            telefono1.setText(tablaCliente.getValueAt(fila, 7).toString());
            telefono2.setText(tablaCliente.getValueAt(fila, 8).toString());

            // Formatear las fechas y asignarlas a los JDateChooser
            String fechaNacimientoTexto = tablaCliente.getValueAt(fila, 5).toString();
            String fechaExpedicionTexto = tablaCliente.getValueAt(fila, 6).toString();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            try {
                java.util.Date fechaNacimiento = formato.parse(fechaNacimientoTexto);
                fechanacimiento.setDate(fechaNacimiento);

                java.util.Date fechaExpedicio = formato.parse(fechaExpedicionTexto);
                fechaExpedicion.setDate(fechaExpedicio);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Error al convertir las fechas: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila.");
        }
    }

    //listar las cedulas desde un combo box
    public void listarCedulas(JComboBox<String> comboBox) {
        comboBox.removeAllItems(); // Limpiar el JComboBox antes de agregar nuevos elementos
        String consulta = "SELECT cedula FROM cliente";

        try {
            Statement st = conexionDB.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {
                comboBox.addItem(rs.getString("cedula")); // Agregar cada cédula al JComboBox
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar cédulas: " + ex.getMessage());
        } finally {
            conexionDB.cerrarConexion();
        }
    }

    // getters and setters
    public String getTelefono2() {
        return telefono2;
    }

    public void setTelefono2(String telefono2) {
        this.telefono2 = telefono2;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApelldio(String apellido) {
        this.apellido = apellido;
    }

}
