package com.inmobilaria;

import vista.AgenteComercial;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Inbomiliaria S.A");
        AgenteComercial agenteComercial = new AgenteComercial();
        frame.add(agenteComercial.getVentana());
        frame.setSize(350,285);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}