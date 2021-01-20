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
public class Algebra {
    
    public static String OperadoresValidos="+,-,*,/,^,sqrt";
    public static String[][] ConstantesValidas=Dimention.GeneraMatriz(2, 2,"euler,2.7182818284590,pi,3.141516926535",",");
    
    
     /**
     * Descripcion: Convertir una expresion algebraica en un Vector de String con Elementos Separados
     *
     * @param	expresion Expresion a convertir
     * @return	valores de retorno
     */
    public static String[] ExpresionToVector (String expresion){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String[] salida = new String [100];
        
        String OpActual="";
        int posActual=0;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            //Recorrer caracter a caracter 
            for(int i=0; i<expresion.length(); i++){
                //Si con numeros concatenarlos
                OpActual=OpActual+expresion.substring(i, i+1);
                //Si se encuentra algun operador entonces separarlos
                if(Cad.numOfContains(OpActual,"(,),[,],{,},+,-,*,/,sqrt,^", ",")>=1){
                    //Si no hay elementos anteriores, solo agregar al vector
                    if(OpActual.length()<=1){
                        salida[posActual]=OpActual;
                        posActual=posActual+1;
                        OpActual="";
                    }else{
                        //Si hay elementos anteriores agregar esos y luego agregar el operador encontrado//
                        salida[posActual]=OpActual.substring(0, OpActual.length()-1);
                        posActual=posActual+1;
                        salida[posActual]=OpActual.substring(OpActual.length()-1, OpActual.length());
                        posActual=posActual+1;
                        OpActual="";
                    }
                }
                //Dimention.ImprimirVector(salida);
            }
            //Si quedaron Restos de Operadores que los Agrege
            if(OpActual.length()>0){
                salida[posActual]=OpActual;
                posActual=posActual+1;
                OpActual="";
            }
	}else{
            System.out.println("ERROR en remplazarSubCad, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Obtener una constante del Conjunto de Constantes 
     *
     * @param	constante Constante a buscar
     * @param   showMensaje Mostrar Mensaje si o no
     * @return	valores de retorno
     */
    public static double getConstante (String constante, boolean showMensaje){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        double salida=-1;
        
        int posicion=0;
    //Comprobar Condiciones Iniciales//
    posicion=Dimention.posOfContains(Dimention.getColumnN(ConstantesValidas,2,2,0),constante,false);
    if(posicion<0){
        condiciones=false;
        motivo="No se encontro Constante: "+constante;
        
        if(showMensaje){
            System.out.print("getConstante sugerencia: Constantes Soportadas: ");
            Dimention.ImprimirVector(Dimention.getColumnN(ConstantesValidas,2,2,0));
        }
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=Cad.aDouble(ConstantesValidas[posicion][1],-1);
	}else{
            if(showMensaje){
                System.out.println("ERROR en getConstante, motivo: "+motivo+", valor regresado: "+salida);
            }
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Obtener el nivel de Jerarquia de los Operadores 1=menor 3=mayor
     *
     * @param	Operador Operador a Evaluar Jerarquia
     * @return	Numero de Jerarquia
     */
    public static int JerarquiaOperador (String Operador){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
    if(Operador==null){
        return 0;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            switch(Operador){   
                case "+": return 1;
                case "-": return 1;
                case "*": return 2;
                case "/": return 2;
                case "^": return 3;
                case "sqrt": return 3;
            }
	}else{
            System.out.println("ERROR en JerarquiaOperador, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Cambiar una exprecion de notacion Infija a Posfija
     *
     * @param	notacionInfija Expresion Algebraica en Infija
     * @return	String con notacion en Posfija
     */
    public static String InfijaToPosfija (String notacionInfija){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        
        String[] Infija = new String[250];
        DataStructure.Pila PilaOperadores = new DataStructure.Pila(250);
        DataStructure.Pila PilaExpresion = new DataStructure.Pila(250);
        String OpActual="";
    //Comprobar Condiciones Iniciales//
    
	//Comenzar Proceso//
        if(condiciones==true){
            //Normalizar Expresion//
                //Remplazar Corchetes
                notacionInfija=Cad.remplazarSubCadALL(notacionInfija,"[","(");
                notacionInfija=Cad.remplazarSubCadALL(notacionInfija,"]",")");
            
            Infija=ExpresionToVector(notacionInfija);
            
            for(int i=0; i<Dimention.sizeOcupado(Infija); i++){
                OpActual=Infija[i];
                //Tratamiento de las Llaves
                if((OpActual.equals("("))||(OpActual.equals(")"))){
                    if(OpActual.equals("(")){
                        PilaOperadores.Apilar(OpActual);
                    }
                    if(OpActual.equals(")")){
                        while(!PilaOperadores.VerTope().equals("(")){
                            PilaExpresion.Apilar(PilaOperadores.Desapila());
                        }
                        PilaOperadores.Desapila();
                    }
                }else{
                    //Tratamiento de los Operadores y Operandos//
                    if(Cad.numOfContains(OpActual, "+,-,*,/,sqrt,^", ",")>=1){ //Es Operador
                        //MAYOR Se Apila//
                        if(JerarquiaOperador(OpActual)>JerarquiaOperador(PilaOperadores.VerTope())){
                            PilaOperadores.Apilar(OpActual);
                        }else{
                            //MENOR  Desapilar hasta vaciar o encontrar un "("
                            if(JerarquiaOperador(OpActual)<JerarquiaOperador(PilaOperadores.VerTope())){
                                while ((PilaOperadores.TamPila()>=0)&&(!PilaOperadores.VerTope().equals("("))) {                                    
                                    PilaExpresion.Apilar(PilaOperadores.Desapila());
                                }
                                PilaOperadores.Apilar(OpActual);
                            }else{
                                //IGUAL Desapilar Operador anterior y Apilar Nuevo
                                if(JerarquiaOperador(OpActual)==JerarquiaOperador(PilaOperadores.VerTope())){
                                    PilaExpresion.Apilar(PilaOperadores.Desapila());
                                    PilaOperadores.Apilar(OpActual);
                                }
                            }
                        }
                    }else{ //Es Operando
                        PilaExpresion.Apilar(OpActual);
                    }
                }
                
            }
            
            //Terminar de Vaciar Pila de Operadores//
            for(int x=PilaOperadores.TamPila(); x>=0; x--){
                PilaExpresion.Apilar(PilaOperadores.Desapila());
            }
            
            //Convertir Vector en String//
            salida=PilaExpresion.convetToCadena(",");
	}else{
            System.out.println("ERROR en InfijaToPosfija, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Realizar Potenciacion
     *
     * @param	base Numero Base de la Potenciacion
     * @param   exponente Exponente
     * @return	double valor
     */
    public static double Potenciacion (double base, double exponente){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        double salida=0;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            salida=Math.pow(base,exponente);
	}else{
            System.out.println("ERROR en Potenciacion, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Metodo NewtonRapshon para sistemas de ecuaciones exponenciales
     * 
     * Xn+1 = Xn - (F(x)/dF(x))   Metodo Formula
     *
     * @param	Fx Funcion Fx
     * @param   dFx Derivada de Fx
     * @param   Variable Variable Independiente que esta en Fx y dFx
     * @param   Xo Valor Inicial de la Variable Independiente
     * @param   Error grado de Error  salida LessEqualsThan Error   0.06 LessEqualsThan 0.1 Aceptable Termina Iterar
     * @return	valores de retorno
     */
    public static double MetodoNewtonRapshon (String Fx, String dFx, String Variable, double Xo, double Error){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        double salida=0;
        
        double valAnterior=Xo;
        double valNext=0;
        double valFx=0;
        double valdFx=0;
        double diferencia=0;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            do{
                //Obtener Fx y dFx//
                valFx=EvalueExpresion(Cad.remplazarSubCadALL(Fx,Variable,Nums.aCadena(valAnterior)));
                valdFx=EvalueExpresion(Cad.remplazarSubCadALL(dFx,Variable,Nums.aCadena(valAnterior)));
                
                //Obtener el Valor siguiente//
                valNext=valAnterior-(valFx/valdFx);
                
                //Obtener la Diferencia//
                diferencia=valAnterior-valNext;
                
                //Remplazar Valor Before//
                valAnterior=valNext;
                
            }while(diferencia>Error);
            salida=valNext;
	}else{
            System.out.println("ERROR en MetodoNewtonRapshon, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Evaluar una Expresion algebraica
     *
     * @param	ExpInfija Expresion en Infija
     * @return	valores de retorno
     */
    public static double EvalueExpresion (String ExpInfija){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        double salida=0;
        
        String[] vectorExp;
        double resultado=0;
        double x=0;
        double y=0;
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(ExpInfija)){
        condiciones=false;
        motivo="Expresion NULL o Vacia";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Normalizar la ExpInfija//
                //Si inicia con signo la expresion +2+2,  -1+1  agregar un cero al inicio  0-1+1
                if((ExpInfija.substring(0, 1).equals("-"))||(ExpInfija.substring(0, 1).equals("+"))){
                    ExpInfija="0"+ExpInfija;
                }
                
                //Si tiene exponencial negativo  10^-2  convertir a 1/10^2
               String[] vectAux=ExpresionToVector(ExpInfija);
               for(int i=0; i<Dimention.sizeOcupado(vectAux)-1; i++){
                   if((vectAux[i].equals("^"))&&(vectAux[i+1].equals("-"))){
                       vectAux[i+1]=Nums.aCadena(Potenciacion(Cad.aDouble(vectAux[i-1],0),Cad.aDouble(vectAux[i+2],0)));
                       vectAux[i-1]="1";
                       vectAux[i]="/";
                       vectAux=Dimention.EliminarPosNvector(vectAux,i+2);
                       
                       //Convertir el vector resultante en String//
                        String cad=Dimention.convertVectorToString(vectAux,"");
                        cad=Cad.EliminarSubcadALL(cad,"null");
                        ExpInfija=cad;
                   }
               }
            vectorExp = Cad.aVector(InfijaToPosfija(ExpInfija),",");
            
            try{
            boolean opero=false;
            for(int i=0; i<vectorExp.length; i++){
                if(Cad.numOfContainsExacly(OperadoresValidos,",",vectorExp[i],false)>=1){
                    //Suma//
                    if((vectorExp[i].equals("+"))&&(opero==false)){
                        //Comprobar si algun Operando es Constante conocida//
                        if(getConstante(vectorExp[i-2],false)==-1){
                            x=Cad.aDouble(vectorExp[i-2],-1);
                        }else{
                            x=getConstante(vectorExp[i-2],false);
                        }
                        if(getConstante(vectorExp[i-1],false)==-1){
                            y=Cad.aDouble(vectorExp[i-1],-1);
                        }else{
                            y=getConstante(vectorExp[i-1],false);
                        }
                        
                        resultado=x+y;
                        
                        //Reconvertir Vector//
                        vectorExp=Dimention.EliminarPosNvector(vectorExp, i-1);
                        vectorExp=Dimention.EliminarPosNvector(vectorExp, i-1);
                        vectorExp[i-2]=Nums.aCadena(resultado);
                        //Indicar que ya se Opero y empezar denuevo//
                        opero=true; i=0;
                    }
                    
                    //Resta//
                    if((vectorExp[i].equals("-"))&&(opero==false)){
                        //Comprobar si algun Operando es Constante conocida//
                        if(getConstante(vectorExp[i-2],false)==-1){
                            x=Cad.aDouble(vectorExp[i-2],-1);
                        }else{
                            x=getConstante(vectorExp[i-2],false);
                        }
                        if(getConstante(vectorExp[i-1],false)==-1){
                            y=Cad.aDouble(vectorExp[i-1],-1);
                        }else{
                            y=getConstante(vectorExp[i-1],false);
                        }
                        resultado=x-y;
                        
                        //Reconvertir Vector//
                        vectorExp=Dimention.EliminarPosNvector(vectorExp, i-1);
                        vectorExp=Dimention.EliminarPosNvector(vectorExp, i-1);
                        vectorExp[i-2]=Nums.aCadena(resultado);
                        //Indicar que ya se Opero y empezar denuevo//
                        opero=true; i=0;
                    }
                    
                    
                    //Multiplicacion//
                    if((vectorExp[i].equals("*"))&&(opero==false)){
                        //Comprobar si algun Operando es Constante conocida//
                        if(getConstante(vectorExp[i-2],false)==-1){
                            x=Cad.aDouble(vectorExp[i-2],-1);
                        }else{
                            x=getConstante(vectorExp[i-2],false);
                        }
                        if(getConstante(vectorExp[i-1],false)==-1){
                            y=Cad.aDouble(vectorExp[i-1],-1);
                        }else{
                            y=getConstante(vectorExp[i-1],false);
                        }
                        resultado=x*y;
                        
                        //Reconvertir Vector//
                        vectorExp=Dimention.EliminarPosNvector(vectorExp, i-1);
                        vectorExp=Dimention.EliminarPosNvector(vectorExp, i-1);
                        vectorExp[i-2]=Nums.aCadena(resultado);
                        //Indicar que ya se Opero y empezar denuevo//
                        opero=true; i=0;
                    }
                    
                    
                    //Divicion//
                    if((vectorExp[i].equals("/"))&&(opero==false)){
                        //Comprobar si algun Operando es Constante conocida//
                        if(getConstante(vectorExp[i-2],false)==-1){
                            x=Cad.aDouble(vectorExp[i-2],-1);
                        }else{
                            x=getConstante(vectorExp[i-2],false);
                        }
                        if(getConstante(vectorExp[i-1],false)==-1){
                            y=Cad.aDouble(vectorExp[i-1],-1);
                        }else{
                            y=getConstante(vectorExp[i-1],false);
                        }
                        resultado=x/y;
                        
                        //Reconvertir Vector//
                        vectorExp=Dimention.EliminarPosNvector(vectorExp, i-1);
                        vectorExp=Dimention.EliminarPosNvector(vectorExp, i-1);
                        vectorExp[i-2]=Nums.aCadena(resultado);
                        //Indicar que ya se Opero y empezar denuevo//
                        opero=true; i=0;
                    }
                    
                    //Potenciacion//
                    if((vectorExp[i].equals("^"))&&(opero==false)){
                        //Comprobar si algun Operando es Constante conocida//
                        if(getConstante(vectorExp[i-2],false)==-1){
                            x=Cad.aDouble(vectorExp[i-2],-1);
                        }else{
                            x=getConstante(vectorExp[i-2],false);
                        }
                        if(getConstante(vectorExp[i-1],false)==-1){
                            y=Cad.aDouble(vectorExp[i-1],-1);
                        }else{
                            y=getConstante(vectorExp[i-1],false);
                        }
                        resultado=Potenciacion(x,y);
                        
                        //Reconvertir Vector//
                        vectorExp=Dimention.EliminarPosNvector(vectorExp, i-1);
                        vectorExp=Dimention.EliminarPosNvector(vectorExp, i-1);
                        vectorExp[i-2]=Nums.aCadena(resultado);
                        //Indicar que ya se Opero y empezar denuevo//
                        opero=true; i=0;
                    }
                //Reiniciar el Recorrido del Vector//
                    i=0; opero=false;
                }
            }
            //Si la salida es una Constante buscarlam si no hacer convercion Normal
                if(getConstante(vectorExp[0],false)==-1){
                    salida=Cad.aDouble(vectorExp[0],-1);
                }else{
                    salida=getConstante(vectorExp[0],false);
                }
            }catch(Exception ex){
                System.out.println("Error en EvalueExpresion motivo: Error de sintaxis, valor regresado: "+salida);
            }
	}else{
            System.out.println("ERROR en EvalueExpresion, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Sacar la Raiz N de un Numero
     *
     * @param	Radicando Numero a sacar Raiz
     * @param   baseRadical RaizCuadrada, Cubica, etc......
     * @return	ERROR=-1, 
     */
    public static double Radicacion (double Radicando, double baseRadical){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        double salida=-1;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            double exponente=1/baseRadical;
            salida=Potenciacion(Radicando,exponente);
	}else{
            System.out.println("ERROR en Radicacion, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
    
}
