package Persistencia;

import Modelo.Comidas;
import Modelo.Conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public Comidas buscarComida(int id) {
        String sql = "SELECT * FROM  ingredientes WHERE IdIngrediente=?;";
        Comidas comid = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery(); //devuelve consulta
            if (rs.next()) { 
                comid = new Comidas(); //creacion del objeto
               comid.setIdComida(rs.getInt("IdComida"));
               comid.setNombre(rs.getString("Nombre"));
               comid.setTipoDeComida(rs.getString("TipoDeComida"));
               comid.setCaloriasComida(rs.getDouble("CaloriasComida"));
               comid.setEstado(rs.getBoolean("Estado"));
               comid.setNoApto(rs.getString("NoApto"));
               

            } else {
                JOptionPane.showMessageDialog(null, "No existe esa comida");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar la comida" + ex.getMessage());
        }
      return comid; 
    
    }
    public List<Comidas> listarComidasPorMenuDiario(int idMenu) {
    String sql = "SELECT c.IdComidas, c.Nombre, c.TipoDeComida, c.CaloriasComida, c.NoApto, c.Estado"
               + " FROM menucomidas mc JOIN comidas c ON mc.IdComidas = c.IdComidas"
               + " WHERE mc.IdMenuDiario = ?";
    List<Comidas> lista = new ArrayList<>();

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idMenu);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Comidas comida = new Comidas();
                comida.setIdComida(rs.getInt("IdComidas"));
                comida.setNombre(rs.getString("Nombre"));
                comida.setTipoDeComida(rs.getString("TipoDeComida"));
                comida.setCaloriasComida(rs.getDouble("CaloriasComida"));
                comida.setNoApto(rs.getString("NoApto"));
                comida.setEstado(rs.getBoolean("Estado"));
                lista.add(comida);
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Comidas: " + ex.getMessage());
    }

    return lista;
}
}



            
            
    

    
    
