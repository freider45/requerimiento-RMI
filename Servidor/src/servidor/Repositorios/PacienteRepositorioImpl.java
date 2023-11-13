
package servidor.Repositorios;

import java.util.LinkedList;
import java.util.List;
import servidor.DTO.UsuarioDTO;

public class PacienteRepositorioImpl implements PacienteRepositoryInt {

    private LinkedList<UsuarioDTO> pacientes;
    
    public PacienteRepositorioImpl(){
        pacientes=new LinkedList();
    }
    @Override
    public UsuarioDTO registrarPaciente(UsuarioDTO objPaciente) {
        this.pacientes.add(objPaciente);
        return objPaciente;
    }

    @Override
    public int consultarCantidadPacientes() {
        return this.pacientes.size(); 
    }

    @Override
    public UsuarioDTO consultarPaciente(int noHabitacion) {
        UsuarioDTO objRespuesta=null;
        for(UsuarioDTO paciente :pacientes){
            if(paciente.getNoHabitacion() == noHabitacion){
                objRespuesta=paciente;
                break;
            }
        }
        return objRespuesta;
    }

    @Override
    public List<UsuarioDTO> listarPacientes() {
        return this.pacientes;
    }
    
}
