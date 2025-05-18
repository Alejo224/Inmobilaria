package com.inmobilaria.vista;

import javax.swing.*;
import java.awt.event.*;

public class VistaLoguin extends JDialog {
    private JPanel ventanaLoguin;
    private JButton btnIngresar;
    private JButton buttonCancel;
    private JTextField txtContrasesña;
    private JTextField txtloguin;

    public VistaLoguin() {
        setContentPane(ventanaLoguin);
        setModal(true);
        getRootPane().setDefaultButton(btnIngresar);

        btnIngresar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
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
        ventanaLoguin.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaAgenteComercial agente = new VistaAgenteComercial();
                agente.setSize(350,212);
                agente.setLocationRelativeTo(null);
                agente.setVisible(true);

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
        VistaLoguin dialog = new VistaLoguin();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
    public JPanel getVentana() {
        return ventanaLoguin;
    }

}
