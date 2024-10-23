package Persistencia;

import Modelo.Conexion;
import Modelo.MenuDiario;
import Modelo.RenglonDeMenu;
import java.sql.*;
import java.util.ArrayList;
import org.mariadb.jdbc.Connection;
import javax.swing.JOptionPane;

public class MenuDiarioData {

    private Connection con = null;

    public MenuDiarioData() {
        con = (Connection) Conexion.getConexion();
    }

    public void insrtMenuDiario(MenuDiario md) {
        String sql = "INSERT INTO menudiario( dia, idRenglon, caloriasDelMenu) VALUES (?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ArrayList<RenglonDeMenu> list = md.getComidas();
            for (RenglonDeMenu renglon : list) {
                ps.setInt(1, md.getDia());
                ps.setInt(2, renglon.getIdRenglon());
                ps.setInt(3, md.getCaloriasDelMenu());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }
    }
    public void actualizarMenuDiario(MenuDiario md){
        String sql = "UPDATE  menudiario  SET  dia = ? , idRenglon = ?, caloriasDelMenu = ? WHERE estado=1 AND idMenu=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ArrayList<RenglonDeMenu> list = md.getComidas();
            for (RenglonDeMenu renglon : list) {
                ps.setInt(1, md.getDia());
                ps.setInt(2, renglon.getIdRenglon());
                ps.setInt(3, md.getCaloriasDelMenu());
                ps.setInt(4, md.getIdMenu());
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }
    }
    public void buscarMenuDiario (int idMenu){
        String sql ="SELECT m.idMenu, m.dia, m.caloriasDelMenu, m.estado, r.idRenglon, r.idAlimento, r.cantidadGrs, r.subtotalCalorias " +
                       "FROM menudiario m JOIN renglondemenu r ON m.idRenglon = r.idRenglon WHERE idMenu = ?";
        MenuDiario menuDieta = null;
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMenu);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                menuDieta = new MenuDiario();
                menuDieta.setIdMenu(rs.getInt("m.idMenu"));
                menuDieta.setDia(rs.getInt("m.dia"));
                menuDieta.getComidas().add(rs.getInt("r.idRenglon"), rs.getInt("r.idAlimento"));
                
            }
                
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla MenuDiario");
        }
    }

}