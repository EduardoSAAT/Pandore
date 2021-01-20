/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time;

import Algoritms.Cad;
import Algoritms.Nums;
import java.util.Calendar;

/**
 *
 * @author Ing Lalux
 */
public class AlgoritmsT {
    
     
    
    /**
     * Descripcion: Convertir tiempo de un formato a otro
     *
     * @param	num Tiempo numerico
     * @param   FormatEntrada formato de num: nanosegundos, milisegundos, segundos, minutos, horas, dias
     * @param   FormatSalida  formato de salida: nanosegundos, milisegundos, segundos, minutos, horas, dias
     * @return	valores de retorno
     */
    public static double convertTime (double num, String FormatEntrada, String FormatSalida){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        double salida=0;
        
        double numConvert=num;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            //Convertir todo a Nanosegundos//
            switch(FormatEntrada){
		case "nanosegundos":
                    //Formato Actual//
			break;
		case "milisegundos":
                    numConvert=numConvert*1000;
			break;
                case "segundos":
                    numConvert=numConvert*1000;
                    numConvert=numConvert*1000;
			break;
                case "minutos":
                    numConvert=numConvert*60;
                    numConvert=numConvert*1000;
                    numConvert=numConvert*1000;
			break;  
                case "horas":
                    numConvert=numConvert*60;
                    numConvert=numConvert*60;
                    numConvert=numConvert*1000;
                    numConvert=numConvert*1000;
			break;
                case "dias":
                    numConvert=numConvert*24;
                    numConvert=numConvert*60;
                    numConvert=numConvert*60;
                    numConvert=numConvert*1000;
                    numConvert=numConvert*1000;
			break;
		default:
                    System.out.println("ERROR en convertTime, motivo: FormatEntrada no Encontrado! valor regresado: "+salida);
			break;
            }
            
            //Convertir despues al Fotrmato de Salida//
            switch(FormatSalida){
		case "nanosegundos":
                    //Formato Actual//
			break;
		case "milisegundos":
                    numConvert=numConvert/1000;
			break;
                case "segundos":
                    numConvert=numConvert/1000;
                    numConvert=numConvert/1000;
			break;
                case "minutos":
                    numConvert=numConvert/60;
                    numConvert=numConvert/1000;
                    numConvert=numConvert/1000;
			break;  
                case "horas":
                    numConvert=numConvert/60;
                    numConvert=numConvert/60;
                    numConvert=numConvert/1000;
                    numConvert=numConvert/1000;
			break;
                case "dias":
                    numConvert=numConvert/24;
                    numConvert=numConvert/60;
                    numConvert=numConvert/60;
                    numConvert=numConvert/1000;
                    numConvert=numConvert/1000;
			break;
		default:
                    System.out.println("ERROR en convertTime, motivo: FormatSalida no Encontrado! valor regresado: "+salida);
			break;
            }
            salida=numConvert;
	}else{
            System.out.println("ERROR en convertTime, motivo: "+motivo+", valor regresado: "+salida);
	}
        //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Saber si un ano es Bisiesto o no
     *
     * @param	ano ano a evaluar si es bisiesto o no
     * @return	true o false
     */
    public static boolean anoBisiesto (int ano){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            //Son Bisisestos todos los años que:
            //Sean divisibles por 4
            //Sean divisibles por 400 pero no por 100
            if(((ano % 4)==0)&&((ano % 400)==0)&&((ano % 100)!=0)){
                salida=true;
            }else{
                salida=false;
            }
	}else{
            System.out.println("ERROR en anoBisiesto, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Saber en que ANO marca el reloj actual del sistema
     *
     * @return	entero
     */
    public static int getAno(){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
        //Obtenemos la instancia de la clase calendaria ya creada del java//
        Calendar c1 = Calendar.getInstance();
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            salida=c1.get(Calendar.YEAR);
	}else{
            System.out.println("ERROR en getAno, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Saber en que MES marca el reloj actual del sistema
     *
     * @return	entero
     */
    public static int getMes(){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
        //Obtenemos la instancia de la clase calendaria ya creada del java//
        Calendar c1 = Calendar.getInstance();
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            salida=c1.get(Calendar.MONTH)+1;
	}else{
            System.out.println("ERROR en Mes, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Saber en que DIA marca el reloj actual del sistema
     *
     * @return	entero
     */
    public static int getDia(){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
        //Obtenemos la instancia de la clase calendaria ya creada del java//
        Calendar c1 = Calendar.getInstance();
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            salida=c1.get(Calendar.DATE);
	}else{
            System.out.println("ERROR en getDia, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Saber cuantos dias tiene el mes de este ANO
     *
     * @param	mes mes a evaluar cuantos dias tiene
     * @param   Ano en el que esta el mes dado
     * @return	numero de dias
     */
    public static int numDiasOfMes(String mes, int Ano){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
	if(Algoritms.Cad.numOfContains(mes, "enero,febrero,marzo,abril,mayo,junio,julio,agosto,septiembre,octubre,noviembre,diciembre", ",")!=1){
            condiciones=false;
            motivo="Mes no Encontrado!";
        }
	//Comenzar Proceso//
        if(condiciones==true){
            //30 días tiene Septiembre,
            //Abril, Junio, y Noviembre
            //El resto tiene 31,
            //Excepto Febrero,que tiene 28,Y 29 en bisiesto.
            
            salida=31; //Todos tienen 31 excepto en los siguientes casos
            if((mes.equalsIgnoreCase("septiembre"))||(mes.equalsIgnoreCase("abril"))||(mes.equalsIgnoreCase("junio"))||(mes.equalsIgnoreCase("noviembre"))){
                salida=30;
            }
            if(mes.equalsIgnoreCase("febrero")){
                if(anoBisiesto(Ano)){
                    salida=29;
                }else{
                    salida=28;
                }
            }
	}else{
            System.out.println("ERROR en numDiasOfMes, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Saber cuantos dias tiene el mes de este ANO
     *
     * @param	mes del 1 al 12
     * @param   Ano en el que esta el mes dado
     * @return	numero de dias
     */
    public static int numDiasOfMes(int mes, int Ano){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
    if((mes<=0)||(mes>12)){
        condiciones=false;
        motivo="mes: "+mes+" no Existe";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //30 días tiene Septiembre,
            //Abril, Junio, y Noviembre
            //El resto tiene 31,
            //Excepto Febrero,que tiene 28,Y 29 en bisiesto.
            
            salida=31; //Todos tienen 31 excepto en los siguientes casos
            if((mes==9)||(mes==4)||(mes==6)||(mes==11)){
                salida=30;
            }
            if(mes==2){
                if(anoBisiesto(Ano)){
                    salida=29;
                }else{
                    salida=28;
                }
            }
	}else{
            System.out.println("ERROR en numDiasOfMes, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Convertir un tiempo en milisegundos a un formato de Hora/min/seg
     *
     * @param	tiempo Tiempo en Milisegundos
     * @return	String con Formato
     */
    public static String formatHrsMinsSeg(double tiempo){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="00:00:00";
        
        int horas=0;
        int mins=0;
        int seg=0;
        
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            //Obtener los tiempos//
            horas=(int) AlgoritmsT.convertTime(tiempo, "milisegundos", "horas");
            mins=(int) (AlgoritmsT.convertTime(tiempo, "milisegundos", "minutos")-AlgoritmsT.convertTime(horas,"horas","minutos"));
            seg=(int) (AlgoritmsT.convertTime(tiempo, "milisegundos", "segundos")-AlgoritmsT.convertTime(mins, "minutos", "segundos")-AlgoritmsT.convertTime(horas,"horas","segundos"));
            
            //Convertir en formato//
            salida=Integer.toString(horas);
            salida=salida.concat(":");
            salida=salida.concat(Integer.toString(mins));
            salida=salida.concat(":");
            salida=salida.concat(Integer.toString(seg));
	}else{
            System.out.println("ERROR en formatHrsMinsSeg, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Obtener la Fecha actual en formato DD/MM/AAAA
     *
     * @return	valores de retorno
     */
    public static String getFechaActual (){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            salida=Nums.AjustarTamEntero(getDia(), 2)+"/"+Nums.aCadena(getMes())+"/"+Nums.aCadena(getAno());
	}else{
            System.out.println("ERROR en getFechaActual, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Validar si una fecha existe en formado DD/MM/AAAA
     * El año debe ser mayor que cero
     * El mes debe estar entre 1 y 12
     * El dia debe estar en los limites del mes que sea
     *
     * @param	fecha en Formato DD/MM/AAAA
     * @return	valores de retorno
     */
    public static boolean validarFecha (String fecha){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
        
        String temp="";
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(fecha)){
        condiciones=false;
        motivo="Fecha null o Vacia";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Comprobar que el año es mayor que cero//
            temp=Cad.subCadCadAPosB(fecha,"/",fecha.length());
            temp=Cad.subCadCadAPosB(temp,"/",temp.length());
            int ano=Cad.aEntero(temp, 0);
            if(ano<=0){
                salida=false;
            }else{
                //comprobar que el mes este entre 1 y 12//
                temp=Cad.subCadCadAPosB(fecha,"/",Cad.posOfContainsNum(fecha,"/",2,false));
                int mes = Cad.aEntero(temp, 0);
                if((mes<=0)||(mes>12)){
                    salida=false;
                }else{
                    //Comprobar los dias para este mes//
                    int dias = Cad.aEntero(Cad.subCadPosACadB(fecha,0,"/"),0);
                    if((numDiasOfMes(mes,ano)>=dias)&&(dias>0)){
                        salida=true;
                    }
                }
            }
	}else{
            System.out.println("ERROR en validarFecha, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener el añor de la fecha de entrada
     *
     * @param	fecha en formato DD/MM/AAAA
     * @return	0 ERROR, u Entero Valido
     */
    public static int getAno (String fecha){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
        String temp="";
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(fecha)){
        condiciones=false;
        motivo="Fecha NULL o VACIA";
    }
    if(validarFecha(fecha)==false){
        condiciones=false;
        motivo="Fecha Invalida";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            temp=Cad.subCadCadAPosB(fecha,"/",fecha.length());
            temp=Cad.subCadCadAPosB(temp,"/",temp.length());
            salida=Cad.aEntero(temp,0);
            if(salida==0){
                motivo="Fecha No tiene formato DD/MM/AAAA";
                System.out.println("ERROR en getAno, motivo: "+motivo+", valor regresado: "+salida);
            }
	}else{
            System.out.println("ERROR en getAno, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Obtener el Mes de la fecha de entrada
     *
     * @param	fecha en formato DD/MM/AAAA
     * @return	0 ERROR, u Entero Valido
     */
    public static int getMes (String fecha){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
        String temp="";
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(fecha)){
        condiciones=false;
        motivo="Fecha NULL o VACIA";
    }
    if(validarFecha(fecha)==false){
        condiciones=false;
        motivo="Fecha Invalida";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            temp=Cad.subCadCadAPosB(fecha,"/",fecha.length());
            temp=Cad.subCadPosACadB(temp,0,"/");
            salida=Cad.aEntero(temp,0);
            if(salida==0){
                motivo="Fecha No tiene formato DD/MM/AAAA";
                System.out.println("ERROR en getMes, motivo: "+motivo+", valor regresado: "+salida);
            }
	}else{
            System.out.println("ERROR en getMes, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener el Dia de la fecha de entrada
     *
     * @param	fecha en formato DD/MM/AAAA
     * @return	0 ERROR, u Entero Valido
     */
    public static int getDia (String fecha){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
        String temp="";
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(fecha)){
        condiciones=false;
        motivo="Fecha NULL o VACIA";
    }
    if(validarFecha(fecha)==false){
        condiciones=false;
        motivo="Fecha Invalida";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            temp=Cad.subCadPosACadB(fecha,0,"/");
            salida=Cad.aEntero(temp,0);
            if(salida==0){
                motivo="Fecha No tiene formato DD/MM/AAAA";
                System.out.println("ERROR en getDia, motivo: "+motivo+", valor regresado: "+salida);
            }
	}else{
            System.out.println("ERROR en getDia, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Comparar dos Fechas usando un Operador Matematico
     * 
     * @param	fechaA en formato DD/MM/AAAA
     * @param   fechaB en formato DD/MM/AAAA
     * @param   Operador Operadores Matematicos
     * @return	true o false
     */
    public static boolean compareFechas (String fechaA, String fechaB, String Operador){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
        
        int tempA;
        int tempB;
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(fechaA)){
        condiciones=false;
        motivo="FechaA null o Vacia";
    }else{
        if(validarFecha(fechaA)==false){
            condiciones=false;
            motivo="FechaA inValida";
        }
    }
    if(Cad.isNulloVacia(fechaB)){
        condiciones=false;
        motivo="FechaB null o Vacia";
    }else{
        if(validarFecha(fechaB)==false){
            condiciones=false;
            motivo="FechaB inValida";
        }
    }
    if(Cad.isNulloVacia(Operador)){
        condiciones=false;
        motivo="Operador null o Vacio";
    }else{
        if(Cad.numOfContains(Operador,">,<,=,",",")<1){
            condiciones=false;
            motivo="Operador no Soportado, operadoresSoportados: <,>,==";
        }
    }
	//Comenzar Proceso//
        if(condiciones==true){
            switch(Operador){
                case ">=":
                    tempA=getAno(fechaA);
                    tempB=getAno(fechaB);
                    if(tempA>tempB){
                        salida=true;
                    }else{
                        if(tempA==tempB){
                            tempA=getMes(fechaA);
                            tempB=getMes(fechaB);
                            if(tempA>tempB){
                                salida=true;
                            }else{
                                if(tempA==tempB){
                                    tempA=getDia(fechaA);
                                    tempB=getDia(fechaB);
                                    if(tempA>=tempB){
                                        salida=true;
                                    }else{
                                        salida=false;
                                    }
                                }
                            }
                        }
                    }
                    break;
		case ">":
                    tempA=getAno(fechaA);
                    tempB=getAno(fechaB);
                    if(tempA>tempB){
                        salida=true;
                    }else{
                        if(tempA==tempB){
                            tempA=getMes(fechaA);
                            tempB=getMes(fechaB);
                            if(tempA>tempB){
                                salida=true;
                            }else{
                                if(tempA==tempB){
                                    tempA=getDia(fechaA);
                                    tempB=getDia(fechaB);
                                    if(tempA>tempB){
                                        salida=true;
                                    }else{
                                        salida=false;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "<":
                    tempA=getAno(fechaA);
                    tempB=getAno(fechaB);
                    if(tempA<tempB){
                        salida=true;
                    }else{
                        if(tempA==tempB){
                            tempA=getMes(fechaA);
                            tempB=getMes(fechaB);
                            if(tempA<tempB){
                                salida=true;
                            }else{
                                if(tempA==tempB){
                                    tempA=getDia(fechaA);
                                    tempB=getDia(fechaB);
                                    if(tempA<tempB){
                                        salida=true;
                                    }else{
                                        salida=false;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "<=":
                    tempA=getAno(fechaA);
                    tempB=getAno(fechaB);
                    if(tempA<tempB){
                        salida=true;
                    }else{
                        if(tempA==tempB){
                            tempA=getMes(fechaA);
                            tempB=getMes(fechaB);
                            if(tempA<tempB){
                                salida=true;
                            }else{
                                if(tempA==tempB){
                                    tempA=getDia(fechaA);
                                    tempB=getDia(fechaB);
                                    if(tempA<=tempB){
                                        salida=true;
                                    }else{
                                        salida=false;
                                    }
                                }
                            }
                        }
                    }
                    break;
                case "==":
                    tempA=getAno(fechaA);
                    tempB=getAno(fechaB);
                    if(tempA==tempB){
                        tempA=getMes(fechaA);
                        tempB=getMes(fechaB);
                        if(tempA==tempB){
                            tempA=getDia(fechaA);
                            tempB=getDia(fechaB);
                            if(tempA==tempB){
                                salida=true;
                            }
                        }
                    }
                    break;
		default:
                    System.out.println("compareFechas: Operadores Soportados: <,>,<=,>=,== ");
                    motivo="Operador no Existe";
                    System.out.println("ERROR en compareFechas, motivo: "+motivo+", valor regresado: "+salida);
		break;
            }
	}else{
            System.out.println("ERROR en compareFechas, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Comprobar si una fecha esta entre un rango de fechas inclusive
     *  formato de fechas  DD/MM/AAAA
     *
     * @param	fechaA FechaLimiteInferior
     * @param   fechaB Fecha limite superior
     * @param   fechaInside Fecha dentro del rango
     * @return	valores de retorno
     */
    public static boolean Range(String fechaA, String fechaInside, String fechaB){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
    //Comprobar Condiciones Iniciales//
    if(validarFecha(fechaA)==false){
        condiciones=false;
        motivo="fechaA no valida";
    }
    if(validarFecha(fechaB)==false){
        condiciones=false;
        motivo="fechaB no valida";
    }
    if(validarFecha(fechaInside)==false){
        condiciones=false;
        motivo="fechaInside no valida";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            if(compareFechas(fechaA,fechaInside,"<=")){
                if(compareFechas(fechaB, fechaInside,">=")){
                    salida=true;
                }
            }
	}else{
            System.out.println("ERROR en Range, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: convertir dias a Años
     *      25 idas = 0 anos
     *      380 dias = 1año
     * @param	numDias Numero de dias a convertir
     * @return	valores de retorno
     */
    public static int diasToAnos (int numDias){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
    if(numDias<0){
        condiciones=false;
        motivo="Numero de dias negativo";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=numDias/365;
	}else{
            System.out.println("ERROR en diasToAnos, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Sumar o Restar N dias a una Fecha y otener una Fecha Valida en Calendario
     *
     * @param	fecha Fecha a sumarle o quitarle dias
     * @param   numDias Numero de Dias a sumar o restar
     * @return	fecha valida o "" en caso ERROR
     */
    public static String sumarDias (String fecha, int numDias){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        
        int diasRestantes=numDias;
        String temp="";
    //Comprobar Condiciones Iniciales//
    if(validarFecha(fecha)==false){
        condiciones=false;
        motivo="Fecha:"+fecha+" NO valida";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            int dd = Cad.aEntero(Cad.subCadPosACadB(fecha,0,"/"),0);
            int mm = Cad.aEntero(Cad.subCadCadACadB(fecha,"/","/"),0);
            temp=Cad.subCadCadAPosB(fecha,"/",fecha.length());
            int aa = Cad.aEntero(Cad.subCadCadAPosB(temp,"/",temp.length()),0);
            
            //Si se van a sumar//
            if(numDias>=0){
                while(diasRestantes>0){
                    if((dd+diasRestantes)<=numDiasOfMes(mm, aa)){
                        dd=dd+diasRestantes;
                        diasRestantes=0;
                    }else{
                        //Calculo de Dias//
                        diasRestantes=diasRestantes-(numDiasOfMes(mm, aa)-(dd-1));
                        dd=1;
                        
                        //Ajustar Mes y Año//
                        if(mm<12){
                            mm=mm+1;
                        }else{
                            mm=1;
                            aa=aa+1;
                        }
                    }
                }
                salida=Nums.aCadena(dd)+"/"+Nums.aCadena(mm)+"/"+Nums.aCadena(aa);
            }else{//Si se van a restar dias//
                diasRestantes=-diasRestantes;
                while(diasRestantes>0){
                    if((dd-diasRestantes)>0){
                        dd=dd-diasRestantes;
                        diasRestantes=0;
                    }else{
                        //Ajustar mes y Año//
                        if(mm>1){
                            mm=mm-1;
                        }else{
                            mm=12;
                            aa=aa-1;
                        }
                        
                        //Ajustar dia//
                        diasRestantes=diasRestantes-dd;
                        dd=numDiasOfMes(mm, aa);
                    }
                }
                salida=Nums.aCadena(dd)+"/"+Nums.aCadena(mm)+"/"+Nums.aCadena(aa);
            }
	}else{
            System.out.println("ERROR en sumarDias, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Diferencia de dias entre FechaL y FechaU
     *
     * @param	FechaL Fecha Inicial
     * @param   FechaU Fecha Superior Final
     * @return	0 o Mas
     */
    public static int numDiasEntreFechas (String FechaL, String FechaU){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
        int diferenciaDias=0;
        int diasToNextMes=0;
    //Comprobar Condiciones Iniciales//
    if(compareFechas(FechaU, FechaL,">=")==false){
        condiciones=false;
        motivo="La Fecha:"+FechaL+" no es mayor a la Fecha:"+FechaU;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            int dd1=getDia(FechaL);
            int mm1=getMes(FechaL);
            int aa1=getAno(FechaL);
            
            int dd2=getDia(FechaU);
            int mm2=getMes(FechaU);
            int aa2=getAno(FechaU);
            
            while(compareFechas(FechaL, FechaU,"==")==false){
                if((mm1==mm2)&&(aa1==aa2)){
                    diferenciaDias=(dd2-dd1)+diferenciaDias;
                    //Reconstruir FechaL//
                    FechaL=FechaU;
                }else{
                    diasToNextMes=(numDiasOfMes(mm1, aa1)-dd1)+1;
                    diferenciaDias=diferenciaDias+diasToNextMes;
                    
                    //Obtener nueva FechaL siguiente//
                    dd1=1;
                    if(mm1<12){
                        mm1=mm1+1;
                    }else{
                        mm1=1;
                        aa1=aa1+1;
                    }
                    
                    //Reconstruir FechaL//
                    FechaL=dd1+"/"+mm1+"/"+aa1;
                }
            }
            salida=diferenciaDias;
	}else{
            System.out.println("ERROR en numDiasEntreFechas, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
}
