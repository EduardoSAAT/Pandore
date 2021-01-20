/*
 * Pila Estatica de Matrices Dinamicas
 */
package DataStructure;
import Dinamic.MatrizString;

/**
 *
 * @author Ing Lalux
 */
public class PilaMatrizDinamic {
    public MatrizString[] Stack;
    public int Tope=-1;
    
    
    /**
     * Descripcion: Construir una pila, con un crecimiento maximo de 255 espacios//
     *
     */
    public PilaMatrizDinamic(){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            Stack = new MatrizString[255]; //Crear una Pila Inicial con 255 Matrices//
        
            for(int i=0; i<255; i++){
                Stack[i]=new MatrizString(1,1); //Crear cada matriz de 1x1//
                Stack[i].Inicializar(""); //Inicializar cada Matriz
            }
	}else{
            System.out.println("ERROR en Constructor: PilaMatrizDinamic, motivo: "+motivo+", valor regresado: "+salida);
        }
    }
    
    
    
    /**
     * Descripcion: Construir una Pila con un crecimiento Maximo Customizado
     *
     * @param	longitudMAX Longitud maxima que puede crecer la Pila
     */
    public PilaMatrizDinamic(int longitudMAX){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
    if(longitudMAX<=0){
        condiciones=false;
        motivo="No se puede tener una Pila de longitud Negativa";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            Stack = new MatrizString[longitudMAX]; //Crear una Pila Inicial con 255 Matrices//
        
            for(int i=0; i<longitudMAX; i++){
                Stack[i]=new MatrizString(1,1); //Crear cada matriz de 1x1//
                Stack[i].Inicializar(""); //Inicializar cada Matriz
            }
	}else{
            System.out.println("ERROR en Constructor: PilaMatrizDinamic, motivo: "+motivo+", valor regresado: "+salida);
	}
    }
    
    
    /**
     * Descripcion: Apilar Elementos a la Pila
     *
     * @param	Elemento Nuevo Elemento a Apilar
     */
    public void Apilar(MatrizString Elemento){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            Tope=Tope+1;
            Stack[Tope]=Elemento;
        }else{
            System.out.println("ERROR en Apilar, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
    /**
     * Descripcion: Desapila Elementos a la Pila
     *
     * @return Elemento Desapilado
     */
    public MatrizString Desapila(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
        MatrizString Salida = new MatrizString(1,1);
        Salida.Inicializar("");
    //Comprobar Condiciones Iniciales//
    if(this.Tope<0){
        condiciones=false;
        motivo="La pila esta Vacia!";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            Salida=Stack[Tope];
            //Colocar un Elemento Vacio en el tope que acabamos de desapilar//
                Stack[Tope] = new MatrizString(1,1);
                Stack[Tope].Inicializar("");
            Tope=Tope-1;
        }else{
            System.out.println("ERROR en Desapilar, motivo: "+motivo);
	}
    //Terminar Proceso//
	return Salida;
    }
    
    
    /**
     * Descripcion: Obtener la altura de la Pila
     *
     * @return	Int Altura de Pila
     */
    public int TamPila (){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=-1;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            salida=Tope;
	}else{
            System.out.println("ERROR en TamPila, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Obtener el elemento que esta en el Tope
     *
     * @return	String del Tope
     */
    public MatrizString VerTope (){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        MatrizString salida = new MatrizString(1,1);
        salida.Inicializar("");
    //Comprobar Condiciones Iniciales//
    if(Tope<0){
        return salida;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            if(Stack[Tope]!=null){
                salida=Stack[Tope];
            }
	}else{
            System.out.println("ERROR en VerTope, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
}
