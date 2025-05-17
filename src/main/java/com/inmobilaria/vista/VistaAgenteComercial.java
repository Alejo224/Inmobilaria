package com.inmobilaria.vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaAgenteComercial {
    private JButton registrarClienteButton;
    private JPanel ventanaAgente;
    private JButton contratoPropietarioInmobliariaButton;
    private JButton contratoClienteInmbiliariaButton;

    public VistaAgenteComercial() {
        registrarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaRegistro Registro =new VistaRegistro();
                Registro.setSize(500,400);
                //Este comando lo utulizamos para centrar la ventane del Registro en toda la pantalla
                Registro.setLocationRelativeTo(null);
                Registro.setVisible(true);
            }
        });
    }
    public JPanel getVentana() {
        return ventanaAgente;
    }
}
