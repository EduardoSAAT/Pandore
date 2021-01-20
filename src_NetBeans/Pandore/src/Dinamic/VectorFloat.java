/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dinamic;

import Algoritms.Dimention;
import Algoritms.Nums;
import java.io.Serializable;

/**
 *
 * @author Ing Lalux
 */
public class VectorFloat implements Serializable{
    public float[] vectorRaiz;
    public int Longitud=0;
    
    
    /**
     * Descripcion: Crear un Vector de Integers
     *
     * @param	longitudInicial mayorIgual 0;
     */
    public VectorFloat(int longitudInicial){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(longitudInicial<0){
        condiciones=false;
        motivo="Longitud Negativa";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            vectorRaiz= new float[longitudInicial];
            Longitud=longitudInicial;
        }else{
            System.out.println("ERROR en Constructor VectorFloat, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso VectorString Terminado");
    }
    
    
    /**
     * Descripcion: Inicializar el vector con un valor especifico
     *
     * @param	Vaule Valor a Tener en todas las Casillas
     */
    public void Inicializar(float Vaule){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            vectorRaiz = Dimention.InicializaVector(vectorRaiz,Vaule);
        }else{
            System.out.println("ERROR en Inicializar, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
    /**
     * Descripcion: Imprimri en Con sola el Vector
     *
     * @param	separador Separador entre elementos del vector
     */
    public void ImprimirConsola(String separador){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            Dimention.ImprimirVector(vectorRaiz,separador);
        }else{
            System.out.println("ERROR en ImprimirConsola, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso ImprimirConsola Terminado");
    }
    
    
    /**
     * Descripcion: Eliminar una posicion N del vetor
     *
     * @param	PosN Posicion desde cero hasta longitud-1
     */
    public void deletePosN(int PosN){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            vectorRaiz=Dimention.EliminarPosNvector(vectorRaiz, PosN);
            Longitud=Longitud-1;
        }else{
            System.out.println("ERROR en deletePosN, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso deletePosN Terminado");
    }
    
    
    /**
     * Descripcion: Agregar un valor al Vector en una posicion que exista
     *
     * @param	Pos Posicion que exista donde poner Valor
     * @param   Vaule Integer Cualquiera
     */
    public void setVaule(int Pos, float Vaule){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(!((Pos>=0)&&(Pos<Longitud))){
        condiciones=false;
        motivo="Posicion: "+Pos+" No existe en el Vector";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            vectorRaiz[Pos]=Vaule;
        }else{
            System.out.println("ERROR en setVaule, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso identificador Terminado");
    }
    
     /**
     * Descripcion: Obtener el valor de una posicion
     *
     * @param	posicion Posicion del valor a obtener
     * @param   error Valor de salida en caso de Error
     * @return	valores de retorno
     */
    public float getVaule (int posicion, float error){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";
        float salida=error;
    //Comprobar Condiciones Iniciales//
    if(Nums.Range(posicion,0,Longitud-1)==false){
        condiciones=false;
        motivo="Posicion no valida";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=vectorRaiz[posicion];
	}else{
            System.out.println("ERROR en getVaule, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Agregar un valor en una posicion del Vector
     *
     * @param	Vaule Valor a agregar en el Vector
     * @param   Pos Posicion del Vector positiva o Negativa
     * @param   valRelleno Valor de los Espacios que se Creen si es Necesario
     */
    public void setVauleForce(int Pos, float Vaule, float valRelleno){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    
    float vecTemp[];
    //Comprobar Condiciones Iniciales//
    
	//Comenzar Proceso//
        if(condiciones==true){
            //Si la Posicion Existe simplemente meter el valor//
            if((Pos>=0)&&(Pos<Longitud)){
                setVaule(Pos, Vaule);
            }else{
                int diferencia;
                //si la posicion no existe crear la posicion
                if(Pos>=0){ //Posicion a la Derecha
                    diferencia=Pos-Longitud+1;
                    vecTemp = new float[Longitud+diferencia];
                    
                    for(int i=0; i<Longitud; i++){
                        vecTemp[i]=vectorRaiz[i];
                    }
                        for(int i=Longitud; i<diferencia+Longitud; i++){
                            vecTemp[i]=valRelleno;
                        }
                    vecTemp[Pos]=Vaule;
                    vectorRaiz=vecTemp;
                    Longitud=Longitud+diferencia;
                }else{//Posicion a la IZQ
                    diferencia=-Pos;
                    vecTemp = new float[Longitud+diferencia];
                    
                    for(int i=diferencia; i<Longitud+diferencia; i++){
                        vecTemp[i]=vectorRaiz[i-diferencia];
                    }
                        for(int i=1; i<diferencia; i++){
                            vecTemp[i]=valRelleno;
                        }
                    vecTemp[0]=Vaule;
                    vectorRaiz=vecTemp;
                    Longitud=Longitud+diferencia;
                }
            }
        }else{
            System.out.println("ERROR en setVauleForce, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
    /**
     * Descripcion: Agregar un valor a la derecha del vector creando una posicion nueva
     *
     * @param	Vaule Valor a agregar
     */
    public void addVauleRigth (float Vaule){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            this.setVauleForce(Longitud, Vaule, Vaule);
        }else{
            System.out.println("ERROR en addVauleRigth, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso addVauleRigth Terminado");
    }
    
    
    /**
     * Descripcion: Agregar un valor a la Izquiera del vector creando una posicion nueva
     *
     * @param	Vaule Valor a agregar
     */
    public void addVauleLefth (float Vaule){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            float[] vectorTemporal = new float[Longitud+1];
            
            vectorTemporal[0]=Vaule;
            for(int i=0; i<Longitud; i++){
                vectorTemporal[i+1]=vectorRaiz[i];
            }
            
            //Pasar el nuevo vector al vector Original//
            vectorRaiz=vectorTemporal;
            Longitud=Longitud+1;
        }else{
            System.out.println("ERROR en addVauleLefth, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso addVauleRigth Terminado");
    }
    
    
     /**
     * Descripcion: Obtener la suma de todos los elementos en el vector
     *
     * @return	0 a N
     */
    public float getSumaTotal(){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        float salida=0;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            float suma = 0;
            for(int i=0; i<Longitud; i++){
                suma = suma + getVaule(i,0);
            }
            salida=suma;
	}else{
            System.out.println("ERROR en getSumaTotal, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
}
