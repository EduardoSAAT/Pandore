/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

import Algoritms.Cad;
import java.io.Serializable;

/**
 *
 * @author Ing Lalux
 */
public class Nodo implements Serializable{
    public String Element;
    public Nodo[] Hijos;
    
    
    /**
     * Descripcion: Crear un nuevo Nodo, con su valor
     *
     * @param	valor Valor del Elemento de este nodo
     */
    public Nodo(String valor){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            Element = valor;
	}else{
            System.out.println("ERROR en Constructor: Nodo, motivo: "+motivo);
	}
    }
    
    
    /**
     * Descripcion: Obtener el numero de hijos que tiene este nodo
     *
     * @return	0 en caso de ninguno O n en otro caso
     */
    public int numberSon (){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            if(Hijos==null){
                salida=0;
            }else{
                salida=Hijos.length;
            }
	}else{
            System.out.println("ERROR en numberSon, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Agregar un Hijo por la Derecha
     *
     * @param	valor Valor del Elemento de este nodo
     */
    public void addSonRigth(String valor){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Comprobar si existen hijos o el el primer hijo a agregar
            if(numberSon()==0){
                Hijos = new Nodo[1];
                Hijos[0] = new Nodo(valor);
            }else{
                //Pero si hay hijos, entonces aumentar el tamaño del vector de hijos
                Nodo[] nodoTemp = new Nodo[Hijos.length+1];
                
                for(int i=0; i<Hijos.length; i++){
                    nodoTemp[i] = Hijos[i];
                }
                nodoTemp[nodoTemp.length-1] = new Nodo(valor);
                
                //Remplazar el vector de Hijos paso por el nuevo
                Hijos = nodoTemp.clone();
            }
        }else{
            System.out.println("ERROR en addSonRigth, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso addSonRigth Terminado con EXITO");
    	}else{
            System.out.println("Proceso addSonRigth Terminado con FALLO");
    	}
    }
    
    
    /**
     * Descripcion: Agregar un Hijo por la Derecha
     *
     * @param	nodo a agregar por la derecha
     */
    public void addSonRigth(Nodo nodo){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Comprobar si existen hijos o el el primer hijo a agregar
            if(numberSon()==0){
                Hijos = new Nodo[1];
                Hijos[0] = nodo.Clone();
            }else{
                //Pero si hay hijos, entonces aumentar el tamaño del vector de hijos
                Nodo[] nodoTemp = new Nodo[Hijos.length+1];
                
                for(int i=0; i<Hijos.length; i++){
                    nodoTemp[i] = Hijos[i];
                }
                nodoTemp[nodoTemp.length-1] = nodo.Clone();
                
                //Remplazar el vector de Hijos paso por el nuevo
                Hijos = nodoTemp.clone();
            }
        }else{
            System.out.println("ERROR en addSonRigth, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso addSonRigth Terminado con EXITO");
    	}else{
            System.out.println("Proceso addSonRigth Terminado con FALLO");
    	}
    }
    
    
    
    /**
     * Descripcion: Eliminar un hojo de este Nodo
     *
     * @param	nSon Numero del Hijo a Eliminar
     */
    public void deleteSon(int nSon){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Comprobar si existen hijos o el el primer hijo a agregar
            if((numberSon()>0)&&(nSon>0)&&(nSon<=numberSon())){
                //Pero si hay hijos, entonces aumentar el tamaño del vector de hijos
                Nodo[] nodoTemp = new Nodo[Hijos.length-1];
                int xCount=0;
                for(int i=0; i<Hijos.length; i++){
                    if(nSon!=i+1){
                        nodoTemp[xCount] = Hijos[i];
                        xCount=xCount+1;
                    }
                }
                
                //Remplazar el vector de Hijos paso por el nuevo
                Hijos = nodoTemp.clone();
            }
        }else{
            System.out.println("ERROR en deleteSon, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso deleteSon Terminado con EXITO");
    	}else{
            System.out.println("Proceso deleteSon Terminado con FALLO");
    	}
    }
    
    
    
    /**
     * Descripcion: Remplazar el valor del elemento actual
     * 
     * @param   valNuevo Nuevo valor del Elemento de este Nodo
     *
     */
    public void remplazeThis(String valNuevo){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(valNuevo)){
        condiciones=false;
        motivo="Nuevo Elemento is null o vacio";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            Element=valNuevo;
        }else{
            System.out.println("ERROR en remplazeThis motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso remplazeThis Terminado con EXITO");
    	}else{
            System.out.println("Proceso remplazeThis Terminado con FALLO");
    	}
    }
    
    
    /**
     * Descripcion: Obtener un Hijo en especifico de este Nodo
     *
     * @param	numberSon numero de hijo que se hace referencia de 1 a N
     * @return	valores de retorno
     */
    public Nodo getSon(int numberSon){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        Nodo salida=null;
    //Comprobar Condiciones Iniciales//
    if((numberSon()<numberSon)||(numberSon<=0)){
        condiciones=false;
        motivo="El hijo: "+numberSon+" No existe en el Nodo: "+Element;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=Hijos[numberSon-1];
	}else{
            System.out.println("ERROR en getSon, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    private Nodo NodoClone;
     /**
     * Descripcion: Clonar este nodo, obtenido una copia exacta
     *
     * @return	null o Valor Valido
     */
    public Nodo Clone (){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        Nodo salida=null;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            NodoClone = new Nodo(Element);
            
            //Si tiene Hijos llamar a la funcion recursiva para meter hijos//
            for(int i=1; i<=numberSon(); i++){
                CloneRecursive(getSon(i),NodoClone);
            }
            
            salida = NodoClone;
	}else{
            System.out.println("ERROR en Clone, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Funcion de apoyo recursiva para clonar Nodos
     *
     * @param	Hijo Elemento a Meter en el padre
     * @param   Padre Nodo a recibir el elemento
     */
    private void CloneRecursive(Nodo Hijo, Nodo Padre){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Meter este Elemento//
            Padre.addSonRigth(Hijo.Element);
            
            //Obtener la ruta del nuevo padre, que fue el hijoPor la derecha anterior//
            Nodo nuevoNodo = Padre.getSon(Padre.numberSon());
            
            //Si tiene mas Hijos ese nodo, tambien meterlos
            for(int i=1; i<=Hijo.numberSon(); i++){
                CloneRecursive(Hijo.getSon(i),nuevoNodo);
            }
        }else{
            System.out.println("ERROR en CloneRecursive, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso CloneRecursive Terminado con EXITO");
    	}else{
            System.out.println("Proceso CloneRecursive Terminado con FALLO");
    	}
    }
    
    
    
    
    /**
     * Descripcion: Mostrar el nodo en consola
     *
     */
    public void showNode(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(this == null){
        condiciones=false;
        motivo="Nodo null";
    }else{
        if(Element==null){
            condiciones=false;
            motivo="Elemento null";
        }
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Llamar a la funcion recursiva desde el nodo raiz//
            printNodo(this,0);
        }else{
            System.out.println("ERROR en showNode, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso showNode Terminado con EXITO");
    	}else{
            System.out.println("Proceso showNode Terminado con FALLO");
    	}
    }
    
    
    /**
     * Descripcion: Funcion recursiva de utileria para Imprimir todos los Hijos del Arbol
     *
     * @param   nodo Nodo a imprimir sus Hijos en consola
     * @param   profundidad parametro pasa saber cuantos ─ agregar
     */
    private void printNodo(Nodo nodo, int profundidad){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Imprimri el Elemento de este nodo con su respectiva profundidad
            if(profundidad>0){
                if(profundidad==1){
                    System.out.println("└──"+nodo.Element);
                }else{
                    String linea = "└──";
                    for(int i=1; i<profundidad; i++){
                        linea="   "+linea;
                    }
                    
                    //Agregar las lineas verticales anteriores//
                    for(int i=linea.length()-3; i>0; i=i-3){
                        linea = Cad.remplazarPOS(linea, "│", i-3);
                    }
                    
                    System.out.println(linea+nodo.Element);
                }
            }else{
                System.out.println(nodo.Element);
            }
            
            
            //Comprobar si este nodo tiene mas hijos
            //Si es asi aplicar recursividad para cada uno de sis hijos//
            if(nodo.numberSon()>0){
                for(int i=0; i<nodo.numberSon(); i++){
                    printNodo(nodo.Hijos[i],profundidad+1);  
                }
            }
        }else{
            System.out.println("ERROR en printNodo, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso printNodo Terminado con EXITO");
        }else{
            System.out.println("Proceso printNodo Terminado con FALLO");
    	}
    }
    
    
}
