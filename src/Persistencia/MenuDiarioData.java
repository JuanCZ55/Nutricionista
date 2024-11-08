package Persistencia;

import Modelo.Comidas;
import Modelo.Conexion;
import Modelo.Dieta;
import Modelo.MenuDiario;
import Modelo.Paciente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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
                md.setIdMenu(rs.getInt(1));
                for (Comidas comida : md.getComidas()) {
                    insertMenuComidas(md.getIdMenu(), comida.getIdComida());
                }
                JOptionPane.showMessageDialog(null, "MenuDiario Guardado exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "El MenuDiario existe");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }
    }
    public void insertMenuComidas(int idMenu, int idComida) {
        String sql = "INSERT INTO menucomidas(IdMenuDiario, IdComidas) VALUES (?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, idMenu);
            ps.setInt(2, idComida);
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

    //Actualizar MenuComidas
    //Paso 1: buscar el MenuDiario de una Dieta en un dia especifico
    public MenuDiario buscarMenuDiarioPorDietaYDia(int idDieta, int dia) {
        String sql = "SELECT IdMenuDiario, Dia, CaloriasDia, IdDieta, Estado FROM menudiario WHERE IdDieta = ? AND Dia = ?";
        MenuDiario menuDieta = null;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ps.setInt(2, dia);
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
        return menuDieta;
    }

    //Paso 2: buscar las comidas asociadas al un MenuDiario en MenuComidas
    public ArrayList<Comidas> buscarComidasPorMenuDiario(MenuDiario md) {
        String sql = "SELECT IdComidas FROM menucomidas WHERE IdMenuDiario=?;";
        int x = 0;
        Comidas comida = null;
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

    //Paso 3: Actualizar los MenuComidas
    public void actualizarMenuComidas(int idMenu, int idComidasNew, int idComidaOld) {
        String sql = "UPDATE menucomidas SET IdComidas = ?"
                + " WHERE IdMenuDiario =? AND IdComidas=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idComidasNew);
            ps.setInt(2, idMenu);
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
    
    
    //Listar todas las dietas activas
    public ArrayList<Dieta> listarTodasLasDietasActivas() {
        String sql = "SELECT IdDieta, NombreDieta, FechaInicial, FechaFinal, TotalCalorias, IdPaciente, Estado"
                + " FROM dieta"
                + " WHERE Estado=1;";
        int x = 0;
        Dieta dieta = null;
        ArrayList<Dieta> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dieta = new Dieta();
                dieta.setIdDieta(rs.getInt("IdDieta"));
                dieta.setNombreD(rs.getString("NombreDieta"));
                dieta.setFechaIni(rs.getDate("FechaInicial").toLocalDate());
                dieta.setFechaFin(rs.getDate("FechaFinal").toLocalDate());
                dieta.setTotalCalorias(rs.getDouble("TotalCalorias"));
                dieta.setEstado(rs.getBoolean("Estado"));
                lista.add(dieta);
                x++;
            }
            if (x == 0) {
                JOptionPane.showMessageDialog(null, "No hay Dietas Activas");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dietas");
        }

        return lista;
    }

    //Listar Todos los Menus Junto con las comidas
    //Paso 1: Buscar todos los MenuDiarios asociados a la idDieta
    public List<MenuDiario> listarMenuDiarioPorDietaObtenerComidas(int idDieta) {
    String sql = "SELECT * FROM menudiario WHERE IdDieta = ?;";
    List<MenuDiario> lista = new ArrayList<>();

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idDieta);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                MenuDiario menuDiario = new MenuDiario();
                menuDiario.setIdMenu(rs.getInt("IdMenuDiario"));
                // Obtener las comidas asociadas al menú
                ComidaData comidaData = new ComidaData();
                List<Comidas> comidas = comidaData.listarComidasPorMenuDiario(menuDiario.getIdMenu());
                menuDiario.setComidas((ArrayList<Comidas>) comidas); 
                lista.add(menuDiario);
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario: " + ex.getMessage());
    }

    return lista;
}
   

    public ArrayList<MenuDiario> listarMenuDiarioPorDieta(int idDieta) {
    String sql = "SELECT IdMenuDiario FROM menudiario WHERE IdDieta = ?;";
    int x = 0;
    MenuDiario menuDiario = null;
    ArrayList<MenuDiario> lista = new ArrayList<>();
    
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idDieta);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            menuDiario = new MenuDiario();
            menuDiario.setIdMenu(rs.getInt("IdMenuDiario"));
            lista.add(menuDiario);
            x++;
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario: " + ex.getMessage());
    }

    return lista;
}   

    //Listar Menus Activo
    //Paso 1: Buscar todos los MenuDiarios asociados a la idDieta activos
    public ArrayList<MenuDiario> listarMenuDiarioActivoPorDieta(int idDieta) {
        String sql = "SELECT IdMenuDiario FROM menudiario WHERE IdDieta = ? AND Estado = 1;";
        int x = 0;
        MenuDiario menuDiario = null;
        ArrayList<MenuDiario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                menuDiario = new MenuDiario();
                menuDiario.setIdMenu(rs.getInt("IdMenuDiario"));
                lista.add(menuDiario);
                x++;
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }

        return lista;
    }

    //Listar Menus Inactivo
    //Paso 1: Buscar todos los MenuDiarios asociados a la idDieta activos
    public ArrayList<MenuDiario> listarMenuDiarioInactivoPorDieta(int idDieta) {
        String sql = "SELECT IdMenuDiario FROM menudiario WHERE IdDieta = ? AND Estado = 0;";
        int x = 0;
        MenuDiario menuDiario = null;
        ArrayList<MenuDiario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                menuDiario = new MenuDiario();
                menuDiario.setIdMenu(rs.getInt("IdMenuDiario"));
                lista.add(menuDiario);
                x++;
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }

        return lista;
    }

    //Paso 2: Buscar todas las comidas asociadas al idMenu de la tabla menucomidas y sacar las comidas asosiadas
    public ArrayList<Comidas> listarComidasPorMenuDiario(int idMenu) {
        String sql = "SELECT c.IdComidas, c.Nombre, c.TipoDeComida, c.CaloriasComida, c.NoApto, c.Estado"
                + " FROM menucomidas mc JOIN comidas c ON mc.IdComidas = c.IdComidas"
                + " WHERE mc.IdMenuDiario = ?";
        int x = 0;
        Comidas comida = null;
        ArrayList<Comidas> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMenu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                comida = new Comidas();
                comida.setIdComida(rs.getInt("c.IdComidas"));
                comida.setNombre(rs.getString("c.Nombre"));
                comida.setTipoDeComida(rs.getString("c.TipoDeComida"));
                comida.setCaloriasComida(rs.getDouble("c.CaloriasComida"));
                comida.setNoApto(rs.getString("c.NoApto"));
                comida.setEstado(rs.getBoolean("c.Estado"));

                lista.add(comida);
                x++;
            }
            if (x == 0) {
                JOptionPane.showMessageDialog(null, "No hay existe esa Comida");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Comidas");
        }

        return lista;
    }

    //Listar MenuDiario por Dia y Estado
    //Listar Estado Activo
    //Paso 1: recuperar los menus activos por idDieta y por dia
    public ArrayList<MenuDiario> listarMenuDiarioActivoPorDietaYDia(int idDieta, int dia) {
        String sql = "SELECT IdMenuDiario FROM menudiario WHERE IdDieta = ? AND Dia = ?AND Estado = 1;";
        int x = 0;
        MenuDiario menuDiario = null;
        ArrayList<MenuDiario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ps.setInt(2, dia);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                menuDiario = new MenuDiario();
                menuDiario.setIdMenu(rs.getInt("IdMenuDiario"));
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

    //Listar Estado Inactivo
    //Paso 1: recuperar los menus activos
    public ArrayList<MenuDiario> listarMenuDiarioInactivoPorDietaYDia(int idDieta, int dia) {
        String sql = "SELECT IdMenuDiario FROM menudiario WHERE IdDieta = ? AND Dia = ? AND Estado = 0;";
        int x = 0;
        MenuDiario menuDiario = null;
        ArrayList<MenuDiario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ps.setInt(2, dia);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                menuDiario = new MenuDiario();
                menuDiario.setIdMenu(rs.getInt("IdMenuDiario"));
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
    //Paso 2: usar el metodo public ArrayList<Comidas> listarComidasPorMenuDiario(int idMenu)
    
    //Buscar un MenuDiario por idMenu
    public MenuDiario buscarMenuDiario(int idMenu) {
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
        return menuDieta;
    }

    //Baja y Alta logica
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

    //----------------------------------------------------------------------------------------------------
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
        String sql = "SELECT IdMenuDiario, Dia, CaloriasDia, IdDieta, Estado "
                + "FROM menudiario "
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
        String sql = "SELECT IdMenuDiario, Dia, CaloriasDia, IdDieta, Estado "
                + "FROM menudiario "
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

    //
    public ArrayList<MenuDiario> listarMenuDiarioPorPacientse(int idPaciente) {
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
