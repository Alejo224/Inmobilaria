package com.inmobilaria;

import com.inmobilaria.modelo.AgenteComercial;
import vista.ventanaAgenteComercial;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AgenteComercial comercial = new AgenteComercial(155,"Pedro","zapata",15/225,155,"pedro@gg",351,"carnalito","122");
        JFrame frame = new JFrame("Inbomiliaria S.A");
        ventanaAgenteComercial agenteComercial = new ventanaAgenteComercial();
        frame.add(agenteComercial.getVentana());
        frame.setSize(350,285);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        comercial.registrarCliente(111,"Kevin",15,02/45,"kevon@",315222,"zuluaga");
        System.out.println(comercial.toString());
    }
}