/*
 * Esta es una clase especializada en la ejecucion de comandos en la consola desde java
 *
 * La ejecucion de comandos en la consola depende de la plataforma en la que estemos trabajando(Linux,Windows MacOS, etc)
 *
 */
package Algoritms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ing Lalux
 */
public class ConsoleCommands {
    public static String plataformasSupported="LINUX,WINDOWS,BLUEJ,MAC";
    public static String plataformaActual=getNameSO();
            
            
    
    /**
     * Descripcion: Crear una clase para la ejecucion de comandos en consola desde java
     *              especificando en que plataforma se esta trabajando
     * 
     * @param	plataforma Sistema Operativo donde se esta ejecutando este codigo en java
     */
    public ConsoleCommands(String plataforma){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(Cad.numOfContains(plataformasSupported, plataforma,true)<=0){
        condiciones=false;
        motivo="Plataforma: "+plataforma+" no soportada";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            plataformaActual=plataforma;
	}else{
            System.out.println("ERROR en Constructor: ConsoleCommands, motivo: "+motivo);
	}
    }
    
    
    
    /**
     * Descripcion: Crear una clase para la ejecucion de comandos en consola desde java
     *              sin especificar en que plataforma se esta trabajando
     *
     */
    public ConsoleCommands(){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        
        String SO= getNameSO();
    //Comprobar Condiciones Iniciales//
    if(Cad.numOfContains(plataformasSupported, SO,true)<=0){
        condiciones=false;
        motivo="Plataforma: "+SO+" no soportada";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            plataformaActual=SO;
	}else{
            System.out.println("ERROR en Constructor: ConsoleCommands, motivo: "+motivo);
	}
    }
    
    
    
    /**
     * Descripcion: limpiar la pantalla de la consola completamente
     *
     */
    public static void ClearScreen(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            //Si estamos en una plataforma de windows
            if(Cad.LikeA(plataformaActual,"#WINDOWS#","#",true)){
                try {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } catch (IOException ex) {
                    System.out.println("ERROR Inesperado al limpiar la pantalla");
                } catch (InterruptedException ex) {
                    System.out.println("ERROR Inesperado al limpiar la pantalla");
                }
            }
            
            
            //Si estamos en Bluej
            if(Cad.LikeA(plataformaActual,"#BLUEJ#","#",true)){
                System.out.print('\u000C');
            }
            
            
            //Si estamos en Linux
            if(Cad.LikeA(plataformaActual,"#LINUX#","#",true)){
                try {
                    Runtime.getRuntime().exec("clear");
                } catch (IOException ex) {
                    System.out.println("ERROR Inesperado al limpiar la pantalla");
                }
            }
            
            
            //Si estamos en MAC
            if(Cad.LikeA(plataformaActual,"#MAC#","#",true)){
                try {
                    Runtime.getRuntime().exec("clear");
                } catch (IOException ex) {
                    System.out.println("ERROR Inesperado al limpiar la pantalla");
                }
            }
            
            
            //Si no sabemos donde estamos
            if(Cad.isNulloVacia(plataformaActual)){
                try {
                    Runtime.getRuntime().exec("clear");
                } catch (IOException ex) {
                    System.out.println("ERROR Inesperado al limpiar la pantalla");
                }
            }
            
        }else{
            System.out.println("ERROR en ClearScreen, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso ClearScreen Terminado");
    }
    
    
    
    
     /**
     * Descripcion: Obtener nombre del sistema operativo en que se esta trabajando
     *
     * @return	String
     */
    public static String getNameSO(){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            salida = System.getProperty("os.name");
	}else{
            System.out.println("ERROR en getNameSO, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Limpiar la linea actual de la consola
     *
     */
    public static void ClearLine (){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            //Si estamos en una plataforma de windows
            if(Cad.LikeA(plataformaActual,"#WINDOWS#","#",true)){
                System.out.print("\r");
            }
            
            
            //Si estamos en Linux
            if(Cad.LikeA(plataformaActual,"#LINUX#","#",true)){
                System.out.print("\33[2K");
            }
            
            
        }else{
            System.out.println("ERROR en ClearLine, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso identificador Terminado");
    }
    
    
    
     /**
     * Descripcion: Ejecutar un comando de shell en una nueva terminal invisible
     *              y pasar los mensajes a la terminal actual
     *
     * @param	command Comando a Ejecutar
     * @param   showResult Si mostrar el resultado o no
     * @return	valores de retorno
     */
    public static int EjecutarOther (String command, boolean showResult){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            try {
                //Si estamos en plataformas de Windows agregar esos caracteres
                if(plataformaActual.contains("Windows")){
                    command="cmd/c"+command;
                }
                
                Process p = Runtime.getRuntime().exec(command);
                salida = p.waitFor();
                
                if(showResult = true){
                    System.out.println("Process exit code: " + salida);
                    System.out.println("Result:");

                    BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    String line = "";
                    while ((line = reader.readLine()) != null) {
                        System.out.println(line);
                    }
                }
                
            } catch (IOException ex) {
                Logger.getLogger(ConsoleCommands.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(ConsoleCommands.class.getName()).log(Level.SEVERE, null, ex);
            }
	}else{
            System.out.println("ERROR en Ejecutar, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
     /**
     * Descripcion: Ejecutar un comando shell en la terminal actual
     *
     * @param	command Comando a Ejecutar
     */
    public static void EjecutarHere (String command){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            try {
                if(getNameSO().contains("Windows")){
                    new ProcessBuilder("cmd","/c",command).inheritIO().start().waitFor();
                }else{
                    new ProcessBuilder(command).inheritIO().start().waitFor();
                }
            } catch (IOException ex) {
                Logger.getLogger(ConsoleCommands.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(ConsoleCommands.class.getName()).log(Level.SEVERE, null, ex);
            }
	}else{
            System.out.println("ERROR en Ejecutar, motivo: "+motivo);
	}
    //Terminar Proceso//
    }
    
    
}
