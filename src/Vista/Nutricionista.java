package Vista;

import Modelo.Conexion;
import Modelo.Paciente;
import Persistencia.PacienteData;

public class Nutricionista {

    public static void main(String[] args) {
        
        Conexion.getConexion();
       
        Paciente pac = new Paciente("Janito", 49999999, "En el cielo", 549549, true);
        PacienteData pacDate = new PacienteData();
        
        //pacDate.guardarPaciente(pac);
        pacDate.actualizarPaciente(pac);
    }
    
}
