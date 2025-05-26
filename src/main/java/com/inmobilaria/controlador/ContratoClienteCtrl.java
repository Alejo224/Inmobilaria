package com.inmobilaria.controlador;

import com.inmobilaria.vista.VistaContratoCliente;

import java.awt.event.*;

public class ContratoClienteCtrl implements ActionListener {
    private VistaContratoCliente vistaContratoCliente;

    public ContratoClienteCtrl(VistaContratoCliente vistaContratoCliente){
        this.vistaContratoCliente = vistaContratoCliente;
    }

    /**
     * metodo para obtener el evento de la ventana para comunicarse con el modelo
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vistaContratoCliente.getButtonGuardar())){
            System.out.println("Boton guardar");
        }

        if (e.getSource().equals(vistaContratoCliente.getButtonSalir())){
            System.out.println("Boton Salir");
        }
    }
}
