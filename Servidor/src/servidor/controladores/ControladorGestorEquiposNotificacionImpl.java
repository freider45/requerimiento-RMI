
package servidor.controladores;

import cliente.controladores.ControladorCallbackInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import servidor.DTO.UsuarioDTO;

public class ControladorGestorEquiposNotificacionImpl extends UnicastRemoteObject implements ControladorGestorEquiposNotificacionInt{
    
    //La clase UnicastR.. asigna un puerto al objRemoto
    private final LinkedList<ControladorCallbackInt> listaReferencia;
    public ControladorGestorEquiposNotificacionImpl() throws RemoteException{
        super();
        this.listaReferencia = new LinkedList();
    }
    
    @Override
    public boolean registrarReferenciaRemota(ControladorCallbackInt referencia) throws RemoteException {
        return this.listaReferencia.add(referencia);
    }
    
    public void notificarEquiposSobreNuevoRegistroPaciente(UsuarioDTO objPaciente){
        //Aqui se realiza el callback, el servidor invoca un metodo remoto del cliente para notificar un registro
        this.listaReferencia.forEach(
                obj->{
            try {
                obj.notificarRegistroUsuario(objPaciente);
            }catch (RemoteException ex){
                System.out.println("Erro al notificar al administrador");
            }   
        }
        );
    }
}
