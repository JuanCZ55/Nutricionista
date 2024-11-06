package Persistencia;

import Modelo.Conexion;
import Modelo.Dieta;
import Modelo.MenuDiario;
import Modelo.Paciente;
import Vista.Comida;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;

public class DietaData {

    private Connection con = null;

    public DietaData() {
        con = (Connection) Conexion.getConexion();
    }

    public void actualizarDieta(Dieta dieta) {
         String sql = "UPDATE dieta SET NombreDieta = ?, IdPaciente = ?, FechaInicial = ?, FechaFinal = ?, TotalCalorias = ?, Estado = ? WHERE IdDieta = ?";  
        try {  
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setString(1, dieta.getNombreD());  
            ps.setInt(2, dieta.getPaciente().getIdPaciente());  
            ps.setDate(3, java.sql.Date.valueOf(dieta.getFechaIni()));  
            ps.setDate(4, java.sql.Date.valueOf(dieta.getFechaFin()));  
            ps.setDouble(5, dieta.getTotalCalorias());  
            ps.setBoolean(6, dieta.isEstado());  
            ps.setInt(7, dieta.getIdDieta());  

            int updatedRows = ps.executeUpdate();  
            if (updatedRows == 1) {  
                JOptionPane.showMessageDialog(null, "Dieta Modificada Exitosamente");  
            } else {  
                JOptionPane.showMessageDialog(null, "Dieta no encontrada");  
            }  
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta: " + ex.getMessage());
        }
    }

    public Dieta buscarDietaSegunID(int idDieta) {
        String sql = "SELECT * FROM dieta WHERE IdDieta = ?";  
        Dieta dieta = null;  
        try {  
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setInt(1, idDieta);  
            ResultSet rs = ps.executeQuery();  
            if (rs.next()) {  
                dieta = new Dieta();  
                dieta.setIdDieta(rs.getInt("IdDieta"));  
                dieta.setNombreD(rs.getString("NombreDieta"));  
                dieta.setFechaIni(rs.getDate("FechaInicial").toLocalDate());  
                dieta.setFechaFin(rs.getDate("FechaFinal").toLocalDate());  
                dieta.setTotalCalorias(rs.getDouble("TotalCalorias"));  
                dieta.setEstado(rs.getBoolean("Estado"));  

                int idPaciente = rs.getInt("IdPaciente");  
                PacienteData pacienteData = new PacienteData();  
                Paciente paciente = pacienteData.buscarPaciente(idPaciente);  
                dieta.setPaciente(paciente);  
            }  
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta: " + ex.getMessage());
        }
        return dieta;
    }

    public Dieta buscarDietaSegunNombre(String nombreD) {
        String sql = "SELECT * FROM dieta WHERE NombreDieta = ?";  
        Dieta dieta = null;  
        try {  
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setString(1, nombreD);  
            ResultSet rs = ps.executeQuery();  
            if (rs.next()) {  
                dieta = new Dieta();  
                dieta.setIdDieta(rs.getInt("IdDieta"));  
                dieta.setNombreD(rs.getString("NombreDieta"));  
                dieta.setFechaIni(rs.getDate("FechaInicial").toLocalDate());  
                dieta.setFechaFin(rs.getDate("FechaFinal").toLocalDate());  
                dieta.setTotalCalorias(rs.getDouble("TotalCalorias"));  
                dieta.setEstado(rs.getBoolean("Estado"));  

                int idPaciente = rs.getInt("IdPaciente");  
                PacienteData pacienteData = new PacienteData();  
                Paciente paciente = pacienteData.buscarPaciente(idPaciente);  
                dieta.setPaciente(paciente);  
            }  
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta: " + ex.getMessage());
        }
        return dieta;
    }

    public List<Dieta> buscarDietasEnRangoDeFechas(LocalDate fechaInicio, LocalDate fechaFin) {
         String sql = "SELECT * FROM dieta WHERE FechaInicial BETWEEN ? AND ?";  
        List<Dieta> dietas = new ArrayList<>();  

        try {  
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setDate(1, java.sql.Date.valueOf(fechaInicio));  
            ps.setDate(2, java.sql.Date.valueOf(fechaFin));  
            ResultSet rs = ps.executeQuery();  

            while (rs.next()) {  
                Dieta dieta = new Dieta();  
                dieta.setIdDieta(rs.getInt("IdDieta"));  
                dieta.setNombreD(rs.getString("NombreDieta"));  
                dieta.setFechaIni(rs.getDate("FechaInicial").toLocalDate());  
                dieta.setFechaFin(rs.getDate("FechaFinal").toLocalDate());  
                dieta.setTotalCalorias(rs.getDouble("TotalCalorias"));  
                dieta.setEstado(rs.getBoolean("Estado"));  

                int idPaciente = rs.getInt("IdPaciente");  
                PacienteData pacienteData = new PacienteData();  
                Paciente paciente = pacienteData.buscarPaciente(idPaciente);  
                dieta.setPaciente(paciente);  

                dietas.add(dieta);  
            }  

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta: " + ex.getMessage());
        }

        return dietas;
    }

