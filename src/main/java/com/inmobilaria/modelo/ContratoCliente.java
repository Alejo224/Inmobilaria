package com.inmobilaria.modelo;

import com.inmobilaria.enums.ModalidadComercial;

import java.time.LocalDate;
import java.util.Date;

public class ContratoCliente extends Contrato{
    private String nombreFiador, telefonoFiador;

    public ContratoCliente(int codigo, String descripcion, Date fechaCreacion, Date fechaExpiracion,
                           double valor, ModalidadComercial modalidadComercial, String nombreFiador,
                           String telefonoFiador) {
        super(codigo, descripcion, fechaCreacion, fechaExpiracion, valor, modalidadComercial);

        this.nombreFiador = nombreFiador;
        this.telefonoFiador = telefonoFiador;
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
        /*
        ContratoCliente contratoCliente = new ContratoCliente(77,"descripcion", Date ,
                LocalDate.now().minusYears(2), 2388372.78, ModalidadComercial.VENTA,
                "fiador loal", "3249882");
        System.out.println(contratoCliente.toString());;
        System.out.println("nombre fiador = " + contratoCliente.getNombreFiador() + "\n" +
                "telefono fiador = " + contratoCliente.getTelefonoFiador());
                
         */
    }
}
