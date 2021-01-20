/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphic.Loader;
import Algoritms.Cad;
import time.*;
/**
 *
 * @author Ing Lalux
 */
public class Motor {
    
    //ENGRANAJES del Motor//
    public boolean motorActivo=false;
    public int Avance=0;  //Porcentaje de avance 0-100%
    public Cronometro Cronometro = new Cronometro(1000); //Cronometro con Frecuencia a 1 segundo
    public double TimeRestante=0;
    public String Operacion="Operando..."; //Mensaje de Operacion Actual
    public int numOperations=0;  //Numero de Operaciones a Realizar
    public int actualOperation=0;  //Numero de Ultima Operacion Realizada
    

    //Variables de Apoyo//
    boolean switchTimeTranscurrido=false;
    boolean switchTimeRestante=false;
    boolean switchOperacion=false;
    boolean switchAvance=false;
    
    
    /**
     * Descripcion: Construir el Motor y con los Componentes Necesarios
     *
     * @param	NumOperations Numero de Operaciones a Realizar
     * @param   Componentes Componentes a Incluir en la Carga del Motor
     * "tiempoTranscurrido,tiempoRestante,Operacion,Avance"
     */
    public Motor(int NumOperations, String Componentes) {
        this.numOperations=NumOperations;
        Componentes=Componentes.toUpperCase();
        
        //Encender componentes Solicitados
        if(Cad.numOfContains(Componentes, "TIEMPOTRANSCURRIDO", true)>0){
            this.switchTimeTranscurrido=true;
        }
        
        if(Cad.numOfContains(Componentes, "TIEMPORESTANTE", true)>0){
            this.switchTimeTranscurrido=true;
            this.switchTimeRestante=true;
        }
        
        if(Cad.numOfContains(Componentes, "OPERACION", true)>0){
            this.switchOperacion=true;
        }
        
        if(Cad.numOfContains(Componentes, "AVANCE", true)>0){
            this.switchAvance=true;
        }
    }
    
    
    
    /**
     * Descripcion: Construir el Motor y con los Componentes Necesarios
     *
     * @param   Componentes Componentes a Incluir en la Carga del Motor
     * "tiempoTranscurrido,tiempoRestante,Operacion,Avance"
     */
    public Motor(String Componentes){
        Componentes=Componentes.toUpperCase();
        
        //Encender componentes Solicitados
        if(Cad.numOfContains(Componentes, "TIEMPOTRANSCURRIDO", true)>0){
            this.switchTimeTranscurrido=true;
        }
        
        if(Cad.numOfContains(Componentes, "TIEMPORESTANTE", true)>0){
            this.switchTimeTranscurrido=true;
            this.switchTimeRestante=true;
        }
        
        if(Cad.numOfContains(Componentes, "OPERACION", true)>0){
            this.switchOperacion=true;
        }
        
        if(Cad.numOfContains(Componentes, "AVANCE", true)>0){
            this.switchAvance=true;
        }
    }
    
    
    
    
    /**
     * Descripcion: Mueve al Motor Avanzando una Operacion
     *
     * @param	Operation Descripcion de Operacion a Realizar
     */
    public synchronized void Avanzar(String Operation){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            
            //Avanzar UNA Operacion//
            this.actualOperation=this.actualOperation+1;
            
            //Activar el MOTOR cuando se hace la primer Operacion Avanzar//
            if(this.actualOperation==1){
                this.motorActivo=true;
            }
            
            //Si esta Activado el Calculo de Porcentaje de Avance//
            if(this.switchAvance==true){
                this.Avance=calculaPorcentajeAvance();
            }
            
            //Si esta Activado el Mensaje de Operacion Actual
            if(this.switchOperacion==true){
                //Cuando se conoce la Operacion que se esta realizando
                if(Operation.equalsIgnoreCase("")==false){
                    this.Operacion=Operation;
                }
            }
            
            //Si esta Activado el calculo de TimeTranscurrido//
            if((this.switchTimeTranscurrido)&&(this.actualOperation==1)){
                this.Cronometro.start();
            }
            
            //Si esta Activado el calculo de TimeRestante//
            if(this.switchTimeRestante==true){
                this.TimeRestante=calcularTimeRestante();
            }
            
            //Detener Automaticamente el Motor cuando se acabaron las Operaciones//
            if(this.actualOperation==this.numOperations){
                Terminar();
            }
            
        }else{
            System.out.println("ERROR en Avanzar, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso Avanzar Terminado");
    }
    
    
    
