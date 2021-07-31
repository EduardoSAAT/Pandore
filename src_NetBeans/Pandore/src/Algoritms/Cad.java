package Algoritms;


import Archivos.Text;
import DataStructure.Nodo;
import DataStructure.TreeString;
import Dinamic.MatrizLong;
import Dinamic.VectorLong;
import Dinamic.VectorString;
import Graphic.BarGraphic;
import Graphic.ErrorCatcher;
import java.util.Scanner;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author PC1
 */
public class Cad {

    /**
    * Descripcion: Concatenar una SubCadena en una Cad en alguna posicion de Cad
   -Contando desde Cero;
   -Si la posicion esta entre la longitud de la cad: Se INSERTA en la cad;
   -Si la posicion es mayor a la cad: Se Insertan caracteres "caracter";
    * @param  cad Cad a Modificar
    * @param  subCad SubCadena a Concatenar
    * @param  pos Posicion a concatenar
    * @param  cadVacio a usar en espacios vacios
    * @return Regresa String Vacio ERROR, otro caso String con Cadenas
    */
    public static String concatPOS(String cad, String subCad, int pos, String cadVacio){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String salida="";
    //Comprobar Condiciones Iniciales//

	//Comenzar Proceso//
        if(condiciones==true){
            if((pos<0)){ //Posicion atras de la Cad
                salida=concatPOS(subCad,cad,-pos,cadVacio);
            }
            if((pos>=0)&&(pos<cad.length())){ //Posicion esta entre la Cad
                for(int i=0; i<cad.length();i++){
                    if(i==pos){
                        salida=salida.concat(subCad);
                        salida=salida.concat(cad.substring(i, i+1));
                    }else{
                        salida=salida.concat(cad.substring(i, i+1));
                    } 
                }
            }
            if(pos>=cad.length()){ //Posicion despues de la cadena
                salida=salida.concat(cad);
                for(int i=0; i<(pos-cad.length());i++){
                  salida=salida.concat(cadVacio);  
                }
                salida=salida.concat(subCad);
            }
	}else{
            System.out.println("ERROR en concatPOS, valor regresado: "+salida); 
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Comprobar si dos cadenas son Iguales Evitando Problemas de NULL y ""
     *
     * @param	cad1 Cadena uno a Comprobar
     * @param   cad2 Cadena dos a Comprobar
     * @param   IgnoreCase Ignorar minusculas y mayusculas
     * @return	true o false
     */
    public static boolean Equals (String cad1, String cad2, boolean IgnoreCase){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
        
        boolean cad1NULL = false;
        boolean cad2NULL = false;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            if(cad1==null){
                cad1NULL=true;
            }
            if(cad2==null){
                cad2NULL=true;
            }
            
            if(cad1NULL==true&&cad2NULL==true){
                salida=true;
            }else{
                if(cad1==null||cad2==null){
                    salida=false;
                }else{
                    if(IgnoreCase){
                        if(cad1.equalsIgnoreCase(cad2)){
                            salida=true;
                        }
                    }else{
                        if(cad1.equals(cad2)){
                            salida=true;
                        }
                    }
                }
            }
	}else{
            System.out.println("ERROR en Equals, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Eliminar todas las coincidencias de una subcadena encontradas en una Cad
     *
     * @param	cadOriginal Donde buscar la subcad
     * @param   subCad Cad a Eliminar
     * @return	String vacio o con cadenas Eliminadas
     */
    public static String EliminarSubcadALL (String cadOriginal, String subCad){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
    if(cadOriginal==null){
        condiciones=false;
        motivo="CadOriginal Null";
    }
    if(subCad==null){
        condiciones=false;
        motivo="subCad Null";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=remplazarSubCadALL(cadOriginal, subCad, "");
	}else{
            System.out.println("ERROR en EliminarSubcadALL, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Eliminar una subcadena numero N de una Cad
     *
     * @param	cadOriginal Donde eliminar la subcadena
     * @param   subCad Que subcadena Eliminar
     * @param   numConteins numero de Coincidencia a Eliminar
     * @return	String con subcadena Eliminada
     */
    public static String EliminarSubcadNUM (String cadOriginal, String subCad, int numConteins){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            salida=remplazarSubCadNUM(cadOriginal, subCad, "", numConteins);
	}else{
            System.out.println("ERROR en remplazarSubCad, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Eliminar una subcadena desde una PosA, y con un tamaño espesifico
     *
     * @param	cadOriginal Cad donde Eliminar subcadena
     * @param   PosA Posicion Inicial
     * @param   Tam Numero de caracteres a eliminar
     * @return	Cad sin substring
     */
    public static String EliminarPosATam (String cadOriginal, int PosA, int Tam){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        
        int PosB=PosA+Tam;
    //Comprobar Condiciones Iniciales//
    if((PosA<0)||(PosA>cadOriginal.length())){
        condiciones=false;
        motivo="PosA no Valida";
    }
    if((PosB<PosA)||(PosB>cadOriginal.length())){
        condiciones=false;
        motivo="PosB no Valida";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=EliminarPosAPosB(cadOriginal, PosA, PosB);
	}else{
            System.out.println("ERROR en EliminarPosATam, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Eliminar una Subcadena desde una posicionA hasta una CadenaB
     *      La CadB siempre se buscara despues de la posA
     *
     * @param	CadOriginal Cadena Original a Modificar
     * @param   posA Posicion Inicial de la Subcadena a Eliminar
     * @param   CadB PosicionFinal que no se eliminara
     * @return	valores de retorno
     */
    public static String EliminarPosACadB (String CadOriginal, int posA, String CadB){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=CadOriginal;
        
        String temp=subCadPosAPosB(CadOriginal, posA,CadOriginal.length());
        int posB = posOfContains(temp, CadB, false);
    //Comprobar Condiciones Iniciales//
    if(posB==-1){
        condiciones=false;
        motivo="No se encontro:"+CadB+" en la CadOriginal:"+CadOriginal+" despues de la posA:"+posA+" siendo la subCad:"+temp;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=subCadPosAPosB(CadOriginal,0,posA)+subCadPosAPosB(temp, posB,temp.length());
	}else{
            System.out.println("ERROR en EliminarPosACadB, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Eliminar una Subcadena desde una CadenaA hasta una CadenaB
     *      La CadB siempre se buscara despues de la CadA
     *
     * @param	CadOriginal Cadena Original a Modificar
     * @param   CadA Cadena inicial que no se eliminara
     * @param   CadB PosicionFinal que no se eliminara
     * @return	null en caso de error, "" o subcadena
     */
    public static String EliminarCadACadB (String CadOriginal, String CadA, String CadB){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
        
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            //Obtener las dos posiciondes de las dos cadenas//
            int posCadA = posOfContains(CadOriginal, CadA, false);
            
            String temp = subCadCadAPosB(CadOriginal, CadA, CadOriginal.length());
            int posCadB = posOfContains(temp, CadB, false);
            
            //Si estas dos cadenas existen, entonces eliminar la subcadena entre ellas//
            if((posCadA>=0)&&(posCadB>=0)){
                String part1 = subCadANTESdeCad(CadOriginal, CadA)+CadA;
                String part2 = CadB+subCadPosAPosB(CadOriginal,posCadB+posCadA+CadA.length()+1,CadOriginal.length());
                salida=part1+part2;
            }
	}else{
            System.out.println("ERROR en EliminarPosACadB, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Eliminar una una subcadena desde una PosA hasta una PosB
     *
     * @param	cadOriginal Donde eliminar el substring
     * @param   PosA Posicion Inicial
     * @param   PosB Posicion Final
     * @return	Cad sin substring
     */
    public static String EliminarPosAPosB (String cadOriginal, int PosA, int PosB){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
    if((PosA<0)||(PosA>cadOriginal.length())){
        condiciones=false;
        motivo="PosA no Valida";
    }
    if((PosB<PosA)||(PosB>cadOriginal.length())){
        condiciones=false;
        motivo="PosB no Valida";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=cadOriginal.substring(0, PosA);
            salida=salida.concat(cadOriginal.substring(PosB, cadOriginal.length()));
	}else{
            System.out.println("ERROR en EliminarPosAPosB, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Remplazar todas la coincidencias de una subcadena por un remplazo en una Cad
     *
     * @param	cadOriginal Donde buscar y remplazar
     * @param   subCad Subcadena a remplazar
     * @param   remplazo Cad de remplazo
     * @return	cadOriginal con cadena remplazo
     */
    public static String remplazarSubCadALL (String cadOriginal, String subCad, String remplazo){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=cadOriginal;
        
        int numConteins=numOfContains(cadOriginal, subCad, false);
        int i=0;
    //Comprobar Condiciones Iniciales//
    if((numConteins<=0)&&(subCad.length()>0)){
        condiciones=false;
        motivo=subCad+" No encontrada en: "+cadOriginal;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(i=0; i<numConteins; i++){
                salida=remplazarSubCadNUM(cadOriginal, subCad, remplazo, 1);
                cadOriginal=salida;
            }
	}else{
            //System.out.println("ERROR en remplazarSubCadALL, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Remplazar una subcadena de coincidencia numero N encontrada en una Cad
     *
     * @param	cadOriginal Donde buscar la subcadena a remplazar
     * @param   subCad Coincidencia a remplazar
     * @param   remplazo Cad de remplazo
     * @param   numConteins Numero de coincidencia de la subcadena
     * @return	CadOriginal con subcads Remplazadas
     */
    public static String remplazarSubCadNUM (String cadOriginal, String subCad, String remplazo, int numConteins){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        
        int posConteins=posOfContainsNum(cadOriginal, subCad, numConteins, false);
    //Comprobar Condiciones Iniciales//
    if(posConteins<=-1){
        condiciones=false;
        motivo=subCad+" numero:"+numConteins+" no encontrada en: "+cadOriginal;
        salida=cadOriginal;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Concatenar del inicio de la cadena Original Hasta la posicion del Contenido//
            salida=salida.concat(cadOriginal.substring(0, posConteins));
            //Concatenar el remplazo//
            salida=salida.concat(remplazo);
            //concatenar el resto de la cadena Original//
            salida=salida.concat(cadOriginal.substring(posConteins+subCad.length(), cadOriginal.length()));
            
	}else{
            System.out.println("ERROR en remplazarSubCadNUM, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Comprobar si una cadena es nula o vacia
     *
     * @param	cadena Cadena a evaluar
     * @return	true o false
     */
    public static boolean isNulloVacia (String cadena){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            if(cadena==null){
                salida=true;
            }else{
                if(cadena.equals("")){
                    salida=true;
                }
            }
	}else{
            System.out.println("ERROR en isNulloVacia, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
    * Descripcion: Modificar una Cad dada la posicion a modificar
   Ejemplo: hola, wx, 0 = wxla
   Ejemplo: hola, wx, 3 = holwx
    * @param  cadOriginal Cad para Modificar
    * @param  cadRemplazo Cad de Remplazo 
    * @param pos Posicion de Inicio del Remplazo
    * @return Regresa Cad Modificada o Cad Vacia ERROR,
    */
    public static String remplazarPOS(String cadOriginal, String cadRemplazo, int pos){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="";
        String salida="";
    //Comprobar Condiciones Iniciales//
    if(pos<0){
        condiciones=false;
        motivo="Posicion no Valida";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<(cadOriginal.length());i++){
                if(i==pos){ //Si se esta en la posicion de remplazo
                    salida=salida.concat(cadRemplazo);
                    if(cadRemplazo.length()>1){ //Para poder Remplazar correctamente todos los caracteres
                        i=i+cadRemplazo.length()-1;
                    }
                }else{
                    salida=salida.concat(cadOriginal.substring(i, i+1)); //Si no se esta en la posicion de remplazo
                }
            }
	}else{
            System.out.println("ERROR en remplazarSubCad, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
    * Descripcion: Encontrar la primer posicion en que se encuentra una subcadena
    * 
    * @param  cad Cad a evaluar
    * @param  subCad Cad a buscar   
    * @param  ignoreCase True Ignorar Mayusculas, False No Ignora;  
    * @return Regresa Numero desde 0 hasta cad.length;
    *         -1 no encontro subcad;
    */
    public static int posOfContains(String cad, String subCad, boolean ignoreCase){
    //Variables Locales e Inicializacion//
        int inicio=0;
        int fin=subCad.length();
        String cadAux="";
        int contador=0;
        boolean termine=false;
        
    //Comprobar Condiciones Iniciales//
        if(isNulloVacia(cad)){
            return -1;
        }else{
            if(ignoreCase==true){   
                cad=cad.toUpperCase();
                subCad=subCad.toUpperCase();
            }
            if((cad.length()>=1)&&(subCad.length()==0)){
                return -1;
            }
        }
        //Comenzar Proceso//
        do{
            if(fin<=cad.length()){
                cadAux=cad.substring(inicio, fin);
                if(cadAux.equals(subCad)){
                    contador=contador+1;
                    termine=true;
                }
            }else{
                termine=true;
            }
            inicio=inicio+1;
            fin=inicio+subCad.length();
        }while(termine==false);
        //Terminar Proceso//
        if(contador==0){
            inicio=0;
            //System.out.println("ALERTA en posOfContains, no se encontro "+subCad+" en "+cad+"; return:-1");
        }
        return (inicio-1);
    }
    
    
    /**
     * Descripcion: Saber si una cadena contiene solamente elementos de un conjunto
     *
     * @param	cadena Cad donde Buscar
     * @param   conjunto Elementos a buscar
     * @param   separador separador del conjunto
     * @return	Trueo False
     */
    public static boolean OnlyContains (String cadena, String conjunto, String separador){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
        
        int posSeparador=0;
        String element="";
        conjunto=conjunto.concat(separador); //Agregar separador al final
    //Comprobar Condiciones Iniciales//
    if(numOfContains(conjunto,separador,false)<1){
        condiciones=false;
        motivo="El separador no se encuentra en el conjunto";
        salida=false;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            conjunto=conjunto+separador;
            while((cadena.length()>0)&&(conjunto.length()>0)){
                posSeparador=posOfContains(conjunto, separador, false);
                if(posSeparador<0){
                    posSeparador=conjunto.length();
                }
                
                element=conjunto.substring(0, posSeparador);
                cadena=Cad.EliminarSubcadALL(cadena, element);
                conjunto=conjunto.substring(posSeparador+1, conjunto.length());
            }
            
            if(cadena.length()==0){
                salida=true;
            }else{
                salida=false;
            }
	}else{
            System.out.println("ERROR en OnlyContains, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Encontrar que elementos de un conjunto se encuentran en una cadena
     *
     * @param	cad Cad a buscar elementos
     * @param   conjunto Conjunto de Elementos separados por separador
     * @param   separador Cad que separa elementos del conjunto
     * @return	Conjunto con elementos Encontrados separados con mismo separador
     */
    public static String ElementsContains (String cad, String conjunto, String separador){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        
        //Agregar el separador al final de conjunto EVITA ERRORES//
        conjunto=conjunto.concat(separador);
        String elemento="";
        int sizeConjunto=numOfContains(conjunto, separador, false);
    //Comprobar Condiciones Iniciales//
    if(isNulloVacia(separador)){
        condiciones=false;
        motivo="Separador NULL";
    }
    if(cad==null||conjunto==null){
        condiciones=false;
        motivo="Conjunto o Cadena Vacia";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<sizeConjunto; i++){
                //Obtener el elemento del conjunto//
                elemento=subCadANTESdeCad(conjunto, separador);
            
                //Quitar el elemento ya evaluado//
                conjunto=subCadDESPUESdeCad(conjunto, separador);
                
                //Si existe elemento, agregarlo al conjunto resultante//
                if(numOfContains(cad, elemento, false)>=1){
                    salida=salida+elemento+separador;
                }
            }
	}else{
            System.out.println("ERROR en ElementsContains, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Encontrar el numero de elementos de un conjunto se encuentran en una cadena
     *  Ejmplo   "Holamundo,como" "Hola" = 1
     * 
     * @param	cad Cad a buscar elementos
     * @param   conjunto Conjunto de Elementos separados por separador
     * @param   separador Cad que separa elementos del conjunto
     * @return	Numero de coincidencias
     */
    public static int numOfContains(String cad, String conjunto, String separador){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
        //Agregar el separador al final de conjunto EVITA ERRORES//
        conjunto=conjunto.concat(separador);
        String elemento="";
        int sizeConjunto=numOfContains(conjunto, separador, false);
    //Comprobar Condiciones Iniciales//
        if(cad.equals("")){
            condiciones=false;
            motivo="Cadena Vacia!";
        }
        if(conjunto.equals(separador)){
            condiciones=false;
            motivo="Conjunto Vacio!";
        }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<sizeConjunto; i++){
                //Obtener el elemento del conjunto//
                elemento=subCadANTESdeCad(conjunto, separador);
            
                //Quitar el elemento ya evaluado//
                conjunto=subCadDESPUESdeCad(conjunto, separador);
                
                //Buscarlo Cad y Sumar coincidencias Totales//
                salida=salida+numOfContains(cad, elemento, false);
            }
	}else{
            System.out.println("ERROR en numOfContains, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
    * Descripcion: Contar numero de Veces que se encuentra una subcadena en una cadena
    * 
    * @param  cad Cad a evaluar
    * @param  subCad Cad a buscar   
    * @param  ignoreCase True Ignorar Mayusculas, False No Ignora;  
    * @return Regresa Numero desde 0 hasta N.
    */
    public static int numOfContains(String cad, String subCad, boolean ignoreCase){
    //Variables Locales e Inicializacion//
        int inicio=0;
        int fin=subCad.length();
        String cadAux="";
        int contador=0;
        boolean termine=false;
        
    //Comprobar Condiciones Iniciales//
        if(ignoreCase==true){   
            cad=cad.toUpperCase();
            subCad=subCad.toUpperCase();
        }
        if(Cad.isNulloVacia(cad)||Cad.isNulloVacia(subCad)){
            return 0;
        }
        if((cad.length()>=1)&&(subCad.length()==0)){
            return 0;
        }
        //Comenzar Proceso//
        do{
            if(fin<=cad.length()){
                cadAux=cad.substring(inicio, fin);
                if(cadAux.equals(subCad)){
                    contador=contador+1;
                }
            }else{
                termine=true;
            }
            inicio=inicio+1;
            fin=inicio+subCad.length();
        }while(termine==false);
        //Terminar Proceso//
        return contador;
    }
    
    
     /**
     * Descripcion: Numero de Coincidencias Exactas de un elemento en un Conjunto
     *  Ejmplo  "Holamundo,como," "Hola" = 0
     * @param	Conjunto Conjunto de Elementos
     * @param   separadorConjunto Separador del Conjunto de Elementos
     * @param   Elemento Elemento a buscar Coincidencia Exacta en Conjunto
     * @param   UpperCase True Ignora, False Nor Ignora CASE
     * @return	int
     */
    public static int numOfContainsExacly (String Conjunto, String separadorConjunto, String Elemento, boolean UpperCase){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
    //Comprobar Condiciones Iniciales//
    if((Conjunto==null)||(separadorConjunto==null)||(Elemento==null)){
        salida=0;
    }
    
	//Comenzar Proceso//
        if(condiciones==true){
            String[] vector = Cad.aVector(Conjunto, separadorConjunto);
            salida = Dimention.numOfContainsExacly(vector, Elemento, UpperCase);
	}else{
            //System.out.println("ERROR en numOfContainsExacly, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
    * Descripcion: De una Cad regresa una subcadena anterior a una subcadena
   -
    * @param  cadena Cad
    * @param  subcadena SubCadena 
    * @return Regresa String Vacio ERROR, otro caso String con Subcadena Posterior a subcadena
    */
    public static String subCadDESPUESdeCad(String cadena, String subcadena){
    //Variables Locales e Inicializacion//
        String cadenaF="";
        int posicion=0;
    //Comprobar Condiciones Iniciales//
    
    //Comenzar Proceso//
        //Buscar posicion de la subcadena//
        posicion=posOfContains(cadena,subcadena,false);
        //Obtener subcadena Despues a la posicion//
        if(posicion>=0){
            cadenaF=cadena.substring(posicion+subcadena.length(),cadena.length());
        }
    //Terminar Proceso//
        return cadenaF;
    }

    
    /**
    * Descripcion: De una Cad regresa una subcadena anterior a una subcadena
   -
    * @param  cadena Cad
    * @param  subcadena SubCadena 
    * @return Regresa String Vacio ERROR, otro caso String con Subcadena Anterior
    */
    public static String subCadANTESdeCad(String cadena, String subcadena){
    //Variables Locales e Inicializacion//
        String cadenaF="";
        int posicion=0;
    //Comprobar Condiciones Iniciales//
    
    //Comenzar Proceso//
        //Buscar posicion de la subcadena//
        posicion=posOfContains(cadena,subcadena,false);
        //Obtener subcadena anterior a la posicion//
        if(posicion>=0){
            cadenaF=cadena.substring(0,posicion);
        } 

    //Terminar Proceso//
        return cadenaF;
    }
    
    
    
    
    /**
     * Descripcion: Encontrar la posicion en el Abecedario de un caracter, si caracter no esta en el ABC se le da mayor prioridad y aparece primero
     * 
     * @param	caracter String del caracter a buscar en ABC
     * @param   modo 0=ABCEspañol(con Ñ) 1=ABCEnglish (sin Ñ) 2=ABCEspañolconNumeros 3=ABCEngNum
     * @return	int de la posicion
     *          0 en ERROR o caracter no encontrado;
     */
    public static int posicionABC (String caracter, int modo){
    //Variables Locales e Inicializacion//
	boolean condiciones=true;
        String motivo="Indeterminado";
        
        int posicion=0; //Posicion en que encontro el caracter dentro de los Alfabetos//
        String abcEsp="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ"; //Incluye la Ñ//
        String abcEspNum="0123456789ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String abcEng="ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //No incluye la Ñ//
        String abcEngNum="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        caracter=caracter.toUpperCase(); //Convertir Caracter en mayusculas//
        String x="";
        int contador=0;
    //Comprobar Condiciones Iniciales//
	if(caracter.length()!=1){
            condiciones=false;
            motivo="Cadena Recibida No encontrada en ABC";
        }
	//Comenzar Proceso//
        if(condiciones==true){
            if(modo==3){
                for(contador=0; contador<=abcEngNum.length()-1;contador++){
                    x=abcEngNum.substring(contador, contador+1);
                    if(x.equals(caracter)){
                        posicion=contador+1;
                    }
                }
            }
            if(modo==2){
                for(contador=0; contador<=abcEspNum.length()-1;contador++){
                    x=abcEspNum.substring(contador, contador+1);
                    if(x.equals(caracter)){
                        posicion=contador+1;
                    }
                }
                
            }
            if(modo==1){
                for(contador=0; contador<=abcEsp.length()-1;contador++){
                    x=abcEsp.substring(contador, contador+1);
                    if(x.equals(caracter)){
                        posicion=contador+1;
                    }
                }
                
            }
            if(modo==0){
                for(contador=0; contador<=abcEng.length()-1;contador++){
                    x=abcEng.substring(contador, contador+1);
                    if(x.equals(caracter)){
                        posicion=contador+1;
                    }
                }
            }
	}else{
            System.out.println("ERROR en posicionABC, motivo: "+motivo+", valor regresado: "+posicion); 
	}
    //Terminar Proceso//
        return posicion;
    }
    
    
     /**
     * Descripcion: Convertir un numero en una cadena a entero
     *
     * @param	cadena Cad con numeros a convertir
     * @param   error Valor regresado de la funcion en caso de error
     * @return	ERROR en caso de letras
     */
    public static int aEntero (String cadena, int error){
    //Variables Locales e Inicializacion//
        String nums=Cad.generaABC("Numeric Decimal",",",false);
        boolean condiciones=true;
        int salida=error;
        
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(cadena)){
        condiciones=false;
    }else{
        if(!Cad.OnlyContains(cadena,nums.concat("+,-,"),",")){
            condiciones=false;
        }
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=Integer.parseInt(cadena);
	}else{
            //System.out.println("ERROR en aEntero, Cadena: "+cadena+" no se puede Convertir, valor regresado: "+salida); 
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Pasar de Cad a Doble
     *
     * @param	cadena String a convertir
     * @param error Valor a retornar en caso de error
     * @return	Double con valor, ERROR = valor
     */
    public static double aDouble (String cadena, double error){
    //Variables Locales e Inicializacion//
        String abc="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";    
        boolean condiciones=true;
        double salida=error;
    //Comprobar Condiciones Iniciales//
	if(cadena.length()<=0){ //Si es cadena vacia//
            condiciones=false;
        }
        if(Cad.numOfContains(cadena, "-", true)>=2){ //Si contiene mas de 1 signo
            condiciones=false;
        }
        if(Cad.numOfContains(cadena, "+", true)>=2){ //Si contiene mas de un signo
            condiciones=false;
        }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=Double.parseDouble(cadena);
	}else{
            System.out.println("ERROR en aDouble, valor regresado: "+salida); 
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Pasar de Cad a Float
     *
     * @param	cadena String a convertir
     * @param   error Valor a retornar en caso de error
     * @return	Double con valor, ERROR = valor
     */
    public static float aFloat (String cadena, float error){
    //Variables Locales e Inicializacion//
        String caracteresPermitibles=Cad.generaABC("Numeric Decimal",",",true);
        caracteresPermitibles=caracteresPermitibles+"+,-,.,";
        
        boolean condiciones=true;
        float salida=error;
    //Comprobar Condiciones Iniciales//
    if(isNulloVacia(cadena)){
        condiciones=false;
    }else{
        if(OnlyContains(cadena,caracteresPermitibles,",")==false){
            condiciones=false;
        }
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=Float.parseFloat(cadena);
	}else{
            System.out.println("ERROR en aFloat, valor regresado: "+salida); 
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Pasar de Cad a Float
     *
     * @param	cadena String a convertir
     * @param   error Valor a retornar en caso de error
     * @return	long con valor, ERROR = valor
     */
    public static long aLong (String cadena, long error){
    //Variables Locales e Inicializacion//
        String caracteresPermitibles=Cad.generaABC("Numeric Decimal",",",true);
        caracteresPermitibles=caracteresPermitibles+"+,-,.,";
        
        boolean condiciones=true;
        long salida=error;
    //Comprobar Condiciones Iniciales//
    if(isNulloVacia(cadena)){
        condiciones=false;
    }else{
        if(OnlyContains(cadena,caracteresPermitibles,",")==false){
            condiciones=false;
        }
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=Long.parseLong(cadena);
	}else{
            System.out.println("ERROR en aLong, valor regresado: "+salida); 
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Encuentra que Cad esta entes en el ABCEspNumeros Ejm: aba, abb= 1
     *
     * @param	cad1 Cadena1 que puede tener numeros y letras
     * @param   cad2 Cadena2 que puede tener numeros y letras
     * @return	1 si Cad1 esta ANTES en ABC, 2 si Cad2 esta ANTES en ABC, OTRO caso = 1
     */
    public static int compararOrdenABC (String cad1, String cad2){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
        int posCad1=0;
        int posCad2=0;
        boolean termino=false;
    //Comprobar Condiciones Iniciales//
    if((cad1==null)||(cad2==null)){
        return 1;
    }
    if((cad1.equals(""))||(cad2.equals(""))){
        return 1;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            do{
               //Obtener y comparar las posiciones en el ABCEspañolconNumeros de ambas cadenas//
               if((posicionABC(cad1.substring(posCad1, posCad1+1),2))<(posicionABC(cad2.substring(posCad2, posCad2+1),2))){
                   termino=true;
                   salida=1;
               }
               if((posicionABC(cad1.substring(posCad1, posCad1+1),2))>(posicionABC(cad2.substring(posCad2, posCad2+1),2))){
                   termino=true;
                   salida=2;
               }
               //Obtener la siguiente posicion de los caracteres de ambas cadenas//
               posCad1=posCad1+1;
               posCad2=posCad2+1;
            }while((termino==false)&&(posCad1+1<=cad1.length())&&(posCad2+1<=cad2.length()));
            //Si NO Encontro pero se acabaron las cadenas, toma la cad mas pequeña//
            if(termino==false){
                if(cad1.length()<=cad2.length()){
                    salida=1;
                }else{
                    salida=2;
                }
            }
	}else{
            System.out.println("ERROR en remplazarSubCad, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Comparar dos cadenas en el AbecedarioIngles usando Operador
     * Operadores:  Los mismo que Java
     *
     * @param	Cad1 Cadena 1 lado Izquierdo
     * @param   Cad2 cadena 2 lado derecho
     * @param   operador Los mismos que Java
     * @return	true o false
     */
    public static boolean compararCadenasABC (String Cad1, String Cad2, String operador){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
        
        int minLong=0;
    //Comprobar Condiciones Iniciales//
    if((Cad1==null)||(Cad2==null)||(operador==null)){
        condiciones=false;
        salida=false;
        motivo="Cad1 o Cad2 u Operador NULL";
    }else{
        if((Cad1.length()==0)||(Cad2.length()==0)){
            condiciones=false;
            salida=false;
            motivo="Cad1 o Cad2 VACIA";
        }
        if(operador.length()==0){
            condiciones=false;
            salida=false;
            motivo="Operador NULO";
        }
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Obtener la longitud minima entre las dos cadenas//
            if(Cad1.length()<=Cad2.length()){
                minLong=Cad1.length();
            }else{
                minLong=Cad2.length();
            }
            
            //Empezar a comparar caracter a caracter//
            int count=0;
            while((count<minLong)&&(salida==false)){
                if(operador.equalsIgnoreCase("==")){
                    if(posABC(Cad1.substring(count,count+1),"Spanish")==posABC(Cad2.substring(count,count+1),"Spanish")){
                        salida=true;
                    }
                }
                if(operador.equalsIgnoreCase("<")){
                    if(posABC(Cad1.substring(count,count+1),"Spanish")<posABC(Cad2.substring(count,count+1),"Spanish")){
                        salida=true;
                    }
                }
                if(operador.equalsIgnoreCase(">")){
                    if(posABC(Cad1.substring(count,count+1),"Spanish")>posABC(Cad2.substring(count,count+1),"Spanish")){
                        salida=true;
                    }
                }
                if(operador.equalsIgnoreCase("<=")){
                    if(posABC(Cad1.substring(count,count+1),"Spanish")<=posABC(Cad2.substring(count,count+1),"Spanish")){
                        salida=true;
                    }
                }
                if(operador.equalsIgnoreCase(">=")){
                    if(posABC(Cad1.substring(count,count+1),"Spanish")>=posABC(Cad2.substring(count,count+1),"Spanish")){
                        salida=true;
                    }
                }
                count=count+1;
            }
	}else{
            System.out.println("ERROR en compararCadenasABC, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Encontrar la posicion de la Coincidencia Numero N de una subCad en una Cad
     *
     * @param	cad Cad Original
     * @param   subCad subCadena que se encuentra dentro de Cad N Veces
     * @param   numN numero de subCad a buscar Posicion
     * @param   ignoreCase Ignorar Mayus o Minus
     * @return	ERROR=-1; pos=0....cad.length;
     */
    public static int posOfContainsNum (String cad, String subCad, int numN, boolean ignoreCase){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=-1;
        
        int numContains=0;
        String cadAux=cad;
    //Comprobar Condiciones Iniciales//
	if((numN<=0)||(numN>numOfContains(cad,subCad,ignoreCase))){
            condiciones=false;
            motivo="el valor de numN no es Correcto";
        }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<=cad.length(); i++){
                if(subCad.length()+i<=cad.length()){
                    cadAux=cad.substring(i, i+subCad.length());
                    
                    if(ignoreCase==true){
                        if(cadAux.equalsIgnoreCase(subCad)){
                            numContains=numContains+1;
                            if(numContains==numN){
                                salida=i;
                            }
                        }
                    }else{
                        if(cadAux.equals(subCad)){
                            numContains=numContains+1;
                            if(numContains==numN){
                                salida=i;
                            }
                        }
                    }
                }
            }
	}else{
            System.out.println("ERROR en posOfContainsNum, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener Subcadena desde el final de una CadA hasta una posB
     *
     * @param	cadOriginal Donde obtener el substring
     * @param   CadA Posicion Inicial
     * @param   PosB Posicion Final
     * @return	subString
     */
    public static String subCadCadAPosB (String cadOriginal, String CadA, int PosB){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";
        String salida="";
        
        int PosA=posOfContains(cadOriginal, CadA, false);
    //Comprobar Condiciones Iniciales//
    if(PosA==-1){
        condiciones=false;
        motivo=CadA+" no encontrada en: "+cadOriginal;
    }
    if((PosA+CadA.length())>PosB){
        condiciones=false;
        motivo="PosB antes de Posicion Inicial";
    }
    if((PosB<0)||((PosB)>cadOriginal.length())){
        condiciones=false;
        motivo="PosB fuera de Cadena";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            PosA=PosA+CadA.length();
            salida=cadOriginal.substring(PosA, PosB);
	}else{
            System.out.println("ERROR en subCadCadAPosB, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
    /**
     * Descripcion: Encontrar la Subcadena que se encuentra entre limites A y B
     *              Ejem: ("hola juan como","hola","como")= juan ;
     *              Ejem: "16/05/2018" "/" "/" = 05 
     * @param	Cadena Donde se va a Buscar
     * @param   entreA cadena Inicial
     * @param   entreB cadena Final
     * @return	null No hay subcadena ERROR  "" No hay nada entre cadenas o "cadena" lo que encontro
     */
    public static String subCadCadACadB (String Cadena, String entreA, String entreB){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
        
        int posA=0;
        int posB=0;
        String subCadRestante="";
    //Comprobar Condiciones Iniciales//
    if(isNulloVacia(entreA)){
        condiciones=false;
        motivo="CadenaA es null o vacia";
    }
    if(isNulloVacia(entreB)){
        condiciones=false;
        motivo="CadenaB es null o vacia";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            posA=posOfContains(Cadena,entreA,false);
            
            if(posA>=0){
                subCadRestante=Cad.subCadPosAPosB(Cadena,posA+entreA.length(),Cadena.length());
                posB=posOfContains(subCadRestante,entreB,false);
                
                if(posB==0){
                    //Significa que no hay nada entre las dos cadenass//
                    salida="";
                }else{
                    if(posB>0){
                        salida=subCadPosAPosB(subCadRestante,0,posB);
                    }
                }
            }else{
                //No existe la cadena//
            }
	}else{
            System.out.println("ERROR en subCadCadACadB, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }

    
     /**
     * Descripcion: Obtener SubCad desde una posicion hasta una Subcadena
     *              Ejm ("HolaMundo",2,"n")=olaMu
     * @param	CadOriginal Cad para obtener el subcad
     * @param   posInicio posicion de inicio de busqueda de cadFinal
     * @param   cadFinal  subCadena a encontrar para terminar
     * @return	subCad o ERROR="";
     */
    public static String subCadPosACadB (String CadOriginal, int posInicio, String cadFinal){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        
        String cadAux="";
        int posCadF=0;
    //Comprobar Condiciones Iniciales//
	if((posInicio>CadOriginal.length())||(posInicio<0)){
            condiciones=false;
            motivo="posInicio Fuera de: "+ CadOriginal;
            salida="";
        }
	//Comenzar Proceso//
        if(condiciones==true){
            cadAux=CadOriginal.substring(posInicio, CadOriginal.length());
            posCadF=posOfContains(cadAux,cadFinal,false);
            if(posCadF>=0){
                salida=CadOriginal.substring(posInicio, (posCadF+posInicio));
            }else{
                motivo="Subcad: "+cadFinal+" no encontrada en: "+cadAux;
                System.out.println("ERROR en subCadPosACadB, motivo: "+motivo+", valor regresado: "+salida);
            }
	}else{
            System.out.println("ERROR en subCadPosACadB, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener una subcadena desde el final de una subcadena y con un Tam
     *
     * @param	CadOriginal Cad donde sacar subCad
     * @param   CadA subcadena donde el final es la posInicial
     * @param   Tam Longitud de Subcadena
     * @return	subcadena Exito, "" Otro Caso
     */
    public static String subCadCadATam (String CadOriginal, String CadA, int Tam){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        
        int posCadA=posOfContains(CadOriginal, CadA, false);
    //Comprobar Condiciones Iniciales//
	if(posCadA==-1){
            condiciones=false;
            motivo="No se encontro: "+CadA+" en:"+CadOriginal;
        }
        if(CadA.length()<=0){
            condiciones=false;
            motivo="Cadena Inicial Vacia";
        }
        if(Tam<=0){
            condiciones=false;
            motivo="Longitud de subcadena <= 0";
        }
        if(CadOriginal.length()<=0){
            condiciones=false;
            motivo="Cadena Original Vacia!";
        }
        if(CadOriginal.length()<CadA.length()+Tam){
            condiciones=false;
            motivo="Posicion Fuera de Cadena Original";
        }
	//Comenzar Proceso//
        if(condiciones==true){
            //Si la CadA es una cadena de Caracteres de longitud mayor a 1//
            posCadA=posCadA+CadA.length();
            salida=CadOriginal.substring(posCadA, posCadA+Tam);
	}else{
            System.out.println("ALERTA en subCadCadATam, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Obtener el Caracter de un Abecedario dada su posicion 
     *
     * @param	pos Posicion del Caracter a buscar
     * @param   abc 0=Esp 1=Eng
     * @param   bucle si se para de la longitud regresar al inicio del Abc
     * @return	valores de retorno
     */
    public static String caracterABC (int pos,int abc,boolean bucle){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        
        String abcEsp="ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
        String abcEng="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //Comprobar Condiciones Iniciales//
	if((bucle==false)&&(abc==0)&&(pos>abcEsp.length())){
            condiciones=false;
            motivo="No bucle y Posicion Fuera del ABCEsp";
        }
        if((bucle==false)&&(abc==1)&&(pos>abcEng.length())){
            condiciones=false;
            motivo="No bucle y Posicion Fuera del ABCEng";
        }
	//Comenzar Proceso//
        if(condiciones==true){
            //Si el abc es Español
            if(abc==0){
                if(bucle==false){
                    salida=abcEsp.substring(pos-1, pos);
                }else{
                    while(pos>abcEsp.length()){
                        pos=pos-abcEsp.length();
                    }
                    salida=abcEsp.substring(pos-1, pos);
                }
            }
            //si el abc es Ingles
            if(abc==1){
                if(bucle==false){
                    salida=abcEng.substring(pos-1, pos);
                }else{
                    while(pos>abcEng.length()){
                        pos=pos-abcEng.length();
                    }
                    salida=abcEng.substring(pos-1, pos);
                }
            }
	}else{
            System.out.println("ERROR en caracterABC, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener el subtring de una PosInicial a una PosFinal
     *
     * @param	CadOriginal Donde buscar el Substring
     * @param   PosA Posicion Inicial
     * @param   PosB Posicion Final
     * @return	subString
     */
    public static String subCadPosAPosB(String CadOriginal, int PosA, int PosB){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
        String motivo="Indeterminado";
        String salida=null;
        
        int longitud = CadOriginal.length();
        int i=0;
    //Comprobar Condiciones Iniciales//
    if((PosA>longitud)||(PosA<0)){
        condiciones=false;
        motivo="Posicion inicial fuera de cadena";
    }
    if((PosB>longitud)||(PosB<PosA)){
        condiciones=false;
        motivo="Posicion final fuera de cadena o menor que posInicial";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=CadOriginal.substring(PosA, PosB);
	}else{
            //System.out.println("ERROR en subCadPosAPosB, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Subcadenas de un tamaño definido desde una posicionA
     *
     * @param	CadOriginal Donde buscar el Substring
     * @param   PosA Posicion Inicial
     * @param   Longitud Tamaño de la subCad
     * @return	String
     */
    public static String subCadPosATam (String CadOriginal, int PosA, int Longitud){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
    if(((Longitud+PosA)>CadOriginal.length())||(Longitud<0)){
        condiciones=false;
        motivo="Longitud de SubCad fuera de CadOriginal";
    }
    if((PosA<0)||(PosA>CadOriginal.length())){
        condiciones=false;
        motivo="PosInicial fuera de CadOriginal";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=CadOriginal.substring(PosA,PosA+Longitud);
	}else{
            System.out.println("ERROR en subCadPosATam, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Obtener algun elemento Random de un Conjunto
     *
     * @param	conjunto Conjunto de elementos
     * @param   separador Separador entre elementos
     * @return	algun elemento del conjunto
     */
    public static String getRandomElement (String conjunto, String separador){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        
        //Concatenar separador al final del conjunto si hace falta//
        if(conjunto.substring(conjunto.length()-1, conjunto.length()).equals(separador)){
            //si tiene el separador//
        }else{
            conjunto=conjunto.concat(separador);
        }
        int numElements=0;
        int select=0;
        int posElement=0;
        int posElementoAnterior=0;
    //Comprobar Condiciones Iniciales//
    if(separador.length()<1){
        condiciones=false;
        motivo="Separador nulo";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            numElements=numOfContains(conjunto, separador, false);
            select=Nums.random(1, numElements);
            posElement=posOfContainsNum(conjunto, separador, select, false);
            
            if(select==1){
                posElementoAnterior=0;
            }else{
                posElementoAnterior=posOfContainsNum(conjunto, separador, select-1, false);
            }
            
            if(posElementoAnterior==0){
                salida=subCadPosAPosB(conjunto, posElementoAnterior, posElement);
            }else{
                salida=subCadPosAPosB(conjunto, posElementoAnterior+1, posElement);
            }
	}else{
            System.out.println("ERROR en getRandomElement, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener el Elemento Numero N
     *
     * @param	Conjunto Conjunto de Elementos
     * @param   Separador Separador entre Elementos del Conjunto
     * @param   NumeroN Elemento Numero N
     * @return	String
     */
    public static String getElement(String Conjunto, String Separador, int NumeroN){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            String[] vector = aVector(Conjunto,Separador);
            if((vector.length>NumeroN-1)&&(NumeroN>0)){
                salida=vector[NumeroN-1];
            }else{
                motivo="posicion: "+NumeroN+" fuera del Conjunto";
                System.out.println("ERROR en getElement, motivo: "+motivo+", valor regresado: "+salida);
            }
	}else{
            System.out.println("ERROR en getElement, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Leer una Cad del Teclado
     *
     * @return	String valor Leido
     */
    public static String LeerCadena (){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        
        Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            salida=entradaEscaner.nextLine();
	}else{
            System.out.println("ERROR en LeerCadena, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Convertir una Cadena a un vector de subcadenas
     *
     * @param	cadena Cadena a separar
     * @param   separador indicador de separacion
     * @return	String[]
     */
    public static String[] aVector (String cadena, String separador){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String[] salida =  null;
        int posVector=0;
        String temp="";
        
        int numElements=0;
    //Comprobar Condiciones Iniciales//
    if((separador==null)||(cadena==null)){
        condiciones=false;
        motivo="El cadena o separador NULL";
    }else{
        if(separador.length()>cadena.length()){
        condiciones=false;
        motivo="Separador mas grande que cadena Original";
    }else{
        //NORMALIZAR CADENA//
            //Si no hay caracter Final Agregarlo//
            if(!cadena.substring(cadena.length()-separador.length(), cadena.length()).equals(separador)){
                cadena=cadena.concat(separador);
            }
            //Si hay caracter al Inicio quitarlo a excepcion que sea el unico caracter//
            if(cadena.length()!=separador.length()){
                if(cadena.substring(0,separador.length()).equals(separador)){
                    cadena=cadena.substring(separador.length(),cadena.length());
                }
            }

            //Obtener entonces el numero de elementos//
            numElements=numOfContains(cadena,separador,false);

           if(numElements>=1){
                salida = new String[numElements]; //Redimencionar Vector a numero de elementos//
                for(int x=0; x<numElements; x++){
                    salida[x]=""; //Inicializar vector//
                }
            }else{
                condiciones=false;
                motivo="La cadena no Contiene Elementos";
            }
        }
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<cadena.length()-1; i++){
                //Obtener subcadena a evaluar si es Separador
                if(i+separador.length()<=cadena.length()){
                    temp=cadena.substring(i,i+separador.length());
                }
                
                //Si se encontro el separdor//
                if(temp.equals(separador)){
                    //No concatenar y saltar el separador//
                    i=i+separador.length()-1;
                    posVector=posVector+1;
                }else{
                    //Ir concatenando caracter a caracter//
                    salida[posVector]=salida[posVector].concat(cadena.substring(i,i+1));
                }
            }
	}else{
            //System.out.println("ERROR en aVector, motivo: "+motivo+" ,valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
     /**
     * Descripcion: Convertir una cadena a vector dado un tamaño de bloque
     * Ejm:  (holamundo,2)=(ho,la,mu,nd,o)
     *
     * @param	Cadena cadena a convertir
     * @param   tamBloque cantidad de elementos a tomar de Cadena por bloque del Vector
     * @return	String[]
     */
    public static String[] aVector (String Cadena, int tamBloque){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String[] salida=null;
        
        int tamVector=Nums.redondearEntero((double)Cadena.length()/tamBloque, 1);
        int posInicial=0;
        int posFinal=tamBloque;
    //Comprobar Condiciones Iniciales//
    if(tamBloque<=0){
        condiciones=false;
        motivo="El tamaño de bloques es menor o igual a cero!";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=new String[tamVector];
            for(int i=1; i<=tamVector; i++){
                if(i==tamVector){ //Si este es el ultimo bloque, tomar hasta el final de la cadena//
                    salida[i-1]=Cadena.substring(posInicial,Cadena.length());
                }else{//En otro caso nomar solo la cantidad del tamaño del bloque
                    salida[i-1]=Cadena.substring(posInicial,posFinal);
                }
                posInicial=posInicial+tamBloque;
                posFinal=posFinal+tamBloque;
            }
	}else{
            System.out.println("ERROR en aVector, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Ajustar una cadena a cierta Longitud, rellenando de simbolo en direccion Izq o Der
     * FONTS: DialogInput
     *
     * @param	cad Cadena a ajustar a un tamaño
     * @param   direccion Derecha o Izquierda
     * @param   simbolo a usar para rellenar
     * @param   Longitud Longitud a Ajustar cadena
     * @return	String
     */
    public static String AjustarTam (String cad, String direccion, String simbolo,int Longitud){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        
        int tamOriginal=0;
        int diferencia=0;
    //Comprobar Condiciones Iniciales//
    if(simbolo.length()<1){
        condiciones=false;
        motivo="Simbolo de longitud CERO";
    }
    if(Longitud<0){
        condiciones=false;
        motivo="Valor de Longitud Negativo";
    }
    if(cad==null){
        condiciones=false;
        motivo="Cadena Null";
    }
    //Hacer las converciones de Palabras
    if((direccion.equalsIgnoreCase("L"))||(direccion.equalsIgnoreCase("Izq"))||(direccion.equalsIgnoreCase("Izquierda"))||(direccion.equalsIgnoreCase("Left"))){
        direccion="L";
    }else{
        if((direccion.equalsIgnoreCase("R"))||(direccion.equalsIgnoreCase("Der"))||(direccion.equalsIgnoreCase("Derecha"))||(direccion.equalsIgnoreCase("Rigth"))){
            direccion="R";
        }else{
            condiciones=false;
            motivo="direccion no Soportada";
        }
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Calcular la diferencia//
            salida=cad; tamOriginal=cad.length();
            diferencia=Longitud-tamOriginal;
            
            //Aumentar
            if(diferencia>=0){
                //Generar la Cadena a concatenar//
                String cadAux=""; int numConcat=Nums.redondearEntero((double)((double)diferencia/(double)simbolo.length()),1);
                for(int i=0; i<numConcat; i++){
                    cadAux=cadAux.concat(simbolo);
                }cadAux=subCadPosATam(cadAux,0,diferencia);
                
                //Concatenar a la Cadena Original//
                if(direccion.equalsIgnoreCase("L")){
                    salida=cadAux.concat(salida);  //Izquierda
                }else{
                    salida=salida.concat(cadAux);  //Derecha
                }
                
            }else{ //Disminuir la cadena//
                if(direccion.equalsIgnoreCase("L")){
                    salida=salida.substring((-diferencia),salida.length()); //Izquierda
                }else{
                    salida=salida.substring(0,(tamOriginal+diferencia)); //Derecha
                }
            }
            
	}else{
            System.out.println("ERROR en AjustarTam, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Generar el Alfabeto de algun Idioma
     *
     * @param	Lenguaje "English, Spanish, AlfaNumeric English, Alfanumeric Spanish"
     * @param   separador separador a usar entre letras del Alfabeto
     * @param   UpperCase True=MAyusculas  false=Minusculas
     * @return	Cadena con alfabeto separados con separador
     */
    public static String generaABC (String Lenguaje, String separador, boolean UpperCase){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        
        String Lenguajes="Numeric Decimal,Numeric Hex,Spanish,English,AlfaNum English,AlfaNum Spanish";
    //Comprobar Condiciones Iniciales//
    if(numOfContainsExacly(Lenguajes,",",Lenguaje,true)<1){
        condiciones=false;
        motivo="Lenguaje:"+Lenguaje+" no soportado!";
        System.out.println("");
        System.out.println("Lista de Lenjuages Soportados:");
        System.out.println(Lenguajes);
        System.out.println("");
    }
	//Comenzar Proceso//
        if(condiciones==true){
            if((Lenguaje.equalsIgnoreCase("Numeric Decimal"))){
                String aux="0,1,2,3,4,5,6,7,8,9,";
                aux=Cad.remplazarSubCadALL(aux,",",separador);
                if(UpperCase){
                    return aux;
                }else{
                    return aux.toLowerCase();
                }
            }
            if((Lenguaje.equalsIgnoreCase("Numeric Hex"))){
                String aux="0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F,";
                aux=Cad.remplazarSubCadALL(aux,",",separador);
                if(UpperCase){
                    return aux;
                }else{
                    return aux.toLowerCase();
                }
            }
            if((Lenguaje.equalsIgnoreCase("Español"))||(Lenguaje.equalsIgnoreCase("Spanish"))){
                String aux="A,B,C,D,E,F,G,H,I,J,K,L,M,N,Ñ,O,P,Q,R,S,T,U,V,W,X,Y,Z,";
                aux=Cad.remplazarSubCadALL(aux,",",separador);
                if(UpperCase){
                    return aux;
                }else{
                    return aux.toLowerCase();
                }
            }
            if((Lenguaje.equalsIgnoreCase("Ingles"))||(Lenguaje.equalsIgnoreCase("English"))){
                String aux="A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,";
                aux=Cad.remplazarSubCadALL(aux,",",separador);
                if(UpperCase){
                    return aux;
                }else{
                    return aux.toLowerCase();
                }
            }
            if((Lenguaje.equalsIgnoreCase("AlfaNum English"))){
                String aux="0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,";
                aux=Cad.remplazarSubCadALL(aux,",",separador);
                if(UpperCase){
                    return aux;
                }else{
                    return aux.toLowerCase();
                }
            }
            if((Lenguaje.equalsIgnoreCase("AlfaNum Spanish"))){
                String aux="0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F,G,H,I,J,K,L,M,N,Ñ,O,P,Q,R,S,T,U,V,W,X,Y,Z,";
                aux=Cad.remplazarSubCadALL(aux,",",separador);
                if(UpperCase){
                    return aux;
                }else{
                    return aux.toLowerCase();
                }
            }
	}else{
            System.out.println("ERROR en generaABC, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: obtener la posicion de un caracter de algun Alfabeto
     *
     * @param	caracter Caracter a buscar posicion
     * @param   Alfabeto Español, English,
     * @return	numero Entero
     */
    public static int posABC (String caracter, String Alfabeto){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
        String Leguaje="";
    //Comprobar Condiciones Iniciales//
    
	//Comenzar Proceso//
        if(condiciones==true){
            Leguaje=generaABC(Alfabeto,"",true);
            salida=posOfContains(Leguaje,caracter,true)+1; //Para evitar el CERO//
            
            if(salida==0){
                motivo="No se encontro: "+caracter+" en alfabeto: "+Alfabeto;
                System.out.println("ERROR en posABC, motivo: "+motivo+", valor regresado: "+salida);
            }
	}else{
            System.out.println("ERROR en posABC, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Contar el numero de Elementos de un conjunto separados por separador
     *
     * @param	Conjunto Conjunto de Elementos
     * @param   separador Separador de elementos en el conjunto
     * @return	0 a N
     */
    public static int numOfElements (String Conjunto, String separador){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
    if(separador.length()>Conjunto.length()){
        condiciones=false;
        motivo="Separador no encontrado en Conjunto";
    }
	//Comenzar Proceso//
        if(condiciones==true){
        //Normalizar Cadena para Hacer Calculo//
            //Si el separador se encuentra al inicio quitarlo   ,hola,mundo
            if(Conjunto.substring(0,separador.length()).equals(separador)){
                Conjunto=Conjunto.substring(separador.length(),Conjunto.length());
            }
            //Si el separador se encuentra al final quitarlo//  ,hola,mundo,
            String subcad=subCadPosAPosB(Conjunto,Conjunto.length()-separador.length(),Conjunto.length());
            if(subcad!=null){
                if(subcad.equals(separador)){
                    Conjunto=Conjunto.substring(0,Conjunto.length()-separador.length());
                }
            }
            
            salida=numOfContains(Conjunto,separador,false)+1;
	}else{
            System.out.println("ERROR en remplazarSubCad, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Comparar si dos Cadenas se parecen usando un punto de variacion
     *
     * @param	Cad Cadena a provar
     * @param   CadParecida  Cadena Modelo con puntos de Variacion
     * @param   puntoVar caracter a identificar en CadParecida
     * @param   ConjuntoVar Conjunto de Elementos posibles a encontrar en los puntos de variacion
     * @param   Separador Elemento que identifica la separacion entre Elementos del Conjunto
     * @return	true o false
     */
    public static boolean LikeA (String Cad, String CadParecida, String puntoVar, String ConjuntoVar, String Separador){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
        
        int posCad=0;
        boolean parecido=true;
        boolean encontro=false;
        boolean entro=false;
        
        //Hacer Validacion para Conjunto con CadenaVacia  ",," //
        if(numOfContains(ConjuntoVar,Separador+Separador,false)>=1){
            //Para el caso del Elementos Vacio
            //String a="M";
            //String b="$M$";
            //PuntoVar = $
            //Conjunto=":,,a,b,";   Esto deberia dar True
            //Remplazar cadVacia por un ElementoExtra y agregar este a la cadena al inicio y al final//
            
            String posibleElementExtra="♠,↔,╗,♀,ê,"; int n=0;
            String Select="";
            int numFound=0;
            do{
                n=n+1;
                Select=getElement(posibleElementExtra,",",n);
                numFound=numOfContainsExacly(ConjuntoVar,Separador,Select,false);
            }while((numFound>=1)&&(n<5));
            
            if((n==5)&&(numFound>=1)){ //Si llego al final y encontro elemento//
                //Entonces Todos los elementos posibles ya se encuentran en el conjunto//
                condiciones=false;
                motivo="No se puede Operar la CadenaVacia para este Conjunto con estas Cadenas de entrada";
                System.out.println("Sugerencia: Elimine alguno de estos elementos del ConjuntoVar: "+posibleElementExtra);
            }else{
                //Modificar Cadenas y Conjunto//
                ConjuntoVar=remplazarSubCadALL(ConjuntoVar,Separador+Separador,Separador+Select+Separador);
                Cad=Select+Cad+Select;
            }
        }
        
    //Comprobar Condiciones Iniciales//
    if(puntoVar.length()!=1){
        condiciones=false;
        motivo="puntoVariacion.length != 1";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<CadParecida.length(); i++){
                entro=false;
                //(CadParecida.substring(i, i+1).equals(Cad.substring(posCad, posCad+1))
                if((subCadPosAPosB(CadParecida,i,i+1).equals(subCadPosAPosB(Cad, posCad, posCad+1)))||(CadParecida.substring(i, i+1).equals(puntoVar))){
                    if(CadParecida.substring(i, i+1).equals(puntoVar)){
                        do{
                            encontro=false;
                            String elemento="";
                            String subCad=null;
                            String restoCad=Cad.substring(posCad, Cad.length());
                            
                            for(int x=1; x<=numOfElements(ConjuntoVar, Separador); x++){
                                elemento=getElement(ConjuntoVar, Separador, x);
                                subCad=subCadPosAPosB(restoCad,0,elemento.length());
                                
                                if(subCad!=null){
                                    if(subCad.equals(elemento)){
                                        x=numOfElements(ConjuntoVar, Separador)+1;
                                        encontro=true;
                                        entro=true;
                                        posCad=posCad+elemento.length();
                                        restoCad=subCadPosAPosB(restoCad, posCad,Cad.length());
                                        //restoCad=restoCad.substring(posCad,Cad.length());
                                    }
                                }
                            }
                        }while(((encontro==true)&&(posCad<Cad.length())));
                        //para el caso en el que puntoVar este al final de Cadena//
                        if((encontro==false)&&(i+1==CadParecida.length())){
                            parecido=false;
                        }
                    }
                }else{
                    parecido=false;
                    i=CadParecida.length();
                }
                if(entro==false){
                    posCad=posCad+1;
                }
            }
            
            salida=parecido;
	}else{
            System.out.println("ERROR en LikeA, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Eliminar todos las coincidencias de un grupo de elementos en una Cadena
     *
     * @param	CadenaOriginal  Cadena que no es un Conjunto
     * @param   Conjunto Conjunto de elementos a eliminar
     * @param   separador Separador el conjunto
     * @return	valores de retorno
     */
    public static String EliminarSubcadALLconjunt (String CadenaOriginal, String Conjunto, String separador){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        
        String[] VectorConjunto;
    //Comprobar Condiciones Iniciales//
    if(CadenaOriginal==null){
        condiciones=false;
        motivo="CadenaOriginal es null";
    }
    if(isNulloVacia(Conjunto)){
        condiciones=false;
        motivo="Conjunto a Eliminar es NULL o Vacio";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            if(CadenaOriginal.equalsIgnoreCase("")){
                salida=CadenaOriginal;
            }else{
                VectorConjunto=Cad.aVector(Conjunto, separador);
                for(int i=0; i<VectorConjunto.length; i++){
                    CadenaOriginal=EliminarSubcadALL(CadenaOriginal,VectorConjunto[i]);
                }
                salida=CadenaOriginal;
            }
	}else{
            System.out.println("ERROR en EliminarSubcadALLconjunt, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Eliminar Todos los elementos de un Conjunto de otro Conjunto
     *
     * @param	ConjuntoTotal Conjunto Total de Elementos
     * @param   ConjuntoElimnar  Los que vas a Eliminar
     * @param   separador Separador entre conjuntos
     * @return	valores de retorno
     */
    public static String EliminaElementsALLconjunto (String ConjuntoTotal, String ConjuntoElimnar, String separador){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        
        String ElementsFound="";
        String[] VectorFound=null;
        String[] VectorConjuntTotal=null;
    //Comprobar Condiciones Iniciales//
    if(isNulloVacia(separador)){
        condiciones=false;
        motivo="Separador NULL";
    }
    if(ConjuntoTotal==null || ConjuntoElimnar==null){
        condiciones=false;
        motivo="Conjuntos NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            ElementsFound=ElementsContains(ConjuntoTotal, ConjuntoElimnar, separador);
            VectorFound=Cad.aVector(ElementsFound, separador);
            VectorConjuntTotal=Cad.aVector(ConjuntoTotal, separador);
            if(VectorFound!=null){
                for(int i=0; i<VectorFound.length; i++){
                    VectorConjuntTotal=Dimention.EliminaElementsALL(VectorConjuntTotal,VectorFound[i],false);
                }
            }
            salida=Dimention.convertVectorToString(VectorConjuntTotal, separador);
	}else{
            System.out.println("ERROR en EliminaElementsALLconjunto, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Eliminar Todas las Conincidencias de un elemento de un Conjunto
     *
     * @param	ConjuntoTotal Conjunto Total de Elementos
     * @param   Elemento Elemento a Eliminar Todas las Coincidencias
     * @param   separador Separador del conjunto Total
     * @param   ignoreCase Ignorar Mayusculas de Minusculas
     * @return	valores de retorno
     */
    public static String EliminaElementsALL (String ConjuntoTotal, String Elemento, String separador, boolean ignoreCase){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        
        String[] vectorConjunt;
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(ConjuntoTotal)){
        condiciones=false;
        motivo="ConjuntoTotal es null o Vacio";
    }
    if(Cad.isNulloVacia(Elemento)){
        condiciones=false;
        motivo="Elemento es null o Vacio";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            vectorConjunt=Cad.aVector(ConjuntoTotal, separador);
            vectorConjunt=Dimention.EliminaElementsALL(vectorConjunt, Elemento, ignoreCase);
            salida=Dimention.convertVectorToString(vectorConjunt, separador);
	}else{
            System.out.println("ERROR en EliminaElementsALL, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Eliminar Elementos Repetidos de un Conjunto 
     *
     * @param	conjunto Conjunto de Elementos
     * @param   separador Separador entre Elementos del conjutno
     * @return	valores de retorno
     */
    public static String EliminaRepetidos (String conjunto, String separador){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        
        String elemento="";
        String remplazo="§Õ¼↔";
        String[] vector=null;
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(conjunto)){
        condiciones=false;
        motivo="Conjunto Null o Vacio";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Convertir conjunto a vector para operar mas facil//
            vector=Cad.aVector(conjunto, separador);
            
            //Generar un elemento que no este en el conjunto//
            while(numOfContainsExacly(conjunto, separador, remplazo, false)>=1){
                remplazo=remplazo.concat(remplazo);
            }
            
            //Remplazar Repetidos por Remplazo//
            for(int i=0; i<vector.length; i++){
                if(!vector[i].equals(remplazo)){
                    elemento=vector[i];
                    for(int j=i+1; j<vector.length; j++){
                        if(vector[j].equals(elemento)){
                            vector[j]=remplazo;
                        }
                    }
                }
            }
            
            //Eliminar todos los Remplazo//
            salida=Dimention.convertVectorToString(vector, separador);
            salida=Cad.EliminaElementsALLconjunto(salida,remplazo, separador);
            
	}else{
            System.out.println("ERROR en EliminaRepetidos, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Unir dos conjuntos de Elementos
     *
     * @param	Conjunt1 Conjunto 1 de Elementos
     * @param   Conjunt2 Conjunto 2 de Elementos
     * @param   separador Separador entre elementos de los Conjuntos
     * @param   Repetidos True repetir elementos o False no Repetir Elementos
     * @return	valores de retorno
     */
    public static String UnionConjuntos (String Conjunt1, String Conjunt2, String separador, boolean Repetidos){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
        
        boolean existen=true;
        String[] v1;
        String[] v2;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            if(Cad.isNulloVacia(Conjunt1)){
                salida=Conjunt2; existen=false;
            }
            if(Cad.isNulloVacia(Conjunt2)){
                salida=Conjunt1; existen=false;
            }
            
            if(existen){
                v1=Cad.aVector(Conjunt1, separador);
                v2=Cad.aVector(Conjunt2, separador);
                
                v1=Dimention.concatVectores(v1, v2);
                
                salida=Dimention.convertVectorToString(v1, separador);
                if(Repetidos==false){
                    salida=EliminaRepetidos(salida, separador);
                }
            }
	}else{
            System.out.println("ERROR en UnionConjuntos, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
      /**
     * Descripcion: Encontrar la interseccion de Dos conjuntos
     *
     * @param	Conjunt1 Conjunto 1 de elementos
     * @param   Conjunt2 Conjunto 2 de elementos
     * @param   separador Separador entre Conjuntos
     * @return	valores de retorno
     */
    public static String InterseccionConjuntos (String Conjunt1, String Conjunt2, String separador){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
    
	//Comenzar Proceso//
        if(condiciones==true){
            //Hacer la Union de los Conjuntos//
            salida=Conjunt1+separador+Conjunt2;
            //Buscar que elementos se repiten en ConjuntoUnion//
            salida=ElementsRepetidos(salida, separador);
	}else{
            System.out.println("ERROR en InterseccionConjuntos, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
         /**
     * Descripcion: Encontrar los elementos que estan Repetidos en un Conjunto
     *  "hola,hola,mundo" = "hola,"
     * 
     * @param	Conjuto Conjunto de Elementos
     * @param   separador Separdor entre elementos
     * @return	String Vacio o con Contenidos
     */
    public static String ElementsRepetidos (String Conjuto, String separador){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
        
        String[] aux;
        String element="";
    //Comprobar Condiciones Iniciales//
    if(isNulloVacia(separador)){
        condiciones=false;
        motivo="Separador NULL";
    }
    if(Conjuto==null){
        condiciones=false;
        motivo="Conjunto NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            aux=Cad.aVector(Conjuto, separador);
            
            for(int i=0; i<aux.length; i++){
                element=aux[i];
                for(int x=i+1; x<aux.length; x++){
                    //Buscar si se repite el elemento//
                    if(element.equals(aux[x])){
                        x=aux.length; //Terminar el ciclo/
                        salida=salida+element+separador;
                    }
                }
            }
	}else{
            System.out.println("ERROR en ElementsRepetidos, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Insertar Cadena en una posicion especifica de otra Cadena existente
     *  Insert solo funciona si hay lugar en donde Insertar cadena para evitar problemas
     *  ejm  "hola" "MA" "1" = "hMAola"
     * @param	Cadena Cadena donde Insertar otra Cad
     * @param   CadInsert Cadena a insertar
     * @param   posicion posicion donde Insertar Cadena
     * @return	String
     */
    public static String InsertCad (String Cadena, String CadInsert, int posicion){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=Cadena;
        
        String partA="";
        String partB="";
    //Comprobar Condiciones Iniciales//
    if(Cadena==null){
        condiciones=false;
        motivo="La cadena donde se va Insertar es NULL";
    }
    if(posicion<0||posicion>Cadena.length()){
        condiciones=false;
        motivo="La posicion no existe en la Cadena: "+Cadena;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            partA=Cadena.substring(0, posicion);
            partB=Cadena.substring(posicion,Cadena.length());
            
            salida=partA+CadInsert+partB;
	}else{
            System.out.println("ERROR en InsertCad, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Operacion Diferencia entre Conjuntos
     *
     * @param	Conjunto1 Conjunto 1
     * @param   Conjunto2 Conjutno 2
     * @param   separador Separador entre elementos
     * @return	String Vacio o con Elementos
     */
    public static String DiferenciaConjuntos (String Conjunto1, String Conjunto2, String separador){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
    if(isNulloVacia(separador)){
        condiciones=false;
        motivo="Separdor NULL";
    }
    if(Conjunto1==null||Conjunto2==null){
        condiciones=false;
        motivo="Conjuntos NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=EliminaElementsALLconjunto(Conjunto1, Conjunto2, separador);
	}else{
            System.out.println("ERROR en DiferenciaConjuntos, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Obtener la longitud de una cadena a pesar de que esta sea null
     *
     * @param	cadena Cadena a Evaluar
     * @return	valores de retorno
     */
    public static int LongitudFIX (String cadena){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
	
	//Comenzar Proceso//
        if(condiciones==true){
            if(cadena!=null){
                salida=cadena.length();
            }
	}else{
            System.out.println("ERROR en LongitudFIX, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Comprobar si un conjunto tiene los mismos elementos que otro sin importar el numero de elementos
     *
     * @param	ConjuntoA Conjunto de Elementos
     * @param   ConjuntoB Conjunto de Elementos
     * @param   separador separador entre elementos
     * @return	valores de retorno
     */
    public static boolean ConjuntoEquals (String ConjuntoA, String ConjuntoB, String separador){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=true;
    //Comprobar Condiciones Iniciales//
    if(isNulloVacia(ConjuntoA)){
        condiciones=false;
        motivo="Conjunto A no Valido";
    }
    if(isNulloVacia(ConjuntoB)){
        condiciones=false;
        motivo="Conjunto B no valido";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            String [] vectA = aVector(ConjuntoA, separador);
            String [] vectB = aVector(ConjuntoB, separador);
            
            for(int i=0; i<vectB.length; i++){
                if(Dimention.Contains(vectA,vectB[i])==false){
                    salida=false;
                }
            }
            
            for(int i=0; i<vectA.length; i++){
                if(Dimention.Contains(vectB,vectA[i])==false){
                    salida=false;
                }
            }
	}else{
            System.out.println("ERROR en ConjuntoEquals, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Comparar si una cadena se parece a otra con ciertos puntos de Variacion
     *  Ejemplo: "hola como estas amigo", "hola$estas$" = true
     * 
     * @param	cadOriginal Cadena a Comparar
     * @param   cadParecida Cadena con puntos de variacion
     * @param   puntoVariacion Caracter de variacion
     * @param   ignoreCase Ignorar Mayusculas de Minusculas
     * @return	valores de retorno
     */
    public static boolean LikeA (String cadOriginal, String cadParecida, String puntoVariacion, boolean ignoreCase){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=true;
        boolean showMensaje=true;
        
        String[] vecFragmentCadParecida;
    //Comprobar Condiciones Iniciales//
    if(isNulloVacia(cadOriginal)){
        condiciones=false;
        salida=false;
        showMensaje=false;
        motivo="CadOriginal es NULL o VACIA";
    }
    if(isNulloVacia(cadParecida)){
        condiciones=false;
        salida=false;
        motivo="CadParecida es NULL o VACIA";
    }
    if(isNulloVacia(puntoVariacion)){
        condiciones=false;
        salida=false;
        motivo="Punto de Variacion es NULL o VACIO";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Ignorar mayusculas de minusculas
            if(ignoreCase){
                cadOriginal=cadOriginal.toUpperCase();
                cadParecida=cadParecida.toUpperCase();
                puntoVariacion=puntoVariacion.toUpperCase();
            }
            
            //Eliminar puntos de variacion Repetidos de la Cadena Parecida EJM: ho$$la -> ho$la//
            while(numOfContains(cadParecida,puntoVariacion+puntoVariacion,false)>=2){
                cadParecida=remplazarSubCadALL(cadParecida,puntoVariacion+puntoVariacion,puntoVariacion);
            }
            
            //Convertir en fragmentos la cadena Parecida//
            vecFragmentCadParecida=aVector(cadParecida,puntoVariacion);
            vecFragmentCadParecida=Dimention.EliminaElementsALL(vecFragmentCadParecida,"",false);
            
            //Buscar la posicion de cada framento de CadParecida en cadOriginal//
            int posFound=0; //posicion donde se encuentra el fragmento//
            int posInicio=0; //Posicion de Inicio de busqueda en cadena Original, esto es para hacer una busqueda progresiva
            int posFin=cadOriginal.length(); // y asi evitar el error de fragmentos repetidos obtener la misma posicion
            
            String subCadProgresiva=cadOriginal; //Ir avanzando conforme se encuentran fragmentos
            for(int i=0; i<Dimention.LongitudFIX(vecFragmentCadParecida); i++){
                subCadProgresiva=subCadPosAPosB(subCadProgresiva,posInicio,posFin);
                posFound=posOfContains(subCadProgresiva,vecFragmentCadParecida[i],false);
                
                if(posFound>=0){
                    posInicio=posFound+vecFragmentCadParecida[i].length();
                    posFin=subCadProgresiva.length();
                }else{
                    //Terminar porque no se encontro un fragmento y eso significa que no son parecidas//
                    i=vecFragmentCadParecida.length;
                    salida=false;
                }
            }
            
            
            //Finalmente comprobar que los extremos inicio y fin se cumplan//
                //para solucionar el error que si existen los fragmentos pero no deberian terminar o iniciar asi//
                //EJM: "(INICIO/1/1)","(INICIO/$/"    o    "a(INICIO/1/1)","(INICIO/$/$)"
            

            //Si no tienen punto de variacion Inicial entonces Primer fragmento debe ser el inicio de CadOriginal//
            if(puntoVariacion.equals(subCadPosAPosB(cadParecida,0,puntoVariacion.length()))==false){
                if(vecFragmentCadParecida[0].equals(subCadPosAPosB(cadOriginal,0,vecFragmentCadParecida[0].length()))==false){
                    salida=false;
                }
            }
            
            //Si no tienen punto de variacion Final entonces Ultimo fragmento debe ser el fin de CadOriginal//
            if(puntoVariacion.equals(subCadPosAPosB(cadParecida,cadParecida.length()-puntoVariacion.length(),cadParecida.length()))==false){
                if(vecFragmentCadParecida[vecFragmentCadParecida.length-1].equals(subCadPosAPosB(cadOriginal,cadOriginal.length()-vecFragmentCadParecida[vecFragmentCadParecida.length-1].length(),cadOriginal.length()))==false){
                    salida=false;
                }
            }
            
	}else{
            if(showMensaje){
                System.out.println("ERROR en LikeA, motivo: "+motivo+", valor regresado: "+salida);
            }
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Comparar si una cadena se parece a otra con ciertos puntos de Variacion
     *  Ejemplo: "hola como estas amigo", "hola$estas$" = true
     * 
     * @param	cadOriginal Cadena a Comparar
     * @param   cadParecida Cadena con puntos de variacion
     * @param   puntoVariacion Caracter de variacion
     * @return	valores de retorno
     */
    public static boolean LikeA (String cadOriginal, String cadParecida, String puntoVariacion){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=true;
        boolean showMensaje=true;
        
        String[] vecFragmentCadParecida;
    //Comprobar Condiciones Iniciales//
    if(isNulloVacia(cadOriginal)){
        condiciones=false;
        salida=false;
        showMensaje=false;
        motivo="CadOriginal es NULL o VACIA";
    }
    if(isNulloVacia(cadParecida)){
        condiciones=false;
        salida=false;
        motivo="CadParecida es NULL o VACIA";
    }
    if(isNulloVacia(puntoVariacion)){
        condiciones=false;
        salida=false;
        motivo="Punto de Variacion es NULL o VACIO";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            
            //Eliminar puntos de variacion Repetidos de la Cadena Parecida EJM: ho$$la -> ho$la//
            while(numOfContains(cadParecida,puntoVariacion+puntoVariacion,false)>=2){
                cadParecida=remplazarSubCadALL(cadParecida,puntoVariacion+puntoVariacion,puntoVariacion);
            }
            
            //Convertir en fragmentos la cadena Parecida//
            vecFragmentCadParecida=aVector(cadParecida,puntoVariacion);
            vecFragmentCadParecida=Dimention.EliminaElementsALL(vecFragmentCadParecida,"",false);
            
            //Buscar la posicion de cada framento de CadParecida en cadOriginal//
            int posFound=0; //posicion donde se encuentra el fragmento//
            int posInicio=0; //Posicion de Inicio de busqueda en cadena Original, esto es para hacer una busqueda progresiva
            int posFin=cadOriginal.length(); // y asi evitar el error de fragmentos repetidos obtener la misma posicion
            
            String subCadProgresiva=cadOriginal; //Ir avanzando conforme se encuentran fragmentos
            for(int i=0; i<Dimention.LongitudFIX(vecFragmentCadParecida); i++){
                subCadProgresiva=subCadPosAPosB(subCadProgresiva,posInicio,posFin);
                posFound=posOfContains(subCadProgresiva,vecFragmentCadParecida[i],false);
                
                if(posFound>=0){
                    posInicio=posFound+vecFragmentCadParecida[i].length();
                    posFin=subCadProgresiva.length();
                }else{
                    //Terminar porque no se encontro un fragmento y eso significa que no son parecidas//
                    i=vecFragmentCadParecida.length;
                    salida=false;
                }
            }
            
            
            //Finalmente comprobar que los extremos inicio y fin se cumplan//
                //para solucionar el error que si existen los fragmentos pero no deberian terminar o iniciar asi//
                //EJM: "(INICIO/1/1)","(INICIO/$/"    o    "a(INICIO/1/1)","(INICIO/$/$)"
            

            //Si no tienen punto de variacion Inicial entonces Primer fragmento debe ser el inicio de CadOriginal//
            if(puntoVariacion.equals(subCadPosAPosB(cadParecida,0,puntoVariacion.length()))==false){
                if(vecFragmentCadParecida[0].equals(subCadPosAPosB(cadOriginal,0,vecFragmentCadParecida[0].length()))==false){
                    salida=false;
                }
            }
            
            //Si no tienen punto de variacion Final entonces Ultimo fragmento debe ser el fin de CadOriginal//
            if(puntoVariacion.equals(subCadPosAPosB(cadParecida,cadParecida.length()-puntoVariacion.length(),cadParecida.length()))==false){
                if(vecFragmentCadParecida[vecFragmentCadParecida.length-1].equals(subCadPosAPosB(cadOriginal,cadOriginal.length()-vecFragmentCadParecida[vecFragmentCadParecida.length-1].length(),cadOriginal.length()))==false){
                    salida=false;
                }
            }
            
	}else{
            if(showMensaje){
                System.out.println("ERROR en LikeA, motivo: "+motivo+", valor regresado: "+salida);
            }
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
    /**
     * Descripcion: Comparar si una cadena se parece a ALGUNA otras multiples cadenas con puntos de variacion
     *      $ como marca de Tag
     *      # como marca de variacion
     *  Ejemplo: "Inversiones Compras", "$#Inversion#$#Compra#" = true
     * 
     * @param	cadOriginal Cadena a Comparar
     * @param   cadParecida Cadena con puntos de variacion
     * @param   puntoVariacion Caracter de variacion
     * @param   puntoTags Marca para separar diferentes tags
     * @param   ignoreCase Ignorar Mayusculas de Minusculas
     * @return	valores de retorno
     */
    public static boolean LikeByTags_SOFT(String cadOriginal, String cadParecida, String puntoVariacion, String puntoTags, boolean ignoreCase){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Primero dividir la cadena parecida en un vector con subcadenas de variacion//
            String[] vCadVariantes = aVector(cadParecida,puntoTags);
            
            //Despues comparar cada subcadena con la cadena original//
            for(int i=0; i<vCadVariantes.length; i++){
                //Si en alguna da true entonces terminar proceso y mandar true
                if(LikeA(cadOriginal,vCadVariantes[i],puntoVariacion,ignoreCase)){
                    salida=true;
                    i=vCadVariantes.length;
                }
            }
	}else{
            System.out.println("ERROR en LikeByTags_SOFT, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
    /**
     * Descripcion: Comparar si una cadena se parece a TODAS las otras multiples cadenas con puntos de variacion
     *      $ como marca de Tag
     *      # como marca de variacion
     *  Ejemplo: "Inversiones Compras mundo", "$#Inversion#$#Compra#mundo#" = true
     * Ejemplo: "Inversiones Compras", "$#Inversion#$#Compra#mundo#" = false
     * 
     * @param	cadOriginal Cadena a Comparar
     * @param   cadParecida Cadena con puntos de variacion
     * @param   puntoVariacion Caracter de variacion
     * @param   puntoTags Marca para separar diferentes tags
     * @param   ignoreCase Ignorar Mayusculas de Minusculas
     * @return	valores de retorno
     */
    public static boolean LikeByTags_HARD(String cadOriginal, String cadParecida, String puntoVariacion, String puntoTags, boolean ignoreCase){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=true;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Primero dividir la cadena parecida en un vector con subcadenas de variacion//
            String[] vCadVariantes = aVector(cadParecida,puntoTags);
            
            //Despues comparar cada subcadena con la cadena original//
            for(int i=0; i<vCadVariantes.length; i++){
                //Si en alguna da true entonces terminar proceso y mandar true
                if(LikeA(cadOriginal,vCadVariantes[i],puntoVariacion,ignoreCase)==false){
                    salida=false;
                    i=vCadVariantes.length;
                }
            }
	}else{
            System.out.println("ERROR en LikeByTags_HARD, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Convertir un caracter a un String
     *
     * @param	caracter caracter a convertir
     * @return	null o valores
     */
    public static String aString(char caracter){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            salida=Character.toString(caracter);
	}else{
            System.out.println("ERROR en aString, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Repetir una cadena un numero determinado de veces
     *
     * @param	cadOriginal Cadena a repetir un numero de veces
     * @param   num numero de Veces a repetir cadOriginal 0 = cadVacia
     * @return	String
     */
    public static String Repeat (String cadOriginal, int num){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
    if(num<0){
        condiciones=false;
        motivo="Numero negativo no valido";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            if(num==0){
                salida="";
            }else{
                String temp=cadOriginal;
                for(int i=1; i<num; i++){
                    temp=temp+cadOriginal;
                }
                
                salida=temp;
            }
	}else{
            System.out.println("ERROR en Repeat, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: de una cadena remplazar lo que se encuentre entre una CadenaA y una cadenaB
     *              Conservando las CadenaA y CadenaB
     * Ejm: CadOrginal "Hola Act(Mundo)"
     *      CadA "Act("
     *      CadB ")"
     *      Remplazo "Loco"
     * Salida "Hola Act(Loco)"
     *
     * @param	CadOriginal CadenaOriginal
     * @param   CadA  Cadena Inicial
     * @param   CadB  Cadena Final
     * @param   remplazo Cadena de remplazo
     * @return	CadOriginal o CadenaModificada
     */
    public static String remplazarSubcad_CadACadB (String CadOriginal, String CadA, String CadB, String remplazo){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=CadOriginal;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            int posCadA = Cad.posOfContains(CadOriginal, CadA, false);
            salida = Cad.EliminarCadACadB(salida, CadA, CadB);
            salida = Cad.InsertCad(salida, remplazo, posCadA+CadA.length());
	}else{
            System.out.println("ERROR en remplazarSubcad_CadACadB, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
     /**
     * Descripcion: Convertir un char en su valor en ascii
     *
     * @param	caracter Caracter a evaluar
     * @return	valor ascii o 0
     */
    public static int toASCIIvalue (char caracter){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            salida = (int) caracter;
	}else{
            System.out.println("ERROR en toASCIIvalue, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
     /**
     * Descripcion: Convertir un cadena en su peso en ASCII, es decir la suma de los valores de cada caracter
     *              no la concatenacion de los valores de cara caracter
     *
     * @param	cadena a Evaluar su peso
     * @return	valor ascii o 0
     */
    public static int toASCIIpeso (String cadena){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            char caracter;
            for(int i=0; i<cadena.length(); i++){
                caracter = cadena.charAt(i);
                salida = salida + (int) caracter;
            }
	}else{
            System.out.println("ERROR en toASCIIpeso, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
    
    
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
    }
}