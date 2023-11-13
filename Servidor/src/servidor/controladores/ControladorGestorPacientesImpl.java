
package servidor.controladores;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import servidor.DTO.SensoresDTO;
import servidor.DTO.UsuarioDTO;
import servidor.Repositorios.PacienteRepositoryInt;

public class ControladorGestorPacientesImpl 
        extends UnicastRemoteObject 
        implements ControladorGestorPacientesInt{
    
   private final PacienteRepositoryInt objRepositorio;
   private final ControladorGestorEquiposNotificacionImpl objRemotoGestionEquiposNotificacion;

    public ControladorGestorPacientesImpl(PacienteRepositoryInt objRepositorio,
                    ControladorGestorEquiposNotificacionImpl objRemotoGestionEquiposNotificacion) throws RemoteException {
        super();//llamando al constructor de la clase padre, 
        //asignando un puerto de escucha al objeto remoto
        this.objRepositorio=objRepositorio;
        this.objRemotoGestionEquiposNotificacion = objRemotoGestionEquiposNotificacion;
    }
  

    @Override
    public UsuarioDTO registrarPaciente(UsuarioDTO objPaciente) throws RemoteException {
       objRemotoGestionEquiposNotificacion.notificarEquiposSobreNuevoRegistroPaciente(objPaciente);
        return this.objRepositorio.registrarPaciente(objPaciente); 
    }
    
    @Override
    public boolean enviarLecturaSensores(SensoresDTO objSensoresDTO) throws RemoteException{
        return true;
    }

}
