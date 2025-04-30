/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uniajc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author g.perezmoreno
 */
public class ConexionDatabase {
 
    private static Connection conexion = null;
    
    public static Connection getConnection() {
        if (conexion == null) {      
            try {
                String url = "jdbc:mysql://localhost:3306/escuela";
                String user = "root";
                String password = "admin";

                conexion = DriverManager.getConnection(url, user, password);
                System.out.println("Conexion exitosa!");
                System.out.println("");
            } catch (SQLException error){
                System.out.println("Error conectando a la base de datos: " + error);
            }   
        }
        return conexion;
    }
    
    public static void closeConnection() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (Exception exception) {
                System.out.println("Exception cerrando la base de datos: " + exception);
                exception.printStackTrace();
            }
        }
    }
    
}