    public void bajaLogica(int idDieta) {
        String sql = "UPDATE dieta SET estado = 0 WHERE idDieta = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Dieta desactivada");
            } else {
                JOptionPane.showMessageDialog(null, "Dieta no encontrada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta: " + ex.getMessage());
        }
    }

    public void altaLogica(int idDieta) {
        String sql = "UPDATE dieta SET estado = 1 WHERE idDieta = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Dieta reactivada");
            } else {
                JOptionPane.showMessageDialog(null, "Dieta no encontrada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta: " + ex.getMessage());
        }
    }

    public void borrarDieta(int idDieta) {
        String sql = "DELETE FROM dieta WHERE idDieta = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Dieta eliminada");
            } else {
                JOptionPane.showMessageDialog(null, "Dieta no encontrada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la dieta: " + ex.getMessage());
        }
    }

    public Dieta obtenerDieta(int idPaciente) {
         Dieta dieta = null;  
        String preguntaDieta = "SELECT * FROM dieta WHERE IdPaciente = ?";  

        try {  
            PreparedStatement obtDieta = con.prepareStatement(preguntaDieta);  
            obtDieta.setInt(1, idPaciente);  
            ResultSet rsDieta = obtDieta.executeQuery();  

            if (rsDieta.next()) {  
                dieta = new Dieta();  
                dieta.setIdDieta(rsDieta.getInt("IdDieta"));  
                dieta.setNombreD(rsDieta.getString("NombreDieta"));  
                dieta.setFechaIni(rsDieta.getDate("FechaInicial").toLocalDate());  
                dieta.setFechaFin(rsDieta.getDate("FechaFinal").toLocalDate());  
                dieta.setTotalCalorias(rsDieta.getDouble("TotalCalorias"));  

                // Obtiene los menús diarios para esta dieta  
                MenuDiarioData menuData = new MenuDiarioData();  
                List<MenuDiario> menusDiarios = menuData.listarMenuDiario();  
                dieta.setMenus((ArrayList<MenuDiario>) menusDiarios);  

            } else {  
                JOptionPane.showMessageDialog(null, "No se encontró ninguna dieta para el paciente con ID: " + idPaciente);
            }  
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener dieta: " + e.getMessage());
        }
        return dieta;
    }
    
    public List<MenuDiario> obtenerMenuDiario(int idDieta) {  
        List<MenuDiario> menuDiarioList = new ArrayList<>();  
        String sql = "SELECT * FROM menudario WHERE IdDieta = ?";  

        try {  
            PreparedStatement ps = con.prepareStatement(sql);  
            ps.setInt(1, idDieta);  
            ResultSet rs = ps.executeQuery();  

            while (rs.next()) {  
                MenuDiario menu = new MenuDiario();  
                menu.setIdMenu(rs.getInt("IdMenuDiario")); 
                menu.setCaloriasDelMenu(rs.getDouble("CaloriasDia")); 
                menu.setDia(rs.getInt("Dia")); 
                menu.setEstado(rs.getInt("Estado") == 1); 
                menuDiarioList.add(menu);  
            }  

        } catch (SQLException e) {  
            JOptionPane.showMessageDialog(null, "Error al obtener menú diario: " + e.getMessage());  
        }  

        return menuDiarioList;  
    }  

    public Dieta generarDietaAleatoria(Paciente paciente, int dias, int idDieta) {  
        if (dias < 3 || dias > 7) {  
            JOptionPane.showMessageDialog(null, "La cantidad de días debe ser de 3 a 7");  
            return null; // Salir si no es válido  
        }  

        Random random = new Random();  
        Dieta dieta = new Dieta();  
        dieta.setPaciente(paciente);  
        dieta.setNombreD("Dieta Aleatoria " + LocalDate.now());  
        dieta.setFechaIni(LocalDate.now());  
        dieta.setFechaFin(LocalDate.now().plusDays(dias - 1));  
        dieta.setEstado(true);  
        double totalCalorias = 0;  

        // Obtener el menú diario desde la base de datos  
        List<MenuDiario> menuDiarioList = obtenerMenuDiario(idDieta);  

        for (int i = 0; i < dias; i++) {  
            if (!menuDiarioList.isEmpty()) {  
                // Selecciona un menú aleatorio  
                MenuDiario menuDelDia = menuDiarioList.get(random.nextInt(menuDiarioList.size()));  
                
//                // Supongamos que hay un método que obtiene las comidas a partir del id de menu del día  
//                List<Comida> comidasDelDia = obtenerComidasDelDia(menuDelDia.getIdMenu());  
//                
//                // Agregar las comidas del día a la dieta  
//                for (Comida comida : comidasDelDia) {  
//                    dieta.agregarComida(comida);  
//                    totalCalorias += comida.getCalorias();  
//                }  
            }  
        }  

        dieta.setTotalCalorias(totalCalorias);  
        return dieta;  
    }  
    public List<Dieta> obtenerTodasLasDietas() {
    List<Dieta> listaDietas = new ArrayList<>();
    String preguntaDieta = "SELECT * FROM dieta";  

    try {  
        PreparedStatement obtDieta = con.prepareStatement(preguntaDieta);  
        ResultSet rsDieta = obtDieta.executeQuery();  

        while (rsDieta.next()) {  
            Dieta dieta = new Dieta();  
            dieta.setIdDieta(rsDieta.getInt("IdDieta"));  
            dieta.setNombreD(rsDieta.getString("NombreDieta"));  
            dieta.setFechaIni(rsDieta.getDate("FechaInicial").toLocalDate());  
            dieta.setFechaFin(rsDieta.getDate("FechaFinal").toLocalDate());  
            dieta.setTotalCalorias(rsDieta.getDouble("TotalCalorias"));  

            // Obtiene los menús diarios para esta dieta  
            MenuDiarioData menuData = new MenuDiarioData();  
            List<MenuDiario> menusDiarios = menuData.listarMenuDiario();  
            dieta.setMenus((ArrayList<MenuDiario>) menusDiarios);

            listaDietas.add(dieta);  
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener dietas: " + e.getMessage());
    }
    return listaDietas;
}

   
}
