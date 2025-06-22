package com.inmobilaria.modelo;

import com.inmobilaria.enums.ModalidadComercial;

import java.time.LocalDate;
import java.util.Date;

public abstract class Contrato {
    private int codigo;
    private String descripcion;
    private Date fechaCreacion, fechaExpiracion;
    private double valor;
    private ModalidadComercial modalidadComercial;

    public Contrato(int codigo, String descripcion, Date fechaCreacion,
                    Date fechaExpiracion, double valor, ModalidadComercial modalidadComercial) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.fechaCreacion = fechaCreacion;
        this.fechaExpiracion = fechaExpiracion;
        this.valor = valor;
        this.modalidadComercial = modalidadComercial;
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
