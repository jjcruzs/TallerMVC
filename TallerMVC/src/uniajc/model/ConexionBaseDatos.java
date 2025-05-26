package uniajc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/taller_mvc";
    private static final String USER = "root";
    private static final String PASSWORD = "juanjose0214";

    public static Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos.");
            return con;
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Driver JDBC no encontrado.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error de conexión a MySQL: " + e.getMessage());
        }
        return null;
    }
}
