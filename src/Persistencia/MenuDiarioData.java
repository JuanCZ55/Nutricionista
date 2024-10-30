package Persistencia;

import Modelo.Comidas;
import Modelo.Conexion;
import Modelo.MenuDiario;
import java.sql.*;
import java.util.ArrayList;
import org.mariadb.jdbc.Connection;
import javax.swing.JOptionPane;

public class MenuDiarioData {

    private Connection con = null;

    public MenuDiarioData() {
        con = (Connection) Conexion.getConexion();
    }
    public void insertMenuDiario(MenuDiario md, ArrayList<Comidas> comidas) {
        String sql = "SELECT IdMenuDiario, Dia, CaloriasDia, IdDieta, Estado FROM menudiario "
                + "WHERE Dia = ? AND CaloriasDia = ? AND IdDieta = ? AND (Estado = 1 OR Estado = 0);";
        
        String sql2= "INSERT INTO menudiario( Dia, CaloriasDia, IdDieta) "
                + "VALUES (?,?,?);"
                + "INSERT INTO menucomidas(IdMenuDiario, IdComidas) VALUES (?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, md.getDia());
            ps.setDouble(2,  md.getCaloriasDelMenu());
            ps.setInt(3, md.getIdDieta());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                 JOptionPane.showMessageDialog(null, "MenuDiario existente");
            } else {
                ps = con.prepareStatement(sql2);
                ps.setInt(1, md.getDia());
                ps.setDouble(2, md.getCaloriasDelMenu());
                ps.setInt(3, md.getIdDieta());
                for (Comidas aux : comidas) {
                    ps.setInt(4, md.getIdMenu());
                    ps.setInt(5, aux.getIdComida());
                }
            }   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }
    } 
    
    public void actualizarMenuDiario(MenuDiario md, ArrayList<Comidas> comidas){
        String sql = "UPDATE menucomidas SET IdComidas = ?" +
            " WHERE IdMenuDiario = (SELECT IdMenuDiario" +
            " FROM menudiario " +
            " WHERE IdDieta = ? AND Dia = ?;)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            for (Comidas aux : comidas) {
                ps.setInt(1, aux.getIdComida());
                ps.setInt(2, md.getIdDieta());
                ps.setInt(3, md.getDia());
            }
                
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Menu diario Modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Menu diario no encontrado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }
    }
    
    public void bajaLogica (int id){
        String sql = "UPDATE menudiario SET Estado=0 WHERE IdMenuDiario=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Menu Diario  Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Menu Diario  no encontrado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }
    }
    public void altaLogica (int id){
        String sql = "UPDATE menudiario SET Estado=1 WHERE IdMenuDiario=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Menu Diario  Habilitado");
            } else {
                JOptionPane.showMessageDialog(null, "Menu Diario  no encontrado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }
    }
    
    public void buscarMenuDiario (int idMenu){
        String sql ="SELECT IdMenuDiario, Dia, CaloriasDia, IdDieta, Estado FROM menudiario WHERE IdMenuDiario=?";
        MenuDiario menuDieta = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMenu);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                menuDieta = new MenuDiario();
                menuDieta.setIdMenu(rs.getInt("IdMenuDiario"));
                menuDieta.setDia(rs.getInt("Dia"));
                menuDieta.setCaloriasDelMenu(rs.getInt("CaloriasDia"));
                menuDieta.setIdDieta(rs.getInt("IdDieta"));
                menuDieta.setEstado(rs.getBoolean("estado"));
            } else{
                JOptionPane.showMessageDialog(null, "No existe ese Menu del dia");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }
    }
    
    public ArrayList<MenuDiario> listarMenuDiario(){
        String sql = "SELECT IdMenuDiario, Dia, CaloriasDia, IdDieta, Estado FROM menudiario";
        int x = 0;
        MenuDiario menuDiario = null;
        ArrayList<MenuDiario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                menuDiario = new MenuDiario();
                menuDiario.setIdMenu(rs.getInt("IdMenuDiario"));
                menuDiario.setDia(rs.getInt("Dia"));
                menuDiario.setCaloriasDelMenu(rs.getDouble("CaloriasDia"));
                menuDiario.setIdDieta(rs.getInt("IdDieta"));
                lista.add(menuDiario);
                x++;
            }
            if (x == 0) {
                JOptionPane.showMessageDialog(null, "No hay Menus Diario");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }

        return lista;
    }
    
    //
    public ArrayList<MenuDiario> listarMenuDiarioPorPaciente(int idPaciente){
        String sql = "SELECT IdMenuDiario, Dia, CaloriasDia, IdDieta, Estado\n" +
        "FROM menudiario m JOIN dieta d ON m.IdDieta = d.IdDieta\n" +
        "JOIN paciente p ON d.IdPaciente = p.IdPaciente\n" +
        "WHERE p.IdPaciente=?;";
        int x = 0;
        MenuDiario menuDiario = null;
        ArrayList<MenuDiario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                menuDiario = new MenuDiario();
                menuDiario.setIdMenu(rs.getInt("IdMenuDiario"));
                menuDiario.setDia(rs.getInt("Dia"));
                menuDiario.setCaloriasDelMenu(rs.getDouble("CaloriasDia"));
                menuDiario.setIdDieta(rs.getInt("IdDieta"));
                lista.add(menuDiario);
                x++;
            }
            if (x == 0) {
                JOptionPane.showMessageDialog(null, "No hay Menus Diario");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }

        return lista;
    }
    //
    
    public ArrayList<MenuDiario> listarMenuDiarioPorPacienteYDia(int idPaciente, int dia){
        String sql = "SELECT IdMenuDiario, Dia, CaloriasDia, IdDieta, Estado"+
        " FROM menudiario m JOIN dieta d ON m.IdDieta = d.IdDieta\n" +
        " OIN paciente p ON d.IdPaciente = p.IdPaciente\n" +
        " WHERE p.IdPaciente=? p.Dia=?;";
        int x = 0;
        while (dia>7){
            if (dia>7){
            dia-=7;
        }
        }
        MenuDiario menuDiario = null;
        ArrayList<MenuDiario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPaciente);
            ps.setInt(2, dia);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                menuDiario = new MenuDiario();
                menuDiario.setIdMenu(rs.getInt("IdMenuDiario"));
                menuDiario.setDia(rs.getInt("Dia"));
                menuDiario.setCaloriasDelMenu(rs.getDouble("CaloriasDia"));
                menuDiario.setIdDieta(rs.getInt("IdDieta"));
                lista.add(menuDiario);
                x++;
            }
            if (x == 0) {
                JOptionPane.showMessageDialog(null, "No hay Menus Diario");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }
        
        

        return lista;
    }
    public ArrayList<MenuDiario> listarMenuDiarioPorDia(int dia){
        String sql = "SELECT IdMenuDiario, Dia, CaloriasDia, IdDieta, Estado FROM menudiario WHER Dia=?";
        int x = 0;
        while (dia>7){
            if (dia>7){
            dia-=7;
        }
        }
        MenuDiario menuDiario = null;
        ArrayList<MenuDiario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dia);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                menuDiario = new MenuDiario();
                menuDiario.setIdMenu(rs.getInt("IdMenuDiario"));
                menuDiario.setDia(rs.getInt("Dia"));
                menuDiario.setCaloriasDelMenu(rs.getDouble("CaloriasDia"));
                menuDiario.setIdDieta(rs.getInt("IdDieta"));
                lista.add(menuDiario);
                x++;
            }
            if (x == 0) {
                JOptionPane.showMessageDialog(null, "No hay Menus Diario");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }

        return lista;
    }
    
    public ArrayList<MenuDiario> listarMenuDiarioPorCondicion(String condicion){
        String sql = "SELECT IdMenuDiario, Dia, CaloriasDia, IdDieta, Estado\n" +
        "FROM menudiario m JOIN dieta d ON m.IdDieta = d.IdDieta\n" +
        "JOIN paciente p ON d.IdPaciente = p.IdPaciente\n" +
        "WHERE p.CondicionSalud =?;";
        int x = 0;
        MenuDiario menuDiario = null;
        ArrayList<MenuDiario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, condicion);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                menuDiario = new MenuDiario();
                menuDiario.setIdMenu(rs.getInt("IdMenuDiario"));
                menuDiario.setDia(rs.getInt("Dia"));
                menuDiario.setCaloriasDelMenu(rs.getDouble("CaloriasDia"));
                menuDiario.setIdDieta(rs.getInt("IdDieta"));
                lista.add(menuDiario);
                x++;
            }
            if (x == 0) {
                JOptionPane.showMessageDialog(null, "No hay Menus Diario");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }

        return lista;
    }
    public ArrayList<MenuDiario> listarMenuDiarioPorCondicionYDia(String condicion, int dia){
        String sql = "SELECT IdMenuDiario, Dia, CaloriasDia, IdDieta, Estado\n" +
        "FROM menudiario m JOIN dieta d ON m.IdDieta = d.IdDieta\n" +
        "JOIN paciente p ON d.IdPaciente = p.IdPaciente\n" +
        "WHERE p.CondicionSalud =? m.Dia;";
        int x = 0;
        while (dia>7){
            if (dia>7){
            dia-=7;
        }
        }
        MenuDiario menuDiario = null;
        ArrayList<MenuDiario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, condicion);
            ps.setInt(2, dia);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                menuDiario = new MenuDiario();
                menuDiario.setIdMenu(rs.getInt("IdMenuDiario"));
                menuDiario.setDia(rs.getInt("Dia"));
                menuDiario.setCaloriasDelMenu(rs.getDouble("CaloriasDia"));
                menuDiario.setIdDieta(rs.getInt("IdDieta"));
                lista.add(menuDiario);
                x++;
            }
            if (x == 0) {
                JOptionPane.showMessageDialog(null, "No hay Menus Diario");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }

        return lista;
    }
}