package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgenteComercial {
    private JButton registrarClienteButton;
    private JPanel ventanaAgente;
    private JButton contratoPropietarioInmobliariaButton;
    private JButton contratoClienteInmbiliariaButton;

    public AgenteComercial() {
        registrarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vistaRegistro Registro =new vistaRegistro();
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
