package Algoritms;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.text.DecimalFormat;

/**
 *
 * @author Ing Lalux
 */
public class Nums {
     
    
    /**
     * Descripcion: Encontrar el cociente y el residuo de una divicion
     *
     * @param	dividendo Numero a Dividir
     * @param   divisor Numero que Divide
     */
    public static void CocienteYresudio(int dividendo, int divisor){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    
    double cociente=0;
    double residuo=0;
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            cociente=dividendo/divisor;
            residuo=dividendo%divisor;
        }else{
            System.out.println("ERROR en CocienteYresudio, motivo: "+motivo);
	}
    //Terminar Proceso//
	System.out.println("Cociente y Residuo de: "+dividendo+"/"+divisor);
        System.out.println("Cociente: "+cociente);
        System.out.println("Residuo: "+residuo);
    }
    
    
    /**
     * Descripcion: Comprobar si un numero es PAR o NO
     *
     * @param	num Numero a evaluar
     * @return	V o F
     */
    public static boolean comprobarPAR (int num){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        boolean salida=false;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            if((num%2)==0){
                salida=true;
            }else{
                salida=false;
            }
	}else{
            System.out.println("ERROR en comprobarPAR, valor regresado: "+salida); 
	}
    //Terminar Proceso//
        return salida;
    }
    

     /**
     * Descripcion: Comprobar si un numero es Primo o no
     *
     * @param	num Numero Entero a Comprobar
     * @return	Boolean TRUE si es Primo
     */
    public static boolean comprobarPRIMO (int num){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        boolean salida=false;
        int x=0;
    //Comprobar Condiciones Iniciales//
        
	//Comenzar Proceso//
        if(condiciones==true){
            if(num==0){
                salida=false;
            }else{
                if(((num%num)==0)&&((num%1)==0)){
                    salida=true;
                    for(int i=num-1; i>2; i--){
                        x=(num%i);
                        if(x==0){
                            salida=false;
                        }
                    }
                }
            }

            if(((num)==1)||((num)==-1)){
                salida=false;
            }
	}else{
            System.out.println("ERROR en comprobarPRIMO, valor regresado: "+salida); 
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Convertir de entero a Cad de una cierta longitud
     *
     * @param	num Numero Entero a convertir
     * @param   tamCadena Tamano de cadena
     * @return	String con numero
     */
    public static String AjustarTamEntero (int num, int tamCadena){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String salida="";
        
        String aux="";
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            aux=aCadena(num);
            for(int i=aux.length(); i<tamCadena; i++){
                salida=salida.concat("0");
            }
            salida=salida.concat(aux);
	}else{
            System.out.println("ERROR en aCadenaAjustada, valor regresado: "+salida); 
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Convertir de entero a Cad de una cierta longitud
     *
     * @param	num Numero Entero a convertir
     * @param   tamCadena Tamano de cadena
     * @return	String con numero
     */
    public static String AjustarTamDouble (double num, int tamCadena){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String salida="";
        
        String aux="";
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            aux=aCadena(num);
            for(int i=aux.length(); i<tamCadena; i++){
                salida=salida.concat("0");
            }
            salida=salida.concat(aux);
	}else{
            System.out.println("ERROR en aCadenaAjustada, valor regresado: "+salida); 
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Convertir de Float a Cad de una cierta longitud
     *
     * @param	num Numero Entero a convertir
     * @param   tamCadena Tamano de cadena
     * @return	String con numero
     */
    public static String AjustarTamFloat (float num, int tamCadena){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String salida="";
        
        String aux="";
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            aux=aCadena(num);
            for(int i=aux.length(); i<tamCadena; i++){
                salida=salida.concat("0");
            }
            salida=salida.concat(aux);
	}else{
            System.out.println("ERROR en aCadenaAjustada, valor regresado: "+salida); 
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Convertir de entero a Cad
     *
     * @param	num Numero Entero a convertir
     * @return	String con numero
     */
    public static String aCadena (int num){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String salida="";
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            salida=Integer.toString(num);
	}else{
            System.out.println("ERROR en aCadena, valor regresado: "+salida); 
	}
    //Terminar Proceso//
        return salida;
    }

    /**
     * Descripcion: Convertir de double a Cad
     *
     * @param	num Numero Double a convertir
     * @return	String con numero
     */
    public static String aCadena (double num){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String salida="";

	//Comenzar Proceso//
        if(condiciones==true){        
            salida=Double.toString(num);
	}else{
            System.out.println("ERROR en aCadena, valor regresado: "+salida); 
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Calcular la relacion de porcentaje entre dos numeros cualquiera
     *
     * @param	totalElements Total de la relacion
     * @param   numElements Numero de elementos tomados del total
     * @return	-1 ERRROR o 0 a 100
     */
    public static int relaxPorcentaje (int totalElements, int numElements){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        int salida=-1;
        String motivo="";
    //Comprobar condiciones iniciales
    if(totalElements==0){
        condiciones=false;
        motivo="numElements no puede ser 0  div entre 0 error";
    }
	//Comenzar Proceso//
        if(condiciones==true){        
           salida=(numElements*100)/totalElements; 
	}else{
            System.out.println("ERROR en aCadena, motivoo: "+motivo); 
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Convertir de double a Cad
     *
     * @param	num Numero Flotante a convertir
     * @return	String con numero
     */
    public static String aCadena (float num){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String salida="";

	//Comenzar Proceso//
        if(condiciones==true){        
            salida=Float.toString(num);
	}else{
            System.out.println("ERROR en aCadena, valor regresado: "+salida); 
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Convertir un numero a Formato Cientifico a Formato Decimal
     *
     * @param	Numero Numero Double a convertir
     * @param   NumDecimales Numero de Decimales a Utilizar 0...N
     * @return	String con numero
     */
    public static String convertFormatDecimal (double Numero, int NumDecimales){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        
        DecimalFormat Format;
        String Formato="0";
    //Comprobar Condiciones Iniciales//
    if(NumDecimales<0){
        condiciones=false;
        motivo="Menos de Cero decimales no puede ser";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            if(NumDecimales>0){
                Formato=Formato.concat(".");
            }
            for(int i=0; i<NumDecimales; i++){
                Formato=Formato.concat("0");
            }
            Format = new DecimalFormat(Formato);
            salida=Format.format(Numero);
	}else{
            System.out.println("ERROR en convertFormatDecimal, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Encontrar un Numero Primo de una cierta longitud
     *              Regresa el primer Primo que encuentre
     *
     * @param	longitud Longitud del Primo a Buscar 
     * @return	Entero Primo
     */
    public static int foundPrimoTAM (int longitud){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        int salida=0;
        int Li=0;
        int Ls=0;
        String cad="";
    //Comprobar Condiciones Iniciales//
	if(longitud==0){
            condiciones=false;
        }
	//Comenzar Proceso//
        if(condiciones==true){
            do{
                Li=Li+1;
                cad=Nums.aCadena(Li);
            }while(cad.length()<longitud);
                
            do{
                Ls=Ls+1;
                cad=Nums.aCadena(Ls);
            }while(cad.length()<=longitud);
            Ls=Ls-1;
            
            for(Li=Li; Li<=Ls; Li=Li+1){
                if(Nums.comprobarPRIMO(Li)){
                    return Li;
                }
            }
	}else{
            System.out.println("ERROR en foundPrimoInt, valor regresado: "+salida); 
	}
    //Terminar Proceso//
        return salida;
    }
   
     /**
     * Descripcion: Encontrar el primer numero Primo mayor que num
     *
     * @param	num limite Inferior
     * @return	Entero con Numero Primo
     */
    public static int foundPrimoMAYORque (int num){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
        boolean encontro=false;
        int contador=num;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            do{
                //Ir aumentando el contador y comprobar si es primo//
                contador=contador+1;
                if(comprobarPRIMO(contador)){
                    encontro=true;
                    salida=contador;
                }
            }while(encontro==false);
	}else{
            System.out.println("ERROR en foundPrimoMAYORque, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    /**
     * Descripcion: Encontrar el primer numero Primo MENOR que num
     *
     * @param	num limite Superior
     * @return	Entero con Numero Primo
     */
    public static int foundPrimoMENORque (int num){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
        boolean encontro=false;
        int contador=num;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            do{
                //Ir aumentando el contador y comprobar si es primo//
                contador=contador-1;
                if(comprobarPRIMO(contador)){
                    encontro=true;
                    salida=contador;
                }
            }while(encontro==false);
	}else{
            System.out.println("ERROR en foundPrimoMENORque, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }  
    
    
     /**
     * Descripcion: Redondear a Entero un Numero
     *
     * @param	num Numero a Redondear a Entero
     * @param   modo 0=Abajo Ejm 3.6=3, 1=Arriba 2.1=3, 2=EnteroMasCercano, Ejm 3.5=4
     * @return	Entero con Valor Redondeado a Entero
     */
    public static int redondearEntero (double num, int modo){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
	if(modo>2){
            condiciones=false;
            motivo="Modo: "+modo+" solicitado no encontrado";
        }
	//Comenzar Proceso//
        if(condiciones==true){
            if(modo==2){
                salida=(int)Math.round(num);
            }
            if(modo==1){
                salida=(int) Math.ceil(num);
            }
            if(modo==0){
                salida=(int) Math.floor(num);
            }
	}else{
            System.out.println("ERROR en redondearNum, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    /**
     * Descripcion: Redondear a Entero un Numero
     *
     * @param	num Numero a Redondear a Entero
     * @param   modo 0=Abajo Ejm 3.6=3, 1=Arriba 2.1=3, 2=EnteroMasCercano, Ejm 3.5=4
     * @return	Entero con Valor Redondeado a Entero
     */
    public static int redondearEntero (float num, int modo){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
	if(modo>2){
            condiciones=false;
            motivo="Modo: "+modo+" solicitado no encontrado";
        }
	//Comenzar Proceso//
        if(condiciones==true){
            if(modo==2){
                salida=(int)Math.round(num);
            }
            if(modo==1){
                salida=(int) Math.ceil(num);
            }
            if(modo==0){
                salida=(int) Math.floor(num);
            }
	}else{
            System.out.println("ERROR en redondearNum, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Recortar Decimales de un numero, Esta Funcion no Redondea
     *  Ejm "5.12" "1" = 5.1
     *      "5.12" "0" = 5
     *      "5.12" "3" = 5.12 
     * @param	num Numero A Recortar Decimales
     * @param   numDecimales Numero de Decimales a mantener
     * @return	double con Numero Recortado o -1 caso de Error
     */
    public static double recortarDecimales (double num, int numDecimales){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        double salida=-1;
        
        int izqNum = (int) num;
    //Comprobar Condiciones Iniciales//
        
	//Comenzar Proceso//
        if(condiciones==true){
            if(numDecimales<=0){
                salida=izqNum;
            }else{
                String decimales= Nums.aCadena(getDecimales(num));
                if(numDecimales<decimales.length()){
                    decimales=Cad.subCadPosAPosB(decimales,0,numDecimales);
                }
                salida = Cad.aDouble(Nums.aCadena(izqNum)+"."+decimales,-1);
            }
	}else{
            System.out.println("ERROR en recortarDecimales, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Recortar Decimales de un numero, Esta Funcion no Redondea
     *  Ejm "5.12" "1" = 5.1
     *      "5.12" "0" = 5
     *      "5.12" "3" = 5.12 
     * @param	num Numero A Recortar Decimales
     * @param   numDecimales Numero de Decimales a mantener
     * @return	double con Numero Recortado o -1 caso de Error
     */
    public static float recortarDecimales (float num, int numDecimales){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        float salida=-1;
        
        int izqNum = (int) num;
    //Comprobar Condiciones Iniciales//
        
	//Comenzar Proceso//
        if(condiciones==true){
            if(numDecimales<=0){
                salida=izqNum;
            }else{
                String decimales= getDecimales(num);
                if(numDecimales<decimales.length()){
                    decimales=Cad.subCadPosAPosB(decimales,0,numDecimales);
                }
                salida = Cad.aFloat(Nums.aCadena(izqNum)+"."+decimales,-1);
            }
	}else{
            System.out.println("ERROR en recortarDecimales, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Encontrar un numero random entre dos valores inclusive
     *
     * @param	inicio Limite inferior inclusive
     * @param   fin Limite superior inclusive
     * @return	Numero entero aleatorio ERROR =0;
     */
    public static int random (int inicio, int fin){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
        fin=fin+1;
        if(inicio<0){
            inicio=inicio-1;
        }
    //Comprobar Condiciones Iniciales//
	if(inicio>fin){
            motivo="El inico es mayor que el Fin";
            condiciones=false;
        }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=(int) (Math.random() * (fin - inicio)+inicio);
	}else{
            System.out.println("ERROR en random, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Obtener un numero punto flotante Random
     *  Ejm  "-2.0" "9.15" "1" = 5.5
     *       "-2.0" "9.15" "3" = 5.519
     *       "-2.0" "9.15" "3" = 9.15
     *
     * @param	valMin valor de Inicio del Rango
     * @param   valMax valor MAximo del rango
     * @param   numDecimales Numero de Decimales a tener en el numero
     * @return	-1 ERROr otro 0.....N
     */
    public static double random (double valMin, double valMax, int numDecimales){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        double salida=-1;
        
        int izqMax = (int) valMax;
        int izqMin = (int) valMin;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            int izqRandom = random(izqMin, izqMax);
            
            if((izqRandom!=izqMax)&&(izqRandom!=izqMin)){
                String derRandom = "";
                for(int i=1; i<=numDecimales;i++){
                    derRandom=derRandom.concat(Nums.aCadena(random(0,9)));
                }
                salida=Cad.aDouble(Nums.aCadena(izqRandom)+"."+derRandom,-1);
            }else{
                int decimales=0;
                if(izqRandom==izqMax){
                    decimales = getDecimales(valMax);
                }else{
                    decimales = getDecimales(valMin);
                }
                int derRandom = random(0,decimales);
                String numComplet = Nums.aCadena(izqRandom)+"."+Nums.aCadena(derRandom);
                salida=recortarDecimales(Cad.aDouble(numComplet,-1), numDecimales);
            }
	}else{
            System.out.println("ERROR en random, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Algoritmo de Ordenamiento de Vectores por Metodo de Burbuja
     *
     * @param	vector Vector a Ordenar
     * @param   UpDown Direccion, 0=Menor a Mayor, 1=Mayor a Menor
     * @return	ERROR vector con basura, otro caso Vector Ordenado
     */
    public static int[] ordenBurbuja (int[] vector, int UpDown){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int[] salida= new int[vector.length];
        
        int mayor=0;
        int menor=0;
    //Comprobar Condiciones Iniciales//
	if((UpDown<0)||(UpDown>1)){
            motivo="El modo de Ordenamiento no existe";
            condiciones=false;
        }
	//Comenzar Proceso//
        if(condiciones==true){
            //Copiar en la salida//
            for(int i=0; i<vector.length; i++){
                salida[i]=vector[i];
            }
            
            //Si es de Menor a Mayor//
            if(UpDown==0){
                //Hacer el Ordenamiento por burbuja//
                for(int i=0; i<salida.length-1; i++){
                    for(int j=0; j<salida.length-1; j++){
                        if(salida[j]>salida[j+1]){
                            //Obtener el mayor y el menor//
                            mayor=salida[j];
                            menor=salida[j+1];
                            //Hacer el cambio//
                            salida[j]=menor;
                            salida[j+1]=mayor;
                        }
                    }
                }  
            }
            
            //Si es de Mayor a Menor//
            if(UpDown==1){
                //Hacer el Ordenamiento por burbuja//
                for(int i=0; i<salida.length-1; i++){
                    for(int j=0; j<salida.length-1; j++){
                        if(salida[j]<salida[j+1]){
                            //Obtener el mayor y el menor//
                            mayor=salida[j];
                            menor=salida[j+1];
                            //Hacer el cambio//
                            salida[j]=menor;
                            salida[j+1]=mayor;
                        }
                    }
                }   
            }
            
	}else{
            System.out.println("ERROR en ordenBurbuja, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Algoritmo de Ordenamiento de Vectores por Metodo de Dos Fases
     *
     * @param	vector Vector a Ordenar
     * @param   UpDown Direccion, 0=Menor a Mayor, 1=Mayor a Menor
     * @return	ERROR vector con basura, otro caso Vector Ordenado
     */
    public static int[] ordenDosFases (int[]vector, int UpDown){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int[] salida = new int[vector.length];
        
        int turno=0; //0=Par, 1=Impar
        int posicion=0; //posicionVector
        int temporal=0; //Variable con valor Temporal
        int numCambios=0; //Si no hay cambios en Par e Impar Termina el Algoritmo
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            //Orden de Menor a Mayor//
            if(UpDown==0){
                do{
                    if(turno==0){//Fase PAR
                        //Situarse en la posicion Inicial e Inicializar numCambios//
                        posicion=0;
                        numCambios=0;
                        //Ciclo Hasta Terminar con el Vector//
                        while(posicion+1<=vector.length){ //Mientras existan dos posicion siguientes a comparar
                            //Comparar con el siguiente//
                            if(vector[posicion]>vector[posicion+1]){
                                //Si el siguiente Mayor entonces Cambio//
                                temporal=vector[posicion];
                                vector[posicion]=vector[posicion+1];
                                vector[posicion+1]=temporal;
                                //+1 a numCambios//
                                numCambios=numCambios+1;
                            }
                            //Aumentar la posicion del Vector//
                            posicion=posicion+2;
                        }
                        //Cambio de Fase//
                        turno=1;
                    }
                    if(turno==1){//Fase IMPAR
                        //Situarse en la posicion Inicial e Inicializar numCambios//
                        posicion=1;
                        numCambios=0;
                        //Ciclo Hasta Terminar con el Vector//
                        while(posicion+2<=vector.length){ //Mientras existan dos posicion siguientes a comparar
                            //Comparar con el siguiente//
                            if(vector[posicion]>vector[posicion+1]){
                                //Si el siguiente Mayor entonces Cambio//
                                temporal=vector[posicion];
                                vector[posicion]=vector[posicion+1];
                                vector[posicion+1]=temporal;
                                //+1 a numCambios//
                                numCambios=numCambios+1;
                            }
                            //Aumentar la posicion del Vector//
                            posicion=posicion+2;
                        }
                        //cambio de Fase
                        turno=0;
                    }  
                }while(numCambios!=0); 
            }
            //Orden de Mayor a Menor    
            if(UpDown==1){
                do{
                    if(turno==0){//Fase PAR
                        //Situarse en la posicion Inicial e Inicializar numCambios//
                        posicion=0;
                        numCambios=0;
                        //Ciclo Hasta Terminar con el Vector//
                        while(posicion+1<=vector.length){ //Mientras existan dos posicion siguientes a comparar
                            //Comparar con el siguiente//
                            if(vector[posicion]<vector[posicion+1]){
                                //Si el siguiente Mayor entonces Cambio//
                                temporal=vector[posicion];
                                vector[posicion]=vector[posicion+1];
                                vector[posicion+1]=temporal;
                                //+1 a numCambios//
                                numCambios=numCambios+1;
                            }
                            //Aumentar la posicion del Vector//
                            posicion=posicion+2;
                        }
                        //Cambio de Fase//
                        turno=1;
                    }
                    if(turno==1){//Fase IMPAR
                        //Situarse en la posicion Inicial e Inicializar numCambios//
                        posicion=1;
                        numCambios=0;
                        //Ciclo Hasta Terminar con el Vector//
                        while(posicion+2<=vector.length){ //Mientras existan dos posicion siguientes a comparar
                            //Comparar con el siguiente//
                            if(vector[posicion]<vector[posicion+1]){
                                //Si el siguiente Mayor entonces Cambio//
                                temporal=vector[posicion];
                                vector[posicion]=vector[posicion+1];
                                vector[posicion+1]=temporal;
                                //+1 a numCambios//
                                numCambios=numCambios+1;
                            }
                            //Aumentar la posicion del Vector//
                            posicion=posicion+2;
                        }
                        //cambio de Fase
                        turno=0;
                    }  
                }while(numCambios!=0);
            }
            //Mandar la Salida
            salida=vector;
	}else{
            System.out.println("ERROR en ordenDosFases, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Convertir un numero Decimal a Hexadecimal
     *
     * @param	decimal Numero a convertir
     * @return	String con valor
     */
    public static String convertDecimalToHex (int decimal){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            String digits = "0123456789ABCDEF";
            if (decimal <= 0) return "0";
            int base = 16;   // flexible to change in any base under 16
            String hex = "";
            while (decimal > 0) {
                int digit = decimal % base;              // rightmost digit
                hex = digits.charAt(digit) + hex;  // string concatenation
                decimal = decimal / base;
            }
            return hex;
	}else{
            System.out.println("ERROR en convertDecimalToHex, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Convertir un numero Binario a Decimal
     *
     * @param	Binario Numero Binario a Convertir
     * @return	valores de retorno
     */
    public static int convertBinarioToDecimal (int Binario){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
        int[] vector;
        int result;
    //Comprobar Condiciones Iniciales//
    if(!Cad.OnlyContains(aCadena(Binario),"1,0",",")){
        condiciones=false;
        motivo="El numero: "+Binario+" no es Binario!";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            vector=Dimention.convertVectorStringToVectorInt(Cad.aVector(aCadena(Binario),1));
            for(int i=1; i<=vector.length; i++){
                result=vector[i-1]*(int)Math.pow(2,vector.length-i);
                salida=salida+result;
            }
	}else{
            System.out.println("ERROR en convertBinarioToDecimal, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
      /**
     * Descripcion: Convertir un numero en BaseN a Base Decimal
     *
     * @param	Numero Numero en Base N
     * @param   base Base del Numero
     * @return	int
     */
    public static int convertBaseNToDecimal (String Numero, int base){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
        int result=0;
        int[] vector;
    //Comprobar Condiciones Iniciales//
    if(Numero==null){
        condiciones=false;
        motivo="Numero NULL";
    }
    if(Numero.length()==0){
        condiciones=false;
        motivo="Numero NULL";
    }
    if((base>35)||(base<1)){
        condiciones=false;
        motivo="La base es no es soportada";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            vector = new int[Numero.length()];
            //Construir vector convirtiendo letras a numeros//
            for(int i=0; i<Numero.length(); i++){
                vector[i]=Cad.aEntero(Numero.substring(i, i+1),-1);
                if(vector[i]==-1){
                    vector[i]=Cad.posABC(Numero.substring(i, i+1),"English")+9;
                }
            }
            //Hacer Operacion de Convercion//
            for(int i=1; i<=vector.length; i++){
                result=vector[i-1]*(int)Math.pow(base,vector.length-i);
                salida=salida+result;
            }
	}else{
            System.out.println("ERROR en convertBaseNToDecimal, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
         /**
     * Descripcion: Convertir un Numero en Base Decimal a Base N
     *
     * @param	Numero Numero a Convertir
     * @param   Base Base a la que convertir el Numero
     * @return	String
     */
    public static String convertDecimalToBaseN (int Numero, int Base){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        
        int Cociente = Numero;
        int Residuo = 0;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            do {
                Residuo=Cociente%Base;
                Cociente=Cociente/Base;
                salida=Cad.getElement(Cad.generaABC("AlfaNum English",",",true),",",Residuo+1).concat(salida);
            }while(Cociente>0);
	}else{
            System.out.println("ERROR en remplazarSubCad, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Convertir un Numero Dcimal a Binario
     *
     * @param	Numero Numero a Convertir
     * @return	int 
     */
    public static int convertDecimalToBinario (int Numero){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";
        int salida=0;
        
        int Cociente=Numero;
        int Residuo=0;
        String temp="";
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            do{
                Residuo=Cociente%2;
                Cociente=Cociente/2;
                temp=aCadena(Residuo).concat(temp);
            }while(Cociente>0);
            salida=Cad.aEntero(temp,0);
	}else{
            System.out.println("ERROR en convertDecimalToBinario, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Obtener el valor absoluto de un numero
     *
     * @param	Numero Numero a obtener valor absoluto
     * @return	Entero Positivo
     */
    public static int valorAbsoluto (int Numero){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            if(Numero>=0){
                salida=Numero;
            }else{
                salida=-Numero;
            }
	}else{
            System.out.println("ERROR en valorAbsoluto, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Obtener el valor absoluto de un numero
     *
     * @param	Numero Numero a obtener valor absoluto
     * @return	Entero Positivo
     */
    public static float valorAbsoluto (float Numero){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        float salida=0;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            if(Numero>=0){
                salida=Numero;
            }else{
                salida=-Numero;
            }
	}else{
            System.out.println("ERROR en valorAbsoluto, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Convertir un Numero a Notacion Cientifica
     *  Ejm  "1260" "NumCifrasSignificativas" "3"  = "126.0E1"
     *       "1260" "NumDecimales" "3"  = "1.260E3"
     *       "1260" "GradoExponente" "4"  = "0.1260E4"
     * @param	Num Numero a Convertir Notacion
     * @param   Criterio "NumCifrasSignificativas, NumDecimales, GradoExponente"
     * @param   valCriterio Valor a usar en el Criterio que se escoga
     * @return	String "" o con Valor
     */
    public static String convertFormatCientific (double Num, String Criterio, int valCriterio){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        
        String NumDec;
    //Comprobar Condiciones Iniciales//
    
	//Comenzar Proceso//
        if(condiciones==true){
            NumDec=convertFormatDecimal(Num,0);
            
            switch(Criterio){
                case"NumCifrasSignificativas":
                    if(valCriterio<NumDec.length()&&(valCriterio>=1)){ //El punto se puede poder en el numero 12.60E2//
                        NumDec = Cad.InsertCad(NumDec,".",valCriterio);
                        NumDec = NumDec+"E"+Nums.aCadena(NumDec.length()-1-valCriterio);
                    }
                    if(valCriterio == NumDec.length()){ //No se requiere criterio, queda igual 1260E0
                        NumDec = NumDec+"E0";
                    }
                    if(valCriterio>NumDec.length()){//Se tienen que agregar ceros  0.01260E5
                        int diferencia=valCriterio-NumDec.length();
                        for(int i=0; i<diferencia; i++){
                            NumDec = NumDec.concat("0");
                        }
                        NumDec = NumDec+"E-"+Nums.aCadena(diferencia);
                    }
                    break;
                case"NumDecimales":
                    if(valCriterio==0){ //No modificar el numero//
                        salida=NumDec;
                    }
                    if((valCriterio<NumDec.length())&&(valCriterio>0)){ //El punto esta dentro del numero//
                        NumDec = Cad.InsertCad(NumDec,".",NumDec.length()-valCriterio);
                        NumDec = NumDec+"E"+Nums.aCadena(valCriterio);
                    }
                    if(valCriterio>=NumDec.length()){
                        NumDec = "0."+NumDec;
                        int diferencia=valCriterio-NumDec.length()+2;
                        for(int i=0; i<diferencia; i++){
                            NumDec = Cad.InsertCad(NumDec,"0",2);
                        }
                        NumDec = NumDec+"E"+Nums.aCadena(valCriterio);
                    }
                    break;
                case"GradoExponente":
                    if(valCriterio==0){
                        NumDec = NumDec+"E0";
                    }
                    if(valCriterio>0){
                        NumDec = convertFormatCientific(Num,"NumDecimales",valCriterio);
                    }
                    if(valCriterio<0){
                        for(int i=0; i<valorAbsoluto(valCriterio); i++){
                            NumDec = NumDec.concat("0");
                        }
                        NumDec = NumDec+"E"+Nums.aCadena(valCriterio);
                    }
                    break;
                default:
                    motivo="Criterio para construir Numero no Soportado";
                    System.out.println("convertFormatCientific dice:");
                    System.out.println("    Formatos Soportados: NumCifrasSignificativas,NumDecimales,GradoExponente");
                    System.out.println("ERROR en convertFormatCientific, motivo: "+motivo+", valor regresado: "+salida);
                    break;
            }
            salida=NumDec;
	}else{
            System.out.println("ERROR en convertFormatCientific, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Obtener los decimales de un numero
     *  Ejm "12.56" = 0.56
     *      "5" = 0
     *      "12.0" = 0
     *
     * @param	num Numero a Obtener decimales
     * @return	0 .... N
     */
    public static int getDecimales (double num){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
        String numCad = Nums.aCadena(num);
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            int posDecimal = Cad.posOfContains(numCad,".",false);
            
            if(posDecimal<0){
                salida=0;
            }else{
                salida=Cad.aEntero(Cad.subCadPosAPosB(numCad,posDecimal+1,numCad.length()),0);
            }
	}else{
            System.out.println("ERROR en getDecimales, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Obtener los decimales de un numero
     *  Ejm "12.56" = 0.56
     *      "5" = 0
     *      "12.0" = 0
     *
     * @param	num Numero a Obtener decimales
     * @return	0 .... N
     */
    public static String getDecimales (float num){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="0";
        
        String numCad = Nums.aCadena(num);
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            int posDecimal = Cad.posOfContains(numCad,".",false);
            
            if(posDecimal<0){
                salida="0";
            }else{
                salida=Cad.subCadPosAPosB(numCad,posDecimal+1,numCad.length());
            }
	}else{
            System.out.println("ERROR en getDecimales, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Ver si un numeor esta dentro de un rango inclusive
     *
     * @param	numero Numero a Evaluar
     * @param   LimiteInferior valor minimo inclusive
     * @param   LimiteSuperior valor MAximo inclusive
     * @return	valores de retorno
     */
    public static boolean Range (int numero, int LimiteInferior, int LimiteSuperior){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            if((numero>=LimiteInferior)&&(numero<=LimiteSuperior)){
                salida=true;
            }
	}else{
            System.out.println("ERROR en Range, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Ver si un numeor esta dentro de un rango inclusive
     *
     * @param	numero Numero a Evaluar
     * @param   LimiteInferior valor minimo inclusive
     * @param   LimiteSuperior valor MAximo inclusive
     * @return	valores de retorno
     */
    public static boolean Range (float numero, float LimiteInferior, float LimiteSuperior){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            if((numero>=LimiteInferior)&&(numero<=LimiteSuperior)){
                salida=true;
            }
	}else{
            System.out.println("ERROR en Range, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
}
