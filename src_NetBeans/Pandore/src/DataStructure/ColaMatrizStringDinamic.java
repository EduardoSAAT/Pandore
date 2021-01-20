/*
 * Cola Estatica de Matrices Dinamicas de Strings
 */
package DataStructure;
import Dinamic.MatrizString;
/**
 *
 * @author Ing Lalux
 */
public class ColaMatrizStringDinamic {
    public MatrizString[] Cola;
    public int puntero=-1;
    
    
    /**
     * Descripcion: Crear una Cola de un Crecimiento Maximo de 255 Elementos
     *
     */
    public ColaMatrizStringDinamic(){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            Cola=new MatrizString[255];
            
            for(int i=0; i<255; i++){
                Cola[i] = new MatrizString(1,1);
                Cola[i].Inicializar("");
            }
	}else{
            System.out.println("ERROR en Constructor: ColaMAtrizStringDinamic, motivo: "+motivo+", valor regresado: "+salida);
        }
    }
    
    
    
    /**
     * Descripcion: Crear una Cola de un Crecimiento Maximo Custom
     *
     * @param longitudMAX Longitud Maxima que puede tener la Cola
     */
    public ColaMatrizStringDinamic(int longitudMAX){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
    if(longitudMAX<0){
        condiciones=false;
        motivo="No se puede tener longitud Negativa";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            Cola=new MatrizString[longitudMAX];
            
            for(int i=0; i<longitudMAX; i++){
                Cola[i] = new MatrizString(1,1);
                Cola[i].Inicializar("");
            }
	}else{
            System.out.println("ERROR en Constructor: ColaMAtrizStringDinamic, motivo: "+motivo+", valor regresado: "+salida);
        }
    }
    
    
    
    
    /**
     * Descripcion: Encolar un Elemento
     *
     * @param	Elemento Elemento a Encolar
     */
    public void Encolar(MatrizString Elemento){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(Elemento==null){
        condiciones=false;
        motivo="No se puede encolar un Elemento NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            puntero=puntero+1;
            Cola[puntero]=Elemento;
        }else{
            System.out.println("ERROR en Encolar, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso Encolar Terminado");
    }
    
    
    
     /**
     * Descripcion: Desencolar un elemento de la Cola
     *
     * @return	Elemento siguiente de la Cola
     */
    public MatrizString DesEncolar (){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        MatrizString salida=null;
    //Comprobar Condiciones Iniciales//
    if(this.LongitudCola()<=0){
        condiciones=false;
        motivo="No hay Elementos en la Cola";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=Cola[puntero];
            puntero=puntero-1;
	}else{
            System.out.println("ERROR en DesEncolar, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Saber cuantos elementos tiene la cola actualmente
     *
     * @return	0 o N
     */
    public int LongitudCola(){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            if(puntero<0){
                salida=0;
            }else{
                salida=puntero+1;
            }
	}else{
            System.out.println("ERROR en LongitudCola, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
}
