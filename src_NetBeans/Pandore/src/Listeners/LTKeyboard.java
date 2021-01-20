/*
 * Clase de Listener para Keyboard de Teclado
 * 
 * Modo de Uso:
 * 1.- Instanciar un objeto de esta clase, que sera el oyente = new LTKeyboard()
 * 2.- Poner a Ecuchar al Objeto  oyente.startListening
 *     Todo lo que se presione en el teclado se guardara en KeyPressed
 *     Todo lo que se presione y se libere se guardara en KeyReleased
 *     Estos son vectores que guardan el codigo de tecla presionada, no el ASCII
 * 3.- Para dejar de escuchar es con  oyente.stopListening
 */
package Listeners;

import Dinamic.VectorInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.*;
import org.jnativehook.keyboard.*;
import org.*;

/**
 *
 * @author Ing Lalux
 */
public class LTKeyboard implements NativeKeyListener{
    //Variables que almacenan lo que pasa en el teclado//
    public VectorInteger keyPressed;
    public VectorInteger KeyReleased;
    boolean estadoEscucha=false; //False no escucha, true escuchando
    
    
    /**
     * Descripcion: poner a Escuchar
     *
     */
    public void startListening(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
        try {
            GlobalScreen.unregisterNativeHook();
        } catch (NativeHookException ex) {
            Logger.getLogger(LTKeyboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales	
	//Comenzar Proceso//
        if(condiciones==true){
            keyPressed = new VectorInteger();
            KeyReleased = new VectorInteger();
            estadoEscucha=true;
            try {
                GlobalScreen.registerNativeHook();
            } catch (NativeHookException ex) {
                Logger.getLogger(LTKeyboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            GlobalScreen.addNativeKeyListener(this);
        }else{
            System.out.println("ERROR en startListening, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
    		System.out.println("Proceso startListening Terminado con EXITO");
    	}else{
    		System.out.println("Proceso startListening Terminado con FALLO");
    	}	
    }
    
    
    /**
     * Descripcion: Detener la Escucha del Teclado
     *
     */
    public void stopListening(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            estadoEscucha=false;
            try {
                GlobalScreen.unregisterNativeHook();
            } catch (NativeHookException ex) {
                Logger.getLogger(LTKeyboard.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("ERROR en stopListening, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso stopListening Terminado con EXITO");
    	}else{
            System.out.println("Proceso stopListening Terminado con FALLO");
    	}
    }
    
    
    
    /**
     * Descripcion: Obtener el ultimo valor de Tecla Presionada
     * 
     * @param error valor a entregar si algo sale mal
     * @return	error, o numero Entero
     */
    public int getLastVaulePressed (int error){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=error;
    //Comprobar Condiciones Iniciales//
    if(estadoEscucha==false){
        condiciones=false;
        motivo="Este Objeto no esta a la Escucha aun";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            if(keyPressed.Longitud()<=0){
                salida=error;
            }else{
                salida = keyPressed.getValue(keyPressed.Longitud()-1,error);
            }
	}else{
            System.out.println("ERROR en getLastVaulePressed, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Obtener el ultimo valor de Tecla Presionada
     *
     * @param error valor a entregar si algo sale mal
     * @return	error, o numero Entero
     */
    public char getLastVaulePressed (char error){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        char salida=error;
    //Comprobar Condiciones Iniciales//
    if(estadoEscucha==false){
        condiciones=false;
        motivo="Este Objeto no esta a la Escucha aun";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            if(keyPressed.Longitud()<=0){
                salida=error;
            }else{
                salida = (char)keyPressed.getValue(keyPressed.Longitud()-1,error);
            }
	}else{
            System.out.println("ERROR en getLastVaulePressed, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
    /**
     * Descripcion: Obtener el ultimo valor de Tecla Liberada
     *
     * @param error valor a entregar si algo sale mal
     * @return	error, o numero Entero
     */
    public int getLastVauleReleased (int error){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=error;
    //Comprobar Condiciones Iniciales//
    if(estadoEscucha==false){
        condiciones=false;
        motivo="Este Objeto no esta a la Escucha aun";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            if(KeyReleased.Longitud()<=0){
                salida=error;
            }else{
                salida = KeyReleased.getValue(KeyReleased.Longitud()-1,error);
            }
	}else{
            System.out.println("ERROR en getLastVauleReleased, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Obtener el ultimo valor de Tecla Liberada
     *
     * @param error valor a entregar si algo sale mal
     * @return	error, o numero Entero
     */
    public char getLastVauleReleased(char error){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        char salida=error;
    //Comprobar Condiciones Iniciales//
    if(estadoEscucha==false){
        condiciones=false;
        motivo="Este Objeto no esta a la Escucha aun";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            if(KeyReleased.Longitud()<=0){
                salida=error;
            }else{
                salida = (char)KeyReleased.getValue(KeyReleased.Longitud()-1,error);
            }
	}else{
            System.out.println("ERROR en getLastVauleReleased, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Obtener la informacion de como usar esta clase
     *
     */
    public static void help(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    //no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            System.out.println("**************** HELP ********************");
            System.out.println("Clase de Listener para Keyboard de Teclado");
            System.out.println("Modo de Uso:");
            System.out.println("1.- Instanciar un objeto de esta clase, que sera el oyente = new LTKeyboard()");
            System.out.println("2.- Poner a Ecuchar al Objeto  oyente.startListening");
            System.out.println("    Todo lo que se presione en el teclado se guardara en KeyPressed");
            System.out.println("    Todo lo que se presione y se libere se guardara en KeyReleased");
            System.out.println("    Estos son vectores que guardan el codigo de tecla presionada, no el ASCII");
            System.out.println("3.- Para dejar de escuchar es con  oyente.stopListening");
            System.out.println("******************************************");
        }else{
            System.out.println("ERROR en help, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso help Terminado con EXITO");
    	}else{
            //System.out.println("Proceso help Terminado con FALLO");
    	}
    }
    
    

    @Override
    public void nativeKeyPressed(NativeKeyEvent nke) {
        int code = nke.getKeyCode();
        keyPressed.addVauleRigth(code);
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nke) {
        int code = nke.getKeyCode();
        KeyReleased.addVauleRigth(code);
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent nke) {
    
    }
    
}
