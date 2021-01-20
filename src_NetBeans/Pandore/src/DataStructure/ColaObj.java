/*
 * Cola Para manejas Objetos de Cualquier tipo
 * De forma Dinamica
 */
package DataStructure;

/**
 *  
 * @author Ing Lalux
 */
public class ColaObj implements Cloneable{
    Object[] ColaObjetos;
    int puntero; //Este puntero siempre apunta a la posicion siguiente vacia//
    
    
    
    public ColaObj clone()throws CloneNotSupportedException{
        ColaObj copia = (ColaObj)super.clone();
        return copia;
    }
    
    
    /**
     * Descripcion: Constructora de Nueva Estructura de Cola para Objetos
     *              No se define un tamaño Inicial
     */
    public ColaObj(){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            ColaObjetos = new Object[10];
            puntero=0;
	}else{
            System.out.println("ERROR en Constructor: ColaObj, motivo: "+motivo+", valor regresado: "+salida);
        }
    }
    
    
    /**
     * Descripcion: Constructora de Nueva Estructura de Cola para Objetos
     *
     * @param	longitudInicial Longitud Maxima Inicial 
     */
    public ColaObj(int longitudInicial){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            ColaObjetos = new Object[longitudInicial];
            puntero=0;
	}else{
            System.out.println("ERROR en Constructor: ColaObj, motivo: "+motivo+", valor regresado: "+salida);
        }
    }
    
    
    /**
     * Descripcion: Encolar un Objeto al final de la cola
     *              Siendo el ultimo hasta el momento en salir
     *
     * @param	Objeto Objeto a Encolar
     */
    public void EncolarFinal(Object Objeto){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    
	//Comenzar Proceso//
        if(condiciones==true){
            //Comprobar si ya se llego al limite la estructura de dato actual//
            if(puntero>=ColaObjetos.length){
                //si es haci Agrandar la Cola con 10 posiciones mas//
                Object[] nuevaCola = new Object[ColaObjetos.length+10];
                
                for(int i=0; i<ColaObjetos.length; i++){
                    nuevaCola[i]=ColaObjetos[i];
                }
                
                ColaObjetos=nuevaCola.clone();
            }
            
            ColaObjetos[puntero]=Objeto;
            puntero=puntero+1;
        }else{
            System.out.println("ERROR en Encolar, motivo: "+motivo);
	}
    //Terminar Proceso//
	System.out.println("Proceso Encolar Terminado");
    }
    
    
    
    /**
     * Descripcion: Encolar un Objeto al Inicio de la Cola
     *              convirtiendose en el primero en Salir
     *
     * @param	Objeto Objeto a Encolar
     */
    public void EncolarInicio(Object Objeto){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    
	//Comenzar Proceso//
        if(condiciones==true){
            //Crear una nueva cola//
            Object[] nuevaCola = new Object[ColaObjetos.length+1];
            
            nuevaCola[0]=Objeto;
            for(int i=1; i<=ColaObjetos.length; i++){
                nuevaCola[i]=ColaObjetos[i-1];
            }
            
            //Sustituir la cola Vieja
                ColaObjetos = nuevaCola.clone();
                puntero++;
        }else{
            System.out.println("ERROR en Encolar, motivo: "+motivo);
	}
    //Terminar Proceso//
	System.out.println("Proceso Encolar Terminado");
    }
    
    
    
     /**
     * Descripcion: Desencolar Objetos de la Cola en modo FIFO
     *
     * @return	Objeto que estaba Primero
     * @throws  CloneNotSupportedException Error a mostrar en caso de error
     */
    public Object Desencolar () throws CloneNotSupportedException{
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        Object salida=null;
    //Comprobar Condiciones Iniciales//
    if(ColaObjetos==null){
        condiciones=false;
        motivo="La cola es NULL";
    }else{
        if(TamCola()==0){
            condiciones=false;
            motivo="No hay Objetos en la Cola";
        }
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=ColaObjetos[0];
            
            //Reestructurar la cola//
            for(int i=1; i<puntero; i++){
                ColaObjetos[i-1]=ColaObjetos[i];
            }
            puntero--;
	}else{
            System.out.println("ERROR en Desencolar, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Desencolar un elemento Especifico
     *
     * @param Posicion posicion del Objeto a Desencolar
     * @return	Objeto que estaba Primero
     * @throws java.lang.CloneNotSupportedException Error
     */
    public Object Desencolar (int Posicion) throws CloneNotSupportedException{
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        Object salida=null;
    //Comprobar Condiciones Iniciales//
    if(ColaObjetos==null){
        condiciones=false;
        motivo="La cola es NULL";
    }else{
        if(TamCola()==0){
            condiciones=false;
            motivo="No hay Objetos en la Cola";
        }
    }
    if(Posicion>=TamCola()){
        condiciones=false;
        motivo="Posicion no Existe";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=ColaObjetos[Posicion];
            
            //Reestructurar la cola//
            int x=0;
            for(int i=0; i<puntero-1; i++){
                if(x==Posicion){
                    x=x+1;
                }
                ColaObjetos[i]=ColaObjetos[x];
                x=x+1;
            }
            puntero--;
	}else{
            System.out.println("ERROR en Desencolar, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener el Tamaño de la Cola
     *
     * @return	[0-n];
     */
    public int TamCola(){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            //como el puntero siempre indica la posicion siguiente vacia e inicia en 0 entonces es el mismo tamCola
            salida=puntero;
	}else{
            System.out.println("ERROR en TamCola, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Desencolar Objetos de la Cola en modo FIFO
     *
     * @param   Posicion Consultar Un pobjeto en una cierta Posicion
     * @return	Objeto que estaba Primero
     * @throws java.lang.CloneNotSupportedException Error
     */
    public Object Consultar (int Posicion) throws CloneNotSupportedException{
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        Object salida=null;
    //Comprobar Condiciones Iniciales//
    if(ColaObjetos==null){
        condiciones=false;
        motivo="La cola es NULL";
    }else{
        if(TamCola()==0){
            condiciones=false;
            motivo="No hay Objetos en la Cola";
        }
        
        if(((Posicion>=0)&&(Posicion<TamCola()))==false){
            condiciones=false;
            motivo="posicion no Existe en la Cola";
        }
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //salida=ColaObjetos[Posicion];
            Object ob = ColaObjetos[Posicion];
            
            salida = ob;
	}else{
            System.out.println("ERROR en Consultar, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
}
