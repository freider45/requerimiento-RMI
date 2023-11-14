
package servidor.DTO;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Notificacion implements Serializable{
    private LocalDateTime fechaHora;
    private String mensaje;
    private int puntuacion;
    private SensoresDTO objSensor;

    public Notificacion(LocalDateTime fechaHora, String mensaje, int puntuacion, SensoresDTO objSensor) {
        this.fechaHora = fechaHora;
        this.mensaje = mensaje;
        this.puntuacion = puntuacion;
        this.objSensor = objSensor;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public SensoresDTO getObjSensor() {
        return objSensor;
    }

    public void setObjSensor(SensoresDTO objSensor) {
        this.objSensor = objSensor;
    }
    
}
