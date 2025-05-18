package com.inmobilaria.vista;

import javax.swing.*;
import java.awt.event.*;

public class VistaAgenteComercial extends JDialog {
    private JPanel contentPane;
    private JButton buttonsalir;
    private JButton registrarClienteButton;
    private JButton contratoClienteMobiliariaButton;
    private JButton contratoPropietarioMobiliariaButton;

    public VistaAgenteComercial() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonsalir);

        buttonsalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        registrarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaRegistro Registro =new VistaRegistro();
                Registro.setSize(339,535);
                //Este comando lo utulizamos para centrar la ventane del Registro en toda la pantalla
                Registro.setLocationRelativeTo(null);
                Registro.setVisible(true);
            }
        });
        contratoClienteMobiliariaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaContratoCliente clientes = new VistaContratoCliente();
                clientes.setSize(550,350);
                clientes.setLocationRelativeTo(null);
                clientes.setVisible(true);
            }
        });
        contratoPropietarioMobiliariaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaContratoPropietario propietario = new VistaContratoPropietario();
                propietario.setSize(500,250);
                propietario.setLocationRelativeTo(null);
                propietario.setVisible(true);
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        VistaAgenteComercial dialog = new VistaAgenteComercial();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
