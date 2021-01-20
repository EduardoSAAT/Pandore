/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dinamic;

import Algoritms.*;
import java.io.Serializable;

/**
 *
 * @author Ing Lalux
 */
public class MatrizString implements Serializable{
    public String matrizRaiz[][];
    public int Alto;
    public int Ancho;
    
    
    /**
     * Descripcion: Constriur la Matriz Dinamica
     *
     * @param	alto  Numero de Filas que tendra la matriz
     * @param   ancho Numero de Columnas que tendra la matriz
     */
    public MatrizString(int alto, int ancho){
        Alto=alto;
        Ancho=ancho;
        matrizRaiz=new String[Alto][Ancho];
    }
    
    
    /**
     * Descripcion: Constriur la Matriz Dinamica
     *
     * @param   matriz Matriz a convertir a Dinamica
     * @param   eliminaSobrante Eliminar FilasyColumnas que solo tienen elementos null
     */
    public MatrizString(String[][]matriz, boolean eliminaSobrante){
        matrizRaiz=matriz;
        Alto=Dimention.getNumFilas(matriz);
        Ancho=Dimention.getNumColumnas(matriz);
        
        if(eliminaSobrante){
            matrizRaiz=Dimention.EliminaFilasNull(matrizRaiz, Alto, Ancho);
                Alto=Dimention.getNumFilas(matrizRaiz);
                Ancho=Dimention.getNumColumnas(matrizRaiz);
            //Falta EliminarColumnas
        }
    }
    
    
    
