package Persistencia;

import Modelo.Paciente;
import Modelo.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;

public class PacienteData {

    private Connection con = null;

    public PacienteData() {
        con = (Connection) Conexion.getConexion();
    }
//Inserta un nuevo paciente en la base de datos

    public void guardarPaciente(Paciente paciente) {//usar el constructor sin id y estado
        String sql = "INSERT INTO paciente(Nombre, Edad, Altura, CondicionSalud, PesoActual, PesoBuscado, PesoInical) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, paciente.getNombre());
            ps.setInt(2, paciente.getEdad());
            ps.setDouble(3, paciente.getAltura());
            ps.setString(4, String.join(",", paciente.getCondicionSalud()));//castea el arraylist a string
            ps.setDouble(5, paciente.getPesoActual());
            ps.setDouble(6, paciente.getPesoBuscado());
            ps.setDouble(7, paciente.getPesoInicial());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                paciente.setIdPaciente(rs.getInt(1));
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
//Actualiza el nombre, edad, altura, condicion de salud de un paciente

    public void actualizarPaciente(Paciente pac) {//usar constructor con id sin estado 
        String sql = "UPDATE  paciente  SET  Nombre =?, Edad =?, Altura =?,CondicionSalud=? WHERE  IdPaciente  =?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, pac.getNombre());
            ps.setInt(2, pac.getEdad());
            ps.setDouble(3, pac.getAltura());
            ps.setString(4, String.join(",", pac.getCondicionSalud()));
            ps.setInt(5, pac.getIdPaciente());

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
        String sql = "UPDATE paciente SET Estado = 0 WHERE IdPaciente =?";
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
        String sql = "UPDATE paciente SET Estado = 1 WHERE IdPaciente =?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Paciente Habilitado");
            } else {
                JOptionPane.showMessageDialog(null, "Paciente no encontrado");
            }
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Paciente");
        }
    }
//modifica el peso buscado

    public void cambiarPesoBuscado(int id, double pesoBuscado) {
        String sql = "UPDATE  paciente  SET  PesoBuscado =? WHERE  IdPaciente  =?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, pesoBuscado);
            ps.setInt(2, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Peso Cambiado");
            } else {
                JOptionPane.showMessageDialog(null, "Paciente no encontrado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el peso buscado");
        }
    }
//sirve para actualizar el peso actual

    public void actualizarPesoActual(int id, double pesoAct) {
        String sql = "UPDATE  paciente  SET  pesoActual =? WHERE  IdPaciente  =?;";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, pesoAct);
            ps.setInt(2, id);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Peso Actual Actualizado");
            } else {
                JOptionPane.showMessageDialog(null, "Paciente no encontrado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al actualizar el peso buscado");
        }
    }
//verifica si acerca al peso sin importar si sube o baja

    public boolean seAcercaAlPaso(int id) {
        String sql = "SELECT  * FROM  paciente  WHERE  IdPaciente  =?;";
        Paciente pac = null;
        boolean llega = false;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pac = new Paciente();

                pac.setPesoActual(rs.getDouble("PesoActual"));
                pac.setPesoBuscado(rs.getDouble("PesoBuscado"));
                pac.setPesoInicial(rs.getDouble("PesoInical"));
                if (pac != null) {
                    // Perder peso
                    if (pac.getPesoInicial() > pac.getPesoBuscado()) {
                        if (pac.getPesoActual() < pac.getPesoInicial() && pac.getPesoActual() >= pac.getPesoBuscado()) {
                            llega = true;
                        }
                    } // Ganar peso
                    else if (pac.getPesoInicial() < pac.getPesoBuscado()) {
                        if (pac.getPesoActual() > pac.getPesoInicial() && pac.getPesoActual() <= pac.getPesoBuscado()) {
                            llega = true;
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe ese Paciente");
            }
            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar paciente");
        }
        return llega;
    }

    public Paciente buscarPaciente(int id) {
        String sql = "SELECT  *  FROM  paciente  WHERE  IdPaciente  =?;";
        Paciente pac = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pac = new Paciente();
                pac.setIdPaciente(rs.getInt("IdPaciente "));
                pac.setNombre(rs.getString("Nombre"));
                pac.setEdad(rs.getInt("Edad"));
                pac.setAltura(rs.getDouble("Altura"));
                pac.setPesoActual(rs.getDouble("PesoActual"));
                pac.setPesoBuscado(rs.getDouble("PesoBuscado"));
                pac.setPesoInicial(rs.getDouble("PesoInical"));
                pac.setCondicionSalud(convertirStringSet(rs.getString("CondicionSalud")));

                pac.setEstado(rs.getBoolean("Estado"));
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
//Lista todos los pacientes

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
                paciente.setIdPaciente(rs.getInt("IdPaciente "));
                paciente.setNombre(rs.getString("Nombre"));
                paciente.setEdad(rs.getInt("Edad"));
                paciente.setAltura(rs.getDouble("Altura"));
                paciente.setPesoActual(rs.getDouble("PesoActual"));
                paciente.setPesoBuscado(rs.getDouble("PesoBuscado"));
                paciente.setPesoInicial(rs.getDouble("PesoInical"));
                paciente.setCondicionSalud(convertirStringSet(rs.getString("CondicionSalud")));

                paciente.setEstado(rs.getBoolean("Estado"));

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
//Devuelve una lista de los pacientes que tienen el mismo peso buscado con el actual

    public ArrayList<Paciente> listarLosQueLLegaron() {
        String sql = "SELECT * FROM paciente WHERE PesoActual=PesoBuscado";
        int x = 0;
        Paciente paciente = null;
        ArrayList<Paciente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("IdPaciente "));
                paciente.setNombre(rs.getString("Nombre"));
                paciente.setEdad(rs.getInt("Edad"));
                paciente.setAltura(rs.getDouble("Altura"));
                paciente.setPesoActual(rs.getDouble("PesoActual"));
                paciente.setPesoBuscado(rs.getDouble("PesoBuscado"));
                paciente.setPesoInicial(rs.getDouble("PesoInical"));
                paciente.setCondicionSalud(convertirStringSet(rs.getString("CondicionSalud")));

                paciente.setEstado(rs.getBoolean("Estado"));

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

    /**
     * Convierte una cadena con formato ("palabra1,palabra2,palabra3,palabra4")
     * en un HashSet<String>, separando cada palabra individualmente.
     *
     * @param cond Cadena a dividir, en formato de palabras separadas por comas.
     * @return HashSet<String> Devuelve un conjunto de palabras sin duplicados y
     * sin espacios adicionales.
     */
    public HashSet<String> convertirStringSet(String cond) {
        HashSet<String> listahash = new HashSet<>();
        // Verificar que la cadena no sea nula ni vacía
        if (cond != null && !cond.trim().isEmpty()) {
            // Dividir la cadena en elementos y agregarlos al HashSet
            String[] arrs = cond.split(",");
            for (String ar : arrs) {
                listahash.add(ar.trim()); // Agregar cada elemento sin espacios
            }
        }
        return listahash;
    }
}
