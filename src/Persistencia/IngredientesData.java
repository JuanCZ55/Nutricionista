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

    public void insertarIngrediente(Ingredientes ingr) {
        String sql = """
                     INSERT INTO ingredientes (Nombre, CaloriasPor100, NoApto)
                     VALUES (?,?,?);
                     """;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ingr.getNombre());
            ps.setDouble(2, ingr.getCaloriasPor100());
            ps.setString(3, ingr.getNoApto());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                ingr.setIdIngredientes(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Ingrediente Guardado Existosamente");
            } //No influye
            else {
                JOptionPane.showMessageDialog(null, "El Ingrediente ya existe");
            }
            //
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ingredientes");
        }

    }

    public void actualizarIngrediente(Ingredientes ingr) {
        String sql = "UPDATE ingredientes SET Nombre = ? , CaloriasPor100 = ?, NoApto = ?WHERE IdIngredientes = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, ingr.getNombre());
            ps.setDouble(2, ingr.getCaloriasPor100());
            ps.setString(3, ingr.getNoApto());
            ps.setInt(4, ingr.getIdIngredientes());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Ingrediente Modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Ingrediente no encontrado");
            }
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
                JOptionPane.showMessageDialog(null, "Ingrediente Inactivo");
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
                JOptionPane.showMessageDialog(null, "Ingrediente Activo");
            } else {
                JOptionPane.showMessageDialog(null, "Ingrediente no encontrado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Ingredientes");
        }
    }

    public Ingredientes buscarIngredientes(int id) {
        String sql = "SELECT * FROM  ingredientes WHERE IdIngredientes =?;";
        Ingredientes ingr = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ingr = new Ingredientes();
                ingr.setIdIngredientes(rs.getInt("IdIngredientes"));
                ingr.setNombre(rs.getString("Nombre"));
                ingr.setCaloriasPor100(rs.getDouble("CaloriasPor100"));
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
                ingredientes.setIdIngredientes(rs.getInt("IdIngredientes"));
                ingredientes.setNombre(rs.getString("Nombre"));
                ingredientes.setCaloriasPor100(rs.getDouble("CaloriasPor100"));
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

    public ArrayList<Ingredientes> listaMaxCalorias(double maxCalorias) {
        ArrayList<Ingredientes> lista = new ArrayList<>();
        int x = 1;
        String sql = "SELECT * FROM ingredientes WHERE Estado = 1;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                double caloT = rs.getDouble("CaloriasPor100");
                if (caloT <= maxCalorias) {
                    Ingredientes in = new Ingredientes();
                    in.setIdIngredientes(rs.getInt("IdIngredientes"));
                    in.setNombre(rs.getString("Nombre"));
                    in.setCaloriasPor100(rs.getDouble("CaloriasPor100"));
                    in.setNoApto(rs.getString("NoApto"));
                    in.setEstado(rs.getBoolean("Estado"));
                    lista.add(in);
                    x++;
                }
            }
            if (x == 0) {
                JOptionPane.showMessageDialog(null, "No hay ingredientes menores a esa cantidad de calorias");
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar maximas calorias");
        }
        return lista;
    }

    public ArrayList<Ingredientes> listaMinCalorias(double minCalorias) {
        ArrayList<Ingredientes> lista = new ArrayList<>();
        int x = 1;
        String sql = "SELECT * FROM ingredientes WHERE Estado = 1;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                double caloT = rs.getDouble("CaloriasPor100");
                if (caloT >= minCalorias) {
                    Ingredientes in = new Ingredientes();
                    in.setIdIngredientes(rs.getInt("IdIngredientes"));
                    in.setNombre(rs.getString("Nombre"));
                    in.setCaloriasPor100(rs.getDouble("CaloriasPor100"));
                    in.setNoApto(rs.getString("NoApto"));
                    in.setEstado(rs.getBoolean("Estado"));
                    lista.add(in);
                    x++;
                }
            }
            if (x == 0) {
                JOptionPane.showMessageDialog(null, "No hay ingredientes mayores a esa cantidad de calorias");
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar minimas calorias");
        }
        return lista;
    }

    public ArrayList<Ingredientes> listaMinMaxCalorias(double minCalorias, double maxCalorias) {
        ArrayList<Ingredientes> lista = new ArrayList<>();
        int x = 1;
        String sql = "SELECT * FROM ingredientes WHERE Estado = 1;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                double caloT = rs.getDouble("CaloriasPor100");
                if (caloT >= minCalorias && caloT <= maxCalorias) {
                    Ingredientes in = new Ingredientes();
                    in.setIdIngredientes(rs.getInt("IdIngredientes"));
                    in.setNombre(rs.getString("Nombre"));
                    in.setCaloriasPor100(rs.getDouble("CaloriasPor100"));
                    in.setNoApto(rs.getString("NoApto"));
                    in.setEstado(rs.getBoolean("Estado"));
                    lista.add(in);
                    x++;
                }
            }
            if (x == 0) {
                JOptionPane.showMessageDialog(null, "No hay ingredientes entre ese rango de calorias.");
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar ingredientes del rango establecido");
        }
        return lista;
    }

}
