/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphic;

import Algoritms.Cad;
import Algoritms.Dimention;
import Algoritms.Nums;

/**Esta vercion v2.0 tiene soporte para valores negativos en el Grafico, usa como motor el Systema de grafico v1.5
 *
 * @author Ing Lalux
 */
public class BarGraphic {
    int lineasAltura=0;
    int espacioBarToBar=2;
    int numBars=0;
    float valMax=0;
    float valMin=0;
    String caracter="█";
    
    float[] vectorDataBarras; //Valores de Cada barra//
    //El Grafico Completo Expresado en un Vector de Filas//
    public String[] vectorFilas;
    
    /**
      * Descripcion: Construir un nuevo Grafico con Valores Custom
      * Se recomienda usar El Font: DialogInput
      * 
      * @param  Altura Numero de Lines de altura de la Grafica
      * @param  numBars Numero de Barras a tener
      * @param  vectorData Vector de datos
      */
    public BarGraphic(int Altura, int numBars, float[]vectorData){
        //Obtener los valors minimos y maximos del Vector//
        valMin=Dimention.getMinVaule(vectorData,0);
        valMax=Dimention.getMaxVaule(vectorData,0);
        this.numBars=numBars;
        lineasAltura=Altura;
        vectorDataBarras=vectorData.clone();
          
      //Existen 3 casos//
      
        //El caso en el que valMin y valMAx sean positivos//
            if((valMin>=0)&&(valMax>=0)){
                //Se crea un solo grafico//
                BarGraphicv1 graFv1 = new BarGraphicv1(Altura, numBars, valMin, valMax, false);
                graFv1.setVaulesBars(vectorData);
                //Obtener los Atributos del graficov1.5 para este grafico//
                vectorFilas=graFv1.vectorFilas;
            }
          
          
        //El caso en el que valMin y valMAx sean negativos//
            if((valMin<0)&&(valMax<=0)){
                //se crea un solo grafico pero con signos negativos y los valores invertidos//
                BarGraphicv1 graFv1 = new BarGraphicv1(Altura, numBars,Nums.valorAbsoluto(valMax),Nums.valorAbsoluto(valMin),true);
                //Invertir los valores de vectorData//
                for(int i=0; i<vectorData.length; i++){
                    vectorData[i]=Nums.valorAbsoluto(vectorData[i]);
                }
                graFv1.setVaulesBars(vectorData);
                //Obtener los Atributos del graficov1.5 para este grafico//
                vectorFilas=graFv1.vectorFilas;
            }
        
        //El caso en el que valMin y valMAx sean negativo y positivo//
            if((valMin<0)&&(valMax>=0)){
                //Definir una altura variable para cada Grafico deacuerdo a sus valores//
                float sumaMinMAx = Nums.valorAbsoluto(valMax)+Nums.valorAbsoluto(valMin);
                float valPerLine = sumaMinMAx/Altura;
                    int AlturaP=Nums.redondearEntero(valMax/valPerLine,0);
                    int AlturaN=Nums.redondearEntero(Nums.valorAbsoluto(valMin)/valPerLine,0);
                    if(AlturaP<1){
                        AlturaP=1;
                    }
                    if(AlturaN<1){
                        AlturaN=1;
                    }
                    
                    
                //Crear un Grafico con los valores Positivos//
                BarGraphicv1 grafPositive = new BarGraphicv1(AlturaP, numBars,valMin, valMax,false);
                grafPositive.setVaulesBars(vectorData);
                
                //Crear un Grafico con los valores Negativos//
                BarGraphicv1 grafNegative = new BarGraphicv1(AlturaN, numBars,-valMax,Nums.valorAbsoluto(valMin),true);
                    //Invertir los valores de vectorData//
                    for(int i=0; i<vectorData.length; i++){
                        vectorData[i]=-vectorData[i];
                    }
                    grafNegative.setVaulesBars(vectorData);
                
                //Unir los dos graficos para generar uno//
                String[] graficUnion = new String[grafPositive.vectorFilas.length+grafNegative.vectorFilas.length-1]; //MEnos uno porque se quita la linea base de un grafico
                
                for(int i=0; i<grafPositive.vectorFilas.length; i++){
                    graficUnion[i]=grafPositive.vectorFilas[i];
                }
                int aux=grafPositive.vectorFilas.length;
                //-2 en la inicializacion porque se quita la base de un grafico//
                for(int i=grafNegative.vectorFilas.length-2; i>=0;i--){
                    graficUnion[aux]=grafNegative.vectorFilas[i]; aux++;
                }
                vectorFilas=graficUnion;
                    
                    //Ajustar los anchos de los numeros de la Izquierda//
                    String anchoPositivo = vectorFilas[0];
                    anchoPositivo=Cad.subCadCadACadB(anchoPositivo,"+","|");
                    
                    String anchoNegative = vectorFilas[vectorFilas.length-1];
                    anchoNegative = Cad.subCadCadACadB(anchoNegative,"-","|");
                    
                    int anchoMayor;
                    if(anchoPositivo.length()>=anchoNegative.length()){
                        anchoMayor=anchoPositivo.length();
                    }else{
                        anchoMayor=anchoNegative.length();
                    }   
                        //Cambiando todos los numeros de izquierda de la Grafica Final//
                        String numeroCad="";
                        String cadena;
                        for(int i=0; i<vectorFilas.length; i++){
                            cadena=vectorFilas[i];
                            if(Cad.numOfContains(cadena,"--",false)>=1){
                                //ignorar, porque es la linea punteada
                            }else{
                                numeroCad=Cad.subCadPosACadB(cadena,1,"|");
                                numeroCad=Nums.AjustarTamFloat(Cad.aFloat(numeroCad,0),anchoMayor);
                                
                                cadena=Cad.EliminarPosACadB(cadena,1,"|");
                                cadena=Cad.InsertCad(cadena,numeroCad,1);
                            }
                            vectorFilas[i]=cadena;
                        }
                    
                
                //Regresar el vector a la Normalidad, porque este tipo de datos se pasan por Valor//
                    for(int i=0; i<vectorData.length; i++){
                        vectorData[i]=-vectorData[i];
                    }
            }
            
    }
    
    
    
