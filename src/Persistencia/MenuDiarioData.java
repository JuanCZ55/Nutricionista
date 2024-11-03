package Persistencia;

import Modelo.Comidas;
import Modelo.Conexion;
import Modelo.MenuDiario;
import Modelo.Paciente;
import java.sql.*;
import java.util.ArrayList;
import org.mariadb.jdbc.Connection;
import javax.swing.JOptionPane;

public class MenuDiarioData {

    private Connection con = null;

    public MenuDiarioData() {
        con = (Connection) Conexion.getConexion();
    }

    //Insertar el menu diario/comidas
    public void insertMenuDiario(MenuDiario md) {
        String sql = "INSERT INTO menudiario( Dia, CaloriasDia, IdDieta) VALUES (?,?,?); ";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, md.getDia());
            ps.setDouble(2, md.getCaloriasDelMenu());
            ps.setInt(3, md.getIdDieta());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "MenuDiario Guardado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "El MenuDiario existe");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }
    }

    public void insertMenuComidas(int idMenuDiario, int idComidas) {
        String sql = "INSERT INTO menucomidas(IdMenuDiario, IdComidas) VALUES (?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idMenuDiario);
            ps.setInt(2, idComidas);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "MenuComidas Guardado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "El MenuComidas existe");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }
    }

    //Buscar menu asociado al paciente junto con una fecha y que este habilitado
    /**
     * buscarMenuDiario(Paciente pac, int dia): Busca un Paciente en la base de
     * datos del cual se buscara las Dietas asociadas. Si existe alguna Dieta
     * asociada verifica los MenuDiarios asociados y de existir revisa que el
     * MenuDiario tenga el dia pasado por parametro y que el Estado sea activo
     *
     * @param pac - Objeto Paciente.
     * @param dia - Objeto int.
     */
    public MenuDiario buscarMenuDiario(Paciente pac, int dia) {
        String sql = "SELECT `IdMenuDiario`, `Dia`, `CaloriasDia`, `IdDieta`, `Estado` "
                + "FROM `menudiario` "
                + "WHERE  IdDieta = (SELECT IdDieta "
                + "FROM dieta d JOIN paciente p ON d.IdPaciente=p.IdPaciente "
                + "WHERE p.IdPaciente = ?) AND Dia=? AND Estado = 1";
        MenuDiario menuDiario = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pac.getIdPaciente());
            ps.setInt(2, dia);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                menuDiario = new MenuDiario();
                menuDiario.setIdMenu(rs.getInt("IdMenuDiario"));
                menuDiario.setDia(rs.getInt("Dia"));
                menuDiario.setCaloriasDelMenu(rs.getDouble("CaloriasDia"));
                menuDiario.setIdDieta(rs.getInt("IdDieta"));
                menuDiario.setEstado(rs.getBoolean("Estado"));
                menuDiario.setComidas(new ArrayList<>());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }
        return menuDiario;
    }
    //Buscar menu asociado 
    public MenuDiario buscarMenuDiarioEliminado(Paciente pac, int dia) {
        String sql = "SELECT `IdMenuDiario`, `Dia`, `CaloriasDia`, `IdDieta`, `Estado` "
                + "FROM `menudiario` "
                + "WHERE  IdDieta = (SELECT IdDieta "
                + "FROM dieta d JOIN paciente p ON d.IdPaciente=p.IdPaciente "
                + "WHERE p.IdPaciente = ?) AND Dia=? AND Estado = 0";
        MenuDiario menuDiario = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pac.getIdPaciente());
            ps.setInt(2, dia);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                menuDiario = new MenuDiario();
                menuDiario.setIdMenu(rs.getInt("IdMenuDiario"));
                menuDiario.setDia(rs.getInt("Dia"));
                menuDiario.setCaloriasDelMenu(rs.getDouble("CaloriasDia"));
                menuDiario.setIdDieta(rs.getInt("IdDieta"));
                menuDiario.setEstado(rs.getBoolean("Estado"));
                menuDiario.setComidas(new ArrayList<>());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }
        return menuDiario;
    }

    //Actualizar MenuComidas
    public void actualizarMenuComidas(MenuDiario md, int idComidasNew, int idComidaOld) {
        String sql = "UPDATE menucomidas SET IdComidas = ?"
                + " WHERE IdMenuDiario =? AND IdComidas=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, idComidasNew);
                ps.setInt(2, md.getIdMenu());
                ps.setInt(3, idComidaOld);
            
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "MenuComida Modificado");
            } else {
                JOptionPane.showMessageDialog(null, "MenuComida no encontrado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuComidas");
        }
    }
    
    public ArrayList<Comidas> buscarComidasPorMenuDiario(MenuDiario md) {
        String sql = "SELECT mc.IdComidas "
                + "FROM comidas c JOIN menucomidas mc ON c.IdComidas = mc.IdComidas "
                + "WHERE mc.IdMenuDiario = ?;";
        int x = 0;
        Comidas comida= null;
        ArrayList<Comidas> lista = new ArrayList<>();;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, md.getIdMenu());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                comida = new Comidas();
                comida.setIdComida(rs.getInt("mc.IdComidas"));
                lista.add(comida);
                x++;
            }
            if (x == 0) {
                JOptionPane.showMessageDialog(null, "No hay Menus Diario");
            }

            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }
        return lista;
    }
    
    

    public void bajaLogica(int id) {
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

    public void altaLogica(int id) {
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

    public void buscarMenuDiario(int idMenu) {
        String sql = "SELECT IdMenuDiario, Dia, CaloriasDia, IdDieta, Estado FROM menudiario WHERE IdMenuDiario=?";
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
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese Menu del dia");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }
    }

    public ArrayList<MenuDiario> listarMenuDiario() {
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
    public ArrayList<MenuDiario> listarMenuDiarioPorPaciente(int idPaciente) {
        String sql = "SELECT IdMenuDiario, Dia, CaloriasDia, IdDieta, Estado\n"
                + "FROM menudiario m JOIN dieta d ON m.IdDieta = d.IdDieta\n"
                + "JOIN paciente p ON d.IdPaciente = p.IdPaciente\n"
                + "WHERE p.IdPaciente=?;";
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

    public ArrayList<MenuDiario> listarMenuDiarioPorPacienteYDia(int idPaciente, int dia) {
        String sql = "SELECT IdMenuDiario, Dia, CaloriasDia, IdDieta, Estado"
                + " FROM menudiario m JOIN dieta d ON m.IdDieta = d.IdDieta\n"
                + " OIN paciente p ON d.IdPaciente = p.IdPaciente\n"
                + " WHERE p.IdPaciente=? p.Dia=?;";
        int x = 0;
        while (dia > 7) {
            if (dia > 7) {
                dia -= 7;
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

    public ArrayList<MenuDiario> listarMenuDiarioPorDia(int dia) {
        String sql = "SELECT IdMenuDiario, Dia, CaloriasDia, IdDieta, Estado FROM menudiario WHER Dia=?";
        int x = 0;
        while (dia > 7) {
            if (dia > 7) {
                dia -= 7;
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

    public ArrayList<MenuDiario> listarMenuDiarioPorCondicion(String condicion) {
        String sql = "SELECT IdMenuDiario, Dia, CaloriasDia, IdDieta, Estado\n"
                + "FROM menudiario m JOIN dieta d ON m.IdDieta = d.IdDieta\n"
                + "JOIN paciente p ON d.IdPaciente = p.IdPaciente\n"
                + "WHERE p.CondicionSalud =?;";
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

    public ArrayList<MenuDiario> listarMenuDiarioPorCondicionYDia(String condicion, int dia) {
        String sql = "SELECT IdMenuDiario, Dia, CaloriasDia, IdDieta, Estado\n"
                + "FROM menudiario m JOIN dieta d ON m.IdDieta = d.IdDieta\n"
                + "JOIN paciente p ON d.IdPaciente = p.IdPaciente\n"
                + "WHERE p.CondicionSalud =? m.Dia;";
        int x = 0;
        while (dia > 7) {
            if (dia > 7) {
                dia -= 7;
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
