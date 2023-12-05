/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.*;

/**
 * Clase para crear la conexión a la base de datos
 * @author Andrea
 */
public class ConexionDB {

    // si no funciona la conexión con la primera, usar la segunda URL
    //private static final String URL = "jdbc:mysql://localhost:3306/acceso_datos";
    private static final String URL = "jdbc:mysql://localhost:3306/mydatabase?useSSL=false&allowPublicKeyRetrieval=true";

    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private Connection conexion = null;

    // constructor
    public ConexionDB() {
    }

    public Connection getConnection() {
        if (conexion == null) {
            System.out.println("INTENTO");

            try {
                conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException ex) {
                java.util.logging.Logger.getLogger(ConexionDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }

        return conexion;
    }

    public void desconectar() {

        try {
            conexion.close();
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ConexionDB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        conexion = null;
        System.out.println("Conexión cerrada");

    }

}
