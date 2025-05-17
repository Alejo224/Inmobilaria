package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaLoguin {
    private JButton salirButton;
    private JButton ingresarButton;
    private JTextField txtLoguin;
    private JTextField txtContraseña;
    private JPanel ventanaLoguin;

    public ventanaLoguin() {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaAgenteComercial comercial = new ventanaAgenteComercial();

            }
        });
    }
}
