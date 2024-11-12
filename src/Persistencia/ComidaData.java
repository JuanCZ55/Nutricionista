package Persistencia;

import Modelo.Comidas;
import Modelo.Conexion;
import Modelo.Ingredientes;
import java.sql.*;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ComidaData {

    private Connection con = null;

    public ComidaData() {
        con = (Connection) Conexion.getConexion();
    }

    /**
     * crearComida(Comidas com, HashMap<Integer, Double> ingrePesos): Inserta
     * una nueva comida en la base de datos, calculando sus calorias y
     * condiciones de aptitud segun los ingredientes. Asigna el ID generado a la
     * comida y registra los ingredientes asociados. Autor: Zegarra
     *
     * @param com Comidas a insertar
     * @param ingrePesos HashMap con ID de ingredientes y sus pesos
     * @return true si la comida se inserto exitosamente, false si ocurrio un
     * error
     */
    public boolean crearComida(Comidas com, HashMap<Integer, Double> ingrePesos) {
        String sql = "INSERT INTO comidas(Nombre, TipoDeComida, CaloriasComida, NoApto) VALUES (?,?,?,?);";
        boolean fla = false;
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, com.getNombre());
            ps.setString(2, com.getTipoDeComida());
            ps.setDouble(3, caloriasComidas(ingrePesos));
            ps.setString(4, noAptoComidas(ingrePesos));

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                com.setIdComida(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Comida Registrada Existosamente");
                fla = true;
            }
            insertarIngredientesComidas(com, ingrePesos);
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al registrar una comida");
        }
        return fla;
    }

    /**
     * insertarIngredientesComidas(Comidas com, HashMap<Integer, Double>
     * ingrePesos): Inserta los ingredientes asociados a una comida en la tabla
     * de ingredientescomidas con sus respectivos pesos. Autor: Zegarra
     *
     * @param com Comidas que contiene el ID de la comida
     * @param ingrePesos HashMap con ID de ingredientes y sus pesos
     */
    public void insertarIngredientesComidas(Comidas com, HashMap<Integer, Double> ingrePesos) {
        String sql = "INSERT INTO ingredientescomidas(IdComidas, IdIngredientes, peso) VALUES  (?,?,?) ;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            for (HashMap.Entry<Integer, Double> ip : ingrePesos.entrySet()) {
                ps.setInt(1, com.getIdComida());
                ps.setInt(2, ip.getKey());
                ps.setDouble(3, ip.getValue());
                ps.executeUpdate();
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar ComidasIngredientes");
        }
    }

    /**
     * noAptoComidas(HashMap<Integer, Double> ingrePesos): Determina las
     * condiciones de salud para las que una comida no es apta en base a sus
     * ingredientes. Autor: Zegarra
     *
     * @param ingrePesos HashMap con ID de ingredientes y sus pesos
     * @return String con las condiciones no aptas para la comida
     */
    public String noAptoComidas(HashMap<Integer, Double> ingrePesos) {
        PacienteData pd = new PacienteData();//uso para convertir el HashSet en un String
        HashSet<String> condiCom = new HashSet<>();
        HashSet<String> condiIng;
        IngredientesData id = new IngredientesData();
        String cond;
        for (HashMap.Entry<Integer, Double> ip : ingrePesos.entrySet()) {
            Ingredientes ingrediente = id.buscarIngredientes(ip.getKey());

            condiIng = pd.convertirStringSet(ingrediente.getNoApto());
            condiCom.addAll(condiIng);
        }
        cond = pd.convertirSetString(condiCom);
        return cond;
    }

    /**
     * caloriasComidas(HashMap<Integer, Double> ingredientesPesos): Calcula las
     * calorias totales de una comida en base a los ingredientes y sus pesos.
     * Autor: Zegarra
     *
     * @param ingredientesPesos HashMap con ID de ingredientes y sus pesos
     * @return double con las calorias totales de la comida redondeadas a dos
     * decimales
     */
    public double caloriasComidas(HashMap<Integer, Double> ingredientesPesos) {
        double calorias = 0;
        IngredientesData id = new IngredientesData();
        for (HashMap.Entry<Integer, Double> ip : ingredientesPesos.entrySet()) {
            Ingredientes ingrediente = id.buscarIngredientes(ip.getKey());
            if (ingrediente != null) {
                double aux = ingrediente.getCaloriasPor100() / 100;
                calorias += aux * ip.getValue();
            }
        }
        return Math.round(calorias * 100.0) / 100.0;
    }

    /**
     * buscarIngredientesComidas(int idCom): Recupera los ingredientes y sus
     * pesos asociados a una comida especifica en la base de datos.
     * Autor:Zegarra
     *
     * @param idCom ID de la comida cuyos ingredientes se desean buscar
     * @return HashMap con IDs de ingredientes y sus pesos, vacio si no se
     * encuentran
     */
    public HashMap<Integer, Double> buscarIngredientesComidas(int idCom) {
        HashMap<Integer, Double> ingredientesPesos = new HashMap<>();
        String sql = "SELECT * FROM ingredientescomidas WHERE IdComidas=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCom);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ingredientesPesos.put(rs.getInt("IdIngredientes"), rs.getDouble("peso"));
            }
            if (ingredientesPesos.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontro ningun ingrediente para esa comida");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al Buscar en IngredientesComidas");
        }
        return ingredientesPesos;
    }

    /**
     * modificarComida(Comidas com, HashMap<Integer, Double> ingredientesPesos):
     * Actualiza los datos de una comida en la base de datos, incluyendo sus
     * ingredientes asociados. Autor: Zegarra
     *
     * @param com Objeto Comidas con los nuevos datos de la comida
     * @param ingredientesPesos HashMap con IDs de ingredientes y sus pesos
     * @return true si la comida se modifico correctamente, false si no se
     * encontro o ocurrio un error
     */
    public boolean modificarComida(Comidas com, HashMap<Integer, Double> ingredientesPesos) {
        String sql = "UPDATE comidas SET Nombre=? ,TipoDeComida=? ,CaloriasComida= ?,NoApto=? WHERE IdComidas=? ;";
        boolean as = true;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, com.getNombre());
            ps.setString(2, com.getTipoDeComida());
            ps.setDouble(3, com.getCaloriasComida());
            ps.setString(4, noAptoComidas(ingredientesPesos));
            ps.setInt(5, com.getIdComida());
            int cont = ps.executeUpdate();
            if (cont > 0) {
                JOptionPane.showMessageDialog(null, "Se modifico en comidas correctamente");
                actualizaringredientescomidas(com.getIdComida(), ingredientesPesos);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro la comida o esta dada de baja");
                as = false;
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al modificar en comidas");
            as = false;

        }
        return as;
    }

    /**
     * actualizaringredientescomidas(int idComida, HashMap<Integer, Double>
     * ingredientesPesos): Elimina los ingredientes actuales de una comida y
     * luego inserta los nuevos ingredientes con sus pesos en la base de datos.
     * Autor: Zegarra
     *
     * @param idComida ID de la comida que se actualizara
     * @param ingredientesPesos HashMap con IDs de ingredientes y sus nuevos
     * pesos
     */
    public void actualizaringredientescomidas(int idComida, HashMap<Integer, Double> ingredientesPesos) {
        String sql1 = "DELETE FROM ingredientescomidas WHERE IdComidas = ?;";
        String sql2 = "INSERT INTO ingredientescomidas (IdComidas, IdIngredientes, peso) VALUES (?, ?, ?);";

        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(sql1);
            ps.setInt(1, idComida);
            ps.executeUpdate();//elimina las tuplas para IdComidas
            ps = con.prepareStatement(sql2);
            for (HashMap.Entry<Integer, Double> ip : ingredientesPesos.entrySet()) {
                int id = ip.getKey();
                double peso = ip.getValue();
                ps.setInt(1, idComida);
                ps.setInt(2, id);
                ps.setDouble(3, peso);
                ps.executeUpdate();//Inserta los nuevos ingredientes
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar en IngredientesComidas");
        }
    }

    public void bajaLogica(int id) {
        String sql = "UPDATE comidas SET Estado = 0 WHERE IdComidas = ?";
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
        String sql = "UPDATE comidas SET Estado = 1 WHERE IdComidas = ?";
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
        String sql = "SELECT * FROM  comidas WHERE IdComidas=?;";
        Comidas comid = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery(); //devuelve consulta
            if (rs.next()) {
                comid = new Comidas(); //creacion del objeto
                comid.setIdComida(rs.getInt("IdComidas"));
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
        String sql = "SELECT * FROM comidas WHERE Estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comidas comida = new Comidas();
                comida.setIdComida(rs.getInt("IdComidas"));
                comida.setNombre(rs.getString("Nombre"));
                comida.setCaloriasComida(rs.getDouble("CaloriasComida"));
                comida.setTipoDeComida(rs.getString("TipoDeComida"));
                comida.setNoApto(rs.getString("NoApto"));
                comida.setEstado(rs.getBoolean("Estado"));

                lista.add(comida);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar comidas: " + ex.getMessage());
        }
        return lista;
    }
    public ArrayList<Comidas> listarComidasAll() {
        ArrayList<Comidas> lista = new ArrayList<>();
        String sql = "SELECT * FROM comidas ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comidas comida = new Comidas();
                comida.setIdComida(rs.getInt("IdComidas"));
                comida.setNombre(rs.getString("Nombre"));
                comida.setCaloriasComida(rs.getDouble("CaloriasComida"));
                comida.setTipoDeComida(rs.getString("TipoDeComida"));
                comida.setNoApto(rs.getString("NoApto"));
                comida.setEstado(rs.getBoolean("Estado"));

                lista.add(comida);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar comidas: " + ex.getMessage());
        }
        return lista;
    }

    public ArrayList<Comidas> listarComidasPorTipoDeComida(String tipo) {
        ArrayList<Comidas> lista = new ArrayList<>();
        String sql = "SELECT * FROM comidas WHERE Estado = 1 AND TipoDeComida = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, tipo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comidas comida = new Comidas();
                comida.setIdComida(rs.getInt("IdComidas"));
                comida.setNombre(rs.getString("Nombre"));
                comida.setCaloriasComida(rs.getDouble("Calorias"));
                comida.setTipoDeComida(rs.getString("Tipo"));
                comida.setNoApto(rs.getString("NoApto"));
                comida.setEstado(rs.getBoolean("Estado"));

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
        String sql = "SELECT * FROM comidas WHERE Estado = 1";
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
                comida.setIdComida(rs.getInt("IdComidas"));
                comida.setNombre(rs.getString("Nombre"));
                comida.setCaloriasComida(rs.getDouble("CaloriasComida"));
                comida.setTipoDeComida(rs.getString("TipoDeComida"));
                comida.setNoApto(rs.getString("NoApto"));
                comida.setEstado(rs.getBoolean("Estado"));
                lista.add(comida);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al listar comidas por no condición: " + ex.getMessage());
        }
        return lista;
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

    public ArrayList<Comidas> listaMaxCalorias(double maxCalorias) {
        ArrayList<Comidas> lista = new ArrayList<>();
        int x = 1;
        String sql = "SELECT * FROM comidas WHERE Estado = 1 AND CaloriasComida <= ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, maxCalorias);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comidas in = new Comidas();
                in.setIdComida(rs.getInt("IdComidas"));
                in.setNombre(rs.getString("Nombre"));
                in.setTipoDeComida(rs.getString("TipoDeComida"));
                in.setCaloriasComida(rs.getDouble("CaloriasComida"));
                in.setNoApto(rs.getString("NoApto"));
                in.setEstado(rs.getBoolean("Estado"));
                lista.add(in);
                x++;
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

    public ArrayList<Comidas> listaMinCalorias(double minCalorias) {
        ArrayList<Comidas> lista = new ArrayList<>();
        int x = 1;
        String sql = "SELECT * FROM comidas WHERE Estado = 1 AND CaloriasComida >= ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, minCalorias);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comidas in = new Comidas();
                in.setIdComida(rs.getInt("IdComidas"));
                in.setNombre(rs.getString("Nombre"));
                in.setTipoDeComida(rs.getString("TipoDeComida"));
                in.setCaloriasComida(rs.getDouble("CaloriasComida"));
                in.setNoApto(rs.getString("NoApto"));
                in.setEstado(rs.getBoolean("Estado"));
                lista.add(in);
                x++;
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

    public ArrayList<Comidas> listaMinMaxCalorias(double minCalorias, double maxCalorias) {
        ArrayList<Comidas> lista = new ArrayList<>();
        int x = 1;
        String sql = "SELECT * FROM comidas WHERE Estado = 1 AND CaloriasComida BETWEEN ? AND ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, minCalorias);
            ps.setDouble(2, maxCalorias);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                double caloT = rs.getDouble("CaloriasComida");
                Comidas in = new Comidas();
                in.setIdComida(rs.getInt("IdComidas"));
                in.setNombre(rs.getString("Nombre"));
                in.setTipoDeComida(rs.getString("TipoDeComida"));
                in.setCaloriasComida(rs.getDouble("CaloriasComida"));
                in.setNoApto(rs.getString("NoApto"));
                in.setEstado(rs.getBoolean("Estado"));
                lista.add(in);
                x++;
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
