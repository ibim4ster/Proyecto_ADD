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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Clase de ejemplo para crear un AccesoDAO y comprobar que se conecta
 *
 * @author Andrea
 */
public class RunEj {

    public static void main(String[] args) {
        //VistaRun vista = new VistaRun();
        AccesoDAO ad = new AccesoDAO();
        ad.extraerDatosEmpleados();
        ad.extraerDatosIngresoRegistro();
        ad.extraerRegistroFaltas();
        //ad.insertarFalta(4, 3, 4);

        String fechaString = "2022-01-21";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fecha = (java.sql.Date) dateFormat.parse(fechaString);
            ad.insertarEmpleado(6, "JUAN", "DOMINGUEZ", "69562452J", fecha, "ANALISTA");
        } catch (ParseException ex) {
            Logger.getLogger(RunEj.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
