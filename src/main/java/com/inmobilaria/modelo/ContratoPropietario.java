package com.inmobilaria.modelo;

import com.inmobilaria.enums.ModalidadComercial;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContratoPropietario extends Contrato{
    private String comision;
    private final ConexionDB conexionDB = new ConexionDB();

    public ContratoPropietario(int codigo, String descripcion, java.util.Date fechaCreacion, java.util.Date fechaExpiracion,
                               double valor, ModalidadComercial modalidadComercial) {
        super(codigo, descripcion, fechaCreacion, fechaExpiracion, valor, modalidadComercial);
        this.comision = comision;
    }

    // Method to create a new record
    public void crearContratoPropietario(String cedulaPropietario, String codigoContrato, double comision, double valor) {
        String sql = "INSERT INTO contrato_propietario (cedula_propietario, codigo_contrato, comision, valor) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conexionDB.establecerConexion().prepareStatement(sql)) {
            ps.setString(1, cedulaPropietario);
            ps.setString(2, codigoContrato);
            ps.setDouble(3, comision);
            ps.setDouble(4, valor);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Contrato creado exitosamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear contrato: " + ex.getMessage());
        }
    }

    // Method to update an existing record
    public void actualizarContratoPropietario(String cedulaPropietario, String codigoContrato, double comision, double valor) {
        String sql = "UPDATE contrato_propietario SET comision = ?, valor = ? WHERE cedula_propietario = ? AND codigo_contrato = ?";
        try (PreparedStatement ps = conexionDB.establecerConexion().prepareStatement(sql)) {
            ps.setDouble(1, comision);
            ps.setDouble(2, valor);
            ps.setString(3, cedulaPropietario);
            ps.setString(4, codigoContrato);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Contrato actualizado exitosamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar contrato: " + ex.getMessage());
        }
    }

    // metodo mostrar contratos porpietarios
    public void mostrarContratosPropietarios(JTable tabla) {
        String sql = "SELECT * FROM contrato_propietario";
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); // Limpiar la tabla
        try (Statement st = conexionDB.establecerConexion().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("cedula_propietario"),
                    rs.getString("codigo_contrato"),
                    rs.getDouble("comision"),
                    rs.getDouble("valor")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar contratos: " + ex.getMessage());
        }
    }

    // Metodo eliminar contrato propieatrio
    public void eliminarContratoPropietario(String cedulaPropietario, String codigoContrato) {
        String sql = "DELETE FROM contrato_propietario WHERE cedula_propietario = ? AND codigo_contrato = ?";
        try (PreparedStatement ps = conexionDB.establecerConexion().prepareStatement(sql)) {
            ps.setString(1, cedulaPropietario);
            ps.setString(2, codigoContrato);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Contrato eliminado exitosamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar contrato: " + ex.getMessage());
        }
    }

    // Metodo seleccionar fila de la tabla
    public void seleccionarContratoPropietario(JTable tabla, JTextField cedulaPropietario, JTextField codigoContrato,
                                               JTextField comision, JTextField valor) {
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            cedulaPropietario.setText(tabla.getValueAt(fila, 0).toString());
            codigoContrato.setText(tabla.getValueAt(fila, 1).toString());
            comision.setText(tabla.getValueAt(fila, 2).toString());
            valor.setText(tabla.getValueAt(fila, 3).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila.");
        }
    }

    // getters and setters

    public String getComision() {
        return comision;
    }

    public void setComision(String comision) {
        this.comision = comision;
    }
}
