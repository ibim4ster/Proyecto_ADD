/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


/**
 * Crear la conexión con ConexionDB y Connection
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
            String sql = "SELECT * FROM empleados";

            // Crear un Statement para ejecutar la consulta SQL
            Statement statement = conexion.createStatement();

            // Ejecutar la consulta y obtener los resultados en un ResultSet
            ResultSet resultSet = statement.executeQuery(sql);

            // Iterar a través del ResultSet e imprimir los datos de cada empleado
            while (resultSet.next()) {
                System.out.println("Tenemos registros");
                
                int id = resultSet.getInt("ID");
                String nombre = resultSet.getString("NOMBRE");
                String apellido = resultSet.getString("APELLIDO");
                String DNI = resultSet.getString("DNI");
                Date fecha_contr = resultSet.getDate("FECHA_CONTRATACION");
                String puesto = resultSet.getString("PUESTO");

                // Aquí puedes procesar los datos como desees, por ejemplo, imprimirlos en la consola
                System.out.println("ID: " + id + ", Nombre: " + nombre + ", Apellido: " + apellido +
                        DNI + fecha_contr.toString() + puesto);
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
    
}
