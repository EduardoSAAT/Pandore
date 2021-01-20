/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time;
import Algoritms.Cad;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import time.*;

/**
 *
 * @author Ing Lalux
 */
public class Cronometro extends Thread{
    
    public double TimeTranscurrido=0;
    public double FrequencyRefresh=0;
    public boolean Activo=false;
    public time.Reloj Reloj = new time.Reloj();
    
    /**
     * Descripcion: Construir el Cronometro calibrando la Frecuencia de Actualizacion
     *
     * @param	FrequencyRefresh Frecuencia de Actualizacion de Cronometro en MILISEGUNDOS
     */
    public Cronometro(double FrequencyRefresh)
    {
        this.FrequencyRefresh=FrequencyRefresh;
    }
    
    
    @Override
    public void run(){
        this.Reloj.RelojStart(0, "milisegundos");
        this.Activo=true;
        while(this.Activo==true){
            try {
                Cronometro.sleep((long) this.FrequencyRefresh);
            } catch (Exception ex) {
            }
            this.TimeTranscurrido=this.Reloj.RelojVer("milisegundos");
        }
    }
    
    
    /**
     * Descripcion: Detener el cronometro y Reiniciar el valor de TiempoTranscurrido
     *
     */
    public void CronometroStop(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            //Llamada a Sleep para que no crashee la funcion//
                try {
                    sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Cad.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            //Hacer las acciones propias de esta funcion
            this.Activo=false;
            this.TimeTranscurrido=0;
        }else{
            System.out.println("ERROR en CronometroStop, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
}
