package com.inmobilaria.controlador;

import com.inmobilaria.vista.VistaContratoPropietario;

import java.awt.event.*;

public class ContratoPropietarioCtrl implements ActionListener {
    private VistaContratoPropietario vistaContratoPropietario;

    public ContratoPropietarioCtrl(VistaContratoPropietario vistaContratoPropietario){
        this.vistaContratoPropietario = vistaContratoPropietario;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(vistaContratoPropietario.getButtonGuardar())){
            System.out.println("Boton guardar");
        }
        if (e.getSource().equals(vistaContratoPropietario.getButtonSalir())){
            if (vistaContratoPropietario == null) vistaContratoPropietario = new VistaContratoPropietario();
            System.out.println("boton salir");
        }
    }
}
