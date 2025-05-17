package com.inmobilaria.vista;

import javax.swing.*;

public class VistaContratoCliente extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton ventaRadioButton;
    private JRadioButton alquilerRadioButton;
    private JTextField txtCodigo;
    private JTextField txtNombreFiador;
    private JTextField txtnumeroFiador;
    private JTextField txtfechaExpedi;
    private JTextField txtfechaCreacion;
    private JTextField txtDescripcion;
    private JTextField txtValor;


    public VistaContratoCliente() {
        setContentPane(contentPane);
        setModal(true);

    }


    public static void main(String[] args) {
        VistaContratoCliente dialog = new VistaContratoCliente();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
