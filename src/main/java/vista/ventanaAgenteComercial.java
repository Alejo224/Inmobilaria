package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ventanaAgenteComercial {
    private JButton registrarClienteButton;
    private JPanel ventanaAgente;
    private JButton contratoPropietarioInmobliariaButton;
    private JButton contratoClienteInmbiliariaButton;

    public ventanaAgenteComercial() {
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
        contratoPropietarioInmobliariaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contratoPropietario propietario = new contratoPropietario();
                propietario.setSize(500,250);
                propietario.setLocationRelativeTo(null);
                propietario.setVisible(true);
            }
        });
        contratoClienteInmbiliariaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contratoCliente clientes = new contratoCliente();
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
