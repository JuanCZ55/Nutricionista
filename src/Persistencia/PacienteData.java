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
    /**
     * guardarPaciente(Paciente paciente): Inserta un nuevo paciente en la base
     * de datos.
     *
     * Agrega un nuevo registro con los datos del paciente, y si la inserción es
     * exitosa, asigna el ID generado al objeto Paciente. Muestra un mensaje de
     * éxito o error según el resultado de la operación.
     *
     * @param paciente - Objeto Paciente con los datos a guardar.
     */
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
            }
            //
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Paciente");
        }
    }

//Actualiza el nombre, edad, altura, condicion de salud de un paciente
    /**
     * actualizarPaciente(Paciente pac): Actualiza los datos de un paciente en
     * la base de datos.
     *
     * Modifica el nombre, edad, altura y condición de salud del paciente con el
     * ID especificado. Muestra un mensaje de éxito o error según el resultado
     * de la operación.
     *
     * @param pac - Objeto Paciente con los nuevos datos.
     */
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

    /**
     * bajaLogica(int id): Deshabilita a un paciente en la base de datos.
     *
     * Actualiza el estado del paciente con el ID especificado a deshabilitado.
     * Muestra un mensaje de éxito o error según el resultado de la operación.
     *
     * @param id - ID del paciente a deshabilitar.
     */
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

    /**
     * altaLogica(int id): Habilita a un paciente en la base de datos.
     *
     * Actualiza el estado del paciente con el ID especificado a habilitado.
     * Muestra un mensaje de éxito o error según el resultado de la operación.
     *
     * @param id ID del paciente a habilitar.
     */
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

    /**
     * cambiarPesoBuscado(int id, double pesoBuscado): Cambia el peso buscado de
     * un paciente. Actualiza el peso buscado en la base de datos para el
     * paciente con el ID especificado. Muestra un mensaje de éxito o error
     * según el resultado de la operación.
     *
     * @param id - ID del paciente a actualizar.
     * @param pesoBuscado - Nuevo peso buscado del paciente.
     */
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

    /**
     * actualizarPesoActual(int id, double pesoAct): Actualiza el peso actual de
     * un paciente. Modifica el peso actual en la base de datos para el paciente
     * con el ID especificado. Muestra un mensaje de éxito o error según el
     * resultado de la operación.
     *
     *
     * @param id ID del paciente a actualizar.
     * @param pesoAct Nuevo peso actual del paciente.
     */
    public void actualizarPesoActual(int id, double pesoAct) {
        String sql = "UPDATE  paciente  SET  pesoActual =? WHERE  IdPaciente=?;";
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
    /**
     * seAcercaAlPaso(int id): Verifica si un paciente está cerca de alcanzar su
     * peso buscado. Realiza la consulta de sql y verifica si busca bajar o
     * subir de peso y luego si acerca al peso devuelve true sino false
     *
     * @param id ID del paciente a verificar
     * @return boolean true si se acerca al peso sino false
     */
    public boolean seAcercaAlPeso(int id) {
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

    /**
     * buscarPaciente(int id): Busca un paciente utilizando su ID.
     *
     * Realiza la consulta en la base de datos. Si se encuentra el paciente,
     * devuelve un Paciente sino se muestra el mensaje que "No existe ese
     * Alumno".
     *
     * @param id ID del paciente a buscar
     * @return Paciente El paciente encontrado o null si no existe.
     */
    public Paciente buscarPaciente(int id) {
        String sql = "SELECT * FROM  paciente WHERE IdPaciente=?;";
        Paciente pac = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pac = new Paciente();
                pac.setIdPaciente(rs.getInt("IdPaciente"));
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
            JOptionPane.showMessageDialog(null, "Error al buscar paciente" + ex.getMessage());
        }
        return pac;
    }

//Lista todos los pacientes
    /**
     * listarPacientes(): Obtiene la lista de todos los paciente registrados en
     * BD Realiza la consulta de la tabla paciente y guarda todos los resultados
     * dentro un ArrayList<Paciente>. Si no se encuentra muestra un mensaje
     * indicado que no hay pacientes registrados
     *
     * @return ArrayList<Paciente> Lista de todos los pacientes registrados.
     */
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
                paciente.setIdPaciente(rs.getInt("IdPaciente"));
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
                paciente.setIdPaciente(rs.getInt("IdPaciente"));
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
                JOptionPane.showMessageDialog(null, "Ningun paciente llego al peso buscado");
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pacientes");
        }
        return lista;
    }

    /**
     * listarLosQueNoLLegaron(): Se obtiene una lista de pacientes que no han
     * alcanzado el peso buscado. Realiza la consulta de cuando el peso actual
     * es distinto al buscado crea un ArrayList<Paciente> y guarda los que
     * devuelve la consulta
     *
     * @return ArrayList<Paciente> Lista de pacientes que no han alcanzado el
     * peso buscado
     */
    public ArrayList<Paciente> listarLosQueNoLLegaron() {
        String sql = "SELECT * FROM paciente WHERE PesoActual<>PesoBuscado";
        int x = 0;
        Paciente paciente = null;
        ArrayList<Paciente> lista = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("IdPaciente"));
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
                JOptionPane.showMessageDialog(null, "Todos los pacientes llegaron al peso buscado");
            }

            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pacientes");
        }
        return lista;
    }

    /**
     * listarLosQueLLegaron2(): Revisa y compara los pesos de los pacientes que
     * llegaron y hasta superaron su meta, considera si el paciente debe subir o
     * bajar de peso, se toma en cuenta su peso buscado con el inicial asi
     * determina si desea subir o bajar, y si su peso actual llega o supera su
     * meta lo guarda en el ArrayList llamada "llegaron"
     *
     * @return ArrayList<Paciente> Devuelve un ArrayList de Paciente
     */
    public ArrayList<Paciente> listarLosQueLLegaron2() {
        ArrayList<Paciente> lista = listarPacientes();
        ArrayList<Paciente> llegaron = new ArrayList<>();
        try {
            for (Paciente pac : lista) {
                if (pac != null) {
                    // Perder peso
                    if (pac.getPesoInicial() > pac.getPesoBuscado()) {
                        if (pac.getPesoActual() < pac.getPesoInicial() && pac.getPesoActual() <= pac.getPesoBuscado()) {
                            llegaron.add(pac);
                        }
                    } // Ganar peso
                    else if (pac.getPesoInicial() < pac.getPesoBuscado()) {
                        if (pac.getPesoActual() > pac.getPesoInicial() && pac.getPesoActual() >= pac.getPesoBuscado()) {
                            llegaron.add(pac);
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar los que llegaron");

        }

        return llegaron;
    }

    public ArrayList<Paciente> listarLosNoQueLLegaron2() {
        ArrayList<Paciente> lista = listarPacientes();
        ArrayList<Paciente> nollegaron = new ArrayList<>();
        try {
            for (Paciente pac : lista) {
                if (pac != null) {
                    // Perder peso
                    if (pac.getPesoInicial() > pac.getPesoBuscado()) {
                        if (pac.getPesoActual() > pac.getPesoBuscado()) {
                            nollegaron.add(pac);
                        }
                    } // Ganar peso
                    else if (pac.getPesoInicial() < pac.getPesoBuscado()) {
                        if (pac.getPesoActual() < pac.getPesoBuscado()) {
                            nollegaron.add(pac);
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al listar los que llegaron");
        }
        return nollegaron;
    }

    /**
     * cuantoPesoFalta(double pesoActual, double pesoBuscado): Calcula la
     * diferencia de peso entre el peso actual y el peso buscado, usando
     * Math.abs para evitar valores negativos. Devuelve la cantidad de peso que
     * falta para alcanzar el peso buscado, sin importar si el paciente necesita
     * subir o bajar de peso.
     *
     * @param pesoActual - Double que representa el peso actual del paciente
     * @param pesoBuscado - Double que representa el peso objetivo del paciente
     * @return Double - la cantidad de peso que le falta para alcanzar el peso
     * buscado
     */
    public String cuantoPesoFalta(Paciente pac) {
        double pesoInicial = pac.getPesoInicial();
        double pesoActual = pac.getPesoActual();
        double pesoBuscado = pac.getPesoBuscado();
        double peso = pesoBuscado - pesoActual;
        String sms = "";
        if (peso == 0) {
            sms = "Llego a su peso buscado, felicitaciones";
            return sms;
        }
        // Perder peso
        if (pesoInicial > pesoBuscado) {
            if (peso > 0) {
                sms = "Supero su meta por " + Math.abs(peso) + " kg";
            } else if (peso < 0) {
                sms = "Te falta perder " + Math.abs(peso) + " kg para llegar a tu peso buscado";

            }
        } // Ganar peso
        else if (pesoInicial < pesoBuscado) {
            if (peso > 0) {
                sms = "Te falta ganar " + Math.abs(peso) + " kg para llegar a tu peso buscado";
            } else if (peso < 0) {
                sms = "Supero su meta por " + Math.abs(peso) + " kg";

            }
        }

        return sms;
    }

    public double imc(double peso, double altura) {
        double imc = peso / (altura * altura);
        return imc;
    }
//---------------------------------------------------------------------------------------------------------------

    /**
     * convertirStringSet(String cond): Convierte una cadena en un conjunto de
     * cadenas.
     *
     * Separa una cadena por comas y agrega cada elemento a un HashSet,
     * eliminando espacios en blanco. Retorna un HashSet vacío si la cadena es
     * nula o vacía.
     *
     * @param cond - Cadena a convertir en un conjunto.
     * @return HashSet<String> - Conjunto de cadenas resultante.
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

    /**
     * convertirSetString(HashSet<String> list): Convierte un conjunto de
     * cadenas en una sola cadena.
     *
     * Une los elementos de un HashSet en una cadena, separados por comas.
     * Retorna una cadena vacía si el conjunto es nulo o está vacío.
     *
     * @param list - Conjunto de cadenas a convertir.
     * @return String - Cadena resultante de la conversión.
     */
    public String convertirSetString(HashSet<String> list) {
        if (list == null || list.isEmpty()) {
            return "";
        }
        return String.join(",", list);
    }
}
