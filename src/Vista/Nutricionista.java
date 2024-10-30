package Vista;

import Modelo.Conexion;
import Modelo.Dieta;
import Modelo.Paciente;
import Persistencia.PacienteData;
import java.time.LocalDate;
import java.util.Scanner;

public class Nutricionista {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        Paciente paciente = new Paciente("Ariel", 21, 1.54, 65, 70.3);
        Paciente paciente1 = new Paciente("Kevin", 26, 1.72, 73, 89);
        Paciente paciente2 = new Paciente("Raul", 2, 0.45, 8, 6.5);
        Paciente paciente3 = new Paciente("Juan", 25, 1.80, 72, 85.3);
        PacienteData pacienteData = new PacienteData();
/*        
        //--------------------------------------------------------------
        System.out.println("Cargar Paciente");
        pacienteData.guardarPaciente(paciente);
        pacienteData.guardarPaciente(paciente1);
        pacienteData.guardarPaciente(paciente2);
        pacienteData.guardarPaciente(paciente3);
*/        
       
        //--------------------------------------------------------------
        System.out.println("<----------------------------------------->");
        System.out.println("Actualizar Paciente");
        pacienteData.actualizarPaciente(new Paciente(2, "Raul", 3, 0.5, 8, 6.5, true));
        
        
        //--------------------------------------------------------------
        System.out.println("<----------------------------------------->");
        System.out.println("Buscar Paciente por id");
        System.out.println(pacienteData.buscarPaciente(4).toString());
        
        
        //--------------------------------------------------------------
        System.out.println("<----------------------------------------->");
        System.out.println("Baja logica de paciente por id");
        pacienteData.bajaLogica(1);
        
        
        //--------------------------------------------------------------
        System.out.println("<----------------------------------------->");
        System.out.println("Alta logica de paciente por id");
        pacienteData.altaLogica(1);
        
        
        //--------------------------------------------------------------
        System.out.println("<----------------------------------------->");
        System.out.println("Cambiar el peso buscado del Paciente");
        //Id    Peso buscado
        pacienteData.cambiarPesoBuscado(2, 150.6);
        
        
        //--------------------------------------------------------------
        System.out.println("<----------------------------------------->");
        System.out.println("Actualizar el peso actual del paciente");
         //Id    Peso actual
        pacienteData.actualizarPesoAct(1, 900.0);
        
        /* 
        //--------------------------------------------------------------
        System.out.println("<----------------------------------------->");
        System.out.println("Se acerca al peso buscado");
        //Dieta      id 
        pacienteData.seAcercaAlPeso(new Dieta("Dietobich", null, null, null, 65.8, 90, 4500, paciente), 3);
        
        */
        //--------------------------------------------------------------
        System.out.println("<----------------------------------------->");
        System.out.println("Listado de pacientes");
        for (Paciente aux : pacienteData.listarPacientes()){
            System.out.println(aux.toString()+ "\n");
        }
        
        //--------------------------------------------------------------
        System.out.println("<----------------------------------------->");
        System.out.println("Listado de pacientes");
        for (Paciente aux : pacienteData.listarLosQueLLegaron()){
            System.out.println(aux.toString()+ "\n");
        }
    }
    
}
