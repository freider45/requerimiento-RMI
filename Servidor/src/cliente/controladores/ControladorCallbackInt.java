/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package cliente.controladores;
import java.rmi.Remote;
import java.rmi.RemoteException;
 import java.rmi.server.UnicastRemoteObject;
import servidor.DTO.SensoresDTO;
import servidor.DTO.UsuarioDTO;
/**
 *
 * @author IngSis
 */
public interface ControladorCallbackInt extends Remote{
    public void notificarRegistroUsuario(UsuarioDTO objUsuario) throws RemoteException;
    public void notificarSensores(SensoresDTO objSensores) throws RemoteException;
}