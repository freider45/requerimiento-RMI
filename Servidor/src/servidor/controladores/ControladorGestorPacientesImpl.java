
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
    public boolean enviarLecturaSensores(SensoresDTO objSensoresDTO) throws RemoteException{
        System.out.println("\nLecturas de sensores recibidas..\n");
        System.out.println("\nFrecuencia cardiaca: "+objSensoresDTO.getFrecuenciaCardiaca());
        System.out.println("\nFrecuencia respiratoria: "+objSensoresDTO.getFrecuenciaRespiratoria());
        System.out.println("\nPresión arterial: "+objSensoresDTO.getTensionArterialSistolica()+"/"+
                objSensoresDTO.getTensionArterialDiastolica());
        System.out.println("\nSaturación de oxígeno: "+objSensoresDTO.getSaturacionOxigeno());
        System.out.println("\nTempertatura: "+objSensoresDTO.getTemperatura());
        return true;
    }

}
