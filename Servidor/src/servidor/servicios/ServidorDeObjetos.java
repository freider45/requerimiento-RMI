
package servidor.servicios;


import java.rmi.Remote;
import servidor.utilidades.UtilidadesRegistroS;
import servidor.utilidades.UtilidadesConsola;
import java.rmi.RemoteException;
import servidor.Repositorios.PacienteRepositorioImpl;
import servidor.controladores.ControladorGestorEquiposNotificacionImpl;
import servidor.controladores.ControladorGestorPacientesImpl;

public class ServidorDeObjetos
{
    public static void main(String args[]) throws RemoteException
    {        
         
        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";
                       
        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiRegistry ");
        direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiRegistry ");
        numPuertoRMIRegistry = UtilidadesConsola.leerEntero(); 
     
        //Crear el repositorio
        PacienteRepositorioImpl objPacienteRepositoryImpl=new PacienteRepositorioImpl();
        ControladorGestorEquiposNotificacionImpl objControladorGestorEquipos = new ControladorGestorEquiposNotificacionImpl();
        //Crear el objeto remoto
        ControladorGestorPacientesImpl objRemoto= new ControladorGestorPacientesImpl(objPacienteRepositoryImpl,objControladorGestorEquipos);
        try
        {
            //se lanza el ns si no existe
           UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
           UtilidadesRegistroS.RegistrarObjetoRemoto((Remote) objRemoto, direccionIpRMIRegistry, numPuertoRMIRegistry, "idGestorPacientes");            
           UtilidadesRegistroS.RegistrarObjetoRemoto((Remote) objControladorGestorEquipos, direccionIpRMIRegistry, numPuertoRMIRegistry, "idGestorEquipo");
        } catch (Exception e)
        {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" +  e.getMessage());
        }
    }

}
