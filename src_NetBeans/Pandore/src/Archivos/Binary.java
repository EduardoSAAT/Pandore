/*
 * esta es una clase con todas las funcionalidades para manejar Archivos binarios en Java
 * todo de una forma facil rapida y sencilla
 */
package Archivos;

import Algoritms.Cad;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ing Lalux
 */
public class Binary {
    //VARIABLES DEL ARCHIVO//
    public File archivo;
    public String nombreRuta="";
    
    public FileOutputStream FlujoSalida;
    public FileInputStream FlujoEntrada;
    
    
    
    
    /**
     * Descripcion: Relacionar una Variable Logica con el Nombre Logico
     *
     * @param	NombreyRuta Nombre y ruta del Archivo
     */
    public Binary(String NombreyRuta){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida="";
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(NombreyRuta)){
        condiciones=false;
        motivo="NombreyRuta es null o Vacio";
    }
    if(!FileExist(NombreyRuta)){
        condiciones=false;
        motivo="El archivo:"+NombreyRuta+" no existe";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Definir nombre Logico y Fisico//
           nombreRuta=NombreyRuta;
           archivo = new File(nombreRuta);
	}else{
            System.out.println("ERROR en Constructor: Binary, motivo: "+motivo+", valor regresado: "+salida);
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
     * Descripcion: Escribir un Objeto en el Archivo, esto remplaza todo su contenido anterior
     *      Recordar que hay que implementar la serializacion de la clase que se desee mandar como objeto
     *
     * @param	objeto Objeto a Mandar al Archivo
     */
    public void Escribir(Object objeto){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(objeto==null){
        condiciones=false;
        motivo="El objeto es null";
    }
    if(!FileExist(nombreRuta)){
        condiciones=false;
        motivo="El archivo no existe";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            try {
                FlujoSalida = new FileOutputStream(archivo);
                
                //ObjectOutputStream convierte objetos y variables en arrays de bits
                ObjectOutputStream convertBits = new ObjectOutputStream(FlujoSalida);
                
                
                //Escribir el objeto en el archivo usando el conversor//
                convertBits.writeObject(objeto);
                
                //Cerrar los flujos de salida//
                convertBits.close();
                FlujoSalida.close();
                
            } catch (FileNotFoundException ex) {
                System.out.println("ErrorInesperado al intentar escribir en el Archivo, el Archivo no Existe");
            } catch (IOException ex) {
                System.out.println("ErrorInesperado al intentar escribir en el Archivo, error de IO");
                System.out.println("    Solucion: falta Implement Serializable en la clase recibida");
            }
        }else{
            System.out.println("ERROR en Escribir, motivo: "+motivo);
	}
    //Terminar Proceso//
	System.out.println("Proceso Escribir Terminado");
    }
    
    
    
    /**
     * Descripcion: Leer todo el contenido del Arhivo
     *
     * @return	Objeto con todo el con tenido del archivo, solo tendrias que castearlo a lo que era anteriormente
     */
    public Object Leer(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    Object salida=null;
    //Comprobar Condiciones Iniciales//
    if(Tamaño()<=0){
        condiciones=false;
        motivo="El archivo esta vacio";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            try {
                FlujoEntrada = new FileInputStream(archivo);
                
                //ObjectOutputStream convierte objetos y variables en arrays de bits
                ObjectInputStream convertBits = new ObjectInputStream(FlujoEntrada);
                salida = convertBits.readObject();
                
                //Cerrar los Flujos de Entrada
                convertBits.close();
                FlujoEntrada.close();
                
                
            } catch (FileNotFoundException ex) {
                System.out.println("ErrorInesperado al intentar leer del Archivo, el Archivo no Existe");
            } catch (IOException ex) {
                System.out.println("ErrorInesperado al intentar leer en el Archivo, error de IO");
                System.out.println("    Solucion 1: falta Implement Serializable en la clase recibida");
                System.out.println("    Solucion 2: La clase del objeto cambio su estructura, no puede castearse");
            } catch (ClassNotFoundException ex) {
                System.out.println("ErrorInesperado al intentar leer en el Archivo, error de Clases");
                System.out.println("    Posibles Causas: -No se encuentra la definicion de alguna clase del Archivo en el path actual donde se ejecuta este script");
                System.out.println("        Solucion: Pasar y ejecutar este script a la carpeta donde se encuentra la definicion de las clases que componen el Archivo");
                Logger.getLogger(Binary.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }else{
            System.out.println("ERROR en Leer, motivo: "+motivo);
	}
    //Terminar Proceso//
	return salida;
    }
    
    
     /**
     * Descripcion: Obtener el tamaño en bytes de un archivo
     *
     * @return	Tamaño del archivo en bytes
     */
    public long Tamaño (){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        long salida=0;
    //Comprobar Condiciones Iniciales//
    if(FileExist(nombreRuta)==false){
        return 0;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida = archivo.length();
	}else{
            System.out.println("ERROR en Tamaño, motivo: "+motivo+", valor regresado: "+salida);
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
        
        CrearNewFile("temp.CrearCopia");
        Binary ArchTemp = new Binary("temp.CrearCopia");
        
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(nombreYRutaCopy)){
        condiciones=false;
        motivo="NombreyRutaCopy is null o vacia";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Copiar los Datos//
            Object Data = this.Leer();
            ArchTemp.Escribir(Data);
            
            //Cambiarle el nombre al archivoTemporal//
            ArchTemp.CambiarName(nombreYRutaCopy);
	}else{
            System.out.println("ERROR en CrearCopia, motivo: "+motivo+", valor regresado: "+salida);
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
     * @return	false no se pudo copiar, true se copio con exito
     */
    public static boolean CrearCopiaFile (String nombreYRutaOriginal, String nombreYRutaCopy, boolean Remplaze){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
        
        Binary newArch;
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
                newArch = new Binary(nombreYRutaOriginal);
                newArch.CrearCopia(nombreYRutaCopy);
                salida=true;
            }else{
                if(FileExist(nombreYRutaCopy)){
                    salida=false;
                    System.out.println("No se creo copia del archivo, porque ya existe el archivo copia");
                }else{
                    newArch = new Binary(nombreYRutaOriginal);
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
    
    
}
