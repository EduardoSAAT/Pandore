/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algoritms;

/**
 *
 * @author Ing Lalux
 */
public class Dimention {
    
    
    /**
     * Descripcion: Generar una MatrizNxM con numeros aleatorios desde MIN a MAX
     *
     * @param	MatrizAlto NumFilas de la Matriz
     * @param   MatrizAncho NumColumnas de la Matriz
     * @param   valMIN Numero Minimo Posible a Generar aleatoriamente
     * @param   valMAX Numero Maximo posible a Generar aleatoriamente
     * @return  Matriz de enteros
     */
    public static int[][] GeneraMatrizAleatoria (int MatrizAlto, int MatrizAncho, int valMIN, int valMAX){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
        int[][] mTemp = new int[MatrizAlto][MatrizAncho];
    //Comprobar Condiciones Iniciales//
    if((MatrizAlto<=0)||(MatrizAncho<=0)){
        condiciones=false;
        motivo="Dimensiones de la MAtriz negativas o nulas";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<MatrizAlto; i++){
                for(int j=0; j<MatrizAncho; j++){
                    mTemp[i][j]=Nums.random(valMIN, valMAX);
                }
            }
        }else{
            System.out.println("ERROR en GeneraMatrizAleatoria, motivo: "+motivo);
	}
    //Terminar Proceso//
	return mTemp;
    }
    
    
    
    /**
     * Descripcion: Imprimir una MatrizNxM de Strings
     *
     * @param	matriz Matris a Imprimir
     * @param   alto Filas de la Matriz
     * @param   ancho Columnas de la Matriz
     */
    public static void ImprimirMatriz (String[][] matriz, int alto, int ancho){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
        
    //Comprobar Condiciones Iniciales//
    if((alto<=0)||(ancho<=0)){
        condiciones=false;
        motivo="Dimensiones de la MAtriz negativas o nulas";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<alto; i++){
                for(int j=0; j<ancho; j++){
                    System.out.print(matriz[i][j]+",");
                }
                System.out.println("");
            }
        }else{
            System.out.println("ERROR en ImprimirMatriz, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso ImprimirMatriz Terminado");
    }
    
    
    
    /**
     * Descripcion: Imprimir una MatrizNxM
     *
     * @param	matriz Matris a Imprimir
     * @param   alto Filas de la Matriz
     * @param   ancho Columnas de la Matriz
     */
    public static void ImprimirMatriz (int[][] matriz, int alto, int ancho){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
        
    //Comprobar Condiciones Iniciales//
    if((alto<=0)||(ancho<=0)){
        condiciones=false;
        motivo="Dimensiones de la MAtriz negativas o nulas";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<alto; i++){
                for(int j=0; j<ancho; j++){
                    System.out.print(matriz[i][j]+",");
                }
                System.out.println("");
            }
        }else{
            System.out.println("ERROR en ImprimirMatriz, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso ImprimirMatriz Terminado");
    }
    
    
    /**
     * Descripcion: Generar un VectorN con numeros aleatorios desde MIN a MAX
     *
     * @param	Magnitud  Longitud del Vector
     * @param   valMIN Numero Minimo Posible a Generar aleatoriamente
     * @param   valMAX Numero Maximo posible a Generar aleatoriamente
     * @return  Vector de Enteros
     */
    public static int[] GeneraVectorAleatorio (int Magnitud, int valMIN, int valMAX){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
        int[] vecTemp = new int[Magnitud];
    //Comprobar Condiciones Iniciales//
    if(Magnitud<=0){
        condiciones=false;
        motivo="Magnitud del vector negativa o nula";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<Magnitud; i++){
                vecTemp[i]=Nums.random(valMIN, valMAX);
            }
        }else{
            System.out.println("ERROR en GeneraVectorAleatorio, motivo: "+motivo);
	}
    //Terminar Proceso//
	return vecTemp;
    }
    
    
    /**
     * Descripcion: Generar un VectorN con numeros aleatorios desde MIN a MAX
     *
     * @param	Magnitud  Longitud del Vector
     * @param   valMIN Numero Minimo Posible a Generar aleatoriamente
     * @param   valMAX Numero Maximo posible a Generar aleatoriamente
     * @param   numDecimales Numero de Decimales en los Elementos
     * @return  Vector de Enteros
     */
    public static double[] GeneraVectorAleatorio (int Magnitud, double valMIN, double valMAX, int numDecimales){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
        double[] vecTemp = new double[Magnitud];
    //Comprobar Condiciones Iniciales//
    if(Magnitud<=0){
        condiciones=false;
        motivo="Magnitud del vector negativa o nula";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<Magnitud; i++){
                vecTemp[i]=Nums.random(valMIN, valMAX, numDecimales);
            }
        }else{
            System.out.println("ERROR en GeneraVectorAleatorio, motivo: "+motivo);
	}
    //Terminar Proceso//
	return vecTemp;
    }
    
    
    /**
     * Descripcion: Imprimir Vector Enteros
     *
     * @param	vector Vector a Imprimir
     */
    public static void ImprimirVector (int[] vector){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(vector==null){
        condiciones=false;
        motivo="Vector NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vector.length; i++){
                System.out.print(vector[i]+",");
            }
            System.out.println("");
        }else{
            System.out.println("ERROR en ImprimirVector, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
     /**
     * Descripcion: Imprimir Vector Enteros
     *
     * @param	vector Vector a Imprimir
     * @param   separador Separador entre elementos del vector
     */
    public static void ImprimirVector (int[] vector, String separador){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vector.length; i++){
                System.out.print(vector[i]+separador);
            }
            System.out.println("");
        }else{
            System.out.println("ERROR en ImprimirVector, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
    /**
     * Descripcion: Imprimir Vector de Strings
     *
     * @param	vector Vector a Imprimir
     */
    public static void ImprimirVector (String[] vector){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(vector==null){
        condiciones=false;
        motivo="El vector = NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vector.length; i++){
                System.out.print(vector[i]+",");
            }
            System.out.println("");
        }else{
            System.out.println("ERROR en ImprimirVector, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
    /**
     * Descripcion: Imprimir Vector de Strings
     *
     * @param	vector Vector a Imprimir
     * @param   separador Separador entre elementos del vector
     */
    public static void ImprimirVector (String[] vector, String separador){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(vector==null){
        condiciones=false;
        motivo="El vector = NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vector.length; i++){
                System.out.print(vector[i]+separador);
            }
            System.out.println("");
        }else{
            System.out.println("ERROR en ImprimirVector, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
    /**
     * Descripcion: Imprimir Vector de Strings
     *
     * @param	vector Vector a Imprimir
     */
    public static void ImprimirVector (float[] vector){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(vector==null){
        condiciones=false;
        motivo="El vector = NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vector.length; i++){
                System.out.print(vector[i]+",");
            }
            System.out.println("");
        }else{
            System.out.println("ERROR en ImprimirVector, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
    /**
     * Descripcion: Imprimir Vector de Strings
     *
     * @param	vector Vector a Imprimir
     * @param   separador separador entre elementos
     */
    public static void ImprimirVector (float[] vector, String separador){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(vector==null){
        condiciones=false;
        motivo="El vector = NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vector.length; i++){
                System.out.print(vector[i]+separador);
            }
            System.out.println("");
        }else{
            System.out.println("ERROR en ImprimirVector, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
    /**
     * Descripcion: Imprimir Vector de Doubles
     *
     * @param	vector Vector a Imprimir
     */
    public static void ImprimirVector (double[] vector){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(vector==null){
        condiciones=false;
        motivo="El vector = NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vector.length; i++){
                System.out.print(vector[i]+",");
            }
            System.out.println("");
        }else{
            System.out.println("ERROR en ImprimirVector, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    /**
     * Descripcion: Contar el numero de espacios ocupados del vector
     *
     * @param	vector Vector a evaluar
     * @return	valores de retorno
     */
    public static int sizeOcupado (String[] vector){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vector.length; i++){
                if((vector[i]==null)||(vector[i].equals(""))){
                    //ignorar
                }else{
                    salida=salida+1;
                }
            }
	}else{
            System.out.println("ERROR en sizeOcupado, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Generar una Matriz usando un vector de datos en String
     *
     * @param	MatrizAlto NumFilas de la Matriz
     * @param   MatrizAncho NumColumnas de la Matriz
     * @param   data Datos separados por comas:  1,2,3,4,4 y COMPLETOS
     * @return  Matriz de enteros
     */
    public static int[][] GeneraMatriz (int MatrizAlto, int MatrizAncho, String data){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
        int[][] mTemp = new int[MatrizAlto][MatrizAncho];
    //Comprobar Condiciones Iniciales//
    if((MatrizAlto<=0)||(MatrizAncho<=0)){
        condiciones=false;
        motivo="Dimensiones de la MAtriz negativas o nulas";
    }
    if(data==null){
        condiciones=false;
        motivo="String de Datos NULL!";
    }else{
        if(data.length()<=0){
            condiciones=false;
            motivo="String de Datos Vacio!";
        }else{
            //Normalizacion de la cadena//
            if(!data.substring(data.length()-1,data.length()).equalsIgnoreCase(",")){
                data=data.concat(",");
            }
            if(data.substring(0,1).equalsIgnoreCase(",")){
                data=data.substring(1,data.length());
            }
        }
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<MatrizAlto; i++){
                for(int j=0; j<MatrizAncho; j++){
                    mTemp[i][j]=Cad.aEntero(Cad.subCadANTESdeCad(data, ","),0);
                    data=Cad.subCadDESPUESdeCad(data,",");
                }
            }
        }else{
            System.out.println("ERROR en GeneraMatriz, motivo: "+motivo);
	}
    //Terminar Proceso//
	return mTemp;
    }
    
    
    
    /**
     * Descripcion: Generar una Matriz usando un vector de datos en String
     *
     * @param	MatrizAlto NumFilas de la Matriz
     * @param   MatrizAncho NumColumnas de la Matriz
     * @param   data Datos separados por separador y Completos
     * @param   separador Separador del data
     * @return  Matriz de String
     */
    public static String[][] GeneraMatriz (int MatrizAlto, int MatrizAncho, String data, String separador){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
        String[][] mTemp = new String[MatrizAlto][MatrizAncho];
    //Comprobar Condiciones Iniciales//
    if((MatrizAlto<=0)||(MatrizAncho<=0)){
        condiciones=false;
        motivo="Dimensiones de la MAtriz negativas o nulas";
    }
    if(data==null){
        condiciones=false;
        motivo="String de Datos NULL!";
    }else{
        if(data.length()<=0){
            condiciones=false;
            motivo="String de Datos Vacio!";
        }else{
            //Normalizacion de la cadena//
            if(!data.substring(data.length()-separador.length(),data.length()).equals(separador)){
                data=data.concat(separador);
            }
            if(data.substring(0,separador.length()).equals(separador)){
                data=data.substring(separador.length(),data.length());
            }
        }
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<MatrizAlto; i++){
                for(int j=0; j<MatrizAncho; j++){
                    mTemp[i][j]=Cad.subCadANTESdeCad(data,separador);
                    data=Cad.subCadDESPUESdeCad(data,",");
                }
            }
        }else{
            System.out.println("ERROR en GeneraMatriz, motivo: "+motivo);
	}
    //Terminar Proceso//
	return mTemp;
    }
    
    
    
     /**
     * Descripcion: Convertir un vector a String
     *
     * @param	vector Vector a convertir
     * @param   separador a utilizar para separar elementos en el String resultado
     * @return	String
     */
    public static String convertVectorToString (int[] vector, String separador){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vector.length; i++){
                salida=salida.concat(Nums.aCadena(vector[i]));
                if(!(i>=vector.length-1)){
                    salida=salida.concat(separador);
                }
            }
	}else{
            System.out.println("ERROR en convertVectorToString, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
    /**
     * Descripcion: Convertir una matriz en un String Fila a Fila
     *
     * @param	matriz Matriz a convertir
     * @param   alto Eje y, i
     * @param   ancho Eje x, j
     * @param   separador separador a utilizar entre elementos de la matriz
     * @return	String con separador
     */
    public static String convertMatrizToString (int[][] matriz, int alto, int ancho, String separador){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
    
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<alto; i++){
                for(int j=0; j<ancho; j++){
                    salida=salida.concat(Nums.aCadena(matriz[i][j]));
                    if(!((i==alto-1)&&(j==ancho-1))){
                        salida=salida.concat(separador);
                    }
                }
            }
	}else{
            System.out.println("ERROR en convertMatrizToString, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Convertir un Vector a una Matriz
     *
     * @param	alto Alto de la Matriz
     * @param   ancho ancho de la matriz
     * @param   vector Vector de enteros compatible a las dimensiones de la matriz
     * @return	int[][]
     */
    public static int[][] convertVectorToMatriz (int alto, int ancho, int[] vector){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int[][] salida= new int[alto][ancho];
    //Comprobar Condiciones Iniciales//
    if((alto*ancho)!=vector.length){
        condiciones=false;
        motivo="Numero de Elementos del Vector Incompatibles";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            int x=0;
            for(int i=0; i<alto; i++){
                for(int j=0; j<ancho; j++){
                    salida[i][j]=vector[x];
                    x=x+1;
                }
            }
	}else{
            System.out.println("ERROR en convertVectorToMatriz, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Convertir un Vector de Strings a un Vector de Integers
     *
     * @param	vectorString Vector de Strings a convertir
     * @return	int[] o null o Error en -1
     */
    public static int[] convertVectorStringToVectorInt (String[] vectorString){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int[] salida=null;
        
        int numero=0;
    //Comprobar Condiciones Iniciales//
    if(vectorString==null){
        condiciones=false;
        motivo="no existe vector a convertir NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida= new int[vectorString.length];
            for(int i=0; i<vectorString.length; i++){
                salida[i]=Cad.aEntero(vectorString[i], -999999999);
            }
	}else{
            System.out.println("ERROR en convertVectorStringToVectorInt, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Convertir un Vector de Int a un Vector de Strings
     *
     * @param	vector Vector a Convertir
     * @return	String[]
     */
    public static String[] convertVectorIntToVectorString (int[] vector){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String[] salida=null;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            salida = new String[vector.length];
            for(int i=0; i<vector.length; i++){
                salida[i]=Nums.aCadena(vector[i]);
            }
	}else{
            System.out.println("ERROR en convertVectorIntToVectorString, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Convertir un Vector de Double a un Vector de Float
     *
     * @param	vector Vector a Convertir
     * @return	float[] o null
     */
    public static float[] convertVectorDoubleToVectorFloat (double[] vector){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        float[] salida=null;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            salida = new float[vector.length];
            for(int i=0; i<vector.length; i++){
                salida[i]=(float) vector[i];
            }
	}else{
            System.out.println("ERROR en convertVectorIntToVectorString, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Numero de Coincidencias Exactas encontradas de un elemento en un Conjunto
     *
     * @param	Conjunto Conjunto como Vector de Elementos
     * @param   Elemento Elemento a Buscar Coincidencias Exactas
     * @param   UpperCase True Ignorar Mayus, false No ignorar 
     * @return	int
     */
    public static int numOfContainsExacly (String[] Conjunto, String Elemento, boolean UpperCase){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
    if((Conjunto==null)||(Elemento==null)){
        condiciones=false;
        motivo="Conjunto o Elemento NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<Conjunto.length; i++){
                if(UpperCase==true){
                    if(Conjunto[i].equalsIgnoreCase(Elemento)){
                        salida=salida+1;
                    }
                }else{
                    if(Conjunto[i].equals(Elemento)){
                        salida=salida+1;
                    }
                }
            }
	}else{
            //System.out.println("ERROR en numOfContainsExacly, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Numero de Coicidencias encontradas de un Elemento en un Conjunto
     *
     * @param	Conjunto Vector de String donde Buscar Elementos
     * @param   Elemento Elemento a Buscar en Conjunto
     * @param   UpperCase True Ignora, False No Ignora CASE
     * @return	valores de retorno
     */
    public static int numOfContains (String[] Conjunto, String Elemento, boolean UpperCase){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<Conjunto.length; i++){
                salida=salida+Cad.numOfContains(Conjunto[i],Elemento,UpperCase);
            }
	}else{
            System.out.println("ERROR en numOfContains, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Si un VectorString contiene almenos 1 elemento NULL
     *
     * @param	vector Vector de Strings
     * @return	true o false
     */
    public static boolean ContainsNULL (String[] vector){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
    //Comprobar Condiciones Iniciales//
    if(vector==null){
        condiciones=false;
        motivo="Vector NULL no EXITE";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vector.length; i++){
                if(vector[i]==null){
                    salida=true; i=vector.length;
                }
            }
	}else{
            System.out.println("ERROR en ContainsNULL, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Encontrar la posicion de un String en un Vector de Strings
     *
     * @param	cad Cadena a buscar en el vector
     * @param   vector Vector donde buscar los datos
     * @param   IgnoreCase Ignorar Mayusculas y minusculas
     * @return	posicion o -1 ERROR
     */
    public static int posOfContains(String[] vector, String cad, boolean IgnoreCase){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";
        int salida=-1;
    //Comprobar Condiciones Iniciales//
    if(vector==null){
        condiciones=false;
        motivo="Vector NULL";
    }
    if(Dimention.ContainsNULL(vector)){
        condiciones=false;
        motivo="Vector Contiene NULL";
    }
    if(cad==null){
        condiciones=false;
        motivo="Cadena NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vector.length; i++){
                if(IgnoreCase==true){
                    if(vector[i].equalsIgnoreCase(cad)){
                        salida=i;
                        i=vector.length;
                    }
                }else{
                    if(vector[i].equals(cad)){
                        salida=i;
                        i=vector.length;
                    }
                }
            }
	}else{
            System.out.println("ERROR en posOfContains, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Encontrar la posicion de un valor en un Vector
     *
     * @param   vector Vector donde buscar los datos
     * @param	Valor  Valor a buscar en el vector
     * @return	posicion o -1 ERROR
     */
    public static int posOfContains(float[] vector, float Valor){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";
        int salida=-1;
    //Comprobar Condiciones Iniciales//
    if(vector==null){
        condiciones=false;
        motivo="Vector NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vector.length; i++){
                if(vector[i]==Valor){
                    salida=i;
                    i=vector.length;
                }
            }
	}else{
            System.out.println("ERROR en posOfContains, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Convertir un vector de Strings a un String
     *
     * @param	vector Vector a convertir
     * @param   separador Separador a usar para concatenar
     * @return	valores de retorno
     */
    public static String convertVectorToString (String[] vector, String separador){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vector.length; i++){
                salida=salida+vector[i]+separador;
            }
	}else{
            System.out.println("ERROR en convertVectorToString, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Obtener la fila N de una matriz
     *
     * @param	matriz matriz de donde obtener el vector
     * @param   numN Numero de Fila
     * @param   alto Alto de la MAtriz
     * @param   ancho Ancho de la matriz
     * @return	String[]
     */
    public static String[] getFilaN (String[][] matriz, int alto, int ancho, int numN){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String[] salida=null;
    //Comprobar Condiciones Iniciales//
    if(numN>=alto){
        condiciones=false;
        motivo="FilaN: "+numN+" no se encuentra en la matriz";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida = new String[ancho];
            
            for(int i=0; i<ancho; i++){
                salida[i]=matriz[numN][i];
            }
	}else{
            System.out.println("ERROR en getFila, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Obtener la fila N de una matriz
     *
     * @param	matriz matriz de donde obtener el vector
     * @param   numN Numero de Fila
     * @param   alto Alto de la MAtriz
     * @param   ancho Ancho de la matriz
     * @return	String[]
     */
    public static float[] getFilaN (float[][] matriz, int alto, int ancho, int numN){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        float[] salida=null;
    //Comprobar Condiciones Iniciales//
    if(numN>=alto){
        condiciones=false;
        motivo="FilaN: "+numN+" no se encuentra en la matriz";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida = new float[ancho];
            
            for(int i=0; i<ancho; i++){
                salida[i]=matriz[numN][i];
            }
	}else{
            System.out.println("ERROR en getFila, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Obtener la Columna N dela MAtriz
     *
     * @param	matriz matriz de donde obtener el vector
     * @param   numN Numero de Columna
     * @param   alto Alto de la MAtriz
     * @param   ancho Ancho de la matriz
     * @return	String[]
     */
    public static String[] getColumnN (String[][] matriz, int alto, int ancho, int numN){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String[] salida=null;
    //Comprobar Condiciones Iniciales//
    if(numN>=ancho){
        condiciones=false;
        motivo="ColumnaN: "+numN+" no se encuentra en la matriz";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida = new String[alto];
            for(int i=0; i<alto; i++){
                salida[i]=matriz[i][numN];
            }
	}else{
            System.out.println("ERROR en getColumnN, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Inicializar matriz a un Solo valor unico
     *
     * @param   matriz Matriz a Inicializar
     * @param   alto Alto de la matriz
     * @param   ancho Ancho de la matriz
     * @param	valorUnico Valor a tener en toda la matriz
     * @return	valores de retorno
     */
    public static String[][] InicializarMatriz (String[][] matriz, int alto, int ancho, String valorUnico){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String[][] salida=null;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        
        salida= new String[alto][ancho];
        
        if(condiciones==true){
            for(int i=0; i<alto; i++){
                for(int j=0; j<ancho; j++){
                    salida[i][j]=valorUnico;
                }
            }
	}else{
            System.out.println("ERROR en InicializarMatriz , motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Inicializar Vector a un Solo valor unico
     *
     * @param   vector Vector a Inicializar
     * @param	valorUnico Valor a tener en toda la matriz
     * @return	valores de retorno
     */
    public static String[] InicializaVector (String[] vector,String valorUnico){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String[] salida=null;
        
        int lengt = vector.length;
    //Comprobar Condiciones Iniciales//
    
	//Comenzar Proceso//
        salida= new String[lengt];
        
        if(condiciones==true){
            for(int i=0; i<lengt; i++){
                salida[i]=valorUnico;
            }
	}else{
            System.out.println("ERROR en InicializarVector, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Eliminar la posicion N de un Vector, reduciendo asi su tamaño
     *
     * @param	vector Vector de Strings a modificar
     * @param   posN posicion a Eliminar del Vector 0...N
     * @return	String[] reducido
     */
    public static String[] EliminarPosNvector (String[] vector, int posN){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String[] salida=vector;
    //Comprobar Condiciones Iniciales//
    if((posN>=vector.length)||(posN<0)){
        condiciones=false;
        motivo="PosicionN no valida: "+posN;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=new String[vector.length-1];
            
            int posX=0;
            for(int i=0; i<vector.length;i++){
                if(i!=posN){
                    salida[posX]=vector[i];
                    posX=posX+1;
                }
            }
            
	}else{
            System.out.println("ERROR en EliminarPosNvector, motivo: "+motivo+", valor regresado: Vector sin cambios "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Eliminar la posicion N de un Vector, reduciendo asi su tamaño
     *
     * @param	vector Vector de Strings a modificar
     * @param   posN posicion a Eliminar del Vector 0...N
     * @return	int[] reducido
     */
    public static int[] EliminarPosNvector (int[] vector, int posN){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int[] salida=vector;
    //Comprobar Condiciones Iniciales//
    if((posN>=vector.length)||(posN<0)){
        condiciones=false;
        motivo="PosicionN no valida: "+posN;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=new int[vector.length-1];
            
            int posX=0;
            for(int i=0; i<vector.length;i++){
                if(i!=posN){
                    salida[posX]=vector[i];
                    posX=posX+1;
                }
            }
            
	}else{
            System.out.println("ERROR en EliminarPosNvector, motivo: "+motivo+", valor regresado: Vector sin cambios "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Eliminar la posicion N de un Vector, reduciendo asi su tamaño
     *
     * @param	vector Vector de Strings a modificar
     * @param   posN posicion a Eliminar del Vector 0...N
     * @return	int[] reducido
     */
    public static float[] EliminarPosNvector (float[] vector, int posN){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        float[] salida=vector;
    //Comprobar Condiciones Iniciales//
    if((posN>=vector.length)||(posN<0)){
        condiciones=false;
        motivo="PosicionN no valida: "+posN;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=new float[vector.length-1];
            
            int posX=0;
            for(int i=0; i<vector.length;i++){
                if(i!=posN){
                    salida[posX]=vector[i];
                    posX=posX+1;
                }
            }
            
	}else{
            System.out.println("ERROR en EliminarPosNvector, motivo: "+motivo+", valor regresado: Vector sin cambios "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
    /**
     * Descripcion: Eliminar la posicion N de un Vector, reduciendo asi su tamaño
     *
     * @param	vector Vector de Strings a modificar
     * @param   posN posicion a Eliminar del Vector 0...N
     * @return	long[] reducido
     */
    public static long[] EliminarPosNvector (long[] vector, int posN){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        long[] salida=vector;
    //Comprobar Condiciones Iniciales//
    if((posN>=vector.length)||(posN<0)){
        condiciones=false;
        motivo="PosicionN no valida: "+posN;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=new long[vector.length-1];
            
            int posX=0;
            for(int i=0; i<vector.length;i++){
                if(i!=posN){
                    salida[posX]=vector[i];
                    posX=posX+1;
                }
            }
            
	}else{
            System.out.println("ERROR en EliminarPosNvector, motivo: "+motivo+", valor regresado: Vector sin cambios "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Eliminar la posicion N de un Vector, reduciendo asi su tamaño
     *
     * @param	vector Vector de Strings a modificar
     * @param   posN posicion a Eliminar del Vector 0...N
     * @return	int[] reducido
     */
    public static Long[] EliminarPosNvector (Long[] vector, int posN){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        Long[] salida=vector;
    //Comprobar Condiciones Iniciales//
    if((posN>=vector.length)||(posN<0)){
        condiciones=false;
        motivo="PosicionN no valida: "+posN;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=new Long[vector.length-1];
            
            int posX=0;
            for(int i=0; i<vector.length;i++){
                if(i!=posN){
                    salida[posX]=vector[i];
                    posX=posX+1;
                }
            }
            
	}else{
            System.out.println("ERROR en EliminarPosNvector, motivo: "+motivo+", valor regresado: Vector sin cambios "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Concatenar Vectores ampliando su longitud
     * Vr=v1+v2
     *
     * @param	vector1 Vector 1
     * @param   vector2 Vector 2
     * @return	un solo vector con elementos
     */
    public static String[] concatVectores (String[]vector1, String[]vector2){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String[] salida=null;
        
        boolean nulos =false;
    //Comprobar Condiciones Iniciales//
    if(vector1==null){
        salida=vector2; nulos=true;
    }
    if(vector2==null){
        salida=vector1; nulos =true;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            if(nulos==false){
                salida=new String[vector1.length+vector2.length];
                
                for(int i=0; i<salida.length; i++){
                    if(i>=vector1.length){
                        salida[i]=vector2[i-vector1.length];
                    }else{
                        salida[i]=vector1[i];
                    }
                }
            }
	}else{
            System.out.println("ERROR en concatVectores, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Comprobar si un elemento se encuentra en un conjunto Vector
  Comprobacion Exacta, tiene que ser el mismo elemento v[i]=Cad
     * @param	Conjunto Conjunto de Elementos
     * @param   Elemento Elemento a buscar si se encuentra
     * @return	true o false
     */
    public static boolean Contains (String[] Conjunto, String Elemento){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
    //Comprobar Condiciones Iniciales//
    if((Conjunto==null)||(Elemento==null)){
        condiciones=false;
        motivo="Conjunto y/o Elemento Null";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<Conjunto.length; i++){
                if(Conjunto[i].equals(Elemento)){
                    salida=true;
                    i=Conjunto.length;
                }
            }
	}else{
            System.out.println("ERROR en Contains, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Obtener el valor maximo que se encuentre en un Vector
     *
     * @param	vector Vector donde buscar el Valor Maximo
     * @param   error Valor de salida en caso de error
     * @return	error o Valor Valido
     */
    public static int getMaxVaule (int[] vector, int error){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=error;
    //Comprobar Condiciones Iniciales//
    if(vector==null){
        condiciones=false;
        motivo="El vector is NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vector.length; i++){
                if(i==0){
                    salida=vector[i];
                }
                if(vector[i]>salida){
                    salida=vector[i];
                }
            }
	}else{
            System.out.println("ERROR en getMaxVaule, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Obtener el valor maximo que se encuentre en un Vector
     *
     * @param	vector Vector donde buscar el Valor Maximo
     * @param   error Valor de salida en caso de error
     * @return	error o Valor Valido
     */
    public static double getMaxVaule (double[] vector, double error){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        double salida=error;
    //Comprobar Condiciones Iniciales//
    if(vector==null){
        condiciones=false;
        motivo="El vector is NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vector.length; i++){
                if(i==0){
                    salida=vector[i];
                }
                if(vector[i]>salida){
                    salida=vector[i];
                }
            }
	}else{
            System.out.println("ERROR en getMaxVaule, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener el valor maximo que se encuentre en un Vector
     *
     * @param	vector Vector donde buscar el Valor Maximo
     * @param   error Valor de salida en caso de error
     * @return	error o Valor Valido
     */
    public static float getMaxVaule (float[] vector, float error){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        float salida=error;
    //Comprobar Condiciones Iniciales//
    if(vector==null){
        condiciones=false;
        motivo="El vector is NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vector.length; i++){
                if(i==0){
                    salida=vector[i];
                }
                if(vector[i]>salida){
                    salida=vector[i];
                }
            }
	}else{
            System.out.println("ERROR en getMaxVaule, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Obtener el valor minimo que se encuentre en un vector
     *
     * @param	vector Vector de Enteros
     * @param   error Valor en Caso de Error
     * @return	error o ValorMIN
     */
    public static int getMinVaule (int[] vector, int error){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=error;
    //Comprobar Condiciones Iniciales//
    if(vector==null){
        condiciones=false;
        motivo="El vector is NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vector.length; i++){
                if(i==0){
                    salida=vector[i];
                }else{
                    if(vector[i]<salida){
                        salida=vector[i];
                    }
                }
            }
	}else{
            System.out.println("ERROR en getMinVaule, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Obtener el valor minimo que se encuentre en un vector
     *
     * @param	vector Vector de Enteros
     * @param   error Valor en Caso de Error
     * @return	error o ValorMIN
     */
    public static double getMinVaule (double[] vector,double error){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        double salida=error;
    //Comprobar Condiciones Iniciales//
    if(vector==null){
        condiciones=false;
        motivo="El vector is NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vector.length; i++){
                if(i==0){
                    salida=vector[i];
                }else{
                    if(vector[i]<salida){
                        salida=vector[i];
                    }
                }
            }
	}else{
            System.out.println("ERROR en getMinVaule, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Obtener el valor minimo que se encuentre en un vector
     *
     * @param	vector Vector de Enteros
     * @param   error Valor en Caso de Error
     * @return	error o ValorMIN
     */
    public static float getMinVaule (float[] vector,float error){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        float salida=error;
    //Comprobar Condiciones Iniciales//
    if(vector==null){
        condiciones=false;
        motivo="El vector is NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vector.length; i++){
                if(i==0){
                    salida=vector[i];
                }else{
                    if(vector[i]<salida){
                        salida=vector[i];
                    }
                }
            }
	}else{
            System.out.println("ERROR en getMinVaule, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Obtener el Valor en una Posicion del Vector con validacion de ERRORES
     *  solo se valida que exista la posicion en el vector
     * @param	vector Vector donde buscar el elemento
     * @param   posElement posicion del vector donde se encuentra elemenro
     * @param   ERROR valor de salida en caso de errores en el vector o posicion
     * @return	valores de retorno
     */
    public static int getValueVector (int[] vector, int posElement, int ERROR){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=ERROR;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            if(vector==null){
                salida=ERROR;
            }else{
                if((posElement<vector.length)&&(posElement>=0)){
                    salida=vector[posElement];
                }else{
                    salida=ERROR;
                }
            }
	}else{
            System.out.println("ERROR en getValueVector, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener el Valor en una Posicion del Vector con validacion de ERRORES 
     *  solo se valida que exista la posicion en el vector
     * @param	vector Vector de donde obtener datos
     * @param   posElement Posicion en el vector
     * @param   ERROR Valor de salida en casos de Error
     * @return	valores de retorno
     */
    public static String getValueVector (String[] vector, int posElement, String ERROR){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            if(vector==null){
                salida=ERROR;
            }else{
                if((posElement<0)||(posElement>=vector.length)){
                    salida=ERROR;
                }else{
                    salida=vector[posElement];
                }
            }
	}else{
            System.out.println("ERROR en getValueVector, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Obtener el Valor en una Posicion del Vector con validacion de ERRORES 
     *  Valida que exista la posicion en el vector y no sea NULL
     * @param	vector Vector de donde obtener datos
     * @param   posElement Posicion en el vector
     * @param   ERROR Valor de salida en casos de Error
     * @return	valores de retorno
     */
    public static String getValueVectorFIX (String[] vector, int posElement, String ERROR){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            if(vector==null){
                salida=ERROR;
            }else{
                if((posElement<0)||(posElement>=vector.length)){
                    salida=ERROR;
                }else{
                    salida=vector[posElement];
                }
                
                if(salida==null){
                    salida=ERROR;
                }
            }
	}else{
            System.out.println("ERROR en getValueVector, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Obtener la longitud de un vector aunque este sea nulo
     *
     * @param	vector Vector a Evaluar
     * @return	valores de retorno
     */
    public static int LongitudFIX (String[] vector){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            if(vector!=null){
                salida=vector.length;
            }
	}else{
            System.out.println("ERROR en LongitudFIX, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Obtener un Subvector desde una posicionA hasta una posicionB
     *
     * @param	vector Vector a Recortar
     * @param   posA Posicion Incial
     * @param   posB Posicion Final
     * @return	null o Vector
     */
    public static float[] subVectorPosAPosB(float[] vector, int posA, int posB){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        float[] salida=null;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            salida = new float[posB-posA];
            int posSalida=0;
            for(int i=posA; i<posB; i++){
                salida[posSalida]=vector[i];
                posSalida=posSalida+1;
            }
	}else{
            System.out.println("ERROR en subVectorPosAPosB, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Eliminar la Fila N de una Matriz
     *
     * @param	Matriz MAtriz a Eliminar Fila
     * @param   alto  Numero de Filas
     * @param   ancho Numero Columnas
     * @param   numFila 0.....N
     * @return	valores de retorno
     */
    public static String[][] EliminarFilaN (String[][] Matriz, int alto, int ancho, int numFila){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String[][] salida=null;
    //Comprobar Condiciones Iniciales//
    if((numFila<0)||(numFila>=alto)){
        condiciones=false;
        motivo="Numero de Fila no Existe";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=new String[alto-1][ancho];
            
            int posMatrizVieja=0;
            for(int i=0; i<alto-1; i++){
                if(numFila==i){
                    posMatrizVieja=posMatrizVieja+1;
                }
                
                for(int x=0; x<ancho; x++){
                    salida[i][x]=Matriz[posMatrizVieja][x];
                }
                posMatrizVieja=posMatrizVieja+1;
            }
	}else{
            System.out.println("ERROR en EliminarFilaN, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Eliminar la Columna N de una Matriz
     *
     * @param	Matriz MAtriz a Eliminar Fila
     * @param   alto  Numero de Filas
     * @param   ancho Numero Columnas
     * @param   numColumna 0.....N
     * @return	valores de retorno
     */
    public static String[][] EliminarColumnaN (String[][] Matriz, int alto, int ancho, int numColumna){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String[][] salida=null;
    //Comprobar Condiciones Iniciales//
    if((numColumna<0)||(numColumna>=ancho)){
        condiciones=false;
        motivo="Numero de Columna no Existe";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=new String[alto][ancho-1];
            
            int posMatrizVieja=0;
            for(int i=0; i<alto-1; i++){
                if(numColumna==i){
                    posMatrizVieja=posMatrizVieja+1;
                }
                
                for(int x=0; x<ancho; x++){
                    salida[i][x]=Matriz[posMatrizVieja][x];
                }
                posMatrizVieja=posMatrizVieja+1;
            }
	}else{
            System.out.println("ERROR en EliminarColumnaN, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Inicializar un Vector con un Valor Unico
     *
     * @param   Vector Vector a Inicializar
     * @param	Vaule Valor a tener en todos los elementos del vector
     * @return	int[]
     */
    public static int[] InicializaVector (int[]Vector, int Vaule){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";
        int[] salida=null;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<Vector.length; i++){
                Vector[i]=Vaule;
            }
            salida=Vector;
	}else{
            System.out.println("ERROR en InicializaVector, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Inicializar un Vector con un Valor Unico
     *
     * @param   Vector Vector a Inicializar
     * @param	Vaule Valor a tener en todos los elementos del vector
     * @return	int[]
     */
    public static float[] InicializaVector (float[]Vector, float Vaule){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";
        float[] salida=null;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<Vector.length; i++){
                Vector[i]=Vaule;
            }
            salida=Vector;
	}else{
            System.out.println("ERROR en InicializaVector, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Eliminar el primer Element que encuentre de IZQ a DER en VectorString
     *
     * @param	vectString Vector de Elementos
     * @param   Element Elemento a Eliminar, el primero en ser encontrado
     * @return	String[] o null
     */
    public static String[] EliminarElement(String[] vectString, String Element){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String[] salida=vectString;
        
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vectString.length; i++){
                if(Cad.Equals(salida[i],Element,false)){
                    salida=EliminarPosNvector(vectString, i);
                    i=vectString.length+1;
                }
            }
	}else{
            System.out.println("ERROR en EliminarElement, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Elimina todos los Elementos Element de un Vector de Strings
     *
     * @param	vector Vector de Elementos
     * @param   Element Elemento a Eliminar TODOS del Vector
     * @param   IgnoreCase Ignorar Case
     * @return	String[] 
     */
    public static String[] EliminaElementsALL (String[] vector, String Element, boolean IgnoreCase){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String[] salida=null;
    //Comprobar Condiciones Iniciales//
    if(vector==null){
        condiciones=false;
        motivo="Vector is NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=vector;
            for(int i=0; i<salida.length; i++){
                if(Cad.Equals(salida[i],Element,IgnoreCase)){
                    salida=Dimention.EliminarPosNvector(salida, i);
                    i=i-1;
                }
            }
	}else{
            System.out.println("ERROR en EliminaElementsALL, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Eliminar Filas donde todos sus elementos son nulos
     *
     * @param	matriz Matriz nxn
     * @param   alto Numero de Filas
     * @param   ancho Numero de Columnas
     * @return	matriz sin cambios o con cambios
     */
    public static String[][] EliminaFilasNull (String[][] matriz, int alto, int ancho){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String[][] salida=matriz;
        
        String elemento="";
        boolean eliminar=true;
    //Comprobar Condiciones Iniciales//
    
	//Comenzar Proceso//
        if(condiciones==true){
           for(int i=0; i<getNumFilas(salida); i++){
               
               for(int x=0; x<ancho; x++){
                   elemento=salida[i][x];
                   if(elemento!=null){
                       eliminar=false;
                   }
               }
               
               if(eliminar){
                   salida=EliminarFilaN(salida,getNumFilas(salida), ancho, i);
                   i=i-1;
               }
               eliminar=true;
           }
	}else{
            System.out.println("ERROR en EliminaFilasNull, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener el valor en una posicion de una matriz de forma Segura
     *  Solo valida que exista la posicion en la matriz
     * @param	matriz de nxm
     * @param   posAlto posicion en las Filas
     * @param   posAncho posicion en las Columnas
     * @param   Error Salida en caso de ERROR
     * @return	valores de retorno
     */
    public static String getValueMatriz (String[][] matriz, int posAlto, int posAncho, String Error){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            try {
               salida=matriz[posAlto][posAncho]; 
            } catch (Exception e) {
                /*ArrayIndexOutOfBoundsException ObjetoErrorArrays = new ArrayIndexOutOfBoundsException();
                if(e.getClass().equals(ObjetoErrorArrays.getClass())){
                    System.out.println("Es un Error de Array");
                }*/
                salida=Error;
            }
	}else{
            System.out.println("ERROR en getValueMatriz, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Obtener el numero de Filas de una Matriz
     *  contando desde 1....N
     * @param	matriz nxm
     * @return	1...N
     */
    public static int getNumFilas (String[][] matriz){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
        int contador=-1;
        boolean Termino=false;
        String elemento="";
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            do {
                try {
                    contador=contador+1;
                    elemento=matriz[contador][0];
                } catch (Exception e) {
                    Termino=true;
                }
            } while (Termino==false);
            
            salida=contador;
	}else{
            System.out.println("ERROR en getNumFilas, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Obtener el numero de Filas de una Matriz
     *  contando desde 1....N
     * @param	matriz nxm
     * @return	1...N
     */
    public static int getNumFilas (float[][] matriz){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
        int contador=-1;
        boolean Termino=false;
        float elemento=0;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            do {
                try {
                    contador=contador+1;
                    elemento=matriz[contador][0];
                } catch (Exception e) {
                    Termino=true;
                }
            } while (Termino==false);
            
            salida=contador;
	}else{
            System.out.println("ERROR en getNumFilas, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Obtener el numero de Columnas de una Matriz
     *  contando desde 1....N
     * @param	matriz nxm
     * @return	1...N
     */
    public static int getNumColumnas (String[][] matriz){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
        int contador=-1;
        boolean Termino=false;
        String elemento="";
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            do {
                try {
                    contador=contador+1;
                    elemento=matriz[0][contador];
                } catch (Exception e) {
                    Termino=true;
                }
            } while (Termino==false);
            
            salida=contador;
	}else{
            System.out.println("ERROR en getNumFilas, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Obtener el numero de Columnas de una Matriz
     *  contando desde 1....N
     * @param	matriz nxm
     * @return	1...N
     */
    public static int getNumColumnas (float[][] matriz){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
        int contador=-1;
        boolean Termino=false;
        float elemento=0;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            do {
                try {
                    contador=contador+1;
                    elemento=matriz[0][contador];
                } catch (Exception e) {
                    Termino=true;
                }
            } while (Termino==false);
            
            salida=contador;
	}else{
            System.out.println("ERROR en getNumFilas, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    /**
     * Descripcion: Obtener el valor en una posicion de una matriz de forma Segura
     *  Valida que exista la posicion en la matriz y no sea NULL
     * @param	matriz de nxm
     * @param   posAlto posicion en las Filas
     * @param   posAncho posicion en las Columnas
     * @param   Error Salida en caso de ERROR u NULL
     * @return	valores de retorno
     */
    public static String getValueMatrizFIX (String[][] matriz, int posAlto, int posAncho, String Error){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            try {
               salida=matriz[posAlto][posAncho];
               if(salida==null){
                   salida=Error;
               }
            } catch (Exception e) {
                /*ArrayIndexOutOfBoundsException ObjetoErrorArrays = new ArrayIndexOutOfBoundsException();
                if(e.getClass().equals(ObjetoErrorArrays.getClass())){
                    System.out.println("Es un Error de Array");
                }*/
                salida=Error;
            }
	}else{
            System.out.println("ERROR en getValueMatriz, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Convertir un vector de Enteros a un vector de Floats
     *
     * @param	vector Vector a convertir
     * @return	valores de retorno
     */
    public static float[] convertVectorIntToVectorFloat (int[] vector){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";
        float[] salida=null;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            salida= new float[vector.length];
            
            for(int i=0; i<vector.length; i++){
                salida[i]=vector[i];
            }
	}else{
            System.out.println("ERROR en convertVectorIntToVectorFloat, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
}
