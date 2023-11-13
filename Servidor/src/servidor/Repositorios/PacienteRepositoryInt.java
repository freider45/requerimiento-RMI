
package servidor.Repositorios;

import java.util.List;
import servidor.DTO.UsuarioDTO;

public interface PacienteRepositoryInt
{    
    public UsuarioDTO registrarPaciente(UsuarioDTO objProducto);
    public int consultarCantidadPacientes();
    public UsuarioDTO consultarPaciente(int noHabitacion);
    public List<UsuarioDTO> listarPacientes();
}


