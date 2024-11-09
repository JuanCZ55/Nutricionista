package Persistencia;

import Modelo.Comidas;
import Modelo.Conexion;
import Modelo.Dieta;
import Modelo.MenuDiario;
import Modelo.Paciente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Connection;

public class DietaData {

    private Connection con = null;
    private MenuDiarioData menudiario;
    private ComidaData comidaData;

    public DietaData() {
        this.menudiario = new MenuDiarioData();
        this.comidaData = new ComidaData();
        con = (Connection) Conexion.getConexion();
    }
    public int insertarDietaGeneraID(Dieta dieta) {  
    String sql = "INSERT INTO dieta (NombreDieta, FechaInicial, FechaFinal, TotalCalorias, IdPaciente, Estado) VALUES (?, ?, ?, ?, ?, ?)";  
    int idGenerado = -1;  

    try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {  
        ps.setString(1, dieta.getNombreD());  
        ps.setDate(2, java.sql.Date.valueOf(dieta.getFechaIni()));  
        ps.setDate(3, java.sql.Date.valueOf(dieta.getFechaFin()));   
        ps.setDouble(4, dieta.getTotalCalorias());  
        ps.setInt(5, dieta.getPaciente().getIdPaciente());  
        ps.setBoolean(6, dieta.isEstado());  

        int updatedRows = ps.executeUpdate();  
        if (updatedRows == 1) {  
            // Obtener el ID generado  
            ResultSet rs = ps.getGeneratedKeys();  
            if (rs.next()) {  
                idGenerado = rs.getInt(1); 
                dieta.setIdDieta(idGenerado); 
            }  
            JOptionPane.showMessageDialog(null, "Dieta insertada correctamente.");  
        } else {  
            JOptionPane.showMessageDialog(null, "Dieta no insertada.");  
        }  
    } catch (SQLException ex) {  
        JOptionPane.showMessageDialog(null, "Error al insertar dieta: " + ex.getMessage());  
    }  
    return idGenerado; // Retorna el ID de la dieta  
}
    public void insertarDieta(Dieta dieta) {
    String sql = "INSERT INTO dieta (NombreDieta, FechaInicial, FechaFinal, TotalCalorias, IdPaciente, Estado) VALUES (?, ?, ?, ?, ?, ?)";

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, dieta.getNombreD());
        ps.setDate(2, java.sql.Date.valueOf(dieta.getFechaIni()));  
        ps.setDate(3, java.sql.Date.valueOf(dieta.getFechaFin())); 
        ps.setDouble(4, dieta.getTotalCalorias());
        ps.setInt(5, dieta.getPaciente().getIdPaciente()); // Aquí asocias el paciente
        ps.setBoolean(6, dieta.isEstado());
        int updatedRows = ps.executeUpdate();  
            if (updatedRows == 1) {  
                JOptionPane.showMessageDialog(null, "Dieta Modificada Exitosamente");  
            } else {  
                JOptionPane.showMessageDialog(null, "Dieta no encontrada");  
            }  
            ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al insertar dieta: " + ex.getMessage());
    }
}   
    public List<Dieta> listarDietasPorPaciente(int idPaciente) {
    List<Dieta> dietas = new ArrayList<>();
    String sql = "SELECT * FROM dieta WHERE IdPaciente = ?";

    try (PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idPaciente);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Dieta dieta = new Dieta();
            dieta.setIdDieta(rs.getInt("IdDieta"));
            dieta.setNombreD(rs.getString("NombreDieta"));
            dieta.setFechaIni(rs.getDate("FechaInicial").toLocalDate());
            dieta.setFechaFin(rs.getDate("FechaFinal").toLocalDate());
            dieta.setTotalCalorias(rs.getDouble("TotalCalorias"));
            dieta.setEstado(rs.getBoolean("Estado"));

            // Asocia el paciente a la dieta
            Paciente paciente = new Paciente();
            paciente.setIdPaciente(idPaciente); // Este es el paciente asociado
            dieta.setPaciente(paciente);

            dietas.add(dieta);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al listar dietas: " + ex.getMessage());
    }

    return dietas;
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
                List<MenuDiario> menusDiarios = menuData.listarMenuDiarioPorPacientse(idPaciente);  
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
  
    public List<Dieta> obtenerTodasLasDietas() {
    List<Dieta> listaDietas = new ArrayList<>();
    String preguntaDieta = "SELECT * FROM dieta";  

    try (PreparedStatement obtDieta = con.prepareStatement(preguntaDieta);
         ResultSet rsDieta = obtDieta.executeQuery()) {

        while (rsDieta.next()) {  
            Dieta dieta = new Dieta();  
            dieta.setIdDieta(rsDieta.getInt("IdDieta"));  
            dieta.setNombreD(rsDieta.getString("NombreDieta"));  
            dieta.setFechaIni(rsDieta.getDate("FechaInicial").toLocalDate());  
            dieta.setFechaFin(rsDieta.getDate("FechaFinal").toLocalDate());  
            dieta.setTotalCalorias(rsDieta.getDouble("TotalCalorias"));  
            
             // Obtener el idPaciente de la dieta actual
            int idPaciente = rsDieta.getInt("idPaciente");
            
            // Obtener el paciente asociado usando su ID
            PacienteData pacienteData = new PacienteData(); 
            Paciente paciente = pacienteData.buscarPaciente(idPaciente);
              if (paciente != null) {
                dieta.setPaciente(paciente);  // Asocio el paciente a la dieta
            } else {
                JOptionPane.showMessageDialog(null, "Paciente no encontrado para el idPaciente: " + idPaciente);
            }
            // Obtener los menús diarios para esta dieta  
            MenuDiarioData menuData = new MenuDiarioData();  
            List<MenuDiario> menusDiarios = menuData.listarMenuDiarioPorDietaObtenerComidas(dieta.getIdDieta());
            

            // Para cada menú, obtener las comidas asociadas
            for (MenuDiario menu : menusDiarios) {
                ComidaData comidaData = new ComidaData();
                List<Comidas> comidas = comidaData.listarComidasPorMenuDiario(menu.getIdMenu());
                menu.setComidas((ArrayList<Comidas>) comidas);
            }

            dieta.setMenus((ArrayList<MenuDiario>) menusDiarios); // Asignemos los menús con las comidas a la dieta
            listaDietas.add(dieta);  
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener dietas: " + e.getMessage());
    
    }
    return listaDietas;
}
   public void generarMenusDeDieta(Dieta dieta) {
    // Calcular la cantidad de días de la dieta
    long diasDeDieta = ChronoUnit.DAYS.between(dieta.getFechaIni(), dieta.getFechaFin()) + 1; // 1 es para que Incluya el día de inicio

    // Obtener las calorías totales de la dieta 
    double caloriasTotales = menudiario.calcularCaloriasTotalesPorDieta(dieta.getIdDieta());
    // Inicializar la lista de menús de la dieta
    ArrayList<MenuDiario> menus = new ArrayList<>();

    LocalDate fechaActual = dieta.getFechaIni(); 
    // Recorremos todos los días de la dieta
    for (long i = 0; i < diasDeDieta; i++) {
        // Crear un MenuDiario para cada día
        MenuDiario menu = new MenuDiario();
        menu.setDia(fechaActual.getDayOfMonth());
        menu.setIdDieta(dieta.getIdDieta());
        menu.setCaloriasDelMenu(caloriasTotales); // Usamos las calorías totales para todo el período
        menu.setEstado(dieta.isEstado()); // El estado de la dieta se propaga al menú diario

        // Insertar el MenuDiario en la base de datos y obtener su id
        int idMenuGenerado = menudiario.insertMenuDiarioObtenerID(menu);

        // Asignar el id generado al objeto MenuDiario
        menu.setIdMenu(idMenuGenerado);

        // Obtener las comidas para este día
        ArrayList<Comidas> comidasDelDia = (ArrayList<Comidas>) comidaData.listarComidasPorMenuDiario(menu.getIdMenu()); // Usamos el idMenu generado
        menu.setComidas(comidasDelDia);
        // Insertar las comidas en la base de datos
        for (Comidas comida : comidasDelDia) {
            menudiario.insertMenuComidas(menu.getIdMenu(), comida.getIdComida());
        }
        menus.add(menu);
        //obtener el menu para el siguiente dia
        fechaActual = fechaActual.plusDays(1);
    }
        dieta.setMenus(menus);  

    
}

}
