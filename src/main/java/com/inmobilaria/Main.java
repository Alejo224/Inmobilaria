package com.inmobilaria;

import com.inmobilaria.modelo.AgenteComercial;
import com.inmobilaria.vista.VistaAgenteComercial;

import javax.swing.*;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AgenteComercial comercial = new AgenteComercial(155,"Pedro","zapata",15/225,155,"pedro@gg",351,"carnalito","122");
        JFrame frame = new JFrame("Inbomiliaria S.A");
        VistaAgenteComercial agenteComercial = new VistaAgenteComercial();
        frame.add(agenteComercial.getVentana());
        frame.setSize(350,285);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        //esto es de practica para saber si el metodo funciona correctamente

        int cedula,fechaN,fechaExpe,telefono;
        String nombre, correo,apellidos;
        Scanner teclado = new Scanner(System.in);
        System.out.println("ingrese cedula");
        cedula = teclado.nextInt();
        System.out.println("ingrese telefono");
        telefono = teclado.nextInt();
        System.out.println("ingrese fach N");
        fechaN = teclado.nextInt();
        System.out.println("ingrese fecha expe");
        fechaExpe = teclado.nextInt();
        teclado = new Scanner(System.in);
        System.out.println("ingrese correo");
        correo = teclado.nextLine();
        System.out.println("ingrese nombres");
        nombre = teclado.nextLine();
        System.out.println("ingrese apellidos");
        apellidos = teclado.nextLine();

        comercial.registrarCliente(cedula,nombre,fechaN,fechaExpe,correo,telefono,apellidos);
        System.out.println(comercial.mostarCliente());

    }
}