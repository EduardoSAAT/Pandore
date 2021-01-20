/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritms;

/**
 *
 * @author Ing Lalux
 */
public class Cryptography {
    
    
    
     /**
     * Descripcion: Cifran una cadena de caracteres usando el metodo Cesar o Dezplazamiento
     *
     * @param	Palabra Palabra a codificar
     * @param   numCambio numero de pasos que cambiara cada letra de la palabra
     * @param   codificar True Codifica, False Decodifica
     * @return	valores de retorno
     */
    public static String CifradoCesar (String Palabra, int numCambio, boolean codificar){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=Palabra;
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            char[] vectorCaracteres = Palabra.toCharArray();
            
            
            int posAscii=0;
            for(int i=0; i<vectorCaracteres.length; i++){
                posAscii = (int)vectorCaracteres[i];
                
                if(codificar){
                    posAscii=posAscii+numCambio;
                }else{
                    posAscii=posAscii-numCambio;
                }
                vectorCaracteres[i]=(char)posAscii;
            }
            salida = String.valueOf(vectorCaracteres);
	}else{
            System.out.println("ERROR en CifradoCesar, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
}
