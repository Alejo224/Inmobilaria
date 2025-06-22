package com.inmobilaria.modelo;

import com.inmobilaria.enums.ModalidadComercial;

public class ContratoPropietario extends Contrato{
    private String comision;

    public ContratoPropietario(int codigo, String descripcion, java.util.Date fechaCreacion, java.util.Date fechaExpiracion,
                               double valor, ModalidadComercial modalidadComercial, String nombrePropietario,
                               String telefonoPropietario) {
        super(codigo, descripcion, fechaCreacion, fechaExpiracion, valor, modalidadComercial);
        this.comision = comision;
    }


}
