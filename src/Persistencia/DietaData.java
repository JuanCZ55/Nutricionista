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

        String sql = "UPDATE dieta SET nombreD = ?, idMenu = ?, idPaciente = ?, fechaIni = ?, fechaFin = ?, pesoInicial = ?, pesoFinal = ?, totalCalorias = ?, estado = ? WHERE idDieta = ?";
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

            } else {
                JOptionPane.showMessageDialog(null, "Dieta no encontrada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta: " + ex.getMessage());
        }
        return dieta;
    }

    public Dieta buscarDietaSegunNombre(String nombreD) {
        String sql = "SELECT * FROM dieta WHERE nombreD = ?";
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

            } else {
                JOptionPane.showMessageDialog(null, "Dieta no encontrada");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Dieta: " + ex.getMessage());
        }
        return dieta;
    }

    public List<Dieta> buscarDietasEnRangoDeFechas(LocalDate fechaInicio, LocalDate fechaFin) {
        String sql = "SELECT * FROM dieta WHERE fechaIni BETWEEN ? AND ?";
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

            if (dietas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se encontraron dietas en el rango de fechas especificado");
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
                List<MenuDiario> menusDiarios = obtenerMenusDiarios(idDieta);
                dieta.setMenusDiarios(menusDiarios);

            } else {
                System.out.println("No se encontró ninguna dieta para el paciente con ID: " + idPaciente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener dieta: " + e.getMessage());
        }
        return dieta;
    }

    private List<MenuDiario> obtenerMenusDiarios(int idDieta) {
        List<MenuDiario> menusDiarios = new ArrayList<>();
        String preguntaMenuDiario = "SELECT * FROM MenuDiario WHERE IdDieta = ?";

        try {
            PreparedStatement stmtMenuDiario = con.prepareStatement(preguntaMenuDiario);
            stmtMenuDiario.setInt(1, idDieta);
            ResultSet rsMenuDiario = stmtMenuDiario.executeQuery();

            while (rsMenuDiario.next()) {
                MenuDiario menu = new MenuDiario();
                menu.setDia(rsMenuDiario.getString("Dia"));
                menu.setCaloriasTotales(rsMenuDiario.getInt("CaloriasTotales"));

                int idMenuDiario = rsMenuDiario.getInt("IdMenuDiario");

                // Obtiene las comidas para este menú diario
                List<Comida> comidas = obtenerComidas(idMenuDiario);
                menu.setComidas(comidas);

                menusDiarios.add(menu);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener menús diarios: " + e.getMessage());
        }
        return menusDiarios;
    }

    private List<Comida> obtenerComidas(int idMenuDiario) {
        List<Comida> comidas = new ArrayList<>();
        String preguntaComidas = "SELECT * FROM Comidas WHERE IdComidas IN (SELECT IdComidas FROM MenuComidas WHERE IdMenuDiario = ?)";

        try {
            PreparedStatement stmtComidas = con.prepareStatement(preguntaComidas);
            stmtComidas.setInt(1, idMenuDiario);
            ResultSet rsComidas = stmtComidas.executeQuery();

            while (rsComidas.next()) {
                Comida comida = new Comida();
                comida.setNombre(rsComidas.getString("Nombre"));
                comida.setTipoDeComida(rsComidas.getString("TipoDeComida"));
                comida.setCaloriasTotal(rsComidas.getInt("CaloriasTotal"));

                int idComidas = rsComidas.getInt("IdComidas");

                // Obtiene los ingredientes para esta comida
                List<Ingrediente> ingredientes = obtenerIngredientes(idComidas);
                comida.setIngredientes(ingredientes);

                comidas.add(comida);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener comidas: " + e.getMessage());
        }
        return comidas;
    }

    private List<Ingrediente> obtenerIngredientes(int idComidas) {
        List<Ingrediente> ingredientes = new ArrayList<>();
        String preguntaIngredientes = "SELECT * FROM Ingredientes WHERE IdIngredientes IN (SELECT IdIngredientes FROM IngredientesComidas WHERE IdComidas = ?)";

        try {
            PreparedStatement stmtIngredientes = con.prepareStatement(preguntaIngredientes);
            stmtIngredientes.setInt(1, idComidas);
            ResultSet rsIngredientes = stmtIngredientes.executeQuery();

            while (rsIngredientes.next()) {
                Ingrediente ingrediente = new Ingrediente();
                ingrediente.setNombre(rsIngredientes.getString("Nombre"));
                ingrediente.setCaloriasPor100gr(rsIngredientes.getInt("Caloriaspor100gr"));
                ingredientes.add(ingrediente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener ingredientes: " + e.getMessage());
        }
        return ingredientes;
    }

    public ArrayList<String[]> obtenerInformacionCompletaDieta(int idDieta) {
        ArrayList<String[]> informacionCompleta = new ArrayList<>();

        // Busca la dieta
        Dieta dieta = buscarDieta(idDieta);
        if (dieta == null) {
            informacionCompleta.add(new String[]{"No se encontró la dieta con ID: " + idDieta});
            return informacionCompleta;
        }

        // Obtiene el paciente asociado a la dieta
        Paciente paciente = dieta.getPaciente();

        // Obtiene los menús diarios de la dieta
        List<MenuDiario> menusDiarios = dieta.getMenus();

        // Itera sobre cada menú diario para obtener las comidas y sus ingredientes
        for (MenuDiario menu : menusDiarios) {
            List<Comida> comidas = obtenerComidas(menu.getIdMenuDiario());
            for (Comida comida : comidas) {
                List<Ingrediente> ingredientes = obtenerIngredientes(comida.getIdComidas());

                // Si no hay ingredientes, al menos agregar la comida sin ingredientes
                if (ingredientes.isEmpty()) {
                    informacionCompleta.add(new String[]{
                        dieta.getNombreD(),
                        paciente.getNombre(),
                        paciente.getApellido(),
                        menu.getDia() + "",
                        comida.getNombre(),
                        comida.getTipoDeComida(),
                        String.valueOf(comida.getCaloriasTotal()),
                        "Sin ingredientes"
                    });
                } else {
                    // Agregar cada ingrediente de la comida
                    for (Ingrediente ingrediente : ingredientes) {
                        informacionCompleta.add(new String[]{
                            dieta.getNombreD(),
                            paciente.getNombre(),
                            paciente.getApellido(),
                            menu.getDia() + "",
                            comida.getNombre(),
                            comida.getTipoDeComida(),
                            String.valueOf(comida.getCaloriasTotal()),
                            ingrediente.getNombre(),
                            String.valueOf(ingrediente.getCaloriasPor100gr())
                        });
                    }
                }
            }
        }

        return informacionCompleta;
    }

    public ArrayList<String[]> obtenerInformacionDietaPorDia(int idDieta, int dia) {
        ArrayList<String[]> informacionPorDia = new ArrayList<>();

        // Busca la dieta
        Dieta dieta = buscarDieta(idDieta);
        if (dieta == null) {
            informacionPorDia.add(new String[]{"No se encontró la dieta con ID: " + idDieta});
            return informacionPorDia;
        }

        // Obtiene el paciente asociado a la dieta
        Paciente paciente = dieta.getPaciente();

        // Obtiene los menús diarios de la dieta
        List<MenuDiario> menusDiarios = dieta.getMenus();

        // Itera sobre cada menú diario para obtener las comidas y sus ingredientes
        for (MenuDiario menu : menusDiarios) {
            if (menu.getDia() == dia) {  // Filtra solo por el día especificado
                List<Comida> comidas = obtenerComidas(menu.getIdMenuDiario());
                for (Comida comida : comidas) {
                    List<Ingrediente> ingredientes = obtenerIngredientes(comida.getIdComidas());

                    // Si no hay ingredientes, al menos agregar la comida sin ingredientes
                    if (ingredientes.isEmpty()) {
                        informacionPorDia.add(new String[]{
                            dieta.getNombreD(),
                            paciente.getNombre(),
                            paciente.getApellido(),
                            String.valueOf(menu.getDia()),
                            comida.getNombre(),
                            comida.getTipoDeComida(),
                            String.valueOf(comida.getCaloriasTotal()),
                            "Sin ingredientes"
                        });
                    } else {
                        // Agregar cada ingrediente de la comida
                        for (Ingrediente ingrediente : ingredientes) {
                            informacionPorDia.add(new String[]{
                                dieta.getNombreD(),
                                paciente.getNombre(),
                                paciente.getApellido(),
                                String.valueOf(menu.getDia()),
                                comida.getNombre(),
                                comida.getTipoDeComida(),
                                String.valueOf(comida.getCaloriasTotal()),
                                ingrediente.getNombre(),
                                String.valueOf(ingrediente.getCaloriasPor100gr())
                            });
                        }
                    }
                }
            }
        }

        return informacionPorDia;
    }

}
