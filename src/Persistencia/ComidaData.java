package Persistencia;

import Modelo.Comidas;
import Modelo.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ComidaData {
    private Connection con = null;

    public ComidaData() {
        con = (Connection) Conexion.getConexion();
    }

    public void guardar(Comidas comid) { 
        String sql = "INSERT INTO comida (Nombre, TipoDeComida, CaloriasTotal, Apto) VALUES (?, ?, ?, ?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, comid.getNombre());
            ps.setString(2, comid.getTipoDeComida());
            ps.setDouble(3, comid.getCaloriasComida()); 
            ps.setString(4, comid.getNoApto()); 

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                comid.setIdComida(rs.getInt(1));  
                JOptionPane.showMessageDialog(null, "Comida guardada exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "La comida no fue guardada");
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla comida: " + ex.getMessage());
        }
    }

    public void actualizarComida(Comidas comid) {
        String sql = "UPDATE comida SET Nombre = ?, TipoDeComida = ?, CaloriasTotal = ?, Apto = ? WHERE IdComida = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, comid.getNombre());
            ps.setString(2, comid.getTipoDeComida());
            ps.setDouble(3, comid.getCaloriasComida());
            ps.setString(4, comid.getNoApto()); 
            ps.setInt(5, comid.getIdComida());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Comida modificada exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "Comida no encontrada");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla comida: " + ex.getMessage());
        }
    }

    public void bajaLogica(int id) {
        String sql = "UPDATE comida SET Estado = 0 WHERE IdComida = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Comida eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "Comida no encontrada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla comida: " + ex.getMessage());
        }
    }

    public void altaLogica(int id) {
        String sql = "UPDATE comida SET Estado = 1 WHERE IdComida = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Comida eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "Comida no encontrada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla comida: " + ex.getMessage());
        }
    }
}



            
            
    

    
    
