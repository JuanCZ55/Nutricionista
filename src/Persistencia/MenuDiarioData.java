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

    private java.sql.Connection con = null;

    public MenuDiarioData() {
        con = (java.sql.Connection) Conexion.getConexion();
    }

    public boolean verificarDiasActivosMenuDiarioPorDieta(int idDieta) {
        String sql = """
                    SELECT Dia
                    FROM menudiario 
                    WHERE IdDieta = ? AND Estado = 1
                    ORDER BY Dia ASC;
                    """;
        boolean completo = true;
        ArrayList<Integer> diasMenu = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                diasMenu.add(rs.getInt("Dia"));
            }

            //Sacar el dia mas grande
            int diaMaximo = 0;
            for (int i = 0; i < diasMenu.size(); i++) {
                if (diasMenu.get(i) > diaMaximo) {
                    diaMaximo = diasMenu.get(i);
                }
            }

            // Verifica que esten todso los dias anteriores al dia mas grande
            String diasFaltantes = "";
            for (int i = 1; i < diaMaximo; i++) {
                if (!diasMenu.contains(i)) {
                    diasFaltantes = diasFaltantes + i + ". ";
                    completo = false;
                }
            }
            if (!diasFaltantes.equals("")) {
                JOptionPane.showMessageDialog(null, "Faltan los siguientes dias activos para poder salir: " + diasFaltantes);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a MenuDiario");
            completo = false;
        }
        return completo;
    }

    //Cargar comidas por condicion del paciente
    //Si la condicion del peciente esta incluida dentro del la comida no retona esa comida
    public ArrayList<Comidas> listarComidasActivas() {
        String sql = """
                     SELECT IdComidas, Nombre, TipoDeComida, CaloriasComida, NoApto, Estado 
                     FROM comidas 
                     WHERE Estado=1;
                     """;
        int x = 0;
        Comidas comida = null;
        ArrayList<Comidas> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                comida = new Comidas();
                comida.setIdComida(rs.getInt("IdComidas"));
                comida.setNombre(rs.getString("Nombre"));
                comida.setTipoDeComida(rs.getString("TipoDeComida"));
                comida.setCaloriasComida(rs.getDouble("CaloriasComida"));
                comida.setNoApto(rs.getString("NoApto"));
                comida.setEstado(rs.getBoolean("Estado"));
                lista.add(comida);
                x++;
            }
            if (x == 0) {
                JOptionPane.showMessageDialog(null, "No hay Comidas");
            }

            ps.close();
        } catch (Exception e) {
        }
        return lista;
    }

    // Método para obtener comidas aptas según las restricciones
    public ArrayList<Comidas> obtenerComidasAptas(ArrayList<Comidas> comidas, String restricciones) {
        String[] restriccionesArray = restricciones.split(","); // Separar por coma y eliminar espacios
        List<String> listaRestricciones = List.of(restriccionesArray);

        ArrayList<Comidas> comidasAptas = new ArrayList<>();

        for (Comidas comida : comidas) {
            boolean esApta = true;
            for (String restriccion : listaRestricciones) {
                if (comida.getNoApto().contains(restriccion)) {
                    esApta = false;
                    break;
                }
            }
            if (esApta) {
                comidasAptas.add(comida);
            }
        }

        return comidasAptas;
    }

    public Paciente obtenerPacientePorDieta(int idDieta) {
        String sql = """
                    SELECT p.IdPaciente, p.Nombre, p.Edad, p.Altura, p.CondicionSalud, p.PesoActual, p.PesoBuscado, p.PesoInical, p.Estado 
                    FROM paciente p JOIN dieta d ON p.IdPaciente = d.IdPaciente 
                    WHERE d.IdDieta = ?;
                     """;
        Paciente pac = null;
        PacienteData pacData = new PacienteData();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pac = new Paciente();
                pac.setIdPaciente(rs.getInt("p.IdPaciente"));
                pac.setNombre(rs.getString("p.Nombre"));
                pac.setEdad(rs.getInt("p.Edad"));
                pac.setAltura(rs.getDouble("p.Altura"));
                pac.setPesoActual(rs.getDouble("p.PesoActual"));
                pac.setPesoBuscado(rs.getDouble("p.PesoBuscado"));
                pac.setPesoInicial(rs.getDouble("p.PesoInical"));
                pac.setCondicionSalud(pacData.convertirStringSet(rs.getString("p.CondicionSalud")));

                pac.setEstado(rs.getBoolean("p.Estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe un paciente asociado con la dieta");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a las trablas paciente y dieta");
        }
        return pac;
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
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }
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
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Comidas");
        }

        return lista;
    }
    
    public ArrayList<MenuDiario> listarMenuDiarioPorDietaActivos(int idDieta){
        String sql = """
                     SELECT IdMenuDiario, Dia FROM menudiario WHERE IdDieta = ? AND Estado = 1;
                     """;
        int x = 0;
        MenuDiario menu = null;
        ArrayList<MenuDiario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                menu = new MenuDiario();
                menu.setIdMenu(rs.getInt("IdMenuDiario"));
                menu.setDia(rs.getInt("Dia"));
                menu.setComidas(listarComidasPorMenuDieta(idDieta));
                lista.add(menu);
                x++;
            }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al accedeer a la tabla menu diario");
        }
        return lista;
    }
    
     public ArrayList<Comidas> listarComidasPorMenuDieta(int idDieta) {
        String sql = """
                     SELECT mc.IdComidas, c.Nombre, c.TipoDeComida, c.CaloriasComida
                     FROM menudiario md JOIN menucomidas mc ON md.IdMenuDiario = mc.IdMenuDiario
                     JOIN comidas c ON mc.IdComidas = c.IdComidas
                     WHERE md.IdDieta = ?;
                     """;
        int x = 0;
        Comidas comida = null;
        ArrayList<Comidas> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                comida = new Comidas();
                comida.setIdComida(rs.getInt("mc.IdComidas"));
                comida.setNombre(rs.getString("c.Nombre"));
                comida.setTipoDeComida(rs.getString("c.TipoDeComida"));
                comida.setCaloriasComida(rs.getDouble("c.CaloriasComida"));
                lista.add(comida);
                x++;
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Comidas");
        }

        return lista;
    }

    //Actualizar MenuComidas
    //Paso 1: buscar el MenuDiario de una Dieta en un dia especifico
    public MenuDiario buscarMenuDiarioPorDietaYDia(int idDieta, int dia) {
        String sql = "SELECT IdMenuDiario, Dia, CaloriasDia, IdDieta, Estado FROM menudiario WHERE IdDieta = ? AND Dia = ? AND Estado =1";
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
                menuDieta.setEstado(rs.getBoolean("Estado"));
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
                comida.setIdComida(rs.getInt("IdComidas"));
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

    public void actualizarMenuDiario(double calorias, int idDieta, int dia) {
        String sql = """
                   UPDATE menudiario SET CaloriasDia = ?
                   WHERE IdDieta = ? AND Dia =? AND Estado = 1 ;
                   """;
        try {
            PreparedStatement ps = con.prepareStatement(sql);            
            ps.setDouble(1, calorias);
            ps.setInt(2, idDieta);
            ps.setInt(3, dia);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar al MenuDiario");
            
        }

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
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuComidas");
        }
    }
    
    public void actualizarTotalCaloriasDieta (int idDieta){
        String sql = """
                     UPDATE dieta 
                     SET TotalCalorias = (
                         SELECT SUM(CaloriasDia)
                         FROM menudiario
                         WHERE IdDieta = dieta.IdDieta AND Estado = 1
                     )
                     WHERE IdDieta = ? AND Estado = 1;
                     """;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ps.executeUpdate();
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

    //Contador de menu diarios activos asociados a una dieta
    public int contadorMenuDiariosDeUnaDieta(int idDieta) {
        String sql = "SELECT COUNT(*) AS cantidadMenu FROM menudiario WHERE IdDieta = ? AND Estado = 1;";
        int contador = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                contador = rs.getInt("cantidadMenu");
            }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiarios");
        }
        return contador;
    }

    public int contadorMenuDiariosInactivoDeUnaDieta(int idDieta) {
        String sql = "SELECT COUNT(*) AS cantidadMenu FROM menudiario WHERE IdDieta = ? AND Estado = 0;";
        int contador = 0;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                contador = rs.getInt("cantidadMenu");
            }
            ps.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiarios");
        }
        return contador;
    }

    //Listar Todos los Menus Junto con las comidas
    //Paso 1: Buscar todos los MenuDiarios asociados a la idDieta
    public ArrayList<MenuDiario> listarMenuDiarioPorDieta(int idDieta) {
        String sql = "SELECT IdMenuDiario, Estado FROM menudiario WHERE IdDieta = ?;";
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
                menuDiario.setEstado(rs.getBoolean("Estado"));
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
        String sql = "SELECT IdMenuDiario, Estado FROM menudiario WHERE IdDieta = ? AND Estado = 1;";
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
                menuDiario.setEstado(rs.getBoolean("Estado"));
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
        String sql = "SELECT IdMenuDiario, Estado FROM menudiario WHERE IdDieta = ? AND Estado = 0;";
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
                menuDiario.setEstado(rs.getBoolean("Estado"));
                lista.add(menuDiario);
                x++;
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }

        return lista;
    }

    //Listar todos los menusdiario
    public ArrayList<MenuDiario> listarMenuDiarioPorDietaYDia(int idDieta, int dia) {
        String sql = "SELECT IdMenuDiario, Estado FROM menudiario WHERE IdDieta = ? AND Dia = ?";
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
                menuDiario.setEstado(rs.getBoolean("Estado"));
                lista.add(menuDiario);
                x++;
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }

        return lista;
    }

    //Listar MenuDiario por Dia y Estado
    //Listar Estado Activo
    //Paso 1: recuperar los menus activos por idDieta y por dia
    public ArrayList<MenuDiario> listarMenuDiarioActivoPorDietaYDia(int idDieta, int dia) {
        String sql = "SELECT IdMenuDiario, Estado FROM menudiario WHERE IdDieta = ? AND Dia = ? AND Estado = 1;";
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
                menuDiario.setEstado(rs.getBoolean("Estado"));
                lista.add(menuDiario);
                x++;
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
        String sql = "SELECT IdMenuDiario, Estado FROM menudiario WHERE IdDieta = ? AND Dia = ? AND Estado = 0;";
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
                menuDiario.setEstado(rs.getBoolean("Estado"));
                lista.add(menuDiario);
                x++;
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

    public MenuDiario buscarMenuDiarioPorDieta(int idDieta, int dia) {
        String sql = "SELECT IdMenuDiario, Dia, CaloriasDia, IdDieta, Estado FROM menudiario WHERE IdDieta=? AND Dia = ? AND Estado = 1";
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

    public double calcularCaloriasTotalesPorDieta(int idDieta) {
        String sql = "SELECT CaloriasDia FROM menudiario WHERE IdDieta = ?";
        double totalCalorias = 0;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ResultSet rs = ps.executeQuery();

            // Acumula las calorías día por día
            while (rs.next()) {
                double caloriasDia = rs.getDouble("CaloriasDia");
                totalCalorias += caloriasDia;  // Suma al acumulador
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario: " + ex.getMessage());
        }

        return totalCalorias;
    }

    //revisar.
    //No concide el parametro que recive con el parametro que le es asignado en obtenerDieta de DietaData
    public ArrayList<MenuDiario> listaMenuDiarioPorDieta(int idMenu) {
        String sql = "SELECT IdMenuDiario, Dia, CaloriasDia, IdDieta, Estado"
                + " FROM menudiario WHERe IdMenuDiario = ?";
        int x = 0;
        MenuDiario menuDiario = null;
        ArrayList<MenuDiario> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMenu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                menuDiario = new MenuDiario();
                menuDiario.setIdMenu(rs.getInt("IdMenuDiario"));
                menuDiario.setDia(rs.getInt("Dia"));
                menuDiario.setCaloriasDelMenu(rs.getDouble("CaloriasDia"));
                menuDiario.setIdDieta(rs.getInt("IdDieta"));
                menuDiario.setEstado(rs.getBoolean("Estado"));
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
