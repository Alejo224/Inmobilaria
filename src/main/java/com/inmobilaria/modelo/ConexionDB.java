package com.inmobilaria.modelo;

import java.sql.*;

/**
 * Configuración de la conexión JDBC de forma centralizada.
**/

public class ConexionDB {

    Connection connection = null;
    private final String user = System.getenv("DB_USER");
    private final String password = System.getenv("DB_PASSWORD");
    private final String url = System.getenv("DB_URL");

    private static final String DRIVER_MSQL = "com.mysql.cj.jdbc.Driver";
    private static final String DRIVER_POSTGRESQL = "org.postgresql.Driver";

    public Connection establecerConexion() {
        System.out.println("Conectando ...");
        try {
            Class.forName(DRIVER_MSQL);
            connection = java.sql.DriverManager.getConnection(url, user, password);
            System.out.println("Se conecto a la base de datos correctamente");
        } catch (Exception e) {
            System.out.println("Error al conectar a la base de datos: " + e);
        }
        return connection;
    }

    public void cerrarConexion(){
        try{
            if (connection != null && !connection.isClosed() ){
                connection.close();
                System.out.println("La conexion fue cerrada correctamente");
            }
        } catch (SQLException e){
            System.out.println("La conexion no fue cerrada correctamente \n " + e);
        }
    }
}
