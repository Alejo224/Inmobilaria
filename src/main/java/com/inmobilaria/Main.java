package com.inmobilaria;


import com.inmobilaria.modelo.AgenteComercial;
import com.inmobilaria.modelo.ConexionDB;
import com.inmobilaria.modelo.Propietario;
import com.inmobilaria.vista.VistaLoguin;

import java.sql.Connection;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        VistaLoguin loguin = new VistaLoguin();
        loguin.setVisible(true);
        loguin.setLocationRelativeTo(null);


    }
}