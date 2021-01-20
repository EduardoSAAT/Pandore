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
public class VectorLong implements Serializable{
    long[] vectorRaiz;
    
    
    /**
     * Descripcion: Construir un vector dinamico de enteros
     *
     */
    public VectorLong(){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            vectorRaiz = null;
	}else{
            System.out.println("ERROR en Constructor: vecInt, motivo: "+motivo);
	}
    }
    
    
    
     /**
     * Descripcion: Obtener la longitud del vector
     *
     * @return	0 - n
     */
    public int Longitud (){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            if(vectorRaiz==null){
                salida=0;
            }else{
                salida=vectorRaiz.length;
            }
	}else{
            System.out.println("ERROR en Longitud, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Obtener el valor en una posicion del arreglo
     *
     * @param	posicion posicion del valor a obtener
     * @param   valorError Valor que deberia arrojar si ocurre un error
     * @return	valores o valorError
     */
    public long getValue (int posicion, long valorError){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        long salida = valorError;
    //Comprobar Condiciones Iniciales//
    if(Longitud()==0){
        condiciones = false;
        motivo="El vector esta vacio";
    }else{
        if(posicion<0 || posicion>=Longitud()){
            condiciones=false;
            motivo="La posicion no existe";
        }
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida = vectorRaiz[posicion];
	}else{
            System.out.println("ERROR en getValue, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Cambiar el valor de una cierta posicion
     *
     * @param	Pos Posicion que exista donde poner Valor
     * @param   Vaule Integer Cualquiera
     */
    public void changeVaule(int Pos, Long Vaule){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(!posExist(Pos)){
        condiciones=false;
        motivo="Posicion: "+Pos+" No existe en el Vector";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            vectorRaiz[Pos]=Vaule;
        }else{
            System.out.println("ERROR en changeVaule, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso identificador Terminado");
    }
    
    
    
    /**
     * Descripcion: Agregar un valor a la derecha del arreglo
     *
     * @param	vaule Valor a gregar
     */
    public void addVauleRigth(long vaule){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//	
	//Comenzar Proceso//
        if(condiciones==true){
            long[] nuevoVector = new long[Longitud()+1];
            
            //Agregar los valores
            for(int i=0 ; i<Longitud(); i++){
                nuevoVector[i] = vectorRaiz[i];
            }
            nuevoVector[Longitud()] = vaule;
            
            //remplazar los vectores
            vectorRaiz = nuevoVector.clone();
                    
        }else{
            System.out.println("ERROR en addVauleRigth, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso addVauleRigth Terminado");
    }
    
    
    /**
     * Descripcion: Agregar un valor a la derecha del arreglo
     *
     * @param	vaule Valor a gregar
     */
    public void addVauleRigth(int vaule){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//	
	//Comenzar Proceso//
        if(condiciones==true){
            long[] nuevoVector = new long[Longitud()+1];
            
            //Agregar los valores
            for(int i=0 ; i<Longitud(); i++){
                nuevoVector[i] = vectorRaiz[i];
            }
            nuevoVector[Longitud()] = vaule;
            
            //remplazar los vectores
            vectorRaiz = nuevoVector.clone();
                    
        }else{
            System.out.println("ERROR en addVauleRigth, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso addVauleRigth Terminado");
    }
    
    
    
    /**
     * Descripcion: Eliminar el valor mas a la derecha del vector
     *
     */
    public void deleteVauleRigth(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//	
    if(Longitud()<=0){
        condiciones=false;
        motivo="No hay elementos en el vector";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            long[] nuevoVector = new long[Longitud()-1];
            
            //Agregar los valores
            for(int i=0 ; i<Longitud()-1; i++){
                nuevoVector[i] = vectorRaiz[i];
            }
            
            //remplazar los vectores
            vectorRaiz = nuevoVector.clone();
        }else{
            System.out.println("ERROR en deleteVauleRigth, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso deleteVauleRigth Terminado");
    }
    
    
    
     /**
     * Descripcion: Saber si una pocion existe en el vector
     *
     * @param	pos Posicion en el vector
     * @return	true o false
     */
    public boolean posExist (int pos){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida = false;
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            //Si el vector existe
            if(vectorRaiz != null){
                
                //Si la posicion existe en el vector
                if(pos>=0 && pos<Longitud()){
                    salida=true;
                }
            }
	}else{
            System.out.println("ERROR en posExist, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
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
    if(Longitud()==0){
        condiciones=false;
        motivo="El vector esta vacio";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<Longitud(); i++){
                System.out.print(vectorRaiz[i]);
                System.out.print(separador);
            }
        }else{
            System.out.println("ERROR en ImprimirConsola, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso ImprimirConsola Terminado");
    }
    
    
    
    /**
     * Descripcion: Agregar un valor a la izquierda del arreglo
     *
     * @param	vaule Valor a gregar
     */
    public void addVauleLefth(long vaule){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//	
	//Comenzar Proceso//
        if(condiciones==true){
            long[] vectorNuevo = new long[Longitud()+1];
            vectorNuevo[0] = vaule;
            
            //Pasar todos los demas valores en las casillas siguientes//
            for(int i=0; i<Longitud(); i++){
                vectorNuevo[i+1] = vectorRaiz[i];
            }
            
            //Clonacion de Datos//
            vectorRaiz = vectorNuevo.clone();
        }else{
            System.out.println("ERROR en addVauleLefth, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso addVauleLefth Terminado");
    }
    
    
    
    /**
     * Descripcion: Agregar un valor a la izquierda del arreglo
     *
     * @param	vaule Valor a gregar
     */
    public void addVauleLefth(int vaule){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//	
	//Comenzar Proceso//
        if(condiciones==true){
            long[] vectorNuevo = new long[Longitud()+1];
            vectorNuevo[0] = vaule;
            
            //Pasar todos los demas valores en las casillas siguientes//
            for(int i=0; i<Longitud(); i++){
                vectorNuevo[i+1] = vectorRaiz[i];
            }
            
            //Clonacion de Datos//
            vectorRaiz = vectorNuevo.clone();
        }else{
            System.out.println("ERROR en addVauleLefth, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso addVauleLefth Terminado");
    }
    
    
    /**
     * Descripcion: Eliminar el valor mas a la izquierda del vector
     *
     */
    public void deleteVauleLefth(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//	
    if(Longitud()<=0){
        condiciones=false;
        motivo="No hay elementos en el vector";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            long[] vectorNuevo = new long[Longitud()-1];
            
            //Pasar todos los demas valores en las casillas siguientes//
            for(int i=1; i<Longitud(); i++){
                vectorNuevo[i-1] = vectorRaiz[i];
            }
            
            //Clonacion de Datos//
            vectorRaiz = vectorNuevo.clone();
        }else{
            System.out.println("ERROR en deleteVauleLefth, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso deleteVauleLefth Terminado");
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
    if(!posExist(PosN)){
        condiciones=false;
        motivo="La posicion:"+PosN+" no existe";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            vectorRaiz=Dimention.EliminarPosNvector(vectorRaiz, PosN).clone();
        }else{
            System.out.println("ERROR en deletePosN, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso deletePosN Terminado");
    }
    
    
    
    /**
     * Descripcion: Insertar un valor en cualquier parte del vector
     *
     * @param	vaule Valor a Insertar
     * @param   pos Posicion a insertar el valor
     * @param   valRelleno Valor de relleno en el caso que se generen espacios vacios
     */
    public void InsertVaule(Long vaule, int pos, Long valRelleno){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
        //Existen 4 casos pa insertar valores
        int caso=0;
        if(pos>0 && pos<Longitud()){
            caso=1; //La posicion de inserccion esta dentro del vector
        }
        if(pos>=Longitud()){
            caso=2; //La posicion de inserccion esta a la derecha del vector
        }
        if(pos<=0){
            caso=3; //La posicion de inserccion esta a la izquierda del vector
        }
        
            //Caso en que el vector tiene longitud cero
            /*if(Longitud()==0){
                int[] nuevoVector= new int[valRelleno];
            }*/
            
            System.out.println("Tipo caso:"+caso);
            
            //Caso en que se va insertar dentro del vector
            if(caso==1){
                long[] vectorNuevo = new long[Longitud()+1];
            
                //Pasar Datos//
                for(int i=0; i<pos; i++){
                    vectorNuevo[i] = vectorRaiz[i];
                }
                vectorNuevo[pos] = vaule;
                
                for(int i=pos; i<Longitud(); i++){
                    vectorNuevo[1+i] = vectorRaiz[i];
                }
            
                //remplazar Vectores//
                vectorRaiz = vectorNuevo.clone();
            }
            
            //Caso en que se va insertar a la derecha del vector//
            if(caso==2){
                //Calcular cuanto va crecer el vector
                int crecimiento = pos-(Longitud()-1);
                long[] nuevoVector = new long[Longitud()+crecimiento];
                
                //PAsar los datos Originales
                for(int i=0; i<Longitud(); i++ ){
                    nuevoVector[i] = vectorRaiz[i];
                }
                
                //Pasar los demas datos de relleno y en el ultimo el dato vaule
                for(int i=Longitud(); i<Longitud()+crecimiento; i++){
                    if(i==Longitud()+crecimiento-1){
                        nuevoVector[i] = vaule;
                    }else{
                        nuevoVector[i] = valRelleno;
                    }
                }
                
                //Remplazamos el vector Raiz
                vectorRaiz = nuevoVector.clone();
            }
            
            //Caso en que se va insertar a la izquierda del vector//
            if(caso==3){
                //Calcular cuanto va crecer el vector
                int crecimiento = Math.abs(pos)+1;
                long[] nuevoVector = new long[Longitud()+crecimiento];
                
                //Agregar Vaule//
                nuevoVector[0] = vaule;
               
                //Agregar los valores de relleno//
                for(int i=1; i<crecimiento; i++){
                    nuevoVector[i] = valRelleno;
                }
                
                //Agregar los valores anteriores
                for(int i=0; i<Longitud(); i++){
                    nuevoVector[crecimiento+i] = vectorRaiz[i];
                }
                
                //Remplazamos el vector Raiz
                vectorRaiz = nuevoVector.clone();
            }
        }else{
            System.out.println("ERROR en InsertVaule, motivo: "+motivo);
	}
    //Terminar Proceso//
	System.out.println("Proceso InsertVaule Terminado");
    }
    
    
    
     /**
     * Descripcion: Obtener la suma de todos los elementos en el vector
     *
     * @return	0 a N
     */
    public long getSumaTotal(){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        long salida=0;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            long suma = 0;
            for(int i=0; i<Longitud(); i++){
                suma = suma +getValue(i, 0);
            }
            salida=suma;
	}else{
            System.out.println("ERROR en getSumaTotal, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
     /**
     * Descripcion: Convertir este vector a un vector de Enteros
     *
     * @return	null o Vector
     */
    public VectorInteger toVectorInteger (){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        VectorInteger salida=null;
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            salida = new VectorInteger();
            
            for(int i=0; i<Longitud(); i++){
                salida.addVauleRigth((int) getValue(i,0));
            }
	}else{
            System.out.println("ERROR en toVectorInteger, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
}
