package com.inmobilaria.modelo;

import com.inmobilaria.enums.ModalidadComercial;
import com.toedter.calendar.JDateChooser;
import java.math.BigDecimal;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;

public class Contrato {
    private int codigo;
    private String descripcion;
    private Date fechaCreacion, fechaExpiracion;
    private double valor;
    private ModalidadComercial modalidadComercial;
    private final ConexionDB conexionDB = new ConexionDB();
    private ContratoCliente contratoCliente;

    public Contrato(){};
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

    public void crearContratoCliente(JTextField codigo, JTextField descripcion, ButtonGroup tipoContratoGroup,
                          JDateChooser fechaCreacion, JDateChooser fechaExpiracion, JComboBox<String> cedulaAgenteCom, JComboBox<String> cedulaCliente,
                          JTextField nombreFiador, JTextField valor, JTextField numeroFiador) {
    String consulta = "INSERT INTO contrato (codigo, descripcion, fecha_creacion, id_tipo_contrato, fecha_expiracion, cedula_agentecom) VALUES (?, ?, ?, ?, ?, ?)";
    ButtonModel selectedModel = tipoContratoGroup.getSelection();

    if (selectedModel == null) {
        JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de contrato.");
        return; // Exit the method if no selection is made
    }
    if (fechaCreacion == null) fechaCreacion = new JDateChooser();
    if (fechaExpiracion== null) fechaExpiracion = new JDateChooser();

    int idTipoContrato = selectedModel.getActionCommand().equals("venta") ? 1 : 2;

    try {
        PreparedStatement ps = conexionDB.establecerConexion().prepareStatement(consulta);
        ps.setString(1, codigo.getText());
        ps.setString(2, descripcion.getText());
        ps.setDate(3, new java.sql.Date(fechaCreacion.getDate().getTime()));
        ps.setInt(4, idTipoContrato);
        ps.setDate(5, new java.sql.Date(fechaExpiracion.getDate().getTime()));
        ps.setString(6, cedulaAgenteCom.getSelectedItem().toString());

        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Contrato creado exitosamente.");
        
        if (contratoCliente == null){
            contratoCliente = new ContratoCliente();
        }
        
        BigDecimal valorConvertido = new BigDecimal(valor.getText());
        contratoCliente.crear(cedulaCliente.getSelectedItem().toString(), codigo.getText(), nombreFiador.getText(),
                valorConvertido.doubleValue(), numeroFiador.getText());

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al crear contrato: " + e.getMessage());
    } finally {
        conexionDB.cerrarConexion();
    }
}

    public void actualizarContrato(JTextField codigo, JTextField descripcion, ButtonGroup tipoContratoGroup,
                                   JDateChooser fechaCreacion, JDateChooser fechaExpiracion, JComboBox<String> cedulaAgenteCom) {
        String consulta = "UPDATE contrato SET descripcion = ?, fecha_creacion = ?, id_tipo_contrato = ?, fecha_expiracion = ?, cedula_agentecom = ? WHERE codigo = ?";
        int idTipoContrato = tipoContratoGroup.getSelection().getActionCommand().equals("venta") ? 1 : 2;

        try {
            PreparedStatement ps = conexionDB.establecerConexion().prepareStatement(consulta);
            ps.setString(1, descripcion.getText());
            ps.setDate(2, new java.sql.Date(fechaCreacion.getDate().getTime()));
            ps.setInt(3, idTipoContrato);
            ps.setDate(4, new java.sql.Date(fechaExpiracion.getDate().getTime()));
            ps.setString(5, cedulaAgenteCom.getSelectedItem().toString());
            ps.setString(6, codigo.getText());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Contrato actualizado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar contrato: " + e.getMessage());
        } finally {
            conexionDB.cerrarConexion();
        }
    }

    public void eliminarContrato(JTextField codigo) {
        String consulta = "DELETE FROM contrato WHERE codigo = ?";

        try {
            PreparedStatement ps = conexionDB.establecerConexion().prepareStatement(consulta);
            ps.setString(1, codigo.getText());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Contrato eliminado exitosamente.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar contrato: " + e.getMessage());
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
