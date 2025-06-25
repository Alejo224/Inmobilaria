package com.inmobilaria.modelo;

import com.inmobilaria.enums.ModalidadComercial;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class ContratoCliente extends Contrato{
    private String nombreFiador, telefonoFiador;
    private final ConexionDB conexionDB = new ConexionDB();

    public ContratoCliente(){}
    
    public ContratoCliente(int codigo, String descripcion, Date fechaCreacion, Date fechaExpiracion,
                           double valor, ModalidadComercial modalidadComercial, String nombreFiador,
                           String telefonoFiador) {
        super(codigo, descripcion, fechaCreacion, fechaExpiracion, valor, modalidadComercial);

        this.nombreFiador = nombreFiador;
        this.telefonoFiador = telefonoFiador;
    }

    //metoods crear
    // CREAR (Insertar)
    public void crear(String cedulaCliente, String codigoContrato, String nombreFiador, double valor, String numeroFiador) {
        String sql = "INSERT INTO contrato_cliente (cedula_cliente, codigo_contrato, nombre_fiador, valor, numero_fiador) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = conexionDB.establecerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cedulaCliente);
            ps.setString(2, codigoContrato);
            ps.setString(3, nombreFiador);
            ps.setDouble(4, valor);
            ps.setString(5, numeroFiador);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Contrato-Cliente creado exitosamente.");
            } else {
                System.out.println("No se pudo crear el Contrato-Cliente.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // ACTUALIZAR
    public void actualizar(String cedulaCliente, String codigoContrato, String nombreFiador, double valor, String numeroFiador) {
        String sql = "UPDATE contrato_cliente SET nombre_fiador=?, valor=?, numero_fiador=? WHERE cedula_cliente=? AND codigo_contrato=?";
        try (Connection con = conexionDB.establecerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nombreFiador);
            ps.setDouble(2, valor);
            ps.setString(3, numeroFiador);
            ps.setString(4, cedulaCliente);
            ps.setString(5, codigoContrato);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Contrato-Cliente actualizado exitosamente.");
            } else {
                System.out.println("No se pudo actualizar el Contrato-Cliente.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // ELIMINAR
    public void eliminar(String cedulaCliente, String codigoContrato) {
        String sql = "DELETE FROM contrato_cliente WHERE cedula_cliente=? AND codigo_contrato=?";
        try (Connection con = conexionDB.establecerConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cedulaCliente);
            ps.setString(2, codigoContrato);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                System.out.println("Contrato-Cliente eliminado exitosamente.");
            } else {
                System.out.println("No se pudo eliminar el Contrato-Cliente.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // MOSTRAR en la tabla(Llenar JTable)
    public void mostrar(JTable tabla) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Cédula Cliente");
        modelo.addColumn("Código Contrato");
        modelo.addColumn("Nombre Fiador");
        modelo.addColumn("Valor");
        modelo.addColumn("Número Fiador");
        
        tabla.setModel(modelo);
        String sql = "SELECT * FROM contrato_cliente";
        
        try  {
            
            Statement st = conexionDB.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Object[] fila = new Object[]{
                    rs.getString("cedula_cliente"),
                    rs.getString("codigo_contrato"),
                    rs.getString("nombre_fiador"),
                    rs.getBigDecimal("valor"),
                    rs.getString("numero_fiador")
                };
                System.out.println("Agregando fila: " + Arrays.toString(fila));
                modelo.addRow(fila);
            }
            tabla.setModel(modelo);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar contratos de clientes: " + ex);
        }
    }

    public String getNombreFiador() {
        return nombreFiador;
    }

    public void setNombreFiador(String nombreFiador) {
        this.nombreFiador = nombreFiador;
    }

    public String getTelefonoFiador() {
        return telefonoFiador;
    }

    public void setTelefonoFiador(String telefonoFiador) {
        this.telefonoFiador = telefonoFiador;
    }

    public static void main(String[] args) {
    }
}
