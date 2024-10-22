
package Persistencia;

import Modelo.Conexion;
import Modelo.Dieta;
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
    
    
}
