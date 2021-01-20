/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Automata;
import Algoritms.*;
/**
 *
 * @author Ing Lalux
 */
public class Automata {
    
    //Elementos del Automata//
    public String Alfabeto="";
    public String statInicial="";
    public String statsFinal="";
    public String stats="";
    public String[][] FunctionsTrans; public int ancho=100; public int alto=20;
    
    
    //Variables de Proceso de Recorrido Paso a Paso//
    public String statActual="";
    // "OTRO" posicion donde se encuentra el Simbolo "Otro"
    // "statERROR" posicion donde se encutra el estado "Error"
    
    
    
    /**
     * Descripcion: Construir Automata con los Elementos dados
     *  Tambien Crear el Automata con Alfabeto que incluya "OTRO" ejm: "a,b,c,OTRO"
     *  Con sus funciones de Trancicion:  "(A,a)=B|(B,OTRO)=ERROR"
     *  Tambien Definir un Estado de ERROR  ejm: "A,b,c,ERROR"
     *
     * @param   Alfabeto conjunto del Alfabeto separdo por comas
     * @param	estadoInicial Estado Inicial del Automata
     * @param   estadosFinales Conjunto de estados finales separados por comas
     * @param   Estados Conunto de estados separados por comas
     * @param   FuncionesTrans (q,a)=b|(q1,b)=2| este es el Formato
     */
    public Automata(String Alfabeto, String estadoInicial, String estadosFinales, String Estados, String FuncionesTrans){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            this.Alfabeto=Alfabeto;
            this.statInicial=estadoInicial;
            this.statsFinal=estadosFinales;
            this.stats=Estados;
            
            this.ancho=Cad.numOfElements(Alfabeto,",")+1;
            this.alto=Cad.numOfElements(stats,",")+1;
            FunctionsTrans = new String[alto][ancho];
            
            //Inicializar Matriz con String Vacio//
            FunctionsTrans=Dimention.InicializarMatriz(FunctionsTrans, alto, ancho,"");
            
            //Rellenar Tabla con ALFABETO//
            String[] vAux = Cad.aVector(Alfabeto,",");
            for(int i=1; i<ancho; i++){
                FunctionsTrans[0][i]=vAux[i-1];
            }
            
            //Rellenar Tabla con Estados//
            vAux = Cad.aVector(stats,",");
            for(int i=1; i<alto; i++){
                FunctionsTrans[i][0]=vAux[i-1];
            }
            
            //Rellenar con funciones de trancision//
            setFunctionTrans(FuncionesTrans);
            
            //Asignar el estadoInicial del Recorrido//
            statActual=statInicial;
            
            
        }else{
            System.out.println("ERROR en Constructor Automata, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
    
    
    /**
     * Descripcion: Ingresar un conjunto de funciones de transicion a la tabla del Automata
     *
     * @param	Functions de la forma (q,a)=b|(q1,b)=2
     */
    public void setFunctionTrans(String Functions){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
        
        String[] vector;
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            vector = new String[Cad.numOfElements(Alfabeto,",")*Cad.numOfElements(stats,",")];
            
            String Funcion="";
            int posFila=0;
            int posColumna=0;
            
            vector=Cad.aVector(Functions,"|");
            
            for(int i=0; i<vector.length; i++){
                Funcion=vector[i];
                posFila=Dimention.posOfContains(Dimention.getFilaN(FunctionsTrans,alto,ancho,0),Cad.subCadCadACadB(Funcion,",",")"),false);
                posColumna=Dimention.posOfContains(Dimention.getColumnN(FunctionsTrans, alto, ancho,0),Cad.subCadCadACadB(Funcion,"(",","),false);
                
                FunctionsTrans[posColumna][posFila]=Cad.subCadCadAPosB(Funcion,"=",Funcion.length());
            }
        }else{
            System.out.println("ERROR en setFunctionTrans, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
    
    
    /**
     * Descripcion: Reducir un AFD
     *
     * @param	AFD Automata Finito con todos sus componentes
     * @return	valores de retorno
     */
    public static Automata MinimizaAFD (Automata AFD){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        Automata salida=null;
        
        String[] conjuntoActual = new String[AFD.alto];
        String[] newConjunto = new String[AFD.alto];
        String[][] Tabla = AFD.FunctionsTrans;
        
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
        //Generar Condiciones Iniciales//
             //Generar Conjuntos Iniciales 
             conjuntoActual[0]=AFD.statsFinal;
             conjuntoActual[1]=Cad.EliminaElementsALLconjunto(AFD.stats,AFD.statsFinal,",");
             
             //Generar Tabala Inicial//
             String elemento ="";
             int conjuntoX=-1;
             boolean encontro=false;
             
             
             for(int i=1; i<AFD.alto; i++){
                 for(int j=1; j<AFD.ancho; j++){
                     elemento=Tabla[i][j];
                     if(!elemento.equals("")){
                         do{
                             conjuntoX=conjuntoX+1;
                             if(Cad.numOfContainsExacly(conjuntoActual[conjuntoX],",", elemento,false)>=1){
                                 encontro=true;
                             }
                         }while(encontro==false);
                         Tabla[i][j]=Nums.aCadena(conjuntoX);
                     }
                 }
             }
             
             
             Dimention.ImprimirMatriz(Tabla,AFD.alto,AFD.ancho);
             
             /*for(int n=1; n<AFD.alto-1; n++){
                 if(Dimention.numOfContainsExacly(conjuntoActual,Tabla[n][0],false)>=1){
                     newConjunto[conjuntoX]=newConjunto[conjuntoX].concat(","+Tabla[n][0]);
                     
                 }
             }*/
             
             
	}else{
            System.out.println("ERROR en remplazarSubCad, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Evaluar si una Cadena es Aceptada por Este Automata
     *
     * @param	Cadena Patron de Caracteres a evaluar
     * @return	true o false
     */
    public boolean evalueCadena (String Cadena){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
        
        String caracter=null;
        String statActual=this.statInicial;
        int posAlto=-1;
        int posAncho=-1;
        boolean crashERROR=false;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<Cadena.length(); i++){
                caracter=Cadena.substring(i, i+1);
                posAncho=Dimention.posOfContains(Dimention.getFilaN(FunctionsTrans, alto, ancho, 0),caracter,false);
                posAlto=Dimention.posOfContains(Dimention.getColumnN(FunctionsTrans, alto, ancho, 0),statActual,false);
                
                if((posAlto==-1)||(posAncho==-1)){
                    crashERROR=true;
                    motivo="Patron de Caracteres: "+Cadena+" No valida para Este automata";
                    if(posAncho==-1){
                        motivo=motivo+" Simbolos No coinciden";
                    }
                    System.out.println("ERROR en evalueCadena, motivo: "+motivo+", valor regresado: "+salida);
                }
                
                if(crashERROR==false){
                    if(!FunctionsTrans[posAlto][posAncho].equals("")){
                        statActual=FunctionsTrans[posAlto][posAncho];
                    }else{
                        salida=false; i=Cadena.length(); statActual="BASURA";
                    }
                }
            }
            
            if(Cad.posOfContains(statsFinal,statActual,false)>=0){
                salida=true;
            }else{
                salida=false;
            }
	}else{
            System.out.println("ERROR en evalueCadena, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Resetear el recorrido del Automata situandolo de regreso al estado Inicial
     *
     */
    public void resetRecorrido(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            statActual=statInicial;
        }else{
            System.out.println("ERROR en resetRecorrido, motivo: "+motivo);
	}
    //Terminar Proceso//
        System.out.println("Se Reinicio Recorrido al Estado Inicial: "+statInicial);
    }
    
    
     /**
     * Descripcion: Avanzar en el Recorrido con el siguiente Simbolo de Entrada
     *
     * @param   Caracter Simbolo de Entrada longitud 1
     */
    public void evalueRecorrido(String Caracter){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    
    int posAlto=-1;
    int posAncho=-1;
    boolean error=false;
    //Comprobar Condiciones Iniciales//
    if(Caracter.length()>1){
        condiciones=false;
        motivo="Se ingreso: "+Caracter+" con mas de 1 simbolo de entrada";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            posAlto=Dimention.posOfContains(Dimention.getColumnN(FunctionsTrans, alto, ancho,0),statActual,false);
            if(posAlto==-1){
                error=true;
                motivo="Estado: "+statActual+" no esta definido en Tabla FuncionTransicion";
                statActual="Error";
                System.out.println("ERROR en evalueRecorrido, motivo: "+motivo);
            }
            
            if(error==false){
                posAncho=Dimention.posOfContains(Dimention.getFilaN(FunctionsTrans, alto, ancho,0),Caracter,false);
                //Si no se encuentra este simbolo, buscar la salida con cualquier "OTRO"
                if(posAncho==-1){
                    //Si no existe simbolo ir directamente a "OTRO"
                    posAncho=Dimention.posOfContains(Dimention.getFilaN(FunctionsTrans, alto, ancho,0),"OTRO",true);
                }else{
                    //Si Existe simbolo, comprobar que existan trancisiones, sino ir a "OTRO"
                    if(FunctionsTrans[posAlto][posAncho].equals("")){
                        posAncho=Dimention.posOfContains(Dimention.getFilaN(FunctionsTrans, alto, ancho,0),"OTRO",true);
                    }
                }
                    //Si no se encontro definida tampoco salida con OTRO entonces//
                    if(posAncho==-1){
                        error=true; statActual="Error";
                        motivo="No esta definido el simbolo: "+Caracter+" en la tablaFuncionTrans, Ni tampoco una salida a 'OTRO'";
                        System.out.println("ERROR en evalueRecorrido, motivo: "+motivo);
                    }
                
                if(error==false){
                    if(!FunctionsTrans[posAlto][posAncho].equals("")){
                        statActual=FunctionsTrans[posAlto][posAncho];
                    }else{
                        statActual="Error";
                    }
                }
            }
        }else{
            System.out.println("ERROR en evalueRecorrido, motivo: "+motivo);
	}
    //Terminar Proceso//
	System.out.println("Ahora el nuevo Estado Actual es: "+statActual);
    }
    
}
