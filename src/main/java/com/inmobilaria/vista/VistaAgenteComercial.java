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
        contratoPropietarioInmobliariaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaContratoPropietario propietario = new VistaContratoPropietario();
                propietario.setSize(500,250);
                propietario.setLocationRelativeTo(null);
                propietario.setVisible(true);
            }
        });
        contratoClienteInmbiliariaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaContratoCliente clientes = new VistaContratoCliente();
                clientes.setSize(550,350);
                clientes.setLocationRelativeTo(null);
                clientes.setVisible(true);
            }
        });

    }
    public JPanel getVentana() {
        return ventanaAgente;
    }
}