    /**
     * Descripcion: Inicializar la Matriz con un Valor Especifico
     *
     * @param	ValorEspecifico Valor que tendra Todas las casillas de la Matriz
     */
    public void Inicializar(String ValorEspecifico){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<Alto; i++){
                for(int j=0; j<Ancho; j++){
                    matrizRaiz[i][j]=ValorEspecifico;
                }
            }
        }else{
            System.out.println("ERROR en Inicializar, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso Inicializar Terminado");
    }
    
    
    
    /**
     * Descripcion: Agregar una nueva Fila Arriba con Strings Vacios
     *
     * @param	ValorRelleno  Valor a Poner en los nuevos Espacios que se creen
     */
    public void addFilaArriba(String ValorRelleno){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            Alto=Alto+1;
            String nuevaMatriz[][]= new String[Alto][Ancho];
            
            for(int i=0; i<Alto-1; i++){
                for(int j=0; j<Ancho; j++){
                    nuevaMatriz[i+1][j]=matrizRaiz[i][j];
                }
            }
            
            for(int i=0; i<Ancho; i++){
                nuevaMatriz[0][i]=ValorRelleno;
            }
            
            matrizRaiz=nuevaMatriz;
        }else{
            System.out.println("ERROR en addFilaArriba, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso identificador Terminado");
    }
    
    
    /**
     * Descripcion: Agregar una nueva Fila Abajo con Strings Vacios
     *
     * @param	ValorRelleno  Valor a Poner en los nuevos Espacios que se creen
     */
    public void addFilaAbajo(String ValorRelleno){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            Alto=Alto+1;
            String nuevaMatriz[][]= new String[Alto][Ancho];
            
            for(int i=0; i<Alto-1; i++){
                for(int j=0; j<Ancho; j++){
                    nuevaMatriz[i][j]=matrizRaiz[i][j];
                }
            }
            
            for(int i=0; i<Ancho; i++){
                nuevaMatriz[Alto-1][i]=ValorRelleno;
            }
            
            matrizRaiz=nuevaMatriz;
        }else{
            System.out.println("ERROR en addFilaArriba, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso identificador Terminado");
    }
    
    
    /**
     * Descripcion: Agregar una nueva Columna por la Derecha
     * 
     * @param	ValorRelleno  Valor a Poner en los nuevos Espacios que se creen
     */
    public void addColumnaDerecha(String ValorRelleno){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            Ancho=Ancho+1;
            String nuevaMatriz[][]= new String[Alto][Ancho];
            
            for(int i=0; i<Alto; i++){
                for(int j=0; j<Ancho-1; j++){
                    nuevaMatriz[i][j]=matrizRaiz[i][j];
                }
            }
            
            for(int i=0; i<Alto; i++){
                nuevaMatriz[i][Ancho-1]=ValorRelleno;
            }
            
            matrizRaiz=nuevaMatriz;
        }else{
            System.out.println("ERROR en addFilaArriba, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso identificador Terminado");
    }
    
    
    /**
     * Descripcion: Agregar una nueva Columna por la Izquierda
     *
     * @param	ValorRelleno  Valor a Poner en los nuevos Espacios que se creen
     */
    public void addColumnaIzquierda(String ValorRelleno){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            Ancho=Ancho+1;
            String nuevaMatriz[][]= new String[Alto][Ancho];
            
            for(int i=0; i<Alto; i++){
                for(int j=0; j<Ancho-1; j++){
                    nuevaMatriz[i][j+1]=matrizRaiz[i][j];
                }
            }
            
            for(int i=0; i<Alto; i++){
                nuevaMatriz[i][0]=ValorRelleno;
            }
            
            matrizRaiz=nuevaMatriz;
        }else{
            System.out.println("ERROR en addFilaArriba, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso identificador Terminado");
    }
    
    
    /**
     * Descripcion: Poner un valor en una posicion determinada
     *
     * @param	vaule Valor a Agregar en la Matriz
     * @param   alto Valor mayorIgual a cero y menor al Alto
     * @param   ancho Valor MayorIgual a cero y menor a Ancho
     */
    public void setVaule(String vaule, int alto, int ancho){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if((alto>=Alto)||(alto<0)){
        condiciones=false;
        motivo="Posicion Alto:"+alto+" No Existe en la Matriz";
    }
    if((ancho>=Ancho)||(ancho<0)){
        condiciones=false;
        motivo="Posicion Ancho:"+ancho+" No Existe en la Matriz";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            matrizRaiz[alto][ancho]=vaule;
        }else{
            System.out.println("ERROR en setVaule, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
    /**
     * Descripcion: Si el punto no existe en la matriz, este se crea
     *
     * @param	vaule Valor a Agregar en la Matriz
     * @param   alto Si es menor a cero se crea FilaArriba, mayor a cero FilaAbajo
     * @param   ancho Si es menor a cero se crea ColumnaIzq, mayor a cero ColumnaDerecha
     * @param	ValorRelleno  Valor a Poner en los nuevos Espacios que se creen
     */
    public void setVauleForce(String vaule, int alto, int ancho, String ValorRelleno){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            if(((alto>=0)&&(alto<Alto))&&((ancho>=0)&&(ancho<Ancho))){
                setVaule(vaule, alto, ancho);
            }else{
                //Crear Para Custiones del Alto//
                if(alto>=0){
                    int AltoInicial=Alto;
                    for(int i=0; i<=alto-AltoInicial; i++){
                        addFilaAbajo(ValorRelleno);
                    }
                }else{
                    for(int i=1; i<=-alto; i++){
                        addFilaArriba(ValorRelleno);
                    }
                }
                //Crear Para cuestiones del Ancho//
                if(ancho>=0){
                    int AnchoInicial=Ancho;
                    for(int i=0; i<=ancho-AnchoInicial; i++){
                        addColumnaDerecha(ValorRelleno);
                    }
                }else{
                    for(int i=1; i<=-ancho; i++){
                        addColumnaIzquierda(ValorRelleno);
                    }
                }
                
                //Finalmente Agregar el ValorEspecifico//
                if(alto<0){alto=0;}  if(ancho<0){ancho=0;}
                setVaule(vaule, alto, ancho);
            }
        }else{
            System.out.println("ERROR en setVaule, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
    /**
     * Descripcion: Imprimir la matriz en Consola
     *
     * @param	separador Separador entre elementos de la matriz
     */
    public void ImprimirConsola(String separador){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(separador==null){
        condiciones=false;
        motivo="El separador es Nulo";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<Alto; i++){
                for(int j=0; j<Ancho; j++){
                    System.out.print(matrizRaiz[i][j]);System.out.print(separador);
                }
                System.out.println("");
            }
        }else{
            System.out.println("ERROR en ImprimirConsola, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
    
     /**
     * Descripcion: Obtner el Vaule de una posicion de la matriz
     *
     * @param	alto Posicion a lo Alto
     * @param   ancho Posicion a lo ancho
     * @return	valores de retorno
     */
    public String getVaule (int alto, int ancho){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
    if((Nums.Range(alto,0,Alto)&&Nums.Range(ancho,0,Ancho))==false){
        condiciones=false;
        motivo="Poscicion ("+alto+","+ancho+") no existe en la Matriz";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=matrizRaiz[alto][ancho];
	}else{
            System.out.println("ERROR en getVaule, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Obtener la posicion de un Elemento en una Columna
     *
     * @param	ElementSearch Elemento a buscar
     * @param   Columna Lugar donde Buscar
     * @param   IgnoreCase Ignorar mayusculas de minusculas
     * @return	posicion de la columna o -1 ERROR
     */
    public int posContainsColumna (String ElementSearch, int Columna, boolean IgnoreCase){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=-1;
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            if(ElementSearch==null){
                for(int i=0; i<Alto; i++){
                    if(matrizRaiz[i][Columna]==null){
                        salida=i;
                        i=Alto;
                    }
                }
            }else{
                if(IgnoreCase==false){
                    for(int i=0; i<Alto; i++){
                        if(matrizRaiz[i][Columna].equals(ElementSearch)){
                            salida=i;
                            i=Alto;
                        }
                    }
                }else{
                    for(int i=0; i<Alto; i++){
                        if(matrizRaiz[i][Columna].equalsIgnoreCase(ElementSearch)){
                            salida=i;
                            i=Alto;
                        }
                    }
                }
            }
	}else{
            System.out.println("ERROR en posContainsColumna, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Obtener alguna fila de la matrizRaiz
     *
     * @param   numFila 0-n
     * @return	String[] o null
     */
    public String[] getFila (int numFila){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String[] salida=null;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            salida = new String[Ancho];
            
            for(int i=0;  i<Ancho; i++){
                salida[i]=matrizRaiz[numFila][i];
            }
	}else{
            System.out.println("ERROR en getFila, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
}
