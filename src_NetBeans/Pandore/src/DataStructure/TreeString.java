/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

import Algoritms.Cad;
import Algoritms.Dimention;
import Archivos.Text;
import Dinamic.VectorString;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;


/**
 *
 * @author Ing Lalux
 */
public class TreeString implements Serializable{
    //Raiz del Arbol
        public Nodo raiz=null;
        public String IdArbol=null;
    
    
        
    /**
     * Descripcion: Crear un Nuevo Arbol, iniciando de su raiz y el valor de su Elemento
     *
     * @param	Raiz Valor del Elemento de este nodo
     */
    public TreeString(String Raiz){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            raiz= new Nodo(Raiz);
	}else{
            System.out.println("ERROR en Constructor: TreeString, motivo: "+motivo);
	}
    }

    
    /**
     * Descripcion: Crear un Nuevo Arbol, con valor de su raiz y un identificador
     *
     * @param   Id Identificador del Arbol
     * @param	Raiz Valor del Elemento de este nodo
     */
    public TreeString(String Id,String Raiz){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            raiz= new Nodo(Raiz);
            this.IdArbol = Id;
	}else{
            System.out.println("ERROR en Constructor: TreeString, motivo: "+motivo);
	}
    }
        
        
    
     /**
     * Descripcion: Obtener el elemento de un HIJO
     *
     * @param	ruta Ruta en formato "#H#H#H o Raiz ejm:  1H3H2H  o R para referirse al elemento de la raiz"
     * @param   ERROR Valor de salida en caso de algun error
     * @return	valor del Elemnto de ese nodo o ERROR
     */
    public String getElement (String ruta, String ERROR){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=ERROR;
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            if(Cad.isNulloVacia(ruta)==false){
                if(nodoExist(ruta)){
                    //Ver si piden el nodo Raiz o alguno de sus Hijos//
                    if(ruta.equalsIgnoreCase("R")){
                        salida = raiz.Element;
                    }else{
                        //Convertir la ruta a vector de Numeros//
                        String[] vectorStrings = Cad.aVector(ruta,"H");
                        int[] vectorNumeros = Dimention.convertVectorStringToVectorInt(vectorStrings);
                        
                        Nodo node = raiz.getSon(vectorNumeros[0]);
                        for(int i=1 ;i<vectorNumeros.length; i++){
                            node = node.getSon(vectorNumeros[i]);
                        }
                        
                        salida = node.Element;
                    }
                }
            }
	}else{
            System.out.println("ERROR en getElement, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
     /**
     * Descripcion: Obtener el elemento padre de un hijo
     *
     * @param	rutaHijo  Ruta en formato "#H#H#H o Raiz ejm:  1H3H2H  o R para referirse al elemento de la raiz"
     * @param   ERROR Valor de salida en caso de algun error
     * @return	valor del Elemnto de ese nodo o ERROR o null si no tiene padre porque es raiz
     */
    public String getPadre (String rutaHijo, String ERROR){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=ERROR;
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            //comprobar que exista la rutaHijo
            if(Cad.isNulloVacia(rutaHijo)==false){
                //comprobar si la ruta se refiere a la raiz o a algun hijo//
                if(Cad.Equals(rutaHijo,"R",false)){
                    //Entonces no tiene padre
                    salida=null;
                }else{
                    //Si es el primer hijo, entonces se refiere a la raiz
                    if(rutaHijo.length()-2 == 0){
                        salida=getElement("R", ERROR);
                    }else{
                        //Entonces a la ruta del hijo eliminarle el ultimo indicador para llegar al padre
                        String pathPadre=Cad.subCadPosAPosB(rutaHijo,0,rutaHijo.length()-2);
                    
                        salida = getElement(pathPadre,ERROR);
                    }
                }
            }
	}else{
            System.out.println("ERROR en getPadre, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener la ruta del elemento padre de un hijo
     *
     * @param	rutaHijo  Ruta en formato "#H#H#H o Raiz ejm:  1H3H2H  o R para referirse al elemento de la raiz"
     * @param   ERROR Valor de salida en caso de algun error
     * @return	valor del Elemnto de ese nodo o ERROR o null si no tiene padre porque es raiz
     */
    public String getPadreRuta (String rutaHijo, String ERROR){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=ERROR;
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            //comprobar que exista la rutaHijo
            if(Cad.isNulloVacia(rutaHijo)==false){
                //comprobar si la ruta se refiere a la raiz o a algun hijo//
                if(Cad.Equals(rutaHijo,"R",false)){
                    //Entonces no tiene padre
                    salida=null;
                }else{
                    //Si es el primer hijo, entonces se refiere a la raiz
                    if(rutaHijo.length()-2 == 0){
                        salida="R";
                    }else{
                        //Entonces a la ruta del hijo eliminarle el ultimo indicador para llegar al padre
                        String pathPadre=Cad.subCadPosAPosB(rutaHijo,0,rutaHijo.length()-2);
                    
                        salida = pathPadre;
                    }
                }
            }
	}else{
            System.out.println("ERROR en getPadreRuta, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener un Nodo completo del Arbol
     *
     * @param	ruta Ruta en formato "#H#H#H o Raiz ejm:  1H3H2H  o R para referirse al elemento de la raiz"
     * @param   Clon si se quiere un objeto clon, o el original
     * @return	null o Nodo valido
     */
    public Nodo getNodo (String ruta, boolean Clon){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        Nodo salida=null;
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            if(Cad.isNulloVacia(ruta)==false){
                if(nodoExist(ruta)){
                    //Ver si piden el nodo Raiz o alguno de sus Hijos//
                    if(ruta.equalsIgnoreCase("R")){
                        salida = raiz;
                    }else{
                        //Convertir la ruta a vector de Numeros//
                        String[] vectorStrings = Cad.aVector(ruta,"H");
                        int[] vectorNumeros = Dimention.convertVectorStringToVectorInt(vectorStrings);
                        
                        Nodo node = raiz.getSon(vectorNumeros[0]);
                        for(int i=1 ;i<vectorNumeros.length; i++){
                            node = node.getSon(vectorNumeros[i]);
                        }
                        
                        salida = node;
                    }
                }
            }
            
            if(Clon==true){
                salida = salida.Clone();
            }
	}else{
            System.out.println("ERROR en getNodo, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Comprobar si un nodo existe
     *
     * @param	ruta Ruta en formato "#H#H#H o Raiz ejm:  1H3H2H  o R para referirse al elemento de la raiz"
     * @return	valor del Elemnto de ese nodo o ERROR
     */
    public boolean nodoExist (String ruta){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(ruta)){
        condiciones=false;
        motivo="ruta null o vacia";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Verificar si se busca una ruta o el elemento raiz//
                if(Cad.Equals(ruta,"R",true)){
                    if(raiz.Element!=null){
                        salida = true;
                    }else{
                        salida = false;
                    }
                }else{
                    //Buscar el elemento de la ruta
                    //convertir la ruta en forma vectorial de enteros//
                    String[] vectorStrings = Cad.aVector(ruta,"H");
                    int[] vectorNumeros = Dimention.convertVectorStringToVectorInt(vectorStrings);
                    //Dimention.ImprimirVector(vectorNumeros, ",");

                    Nodo[] HijosTemp = null;
                    if(raiz.Hijos != null){
                        HijosTemp = raiz.Hijos.clone();
                    }
                    
                    for(int i=0; i<vectorNumeros.length; i++){
                        if(HijosTemp!=null){
                            if((HijosTemp.length>=vectorNumeros[i])&&(vectorNumeros[i]-1>=0)){
                                if(HijosTemp[vectorNumeros[i]-1].Element!=null){
                                    salida=true;
                                    HijosTemp = HijosTemp[vectorNumeros[i]-1].Hijos;
                                }else{
                                    salida=false;
                                    i=vectorNumeros.length+1;
                                }
                            }else{
                                salida=false;
                                i=vectorNumeros.length+1;
                            }
                        }else{
                            //Entonces no tiene Hijos
                            salida=false;
                            i=vectorNumeros.length+1;
                        }
                    }
                }
	}else{
            System.out.println("ERROR en nodoExist, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Comprobar si un elemento es padre, o abuelo de otro nodo
     *
     * @param	node_OLD Element(No path)Nodo a ver si es un ancentro del nodo joven
     * @param   node_Young Element(No path) Nodo joven posible hijo o nieto
     * @return	True si es ancestro false si no lo es
     */
    public boolean isAncestro (String node_OLD, String node_Young){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
    //Comprobar Condiciones Iniciales//
    String pathOLD = getRuta(node_OLD);
    if(Cad.isNulloVacia(pathOLD)){
        condiciones=false;
        motivo="No existe el Node old:"+node_OLD;
    }
    String pathYoung = getRuta(node_Young);
    if(Cad.isNulloVacia(pathYoung)){
        condiciones=false;
        motivo="No existe el NodeYoung:"+node_Young;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Comprobar condiciones conocidas
            
            //Si el path OLD es la raiz entonces es true siempre
            if(Cad.Equals(pathOLD,"R",false)){
                salida=true;
            }else{
                //Si es el mismo path del elemento entonces sacar false
                if(Cad.Equals(pathYoung, pathOLD,false)){
                    salida=false;
                }else{
                    //Comprobar el resto de casos genericos
                    //Comprobar si la ruta del padre esta contenida en la del hijo
                    String temp = Cad.subCadPosAPosB(pathYoung,0,pathOLD.length());

                    if(Cad.Equals(temp,pathOLD,false)){
                        salida=true;
                    }
                }
            }
	}else{
            System.out.println("ERROR en isAncestro, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Comprobar si un elemento es padre, o abuelo de otro nodo
     *
     * @param	pathOLD  path Nodo a ver si es un ancentro del nodo joven
     * @param   pathYoung  path Nodo joven posible hijo o nieto
     * @return	True si es ancestro false si no lo es
     */
    public boolean isAncestro_byPaths (String pathOLD, String pathYoung){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida=false;
    //Comprobar Condiciones Iniciales//
    if(nodoExist(pathOLD)==false){
        condiciones=false;
        motivo="No existe el Node old:"+pathOLD;
    }
    if(nodoExist(pathYoung)==false){
        condiciones=false;
        motivo="No existe el NodeYoung:"+pathYoung;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Comprobar condiciones conocidas
            
            //Si el path OLD es la raiz entonces es true siempre
            if(Cad.Equals(pathOLD,"R",false)){
                salida=true;
            }else{
                //Si es el mismo path del elemento entonces sacar false
                if(Cad.Equals(pathYoung, pathOLD,false)){
                    salida=false;
                }else{
                    //Comprobar el resto de casos genericos
                    //Comprobar si la ruta del padre esta contenida en la del hijo
                    String temp = Cad.subCadPosAPosB(pathYoung,0,pathOLD.length());

                    if(Cad.Equals(temp,pathOLD,false)){
                        salida=true;
                    }
                }
            }
	}else{
            System.out.println("ERROR en isAncestro_byPaths, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
    /**
     * Descripcion: Imprimir en consola el arbol completo
     *
     */
    public void showTree(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(raiz==null){
        condiciones=false;
        motivo="Arbol null";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            System.out.println("Arbol Id:"+IdArbol);
            
            //Llamar a la funcion recursiva desde el nodo raiz//
            printNodo(raiz,0);
        }else{
            System.out.println("ERROR en showTree, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso showTree Terminado con EXITO");
    	}else{
            System.out.println("Proceso showTree Terminado con FALLO");
    	}
    }
    
    
    
    /**
     * Descripcion: Funcion recursiva de utileria para Imprimir todos los Hijos del Arbol
     *
     * @param   nodo Nodo a imprimir sus Hijos en consola
     * @param   profundidad parametro pasa saber cuantos ─ agregar
     */
    private void printNodo(Nodo nodo, int profundidad){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Imprimri el Elemento de este nodo con su respectiva profundidad
            if(profundidad>0){
                if(profundidad==1){
                    System.out.println("└──"+nodo.Element);
                }else{
                    String linea = "└──";
                    for(int i=1; i<profundidad; i++){
                        linea="   "+linea;
                    }
                    
                    //Agregar las lineas verticales anteriores//
                    for(int i=linea.length()-3; i>0; i=i-3){
                        linea = Cad.remplazarPOS(linea, "│", i-3);
                    }
                    
                    System.out.println(linea+nodo.Element);
                }
            }else{
                System.out.println(nodo.Element);
            }
            
            
            //Comprobar si este nodo tiene mas hijos
            //Si es asi aplicar recursividad para cada uno de sis hijos//
            if(nodo.numberSon()>0){
                for(int i=0; i<nodo.numberSon(); i++){
                    printNodo(nodo.Hijos[i],profundidad+1);  
                }
            }
        }else{
            System.out.println("ERROR en printNodo, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso printNodo Terminado con EXITO");
        }else{
            System.out.println("Proceso printNodo Terminado con FALLO");
    	}
    }
    
    
    
     /**
     * Descripcion: Agregar un nuevo Hijo a un nodo
     *
     * @param	rutaNodo ruta del nodo al cual agregar un hijo por la derecha
     * @param   Elemento Elemento a agregar en el nuevo nodo a crear
     * @return	true se pudo     false no se pudo
     */
    public boolean addSon(String rutaNodo, String Elemento){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida = false;
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(rutaNodo)){
        condiciones=false;
        motivo="rutaNodo null o vacia";
    }
    if(nodoExist(rutaNodo)==false){
        condiciones=false;
        motivo="la ruta:"+rutaNodo+" hace referencia a un nodo que no existe";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Verificar si se busca una ruta o el elemento raiz//
                if(Cad.Equals(rutaNodo,"R",true)){
                    //Entonces trabajar con el elemento raiz//
                    raiz.addSonRigth(Elemento);
                }else{
                    //convertir la ruta en forma vectorial de enteros//
                    String[] vectorStrings = Cad.aVector(rutaNodo,"H");
                    int[] vectorNumeros = Dimention.convertVectorStringToVectorInt(vectorStrings);
                    //Dimention.ImprimirVector(vectorNumeros, ",");

                    //Empezar a buscar el nodo de la ruta
                    Nodo[] HijosTemp = raiz.Hijos;
                    for(int i=0; i<vectorNumeros.length; i++){
                        //Si es el ultimo elemento omitirlo simplemente
                        if(i>=vectorNumeros.length-1){
                            //omitir
                        }else{
                            HijosTemp = HijosTemp[vectorNumeros[i]-1].Hijos;
                        }
                    }
                    
                    //Agregar el nuevo Hijo en el ultimo nodo indicado en el vector//
                    HijosTemp[vectorNumeros[vectorNumeros.length-1]-1].addSonRigth(Elemento);
                }
	}else{
            System.out.println("ERROR en addSon, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Agregar un nuevo Hijo a un nodo
     *
     * @param	rutaNodo ruta del nodo al cual agregar un hijo por la derecha
     * @param   Elemento Elemento a agregar en el nuevo nodo a crear
     * @return	true se pudo     false no se pudo
     */
    public boolean addSon(String rutaNodo, Nodo Elemento){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida = false;
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(rutaNodo)){
        condiciones=false;
        motivo="rutaNodo null o vacia";
    }
    if(nodoExist(rutaNodo)==false){
        condiciones=false;
        motivo="la ruta:"+rutaNodo+" hace referencia a un nodo que no existe";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Verificar si se busca una ruta o el elemento raiz//
                if(Cad.Equals(rutaNodo,"R",true)){
                    //Entonces trabajar con el elemento raiz//
                    raiz.addSonRigth(Elemento);
                }else{
                    //convertir la ruta en forma vectorial de enteros//
                    String[] vectorStrings = Cad.aVector(rutaNodo,"H");
                    int[] vectorNumeros = Dimention.convertVectorStringToVectorInt(vectorStrings);
                    //Dimention.ImprimirVector(vectorNumeros, ",");

                    //Empezar a buscar el nodo de la ruta
                    Nodo[] HijosTemp = raiz.Hijos;
                    for(int i=0; i<vectorNumeros.length; i++){
                        //Si es el ultimo elemento omitirlo simplemente
                        if(i>=vectorNumeros.length-1){
                            //omitir
                        }else{
                            HijosTemp = HijosTemp[vectorNumeros[i]-1].Hijos;
                        }
                    }
                    
                    //Agregar el nuevo Hijo en el ultimo nodo indicado en el vector//
                    HijosTemp[vectorNumeros[vectorNumeros.length-1]-1].addSonRigth(Elemento);
                }
	}else{
            System.out.println("ERROR en addSon, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Cambiar el valor del Elemento de un Nodo
     *
     * @param	rutaNodo ruta del nodo el cual modificar
     * @param   newElemento nuevo Elemento
     * @return	true se pudo     false no se pudo
     */
    public boolean remplazeNode(String rutaNodo, String newElemento){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        boolean salida = false;
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(rutaNodo)){
        condiciones=false;
        motivo="rutaNodo null o vacia";
    }
    if(nodoExist(rutaNodo)==false){
        condiciones=false;
        motivo="la ruta:"+rutaNodo+" hace referencia a un nodo que no existe";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Verificar si se busca una ruta o el elemento raiz//
                if(Cad.Equals(rutaNodo,"R",true)){
                    //Entonces trabajar con el elemento raiz//
                    raiz.Element = newElemento;
                }else{
                    //convertir la ruta en forma vectorial de enteros//
                    String[] vectorStrings = Cad.aVector(rutaNodo,"H");
                    int[] vectorNumeros = Dimention.convertVectorStringToVectorInt(vectorStrings);
                    //Dimention.ImprimirVector(vectorNumeros, ",");

                    //Empezar a buscar el nodo de la ruta
                    Nodo[] HijosTemp = raiz.Hijos;
                    for(int i=0; i<vectorNumeros.length-1; i++){
                        HijosTemp = HijosTemp[vectorNumeros[i]-1].Hijos;
                    }
                    
                    //Cambiar el Elemento del ultimo nodo//
                    HijosTemp[vectorNumeros[vectorNumeros.length-1]-1].Element = newElemento;
                }
	}else{
            System.out.println("ERROR en addSon, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Eliminar un Nodo y toda su decendencia
     *
     * @param	rutaNodo ruta del nodo a Eliminar
     */
    public void deleteNodo(String rutaNodo){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(rutaNodo)){
        condiciones=false;
        motivo="rutaNodo null o vacia";
    }
    if(nodoExist(rutaNodo)==false){
        condiciones=false;
        motivo="la ruta:"+rutaNodo+" hace referencia a un nodo que no existe";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Verificar si se busca una ruta o el elemento raiz//
                if(Cad.Equals(rutaNodo,"R",true)){
                    //Entonces Eliminar todo el Arbol//
                    raiz = null;
                }else{
                    //convertir la ruta en forma vectorial de enteros//
                    String[] vectorStrings = Cad.aVector(rutaNodo,"H");
                    int[] vectorNumeros = Dimention.convertVectorStringToVectorInt(vectorStrings);
                    //Dimention.ImprimirVector(vectorNumeros, ",");

                    
                    //Eliminar el Hijo Indicado//
                    if(vectorNumeros.length==1){
                        raiz.deleteSon(vectorNumeros[0]);
                    }else{
                        //Empezar a buscar el nodo de la ruta
                        Nodo[] HijosTemp = raiz.Hijos;
                        for(int i=0; i<vectorNumeros.length-2; i++){
                            HijosTemp = HijosTemp[vectorNumeros[i]-1].Hijos;
                        }
                        
                        //Eliminar al Hijo indicado//
                        int posPadre = vectorNumeros[vectorNumeros.length-2];
                        int posHijoKill = vectorNumeros[vectorNumeros.length-1];
                        HijosTemp[posPadre-1].deleteSon(posHijoKill);
                    }
                }
	}else{
            System.out.println("ERROR en deleteNodo, motivo: "+motivo);
	}
    //Terminar Proceso//
        if(condiciones==true){
            System.out.println("Proceso deleteNodo Terminado con EXITO");
    	}else{
            System.out.println("Proceso deleteNodo Terminado con FALLO");
    	}
    }
    
    
    String rutaFinal=null;
    /**
     * Descripcion: Buscar la Ruta del nodo de algun Elemento
     *
     * @param	Element Elemento a buscar en el Arbol
     * @return	null en caso de no encontrarse o String con ruta Valida
     */
    public String getRuta(String Element){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(Element)){
        condiciones=false;
        motivo="Elemento null o vacio";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            if(Element.equals(raiz.Element)){
                rutaFinal="R";
            }else{
                //String recorrido = "RH"; Incialmente se usaba una nomenglatura de ruta donde siempre esta la RH
                                         //Pero se opto por usar una en la que solo esten los numeros con H
                String recorrido="";
                for(int i =1; i<=raiz.numberSon(); i++){
                    String recorridoTemp = recorrido+i+"H";
                    getRutaRecursive(recorridoTemp, raiz.getSon(i), Element);
                }
            }
            salida=rutaFinal;
            rutaFinal=null;
	}else{
            System.out.println("ERROR en getRuta, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Buscar la Ruta del nodo de algun Elemento Parecido
     *
     * @param	Element Elemento a buscar en el Arbol
     * @param   caracterVariacion CaracterdeVariacion señalador
     * @return	null en caso de no encontrarse o String con ruta Valida
     */
    public String getRutaElementLike(String Element, String caracterVariacion){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(Element)){
        condiciones=false;
        motivo="Elemento null o vacio";
    }
    if(Cad.isNulloVacia(caracterVariacion)){
        condiciones=false;
        motivo="charVaration null o vacio";
    }
    if(raiz==null){
        condiciones=false;
        motivo="Raiz de Arbol null";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            if(Cad.LikeA(raiz.Element, Element, caracterVariacion)){
                rutaFinal="R";
            }else{
                //String recorrido = "RH"; Incialmente se usaba una nomenglatura de ruta donde siempre esta la RH
                                         //Pero se opto por usar una en la que solo esten los numeros con H
                String recorrido="";
                for(int i =1; i<=raiz.numberSon(); i++){
                    String recorridoTemp = recorrido+i+"H";
                    getRutaRecursiveLike(recorridoTemp, raiz.getSon(i), Element, caracterVariacion);
                }
            }
            salida=rutaFinal;
            rutaFinal=null;
	}else{
            System.out.println("ERROR en getRutaElementLike, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
    /**
     * Descripcion: Funcion de apoyo recursiva para la funcion getRuta()
     *
     * @param	recorrido Recorrido que se va llevando hasta llegar al nodo objetivo
     * @param   node Nodo actual a evaluar en la recursion
     * @param   Elemento Elemento que se esta buscando
     */
    private void getRutaRecursive(String recorrido,Nodo node, String Elemento){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            if((node.Element.equals(Elemento))&&(rutaFinal==null)){
                rutaFinal=recorrido;
            }else{
                String recorridoX = recorrido;
                for(int i = 1; i<=node.numberSon(); i++){
                    String recorridoTemp = recorridoX+i+"H";
                    getRutaRecursive(recorridoTemp, node.getSon(i), Elemento);
                }
            }
        }else{
            System.out.println("ERROR en getRutaRecursive, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso getRutaRecursive Terminado con EXITO");
    	}else{
            System.out.println("Proceso getRutaRecursive Terminado con FALLO");
    	}
    }
    
    
    /**
     * Descripcion: Funcion de apoyo recursiva para la funcion getRutaElementLike()
     *
     * @param	recorrido Recorrido que se va llevando hasta llegar al nodo objetivo
     * @param   node Nodo actual a evaluar en la recursion
     * @param   Elemento Elemento que se esta buscando
     */
    private void getRutaRecursiveLike(String recorrido,Nodo node, String Elemento, String caracterVariacion){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            if((Cad.LikeA(node.Element,Elemento,caracterVariacion))&&(rutaFinal==null)){
                rutaFinal=recorrido;
            }else{
                String recorridoX = recorrido;
                for(int i = 1; i<=node.numberSon(); i++){
                    String recorridoTemp = recorridoX+i+"H";
                    getRutaRecursiveLike(recorridoTemp, node.getSon(i), Elemento, caracterVariacion);
                }
            }
        }else{
            System.out.println("ERROR en getRutaRecursive, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso getRutaRecursive Terminado con EXITO");
    	}else{
            System.out.println("Proceso getRutaRecursive Terminado con FALLO");
    	}
    }
    
    
    
    /**
     * Descripcion: Pequeño menu de instrucciones para el uso de esta clase
     *
     */
    public static void Instrucciones(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Variables de uso//
            TreeString arbol2 = new TreeString("X");
            arbol2.addSon("R", "A");
            arbol2.addSon("R", "C");
            arbol2.addSon("R", "D");
            arbol2.addSon("1H", "E");
            arbol2.addSon("1H1H", "M");
            arbol2.addSon("1H1H", "P");
            arbol2.addSon("2H", "F");
            arbol2.addSon("2H", "O");
            arbol2.addSon("2H1H", "Z");
            arbol2.addSon("2H", "G");
            arbol2.addSon("2H2H", "Y");
            
            //MEnu//
            System.out.println("*********** TreeString ************");
            System.out.println("Nomenglatura de rutas");
            System.out.println("  Para la Raiz:R");
            System.out.println("  Para los Hijos:1H2H1H .... etc");
            System.out.println("Por ejemplo, para el siguiente Arbol");
                arbol2.showTree();
            System.out.println("La ruta de E:"+arbol2.getRuta("E"));
            System.out.println("La ruta de P:"+arbol2.getRuta("P"));
            System.out.println("La ruta de Y:"+arbol2.getRuta("Y"));
            System.out.println("***********************************");
        }else{
            System.out.println("ERROR en Instrucciones, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso Instrucciones Terminado con EXITO");
    	}else{
            System.out.println("Proceso Instrucciones Terminado con FALLO");
    	}
    }
    
    
    
    /**
     * Descripcion: Construir un arbol, con una estructura de arbol de un archivo de Texto
     *
     * @param	lineRaiz Linea que va a ser la raiz del arbol
     * @param   lineFin Linea de Fin del Arbol
     * @param   separador Separador que hace distinguir los hijos entre los nodos
     * @param   nombreYruta Nombre y Ruta del Archivo a Trabajar
     */
    public void createTreeFromFileTxt(int lineRaiz,int lineFin,String separador, String nombreYruta){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    Archivos.Text arch;
    //Comprobar Condiciones Iniciales//
    if(Text.FileExist(nombreYruta)==false){
        condiciones=false;
        motivo="Archivo no Existe";
    }else{
        //comprobar que exista la posicion de Inicio y Fin del Arbol
        arch = new Text(nombreYruta);
        
        String temp = arch.LeerLineaN(lineRaiz);
        if(Cad.isNulloVacia(temp)){
            condiciones=false;
            motivo="Linea de la Raiz esta Vacia o no Existe";
        }
        temp = arch.LeerLineaN(lineFin);
        if(Cad.isNulloVacia(temp)){
            condiciones=false;
            motivo="Linea de Fin esta Vacia o no Existe";
        }
    }
    if(Cad.isNulloVacia(separador)){
        condiciones=false;
        motivo="Separador Null o Vacio";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Crear el Archivo//
            arch = new Text(nombreYruta);
            //Crear el nuevo arbol
            String raizElemen = arch.LeerLineaN(lineRaiz);
                raizElemen=Cad.EliminarSubcadALL(raizElemen, separador);
                
            TreeString arbol = new TreeString(raizElemen);
            String linea=null;
                for(int i=lineRaiz+1; i<=lineFin; i++){
                    linea = arch.LeerLineaN(i);
                    String lineElement = Cad.EliminarSubcadALL(linea, separador);

                    String padre = getPadre(nombreYruta, i, lineRaiz, separador);
                        String padreElement = Cad.EliminarSubcadALL(padre,separador);
                        
                    String ruta = arbol.getRuta(padreElement);
                    arbol.addSon(ruta, lineElement);
                }
            raiz = arbol.raiz;
        }else{
            System.out.println("ERROR en createTreeFromFileTxt, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso createTreeFromFileTxt Terminado con EXITO");
    	}else{
            System.out.println("Proceso createTreeFromFileTxt Terminado con FALLO");
    	}
    }
    
    
    
     /**
     * Descripcion: Obtener el 
     *
     * @param	nombreYrutaArch Archivo de Texto en el cual buscar al padre del nodo
     * @param   lineaNodo Linea del archivo de texto donde esta el nodo a buscarle el padre
     * @param   lineaRaiz Linea donde se encuentra la Raiz del Arbol
     * @param   SeparadorNodos Separador entre los nodos de cada linea
     * @return	null si no tiene padre o es la raiz, en otro caso un elemento valido
     */
    private String getPadre (String nombreYrutaArch, int lineaNodo, int lineaRaiz, String SeparadorNodos){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
    if(Text.FileExist(nombreYrutaArch)==false){
        condiciones=false;
        motivo="El archivo no existe";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            Archivos.Text arch = new Text(nombreYrutaArch);
            String linea="";
            //Primero obtener quien es la raiz y cuanto esta desplazado en el archivo//
                linea = arch.LeerLineaN(lineaRaiz);
                int desplazamiento = Cad.numOfContains(linea, SeparadorNodos, true);
            
            
            boolean encontrado=false;
            String padre=null;
            int contador = lineaNodo-1;
            linea = arch.LeerLineaN(lineaNodo);
                int nodoDesplaz = Cad.numOfContains(linea, SeparadorNodos, true);
            while((encontrado==false)&&(padre==null)&&(contador>=lineaRaiz)){
                linea = arch.LeerLineaN(contador);
                    contador=contador-1;
                int lineaDezplaz = Cad.numOfContains(linea, SeparadorNodos, true);
                
                if(lineaDezplaz==nodoDesplaz-1){
                    padre = linea;
                }
            }
            
            salida = padre;
	}else{
            System.out.println("ERROR en getPadre, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Imprimir el Arbol en un archivo de Text en una posicion especifica
     *
     * @param nombreYruta Archivo en el cual meter el Arbol
     * @param lineaRaiz linea en el archivo donde inicia el arbol
     * @param separador Caracter que se usa de separador entre linea
     * @param desplazamiento desplazamiento del arbol en el archivo
     */
    public void printTreeFileTxt(String nombreYruta, int lineaRaiz, String separador, int desplazamiento){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(Archivos.Text.FileExist(nombreYruta)==false){
        condiciones=false;
        motivo="El archivo no existe";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Llamar a la funcion recursiva desde el nodo raiz//
            printNodoFile(raiz,0,nombreYruta,lineaRaiz,separador,desplazamiento);
        }else{
            System.out.println("ERROR en printTreeFile, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso printTreeFile Terminado con EXITO");
    	}else{
            System.out.println("Proceso printTreeFile Terminado con FALLO");
    	}
    }
    
    
    /**
     * Descripcion: Funcion recursiva de utileria para Imprimir arbol en archivo de Texto
     *
     * @param   nodo Nodo a imprimir sus Hijos en consola
     * @param   profundidad parametro pasa saber cuantos ─ agregar
     * @param   archivo Archivo en el que se trabaja
     * @param   linePos Posicion actual de la linea
     * @param   separador Separador entre lineas
     * @param   desplaz Desplamiento del arbol en el archivo
     */
    private void printNodoFile(Nodo nodo, int profundidad, String archivo, int linePos, String separador, int desplaz){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    Text arch = new Text(archivo);
    //Comprobar Condiciones Iniciales//
    //no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Imprimri el Elemento de este nodo con su respectiva profundidad
            if(profundidad>0){
                if(profundidad==1){
                    String temp = Cad.Repeat(separador,desplaz+1)+nodo.Element;
                    //System.out.println(temp);
                    arch.InsertLineN(linePos,temp);
                }else{
                    String linea = Cad.Repeat(separador, desplaz+1);
                    for(int i=1; i<profundidad; i++){
                        linea=separador+linea;
                    }
                    
                    String temp = linea+nodo.Element;
                    //System.out.println(temp);
                    arch.InsertLineN(linePos, temp);
                }
            }else{
                String temp = Cad.Repeat(separador, desplaz)+nodo.Element;
                //System.out.println(temp);
                arch.InsertLineN(linePos, temp);
            }
            
            
            //Comprobar si este nodo tiene mas hijos
            //Si es asi aplicar recursividad para cada uno de sis hijos//
            if(nodo.numberSon()>0){
                for(int i=0; i<nodo.numberSon(); i++){
                    printNodoFile(nodo.Hijos[i],profundidad+1,archivo,linePos+1,separador,desplaz);  
                }
            }
        }else{
            System.out.println("ERROR en printNodoFile, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso printNodoFile Terminado con EXITO");
        }else{
            System.out.println("Proceso printNodoFile Terminado con FALLO");
    	}
    }
    
    
    
    
    VectorString vecStringHojas;
    /**
     * Descripcion: Obtener todos los Nodos Hoja en un Vector de Strings
     *
     * @return	null o Vector con Elementos
     */
    public VectorString getHojasAll(){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        VectorString salida=null;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Usar una variable global para todos
                vecStringHojas = new VectorString(0);
            
            //Llamar a la funcion Recursiva
                addHojaVecString(raiz);
            
            //Terminar de usar la variable global
                salida = vecStringHojas;
                vecStringHojas = null;
	}else{
            System.out.println("ERROR en getHojasAll, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Funcion recursiva de utileria para getHojasAll
     *
     * @param   nodo Nodo a trabajar sus Hijos
     */
    private void addHojaVecString(Nodo nodo){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            if(Cad.isNulloVacia(nodo.Element)==false){
                //Comprobar si este nodo Es una Hoja o Un padre//
                if(nodo.numberSon()>0){
                    //Entonces es padre y solo hay que llamar recursividad con sus hijos
                    for(int i=1; i<=nodo.numberSon(); i++){
                        addHojaVecString(nodo.getSon(i));
                    }
                }else{
                    //Entonces es hoja y hay que mandarlo al VectorStrings
                    vecStringHojas.addVauleRigth(nodo.Element);
                }
            }
        }else{
            System.out.println("ERROR en addHojaVecString, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso addHojaVecString Terminado con EXITO");
        }else{
            System.out.println("Proceso addHojaVecString Terminado con FALLO");
    	}
    }
    
    
    
    
    
    
    
    VectorString vecStringRamas;
    /**
     * Descripcion: Obtener todos las ramas en un vector de string, ojo solo ramas no hojas
     *
     * @return	null o Vector con Elementos
     */
    public VectorString getRamasAll(){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        VectorString salida=null;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Usar una variable global para todos
                vecStringRamas = new VectorString(0);
            
            //Llamar a la funcion Recursiva
                addRamaVecString(raiz);
            
            //Terminar de usar la variable global
                salida = vecStringRamas;
                vecStringRamas = null;
	}else{
            System.out.println("ERROR en getRamasAll, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    /**
     * Descripcion: Funcion recursiva de utileria para getRamasAll
     *
     * @param   nodo Nodo a trabajar
     */
    private void addRamaVecString(Nodo nodo){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            if(Cad.isNulloVacia(nodo.Element)==false){
                //Comprobar si este nodo Es una Hoja o Un padre//
                if(nodo.numberSon()>0){
                    //Entonces es padre y hay que llamar recursividad con sus hijos
                    for(int i=1; i<=nodo.numberSon(); i++){
                        addRamaVecString(nodo.getSon(i));
                    }
                    
                    //Y ademas enviar este nodo a la coleccion
                    vecStringRamas.addVauleRigth(nodo.Element);
                }else{
                    //Entonces es hoja y solo lo ignoramos
                }
            }
        }else{
            System.out.println("ERROR en addRamaVecString, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso addRamaVecString Terminado con EXITO");
        }else{
            System.out.println("Proceso addRamaVecString Terminado con FALLO");
    	}
    }
    
    
    
    
    
    
    
     /**
     * Descripcion: Convertir el Arbol a la clase DefaultMutableTreeNode
     *
     * @return	Arbol en clase DefaultMutableTreeNode
     */
    public DefaultMutableTreeNode getDefaultMutableTreeNode (){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        DefaultMutableTreeNode salida = null;
    //Comprobar Condiciones Iniciales//
            //no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Crear la raiz del Arbol Llamar a la funcion recursiva para que los hijos, sean agregados//
            DefaultMutableTreeNode arbolMutable = new DefaultMutableTreeNode(raiz.Element);
                
                for(int i=1; i<=raiz.numberSon(); i++){
                    getDefaultMutableTreeNodeRecursiveAdd(raiz.getSon(i), arbolMutable);
                }
            
            //Guardar valor de Salida y limpiar la variable Global
            salida=arbolMutable;
	}else{
            System.out.println("ERROR en getDefaultMutableTreeNode, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Agregacion recursiva de los nodos para la funcion, getDefaultMutableTreeeNode
     *
     * @param	nodo Nodo a agregar juntamente con sus hijos
     */
    private void getDefaultMutableTreeNodeRecursiveAdd(Nodo nodoTreeString, DefaultMutableTreeNode nodoMutable){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Agregar el nodo tipo TreeString//
            DefaultMutableTreeNode nuevoNodo = new DefaultMutableTreeNode(nodoTreeString.Element);
            nodoMutable.add(nuevoNodo);
            
            //Llamar a sus hijos para que sean agreegados a este nodo//
            for(int i=1; i<=nodoTreeString.numberSon(); i++){
                getDefaultMutableTreeNodeRecursiveAdd(nodoTreeString.getSon(i), nuevoNodo);
            }
            
        }else{
            System.out.println("ERROR en getDefaultMutableTreeNodeRecursiveAdd, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso getDefaultMutableTreeNodeRecursiveAdd Terminado con EXITO");
    	}else{
            System.out.println("Proceso getDefaultMutableTreeNodeRecursiveAdd Terminado con FALLO");
    	}
    }
    
    
    
     /**
     * Descripcion: Obtener un elemento de un Nodo de la clase de JTree por defecto de Java de manera Recursiva
     *
     * @param	Raiz Elemento Raiz del Arbol
     * @param   Element Elemento a buscar recursivamente en el Arbol
     * @return	Error null o Valor encontrado
     */
    public static TreePath getElementFromJTree (DefaultMutableTreeNode Raiz, String Element){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        TreePath salida=null;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            @SuppressWarnings("unchecked") Enumeration e = Raiz.depthFirstEnumeration(); 
            while (e.hasMoreElements()) { 
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement(); 
                if (Cad.Equals(node.toString(), Element, false)){ 
                    return new TreePath(node.getPath()); 
                } 
            }  
	}else{
            System.out.println("ERROR en getElementFromJTree, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    
     /**
     * Descripcion: Obtener un elemento Parecido  un Nodo de la clase de JTree por defecto de Java de manera Recursiva
     *
     * @param	Raiz Elemento Raiz del Arbol
     * @param   Element Elemento Parecido a buscar recursivamente en el Arbol
     * @param   varChar Caracter de variacion
     * @return	Error null o Valor encontrado
     */
    public static TreePath getElementLikeFromJTree (DefaultMutableTreeNode Raiz, String Element, String varChar){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        TreePath salida=null;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            @SuppressWarnings("unchecked") Enumeration e = Raiz.depthFirstEnumeration(); 
            while (e.hasMoreElements()) { 
                DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement(); 
                
                if (Cad.LikeA(node.toString(), Element, varChar)){ 
                    return new TreePath(node.getPath()); 
                }
            }  
	}else{
            System.out.println("ERROR en getElementLikeFromJTree, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtener la Raiz de un Arbol de Java en DefaultMutableTreeNode
     *
     * @param	Arbol Arbol a obtener su Nodo Raiz
     * @return	null o Valor Valido
     */
    public static DefaultMutableTreeNode convertJtree2DefaultMutableTreeNode (JTree Arbol){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        DefaultMutableTreeNode salida=null;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            salida=(DefaultMutableTreeNode) Arbol.getPathForRow(1).getPathComponent(0);
	}else{
            System.out.println("ERROR en getRaizfromJTree, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Expandir la ruta del Elemento en el Arbol
     *
     * @param	Arbol Arbol donde se encuentra el elemento
     * @param   Element Elemento a expandir
     */
    public static void expandirElement(JTree Arbol, TreePath Element){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            //Arbol.expandPath(Element);
            Arbol.scrollPathToVisible(Element);
            Arbol.setSelectionPath(Element);
        }else{
            System.out.println("ERROR en expandirElement, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso expandirElement Terminado con EXITO");
    	}else{
            System.out.println("Proceso expandirElement Terminado con FALLO");
    	}
    }
    
    
    
     /**
     * Descripcion: Obtener el Elemento Seleccionado de un Arbol
     *
     * @param	arbol Arbol a obtener elemento
     * @return	null error otro caso Valor ""
     */
    public static String getSelectedElement (JTree arbol){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        String salida=null;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
             DefaultMutableTreeNode selectedNode =(DefaultMutableTreeNode) arbol.getSelectionPath().getLastPathComponent();
             salida = selectedNode.getUserObject().toString();
	}else{
            System.out.println("ERROR en getSelectedElement, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    private TreeString ArbolClone;
     /**
     * Descripcion: Clonar Este Arbol de Strings, crear una copia
     *
     * @return null o TreeString valido
     */
    public TreeString Clone(){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        TreeString salida=null;
    //Comprobar Condiciones Iniciales//
    if(raiz == null){
        condiciones = false;
        motivo ="Raiz del Arbol null";
    }else{
        if(raiz.Element == null){
            condiciones = false;
            motivo="Elemento de la raiz null";
        }
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //crear el primer nodo y meter este elemento
            ArbolClone = new TreeString(IdArbol,raiz.Element);
            
            //Comprobar si tiene hijos para llamar la funcion recursiva con sus hijos//
            for(int i=1; i<=raiz.numberSon(); i++){
                CloneRecursive(raiz.getSon(i), "R");
            }
            salida = ArbolClone;
	}else{
            System.out.println("ERROR en Clone, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Funcion de apoyo recursiva para clonar el Arbol
     *
     * @param nodo Nodo a agregar al Arbol
     * @param rutaPadre Ruta del Nodo padre a este nodo
     * @return	valores de retorno
     */
    private void CloneRecursive(Nodo nodo, String rutaPadre){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(nodo == null){
        condiciones=false;
        motivo = "nodo null";
    }
    if(ArbolClone.nodoExist(rutaPadre)==false){
        condiciones=false;
        motivo="Ruta: "+rutaPadre+" no existe en el ArbolClone";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Meter los valores de este nodo//
            ArbolClone.addSon(rutaPadre,nodo.Element);
            
            //Si tiene hijos llamar a la funcion recursiva//
            for(int i=1; i<=nodo.numberSon(); i++){
                CloneRecursive(nodo.getSon(i), ArbolClone.getRuta(nodo.Element));
            }
	}else{
            System.out.println("ERROR en CloneRecursive, motivo: "+motivo);
	}
    //Terminar Proceso//
        if(condiciones==true){
            //System.out.println("Proceso CloneRecursive Terminado con EXITO");
    	}else{
            System.out.println("Proceso CloneRecursive Terminado con FALLO, motivo: "+motivo);
    	}
    }
    
    
    
    /**
     * Descripcion: Mover un Nodo de una posicion a otra, convirtiendolo en un hijo de la nueva ruta
     *
     * @param	rutaInicial Ruta del Nodo a Mover
     * @param   rutaFinal Ruta del nuevo Padre del Nodo a mover
     */
    public void MoverNodeTo(String rutaInicial, String rutaFinal){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(nodoExist(rutaInicial)==false){
        condiciones=false;
        motivo="No existe la ruta: "+rutaInicial;
    }
    if(nodoExist(rutaFinal)==false){
        condiciones=false;
        motivo="No existe ruta: "+rutaFinal;
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Clonar el Elemento
            Nodo ElementoAmover = getNodo(rutaInicial, true); 
            
            //Agregar este nodo a la ruta indicada
            addSon(rutaFinal, ElementoAmover); 
            
            //Eliminar el nodo que se movio
            deleteNodo(rutaInicial); 
        }else{
            System.out.println("ERROR en MoverNodeTo, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
    		System.out.println("Proceso MoverNodeTo Terminado con EXITO");
    	}else{
    		System.out.println("Proceso MoverNodeTo Terminado con FALLO");
    	}
    }
    
    
    
    
    private int AlturaLineas;
     /**
     * Descripcion: Obtener la altura total del arbol en lineas
     *
     * @return 0 o N
     */
    public int AlturaLineas(){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida = 0;
    //Comprobar Condiciones Iniciales//
    if(raiz == null){
        condiciones = false;
        motivo ="Raiz del Arbol null";
    }else{
        if(raiz.Element == null){
            condiciones = false;
            motivo="Elemento de la raiz null";
        }
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Contar este primer nodo
            AlturaLineas = 1;
            
            //Comprobar si tiene hijos para llamar la funcion recursiva con sus hijos//
            for(int i=1; i<=raiz.numberSon(); i++){
                AlturaLineasRecursive(raiz.getSon(i), "R");
            }
            salida = AlturaLineas;
	}else{
            System.out.println("ERROR en AlturaLineas, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
     /**
     * Descripcion: Funcion de apoyo recursiva para clonar el Arbol
     *
     * @param nodo Nodo a agregar al Arbol
     * @param rutaPadre Ruta del Nodo padre a este nodo
     * @return	valores de retorno
     */
    private void AlturaLineasRecursive(Nodo nodo, String rutaPadre){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(nodo == null){
        condiciones=false;
        motivo = "nodo null";
    }
    if(this.nodoExist(rutaPadre)==false){
        condiciones=false;
        motivo="Ruta: "+rutaPadre+" no existe en el ArbolClone";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Meter los valores de este nodo//
            AlturaLineas =AlturaLineas+1;
            
            //Si tiene hijos llamar a la funcion recursiva//
            for(int i=1; i<=nodo.numberSon(); i++){
                AlturaLineasRecursive(nodo.getSon(i), this.getRuta(nodo.Element));
            }
	}else{
            System.out.println("ERROR en AlturaLineasRecursive, motivo: "+motivo);
	}
    //Terminar Proceso//
        if(condiciones==true){
            //System.out.println("Proceso AlturaLineasRecursive Terminado con EXITO");
    	}else{
            System.out.println("Proceso AlturaLineasRecursive Terminado con FALLO, motivo: "+motivo);
    	}
    }
    
    
    
    
    
     /**
     * Descripcion: Obtener todos los Hijos de un padre en un Vector de Strings
     *
     * @param   rutaPadre para obtener sus hijos
     * @return  coleccion de hijos o null, si no tiene
     */
    public VectorString getHijos(String rutaPadre){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        VectorString salida = null;
    //Comprobar Condiciones Iniciales//
    if(nodoExist(rutaPadre)==false){
        condiciones=false;
        motivo="Ruta: "+rutaPadre+" no existe";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Obtener el nodo Padre
            Nodo temp = getNodo(rutaPadre, false);
            
            salida = new VectorString(temp.numberSon());
            //Para todos sus hijos agregarlos al vector de Strings
            for(int i=1; i<=temp.numberSon(); i++){
                salida.addVauleRigth(temp.getSon(i).Element);
            }
	}else{
            System.out.println("ERROR en getHijos, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
}
