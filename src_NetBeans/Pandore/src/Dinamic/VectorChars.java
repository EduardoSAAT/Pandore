/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dinamic;

import Algoritms.Dimention;
import java.io.Serializable;

/**
 *
 * @author Ing Lalux
 */
public class VectorChars implements Serializable{
    public char[] vectorRaiz;
    public int Longitud=0;
    
    
    /**
     * Descripcion: Crear un Vector de Strings
     *
     * @param	longitudInicial MayorIgual 0;
     */
    public VectorChars(int longitudInicial){
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
            vectorRaiz= new char[longitudInicial];
            Longitud=longitudInicial;
        }else{
            System.out.println("ERROR en Constructor VectorChars, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso VectorString Terminado");
    }
    
    
    /**
     * Descripcion: Inicializar el vector con un valor especifico
     *
     * @param	Vaule Valor a Tener en todas las Casillas
     */
    public void Inicializar(char Vaule){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            if(Longitud!=0){
                vectorRaiz = new char[1];
            }else{
                for(int i=0; i<Longitud; i++){
                    vectorRaiz[i]=Vaule;
                }
            }
        }else{
            System.out.println("ERROR en Inicializar, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
    /**
     * Descripcion: Agregar un valor al Vector en una posicion que exista
     *
     * @param	Pos Posicion que exista donde poner Valor
     * @param   Vaule valor Cualquiera
     */
    public void setVaule(int Pos, char Vaule){
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
     * Descripcion: Agregar un valor en una posicion del Vector
     *
     * @param	Vaule Valor a agregar en el Vector
     * @param   Pos Posicion del Vector positiva o Negativa
     * @param   valRelleno Valor de los Espacios que se Creen si es Necesario
     */
    public void setVauleForce(int Pos, char Vaule, char valRelleno){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    
    char vecTemp[];
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
                    vecTemp = new char [Longitud+diferencia];
                    
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
                    vecTemp = new char[Longitud+diferencia];
                    
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
     * Descripcion: Eliminar una posicion N del vetor
     *
     * @param	PosN Posicion desde cero hasta longitud-1
     */
    public void deletePosN(int PosN){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if((PosN>=Longitud)|PosN<0){
        condiciones=false;
        motivo="Posicion: "+PosN+" no valida!";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            char nuevoVector[]=new char[Longitud-1];
            
            int posX=0;
            for(int i=0; i<Longitud;i++){
                if(i!=PosN){
                    nuevoVector[posX]=vectorRaiz[i];
                    posX=posX+1;
                }
            }
            
            vectorRaiz = nuevoVector.clone();
            Longitud=Longitud-1;
        }else{
            System.out.println("ERROR en deletePosN, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso deletePosN Terminado");
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
            for(int i=0; i<Longitud; i++){
                System.out.print(vectorRaiz[i]+separador);
            }
        }else{
            System.out.println("ERROR en ImprimirConsola, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso ImprimirConsola Terminado");
    }
    
    
    /**
     * Descripcion: Agregar un valor a la Izquiera del vector creando una posicion nueva
     *
     * @param	Vaule Valor a agregar
     */
    public void addVauleLefth (char Vaule){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            char[] vectorTemporal = new char[Longitud+1];
            
            vectorTemporal[0]=Vaule;
            for(int i=0; i<Longitud; i++){
                vectorTemporal[i+1]=vectorRaiz[i];
            }
            
            //Pasar el nuevo vector al vector Original//
            vectorRaiz=vectorTemporal.clone();
            Longitud=Longitud+1;
        }else{
            System.out.println("ERROR en addVauleLefth, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso addVauleRigth Terminado");
    }
    
    
    /**
     * Descripcion: Agregar un valor a la derecha del vector creando una posicion nueva
     *
     * @param	Vaule Valor a agregar
     */
    public void addVauleRigth (char Vaule){
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
     * Descripcion: Obtener el valor de una determinada posicion
     *
     * @param	posicion donde buscar Elemento
     * @return	valores de retorno
     */
    public char getValue (int posicion){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        char salida = '!';
    //Comprobar Condiciones Iniciales//
    if(vectorRaiz==null){
        condiciones=false;
        motivo="El vector es NULL";
    }
    if(posicion<0 | posicion>=Longitud){
        condiciones=false;
        motivo="Posicion no Valida!";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=vectorRaiz[posicion];
	}else{
            System.out.println("ERROR en getValue, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Obtener el valor de una determinada posicion
     *
     * @param	posicion donde buscar Elemento
     * @param   error Valor a Obtner en Caso de Error
     * @return	valores de retorno
     */
    public char getValueFIX (int posicion, char error){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        char salida=error;
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            if((posicion>=Longitud)||(posicion<0)){
                return error;
            }
            salida=vectorRaiz[posicion];
	}else{
            System.out.println("ERROR en getValue, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
}
