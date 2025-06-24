package com.inmobilaria.modelo;

import com.inmobilaria.enums.ModalidadComercial;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;

public abstract class Contrato {
    private int codigo;
    private String descripcion;
    private Date fechaCreacion, fechaExpiracion;
    private double valor;
    private ModalidadComercial modalidadComercial;
    private final ConexionDB conexionDB = new ConexionDB();

    public Contrato(int codigo, String descripcion, Date fechaCreacion,
                    Date fechaExpiracion, double valor, ModalidadComercial modalidadComercial) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaExpiracion = fechaExpiracion;
        this.valor = valor;
        this.modalidadComercial = modalidadComercial;
    }

    public void cargarCodigosContratos(JComboBox<String> comboBox) {
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        String consulta = "SELECT codigo FROM contrato;";

        try {
            Statement st = conexionDB.establecerConexion().createStatement();
            ResultSet rs = st.executeQuery(consulta);

            while (rs.next()) {
                modelo.addElement(rs.getString("codigo"));
            }
            comboBox.setModel(modelo);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar códigos de contratos: " + e.getMessage());
        } finally {
            conexionDB.cerrarConexion();
        }
    }

    @Override
    public String toString() {
        return "Contrato{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaExpiracion=" + fechaExpiracion +
                ", valor=" + valor +
                ", modalidadComercial=" + modalidadComercial +
                '}';
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaExpiracion() {
        return fechaExpiracion;
    }

    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public ModalidadComercial getModalidadComercial() {
        return modalidadComercial;
    }

    public void setModalidadComercial(ModalidadComercial modalidadComercial) {
        this.modalidadComercial = modalidadComercial;
    }
}
