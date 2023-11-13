
package servidor.controladores;

import cliente.controladores.ControladorCallbackInt;
import java.rmi.Remote;
import java.rmi.RemoteException;

//Hereda de la clase Remote, lo cual le convierte en interfaz remota
public interface ControladorGestorEquiposNotificacionInt extends Remote{
    public boolean registrarReferenciaRemota(ControladorCallbackInt referencia) throws RemoteException;
}
