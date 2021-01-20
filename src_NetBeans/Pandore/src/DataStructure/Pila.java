/*
 * Pila Estatica de 255 posiciones Maximas
 */
package DataStructure;

/**
 *
 * @author Ing Lalux
 */
public class Pila {
    public String[] Stack;
    public int Tope=-1;
    
    
    //El crecimiento Maximo de la Pila se Fija en 255//
    public Pila(){
        Stack = new String[255];
        
        for(int i=0; i<255; i++){
            Stack[i]="";
        }
    }

    
    //Definir una longitud Maxima que puede Crecer la Pila
    public Pila(int Longitud) {
        Stack = new String[Longitud];
        
        for(int i=0; i<Longitud; i++){
            Stack[i]="";
        }
    }
    
    
    
    /**
     * Descripcion: Apilar Elementos a la Pila
     *
     * @param	Elemento Nuevo Elemento a Apilar
     */
    public void Apilar(String Elemento){
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
    public String Desapila(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
        String Salida="";
    //Comprobar Condiciones Iniciales//
    if(this.Tope<0){
        condiciones=false;
        motivo="La pila esta Vacia!";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            Salida=Stack[Tope];
            Stack[Tope]="";
            Tope=Tope-1;
        }else{
            System.out.println("ERROR en Desapilar, motivo: "+motivo);
	}
    //Terminar Proceso//
	return Salida;
    }
    
    
    
    /**
     * Descripcion: Obtener el elemento que esta en el Tope
     *
     * @return	String del Tope
     */
    public String VerTope (){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
    if(Tope<0){
        return "";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            if(Stack[Tope]==null){
                salida="";
            }else{
                salida=Stack[Tope];
            }
	}else{
            System.out.println("ERROR en VerTope, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
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
     * Descripcion: Convierte la Pila en una Cadena
     *
     * @param   separador Separador entre elementos de la Pila
     * @return	valores de retorno
     */
    public String convetToCadena (String separador){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<=this.TamPila(); i++){
                salida=salida.concat(this.Stack[i])+separador;
            }
	}else{
            System.out.println("ERROR en convetToCadena, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
}
