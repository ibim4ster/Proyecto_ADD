/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import vista.VistaRun;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Clase de ejemplo para crear un AccesoDAO y comprobar que se conecta
 * @author Andrea
 */
public class RunEj {
    public static void main(String[] args) {
        //VistaRun vista = new VistaRun();
        AccesoDAO ad = new AccesoDAO();
        ad.extraerDatosEmpleados();


    }

}
