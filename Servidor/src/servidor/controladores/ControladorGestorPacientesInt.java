

package servidor.controladores;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import servidor.DTO.SensoresDTO;
import servidor.DTO.UsuarioDTO;



//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface ControladorGestorPacientesInt extends Remote
{
    //Definicion del segundo método remoto
    public boolean recibirLecturaSensores(SensoresDTO objSensores) throws RemoteException;
    //cada definición del método debe especificar que puede lanzar la excepción java.rmi.RemoteException  
}


