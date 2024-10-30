package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
        private static Conexion connection = null;

    private Conexion() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar Driver");

        }
    }

    public static Connection getConexion() {
        Connection con = null;

        if (connection == null) {
            connection = new Conexion();
        }

        try {
            con = DriverManager.getConnection("jdbc:mariadb://localhost/Nutricionista2.0", "root", "");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: error al conectarse a la base de datos");
        }

        return con;
    }

}
