package com.inmobilaria.modelo;

import com.inmobilaria.enums.EstadoInmueble;
import com.inmobilaria.enums.ModalidadComercial;
import com.inmobilaria.enums.TipoInmueble;
import com.inmobilaria.enums.ValorInmueble;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Inmueble {
    private String codigo, descripcion, foto, direccion, departemento, ciudad;
    private double areaMts;
    private double precioFinalVenta;
    private TipoInmueble tipoInmueble;
    private ValorInmueble valorInmueble;
    private ModalidadComercial modalidadComercial;
    private EstadoInmueble estadoInmueble;
    private int cantidadBanos;

    private final ConexionDB conexionDB = new ConexionDB();

    public Inmueble(){

    }

    public Inmueble(String codigo, String descripcion, String foto, String direccion, String departemento, String ciudad,
                    double areaMts, double precioFinalVenta, TipoInmueble tipoInmueble, ValorInmueble valorInmueble,
                    ModalidadComercial modalidadComercial, EstadoInmueble estadoInmueble, int cantidadBanos) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.foto = foto;
        this.direccion = direccion;
        this.departemento = departemento;
        this.ciudad = ciudad;
        this.areaMts = areaMts;
        this.precioFinalVenta = precioFinalVenta;
        this.tipoInmueble = tipoInmueble;
        this.valorInmueble = valorInmueble;
        this.modalidadComercial = modalidadComercial;
        this.estadoInmueble = estadoInmueble;
        this.cantidadBanos = cantidadBanos;
    }

    /*
    Metodos para crear, acutilizar, elimar, mostrar, y leccionar
     */
    // Method to create a new record
    public void crearInmueble(Inmueble inmueble) {
        String sql = "INSERT INTO inmueble (codigo, descripcion, foto, bano, tamano_mts2, precio_final_venta, departamento, ciudad, cedula_cliente, id_tipo_inmueble, id_estado_inmueble, id_valor_inmueble)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexionDB.establecerConexion().prepareStatement(sql)) {
            ps.setString(1, inmueble.getCodigo());
            ps.setString(2, inmueble.getDescripcion());
            ps.setString(3, inmueble.getFoto());
            ps.setInt(4, inmueble.getCantidadBanos());
            ps.setDouble(5, inmueble.getAreaMts());
            ps.setDouble(6, inmueble.getPrecioFinalVenta());
            ps.setString(7, inmueble.getDepartemento());
            ps.setString(8, inmueble.getCiudad());
            ps.setString(9, inmueble.getDireccion()); // Assuming cedula_cliente is stored in direccion
            ps.setInt(10, inmueble.getTipoInmueble().ordinal());
            ps.setInt(11, inmueble.getEstadoInmueble().ordinal());
            ps.setInt(12, inmueble.getValorInmueble().ordinal());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inmueble creado exitosamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al crear inmueble: " + ex.getMessage());
        }
    }

    // Metodo actulizar inmueble
    public void actualizarInmueble(Inmueble inmueble) {
        String sql = "UPDATE inmueble SET descripcion = ?, foto = ?, bano = ?, tamano_mts2 = ?, precio_final_venta = ?, departamento = ?, ciudad = ?, cedula_cliente = ?, id_tipo_inmueble = ?, id_estado_inmueble = ?, id_valor_inmueble = ? WHERE codigo = ?";
        try (PreparedStatement ps = conexionDB.establecerConexion().prepareStatement(sql)) {
            ps.setString(1, inmueble.getDescripcion());
            ps.setString(2, inmueble.getFoto());
            ps.setInt(3, inmueble.getCantidadBanos());
            ps.setDouble(4, inmueble.getAreaMts());
            ps.setDouble(5, inmueble.getPrecioFinalVenta());
            ps.setString(6, inmueble.getDepartemento());
            ps.setString(7, inmueble.getCiudad());
            ps.setString(8, inmueble.getDireccion()); // Assuming cedula_cliente is stored in direccion
            ps.setInt(9, inmueble.getTipoInmueble().ordinal());
            ps.setInt(10, inmueble.getEstadoInmueble().ordinal());
            ps.setInt(11, inmueble.getValorInmueble().ordinal());
            ps.setString(12, inmueble.getCodigo());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inmueble actualizado exitosamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar inmueble: " + ex.getMessage());
        }
    }

    // Metodo mostrar imuebles en la tabla
    public void mostrarInmuebles(JTable tabla) {
        String sql = "SELECT * FROM inmueble";
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0); // Clear the table
        try (Statement st = conexionDB.establecerConexion().createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getString("codigo"),
                    rs.getString("descripcion"),
                    rs.getString("foto"),
                    rs.getInt("bano"),
                    rs.getDouble("tamano_mts2"),
                    rs.getDouble("precio_final_venta"),
                    rs.getString("departamento"),
                    rs.getString("ciudad"),
                    rs.getString("cedula_cliente"),
                    rs.getInt("id_tipo_inmueble"),
                    rs.getInt("id_estado_inmueble"),
                    rs.getInt("id_valor_inmueble")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al mostrar inmuebles: " + ex.getMessage());
        }
    }

    // Method to delete a record
    public void eliminarInmueble(String codigo) {
        String sql = "DELETE FROM inmueble WHERE codigo = ?";
        try (PreparedStatement ps = conexionDB.establecerConexion().prepareStatement(sql)) {
            ps.setString(1, codigo);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Inmueble eliminado exitosamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar inmueble: " + ex.getMessage());
        }
    }

    // Method to select a specific record
    public void seleccionarInmueble(JTable tabla, JTextField codigo, JTextField descripcion, JTextField foto, JTextField bano,
                                     JTextField tamanoMts2, JTextField precioFinalVenta, JTextField departamento, JTextField ciudad,
                                     JTextField cedulaCliente, JComboBox<String> idTipoInmueble, JComboBox<String> idEstadoInmueble, JComboBox<String> idValorInmueble) {
        int fila = tabla.getSelectedRow();
        if (fila >= 0) {
            codigo.setText(tabla.getValueAt(fila, 0).toString());
            descripcion.setText(tabla.getValueAt(fila, 1).toString());
            foto.setText(tabla.getValueAt(fila, 2).toString());
            bano.setText(tabla.getValueAt(fila, 3).toString());
            tamanoMts2.setText(tabla.getValueAt(fila, 4).toString());
            precioFinalVenta.setText(tabla.getValueAt(fila, 5).toString());
            departamento.setText(tabla.getValueAt(fila, 6).toString());
            ciudad.setText(tabla.getValueAt(fila, 7).toString());
            cedulaCliente.setText(tabla.getValueAt(fila, 8).toString());
            idTipoInmueble.setSelectedItem(tabla.getValueAt(fila, 9).toString());
            idEstadoInmueble.setSelectedItem(tabla.getValueAt(fila, 10).toString());
            idValorInmueble.setSelectedItem(tabla.getValueAt(fila, 11).toString());
        } else {
            JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila.");
        }
    }



    @Override
    public String toString() {
        return "Inmueble{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", foto='" + foto + '\'' +
                ", direccion='" + direccion + '\'' +
                ", departemento='" + departemento + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", areaMts=" + areaMts +
                ", precioFinalVenta=" + precioFinalVenta +
                ", tipoInmueble=" + tipoInmueble +
                ", valorInmueble=" + valorInmueble +
                ", modalidadComercial=" + modalidadComercial +
                ", estadoInmueble=" + estadoInmueble +
                ", cantidadBanos=" + cantidadBanos +
                '}';
    }

    public ValorInmueble getValorInmueble() {
        return valorInmueble;
    }

    public void setValorInmueble(ValorInmueble valorInmueble) {
        this.valorInmueble = valorInmueble;
    }

    public ModalidadComercial getModalidadComercial() {
        return modalidadComercial;
    }

    public void setModalidadComercial(ModalidadComercial modalidadComercial) {
        this.modalidadComercial = modalidadComercial;
    }

    public EstadoInmueble getEstadoInmueble() {
        return estadoInmueble;
    }

    public void setEstadoInmueble(EstadoInmueble estadoInmueble) {
        this.estadoInmueble = estadoInmueble;
    }

    public int getCantidadBanos() {
        return cantidadBanos;
    }

    public void setCantidadBanos(int cantidadBanos) {
        this.cantidadBanos = cantidadBanos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDepartemento() {
        return departemento;
    }

    public void setDepartemento(String departemento) {
        this.departemento = departemento;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public double getPrecioFinalVenta() {
        return precioFinalVenta;
    }

    public void setPrecioFinalVenta(double precioFinalVenta) {
        this.precioFinalVenta = precioFinalVenta;
    }

    public double getAreaMts() {
        return areaMts;
    }

    public void setAreaMts(double areaMts) {
        this.areaMts = areaMts;
    }

    public TipoInmueble getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(TipoInmueble tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

}
