package com.inmobilaria.vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaLoguin {
    private JButton salirButton;
    private JButton ingresarButton;
    private JTextField txtLoguin;
    private JTextField txtContraseña;
    private JPanel ventanaLoguin;

    public VistaLoguin() {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaAgenteComercial comercial = new VistaAgenteComercial();

            }
        });
    }
}
