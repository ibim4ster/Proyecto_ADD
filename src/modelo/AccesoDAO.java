/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;

/**
 * Crear la conexión con ConexionDB y Connection
 *
 * @author Andrea
 */
public class AccesoDAO {

    static ConexionDB con;
    static Connection conexion;

    public AccesoDAO() {
        con = new ConexionDB();
        conexion = (Connection) con.getConnection();

        if (conexion != null) {
            // comprobar que se conecta
            System.out.println("CONECTADO");
        }
        //con.desconectar();
    }

    public void extraerDatosEmpleados() {
        try {
            System.out.println("En metodo extraerEmp");
            // Crear una sentencia SQL para seleccionar todos los datos de la tabla empleados
            String sql = "SELECT * FROM empleadosa";

            // Crear un Statement para ejecutar la consulta SQL
            Statement statement = conexion.createStatement();

            // Ejecutar la consulta y obtener los resultados en un ResultSet
            ResultSet resultSet = statement.executeQuery(sql);

            // Iterar a través del ResultSet e imprimir los datos de cada empleado
            while (resultSet.next()) {
                System.out.println("Tenemos registros");

                int id = resultSet.getInt(1);
                String nombre = resultSet.getString(2);
                String apellido = resultSet.getString(3);
                String DNI = resultSet.getString(4);
                Date fecha_contr = resultSet.getDate(5);
                String puesto = resultSet.getString(6);

                // Aquí puedes procesar los datos como desees, por ejemplo, imprimirlos en la consola
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido + ", DNI: "
                        + DNI + ", Fecha contrato: " + fecha_contr.toString() + ", Puesto: " + puesto);
                // Puedes imprimir otras columnas aquí si las tienes en tu tabla
            }

            // Cerrar el ResultSet, el Statement y la conexión
            resultSet.close();
            statement.close();
            // No cierres la conexión si planeas realizar más operaciones en la base de datos

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar cualquier excepción que pueda ocurrir durante la extracción de datos
        }
    }

    public void extraerDatosIngresoRegistro() {
        try {
            System.out.println("En metodo extraerIng");
            // Crear una sentencia SQL para seleccionar todos los datos de la tabla empleados
            String sql = "SELECT * FROM ingreso_registro";

            // Crear un Statement para ejecutar la consulta SQL
            Statement statement = conexion.createStatement();

            // Ejecutar la consulta y obtener los resultados en un ResultSet
            ResultSet resultSet = statement.executeQuery(sql);

            // Iterar a través del ResultSet e imprimir los datos de cada empleado
            while (resultSet.next()) {
                System.out.println("Tenemos registros");

                int id = resultSet.getInt(1);
                int idEmple = resultSet.getInt(2);
                Date fechaEntrada = resultSet.getDate(3);
                Date fechaSalida = resultSet.getDate(4);

                // Aquí puedes procesar los datos como desees, por ejemplo, imprimirlos en la consola
                System.out.println("ID: " + id + ", ID Empleado: " + idEmple + ", Fecha de entara: " + fechaEntrada + ", Fecha de salida: " + fechaSalida);
                // Puedes imprimir otras columnas aquí si las tienes en tu tabla
            }

            // Cerrar el ResultSet, el Statement y la conexión
            resultSet.close();
            statement.close();
            // No cierres la conexión si planeas realizar más operaciones en la base de datos

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar cualquier excepción que pueda ocurrir durante la extracción de datos
        }
    }

    public void extraerRegistroFaltas() {
        try {
            System.out.println("En metodo extraerExt");
            // Crear una sentencia SQL para seleccionar todos los datos de la tabla empleados
            String sql = "SELECT * FROM registro_faltas";

            // Crear un Statement para ejecutar la consulta SQL
            Statement statement = conexion.createStatement();

            // Ejecutar la consulta y obtener los resultados en un ResultSet
            ResultSet resultSet = statement.executeQuery(sql);

            // Iterar a través del ResultSet e imprimir los datos de cada empleado
            while (resultSet.next()) {
                System.out.println("Tenemos registros");

                int id = resultSet.getInt(1);
                int idEmple = resultSet.getInt(2);
                int diasFaltados = resultSet.getInt(3);

                // Aquí puedes procesar los datos como desees, por ejemplo, imprimirlos en la consola
                System.out.println("ID: " + id + ", ID Empleado: " + idEmple + ", Dias faltados: " + diasFaltados);
                // Puedes imprimir otras columnas aquí si las tienes en tu tabla
            }

            // Cerrar el ResultSet, el Statement y la conexión
            resultSet.close();
            statement.close();
            // No cierres la conexión si planeas realizar más operaciones en la base de datos

        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar cualquier excepción que pueda ocurrir durante la extracción de datos
        }
    }

    public void insertarFalta(int id, int idEmpleado, int totalDiasFaltados) {
        try {
            String queryINSERT = "INSERT INTO registro_faltas(ID, ID_EMPLEADO, TOTAL_DIAS_FALTADOS) VALUES(?, ?, ?);";
            // Crear un PreparedStatement para ejecutar la consulta SQL
            PreparedStatement sentencia = conexion.prepareStatement(queryINSERT);
            // Setear los valores de la consulta
            sentencia.setInt(1, id);
            sentencia.setInt(2, idEmpleado);
            sentencia.setInt(3, totalDiasFaltados);

            // Ejecutar la consulta de inserción
            int filasAfectadas = sentencia.executeUpdate();
            System.out.println("Filas afectadas: " + filasAfectadas);

            // Cerrar el PreparedStatement
            sentencia.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertarEmpleado(int id, String nombre, String apellido, String DNI, String puesto) {
        try {
            String queryINSERT = "INSERT INTO empleadosa(ID, NOMBRE, APELLIDO, DNI, FECHA_CONTRATACION, PUESTO) VALUES(?, ?, ?, ? ,NOW() ,?);";
            // Crear un PreparedStatement para ejecutar la consulta SQL
            PreparedStatement sentencia = conexion.prepareStatement(queryINSERT);
            // Setear los valores de la consulta
            sentencia.setInt(1, id);
            sentencia.setString(2, nombre);
            sentencia.setString(3, apellido);
            sentencia.setString(4, DNI);
//            sentencia.setDate(5, (java.sql.Date) Fecha_contratacion);
            sentencia.setString(5, puesto);
            // Ejecutar la consulta de inserción
            int filasAfectadas = sentencia.executeUpdate();
            System.out.println("Filas afectadas: " + filasAfectadas);

            // Cerrar el PreparedStatement
            sentencia.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
