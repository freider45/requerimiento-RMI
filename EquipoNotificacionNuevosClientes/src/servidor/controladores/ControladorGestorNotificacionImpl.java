
package servidor.controladores;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import servidor.DTO.Notificacion;

public class ControladorGestorNotificacionImpl extends 
        UnicastRemoteObject implements ControladorGestorNotificacionInt{

    public ControladorGestorNotificacionImpl() throws RemoteException {
        super();
    }
    
    @Override
    public boolean enviarNotificacion(Notificacion notificacion) throws RemoteException {
        System.out.println("\n\n\n\n\t\t         ALERTA GENERADA \n");
        System.out.printf("  No de habitación: \n"+ notificacion.getObjSensor().getPaciente().getNoHabitacion());
        System.out.printf("  Nombres y apellidos: \n"+notificacion.getObjSensor().getPaciente().getNombres(),
                notificacion.getObjSensor().getPaciente().getApellidos());
        System.out.printf("  Edad: años\n"+notificacion.getObjSensor().getPaciente().getEdad());
        System.out.printf("  Hora de la alerta: \n"+ notificacion.getFechaHora());
        System.out.printf("  Fecha de la alerta: "+notificacion.getFechaHora().getDayOfWeek()+"/"
                + notificacion.getFechaHora().getMonth()+"/"+notificacion.getFechaHora().getYear());
        System.out.println("\n\t\tIndicadores que generaron la alerta\n");
        //TODO
        System.out.printf("\n\t", notificacion.getMensaje()+"\n");
        return true;
    }

}
