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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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
        String sql = "SELECT * FROM  comida WHERE IdComida=?;";
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
    public ArrayList<Comidas> listarComidas() {
    ArrayList<Comidas> lista = new ArrayList<>();
    String sql = "SELECT * FROM comida WHERE Estado = 1";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Comidas comida = new Comidas();
            comida.setIdComida(rs.getInt("IdComida"));
            comida.setNombre(rs.getString("Nombre"));
            comida.setCaloriasComida(rs.getDouble("Calorias"));
            comida.setTipoDeComida(rs.getString("Tipo"));
            lista.add(comida);      }
        ps.close();
        rs.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al listar comidas: " + ex.getMessage());
    }
    return lista;
}
    public ArrayList<Comidas> listarComidasPorTipoDeComida(String tipo) {
    ArrayList<Comidas> lista = new ArrayList<>();
    String sql = "SELECT * FROM comida WHERE Estado = 1 AND Tipo = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, tipo);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Comidas comida = new Comidas();
            comida.setIdComida(rs.getInt("IdComida"));
            comida.setNombre(rs.getString("Nombre"));
            comida.setCaloriasComida(rs.getDouble("Calorias"));
            comida.setTipoDeComida(rs.getString("Tipo"));
            lista.add(comida);
        }
        ps.close();
        rs.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al listar comidas por tipo: " + ex.getMessage());
    }
    return lista;
}
public ArrayList<Comidas> listarComidasPorNoCondicion(String cond) {
    PacienteData pd = new PacienteData();
    ArrayList<Comidas> lista = new ArrayList<>();
    String sql = "SELECT * FROM comida WHERE Estado = 1";
    HashSet<String> condSet = pd.convertirStringSet(cond);
    int index = 1;
    for (String aux : condSet) {
        sql += " AND NoApto NOT LIKE CONCAT('%', ?, '%')";
    }
    sql += ";";    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        for (String aux : condSet) {
            ps.setString(index++, aux);
        }
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Comidas comida = new Comidas();
            comida.setIdComida(rs.getInt("IdComida"));
            comida.setNombre(rs.getString("Nombre"));
            comida.setCaloriasComida(rs.getDouble("Calorias"));
            comida.setTipoDeComida(rs.getString("Tipo"));
            comida.setNoApto(rs.getString("NoApto"));
            lista.add(comida);
        }
        ps.close();
        rs.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al listar comidas por no condición: " + ex.getMessage());
    }
    return lista;
}
public Map<String, ArrayList<Comidas>> mostrarComidasPorIngredientes(ArrayList<String> IngredientesData) {
    Map<String, ArrayList<Comidas>> comidasPorIngrediente = new HashMap<>();

    String sql = "SELECT i.Nombre AS Ingrediente, c.* FROM comida c " +
                 "JOIN comida_ingrediente ci ON c.IdComida = ci.IdComida " +
                 "JOIN ingrediente i ON ci.IdIngrediente = i.IdIngrediente " +
                 "WHERE c.Estado = 1 AND (";
    
    for (int i = 0; i < IngredientesData.size(); i++) {
        sql += "i.Nombre LIKE ?";
        if (i < IngredientesData.size() - 1) {
            sql += " OR ";
        }
    }
    sql += ") ORDER BY i.Nombre;";

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        
        
        for (int i = 0; i < IngredientesData.size(); i++) {
            ps.setString(i + 1, "%" + IngredientesData.get(i) + "%");
        }

        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            String ingrediente = rs.getString("Ingrediente");
            Comidas comida = new Comidas();
            comida.setIdComida(rs.getInt("IdComida"));
            comida.setNombre(rs.getString("Nombre"));
            comida.setCaloriasComida(rs.getDouble("CaloriasTotal")); 
            comida.setTipoDeComida(rs.getString("TipoDeComida"));    
            comida.setNoApto(rs.getString("Apto"));                
            
            
            comidasPorIngrediente
                .computeIfAbsent(ingrediente, k -> new ArrayList<>())
                .add(comida);
        }
        
        rs.close();
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al listar comidas por ingredientes: " + ex.getMessage());
    }

    return comidasPorIngrediente;
}



}



            
            
    

    
    
