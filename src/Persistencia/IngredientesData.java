/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;
import org.mariadb.jdbc.Connection;
import Modelo.Conexion;
import Modelo.Ingredientes;
import Modelo.Paciente;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Miguel
 */
public class IngredientesData {
      private Connection con = null;

    public IngredientesData() {
        con = (Connection) Conexion.getConexion();
    }
     public void guardar(Ingredientes ingr) {
        String sql = "INSERT INTO ingredientes( "
                + "Nombre, CaloriasPor100, Peso, NoApto"
                + ") VALUES (?,?,?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ingr.getNombre());
            ps.setDouble(2,ingr.getCaloriasPor100());
            ps.setDouble(3, ingr.getPeso());
            ps.setString(4,ingr.getNoApto());
            
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ingr.setIdIngredientes(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Ingrediente Guardado Existosamente");
            }
            //No influye
            else{
                JOptionPane.showMessageDialog(null, "El Ingrediente ya existe");
            }
            //
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ingredientes");
        }
        
    }
     public void ActulizarIngrediente(Ingredientes ingr){
        String sql = "UPDATE ingredientes SET Nombre= ?,CaloriasPor100=?,Peso=?,NoApto=?, WHERE IdIngredientes=?";
           try{
               PreparedStatement ps = con.prepareStatement(sql);
           
            ps.setString(1, ingr.getNombre());
            ps.setDouble(2,ingr.getCaloriasPor100());
            ps.setDouble(3,ingr.getPeso());
            ps.setString(4, ingr.getNoApto());
            ps.setInt(5, ingr.getIdIngredientes());
            
            
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Ingrediente Modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Ingrediente no encontrado");
            }
            //
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ingredientes");
        }

}
public void bajaLogica(int id) {
        String sql = "UPDATE ingredientes SET Estado = 0 WHERE IdIngredientes =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Ingrediente Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Ingrediente no encontrado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ingredientes");
        }
    }
public void altaLogica(int id) {
        String sql = "UPDATE ingredientes SET Estado = 1 WHERE IdIngredientes =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Ingrediente Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Ingrediente no encontrado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ingredientes");
        }
    }
  public Ingredientes buscarIngredientes(int id) {
        String sql = "SELECT * FROM  ingredientes WHERE IdIngrediente=?;";
        Ingredientes ingr = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ingr = new Ingredientes();
               ingr.setIdIngredientes(rs.getInt("IdIngrediente"));
               ingr.setNombre(rs.getString("Nombre"));
               ingr.setCaloriasPor100(rs.getDouble("CaloriasPor100"));
               ingr.setPeso(rs.getDouble("Peso"));
               ingr.setEstado(rs.getBoolean("Estado"));
               ingr.setNoApto(rs.getString("NoApto"));
               

            } else {
                JOptionPane.showMessageDialog(null, "No existe ese Ingrdiente");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar Ingrediente" + ex.getMessage());
        }
        return ingr;
    }
    public ArrayList<Ingredientes> listarIngredientes() {
        String sql = "SELECT * FROM ingredientes";
        int x = 0;
        Ingredientes ingredientes = null;
        ArrayList<Ingredientes> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ingredientes = new Ingredientes();
               ingredientes.setIdIngredientes(rs.getInt("IdIngrediente"));
               ingredientes.setNombre(rs.getString("Nombre"));
               ingredientes.setCaloriasPor100(rs.getDouble("CaloriasPor100"));
               ingredientes.setPeso(rs.getDouble("Peso"));
               ingredientes.setEstado(rs.getBoolean("Estado"));
               ingredientes.setNoApto(rs.getString("NoApto"));

             

                lista.add(ingredientes);
                x++;
            }
            if (x == 0) {
                JOptionPane.showMessageDialog(null, "No hay Ingredientes");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ingredientes");
        }

        return lista;
    }
}
