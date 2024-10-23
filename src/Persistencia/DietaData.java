
package Persistencia;

import Modelo.Conexion;
import Modelo.Dieta;
import Modelo.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;


public class DietaData {
    private Connection con = null;
    
    public DietaData(){
        con = (Connection) Conexion.getConexion();
    }
    public void guardarDieta(Dieta dieta) {
        
    String sql = "INSERT INTO dieta(nombre, idPaciente, fechaInicial, fechaFinal, pesoInicial, pesoFinal) "
               + "VALUES (?, ?, ?, ?, ?, ?)";
    try {
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, dieta.getNombreD());           
        ps.setInt(2, dieta.getPaciente().getIdPaciente());          
        ps.setDate(3, java.sql.Date.valueOf(dieta.getFechaIni()));
        ps.setDate(4, java.sql.Date.valueOf(dieta.getFechaFin()));
        ps.setDouble(5, dieta.getPesoInicial());     
        ps.setDouble(6, dieta.getPesoFinal());    
        ps.executeUpdate();
        
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
    String sql = "UPDATE dieta SET nombre = ?, idPaciente = ?, fechaInicial = ?, fechaFinal = ?, pesoInicial = ?, pesoFinal = ? WHERE idDieta = ?;";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, dieta.getNombreD());
        ps.setInt(2, dieta.getPaciente().getIdPaciente());
        ps.setDate(3, java.sql.Date.valueOf(dieta.getFechaIni())); 
        ps.setDate(4, java.sql.Date.valueOf(dieta.getFechaFin()));   
        ps.setDouble(5, dieta.getPesoInicial());
        ps.setDouble(6, dieta.getPesoFinal());
        ps.setInt(7, dieta.getIdDieta());  
        
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
    public Dieta buscarDieta(int idDieta) {
        String sql = "SELECT * FROM dieta WHERE idDieta = ?;";
        Dieta dieta = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDieta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                dieta = new Dieta();
                dieta.setIdDieta(rs.getInt("idDieta"));
                dieta.setNombreD(rs.getString("nombre"));
                dieta.setFechaIni(rs.getDate("fechaInicial").toLocalDate());
                dieta.setFechaFin(rs.getDate("fechaFinal").toLocalDate());
                dieta.setPesoInicial(rs.getDouble("pesoInicial"));
                dieta.setPesoFinal(rs.getDouble("pesoFinal"));
                dieta.setTotalCalorias(rs.getInt("totalCalorias"));
                dieta.setEstado(rs.getBoolean("estado"));
                
                int idPaciente = rs.getInt("idPaciente"); //obtener el id del paciente
                // Tenemos que buscar por su clave foranea un paciente 
                PacienteData pacienteData = new PacienteData(); //instanciamos 
                Paciente paciente = pacienteData.buscarPaciente(idPaciente); 
                dieta.setPaciente(paciente);
                JOptionPane.showMessageDialog(null, "Dieta encontrada");
                
            } else {
                JOptionPane.showMessageDialog(null, "Dieta no encontrada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta: " + ex.getMessage());
        }
        return dieta;
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
}
