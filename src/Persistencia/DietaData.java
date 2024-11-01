package Persistencia;

import Modelo.Conexion;
import Modelo.Dieta;
import Modelo.MenuDiario;
import Modelo.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;

public class DietaData {

    private Connection con = null;

    public DietaData() {
        con = (Connection) Conexion.getConexion();
    }

    public void guardarDieta(Dieta dieta) {

        String sql = "UPDATE dieta SET nombreDieta = ?, idMenu = ?, idPaciente = ?, fechaIni = ?, fechaFin = ?, pesoInicial = ?, pesoFinal = ?, totalCalorias = ?, estado = ? WHERE idDieta = ?";
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dieta.getNombreD());
            ps.setInt(2, dieta.getMenus().get(0).getIdMenu()); //en este caso obtendremos el elemento 0 revisar           
            ps.setInt(3, dieta.getPaciente().getIdPaciente());
            ps.setDate(4, java.sql.Date.valueOf(dieta.getFechaIni()));
            ps.setDate(5, java.sql.Date.valueOf(dieta.getFechaFin()));
            ps.setDouble(6, dieta.getPesoInicial());
            ps.setDouble(7, dieta.getPesoFinal());
            ps.setInt(8, dieta.getTotalCalorias());
            ps.setBoolean(9, dieta.isEstado());
            ps.setInt(10, dieta.getIdDieta());
            //del Arrayli de menu voy a obtener el elemento cero, quizas sea mejor obtener uno en especial//

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                dieta.setIdDieta(rs.getInt(1)); // Actualiza el id de la dieta guardada
                JOptionPane.showMessageDialog(null, "Dieta Guardada Exitosamente");
            } else {
                JOptionPane.showMessageDialog(null, "La Dieta ya existe");
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta");
        }
    }

    public void actualizarDieta(Dieta dieta) {
        String sql = "UPDATE dieta SET nombreD = ?, idPaciente = ?, fechaIni = ?, fechaFin = ?, pesoInicial = ?, pesoFinal = ?, totalCalorias = ?, estado = ? WHERE idDieta = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dieta.getNombreD());
            ps.setInt(2, dieta.getPaciente().getIdPaciente());
            ps.setDate(3, java.sql.Date.valueOf(dieta.getFechaIni()));
            ps.setDate(4, java.sql.Date.valueOf(dieta.getFechaFin()));
            ps.setDouble(5, dieta.getPesoInicial());
            ps.setDouble(6, dieta.getPesoFinal());
            ps.setInt(7, dieta.getTotalCalorias());
            ps.setBoolean(8, dieta.isEstado());
            ps.setInt(9, dieta.getIdDieta());

            int exito = ps.executeUpdate();
            if (exito == 1) {
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
        String sql = "SELECT * FROM dieta WHERE idDieta = ?";
        Dieta dieta = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dieta = new Dieta();
                dieta.setIdDieta(rs.getInt("idDieta"));
                dieta.setNombreD(rs.getString("nombreD"));
                dieta.setFechaIni(rs.getDate("fechaIni").toLocalDate());
                dieta.setFechaFin(rs.getDate("fechaFin").toLocalDate());
                dieta.setPesoInicial(rs.getDouble("pesoInicial"));
                dieta.setPesoFinal(rs.getDouble("pesoFinal"));
                dieta.setTotalCalorias(rs.getInt("totalCalorias"));
                dieta.setEstado(rs.getBoolean("estado"));

                int idPaciente = rs.getInt("idPaciente"); // Obtener el id del paciente
                PacienteData pacienteData = new PacienteData(); // Instanciar PacienteData
                Paciente paciente = pacienteData.buscarPaciente(idPaciente); // Buscar el paciente por id
                dieta.setPaciente(paciente);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta: " + ex.getMessage());
        }
        return dieta;
    }

    public Dieta buscarDietaSegunNombre(String nombreD) {
        String sql = "SELECT * FROM dieta WHERE nombreDieta = ?";
        Dieta dieta = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombreD);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dieta = new Dieta();
                dieta.setIdDieta(rs.getInt("idDieta"));
                dieta.setNombreD(rs.getString("nombreD"));
                dieta.setFechaIni(rs.getDate("fechaIni").toLocalDate());
                dieta.setFechaFin(rs.getDate("fechaFin").toLocalDate());
                dieta.setPesoInicial(rs.getDouble("pesoInicial"));
                dieta.setPesoFinal(rs.getDouble("pesoFinal"));
                dieta.setTotalCalorias(rs.getInt("totalCalorias"));
                dieta.setEstado(rs.getBoolean("estado"));

                int idPaciente = rs.getInt("idPaciente"); // Obtener el id del paciente
                PacienteData pacienteData = new PacienteData(); // Instanciar PacienteData
                Paciente paciente = pacienteData.buscarPaciente(idPaciente); // Buscar el paciente por id
                dieta.setPaciente(paciente);

            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta: " + ex.getMessage());
        }
        return dieta;
    }

    public List<Dieta> buscarDietasEnRangoDeFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        String sql = "SELECT * FROM dieta WHERE fechaInicial BETWEEN ? AND ?";
        List<Dieta> dietas = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(fechaInicio));
            ps.setDate(2, java.sql.Date.valueOf(fechaFin));
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Dieta dieta = new Dieta();
                dieta.setIdDieta(rs.getInt("idDieta"));
                dieta.setNombreD(rs.getString("nombreD"));
                dieta.setFechaIni(rs.getDate("fechaIni").toLocalDate());
                dieta.setFechaFin(rs.getDate("fechaFin").toLocalDate());
                dieta.setPesoInicial(rs.getDouble("pesoInicial"));
                dieta.setPesoFinal(rs.getDouble("pesoFinal"));
                dieta.setTotalCalorias(rs.getInt("totalCalorias"));
                dieta.setEstado(rs.getBoolean("estado"));

                // Obtener y asignar el Paciente
                int idPaciente = rs.getInt("idPaciente");
                PacienteData pacienteData = new PacienteData();
                Paciente paciente = pacienteData.buscarPaciente(idPaciente);
                dieta.setPaciente(paciente);

                // Agregar dieta a la lista
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
        String preguntaDieta = "SELECT * FROM Dieta WHERE IdPaciente = ?";

        try {
            PreparedStatement obtDieta = con.prepareStatement(preguntaDieta);
            obtDieta.setInt(1, idPaciente);
            ResultSet rsDieta = obtDieta.executeQuery();

            if (rsDieta.next()) {
                dieta = new Dieta();
                dieta.setNombreD(rsDieta.getString("NombreDieta"));
                dieta.setFechaIni(rsDieta.getDate("FechaIni").toLocalDate());
                dieta.setFechaFin(rsDieta.getDate("FechaFin").toLocalDate());
                dieta.setTotalCalorias(rsDieta.getInt("TotalCalorias"));
                
                int idDieta = rsDieta.getInt("IdDieta");

                // Obtiene los menús diarios para esta dieta
                MenuDiarioData menuData = new MenuDiarioData();
                List<MenuDiario> menusDiarios = menuData.listarMenuDiario();
                dieta.setMenus((ArrayList<MenuDiario>) menusDiarios);

            } else {
                System.out.println("No se encontró ninguna dieta para el paciente con ID: " + idPaciente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener dieta: " + e.getMessage());
        }
        return dieta;
    }

   
}
