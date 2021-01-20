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
public class Sort {
    
    /**
     * Descripcion: Ordenamiento de Enteros por InsertionSort
     *      Complejidad  Peor caso: O(n^2)
     *                   Mejor caso:  O(n)
     *                   Caso Promedio: O(n^2)
     * @param	vector Vector a Ordenar
     * @param   OrdenType Orden de ORdenamiento "UP" o "DOWN"
     * @return	valores de retorno
     */
    public static int[] Insertion (int[] vector, String OrdenType){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        
        int valActual=0;
        int x=0;
        OrdenType=OrdenType.toUpperCase();
    //Comprobar Condiciones Iniciales//
    if(vector==null){
        condiciones=false;
        motivo="Vector NULL";
    }
    if(Cad.OnlyContains(OrdenType,"UP,DOWN,",",")==false){
        condiciones=false;
        motivo="Tipo de Ordenamiento no Soportado, soportado: UP, DOWN";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            switch (OrdenType) {
                case "UP":
                    for (int i = 1; i < vector.length; i++) {
                        valActual = vector[i];
                        x = i - 1;

                        while ((x >= 0) && (vector[x] > valActual)) {
                            vector[x + 1] = vector[x];
                            x = x - 1;
                        }
                        vector[x + 1] = valActual;
                    }
                    break;
                case "DOWN":
                    for (int i = 1; i < vector.length; i++) {
                        valActual = vector[i];
                        x = i - 1;

                        while ((x >= 0) && (vector[x] < valActual)) {
                            vector[x + 1] = vector[x];
                            x = x - 1;
                        }
                        vector[x + 1] = valActual;
                    }
                default:
                    break;
            }
	}else{
            System.out.println("ERROR en InsertionSort, motivo: "+motivo+", valor regresado: "+vector);
	}
    //Terminar Proceso//
        return vector;
    }
    
    
    /**
     * Descripcion: Ordenamiento de Enteros por InsertionSort
     *      Complejidad  Peor caso: O(n^2)
     *                   Mejor caso:  O(n)
     *                   Caso Promedio: O(n^2)
     * @param	vector Vector a Ordenar
     * @param   OrdenType Orden de ORdenamiento "UP" o "DOWN"
     * @return	valores de retorno
     */
    public static float[] Insertion (float[] vector, String OrdenType){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        
        float valActual=0;
        int x=0;
        OrdenType=OrdenType.toUpperCase();
    //Comprobar Condiciones Iniciales//
    if(vector==null){
        condiciones=false;
        motivo="Vector NULL";
    }
    if(Cad.OnlyContains(OrdenType,"UP,DOWN,",",")==false){
        condiciones=false;
        motivo="Tipo de Ordenamiento no Soportado, soportado: UP, DOWN";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            switch (OrdenType) {
                case "UP":
                    for (int i = 1; i < vector.length; i++) {
                        valActual = vector[i];
                        x = i - 1;

                        while ((x >= 0) && (vector[x] > valActual)) {
                            vector[x + 1] = vector[x];
                            x = x - 1;
                        }
                        vector[x + 1] = valActual;
                    }
                    break;
                case "DOWN":
                    for (int i = 1; i < vector.length; i++) {
                        valActual = vector[i];
                        x = i - 1;

                        while ((x >= 0) && (vector[x] < valActual)) {
                            vector[x + 1] = vector[x];
                            x = x - 1;
                        }
                        vector[x + 1] = valActual;
                    }
                default:
                    break;
            }
	}else{
            System.out.println("ERROR en InsertionSort, motivo: "+motivo+", valor regresado: "+vector);
	}
    //Terminar Proceso//
        return vector;
    }
    
    
     /**
     * Descripcion: Odenamiento por metodo burbuja
     *
     * @param	vector Vector a Ordenar
     * @param   OrdenType Tipo de Ordenamiento "UP" "DOWN"
     * @return	vector Ordenado, en caso ERROR mismo vector sin modificacion
     */
    public static int[] Burbuja (int[] vector, String OrdenType){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int[] salida=vector;
        
        OrdenType=OrdenType.toUpperCase();
        int aux;
    //Comprobar Condiciones Iniciales//
    if(vector==null){
        condiciones=false;
        motivo="Vector es NULL";
    }
    if(Cad.OnlyContains(OrdenType,"UP,DOWN",",")==false){
        condiciones=false;
        motivo="Orden de Ordenamiento Incorrecto, solo es posible UP o DOWN";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            switch (OrdenType) {
                case "UP":
                    for (int j = salida.length - 1; j > 0; j--) {
                        for (int i = 0; j > i; i++) {
                            if (salida[i] > salida[i + 1]) {
                                aux = salida[i];
                                salida[i] = salida[i + 1];
                                salida[i + 1] = aux;
                            }
                        }
                    }
                    break;
                case "DOWN":
                    for (int j = salida.length - 1; j > 0; j--) {
                        for (int i = 0; j > i; i++) {
                            if (salida[i] < salida[i + 1]) {
                                aux = salida[i];
                                salida[i] = salida[i + 1];
                                salida[i + 1] = aux;
                            }
                        }
                    }
                    break;
                default:
                    break;
            }
	}else{
            System.out.println("ERROR en Burbuja, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Odenamiento por metodo burbuja
     *
     * @param	vector Vector a Ordenar
     * @param   OrdenType Typo de Ordenamiento "UP" "DOWN"
     * @return	vector Ordenado, en caso ERROR mismo vector sin modificacion
     */
    public static float[] Burbuja (float[] vector, String OrdenType){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        float[] salida=vector;
        
        OrdenType=OrdenType.toUpperCase();
        float aux;
    //Comprobar Condiciones Iniciales//
    if(vector==null){
        condiciones=false;
        motivo="Vector es NULL";
    }
    if(Cad.OnlyContains(OrdenType,"UP,DOWN",",")==false){
        condiciones=false;
        motivo="Orden de Ordenamiento Incorrecto, solo es posible UP o DOWN";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            switch (OrdenType) {
                case "UP":
                    for (int j = salida.length - 1; j > 0; j--) {
                        for (int i = 0; j > i; i++) {
                            if (salida[i] > salida[i + 1]) {
                                aux = salida[i];
                                salida[i] = salida[i + 1];
                                salida[i + 1] = aux;
                            }
                        }
                    }
                    break;
                case "DOWN":
                    for (int j = salida.length - 1; j > 0; j--) {
                        for (int i = 0; j > i; i++) {
                            if (salida[i] < salida[i + 1]) {
                                aux = salida[i];
                                salida[i] = salida[i + 1];
                                salida[i + 1] = aux;
                            }
                        }
                    }
                    break;
                default:
                    break;
            }
	}else{
            System.out.println("ERROR en Buerbuja, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
}
