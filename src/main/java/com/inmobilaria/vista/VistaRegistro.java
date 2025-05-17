package com.inmobilaria.vista;

import javax.swing.*;
import java.awt.event.*;

public class VistaRegistro extends JDialog {
    private JPanel contentPane;
    private JButton btnRegistrar;
    private JButton buttonCancel;
    private JTextField textDireccion;
    private JTextField txtTelefono2;
    private JTextField txtTelefono1;
    private JTextField txtCorreo;
    private JTextField txtFechaExp;
    private JTextField txtFechaNacimento;
    private JTextField txtCedula;
    private JTextField txtNombres;
    private JTextField txtApellidos;

    public VistaRegistro() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(btnRegistrar);

        btnRegistrar.addActionListener(new ActionListener() {
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
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
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
        VistaRegistro dialog = new VistaRegistro();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
