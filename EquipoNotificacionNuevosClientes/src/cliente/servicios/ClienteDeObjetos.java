/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cliente.servicios;
import cliente.controladores.ControladorCallBackImpl;
import java.rmi.RemoteException;
import cliente.utilidades.UtilidadesRegistroC;
import servidor.controladores.ControladorGestorEquiposNotificacionInt;
/**
 *
 * @author IngSis
 */
public class ClienteDeObjetos {

    /**
     * @param args the command line arguments
     * @throws java.rmi.RemoteException
     */
    public static void main(String[] args) throws RemoteException {
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";        

        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
        direccionIpRMIRegistry = cliente.utilidades.UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = cliente.utilidades.UtilidadesConsola.leerEntero(); 

        ControladorCallBackImpl objRemoto= new ControladorCallBackImpl();
        ControladorGestorEquiposNotificacionInt objRemotoServidor=
                (ControladorGestorEquiposNotificacionInt)
                UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry, "idGestorEquipo");
        objRemotoServidor.registrarReferenciaRemota(objRemoto);
        System.out.println("Esperando notificaciones");
    }
    
}
