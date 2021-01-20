/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import Algoritms.Cad;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ing Lalux
 */
public class Text {
    //VARIABLES DEL ARCHIVO//
    public File archivo;
    public int estadoActual=0; //0=Cerrado, 1=AbiertoLectura, 2=AbiertoEscritura, 3=AbiertoLyE
    public int NumeroLineas=0;
    public String nombreRuta="";
    
    public BufferedReader FlujoSalida;
    public BufferedWriter FlujoEntrada;
    
    
    
    
    /**
     * Descripcion: Relacionar una Variable Logica con el Nombre Logico
     * 
     *
     * @param	NombreyRuta Nombre y Ruta del Archivo a Relacionar
     */
    public Text(String NombreyRuta){
       if(FileExist(NombreyRuta)){
           //Definir nombre Logico y Fisico//
           nombreRuta=NombreyRuta;
           archivo = new File(nombreRuta);
           
           //Contar el Numero de Lineas del Archivo Actual//
           NumeroLineas=NumLines();
       }else{
           System.out.println("ERROR en Constructor Text: El Archivo: "+NombreyRuta+" No existe!");
       }    
    }
    
    
    /**
     * Descripcion: Crear un nuevo Archivo
     *
     * @param	nombreRuta Nombre y ruta del archivo
     * @return	true o false
     */
    public static boolean CrearNewFile (String nombreRuta){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
        
        File arch;
        BufferedWriter FlujoIN;
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(nombreRuta)){
        condiciones=false;
        motivo="NombreyRuta null o vacia";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            try {
                arch = new File(nombreRuta);
                FlujoIN = new BufferedWriter(new FileWriter(arch));
                FlujoIN.close();
                salida=true;
                
                
            } catch (FileNotFoundException ex) {
                salida=false;
            } catch (IOException ex) {
                salida=false;
            }
	}else{
            System.out.println("ERROR en CrearNewFile, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Eliminar un Archivo dado su nombre y su ruta
     *
     * @param	NombreyRuta Del Archivo a Eliminar//
     * @return	true o false
     */
    public static boolean EliminarArchivo (String NombreyRuta){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
        
        File Archivo;
    //Comprobar Condiciones Iniciales//
    if(!FileExist(NombreyRuta)){
        condiciones=false;
        motivo="El Archivo no Existe!";
    }
    if(NombreyRuta==null){
        condiciones=false;
        motivo="NombreYRuta NULL no existe";
    }else{
        if(NombreyRuta.equals("")){
            condiciones=false;
            motivo="NombreYRuta NULL no existe";
        }
    }
	//Comenzar Proceso//
        if(condiciones==true){
            Archivo = new File(NombreyRuta);
            Archivo.delete();
            salida=true;
	}else{
            System.out.println("ERROR en EliminarArchivo, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Cambiar el nombre de un Archivo
     *
     * @param   NuevoNombre Nuevo Nombre del Archivo
     * @return	true o false
     */
    public boolean CambiarName (String NuevoNombre){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
        
        File Archivo2 = new File(NuevoNombre);
    //Comprobar Condiciones Iniciales//
    if(!FileExist(nombreRuta)){
        condiciones=false;
        motivo="El Archivo no Existe!";
    }
    if(estadoActual!=0){
        condiciones=false;
        motivo="El Archivo esta Actualemte Abierto";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            this.archivo.renameTo(Archivo2);
            salida=true;
	}else{
            System.out.println("ERROR en CambiarName, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Verificar si un Archivo existe
     *
     * @param	nombreRuta Nombre y ruta del archivo
     * @return	true o false
     */
    public static boolean FileExist (String nombreRuta){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
        
        File arch;
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(nombreRuta)){
        condiciones=false;
        motivo="Nombre y Ruta NULL o Vacio";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            arch = new File(nombreRuta);
            if((arch.exists())&&(arch.isFile())){
                salida=true;
            }else{
                salida=false;
            }
	}else{
            System.out.println("ERROR en FileExist, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }

    
    /**
     * Descripcion: Abrir un Flujo para el Archivo Actual
     * No se requiere utilizar en una aplicacion practica
     *
     * @param   modo 1=Lectura, 2=Escritura, 3=LYE
     * @return  true o false
     */
    private boolean AbrirArchivo (int modo){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    boolean salida=false;
    
    //Comprobar Condiciones Iniciales//
    if(estadoActual!=0){
        condiciones=false;
        motivo="El Archivo: "+nombreRuta+" ya se encuentra Abierto!";
    }
    if(!FileExist(nombreRuta)){
        condiciones=false;
        motivo="El Archivo no Existe";
    }
    if((modo<1)||(modo>3)){
        condiciones=false;
        motivo="El modo de Apertura no Existe";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            try {
                switch(modo){
                    case 1: FlujoSalida = new BufferedReader(new FileReader(archivo));
                            estadoActual=1;
                            salida=true;
                        break;
                    case 2: {
                                try {
                                    FlujoEntrada = new BufferedWriter(new FileWriter(archivo,true));
                                    estadoActual=2;
                                    salida=true;
                                } catch (IOException ex) {
                                    Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        break;
                    case 3: {
                                try {
                                    FlujoSalida = new BufferedReader(new FileReader(archivo));
                                    FlujoEntrada = new BufferedWriter(new FileWriter(archivo,true));
                                    estadoActual=3;
                                    salida=true;
                                } catch (IOException ex) {
                                    Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        break;
                }
            } catch (FileNotFoundException ex) {
                System.out.println("El Archivo no Existe!");
                return false;
            }
        }else{
            System.out.println("ERROR en AbrirArchivo, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
        return salida;
    }
    
    
    /**
     * Descripcion: Cerrar el Archivo Actual
     *
     * @return  true o false
     */
    private boolean CerrarArchivo (){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    boolean salida = false;
    
    //Comprobar Condiciones Iniciales//
    if(this.estadoActual==0){
        condiciones=false;
        motivo="El archivo ya se encuentra cerrado!";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            try {
                switch(estadoActual){
                    case 1: FlujoSalida.close(); salida=true;
                        break;
                    case 2: FlujoEntrada.close(); salida=true;
                        break;
                    case 3: FlujoSalida.close(); FlujoEntrada.close(); salida=true;
                        break;
                }
                estadoActual=0;
            } catch (IOException ex) {
                salida = false;
            }
        }else{
            System.out.println("ERROR en CerrarArchivo, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
        return salida;
    }
    
    
    /**
     * Descripcion: Contar el numero de Lineas del Archivo
     *
     * @return	Entero
     */
    public int NumLines (){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
    if(!AbrirArchivo(1)){
        condiciones=false;
        motivo="No se puede Abrir el Archivo!";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            try {
                while(FlujoSalida.readLine()!=null){
                    salida=salida+1;
                }
            } catch (IOException ex) {
                Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
            }
            CerrarArchivo();
	}else{
            System.out.println("ERROR en NumLines, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Agregar una Linea al Final del Archivo
     *
     * @param	Linea String a agregar al Final
     * @return	valores de retorno
     */
    public boolean AgregarLine (String Linea){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
        
        String leido="";
    //Comprobar Condiciones Iniciales//
    if(!AbrirArchivo(3)){
        condiciones=false;
        motivo="No se puede Abrir el Archivo!";
    }
    if(Linea==null){
        condiciones=false;
        motivo="Linea NuLL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            try {
                if(NumeroLineas==0){
                    FlujoEntrada.append(Linea);
                }else{
                    FlujoEntrada.append("\n");
                    FlujoEntrada.append(Linea);
                }
                NumeroLineas=NumeroLineas+1;
            } catch (IOException ex) {
                Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            CerrarArchivo();
	}else{
            System.out.println("ERROR en AgregarLine, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Leer la linea N del Archivo Actual
     *
     * @param	numLinea Numero de Linea a Obtener String
     * @return	null o String
     */
    public String LeerLineaN (int numLinea){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
    if(!AbrirArchivo(1)){
        condiciones=false;
        motivo="El archivo no se pudo Abrir";
    }
    if((numLinea>NumeroLineas)||(numLinea<=0)){
        condiciones=false;
        motivo="Linea no Existe";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=1; i<=numLinea; i++){
                try {
                    salida=FlujoSalida.readLine();
                } catch (IOException ex) {
                    Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            CerrarArchivo();
	}else{
            System.out.println("ERROR en LeerLineaN, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Crea una Copia del Archivo Actual
     *
     * @param nombreYRutaCopy si es "" o null entonces xxx -Copia.xxx
     * @return	true o false
     */
    public boolean CrearCopia (String nombreYRutaCopy){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
        
        String Linea="";
        boolean inserto=false;
        int countLinea=0;
        CrearNewFile("temp.CrearCopia");
        Text ArchTemp = new Text("temp.CrearCopia");
        
    //Comprobar Condiciones Iniciales//
    if(!AbrirArchivo(1)){
        condiciones=false;
        motivo="No se puede Abrir el Archivo!";
    }
    if(!ArchTemp.AbrirArchivo(2)){
        condiciones=false;
        motivo="No se puede Abrir el ArchivoTemporal!";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            try {
                //Leer la Primera Linea//
                Linea=FlujoSalida.readLine();
                countLinea=countLinea+1;
                
                //Leer El resto del Archivo//
                while(Linea!=null){
                    //Si es la primerainsercion con Append
                    if(inserto==false){
                        ArchTemp.FlujoEntrada.append(Linea);
                        inserto=true;
                    }else{//Si es el resto con Salto y Append
                        ArchTemp.FlujoEntrada.newLine();
                        ArchTemp.FlujoEntrada.append(Linea);
                        inserto=true;
                    }
                    
                    //Seguir Leyendo//
                    Linea=FlujoSalida.readLine();
                    countLinea=countLinea+1;
                }
                
                //Cerrar Archivos//
                CerrarArchivo();
                ArchTemp.CerrarArchivo();
                
                //Obtener el Nombre del Archivo
                String Name=Cad.subCadANTESdeCad(nombreRuta, ".");
                
                //Cambiar nombre del Temporal por el Original//
                if(Cad.isNulloVacia(nombreYRutaCopy)){
                    ArchTemp.CambiarName(Name.concat(" -Copia.").concat(Cad.subCadCadAPosB(nombreRuta,".",nombreRuta.length())));
                }else{
                    ArchTemp.CambiarName(nombreYRutaCopy);
                }
                
                salida=true;
            } catch (IOException ex) {
                Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
            }
	}else{
            System.out.println("ERROR en CrearCopia, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Insertar una Linea en una posicion N, reccoriendo el resto del archivo un espacio
     *
     * @param	posN posicion donde insertar la Linea
     * @param   Line Linea a Insertar
     * @return	true o false
     */
    public boolean InsertLineN (int posN, String Line){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
        
        String Linea="";
        boolean inserto=false;
        int countLinea=0;
        CrearNewFile("temp.InsertLineN");
        Text ArchTemp = new Text("temp.InsertLineN");
        
    //Comprobar Condiciones Iniciales//
    if(posN<=0){
        condiciones=false;
        motivo="No se encuentra la Linea: "+posN;
    }
    if(!AbrirArchivo(1)){
        condiciones=false;
        motivo="No se puede Abrir el Archivo!";
    }
    if(!ArchTemp.AbrirArchivo(2)){
        condiciones=false;
        motivo="No se puede Abrir el ArchivoTemporal!";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            try {
                
                //Tomar en cuenta el factor de Igualdad 0 y 1 entre archivos de Texto//
                if((NumeroLineas==0)&&(posN==1)){
                    //Leer la Primera Linea//
                    Linea=FlujoSalida.readLine();
                    countLinea=countLinea+1;

                    //Leer El resto del Archivo//
                    while(Linea!=null){
                        //Si es la primerainsercion con Append
                        if(inserto==false){
                            if(countLinea!=posN){
                                ArchTemp.FlujoEntrada.append(Linea);
                                inserto=true;
                            }else{
                                //Insertar NewLine y Ademas Texto Leido
                                ArchTemp.FlujoEntrada.append(Line);
                                ArchTemp.FlujoEntrada.newLine();
                                ArchTemp.FlujoEntrada.append(Linea);
                                inserto=true;
                            }
                        }else{//Si es el resto con Salto y Append
                            if(countLinea!=posN){
                                ArchTemp.FlujoEntrada.newLine();
                                ArchTemp.FlujoEntrada.append(Linea);
                                inserto=true;
                            }else{
                                //Insertar NewLine y Ademas Texto Leido
                                ArchTemp.FlujoEntrada.newLine();
                                ArchTemp.FlujoEntrada.append(Line);
                                ArchTemp.FlujoEntrada.newLine();
                                ArchTemp.FlujoEntrada.append(Linea);
                                inserto=true;
                            }
                        }

                        //Seguir Leyendo//
                        Linea=FlujoSalida.readLine();
                        countLinea=countLinea+1;
                    }

                    //Si la posicion esta fuera del archivo Agregarla//
                    int diferencia=0;

                    if(NumeroLineas==0){
                        ArchTemp.FlujoEntrada.append(Line);
                        diferencia=1;
                    }else{
                        if(posN>NumeroLineas){
                            diferencia = posN-NumeroLineas;
                            for(int i=0; i<diferencia-1; i++){
                                ArchTemp.FlujoEntrada.append("\n");
                            }
                            ArchTemp.FlujoEntrada.append("\n");
                            ArchTemp.FlujoEntrada.append(Line);
                        }
                    }


                    //Cambiar el numero de Lineas que tiene el Archivo//
                    if(posN>NumeroLineas){
                        NumeroLineas=NumeroLineas+diferencia;
                    }else{
                        NumeroLineas=NumeroLineas+1;
                    }
                }else{
                    if(NumeroLineas==0){
                        NumeroLineas=1;
                    }
                    //Leer la Primera Linea//
                    Linea=FlujoSalida.readLine();
                    countLinea=countLinea+1;

                    //Leer El resto del Archivo//
                    while(Linea!=null){
                        //Si es la primerainsercion con Append
                        if(inserto==false){
                            if(countLinea!=posN){
                                ArchTemp.FlujoEntrada.append(Linea);
                                inserto=true;
                            }else{
                                //Insertar NewLine y Ademas Texto Leido
                                ArchTemp.FlujoEntrada.append(Line);
                                ArchTemp.FlujoEntrada.newLine();
                                ArchTemp.FlujoEntrada.append(Linea);
                                inserto=true;
                            }
                        }else{//Si es el resto con Salto y Append
                            if(countLinea!=posN){
                                ArchTemp.FlujoEntrada.newLine();
                                ArchTemp.FlujoEntrada.append(Linea);
                                inserto=true;
                            }else{
                                //Insertar NewLine y Ademas Texto Leido
                                ArchTemp.FlujoEntrada.newLine();
                                ArchTemp.FlujoEntrada.append(Line);
                                ArchTemp.FlujoEntrada.newLine();
                                ArchTemp.FlujoEntrada.append(Linea);
                                inserto=true;
                            }
                        }

                        //Seguir Leyendo//
                        Linea=FlujoSalida.readLine();
                        countLinea=countLinea+1;
                    }

                    //Si la posicion esta fuera del archivo Agregarla//
                    int diferencia=0;

                    if(NumeroLineas==0){
                        ArchTemp.FlujoEntrada.append(Line);
                        diferencia=1;
                    }else{
                        if(posN>NumeroLineas){
                            diferencia = posN-NumeroLineas;
                            for(int i=0; i<diferencia-1; i++){
                                ArchTemp.FlujoEntrada.append("\n");
                            }
                            ArchTemp.FlujoEntrada.append("\n");
                            ArchTemp.FlujoEntrada.append(Line);
                        }
                    }


                    //Cambiar el numero de Lineas que tiene el Archivo//
                    if(posN>NumeroLineas){
                        NumeroLineas=NumeroLineas+diferencia;
                    }else{
                        NumeroLineas=NumeroLineas+1;
                    }
                }
                
                
                //Cerrar Archivos//
                CerrarArchivo();
                ArchTemp.CerrarArchivo();
                
                //Eliminar el Viejo
                String Name=nombreRuta;
                EliminarArchivo(nombreRuta);
                
                //Cambiar nombre del Temporal por el Original//
                ArchTemp.CambiarName(Name);
                salida=true;
                
            } catch (IOException ex) {
                Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
            }
	}else{
            System.out.println("ERROR en InsertLineN, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Reamplazar la Linea N del Archivo
     *
     * @param	numLine Numero de Linea a Eliminar
     * @param   newLine Nueva Linea a Colocar
     * @return	true o false
     */
    public boolean RemplaceLineN (int numLine, String newLine){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
        
        String Linea="";
        boolean inserto=false;
        int countLinea=0;
        CrearNewFile("temp.RemplaceLineN");
        Text ArchTemp = new Text("temp.RemplaceLineN");
        
    //Comprobar Condiciones Iniciales//
    if((numLine<=0)||(numLine>NumeroLineas)){
        condiciones=false;
        motivo="No se encuentra la Linea: "+numLine;
    }
    if(!AbrirArchivo(1)){
        condiciones=false;
        motivo="No se puede Abrir el Archivo!";
    }
    if(!ArchTemp.AbrirArchivo(2)){
        condiciones=false;
        motivo="No se puede Abrir el ArchivoTemporal!";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            try {
                //Leer la Primera Linea//
                Linea=FlujoSalida.readLine();
                countLinea=countLinea+1;
                
                //Leer El resto del Archivo//
                while(Linea!=null){
                    //Si es la primerainsercion con Append
                    if(inserto==false){
                        if(countLinea!=numLine){
                            ArchTemp.FlujoEntrada.append(Linea);
                            inserto=true;
                        }else{
                            //Si es la Linea a Remplazar
                            ArchTemp.FlujoEntrada.append(newLine);
                            inserto=true;
                        }
                    }else{//Si es el resto con Salto y Append
                        if(countLinea!=numLine){
                            ArchTemp.FlujoEntrada.newLine();
                            ArchTemp.FlujoEntrada.append(Linea);
                            inserto=true;
                        }else{
                            //Si es la Linea a Remplazar
                            ArchTemp.FlujoEntrada.newLine();
                            ArchTemp.FlujoEntrada.append(newLine);
                            inserto=true;
                        }
                    }
                    
                    //Seguir Leyendo//
                    Linea=FlujoSalida.readLine();
                    countLinea=countLinea+1;
                }
                
                //Cerrar Archivo Original//
                CerrarArchivo();
                ArchTemp.CerrarArchivo();
                
                //Eliminar el Viejo
                String Name=nombreRuta;
                EliminarArchivo(nombreRuta);
                
                //Cambiar nombre del Temporal por el Original//
                ArchTemp.CambiarName(Name);
                salida=true;
                
            } catch (IOException ex) {
                Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
            }
	}else{
            System.out.println("ERROR en RemplaceLineN, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Eliminar la Linea N del Archivo
     *
     * @param	numLine Numero de Linea a Eliminar
     * @return	true o false
     */
    public boolean EliminarLineN (int numLine){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
        
        String Linea="";
        boolean inserto=false;
        int countLinea=0;
        CrearNewFile("temp.EliminarLineN");
        Text ArchTemp = new Text("temp.EliminarLineN");
        
    //Comprobar Condiciones Iniciales//
    if((numLine<=0)||(numLine>NumeroLineas)){
        condiciones=false;
        motivo="No se encuentra la Linea: "+numLine;
    }
    if(!AbrirArchivo(1)){
        condiciones=false;
        motivo="No se puede Abrir el Archivo!";
    }
    if(!ArchTemp.AbrirArchivo(2)){
        condiciones=false;
        motivo="No se puede Abrir el ArchivoTemporal!";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            try {
                //Leer la Primera Linea//
                Linea=FlujoSalida.readLine();
                countLinea=countLinea+1;
                
                //Leer El resto del Archivo//
                while(Linea!=null){
                    //Si es la primerainsercion con Append
                    if(inserto==false){
                        if(countLinea!=numLine){
                            ArchTemp.FlujoEntrada.append(Linea);
                            inserto=true;
                        }
                    }else{//Si es el resto con Salto y Append
                        if(countLinea!=numLine){
                            ArchTemp.FlujoEntrada.newLine();
                            ArchTemp.FlujoEntrada.append(Linea);
                            inserto=true;
                        }
                    }
                    
                    //Seguir Leyendo//
                    Linea=FlujoSalida.readLine();
                    countLinea=countLinea+1;
                }
                
                //Cambiar el Numero de Lineas//
                NumeroLineas=NumeroLineas-1;
                
                //Cerrar Archivos//
                CerrarArchivo();
                ArchTemp.CerrarArchivo();
                
                //Eliminar el Viejo
                String Name=nombreRuta;
                EliminarArchivo(nombreRuta);
                
                //Cambiar nombre del Temporal por el Original//
                ArchTemp.CambiarName(Name);
                salida=true;
                
            } catch (IOException ex) {
                Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
            }
	}else{
            System.out.println("ERROR en EliminarLineN, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Continuar con el Texto de la LineaN
     *
     * @param   numLine Numero de Linea a Continuar
     * @param	addText Texto a agregar
     * @return	true o false
     */
    public boolean ContinueLineN (int numLine, String addText){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
        
        String Linea="";
        boolean inserto=false;
        int countLinea=0;
        CrearNewFile("temp.ContinueLineN");
        Text ArchTemp = new Text("temp.ContinueLineN");
        
    //Comprobar Condiciones Iniciales//
    if((numLine<=0)||(numLine>NumeroLineas)){
        condiciones=false;
        motivo="No se encuentra la Linea: "+numLine;
    }
    if(!AbrirArchivo(1)){
        condiciones=false;
        motivo="No se puede Abrir el Archivo!";
    }
    if(!ArchTemp.AbrirArchivo(2)){
        condiciones=false;
        motivo="No se puede Abrir el ArchivoTemporal!";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            try {
                //Leer la Primera Linea//
                Linea=FlujoSalida.readLine();
                countLinea=countLinea+1;
                
                //Leer El resto del Archivo//
                while(Linea!=null){
                    //Si es la primerainsercion con Append
                    if(inserto==false){
                        if(countLinea!=numLine){
                            ArchTemp.FlujoEntrada.append(Linea);
                            inserto=true;
                        }else{
                            //Agregar la Linea y ademas el Texto a Agregar
                            ArchTemp.FlujoEntrada.append(Linea);
                            ArchTemp.FlujoEntrada.append(addText);
                            inserto=true;
                        }
                    }else{//Si es el resto con Salto y Append
                        if(countLinea!=numLine){
                            ArchTemp.FlujoEntrada.newLine();
                            ArchTemp.FlujoEntrada.append(Linea);
                            inserto=true;
                        }else{
                            //Agregar la Linea y ademas el Texto a Agregar
                            ArchTemp.FlujoEntrada.newLine();
                            ArchTemp.FlujoEntrada.append(Linea);
                            ArchTemp.FlujoEntrada.append(addText);
                            inserto=true;
                        }
                    }
                    
                    //Seguir Leyendo//
                    Linea=FlujoSalida.readLine();
                    countLinea=countLinea+1;
                }
                
                //Cerrar Archivos//
                CerrarArchivo();
                ArchTemp.CerrarArchivo();
                
                //Eliminar el Viejo
                String Name=nombreRuta;
                EliminarArchivo(nombreRuta);
                
                //Cambiar nombre del Temporal por el Original//
                ArchTemp.CambiarName(Name);
                salida=true;
                
            } catch (IOException ex) {
                Logger.getLogger(Text.class.getName()).log(Level.SEVERE, null, ex);
            }
	}else{
            System.out.println("ERROR en ContinueLineN, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Obtener la primer Linea que se parece a un Patron especifico
     *  Ejm: "Hola$mundo$" "$"  =  "hola como mundo estan"
     * @param	Patron Patron a buscar linea a linea en el Archivo
     * @param   puntoVariacion Punto de Variacion del Patron
     * @return	Null NO encontro o Linea con Text
     */
    public String getLineLike (String Patron, String puntoVariacion){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
    if(Patron==null||puntoVariacion==null){
        condiciones=false;
        motivo="El Patron o PuntoVariacion NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            String linea="";
            for(int i=1; i<=NumeroLineas; i++){
                linea=LeerLineaN(i);
                if(Cad.LikeA(linea,Patron, puntoVariacion,true)){
                    salida=linea; i=NumeroLineas+1;
                }
            }
	}else{
            System.out.println("ERROR en getLineLike, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
     /**
     * Descripcion: Obtener la primer Linea que se parece a un Patron especifico
     *  Ejm: "Hola$mundo$" "$"  =  "hola como mundo estan"
     *  Entre una posicionA del Archivo y una posicionB
     * @param	Patron Patron a buscar linea a linea en el Archivo
     * @param   puntoVariacion Punto de Variacion del Patron
     * @param   posA linea de iniccio de busqueda inclusive
     * @param   posB linea de fin de busqueda inclusive
     * @return	Null NO encontro o Linea con Text
     */
    public String getLineLikeBetween (String Patron, String puntoVariacion, int posA, int posB){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
    if(Patron==null||puntoVariacion==null){
        condiciones=false;
        motivo="El Patron o PuntoVariacion NULL";
    }
    if(posA<=0){
        condiciones=false;
        motivo="PosA no valida";
    }
    if(posB>NumeroLineas){
        condiciones=false;
        motivo="PosB no valida";
    }
    if(posA>=posB){
        condiciones=false;
        motivo="PosA menor a posB";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            String line;
            for(int x=posA; x<=posB; x++){
                line=LeerLineaN(x);
                
                if(Cad.LikeA(line,Patron, puntoVariacion)){
                    salida=line;
                    x=posB+1;
                }
            }
	}else{
            System.out.println("ERROR en getLineLikeBetween, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener la Nnesima Linea que se parece a un Patron especifico
     *  Ejm: "Hola$mundo$" "$"  =  "hola como mundo estan"
     * @param	Patron Patron a buscar linea a linea en el Archivo
     * @param   puntoVariacion Punto de Variacion del Patron
     * @param   numMatch Numero de Coincidencia encontrada
     * @return	Null NO encontro o Linea con Text
     */
    public String getLineLikeN (String Patron, String puntoVariacion, int numMatch){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
    if(Patron==null||puntoVariacion==null){
        condiciones=false;
        motivo="El Patron o PuntoVariacion NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            String linea="";
            int numMatchTemp=0;
            for(int i=1; i<=NumeroLineas; i++){
                linea=LeerLineaN(i);
                if(Cad.LikeA(linea,Patron, puntoVariacion,true)){
                    numMatchTemp=numMatchTemp+1;
                    if(numMatchTemp==numMatch){
                        salida=linea; i=NumeroLineas+1;
                    }
                }
            }
	}else{
            System.out.println("ERROR en getLineLikeN, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener la UltimaLinea que se parece a un Patron especifico
     *  Ejm: "Hola$mundo$" "$"  =  "hola como mundo estan"
     * @param	Patron Patron a buscar linea a linea en el Archivo
     * @param   puntoVariacion Punto de Variacion del Patron
     * @return	Null NO encontro o Linea con Text
     */
    public String getLineLikeLast (String Patron, String puntoVariacion){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
    if(Patron==null||puntoVariacion==null){
        condiciones=false;
        motivo="El Patron o PuntoVariacion NULL";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            String linea="";
            for(int i=1; i<=NumeroLineas; i++){
                linea=LeerLineaN(i);
                if(Cad.LikeA(linea,Patron, puntoVariacion,true)){
                    salida=linea;
                }
            }
	}else{
            System.out.println("ERROR en getLineLikeLast, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Crear una Copia de un Archivo
     *
     * @param	nombreYRutaOriginal del Archivo a Copiar
     * @param   nombreYRutaCopy Del nuevo Archivo de Copia
     * @param   Remplaze Remplazar archivo si es que existe si o no
     * @return	valores de retorno
     */
    public static boolean CrearCopiaFile (String nombreYRutaOriginal, String nombreYRutaCopy, boolean Remplaze){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
        
        Text newArch;
    //Comprobar Condiciones Iniciales//
    if(!FileExist(nombreYRutaOriginal)){
        condiciones=false;
        motivo="No esiste el archivo: "+nombreYRutaOriginal;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            
            if(Remplaze){
                if(FileExist(nombreYRutaCopy)){
                    Text.EliminarArchivo(nombreYRutaCopy);
                }
                newArch = new Text(nombreYRutaOriginal);
                newArch.CrearCopia(nombreYRutaCopy);
                salida=true;
            }else{
                if(FileExist(nombreYRutaCopy)){
                    salida=false;
                }else{
                    newArch = new Text(nombreYRutaOriginal);
                    newArch.CrearCopia(nombreYRutaCopy);
                    salida=true; 
                }
            }
	}else{
            System.out.println("ERROR en CrearCopiaFile, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Obtener la Posicion de una Linea en Especifico, buscar la pos de una Linea
     *
     * @param	Linea Linea a buscar en el Archivo
     * @param   IgnoreCase Ignorar Mayusculas y minusculas?
     * @return	-1 ERROR  0 No Encontro, Mayor a 0 Posicion donde Encontro Linea
     */
    public int posLine (String Linea, boolean IgnoreCase){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
        
        String temp="";
    //Comprobar Condiciones Iniciales//
    if(Linea==null){
        salida=-1;
        condiciones=false;
        motivo="Linea NULL a buscar en Archivo";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=1; i<=NumeroLineas; i++){
                temp=LeerLineaN(i);
                if(IgnoreCase==true){
                    temp=temp.toUpperCase();
                    Linea=Linea.toUpperCase();
                }
                if(Linea.equals(temp)){
                    salida=i;
                    i=NumeroLineas+1;
                }
            }
	}else{
            System.out.println("ERROR en posLine, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Obtener el numero de la Linea que se parece a un Patron
     *
     * @param	Patron "$Hola$" la Cadena que se busca en el Archivo
     * @param   puntoVariacion "$" El indicador donde varia el PAtron
     * @return	-1 en ERROR  0 NoFound  Mayor a 1 Linea Correcta Encontrada
     */
    public int posLineLike(String Patron, String puntoVariacion){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=-1;
        
        String temp="";
    //Comprobar Condiciones Iniciales//
    if((Patron==null)||(puntoVariacion==null)){
        condiciones=false;
        motivo="Patron o puntoVariacion NULL";
        salida=-1;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            temp=getLineLike(Patron, puntoVariacion);
            salida=posLine(temp,false);
	}else{
            System.out.println("ERROR en posLineLike, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
    
    /**
     * Descripcion: Obtener el numero de la Linea que se parece a un Patron entre una posicionA y una posicionB
     * 
     *
     * @param	Patron "$Hola$" la Cadena que se busca en el Archivo
     * @param   puntoVariacion "$" El indicador donde varia el PAtron
     * @param   posA posicion inicial a buscar
     * @param   posB posicion final a buscar
     * @return	-1 en ERROR  0 NoFound  Mayor a 1 Linea Correcta Encontrada
     */
    public int posLineLikeBetween(String Patron, String puntoVariacion, int posA, int posB){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=-1;
        
        String temp="";
    //Comprobar Condiciones Iniciales//
    if((Patron==null)||(puntoVariacion==null)){
        condiciones=false;
        motivo="Patron o puntoVariacion NULL";
        salida=-1;
    }
    if(posA<=0){
        condiciones=false;
        motivo="PosA no valida";
    }
    if(posB>NumeroLineas){
        condiciones=false;
        motivo="PosB no valida";
    }
    if(posA>=posB){
        condiciones=false;
        motivo="PosA menor a posB";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            String line;
            for(int i=posA; i<=posB ; i++){
                line = LeerLineaN(i);
                if(Cad.LikeA(line,Patron, puntoVariacion)){
                    salida = i;
                    i=posB+1;
                }
            }
	}else{
            System.out.println("ERROR en posLineLikeBetween, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Obtener el Ultimo numero de la Linea que se parece a un Patron
     *
     * @param	Patron "$Hola$" la Cadena que se busca en el Archivo
     * @param   puntoVariacion "$" El indicador donde varia el PAtron
     * @return	-1 en ERROR  0 NoFound  Mayor a 1 Linea Correcta Encontrada
     */
    public int posLineLikeLast(String Patron, String puntoVariacion){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=-1;
        
        String temp="";
    //Comprobar Condiciones Iniciales//
    if((Patron==null)||(puntoVariacion==null)){
        condiciones=false;
        motivo="Patron o puntoVariacion NULL";
        salida=-1;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            String linea="";
            for(int i=1; i<=NumeroLineas; i++){
                linea=LeerLineaN(i);
                if(Cad.LikeA(linea,Patron, puntoVariacion,true)){
                    salida=i;
                }
            }
	}else{
            System.out.println("ERROR en posLineLikeLast, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Obtener el Nnesimo numero de la Linea que se parece a un Patron
     *
     * @param	Patron "$Hola$" la Cadena que se busca en el Archivo
     * @param   puntoVariacion "$" El indicador donde varia el PAtron
     * @param   numMatch Numero de coincidencia del patron
     * @return	-1 en ERROR  0 NoFound  Mayor a 1 Linea Correcta Encontrada
     */
    public int posLineLikeN(String Patron, String puntoVariacion, int numMatch){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=-1;
        
        String temp="";
    //Comprobar Condiciones Iniciales//
    if((Patron==null)||(puntoVariacion==null)){
        condiciones=false;
        motivo="Patron o puntoVariacion NULL";
        salida=-1;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            temp=getLineLikeN(Patron, puntoVariacion, numMatch);
            salida=posLine(temp,false);
	}else{
            System.out.println("ERROR en posLineLikeN, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Eliminar todas las lineas desde una posicionA hasta una posicionB
     * 
     * @param   posA Posicion Inicial
     * @param   posB Posicion Final
     * @param	Inclusive Incluir en la Eliminada las lineas en la posA y posB o no incluirlas 
     */
    public void deleteLinePosAPosB(int posA, int posB, boolean Inclusive){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(posA > posB){
        condiciones = false;
        motivo="PosA mayor que PosB";
    }
    if(posA<=0 || posB<=0){
        condiciones = false;
        motivo="PosA o PosB menores iguales a cero";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            if(Inclusive){
                for(int i=posA; i<=posB; i++){
                    EliminarLineN(posA);
                }
            }else{
                for(int i=posA+1; i<posB; i++){
                    EliminarLineN(posA);
                }
            }
        }else{
            System.out.println("ERROR en deleteLinePosAPosB, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso deleteLinePosAPosB Terminado con EXITO");
    	}else{
            System.out.println("Proceso deleteLinePosAPosB Terminado con FALLO");
    	}
    }
    
    
    
}