    /**
     * Descripcion: Imprimir el Grafico en Consola
     *
     */
    public void ImprimirGrafico(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vectorFilas.length; i++){
                System.out.println(vectorFilas[i]);
            }
        }else{
            System.out.println("ERROR en ImprimirGrafico, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
    
    
    
    
    
    
    /**Clase Vieja del Grafico, esta vercion no tiene soporte para valores negativos, por eso es Osoleta
    *
    * @author Ing Lalux
    */
    public class BarGraphicv1{
        int lineasAltura=0;
        int espacioBarToBar=2;
        int numBars=0;
        float valMax=0;
        float valMin=0;
        String caracter="█";
        public boolean graficoNegativo=false;

        float[] valBar; //Valores de Cada barra//
        float[] valLinea; //Valor Minimo inclusive asignado a cada Linea//

        //El Grafico Completo Expresado en un Vector de Filas//
        public String[] vectorFilas;


        /**
         * Descripcion: Construir un nuevo Grafico con Valores Custom
         * Se recomienda usar El Font: DialogInput
         *
         * @param   Altura Numero de Lines de altura de la Grafica
         * @param   numBars Numero de Barras a tener
         * @param   valMAX Valor Maximo del grafico
         * @param   valMIN Valor Minimo del grafico
         * @param   graficNegative  Si es asi agregar signos negativos al momento de su construccion, sino signos positivos
         */
        public BarGraphicv1(int Altura, int numBars, float valMIN, float valMAX, boolean graficNegative){
            lineasAltura=Altura;
            this.numBars=numBars;
            this.graficoNegativo=graficNegative;

            valLinea= new float[Altura];
            valBar = new float[numBars];

            valMax=valMAX;
            valMin=valMIN;

            setVauleMinPerLine();

            //Inicializar vector del Grafico//
            vectorFilas = new String[lineasAltura+1];
            for(int i=0; i<vectorFilas.length; i++){
                vectorFilas[i]="";
            }

            //Generar el Grafico aunque no tenga valores las Barras//
            GenerarGrafico();
        }



        /**
         * Descripcion: Asignar los Valores Minimos y Maximos entre cada Linea
         *
         * @param	parametros
         */
        private void setVauleMinPerLine(){
        //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";

        float magnitudLine=0;
        valLinea= new float[lineasAltura];
        //Comprobar Condiciones Iniciales//

            //Comenzar Proceso//
            if(condiciones==true){
                //magnitudLine=valMax/lineasAltura;
                magnitudLine=(valMax-valMin)/lineasAltura;

                valLinea[0]=valMax-magnitudLine;
                for(int i=1; i<lineasAltura; i++){
                    valLinea[i]=valLinea[i-1]-magnitudLine;
                    if(valLinea[i]<0){
                        valLinea[i]=0;
                    }
                }
            }else{
                System.out.println("ERROR en setVauleMinPerLine, motivo: "+motivo);
            }
        //Terminar Proceso//
            //System.out.println("Proceso identificador Terminado");
        }


        /**
         * Descripcion: Asignarle un valor de altura a una determinada barra
         *
         * @param	numBar Numero de la Barra a Modificar
         * @param   valor Valor Nuevo
         */
        public void setVauleBar(int numBar, int valor){
        //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";
        //Comprobar Condiciones Iniciales//
        if(!((valor>=valMin)&&(valor<=valMax))){
            condiciones=false;
            motivo=valor+" No esta en el rango de: "+valMin+" - "+valMax;
        }
        if(numBar>numBars){
            condiciones=false;
            motivo="Barra numero: "+numBar+" no existe!";
        }
            //Comenzar Proceso//
            if(condiciones==true){
                valBar[numBar]=valor;
            }else{
                System.out.println("ERROR en setVauleBar, motivo: "+motivo);
            }

            //Generar Grafico//
            GenerarGrafico();
        //Terminar Proceso//
            //System.out.println("Proceso identificador Terminado");
        }


        /**
         * Descripcion: Asignarle un valor de altura a una determinada barra
         *
         * @param	numBar Numero de la Barra a Modificar
         * @param   valor Valor Nuevo
         */
        public void setVauleBar(int numBar, float valor){
        //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";
        //Comprobar Condiciones Iniciales//
        if(!((valor>=valMin)&&(valor<=valMax))){
            condiciones=false;
            motivo=valor+" No esta en el rango de: "+valMin+" - "+valMax;
        }
        if(numBar>numBars){
            condiciones=false;
            motivo="Barra numero: "+numBar+" no existe!";
        }
            //Comenzar Proceso//
            if(condiciones==true){
                valBar[numBar]=valor;
            }else{
                System.out.println("ERROR en setVauleBar, motivo: "+motivo);
            }

            //Generar Grafico//
            GenerarGrafico();
        //Terminar Proceso//
            //System.out.println("Proceso identificador Terminado");
        }



        /**
         * Descripcion: Dar valores a las baras del grafico usando un vector
         *
         * @param	vector Valores de las barras
         */
        public void setVaulesBars(float[] vector){
        //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";
        //Comprobar Condiciones Iniciales//

            //Comenzar Proceso//
            if(condiciones==true){
                for(int i=0; i<numBars; i++){
                    setVauleBar(i, vector[i]);
                }
            }else{
                System.out.println("ERROR en setVaulesBars, motivo: "+motivo);
            }

            //Generar Grafico//
            GenerarGrafico();
        //Terminar Proceso//
            //System.out.println("Proceso identificador Terminado");
        }


        /**
         * Descripcion: Dar valores a las baras del grafico usando un vector
         *
         * @param	vector Valores de las barras
         */
        public void setVaulesBars(int[] vector){
        //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";
        //Comprobar Condiciones Iniciales//

            //Comenzar Proceso//
            if(condiciones==true){
                for(int i=0; i<numBars; i++){
                    setVauleBar(i, vector[i]);
                }
            }else{
                System.out.println("ERROR en setVaulesBars, motivo: "+motivo);
            }

            //Generar Grafico//
            GenerarGrafico();
        //Terminar Proceso//
            //System.out.println("Proceso identificador Terminado");
        }


        /**
         * Descripcion: Imprimir el Grafico en consola
         *
         */
        public void imprimirGrafico(){
        //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";

        int tamValMax=Nums.aCadena(Nums.recortarDecimales(valLinea[0], 1)).length();
        //Comprobar Condiciones Iniciales//
            //Comenzar Proceso//
            if(condiciones==true){
                for(int i=0; i<lineasAltura; i++){
                    //Imprimir Lado Izquierdo Tabla//
                        if(graficoNegativo==true){ //Generar el Signo//
                            System.out.print("-");
                        }else{
                            System.out.print("+");
                        }
                    System.out.print(Nums.AjustarTamFloat(Algoritms.Nums.recortarDecimales(valLinea[i], 1), tamValMax));
                    System.out.print("|");

                    for(int x=0; x<numBars; x++){
                        //Imprimir el espacio entre barras
                        for(int y=0; y<espacioBarToBar; y++){
                            System.out.print(" ");
                        }

                        //imprimir barras
                        if(valBar[x]>valLinea[i]){
                            System.out.print(caracter);
                        }else{
                            System.out.print(" ");
                        }
                    }
                    System.out.println("");
                }

                //Imprimir Lado Abajo Tabla//
                for(int i=0; i<Integer.toString((int) valMax).length()+3; i++){
                    System.out.print("-");
                }
                for(int i=0; i<numBars; i++){
                    System.out.print("-");
                }
                for(int i=0; i<espacioBarToBar*numBars; i++){
                    System.out.print("-");
                }
                System.out.println("");
            }else{
                System.out.println("ERROR en imprimirGrafico, motivo: "+motivo);
            }
        //Terminar Proceso//
            //System.out.println("Proceso identificador Terminado");
        }



        /**
         * Descripcion: Generar el Grafico en Forma de vectorFilas
         *
         */
        private void GenerarGrafico(){
        //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";

        int posVectorFilas=0;
        int tamValMax=Nums.aCadena(Nums.recortarDecimales(valLinea[0], 1)).length();
        //Reconstruir el Vector de Filas y los ValoresMinimos y Maximos//
        setVauleMinPerLine();
        vectorFilas = new String[lineasAltura+1];
        //Comprobar Condiciones Iniciales//

            //Comenzar Proceso//
            if(condiciones==true){
                //ReFormatear el Vector de Filas del grafico//
                for(int i=0; i<vectorFilas.length; i++){
                    vectorFilas[i]="";
                }

                for(int i=0; i<lineasAltura; i++){
                    //Imprimir Lado Izquierdo Tabla//
                        if(graficoNegativo==true){ //Generar el Signo//
                            vectorFilas[posVectorFilas]=vectorFilas[posVectorFilas].concat("-");
                        }else{
                            vectorFilas[posVectorFilas]=vectorFilas[posVectorFilas].concat("+");
                        }
                    vectorFilas[posVectorFilas]=vectorFilas[posVectorFilas].concat(Nums.AjustarTamFloat(Nums.recortarDecimales(valLinea[i], 1), tamValMax));
                    vectorFilas[posVectorFilas]=vectorFilas[posVectorFilas].concat("|");

                    for(int x=0; x<numBars; x++){
                        //Imprimir el espacio entre barras
                        for(int y=0; y<espacioBarToBar; y++){
                            vectorFilas[posVectorFilas]=vectorFilas[posVectorFilas].concat(" ");
                        }

                        //imprimir barras
                        if(valBar[x]>valLinea[i]){
                            vectorFilas[posVectorFilas]=vectorFilas[posVectorFilas].concat(caracter);
                        }else{
                            String vacio=" ";
                            for(int z=1; z<caracter.length(); z++){
                                vacio=vacio.concat(" ");
                            }
                            vectorFilas[posVectorFilas]=vectorFilas[posVectorFilas].concat(vacio);
                        }
                    }
                    posVectorFilas=posVectorFilas+1;
                }

                //Imprimir Lado Abajo Tabla//
                vectorFilas[posVectorFilas]=vectorFilas[posVectorFilas].concat("-"); //Por el caracter del signo//
                for(int i=0; i<Integer.toString((int) valMax).length()+3; i++){
                    vectorFilas[posVectorFilas]=vectorFilas[posVectorFilas].concat("-");
                }
                for(int i=0; i<numBars*caracter.length(); i++){
                    vectorFilas[posVectorFilas]=vectorFilas[posVectorFilas].concat("-");
                }
                for(int i=0; i<espacioBarToBar*numBars; i++){
                    vectorFilas[posVectorFilas]=vectorFilas[posVectorFilas].concat("-");
                }
                posVectorFilas=posVectorFilas+1;
            }else{
                System.out.println("ERROR en GenerarGrafico, motivo: "+motivo);
            }
        //Terminar Proceso//
            //System.out.println("Proceso identificador Terminado");
        }


        /**
         * Descripcion: Obtener el Grafico expresado en un Vector Fila a Fila
         *
         * @return	NULL o GRAFICO
         */
        public String[] getGrafico (){
        //Variables Locales e Inicializacion//
            boolean condiciones=true;
            String motivo="Indeterminado";
            String[] salida=null;
        //Comprobar Condiciones Iniciales//

            //Comenzar Proceso//
            if(condiciones==true){
                salida=vectorFilas;
            }else{
                System.out.println("ERROR en getGrafico, motivo: "+motivo+", valor regresado: "+salida);
            }
        //Terminar Proceso//
            return salida;
        }



        /**
         * Descripcion: Configurar Aspectos del Grafico como:
         *  Ejem  "SimboloBarras=@|SeparadorEntreBarras=3" "|"
         *
         * @param	Comandos Instrucciones a Operar
         * @param   separadorComandos Separador entre Instrucciones de Comando
         */
        public void ConfigureGrafic(String Comandos, String separadorComandos){
        //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";

        String[] vectorComandos;
        //Comprobar Condiciones Iniciales//

            //Comenzar Proceso//
            if(condiciones==true){
                vectorComandos=Cad.aVector(Comandos,separadorComandos);

                //Operar Todos los Comandos//
                String comando="";
                String valor="";
                for(int i=0; i<vectorComandos.length; i++){
                    comando=Cad.subCadPosACadB(vectorComandos[i],0,"=");
                    valor=Cad.subCadCadAPosB(vectorComandos[i],"=",vectorComandos[i].length());
                    //Comprobar que exista el comando//
                    switch(comando){
                        case "SimboloBarras":
                            caracter=valor;
                            GenerarGrafico();
                            break;
                        case "EspacioEntreBarras":
                            espacioBarToBar=Cad.aEntero(valor,2);
                            GenerarGrafico();
                            break;
                        case "AnchoDeBarras":
                            for(int x=0; x<Cad.aEntero(valor,1)-1; x++){
                                caracter=caracter.concat(caracter);
                            }
                            if(Cad.aEntero(valor,1)==0){
                                caracter="";
                            }
                            GenerarGrafico();
                            break;
                        case "Altura":
                            lineasAltura=Cad.aEntero(valor,5);
                            GenerarGrafico();
                            break;
                        default:
                            motivo="No se Encontro Comando: "+comando;
                            System.out.println("ERROR en ConfigureGrafic, motivo: "+motivo);
                            System.out.println("Comandos Soportados:\n"
                                    + "SimboloBarras=#\n"
                                    + "EspacioEntreBarras=2\n"
                                    + "AnchoDeBarras=1\n"
                                    + "Altura=5\n");
                            break;
                    }
                }
            }else{
                System.out.println("ERROR en ConfigureGrafic, motivo: "+motivo);
            }
        //Terminar Proceso//
            //System.out.println("Proceso identificador Terminado");
        }
    }
    
    
    
    /**
     * Descripcion: Funcion de ayuda para poder Implementar Correctamente esta libreria de Graficos
     *
     */
    public static void HELP(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    
    int respuesta=0;
    BarGraphic temp2;
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            while(respuesta!=5){
                System.out.println("*******SECCION DE AYUDA PARA IMPLEMENTAR BARGRAPHIC********");
                System.out.println("1.- Que es BarGraphic?");
                System.out.println("2.- Implementacion");
                System.out.println("3.- Bugs");
                System.out.println("4.- Vercion y Creditos");
                System.out.println("5.- Exit");
                respuesta=Cad.aEntero(Cad.LeerCadena(),-1);
                
                switch(respuesta){
                    case 1:
                        System.out.println("->Que es BarGraphic");
                        System.out.println("BarGrafic es un sistema que implementa una interface de graficos de barras");
                        System.out.println("Ejemplo:");
                            //BarGraphic temp = new BarGraphic(5,5,0,10);
                            //temp.setVaulesBars(Dimention.GeneraVectorAleatorio(5,0,10));
                            //temp.ImprimirGrafico(); System.out.println("");
                        break;
                    case 2:
                        System.out.println("->Implementacion");
                        System.out.println("1.- Como hacer un Grafico?");
                        System.out.println("2.- Como agregar Valores a las Barras?");
                        System.out.println("3.- Como modificar la apariencia de un Grafico?");
                        int resp2=Cad.aEntero(Cad.LeerCadena(),-1);
                        switch(resp2){
                            case 1:
                                System.out.println("->Implementacion->Como hacer un Grafico?");
                                System.out.println("Usamos el Constructor BarGrafic(Altura, numBars, valMin, valMax)");
                                System.out.println("Parametro: Altura es el numero de lineas verticales que ocupara el grafico, sobre esto se define la escala automaticamente");
                                System.out.print("Ingrese la altura:"); int altura=Cad.aEntero(Cad.LeerCadena(),0);
                                System.out.println("Parametro: numBars define el numero de Barras que tendra el grafico");
                                System.out.print("Ingrese el numero de Barras:"); int barras=Cad.aEntero(Cad.LeerCadena(),0);
                                System.out.println("Parametro: valMin define la altura minima que tendra alguna barra");
                                System.out.print("Ingrese el valMin:"); int min=Cad.aEntero(Cad.LeerCadena(),0);
                                System.out.println("Parametro: valMax define la altura maxima que tendra alguna barra");
                                System.out.print("Ingrese el valMax:"); int max=Cad.aEntero(Cad.LeerCadena(),0);
                                System.out.println("Se Creara el Grafico con el Contructor BarGraphic("+altura+","+barras+","+min+","+max+")");
                                //temp2 = new BarGraphic(altura,barras, min, max);
                                //temp2.imprimirGrafico(); System.out.println("");
                                break;
                            case 2:
                                //temp2 = new BarGraphic(4,3,0,10);
                                System.out.println("->Implementacion->Como agregar valores a las graficas?");
                                System.out.println("Primero se tiene que construir un Grafico por lo que se hara BarGraphic(4,3,0,10)");
                                //temp2.imprimirGrafico();
                                System.out.println("Para Agregar valores a las barras se puede hacer con la funcion setValuresBars(Vector)");
                                System.out.println("Parametro: Vector es un Vector con los valores de las barras definidos");
                                System.out.println("Ingrese Valores separados por comas y se hara un vector con esos datos Ejm: 3,6,9...");
                                String vectS=Cad.LeerCadena();
                                int[] vect=Dimention.convertVectorStringToVectorInt(Cad.aVector(vectS,","));
                                //temp2.setVaulesBars(vect);
                                System.out.println("Se Asignaran valores al Grafico setVaulesBars("+vectS+")");
                                System.out.println("Si se tienen mas valores en el vector que el numero de barras definido, estos se ignoraran");
                                //temp2.imprimirGrafico(); System.out.println("");
                                break;
                            case 3:
                                //temp2 = new BarGraphic(4,3,0,10);
                                //temp2.setVaulesBars(Dimention.convertVectorStringToVectorInt(Cad.aVector("3,6,9",",")));
                                System.out.println("->Implementacion->Como modificar Apariencia?");
                                System.out.println("Primero se tiene que tener un Grafico por lo que se hara BarGraphic(4,3,0,10)");
                                //temp2.imprimirGrafico();
                                System.out.println("Para modificar la apariencia se usa la funcion ConfigureGrafico(Comandos,SeparadorComandos)");
                                System.out.println("Que recibe una serie de Comandos con los que modifica el grafico Ejm  ConfigureGrafico(SimboloBarras=#)");
                                //temp2.ConfigureGrafic("SimboloBarras=#","|");
                                //temp2.imprimirGrafico(); System.out.println("");
                                break;
                        }
                        break;
                    case 3:
                        System.out.println("->Bugs");
                        System.out.println("Ninguno Conocido"); System.out.println("");
                        break;
                    case 4:
                        System.out.println("->Vercion y Creditos");
                        System.out.println("*********************************");
                        System.out.println("    BarGraphic v1.5");
                        System.out.println("    Creador: Ing Eduard'OS");
                        System.out.println("    Laboratorios: SAA");
                        System.out.println("*********************************");
                        System.out.println("Verciones y Funcionalidades");
                        System.out.println("v1.0"); System.out.println("    Simple Grafico");
                        System.out.println("v1.5"); System.out.println("    +Indicadores Escala lateral izquierda\n\t+Configurador de Apariencia");System.out.println("");
                        break;
                }
            }
        }else{
            System.out.println("ERROR en HELP, motivo: "+motivo);
	}
    //Terminar Proceso//
	System.out.println("Proceso HELP Terminado");
    }
    
    
}
