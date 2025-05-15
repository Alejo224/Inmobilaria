package com.inmobilaria.modelo;

import com.inmobilaria.enums.EstadoInmueble;
import com.inmobilaria.enums.ModalidadComercial;
import com.inmobilaria.enums.TipoInmueble;
import com.inmobilaria.enums.ValorInmueble;

public class Inmueble {
    private String codigo, descripcion, foto, direccion, departemento, ciudad;
    private double areaMts;
    private double precioFinalVenta;
    private TipoInmueble tipoInmueble;
    private ValorInmueble valorInmueble;
    private ModalidadComercial modalidadComercial;
    private EstadoInmueble estadoInmueble;
    private int cantidadBanos;

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
