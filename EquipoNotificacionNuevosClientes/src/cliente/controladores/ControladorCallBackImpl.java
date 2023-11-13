/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.controladores;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import servidor.DTO.SensoresDTO;
import servidor.DTO.UsuarioDTO;


/**
 *
 * @author IngSis
 */
public class ControladorCallBackImpl extends UnicastRemoteObject implements ControladorCallbackInt{
   public ControladorCallBackImpl() throws RemoteException{
       super();
   }
   
   @Override
   public void notificarRegistroUsuario(UsuarioDTO objUsuario) throws RemoteException{
       
        System.out.println("Un paciente nuevo se ha registrado\n");
        System.out.println("No habitacion: "+objUsuario.getNoHabitacion());
        System.out.println("Nombres: "+objUsuario.getNombres());
        System.out.println("Apellidos: "+objUsuario.getApellidos());  
        System.out.println("Edad: "+objUsuario.getEdad());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd-yyyy");
        Date fechaActual = Date.from(Instant.now());
        String fecha= simpleDateFormat.format(fechaActual);
        System.out.println("Fecha actual del registro: "+fecha);  
   }
   
   @Override
   public void notificarSensores(SensoresDTO objSensoresDTO) throws RemoteException{
        System.out.println("\nLecturas de sensores recibidas..\n");
        System.out.println("\nFrecuencia cardiaca: "+objSensoresDTO.getFrecuenciaCardiaca());
        System.out.println("\nFrecuencia respiratoria: "+objSensoresDTO.getFrecuenciaRespiratoria());
        System.out.println("\nPresión arterial: "+objSensoresDTO.getTensionArterialSistolica()+"/"+
                objSensoresDTO.getTensionArterialDiastolica());
        System.out.println("\nSaturación de oxígeno: "+objSensoresDTO.getSaturacionOxigeno());
        System.out.println("\nTempertatura: "+objSensoresDTO.getTemperatura());
   }
           
}
