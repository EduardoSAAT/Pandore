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
public class Geometry {
    
    
     /**
     * Descripcion: Calcular el Seno de un Angulo dado en Grados
     *
     * @param	Angulo en Grados
     * @return	valores de retorno
     */
    public static double getSeno (double Angulo){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";
        double salida=0;
    //Comprobar Condiciones Iniciales//
    
	//Comenzar Proceso//
        if(condiciones==true){
            Angulo=Math.toRadians(Angulo);
            salida=Math.sin(Angulo);
	}else{
            System.out.println("ERROR en getSeno, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Calcular el Coseno de un Angulo dado en Grados
     *
     * @param	Angulo en Grados
     * @return	valores de retorno
     */
    public static double getCoseno (double Angulo){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";
        double salida=0;
    //Comprobar Condiciones Iniciales//
    
	//Comenzar Proceso//
        if(condiciones==true){
            Angulo=Math.toRadians(Angulo);
            salida=Math.cos(Angulo);
	}else{
            System.out.println("ERROR en getCoseno, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Calcular el Tangente de un Angulo dado en Grados
     *
     * @param	Angulo en Grados
     * @return	valores de retorno
     */
    public static double getTangente (double Angulo){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";
        double salida=0;
    //Comprobar Condiciones Iniciales//
    
	//Comenzar Proceso//
        if(condiciones==true){
            Angulo=Math.toRadians(Angulo);
            salida=Math.tan(Angulo);
	}else{
            System.out.println("ERROR en getTangente, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
}
