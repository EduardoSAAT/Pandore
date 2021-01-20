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
public class Logic {
    
    
    /**
     * Descripcion: Compuerta Logica AND 
     *
     * @param	var1 Cadena con 0 y 1
     * @param	var2 Cadena con 0 y 1
     * @return	Cadena con Resultado
     */
    public static String ANND(String var1, String var2){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        int i=0;
    //Comprobar Condiciones Iniciales//
    if(var1.length()!=var2.length()){
        condiciones=false;
        motivo="Variables de diferente Length";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(i=0; i<var1.length(); i++){
                if((var1.substring(i, i+1).equals("1"))&&(var2.substring(i, i+1).equals("1"))){
                    salida=salida.concat("1");
                }else{
                    salida=salida.concat("0");
                }
            }
	}else{
            System.out.println("ERROR en Annd, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Compuerta Logica XOR
     *
     * @param	var1 Cadena con 0 y 1
     * @param	var2 Cadena con 0 y 1
     * @return	Cadena con Resultado
     */
    public static String XOR(String var1, String var2){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        int i=0;
    //Comprobar Condiciones Iniciales//
    if(var1.length()!=var2.length()){
        condiciones=false;
        motivo="Variables de diferente Length";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(i=0; i<var1.length(); i++){
                if(var1.substring(i, i+1).equals(var2.substring(i, i+1))){
                    salida=salida.concat("0");
                }else{
                    salida=salida.concat("1");
                }
            }
	}else{
            System.out.println("ERROR en XOR, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Compuerta Logica OR
     *
     * @param	var1 Cadena con 0 y 1
     * @param	var2 Cadena con 0 y 1
     * @return	Cadena con Resultado
     */
    public static String OR(String var1, String var2){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        int i=0;
    //Comprobar Condiciones Iniciales//
    if(var1.length()!=var2.length()){
        condiciones=false;
        motivo="Variables de diferente Length";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(i=0; i<var1.length(); i++){
                if((var1.substring(i, i+1).equals("1"))||(var2.substring(i, i+1).equals("1"))){
                    salida=salida.concat("1");
                }else{
                    salida=salida.concat("0");
                }
            }
	}else{
            System.out.println("ERROR en OR, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Compuerta Logica NOT
     *
     * @param	var1 Cadena con 0 y 1
     * @return	Cadena con Resultado
     */
    public static String NOT(String var1){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        int i=0;
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            for(i=0; i<var1.length(); i++){
                if(var1.substring(i, i+1).equals("1")){
                    salida=salida.concat("0");
                }
                
                if(var1.substring(i, i+1).equals("0")){
                    salida=salida.concat("1");
                }
            }
	}else{
            System.out.println("ERROR en NOT, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Compuerta Logica NAND
     *
     * @param	var1 Cadena con 0 y 1
     * @param	var2 Cadena con 0 y 1
     * @return	Cadena con Resultado
     */
    public static String NAND(String var1, String var2){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        int i=0;
    //Comprobar Condiciones Iniciales//
    if(var1.length()!=var2.length()){
        condiciones=false;
        motivo="Variables de diferente Length";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=Algoritms.Logic.ANND(var1, var2);
            salida=Algoritms.Logic.NOT(salida);
	}else{
            System.out.println("ERROR en NAND, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Compuerta Logica NOR
     *
     * @param	var1 Cadena con 0 y 1
     * @param	var2 Cadena con 0 y 1
     * @return	Cadena con Resultado
     */
    public static String NOR(String var1, String var2){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        int i=0;
    //Comprobar Condiciones Iniciales//
    if(var1.length()!=var2.length()){
        condiciones=false;
        motivo="Variables de diferente Length";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=Algoritms.Logic.OR(var1, var2);
            salida=Algoritms.Logic.NOT(salida);
	}else{
            System.out.println("ERROR en NOR, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Compuerta Logica XNOR
     *
     * @param	var1 Cadena con 0 y 1
     * @param	var2 Cadena con 0 y 1
     * @return	Cadena con Resultado
     */
    public static String XNOR(String var1, String var2){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        int i=0;
    //Comprobar Condiciones Iniciales//
    if(var1.length()!=var2.length()){
        condiciones=false;
        motivo="Variables de diferente Length";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=Algoritms.Logic.XOR(var1, var2);
            salida=Algoritms.Logic.NOT(salida);
	}else{
            System.out.println("ERROR en XNOR, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
}
