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
public class Estadistic {
    
    /**
     * Descripcion: Obtener el valor de Porcentaje de un Numero
     *
     * @param	Numero Numero a obtener el porcentaje
     * @param   porcentaje Porcentajea obtener del Numero
     * @return	valor del porcentaje del Numero
     */
    public static double porcentajeVALOR (double Numero, double porcentaje){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        double salida=0;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            salida=(Numero/100)*porcentaje;
	}else{
            System.out.println("ERROR en porcentajeVALOR, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Obtener el valor de Porcentaje de un Numero
     *
     * @param	Numero Numero a obtener el porcentaje
     * @param   porcentaje Porcentajea obtener del Numero
     * @return	valor del porcentaje del Numero
     */
    public static float porcentajeVALOR (float Numero, float porcentaje){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        float salida=0;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            salida=(Numero/100)*porcentaje;
	}else{
            System.out.println("ERROR en porcentajeVALOR, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Obtener cuanto porcentaje representa el numeroA respecto a un numeroB
     *  (100,50)=50%
     * @param	NumeroA tego este numero para comparar
     * @param   NumeroB que porcentaje es este numero respectoA
     * @return	0 a 100
     */
    public static double porcentajeTASA (double NumeroA, double NumeroB){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        double salida=0;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            salida=(NumeroB/NumeroA)*100;
	}else{
            System.out.println("ERROR en porcentajeTASA, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Obtener cuanto porcentaje representa el numeroA respecto a un numeroB
     *  (100,50)=50%
     * @param	NumeroA tego este numero para comparar
     * @param   NumeroB que porcentaje es este numero respectoA
     * @return	0 a 100
     */
    public static float porcentajeTASA (float NumeroA, float NumeroB){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        float salida=0;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            salida=(NumeroB/NumeroA)*100;
	}else{
            System.out.println("ERROR en porcentajeTASA, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Obtener el valor promedio de N numeros
     *
     * @param	ConjuntoNums de Numeros separados por un separador
     * @param   separador Separador entre numeros
     * @return	-1 Error
     */
    public static double Promedio (String ConjuntoNums, String separador){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        double salida=-1;
        
        int[] vector;
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(ConjuntoNums)){
        condiciones=false;
        motivo="El conjunto esta Vacio o NULL";
    }
    if(Cad.isNulloVacia(separador)){
        condiciones=false;
        motivo="El separador es Vacio o NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            vector=Dimention.convertVectorStringToVectorInt(Cad.aVector(ConjuntoNums, separador));
            salida=0;
            for(int i=0; i<vector.length; i++){
                salida=salida+vector[i];
            }
            salida=salida/vector.length;
	}else{
            System.out.println("ERROR en Promedio, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener el Valor promedio de un grupo de Floats
     *
     * @param	vector Grupo de Valores
     * @return	-1 ERROR, otro Valor
     */
    public static float Promedio (float[] vector){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        float salida=-1;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            salida=0;
            for(int i=0; i<vector.length; i++){
                salida=salida+vector[i];
            }
            salida=salida/vector.length;
	}else{
            System.out.println("ERROR en Promedio, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener la mediana de un conjunto de valores
     *  //LA mediana es el valor central, si el conjunto es par, sera la media de los dos valores centrales
     *
     * @param	vector Vector de Datos
     * @param   error Valor de salida en caso de error
     * @return	valores de retorno
     */
    public static float Mediana (float[]vector, float error){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        float salida=error;
        
        float[] vectorTemp=vector.clone();
        int pos=0;
    //Comprobar Condiciones Iniciales//
    if(vector==null){
        condiciones=false;
        motivo="Vector es NULL";
    }
    if(vector.length==0){
        condiciones=false;
        motivo="Vector sin Elementos";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Ordenar el vector//
            vectorTemp=Algoritms.Sort.Insertion(vectorTemp,"UP");
            
            if(Nums.comprobarPAR(vectorTemp.length)){
                pos=Nums.redondearEntero(vectorTemp.length/2,0);
                salida=(vectorTemp[pos-1]+vectorTemp[pos])/2;
            }else{
                pos=Nums.redondearEntero(vectorTemp.length/2,1);
                salida=vectorTemp[pos];
            }
	}else{
            System.out.println("ERROR en Mediana, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
}
