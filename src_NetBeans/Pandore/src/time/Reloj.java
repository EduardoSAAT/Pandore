/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package time;

/**
 *
 * @author Ing Lalux
 */
public class Reloj {
    double TInicio;
    double TFinal;
    
     
    /**
     * Descripcion: Iniciar el contador del Reloj y con algun valor inicial
     *
     * @param	inicio Valores con los que inicia el contador del Reloj
     * @param   tipo El tipo de valores de @inicio "nanosegundos, milisegundos, segundos, minutos, horas" 
     */
    public synchronized void RelojStart(double inicio, String tipo){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            //Inicializar tiempos//
            TInicio=0;
            TFinal=0;
            
            TInicio=System.nanoTime();
            
            //Sumarle al tiempo Final, el tiempo de mas//
            switch(tipo){
		case "nanosegundos":
			//instrucciones//
                        TFinal=inicio;
			break;
		case "milisegundos":
			//instrucciones//
                        TFinal=(inicio*1000000); //Para Tener en milisegundos
			break;
		case "segundos":
			//instrucciones//
                        inicio=(inicio*1000000); //Para Tener en milisegundos
                        TFinal=(inicio*1000); //Para Tener en segundos
			break; 
                case "minutos":
			//instrucciones//
                        inicio=(inicio*1000000); //Para Tener en milisegundos
                        inicio=(inicio*1000); //Para Tener en segundos
                        TFinal=(inicio*60); //Para Tener en minutos
			break; 
                case "horas":
			//instrucciones//
                        inicio=(inicio*1000000); //Para Tener en milisegundos
                        inicio=(inicio*1000); //Para Tener en segundos
                        inicio=(inicio*60); //Para Tener en minutos
                        TFinal=(inicio*60); //Para Tener en HORAS
			break;
		default:
			//instrucciones//
                        System.out.println("ERROR en RelojStart, motivo: Opcion no encontrada!, Valor regresado: 0");
			break;
            }
	}else{
            System.out.println("ERROR en RelojStart, motivo: "+motivo);
	}
        //Terminar Proceso//
    }
    
     /**
     * Descripcion: Ver el tiempo que ha trascurrido en el Reloj
     *
     * @param	view Formato del resultado: nanosegundos, milisegundos, segundos, minutos, horas
     * @return	double con valores o 0 en caso error
     */
    public synchronized double RelojVer(String view){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        double salida=0;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            TFinal=(System.nanoTime()-TInicio); //Tiempo Total
            switch(view){
		case "nanosegundos":
			//instrucciones//
                        salida=TFinal;
			break;
		case "milisegundos":
			//instrucciones//
                        salida=(TFinal/1000000); //Para Tener en milisegundos
			break;
		case "segundos":
			//instrucciones//
                        salida=(TFinal/1000000); //Para Tener en milisegundos
                        salida=(salida/1000); //Para Tener en segundos
			break; 
                case "minutos":
			//instrucciones//
                        salida=(TFinal/1000000); //Para Tener en milisegundos
                        salida=(salida/1000); //Para Tener en segundos
                        salida=(salida/60); //Para Tener en minutos
			break; 
                case "horas":
			//instrucciones//
                        salida=(TFinal/1000000); //Para Tener en milisegundos
                        salida=(salida/1000); //Para Tener en segundos
                        salida=(salida/60); //Para Tener en minutos
                        salida=(salida/60); //Para Tener en HORAS
			break;
		default:
			//instrucciones//
                        System.out.println("ERROR en RelojVer, motivo: Opcion no encontrada!, Valor regresado: 0");
			break;
            }
	}else{
            System.out.println("ERROR en RelojVer, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
}
