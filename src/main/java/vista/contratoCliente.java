package vista;

import javax.swing.*;

public class contratoCliente extends JDialog {
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


    public contratoCliente() {
        setContentPane(contentPane);
        setModal(true);

    }


    public static void main(String[] args) {
        contratoCliente dialog = new contratoCliente();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
