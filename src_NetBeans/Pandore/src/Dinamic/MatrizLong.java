/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dinamic;

import Algoritms.Nums;
import java.io.Serializable;

/**
 *
 * @author Ing Lalux
 */
public class MatrizLong implements Serializable{
    public long matrizRaiz[][];
    public int Alto;
    public int Ancho;
    
    
    /**
     * Descripcion: Constriur la Matriz Dinamica
     *
     * @param	alto  Numero de Filas que tendra la matriz
     * @param   ancho Numero de Columnas que tendra la matriz
     */
    public MatrizLong(int alto, int ancho){
        Alto=alto;
        Ancho=ancho;
        matrizRaiz=new long[Alto][Ancho];
    }
    
    
    /**
     * Descripcion: Inicializar la Matriz con un Valor Especifico
     *
     * @param	ValorEspecifico Valor que tendra Todas las casillas de la Matriz
     */
    public void Inicializar(long ValorEspecifico){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<Alto; i++){
                for(int j=0; j<Ancho; j++){
                    matrizRaiz[i][j]=ValorEspecifico;
                }
            }
        }else{
            System.out.println("ERROR en Inicializar, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso Inicializar Terminado");
    }
    
    
    
    /**
     * Descripcion: Agregar una nueva Fila Arriba con Strings Vacios
     *
     * @param	ValorRelleno  Valor a Poner en los nuevos Espacios que se creen
     */
    public void addFilaArriba(long ValorRelleno){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            Alto=Alto+1;
            long nuevaMatriz[][]= new long[Alto][Ancho];
            
            for(int i=0; i<Alto-1; i++){
                for(int j=0; j<Ancho; j++){
                    nuevaMatriz[i+1][j]=matrizRaiz[i][j];
                }
            }
            
            for(int i=0; i<Ancho; i++){
                nuevaMatriz[0][i]=ValorRelleno;
            }
            
            matrizRaiz=nuevaMatriz;
        }else{
            System.out.println("ERROR en addFilaArriba, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso identificador Terminado");
    }
    
    
    
    /**
     * Descripcion: Eliminar una fila N de la Matriz
     *
     * @param	posFila Posicion de la fila a eliminar
     */
    public void deleteFilaN(int posFila){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            Alto = Alto-1;
            long[][] matrizNew = new long[Alto][Ancho];
            
            //Para todas las Filas
            int posAltoNuevo=0;
            for(int i=0; i<Alto; i++){
                //Comprobar que esta no sea la fila a eliminar, para pasar los valores
                if(i!=posFila){
                    //Para todos los valores de esta fila//
                    for(int x=0; x<Ancho; x++){
                        //Pasar valores a la nueva matriz
                        matrizNew[posAltoNuevo][x] = matrizRaiz[i][x];
                    }
                    posAltoNuevo=posAltoNuevo+1;
                }
            }
            
            //Remplazar la nueva matriz por la vieja//
            matrizRaiz = matrizNew.clone();
        }else{
            System.out.println("ERROR en deleteFilaN, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso identificador Terminado");
    }
    
    
    
    
    /**
     * Descripcion: Insertar una Fila en la matriz
     *
     * @param	posFila Posicion de la fila a eliminar
     * @param   vectorFila Fila a insertar en forma de vector
     */
    public void insertFilaN(int posFila, VectorLong vectorFila){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(posFila<0 || posFila >Alto){
        condiciones=false;
        motivo="Posicion de Fila no valido";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            Alto = Alto+1;
            long[][] matrizNew = new long[Alto][Ancho];
            
            //Para todas las Filas
            int posAltoviejo=0;
            for(int i=0; i<Alto; i++){
                //Comprobar que esta no sea la fila a insertar, para solo pasar los valores
                if(i!=posFila){
                    //Para todos los valores de esta fila//
                    for(int x=0; x<Ancho; x++){
                        //Pasar valores de la vieja a la nueva
                        matrizNew[i][x] = matrizRaiz[posAltoviejo][x];
                    }
                    posAltoviejo = posAltoviejo+1;
                }else{
                    //Pasar los valores de la nueva fila//
                    for(int x=0; x<Ancho; x++){
                        //Pasar valores de la vieja a la nueva
                        matrizNew[i][x] = vectorFila.getValue(x,9999999);
                    }
                }
            }
            
            //Remplazar la nueva matriz por la vieja//
            matrizRaiz = matrizNew.clone();
        }else{
            System.out.println("ERROR en deleteFilaN, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso identificador Terminado");
    }
    
    
    
    
    
    /**
     * Descripcion: Insertar una Fila en la matriz
     *
     * @param	posFila Posicion de la fila a eliminar
     * @param   vectorFila Fila a insertar en forma de vector
     * @param   valorRelleno Vectores de relleno para los excedentes
     */
    public void insertFilaN_Force(int posFila, VectorLong vectorFila, VectorLong valorRelleno){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            //Si la posicion de la fila es negativo
            if(posFila<0){
                //Crear la nueva matriz con la cantidad de filas nuevas//
                long[][] matrizNueva = new long[Alto+(posFila*(-1))][posFila];
            }
            
            //Si la posicion de la fila esta en el rango
            
            //Si la posicion de la fila excede el rango
            
        }else{
            System.out.println("ERROR en deleteFilaN, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso identificador Terminado");
    }
    
    
    
    
    /**
     * Descripcion: Agregar una nueva Fila Abajo con Strings Vacios
     *
     * @param	ValorRelleno  Valor a Poner en los nuevos Espacios que se creen
     */
    public void addFilaAbajo(long ValorRelleno){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            Alto=Alto+1;
            long nuevaMatriz[][]= new long[Alto][Ancho];
            
            for(int i=0; i<Alto-1; i++){
                for(int j=0; j<Ancho; j++){
                    nuevaMatriz[i][j]=matrizRaiz[i][j];
                }
            }
            
            for(int i=0; i<Ancho; i++){
                nuevaMatriz[Alto-1][i]=ValorRelleno;
            }
            
            matrizRaiz=nuevaMatriz;
        }else{
            System.out.println("ERROR en addFilaArriba, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso identificador Terminado");
    }
    
    
    
    /**
     * Descripcion: Agregar una nueva Columna por la Derecha
     * 
     * @param	ValorRelleno  Valor a Poner en los nuevos Espacios que se creen
     */
    public void addColumnaDerecha(long ValorRelleno){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            Ancho=Ancho+1;
            long nuevaMatriz[][]= new long[Alto][Ancho];
            
            for(int i=0; i<Alto; i++){
                for(int j=0; j<Ancho-1; j++){
                    nuevaMatriz[i][j]=matrizRaiz[i][j];
                }
            }
            
            for(int i=0; i<Alto; i++){
                nuevaMatriz[i][Ancho-1]=ValorRelleno;
            }
            
            matrizRaiz=nuevaMatriz;
        }else{
            System.out.println("ERROR en addFilaArriba, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso identificador Terminado");
    }
    
    
    
    /**
     * Descripcion: Agregar una nueva Columna por la Izquierda
     *
     * @param	ValorRelleno  Valor a Poner en los nuevos Espacios que se creen
     */
    public void addColumnaIzquierda(long ValorRelleno){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		
	//Comenzar Proceso//
        if(condiciones==true){
            Ancho=Ancho+1;
            long nuevaMatriz[][]= new long[Alto][Ancho];
            
            for(int i=0; i<Alto; i++){
                for(int j=0; j<Ancho-1; j++){
                    nuevaMatriz[i][j+1]=matrizRaiz[i][j];
                }
            }
            
            for(int i=0; i<Alto; i++){
                nuevaMatriz[i][0]=ValorRelleno;
            }
            
            matrizRaiz=nuevaMatriz;
        }else{
            System.out.println("ERROR en addFilaArriba, motivo: "+motivo);
	}
    //Terminar Proceso//
        //System.out.println("Proceso identificador Terminado");
    }
    
    
    
    /**
     * Descripcion: Poner un valor en una posicion determinada
     *
     * @param	vaule Valor a Agregar en la Matriz
     * @param   alto Valor mayorIgual a cero y menor al Alto
     * @param   ancho Valor MayorIgual a cero y menor a Ancho
     */
    public void setVaule(long vaule, int alto, int ancho){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if((alto>=Alto)||(alto<0)){
        condiciones=false;
        motivo="Posicion Alto:"+alto+" No Existe en la Matriz";
    }
    if((ancho>=Ancho)||(ancho<0)){
        condiciones=false;
        motivo="Posicion Ancho:"+ancho+" No Existe en la Matriz";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            matrizRaiz[alto][ancho]=vaule;
        }else{
            System.out.println("ERROR en setVaule, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
    
    /**
     * Descripcion: Poner una Fila en una posicion determinada
     *
     * @param	vaule Valor a Agregar en la Matriz
     * @param   alto Valor mayorIgual a cero y menor al Alto
     */
    public void setFila(VectorLong vaule, int alto){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if((alto>=Alto)||(alto<0)){
        condiciones=false;
        motivo="Posicion Alto:"+alto+" No Existe en la Matriz";
    }
    if(Ancho!=vaule.Longitud()){
        condiciones=false;
        motivo="Vector incompatible en matriz, El Ancho del Vector es Diferente al Ancho de la Matriz";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<vaule.Longitud(); i++){
                setVaule(vaule.getValue(i,0), alto,i);
            }
        }else{
            System.out.println("ERROR en setVaule, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
    
    /**
     * Descripcion: Si el punto no existe en la matriz, este se crea
     *
     * @param	vaule Valor a Agregar en la Matriz
     * @param   alto Si es menor a cero se crea FilaArriba, mayor a cero FilaAbajo
     * @param   ancho Si es menor a cero se crea ColumnaIzq, mayor a cero ColumnaDerecha
     * @param	ValorRelleno  Valor a Poner en los nuevos Espacios que se creen
     */
    public void setVauleForce(long vaule, int alto, int ancho, long ValorRelleno){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            if(((alto>=0)&&(alto<Alto))&&((ancho>=0)&&(ancho<Ancho))){
                setVaule(vaule, alto, ancho);
            }else{
                //Crear Para Custiones del Alto//
                if(alto>=0){
                    int AltoInicial=Alto;
                    for(int i=0; i<=alto-AltoInicial; i++){
                        addFilaAbajo(ValorRelleno);
                    }
                }else{
                    for(int i=1; i<=-alto; i++){
                        addFilaArriba(ValorRelleno);
                    }
                }
                //Crear Para cuestiones del Ancho//
                if(ancho>=0){
                    int AnchoInicial=Ancho;
                    for(int i=0; i<=ancho-AnchoInicial; i++){
                        addColumnaDerecha(ValorRelleno);
                    }
                }else{
                    for(int i=1; i<=-ancho; i++){
                        addColumnaIzquierda(ValorRelleno);
                    }
                }
                
                //Finalmente Agregar el ValorEspecifico//
                if(alto<0){alto=0;}  if(ancho<0){ancho=0;}
                setVaule(vaule, alto, ancho);
            }
        }else{
            System.out.println("ERROR en setVaule, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
    /**
     * Descripcion: Imprimir la matriz en Consola
     *
     * @param	separador Separador entre elementos de la matriz
     */
    public void ImprimirConsola(String separador){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(separador==null){
        condiciones=false;
        motivo="El separador es Nulo";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            for(int i=0; i<Alto; i++){
                for(int j=0; j<Ancho; j++){
                    System.out.print(matrizRaiz[i][j]);System.out.print(separador);
                }
                System.out.println("");
            }
        }else{
            System.out.println("ERROR en ImprimirConsola, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
    
     /**
     * Descripcion: Obtner el Vaule de una posicion de la matriz
     *
     * @param	alto Posicion a lo Alto
     * @param   ancho Posicion a lo ancho
     * @return	valores de retorno
     */
    public long getVaule (int alto, int ancho){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        long salida=0;
    //Comprobar Condiciones Iniciales//
    if((Nums.Range(alto,0,Alto)&&Nums.Range(ancho,0,Ancho))==false){
        condiciones=false;
        motivo="Poscicion ("+alto+","+ancho+") no existe en la Matriz";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida=matrizRaiz[alto][ancho];
	}else{
            System.out.println("ERROR en getVaule, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtner la columna X en forma de Vector
     *
     * @param	posColum posicion de la columna empezando en 0 hasta Ancho-1
     * @return	null o Columna en forma de vector
     */
    public VectorLong getColum (int posColum){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        VectorLong salida=null;
    //Comprobar Condiciones Iniciales//
    if(posColum<0||posColum>=Ancho){
        condiciones=false;
        motivo="Posicion de Columna no existe en la matriz";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida = new VectorLong();
            
            for(int i=0; i<Alto; i++){
                salida.addVauleRigth(getVaule(i,posColum));
            }
	}else{
            System.out.println("ERROR en getColum, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
     /**
     * Descripcion: Obtner la Fila X en forma de Vector
     *
     * @param	posFila posicion de la Fila empezando en 0 hasta Ancho-1
     * @return	null o Columna en forma de vector
     */
    public VectorLong getFila (int posFila){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        VectorLong salida=null;
    //Comprobar Condiciones Iniciales//
    if(posFila<0||posFila>=Alto){
        condiciones=false;
        motivo="Posicion de Fila no existe en la matriz";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            salida = new VectorLong();
            
            for(int i=0; i<Ancho; i++){
                salida.addVauleRigth(getVaule(posFila,i));
            }
	}else{
            System.out.println("ERROR en getFila, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    /**
     * Descripcion: Intercambiar columna por otra columna
     *
     * @param	posColumA posicion de la columna A
     * @param   posColumB posicion de la columna B
     */
    public void change_Column2Colum (int posColumA, int posColumB){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(posColumA<0 || posColumA>Ancho){
        condiciones=false;
        motivo="posicion de columA fuera de rango";
    }
    
    if(posColumB<0 || posColumB>Ancho){
        condiciones=false;
        motivo="posicion de columB fuera de rango";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Hacer un recorrido por todo lo alto
            Long elementoTemp;
            for(int i=0; i<Alto; i++){
                //resguardar el elemento de A
                elementoTemp=getVaule(i,posColumA);
                
                //Llevar el elemento de B en A
                setVaule(getVaule(i, posColumB), i, posColumA);
                
                //Meter el elemento resguardado en B//
                setVaule(elementoTemp,i,posColumB);
            }
        }else{
            System.out.println("ERROR en change_Column2Colum, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
    
    /**
     * Descripcion: Intercambiar Fila por otra Fila
     *
     * @param	posFilaA posicion de la Fila A
     * @param   posFilaB posicion de la Fila B
     */
    public void change_Fila2Fila (int posFilaA, int posFilaB){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(posFilaA<0 || posFilaA>Alto){
        condiciones=false;
        motivo="posicion de FilaA fuera de rango";
    }
    
    if(posFilaB<0 || posFilaB>Alto){
        condiciones=false;
        motivo="posicion de FilaB fuera de rango";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Hacer un recorrido por todo lo Ancho
            long elementoTemp;
            for(int i=0; i<Ancho; i++){
                //resguardar el elemento de A
                elementoTemp=getVaule(posFilaA,i);
                
                //Llevar el elemento de B en A
                setVaule(getVaule(posFilaB,i), posFilaA, i);
                
                //Meter el elemento resguardado en B//
                setVaule(elementoTemp,posFilaB,i);
            }
        }else{
            System.out.println("ERROR en change_Fila2Fila, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso identificador Terminado");
    }
    
    
    
    /**
     * Descripcion: Ordenar toda la matriz usando como criterio una columna, afectando todas las filas de la matriz
     *              Usando metodo: Burbuja
     * @param	posColum posicion de la columna a usar como criterio de ordenamiento
     * @param   Mayor2Menor Si el Ordenamiento es de mayor a menor
     */
    public void OrderBy_Colum_ALL(int posColum, boolean Mayor2Menor){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(posColum<0 || posColum>Ancho){
        condiciones=false;
        motivo="Posicion no es Valida";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Usando metodo burbuja//
            
            if(Mayor2Menor){
                //Para Cada Elemento
                for(int i=0; i<Alto; i++){
                    //Ordenamiento Mayor a Menor//
                    //Los Elementos mas pesados suben
                    //Para todos los elementos
                    for(int x=Alto-1; x>0; x--){
                        //Obtener el Elemento Actual//
                            VectorLong ElementActual = getFila(x);

                        //Obtener el Elemento Anterior//
                            VectorLong ElementSiguiente = getFila(x-1);

                        //Comprobar si el elemento Anterior es mas pesado
                        //Si no es mas pesado entonces subir este elemento, hacer remplazo//
                            long elementS=ElementSiguiente.getValue(posColum,0);
                            long elementA=ElementActual.getValue(posColum,0);
                            if(elementS<elementA){
                                setFila(ElementSiguiente,x);
                                setFila(ElementActual,x-1);
                            }
                    }
                }
            }else{
                //Para Cada elemento//
                for(int i=0; i<Alto; i++){
                    //Ordenamiento Menor a Mayor//
                    //Los Elementos mas livianos suben
                    //Para todos los elementos
                    for(int x=Alto-1; x>0; x--){
                        //Obtener el Elemento Actual//
                            VectorLong ElementActual = getFila(x);

                        //Obtener el Elemento Anterior//
                            VectorLong ElementSiguiente = getFila(x-1);

                        //Comprobar si el elemento Anterior es mas liviano
                        //Si no es mas lviano entonces subir este elemento, hacer remplazo//
                            long elementS=ElementSiguiente.getValue(posColum,0);
                            long elementA=ElementActual.getValue(posColum,0);
                            if(elementS>elementA){
                                setFila(ElementSiguiente,x);
                                setFila(ElementActual,x-1);
                            }
                    }
                }
            }
        }else{
            System.out.println("ERROR en OrderBy_Colum_ALL, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso OrderBy_Colum_ALL Terminado");
    }
    
    
    
    
    /**
     * Descripcion: Ordenar solo una columna de la matriz, sin afectar las demas
     *              Usando metodo: Burbuja
     * @param	posColum posicion de la columna a usar como criterio de ordenamiento
     * @param   Mayor2Menor Si el Ordenamiento es de mayor a menor
     */
    public void OrderBy_Colum(int posColum, boolean Mayor2Menor){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(posColum<0 || posColum>Ancho){
        condiciones=false;
        motivo="Posicion no es Valida";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Usando metodo burbuja//
            
            if(Mayor2Menor){
                //Para Cada Elemento
                for(int i=0; i<Alto; i++){
                    //Ordenamiento Mayor a Menor//
                    //Los Elementos mas pesados suben
                    //Para todos los elementos
                    for(int x=Alto-1; x>0; x--){
                        //Obtener el Elemento Actual//
                            long ElementActual = getVaule(x, posColum);

                        //Obtener el Elemento Anterior//
                            long ElementSiguiente = getVaule(x-1, posColum);

                        //Comprobar si el elemento Anterior es mas pesado
                        //Si no es mas pesado entonces subir este elemento, hacer remplazo//
                            if(ElementSiguiente<ElementActual){
                                setVaule(ElementSiguiente, x, posColum);
                                setVaule(ElementActual, x-1, posColum);
                            }
                    }
                }
            }else{
                //Para Cada elemento//
                for(int i=0; i<Alto; i++){
                    //Ordenamiento Menor a Mayor//
                    //Los Elementos mas livianos suben
                    //Para todos los elementos
                    for(int x=Alto-1; x>0; x--){
                        //Obtener el Elemento Actual//
                            long ElementActual = getVaule(x, posColum);

                        //Obtener el Elemento Anterior//
                            long ElementSiguiente = getVaule(x-1, posColum);

                        //Comprobar si el elemento Anterior es mas liviano
                        //Si no es mas liviano entonces subir este elemento, hacer remplazo//
                            if(ElementSiguiente>ElementActual){
                                setVaule(ElementSiguiente, x, posColum);
                                setVaule(ElementActual, x-1, posColum);
                            }
                    }
                }
            }
        }else{
            System.out.println("ERROR en OrderBy_Colum_ALL, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso OrderBy_Colum_ALL Terminado");
    }
    
    
}
