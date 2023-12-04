/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Crear la conexión con ConexionDB y Connection
 * @author Andrea
 */
public class AccesoDAO {
    private static ConexionDB con;
    private static Connection conexion;
    
    public AccesoDAO() {
        con = new ConexionDB();
        conexion = (Connection) con.getConnection();

        if (conexion != null) {
            // comprobar que se conecta
            System.out.println("Hola");
        }
        //con.desconectar();
    }
}