    /**
     * Descripcion: Terminar ejecucion del Motor, Reinicia los valores de los engranajes y apaga los componenets
     *
     */
    public synchronized void Terminar(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            this.motorActivo=false;
            
            this.Cronometro.CronometroStop();
            this.Avance=0;
            this.TimeRestante=0;
            this.numOperations=0;
            this.actualOperation=0;
            
            this.switchTimeTranscurrido=false;
            this.switchTimeRestante=false;
            this.switchOperacion=false;
            this.switchAvance=false;
        }else{
            System.out.println("ERROR en Terminar, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
    
     /**
     * Descripcion: Calcular el tiempo Restante en General
     *
     * @return	tiempo en Milisegundos
     */
    private synchronized double calcularTimeRestante(){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        double salida=0;
    //Comprobar Condiciones Iniciales//
    if(this.switchTimeRestante==false){
        condiciones=false;
        motivo="TimeRestante no Activado";
    }
    if(this.numOperations==0){
        condiciones=false;
        motivo="numOperations no definido";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=((this.Cronometro.TimeTranscurrido/this.actualOperation)*(this.numOperations-this.actualOperation));
	}else{
            System.out.println("ERROR en calcularTimeRestante, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Calcular el Porcentaje de Avance en General
     *
     * @return	valores entre 0-100
     */
    private synchronized int calculaPorcentajeAvance(){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
        int porcentPorOperacion=0;
    //Comprobar Condiciones Iniciales//
    if(this.numOperations==0){
        condiciones=false;
        motivo="numOperation no definido";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            if(this.numOperations>0){
                porcentPorOperacion=(100/this.numOperations);
                salida=this.actualOperation*porcentPorOperacion;
            }
	}else{
            System.out.println("ERROR en calculaPorcentajeAvance, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Instrucciones para el uso de este Motor
     *
     */
    public static void Instrucciones(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            System.out.println("*********** Motor de Loaders  **************");
            System.out.println("Info: Este motor esta diseñado para realizar");
            System.out.println("      las operaciones de calculo necesarias");
            System.out.println("      en una Loader en general");
            System.out.println("");
            System.out.println("Para aumentar la Eficiencia de procesamiento");
            System.out.println("Se puede escoger que componentes Incluir en el Loader");
            System.out.println("Lista de Componentes:");
            System.out.println("   TIEMPOTRANSCURRIDO: Va contando el tiempo transcurrido");
            System.out.println("   TIEMPORESTANTE: Calcula el posible tiempo restante");
            System.out.println("   OPERACION: Indica la operacion Actual");
            System.out.println("   AVANCE: Calcula el porcentaje de Avance Total");
            System.out.println("");
            System.out.println("Se pueden construir 2 Tipos de Loader");
            System.out.println("   Motor(NumOperations,Componentes)");
            System.out.println("   Motor(Componentes)");
            System.out.println("Uno en el que se indica el numero de operaciones a Realizar");
            System.out.println("Y otro en el que se desconoce el numero de Operaciones a Realizar");
            System.out.println("Dependiendo la situacion se Elejira entre uno u Otro");
            System.out.println("********************************************");
        }else{
            System.out.println("ERROR en Instrucciones, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso Instrucciones Terminado con EXITO");
    	}else{
            System.out.println("Proceso Instrucciones Terminado con FALLO");
    	}
    }
    
    
}
