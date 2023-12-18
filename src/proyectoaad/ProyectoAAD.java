/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoaad;

import java.sql.*;
import modelo.AccesoDAO;

/**
 *
 * @author Diurno
 */
public class ProyectoAAD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //VistaRun vista = new VistaRun();
        AccesoDAO ad = new AccesoDAO();
        ad.extraerDatosEmpleados();
        ad.extraerDatosIngresoRegistro();
        ad.extraerRegistroFaltas();
        ad.insertarFalta(5, 3, 4);
        ad.insertarEmpleado(7, "JUANA", "DOMINGUEZ", "69562952J", "ANALISTA");
        Timestamp tf1 = new Timestamp(123, 11, 19, 8, 00, 0, 0);
        Timestamp tf2 = new Timestamp(123, 11, 19, 17, 00, 0, 0);
        ad.insertarIngreso(32, 1, tf1, tf2);
    }
}
