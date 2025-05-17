package com.inmobilaria;

import com.inmobilaria.vista.VistaAgenteComercial;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Inbomiliaria S.A");
        VistaAgenteComercial vistaAgenteComercial = new VistaAgenteComercial();
        frame.add(vistaAgenteComercial.getVentana());
        frame.setSize(550,375);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}