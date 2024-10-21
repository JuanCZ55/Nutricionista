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

    public PacienteData() {
        con = (Connection) Conexion.getConexion();
    }

    public void guardarPaciente(Paciente pac) {//usar el constructor sin id y estado
        String sql = "INSERT INTO paciente(nombre, edad, altura, pesoActual, pesoBuscado) VALUES (?,?,?,?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pac.getNombre());
            ps.setInt(2, pac.getEdad());
            ps.setDouble(3, pac.getAltura());
            ps.setDouble(4, pac.getPesoActual());
            ps.setDouble(5, pac.getPesoBuscado());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pac.setIdPaciente(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Paciente Guardado Existosamente");
            } //No influye
            else {
                JOptionPane.showMessageDialog(null, "El Paciente ya existe");
            }
            //
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Paciente");
        }
    }

    public void actualizarPaciente(Paciente pac) {//usar constructor con id sin estado
        String sql = "UPDATE `paciente` SET `nombre`=?,`edad`='?,`altura`=?,`pesoActual`=?,`pesoBuscado`=? WHERE `idPaciente`=?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, pac.getNombre());
            ps.setInt(2, pac.getEdad());
            ps.setDouble(3, pac.getAltura());
            ps.setDouble(4, pac.getPesoActual());
            ps.setDouble(5, pac.getPesoBuscado());
            ps.setInt(6, pac.getIdPaciente());

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Paciente Modificado");
            } else {
                JOptionPane.showMessageDialog(null, "Paciente no encontrado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar al Paciente");
        }
    }

    public void bajaLogica(int id) {
        String sql = "UPDATE paciente SET estado = 0 WHERE idPaciente=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Paciente Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Paciente no encontrado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Paciente");
        }
    }

    public void altaLogica(int id) {
        String sql = "UPDATE paciente SET estado = 1 WHERE idPaciente=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Paciente Eliminado");
            } else {
                JOptionPane.showMessageDialog(null, "Paciente no encontrado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Paciente");
        }
    }

    public Paciente buscarPaciente(int id) {
        String sql = "SELECT `idPaciente`, `nombre`, `edad`, `altura`, `pesoActual`, `pesoBuscado`, `estado` FROM `paciente` WHERE `idPaciente`=?;";
        Paciente pac = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pac = new Paciente();
                pac.setIdPaciente(rs.getInt("idPaciente"));
                pac.setNombre(rs.getString("nombre"));
                pac.setEdad(rs.getInt("edad"));
                pac.setAltura(rs.getDouble("altura"));
                pac.setPesoActual(rs.getDouble("pesoActual"));
                pac.setPesoBuscado(rs.getDouble("pesoBuscado"));
                pac.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese Alumno");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar paciente");
        }
        return pac;
    }

    public ArrayList<Paciente> listarPacientes() {
        String sql = "SELECT * FROM paciente";
        int x = 0;
        Paciente paciente = null;
        ArrayList<Paciente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("idPaciente"));
                paciente.setNombre(rs.getString("nombre"));
                paciente.setEdad(rs.getInt("edad"));
                paciente.setAltura(rs.getDouble("altura"));
                paciente.setPesoActual(rs.getDouble("pesoActual"));
                paciente.setPesoBuscado(rs.getDouble("pesoBuscado"));
                paciente.setEstado(rs.getBoolean("estado"));

                lista.add(paciente);
                x++;
            }
            if (x == 0) {
                JOptionPane.showMessageDialog(null, "No hay Pacientes");
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pacientes");
        }

        return lista;
    }

}
