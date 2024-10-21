package Persistencia;

import Modelo.Conexion;
import Modelo.Paciente;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;

public class PacienteData {
    private Connection con = null;
    
    public PacienteData(){
        con = (Connection) Conexion.getConexion();
    }
    
   /* public void guardarPaciente(Paciente pac){
        String sql = "INSERT INTO paciente(dni, nombre, telefono, domicilio, estado) "
                + "VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pac.getDni());
            ps.setString(2, pac.getNombre());
            ps.setInt(3, pac.getTelefono());
            ps.setString(4, pac.getDomicilio() );
            ps.setBoolean(5, pac.isEstado());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pac.setIdPaciente(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Paciente Guardado Existosamente");
            }
            //No influye
            else{
                JOptionPane.showMessageDialog(null, "El Paciente ya existe");
            }
            //
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Paciente");
        }
    }
    
    public void actualizarPaciente(Paciente pac) {
        String sql = "UPDATE paciente SET nombre = ?, telefono = ?, domicilio = ? WHERE dni = ?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, pac.getNombre());
            ps.setInt(2, pac.getTelefono());
            ps.setString(3, pac.getDomicilio());
            ps.setInt(4, pac.getDni());
            
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Paciente Modificado");
            } else{
                JOptionPane.showMessageDialog(null, "Paciente no encontrado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Paciente");
        }
    }*/
}
