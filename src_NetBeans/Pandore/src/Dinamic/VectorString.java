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
public class VectorString implements Serializable{
    public String[] vectorRaiz;
    private int Longitud=0;
    
    
    
    
    
    /**
     * Descripcion: Crear un Vector de Strings
     *
     * @param	VS vectorString, para hacer un clon
     */
    public VectorString(VectorString VS){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(VS ==null){
        condiciones=false;
        motivo="VectorString null";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            vectorRaiz= new String[0];
            Longitud=0;
            
            for(int i=0; i<VS.Longitud();i++){
                addVauleRigth(VS.getValue(i,"ERROR"));
            }
        }else{
            System.out.println("ERROR en Constructor VectorString, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso VectorString Terminado");
    }
    
    
    /**
     * Descripcion: Crear un Vector de Strings
     *
     * @param	vector  vectorString, para hacer un clon
     */
    public VectorString(String [] vector){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(vector ==null){
        condiciones=false;
        motivo="VectorString null";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            vectorRaiz = new String[vector.length];
            Longitud = vector.length;
            for(int i=0; i<vector.length; i++){
                vectorRaiz[i] = vector[i];
            }
        }else{
            System.out.println("ERROR en Constructor VectorString, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso VectorString Terminado");
    }
    
    
    /**
     * Descripcion: Crear un Vector de Strings
     *
     * @param	longitudInicial MayorIgual 0;
     */
    public VectorString(int longitudInicial){
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
            vectorRaiz= new String[longitudInicial];
            Longitud=0;
        }else{
            System.out.println("ERROR en Constructor VectorString, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso VectorString Terminado");
    }
    
    
    /**
     * Descripcion: Inicializar el vector con un valor especifico
     *
     * @param	Vaule Valor a Tener en todas las Casillas
     */
    public void Inicializar(String Vaule){
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
     * Descripcion: Agregar un valor al Vector en una posicion que exista
     *
     * @param	Pos Posicion que exista donde poner Valor
     * @param   Vaule String Cualquiera
     */
    public void setVaule(int Pos, String Vaule){
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
    public void setVauleForce(int Pos, String Vaule, String valRelleno){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    
    String vecTemp[];
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
                    vecTemp = new String [Longitud+diferencia];
                    
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
                    vecTemp = new String[Longitud+diferencia];
                    
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
            vectorRaiz=Dimention.EliminarPosNvector(vectorRaiz, PosN);
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
            Dimention.ImprimirVector(vectorRaiz,separador);
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
    public void addVauleLefth (String Vaule){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            String[] vectorTemporal = new String[Longitud+1];
            
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
     * Descripcion: Agregar un valor a la derecha del vector creando una posicion nueva
     *
     * @param	Vaule Valor a agregar
     */
    public void addVauleRigth (String Vaule){
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
     * @param   error Valor a Obtner en Caso de Error
     * @return	valores de retorno
     */
    public String getValue (int posicion, String error){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=error;
    //Comprobar Condiciones Iniciales//
    if(vectorRaiz==null){
        condiciones=false;
        motivo="El vector es NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            if((posicion>=Longitud)||(posicion<0)){
                //El valor de error de la salida
            }else{
                salida=vectorRaiz[posicion];
                
                //Comprobar si en esa posicion existe algun valor o es null
                if(salida==null){
                    salida=error; //Si es asi, entonces mandar error
                }
            }
	}else{
            System.out.println("ERROR en getValue, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener el elemento que se paresca a un ElementLike
     * @param	ElementLike Elemento que contiene caracter de variacion
     * @param   caracterVariacion Caracter de variacion
     * @param   ignoreCase True Ignora
     * @return	null o valor
     */
    public String getValueLike (String ElementLike, String caracterVariacion, boolean ignoreCase){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
    if(vectorRaiz==null){
        condiciones=false;
        motivo="El vector es NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            int posVaule = posValueLike(ElementLike, caracterVariacion, ignoreCase);
            
            if(posVaule!=-1){
                salida=getValue(posVaule, null);
            }
	}else{
            System.out.println("ERROR en getValueLike, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtenerla posicion de un Determinado Valor
     *
     * @param	Element  Elemento a buscar en el vector
     * @param   ignoreCase True ignora case, false lo usa
     * @return	-1 error, 0 a n
     */
    public int posValue (String Element, boolean ignoreCase){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=-1;
    //Comprobar Condiciones Iniciales//
    if(vectorRaiz==null){
        condiciones=false;
        motivo="El vector es NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            String temp;
            for(int i=0; i<Longitud; i++){
                temp = vectorRaiz[i];
                
                if(ignoreCase==true){
                    if(temp.equalsIgnoreCase(Element)){
                        salida=i;
                        i=Longitud;
                    }
                }else{
                    if(temp.equals(Element)){
                        salida=i;
                        i=Longitud;
                    }
                }
            }
	}else{
            System.out.println("ERROR en posValue, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Concatenar vectores de Strings
     *
     * @param	vector Vector a concatenar a la derecha
     */
    public void concatRigth(VectorString vector){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vector.Longitud; i++){
                addVauleRigth(vector.getValue(i,"ERROR en concarRIGTH"));
            }
        }else{
            System.out.println("ERROR en concatRigth, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso concatRigth Terminado con EXITO");
    	}else{
            System.out.println("Proceso concatRigth Terminado con FALLO");
    	}
    }
    
    
    
     /**
     * Descripcion: Obtener la primer posicion de coincidencia de un valor
     *
     * @param	ElementLike   Elemento a buscar en el vector
     * @param   caracterVariacion Caracter que varia en la Cadena
     * @param   ignoreCase True ignora case, false lo usa
     * @return	-1 error, 0 a n
     */
    public int posValueLike (String ElementLike, String caracterVariacion, boolean ignoreCase){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=-1;
    //Comprobar Condiciones Iniciales//
    if(vectorRaiz==null){
        condiciones=false;
        motivo="El vector es NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            String temp;
            for(int i=0; i<Longitud; i++){
                temp = vectorRaiz[i];
                
                if(ignoreCase==true){
                    if(Cad.LikeA(temp, ElementLike, caracterVariacion)){
                        salida=i;
                        i=Longitud;
                    }
                }else{
                    if(Cad.LikeA(temp, ElementLike, caracterVariacion)){
                        salida=i;
                        i=Longitud;
                    }
                }
            }
	}else{
            System.out.println("ERROR en posValue, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener la posicion del algun valor en su repeticion N
     *
     * @param	Element  Elemento a buscar en el vector
     * @param   repeticionN Numero de repeticion del mismo Element
     * @param   afterNpos Buscar repeticion a partir de una N posicion en el Vector
     *                    Asi por ejemplo  [hola][mundo][hola][hola]
     *                    2 Hola a partir de 0 = 2
     *                    2 Hola a partir de 2 = 3
     *                    2 Hola a partir de 3 = -1
     * @param   ignoreCase True ignora case, false lo usa
     * @return	-1 error, 0 a n
     */
    public int posValueN (String Element, int repeticionN, int afterNpos, boolean ignoreCase){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=-1;
    //Comprobar Condiciones Iniciales//
    if(vectorRaiz==null){
        condiciones=false;
        motivo="El vector es NULL";
    }
    if(Element==null){
        condiciones=false;
        motivo="Element es null";
    }
    if(afterNpos>=Longitud){
        condiciones=false;
        motivo="AfterPos MayorIGual a la longitud";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            int numRepeat = 0;
            String temp=null;
            for(int i=afterNpos; i<Longitud; i++){
                temp=getValue(i,"ERROR");
                if(ignoreCase==true){
                    if(temp.equalsIgnoreCase(Element)){
                        numRepeat = numRepeat+1;
                        
                        if(numRepeat == repeticionN){
                            salida=i;
                            i=Longitud;
                        }
                    }
                }else{
                    if(temp.equals(Element)){
                        numRepeat = numRepeat+1;
                        
                        if(numRepeat == repeticionN){
                            salida=i;
                            i=Longitud;
                        }
                    }
                }
                
            }
	}else{
            System.out.println("ERROR en posValueN, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
    
    /**
     * Descripcion: Eliminar Elementos Repetidos del Vector, dejando solo el primero 
     * 
     * @param   IgnoreCase Ignorar Case para coincidir elementos y eliminarlos
     *
     */
    public void DeleteRepetidos(boolean IgnoreCase){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            //Para todos los elementos
            String elemento="";
            for(int i=0 ; i<Longitud(); i++){
                //Tomar el primer elemento
                elemento = getValue(i,"ERROR en funcion DeleteRepetidos");
                
                //Buscar en todos los elementos siguientes si existen repetidos para eliminarlos//
                for(int x=i+1; x<Longitud(); x++){
                    if(Cad.Equals(getValue(x,"ERROR en funcion DeleteRepetidos"), elemento, IgnoreCase)){
                        deletePosN(x);
                        x=x-1;
                    }
                }
            }
        }else{
            System.out.println("ERROR en DeleteRepetidos, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso DeleteRepetidos Terminado");
    }
    
    
    
    
    
    /**
     * Descripcion: Ordenar los String por una subcadena que se encuentra entre una CadA y una CadB
     *      EJM: Metodo de Ordenamiento Burbuja
     *      Elementos: "Hola var1(2) var2(abc), Como var1(1) var2(abd)"
     *      Order By "var1(", ")", true 
     *      Salida: "Como var1(1) var2(abd), Hola var1(2) var2(abc)"
     * 
     * @param	CadA Separador Inicial, no cuentan en el orden
     * @param   CadB Separador Final, no cuentan en el orden
     * @param   MenorMayor Si se ordena de menor a mayor o alreves
     */
    public void OrderBy_SubstringCadACadB(String CadA, String CadB, boolean MenorMayor){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<Longitud; i++){
                for(int x=0; x<Longitud-1; x++){
                    String elementoAnterior = getValue(x,"ERROR");
                    String elementoAnteriorVaule = Cad.subCadCadACadB(elementoAnterior, CadA, CadB);
                        
                    String elementoSiguiente = getValue(x+1,"ERROR");
                    String elementoSiguienteVaule = Cad.subCadCadACadB(elementoSiguiente,CadA,CadB);
                        
                    
                    //Elejir MModo de ordenamiento
                    if(MenorMayor){
                        //Ver si el ElementoSiguiente es menor al elemento anterior para hacer el cambio//
                        if(Cad.compararOrdenABC(elementoAnteriorVaule, elementoSiguienteVaule)==2){
                            setVaule(x+1, elementoAnterior);
                            setVaule(x,elementoSiguiente);
                        }
                    }else{
                        //Ver si el ElementoSiguiente es mayor al elemento anterior para hacer el cambio//
                        if(Cad.compararOrdenABC(elementoAnteriorVaule, elementoSiguienteVaule)==1){
                            setVaule(x+1, elementoAnterior);
                            setVaule(x,elementoSiguiente);
                        }
                    }
                }
            }
        }else{
            System.out.println("ERROR en OrderBy_SubstringCadACadB, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso OrderBy_SubstringCadACadB Terminado con EXITO");
    	}else{
            System.out.println("Proceso OrderBy_SubstringCadACadB Terminado con FALLO");
    	}
    }
    
    
    /**
     * Descripcion: Ordenar los String por una subcadena que se encuentra entre una CadA y una CadB con Typificacion de Datos
     *      EJM: Metodo de Ordenamiento Burbuja
     *      Elementos: "Hola var1(2) var2(abc), Como var1(1) var2(abd)"
     *      Order By "var1(", ")", true , "Fecha"
     *      Salida: "Como var1(1) var2(abd), Hola var1(2) var2(abc)"
     * 
     * @param	CadA Separador Inicial, no cuentan en el orden
     * @param   CadB Separador Final, no cuentan en el orden
     * @param   Type Tipo de Dato Fecha, Numero, Alfanumerico
     * @param   MenorMayor Si se ordena de menor a mayor o alreves
     */
    public void OrderByType_SubstringCadACadB(String CadA, String CadB, String Type, boolean MenorMayor){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(Cad.numOfContains(Type,BloqueOrder.Tipos,",")<=0){
        condiciones=false;
        motivo="El tipo de Dato:"+Type+" no pertenece a:"+BloqueOrder.Tipos;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<Longitud; i++){
                for(int x=0; x<Longitud-1; x++){
                    String elementoAnterior = getValue(x,"ERROR");
                    String elementoAnteriorVaule = Cad.subCadCadACadB(elementoAnterior, CadA, CadB);
                        
                    String elementoSiguiente = getValue(x+1,"ERROR");
                    String elementoSiguienteVaule = Cad.subCadCadACadB(elementoSiguiente,CadA,CadB);
                        
                    
                    //Elejir Modo de ordenamiento
                    
                    if(Type.equalsIgnoreCase("Fecha")){
                        if(MenorMayor){
                            //Ver si el ElementoSiguiente es menor al elemento anterior para hacer el cambio//
                            if(time.AlgoritmsT.compareFechas(elementoAnteriorVaule, elementoSiguienteVaule,">")){
                                setVaule(x+1, elementoAnterior);
                                setVaule(x,elementoSiguiente);
                            }
                        }else{
                            //Ver si el ElementoSiguiente es mayor al elemento anterior para hacer el cambio//
                            if(time.AlgoritmsT.compareFechas(elementoAnteriorVaule, elementoSiguienteVaule,"<")){
                                setVaule(x+1, elementoAnterior);
                                setVaule(x,elementoSiguiente);
                            }
                        }
                    }
                    
                    if(Type.equalsIgnoreCase("Numero")||Type.equalsIgnoreCase("Alfanumerico")||Type.equalsIgnoreCase("Alfabeto")){
                        if(MenorMayor){
                            //Ver si el ElementoSiguiente es menor al elemento anterior para hacer el cambio//
                            if(Cad.compararOrdenABC(elementoAnteriorVaule, elementoSiguienteVaule)==2){
                                setVaule(x+1, elementoAnterior);
                                setVaule(x,elementoSiguiente);
                            }
                        }else{
                            //Ver si el ElementoSiguiente es mayor al elemento anterior para hacer el cambio//
                            if(Cad.compararOrdenABC(elementoAnteriorVaule, elementoSiguienteVaule)==1){
                                setVaule(x+1, elementoAnterior);
                                setVaule(x,elementoSiguiente);
                            }
                        }
                    }
                }
            }
        }else{
            System.out.println("ERROR en OrderByType_SubstringCadACadB, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso OrderByType_SubstringCadACadB Terminado con EXITO");
    	}else{
            System.out.println("Proceso OrderByType_SubstringCadACadB Terminado con FALLO");
    	}
    }
    
    
    
    /**
     * Descripcion: Ordenar los String por una subcadena que se encuentra entre una CadA y una CadB con Typificacion de Datos
     *      EJM: Metodo de Ordenamiento Burbuja
     *      Elementos: "Texto1 P(Alta), Texto2 P(Baja), Texto3(Media)"
     *      Order By "P(", ")", "Custom", [Alta,Media,Baja], true
     *      Salida: "Texto1 P(Alta), Texto3(Media), Texto2 P(Baja)"
     * 
     * @param	CadA Separador Inicial, no cuentan en el orden
     * @param   CadB Separador Final, no cuentan en el orden
     * @param   Type Tipo de Dato Fecha, Numero, Alfanumerico
     * @param   CustomTipe Tipo de elementos custom ejm: Alta,Media,Baja
     * @param   MenorMayor Si se ordena de menor a mayor o alreves
     */
    public void OrderByType_SubstringCadACadB(String CadA, String CadB, String Type, VectorString CustomTipe,boolean MenorMayor){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(Cad.numOfContains(Type.toUpperCase(),BloqueOrder.Tipos,",")<=0){
        condiciones=false;
        motivo="El tipo de Dato:"+Type+" no pertenece a:"+BloqueOrder.Tipos;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<Longitud; i++){
                for(int x=0; x<Longitud-1; x++){
                    String elementoAnterior = getValue(x,"ERROR");
                    String elementoAnteriorVaule = Cad.subCadCadACadB(elementoAnterior, CadA, CadB);
                        
                    String elementoSiguiente = getValue(x+1,"ERROR");
                    String elementoSiguienteVaule = Cad.subCadCadACadB(elementoSiguiente,CadA,CadB);
                        
                    
                    //Elejir Modo de ordenamiento
                    
                    if(Type.equalsIgnoreCase("Fecha")){
                        if(MenorMayor){
                            //Ver si el ElementoSiguiente es menor al elemento anterior para hacer el cambio//
                            if(time.AlgoritmsT.compareFechas(elementoAnteriorVaule, elementoSiguienteVaule,">")){
                                setVaule(x+1, elementoAnterior);
                                setVaule(x,elementoSiguiente);
                            }
                        }else{
                            //Ver si el ElementoSiguiente es mayor al elemento anterior para hacer el cambio//
                            if(time.AlgoritmsT.compareFechas(elementoAnteriorVaule, elementoSiguienteVaule,"<")){
                                setVaule(x+1, elementoAnterior);
                                setVaule(x,elementoSiguiente);
                            }
                        }
                    }
                    
                    if(Type.equalsIgnoreCase("Numero")||Type.equalsIgnoreCase("Alfanumerico")||Type.equalsIgnoreCase("Alfabeto")){
                        if(MenorMayor){
                            //Ver si el ElementoSiguiente es menor al elemento anterior para hacer el cambio//
                            if(Cad.compararOrdenABC(elementoAnteriorVaule, elementoSiguienteVaule)==2){
                                setVaule(x+1, elementoAnterior);
                                setVaule(x,elementoSiguiente);
                            }
                        }else{
                            //Ver si el ElementoSiguiente es mayor al elemento anterior para hacer el cambio//
                            if(Cad.compararOrdenABC(elementoAnteriorVaule, elementoSiguienteVaule)==1){
                                setVaule(x+1, elementoAnterior);
                                setVaule(x,elementoSiguiente);
                            }
                        }
                    }
                    
                    
                    if(Type.equalsIgnoreCase("Custom")){
                        int valorElementoAnterior = CustomTipe.posValue(elementoAnteriorVaule,false);
                        int valorElementoSiguiente = CustomTipe.posValue(elementoSiguienteVaule, false);
                        
                        if(MenorMayor){
                            //Ver si el ElementoSiguiente es menor al elemento anterior para hacer el cambio//
                            if(valorElementoAnterior<valorElementoSiguiente){
                                setVaule(x+1, elementoAnterior);
                                setVaule(x,elementoSiguiente);
                            }
                        }else{
                            //Ver si el ElementoSiguiente es mayor al elemento anterior para hacer el cambio//
                            if(valorElementoAnterior>valorElementoSiguiente){
                                setVaule(x+1, elementoAnterior);
                                setVaule(x,elementoSiguiente);
                            }
                        }
                    }
                    
                    
                }
            }
        }else{
            System.out.println("ERROR en OrderByType_SubstringCadACadB, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso OrderByType_SubstringCadACadB Terminado con EXITO");
    	}else{
            System.out.println("Proceso OrderByType_SubstringCadACadB Terminado con FALLO");
    	}
    }
    
    
    
    
    /**
     * Descripcion: Ordenar el Vector por Bloques usando sus subcadenas
     *      Metodo de Ordenamiento Burbuja
     *      Se conserva el primer ordenamiento, y esos bloques ordenados se ordenan con el criterio del bloque2
     *     
     *  EJM:Elementos: "Hola var1(2) var2(B), Como var1(1) var2(A), Loco var1(3) var2(A), Perro var1(4) var2(B)"
     *      Bloque1 = "var1("  ")"  Menor2Mayor = true
     *      Bloque2 = "var2("  ")"  Menor2Mayor = true
     *      Salida:  Como var1(1) var2(A)
     *               Hola var1(2) var2(B)
     *               Loco var1(3) var2(A)
     *               Perro var1(4) var2(B)
     * 
     * @param	bloque1 Ordenamiento por Bloque1
     * @param   bloque2 Ordenamiento por Bloque2
     * 
     */
    public void OrderBy_Bloques(BloqueOrder bloque1, BloqueOrder bloque2){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Ordenar por el primer bloque//
            OrderByType_SubstringCadACadB(bloque1.CadenaA, bloque1.CadenaB, bloque1.Type, bloque1.CustomType, bloque1.Menor2Mayor);
            
            //Obtener Todos los criterios del primer bloque de todo el Vector//
            VectorString Elementos = new VectorString(0);
            String valTemp ="";
            for(int i=0; i<Longitud(); i++){
                valTemp = getValue(i,"ERROR en OrderByBloques.....");
                valTemp = Cad.subCadCadACadB(valTemp, bloque1.CadenaA, bloque1.CadenaB);
                Elementos.addVauleRigth(valTemp);
            }
                //Eliminar los Valores Repetidos de criterios//
                Elementos.DeleteRepetidos(true);
            
            
            //Separar en bloques, tantos como criterios//
            VectorString[] VectorVectores = new VectorString[Elementos.Longitud()];
            for(int i=0; i<Elementos.Longitud(); i++){
                VectorVectores[i] = new VectorString(0);
            }
            
            VectorString vectTemp = new VectorString(0);
            String CriterioActual="";
            
            
            
            //Meter todos los valores del mismo criterio en un vector del vector del vectores//
            for(int c=0; c<Elementos.Longitud(); c++){
                //Obtener el primer criterio hasta el ultimo
                CriterioActual = Elementos.getValue(c,"ERROR");
                
                //Para todas las actividades
                for(int e=0; e<Longitud(); e++){
                    //comprobar si pertenecen al criterio actual//
                    String valor = getValue(e,"ERROR");
                    String criterioValor = Cad.subCadCadACadB(valor, bloque1.CadenaA, bloque2.CadenaB);
                    
                    if(Cad.Equals(CriterioActual,criterioValor,false)){
                        //Si es asi, meterlo en el vector actual del vector de vectores
                        VectorVectores[c].addVauleRigth(valor);
                    }
                }
            }
            
                
            //Ordenar los subvectores bajo el segundo Criterio//
            for(int i = 0; i<VectorVectores.length-1; i++){
                VectorVectores[i].OrderByType_SubstringCadACadB(bloque2.CadenaA, bloque2.CadenaB,bloque2.Type, bloque2.CustomType, bloque2.Menor2Mayor);
            }
            
            //concatenar subBloques
            VectorString vectorComplete = new VectorString(0);
            for(int i=0; i<VectorVectores.length; i++){
                vectorComplete.concatRigth(VectorVectores[i]);
            }
            
            
            Longitud = vectorComplete.Longitud;
            vectorRaiz = vectorComplete.vectorRaiz;
        }else{
            System.out.println("ERROR en OrderBy_Bloques, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso OrderBy_Bloques Terminado con EXITO");
    	}else{
            System.out.println("Proceso OrderBy_Bloques Terminado con FALLO");
    	}
    }
    
    
    
     /**
     * Descripcion: Obtener la coleccion de elementos que se encuentren entre una CadenaA y una CadenaB
     *              de todos los Strings del vector
     *
     * @param CadA Cadena inicial
     * @param CadB Cadena Final
     * 
     * @return	null o VectorString
     */
    public VectorString getElements_CadACadB(String CadA, String CadB){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        VectorString salida=null;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            salida = new VectorString(0);
            String cadenaTemp;
            for(int i = 0; i<Longitud(); i++){
                cadenaTemp = Cad.subCadCadACadB(getValue(i,"ERROR en funcion interna de getElements_CadACadB"),CadA,CadB);
                if(cadenaTemp != null){
                    salida.addVauleRigth(cadenaTemp);
                }
            }
	}else{
            System.out.println("ERROR en getElements_CadACadB, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
    
     /**
     * Descripcion: Crear un VectorString clon de estos elementos con otra direccion de memoria
     *
     * @return	null o VectorString
     */
    public VectorString Clonar (){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        VectorString salida=null;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            salida = new VectorString(0);
            
            for(int i=0; i<Longitud(); i++){
                salida.addVauleRigth(getValue(i,"ERROR"));
            }
	}else{
            System.out.println("ERROR en Clonar, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Ordenar el Vector por Bloques usando sus subcadenas
     *      Metodo de Ordenamiento Burbuja
     *      Se conserva el primer ordenamiento, y esos bloques ordenados se ordenan con el criterio del bloque2
     *     
     *  EJM:Elementos: "Hola var1(2) var2(B), Como var1(1) var2(A), Loco var1(3) var2(A), Perro var1(4) var2(B)"
     *      Bloque1 = "var1("  ")"  Menor2Mayor = true
     *      Bloque2 = "var2("  ")"  Menor2Mayor = true
     *      Salida:  Como var1(1) var2(A)
     *               Hola var1(2) var2(B)
     *               Loco var1(3) var2(A)
     *               Perro var1(4) var2(B)
     * 
     * @param	bloques  Conjunto de Bloques para hacer ordenamiento
     * 
     */
    /*public void OrderBy_Bloques(BloqueOrder[] bloques){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Crear la estructura de ordenamiento//
            int LongMultiVector = 1;
            VectorString[] Multivector = new VectorString[LongMultiVector];
            Multivector[0] = new VectorString(vectorRaiz);
            
            //Para todos los bloques//
            for(int i = 0; i<bloques.length; i++){
                //Tomar el bloque de bloque actual//
                BloqueOrder bloqueActual = bloques[i];
                
                //Ordenar todos los vectores por el criterio
                for(int x = 0; x<LongMultiVector; x++){
                    Multivector[x].OrderByType_SubstringCadACadB(
                            bloqueActual.CadenaA, 
                            bloqueActual.CadenaB, 
                            bloqueActual.Type, 
                            bloqueActual.CustomType, 
                            bloqueActual.Menor2Mayor);
                }
                
                //Hacer la separacion del conjunto de vectores en mas vectores//
                    //Calcular cuentos nuevos vectores se tienen que hacer//
                    int countNewVectors = 0;
                    for(int x = 0; x<LongMultiVector; x++){
                        VectorString temp = Multivector[x].getElements_CadACadB(bloqueActual.CadenaA,bloqueActual.CadenaB);
                        temp.DeleteRepetidos(false);
                        countNewVectors = countNewVectors + temp.Longitud();
                    }
                    System.out.println("Vectores del Multivector:"+Multivector.length);
                    System.out.println("Nuevos Vectores Resultantes:"+countNewVectors);
                    
                    //Crear el nuevo Multivector//
                    VectorString[] newMultivecVector = new VectorString[countNewVectors];
                    for(int e=0; e<countNewVectors; e++){
                        newMultivecVector[e] = new VectorString(0);
                    }
                    
                    //Agrupar todos los Vectores anteriores en uno solo para recorrerlo mas facil//
                    VectorString vectorViejo = new VectorString(0);
                        //Para todo los vectores//
                        for(int x = 0; x<LongMultiVector; x++){
                            //Para todos los Strings
                            for(int y= 0; y<Multivector[x].Longitud(); y++){
                                vectorViejo.addVauleRigth(Multivector[x].getValue(y,"ERROR interno en Funcion OrderBy_Bloques"));
                            }
                        }
                    System.out.println("********Agrupacion de Datos Viejos **************");
                    vectorViejo.ImprimirConsola("\n");
                    System.out.println("********Agrupacion de Datos Viejos **************");
                    
                    
                        
                    //Pasar todos los elementos del vectorViejo al newMultiVector//
                    int countPosicion=0;
                    String elementActual = vectorViejo.getValue(0,"ERROR interno en Funcion OrderBy_Bloques");
                           elementActual = Cad.subCadCadACadB(elementActual, bloqueActual.CadenaA, bloqueActual.CadenaB);
                    newMultivecVector[countPosicion].addVauleRigth(elementActual);
                    
                    for(int z=1; z<vectorViejo.Longitud(); z++){
                        String temp = vectorViejo.getValue(z,"ERROR interno en Funcion OrderBy_Bloques");
                               temp = Cad.subCadCadACadB(temp, bloqueActual.CadenaA, bloqueActual.CadenaB);
                        
                        if(Cad.Equals(temp, elementActual, false)){
                            elementActual = temp;
                            newMultivecVector[countPosicion].addVauleRigth(elementActual);
                        }else{
                            countPosicion = countPosicion+1;
                            elementActual = temp;
                            newMultivecVector[countPosicion].addVauleRigth(elementActual);
                        }
                    }
                    
                    System.out.println("########## new Multivector ##########");
                    for(int z=0; z<newMultivecVector.length; z++){
                        newMultivecVector[z].ImprimirConsola("\n");
                    }
                    System.out.println("########## new Multivector ##########");
                    
                    
                //Remplazar el vector viejo por el nuevo//
                Multivector = new VectorString[countNewVectors];
                for(int x=0; x<countNewVectors; x++){
                    Multivector[x] = new VectorString(newMultivecVector[x].Clonar());
                }
            }
            
            //Finalmente remplazar el resultado final en la estructura de datos General
                vectorRaiz = new String[0];
                Longitud = 0;
            
                for(int x=0; x<Multivector.length; x++){
                    for(int y=0; y<Multivector[x].Longitud(); y++){
                        Multivector[x].ImprimirConsola("#");
                        addVauleRigth(Multivector[x].getValue(y,"ERROR interno en Funcion OrderBy_Bloques"));
                    }
                }
        }
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso OrderBy_Bloques Terminado con EXITO");
    	}else{
            System.out.println("Proceso OrderBy_Bloques Terminado con FALLO");
    	}
    }
    */
    
    
    
    
    
    /**
     * Descripcion: Ordenar el Vector por Bloques usando sus subcadenas
     *      Metodo de Ordenamiento Burbuja
     *      Se conserva el primer ordenamiento, y esos bloques ordenados se ordenan con el criterio del bloque2
     *     
     *  EJM:Elementos: "Hola var1(2) var2(B), Como var1(1) var2(A), Loco var1(3) var2(A), Perro var1(4) var2(B)"
     *      Bloque1 = "var1("  ")"  Menor2Mayor = true
     *      Bloque2 = "var2("  ")"  Menor2Mayor = true
     *      Salida:  Como var1(1) var2(A)
     *               Hola var1(2) var2(B)
     *               Loco var1(3) var2(A)
     *               Perro var1(4) var2(B)
     * 
     * @param	bloques  Conjunto de Bloques para hacer ordenamiento
     * 
     */
    public void OrderBy_Bloques(BloqueOrder[] bloques){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Crear Matris 2x2 del mismo tamaño con ID y Pesos//
            MatrizLong M2x2 = new MatrizLong(Longitud(),2);
                //Inicializar IDs//
                for(int i=0; i<Longitud(); i++){
                    M2x2.setVaule(i, i, 0);
                }
                
            //Obtener el Peso de cada Elemento del Vector y enviarlo a la Matriz//
            String elementActual;
            for(int posVector=0; posVector<Longitud(); posVector++){
                elementActual=getValue(posVector, "ERROR interno en funcion OrderBy_Bloques....");
                
                //Obtener el peso segun cada criterio de ordenamiento//
                String pesoTotal="";
                for(int posBloque=0; posBloque<bloques.length; posBloque++){
                    BloqueOrder criterioActual = bloques[posBloque];
                    
                    pesoTotal = pesoTotal+Nums.aCadena(criterioActual.getPesoElement(elementActual));
                }
                M2x2.setVaule(Cad.aLong(pesoTotal, -1), posVector, 1);
            }
            
            //Ordenar la columna de pesos de la matriz de Menor2Mayor//
            M2x2.OrderBy_Colum_ALL(1,false);
            
            //Reordenar el vector actual deacuerdo al ordenamiento de la columna pesos de la matriz//
            VectorLong orden = M2x2.getColum(0);
            
            OrderBy_VectorPos(orden.toVectorInteger());
        }
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso OrderBy_Bloques Terminado con EXITO");
    	}else{
            System.out.println("Proceso OrderBy_Bloques Terminado con FALLO");
    	}
    }
    
    
    
    
    /**
     * Descripcion: Ordenar este vector en base a una configuracion de vector de posiciones
     *  Ejm: vectorPos=3,1,2,0
     *  Esto hace que este vector Raiz se ordene de tal forma que el elemtno 3 es el primero, luego el element1 y asi
     * 
     * @param	vectorPos Vector de posiciones que tiene el patron de ordenamiento
     * 
     */
    public void OrderBy_VectorPos(VectorInteger vectorPos){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(vectorPos==null){
        condiciones=false;
        motivo="VectorPos null";
    }else{
        if(vectorPos.Longitud() != Longitud()){
            condiciones=false;
            motivo="Longitud del vector de ordenamiento no corresponde a la longitud del vector a ordenar";
        }
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Crear un Vector clon de los Datos//
            VectorString Clon = new VectorString(this.Clonar());
            
            //Recorrer todo el vector de configuracion de posiciones//
            int pos;
            String element;
            for(int i=0; i<vectorPos.Longitud(); i++){
                //Obtener el elemento a mover//
                pos=vectorPos.getValue(i,0);
                element = Clon.getValue(pos,"ERROR interno en funcion OrderBy_VectorPos...");
                
                //Colocar el elemento en la nueva posicion//
                setVaule(i, element);
            }
        }
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso OrderBy_VectorPos Terminado con EXITO");
    	}else{
            System.out.println("Proceso OrderBy_VectorPos Terminado con FALLO");
    	}
    }
    
    
    
    
     /**
     * Descripcion: Obtener la Longitud del Vector
     *
     * @return	0 a N
     */
    public int Longitud (){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            salida=Longitud;
	}else{
            System.out.println("ERROR en Longitud, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Concatenar todos los Valores en un solo String
     *
     * @return	null o Valor Valido
     */
    public String aString (){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
    if(Longitud()<=0){
        condiciones=false;
        motivo="El vector is empity";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<Longitud(); i++){
                salida = salida+getValue(i,"ERROR aString()");
            }
	}else{
            System.out.println("ERROR en aString, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
    * Clase para Crear Bloques de Ordenamiento para el Vector String
    *   Limitantes para Trabajar con Fechas, solo fechas menores al año 3000
    *   Limitantes para Numeros, numeros enteros, menores a 2000000000
    *   Limitantes de Alfanumerico, solo caracteres ascii español, menores a codigo 255
    * 
    * @author (Eduard SAT) 
    * @version (1.0)
    */
    public static class BloqueOrder{
        //Variables de la Clase
        public String CadenaA;
        public String CadenaB;
        public String Type;
        public VectorString CustomType; //Siempre Ordenamos de Menor a Mayor
        public static String Tipos="NUMERICO,FECHA,ALFANUMERICO,ALFABETO,CUSTOM";
        public boolean Menor2Mayor;
        
      /**
        * Descripcion: Crear un Bloque de Ordenamiento
        *   Para ordenar cadenas Que contengan P(#) siendo # el valor a usar para ordenar
        *   Ejm:  "Altura(" ")"  Esto es P(#)
        *   Conjunto Cadenas "Hola Altura(1)"  "Mundo Altura(3)"   "Como Altura(2)"
        *   Resultado "Hola Altura(1)"  "Como Altura(2)"   "Mundo Altura(3)"
        *   
        *
        * @param   CadA Separador Inicial, no cuentan en el orden
        * @param   CadB Separador Final, no cuentan en el orden
        * @param   Typ Tipo de Dato: Fecha, Numero, Alfanumerico
        * @param   MenorMayor Bloque para Ordenar de MAyor a Menor
        */
        public BloqueOrder(String CadA, String CadB, String Typ, boolean MenorMayor){
        //Variables Locales e Inicializacion//
            boolean condiciones=false;
            String motivo="Indeterminado";
        //Comprobar Condiciones Iniciales//
            if(Cad.numOfContains(Tipos, Typ,true)>=1){
                condiciones=true;
            }else{
                motivo = "Tipo:"+Typ+" no valido!";
                motivo = motivo + "\n Tipos Validos para BloqueOrder:"+Tipos;
            }
        //Comenzar Proceso//
            if(condiciones==true){
                CadenaA = CadA;
                CadenaB = CadB;
                
                Type = Typ;
                
                Menor2Mayor = MenorMayor;
            }else{
                System.out.println("ERROR en BloqueOrder: nombreClase, motivo: "+motivo);
            }
        }
        
        
        
        /**
        * Descripcion: Crear un Bloque de Ordenamiento
        *   Para ordenar cadenas Que contengan P(#) siendo # el valor a usar para ordenar
        *   Ejm:  "Altura(" ")"  Esto es P(#)
        *   Conjunto Cadenas "Hola Altura(1)"  "Mundo Altura(3)"   "Como Altura(2)"
        *   Resultado "Hola Altura(1)"  "Como Altura(2)"   "Mundo Altura(3)"
        *   
        *
        * @param   CadA Separador Inicial, no cuentan en el orden
        * @param   CadB Separador Final, no cuentan en el orden
        * @param   Typ Tipo de Dato: Fecha, Numero, Alfanumerico
        * @param   CustomTyp Elementos Custom ordenados de Menor a MAyor
        * @param   MenorMayor Bloque para Ordenar de MAyor a Menor
        */
        public BloqueOrder(String CadA, String CadB, String Typ, VectorString CustomTyp, boolean MenorMayor){
        //Variables Locales e Inicializacion//
            boolean condiciones=false;
            String motivo="Indeterminado";
            String Tipos = "NUMERICO,FECHA,ALFANUMERICO,ALFABETO,CUSTOM";
        //Comprobar Condiciones Iniciales//
            if(Cad.numOfContains(Tipos, Typ,true)>=1){
                condiciones=true;
            }else{
                motivo = "Tipo:"+Typ+" no valido!";
                motivo = motivo + "\n Tipos Validos para BloqueOrder:"+Tipos;
            }
        //Comenzar Proceso//
            if(condiciones==true){
                CadenaA = CadA;
                CadenaB = CadB;
                
                Type = Typ;
                CustomType = CustomTyp.Clonar();
                
                Menor2Mayor = MenorMayor;
            }else{
                System.out.println("ERROR en BloqueOrder: nombreClase, motivo: "+motivo);
            }
        }
        
        
         /**
        * Descripcion: Obtener el peso de un Elemento segun este Bloque de ordenamiento
        *
        * @param Element String generico como   HolaMundo P(Alta) T(23)
        * @return	0 o N
        */
       public int getPesoElement (String Element){
       //Variables Locales e Inicializacion//
           boolean condiciones=true;
           String motivo="Indeterminado";
           int salida=0;
       //Comprobar Condiciones Iniciales//
           //no hay condiciones Iniciales
           //Comenzar Proceso//
           if(condiciones==true){
               //Obtener el target del elemento a evaluar//
               String target = Cad.subCadCadACadB(Element, CadenaA, CadenaB);
               
               if(Cad.isNulloVacia(target)==false){
                   //Ver que tipo de Elemento estamos manejando en este Bloque de Ordenamiento//
                   if(Cad.Equals(Type,"NUMERICO",true)){
                       salida = Cad.aEntero(target,0);
                       
                       //Modificar la Salida deacuerdo al criterio de ordenamiento del bloque Menor2Mayor
                       //Para los Datos tipo Fecha el primer dato siempre sera el menor
                       if(Menor2Mayor){
                           //Por lo que si va de menor a mayor, simplemente se conserva igual
                       }else{
                           //Pero si es alrevez, entonces sacar el inverso, usando el limite superior
                                //CalcularLimite Superior de Datos Numerico//
                                    //Dado que el maximo valor soportado por un Entero es 2000000000
                                    int LimitSuperior = 2000000000;
                                //Restarle el valor Actual, sera el inverso//
                                    int inverso = LimitSuperior - salida;
                                //Obtener el valor Final para la salida//
                                    salida = inverso;
                       }
                   }
                   
                   if(Cad.numOfContains(Type,"ALFA",true)>=1){
                       salida = Cad.toASCIIpeso(target);
                       
                       //Modificar la Salida deacuerdo al criterio de ordenamiento del bloque Menor2Mayor
                       //Para los Datos tipo Fecha el primer dato siempre sera el menor
                       if(Menor2Mayor){
                           //Por lo que si va de menor a mayor, simplemente se conserva igual
                       }else{
                           //Pero si es alrevez, entonces sacar el inverso, usando el limite superior
                                //CalcularLimite Superior de Datos Alfanumericos//
                                    //Dado que el maximo valor de la tabla ASCII es 255
                                    int LimitSuperior = 255;
                                //Restarle el valor Actual, sera el inverso//
                                    int inverso = LimitSuperior - salida;
                                //Obtener el valor Final para la salida//
                                    salida = inverso;
                       }
                   }
                   
                   if(Cad.Equals(Type,"FECHA",true)){
                       int ano = time.AlgoritmsT.getAno(target);
                       int mes = time.AlgoritmsT.getMes(target);
                       int dia = time.AlgoritmsT.getDia(target);
                       
                       salida = ano*365 + mes*30 + dia; //Simplemente calcular el numero de dias que han transcurrido hasta ahora
                       
                       //Modificar la Salida deacuerdo al criterio de ordenamiento del bloque Menor2Mayor
                       //Para los Datos tipo Fecha el primer dato siempre sera el menor
                       if(Menor2Mayor){
                           //Por lo que si va de menor a mayor, simplemente se conserva igual
                       }else{
                           //Pero si es alrevez, entonces sacar el inverso, usando el limite superior
                                //CalcularLimite Superior de Datos Fecha//
                                    //Suponiendo un Limite superior del Año 3000 = 3000x365
                                    int LimitSuperior = 1095000;
                                //Restarle el valor Actual, sera el inverso//
                                    int inverso = LimitSuperior - salida;
                                //Obtener el valor Final para la salida//
                                    salida = inverso;
                       }
                   }
                   
                   if(Cad.Equals(Type, "CUSTOM", true)){
                       salida = CustomType.posValue(target, false);
                       
                       //Modificar la Salida deacuerdo al criterio de ordenamiento del bloque Menor2Mayor
                       //Para los Datos tipo Custom el primer dato siempre sera el menor
                       if(Menor2Mayor){
                           //Por lo que si va de menor a mayor, simplemente se conserva igual
                       }else{
                           //Pero si es alrevez, entonces sacar el inverso, usando el limite superior
                                //CalcularLimite Superior de Datos Custom//
                                    int LimitSuperior = CustomType.Longitud();
                                //Restarle el valor Actual, sera el inverso//
                                    int inverso = LimitSuperior - salida;
                                //Obtener el valor Final para la salida//
                                    salida = inverso;
                       }
                   }
               }
           }else{
               System.out.println("ERROR en getPesoElement, motivo: "+motivo+", valor regresado: "+salida);
           }
       //Terminar Proceso//
           return salida;
       }
       
       
       
       
        /**
        * Descripcion: Obtener el peso de un Elemento segun este Bloque de ordenamiento
        *
        * @param Element String generico como   HolaMundo P(Alta) T(23)
        * @return	0 o N
        */
       public int getPesoElementTemp (String Element){
       //Variables Locales e Inicializacion//
           boolean condiciones=true;
           String motivo="Indeterminado";
           int salida=0;
       //Comprobar Condiciones Iniciales//
           //no hay condiciones Iniciales
           //Comenzar Proceso//
           if(condiciones==true){
               //Obtener el target del elemento a evaluar//
               String target = Cad.subCadCadACadB(Element, CadenaA, CadenaB);
               
               if(Cad.isNulloVacia(target)==false){
                   //Ver que tipo de Elemento estamos manejando en este Bloque de Ordenamiento//
                   if(Cad.Equals(Type,"NUMERICO",true)){
                       salida = Cad.aEntero(target,0);
                   }
                   
                   if(Cad.numOfContains(Type,"ALFA",true)>=1){
                       salida = Cad.toASCIIpeso(target);
                   }
                   
                   if(Cad.Equals(Type,"FECHA",true)){
                       int ano = time.AlgoritmsT.getAno(target);
                       int mes = time.AlgoritmsT.getMes(target);
                       int dia = time.AlgoritmsT.getDia(target);
                       
                       salida = ano*325 + mes*30 + dia;
                   }
                   
                   if(Cad.Equals(Type, "CUSTOM", true)){
                       salida = CustomType.posValue(target, false);
                   }
               }
           }else{
               System.out.println("ERROR en getPesoElement, motivo: "+motivo+", valor regresado: "+salida);
           }
       //Terminar Proceso//
           return salida;
       }
       
       
        
    }
    
    
    
    
}
