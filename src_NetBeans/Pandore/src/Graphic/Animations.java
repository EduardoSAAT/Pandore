/*
 * Clase para Crear dibujos o animaciones en la consola
 */
package Graphic;

import Algoritms.*;
import Listeners.LTKeyboard;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
/**
 *
 * @author Ing Lalux
 */
public class Animations{
    
    /**
     * Descripcion: Dibujar un Corazon en la consola
     *
     * @param	caracter caracter a usar para hacer el dibujo
     * @param   tiempo tiempo en que la animacion se debe completar en milisegundos
     */
    public static void DibujaCorazon(String caracter, int tiempo){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
    if(Cad.isNulloVacia(caracter)){
        condiciones=false;
        motivo="Caracter es null o vacio";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            //Generar figura//
            String figura[] = new String[23];
            figura[0]="___________0000000_____________0000000 ";
            figura[1]="_______00000000000000_______0000000000000 ";
            figura[2]="_____000000000000000000__000000000000000000  ";
            figura[3]="___000000000000000000000000000000_______00000  ";
            figura[4]="__0000000000000000000000000000000_________0000  ";
            figura[5]="_0000000000000000000000000000000000________0000  ";
            figura[6]="_0000000000000000000000000000000000000_____0000  ";
            figura[7]="0000000000000000000000000000000000000000___00000  ";
            figura[8]="00000000000000000000000000000000000000000_000000  ";
            figura[9]="000000000000000000000000000000000000000000000000  ";
            figura[10]="000000000000000000000000000000000000000000000000  ";
            figura[11]="_0000000000000000000000000000000000000000000000  ";
            figura[12]="__00000000000000000000000000000000000000000000   ";
            figura[13]="____0000000000000000000000000000000000000000   ";
            figura[14]="______000000000000000000000000000000000000   ";
            figura[15]="_________000000000000000000000000000000   ";
            figura[16]="____________000000000000000000000000   ";
            figura[17]="______________00000000000000000000   ";
            figura[18]="_________________000000000000000   ";
            figura[19]="___________________0000000000   ";
            figura[20]="_____________________000000   ";
            figura[21]="______________________0000    ";
            figura[22]="_______________________00    ";
            
            //Modificar la figura//
            for(int i=0; i<figura.length; i++){
                figura[i]=Cad.remplazarSubCadALL(figura[i],"0",caracter);
            }
            
            //Calcular el tiempo en que la animacion se debe completar
            float timeEspera = tiempo/figura.length;
            
            //Dibujar la figura en pantalla
            for(int i=0; i<figura.length; i++){
                try {
                    System.out.println(figura[i]);
                    
                    Thread.sleep((long) timeEspera);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Animations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            System.out.println("ERROR en DibujaCorazon, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso DibujaCorazon Terminado");
    }
    
    
    
    /**
     * Descripcion: Dibujar una mano grosera
     *
     * @param   caracter caracter a usar para hacer el dibujo
     * @param   tiempo tiempo en que la animacion se debe completar en milisegundos
     */
    public static void DibujaFuckYou3D(String caracter, int tiempo){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            //Generar figura//
            String figura[] = new String[12];
            figura[0]="                              /´ /) ";
            figura[1]="                            /¯..// ";
            figura[2]="                          /....//  ";
            figura[3]="                        /¯ ../ / ";
            figura[4]="                     /... ./ /  ";
            figura[5]="                 /´¯/' ...'/´¯`•¸  ";
            figura[6]="             /'/.../... ./... ./¨¯\\  ";
            figura[7]="            ('(...´(... (.. ,~/'..')  ";
            figura[8]="             \\.. ..\\...\\... \\/.. ./  ";
            figura[9]="               \\.. .. .... . _.•´  ";
           figura[10]="                  \\....... ..(  ";
           figura[11]="                    \\..... ...\\  ";
            
            //Modificar la figura//
            for(int i=0; i<figura.length; i++){
                figura[i]=Cad.remplazarSubCadALL(figura[i],".",caracter);
            }
            
            //Calcular el tiempo en que la animacion se debe completar
            float timeEspera = tiempo/figura.length;
            
            //Dibujar la figura en pantalla
            for(int i=0; i<figura.length; i++){
                try {
                    System.out.println(figura[i]);
                    
                    Thread.sleep((long) timeEspera);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Animations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            System.out.println("ERROR en DibujaFuckYou, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso DibujaFuckYou Terminado");
    }
    
    
    
    
    /**
     * Descripcion: Dibujar un Craneo 
     *
     * @param   tiempo tiempo en que la animacion se debe completar en milisegundos
     */
    public static void DibujaCraneo(int tiempo){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            //Generar figura//
            String figura[] = new String[21];
            figura[0]="                      .~#########%%;~. ";
            figura[1]="                     /############%%;`\\ ";
            figura[2]="                    /######/~\\/~\\%%;,;,\\  ";
            figura[3]="                   |#######\\    /;;;;.,.|  ";
            figura[4]="                   |#########\\/%;;;;;.,.|  ";
            figura[5]="          XX       |##/~~\\####%;;;/~~\\;,|       XX  ";
            figura[6]="        XX..X      |#|  o  \\##%;/  o  |.|      X..XX  ";
            figura[7]="      XX.....X     |##\\____/##%;\\____/.,|     X.....XX  ";
            figura[8]=" XXXXX.....XX      \\#########/\\;;;;;;,, /      XX.....XXXXX  ";
            figura[9]="X |......XX%,.@      \\######/%;\\;;;;, /      @#%,XX......| X  ";
            figura[10]="X |.....X  @#%,.@     |######%%;;;;,.|     @#%,.@  X.....| X  ";
            figura[11]="X  \\...X     @#%,.@   |# # # % ; ; ;,|   @#%,.@     X.../  X  ";
            figura[12]=" X# \\.X        @#%,.@                  @#%,.@        X./  #   ";
            figura[13]="  ##  X          @#%,.@              @#%,.@          X   #   ";
            figura[14]=", \"# #X            @#%,.@          @#%,.@            X ##   ";
            figura[15]="   `###X             @#%,.@      @#%,.@             ####'   ";
            figura[16]="  . ' ###              @#%.,@  @#%,.@              ###`\"   ";
            figura[17]="    . \";\"                @#%.@#%,.@                ;\"` ' .   ";
            figura[18]="      '                    @#%,.@                   ,.   ";
            figura[19]="      ` ,                @#%,.@  @@                `   ";
            figura[20]="                          @@@  @@@     ";
            
            
            //Calcular el tiempo en que la animacion se debe completar
            float timeEspera = tiempo/figura.length;
            
            //Dibujar la figura en pantalla
            for(int i=0; i<figura.length; i++){
                try {
                    System.out.println(figura[i]);
                    
                    Thread.sleep((long) timeEspera);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Animations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            System.out.println("ERROR en DibujaCraneo, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso DibujaCraneo Terminado");
    }
    
    
    /**
     * Descripcion: Dibujar un Craneo 
     *
     * @param   tiempo tiempo en que la animacion se debe completar en milisegundos
     */
    public static void DibujaCraneoAnimation(int tiempo){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            //Generar figura//
            String figura[] = new String[21];
            
            //Calcular el tiempo en que la animacion se debe completar
            float timeEspera = tiempo/figura.length;
            
            while(true){
                figura[0]="                      .~#########%%;~. ";
                figura[1]="                     /############%%;`\\ ";
                figura[2]="                    /######/~\\/~\\%%;,;,\\  ";
                figura[3]="                   |#######\\    /;;;;.,.|  ";
                figura[4]="                   |#########\\/%;;;;;.,.|  ";
                figura[5]="          XX       |##/~~\\####%;;;/~~\\;,|       XX  ";
                figura[6]="        XX..X      |#|  o  \\##%;/  o  |.|      X..XX  ";
                figura[7]="      XX.....X     |##\\____/##%;\\____/.,|     X.....XX  ";
                figura[8]=" XXXXX.....XX      \\#########/\\;;;;;;,, /      XX.....XXXXX  ";
                figura[9]="X |......XX%,.@      \\######/%;\\;;;;, /      @#%,XX......| X  ";
                figura[10]="X |.....X  @#%,.@     |######%%;;;;,.|     @#%,.@  X.....| X  ";
                figura[11]="X  \\...X     @#%,.@   |# # # % ; ; ;,|   @#%,.@     X.../  X  ";
                figura[12]=" X# \\.X        @#%,.@                  @#%,.@        X./  #   ";
                figura[13]="  ##  X          @#%,.@              @#%,.@          X   #   ";
                figura[14]=", \"# #X            @#%,.@          @#%,.@            X ##   ";
                figura[15]="   `###X             @#%,.@      @#%,.@             ####'   ";
                figura[16]="  . ' ###              @#%.,@  @#%,.@              ###`\"   ";
                figura[17]="    . \";\"               @#%.@#%,.@                ;\"` ' .   ";
                figura[18]="      '                   @#%,.@                   ,.       ";
                figura[19]="      ` ,               @#%,.@  @@                `        ";
                figura[20]="                         @@@  @@@                         ";

                //Dibujar la figura en pantalla
                Algoritms.ConsoleCommands.ClearScreen();
                for(int i=0; i<figura.length; i++){
                        System.out.println(figura[i]);
                }
                    try {
                        Thread.sleep((long) timeEspera);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Animations.class.getName()).log(Level.SEVERE, null, ex);
                    }


                figura[11]="X  \\...X     @#%,.@   |# # # % ; ; ;,|   @#%,.@     X.../  X  ";
                figura[12]=" X# \\.X        @#%,.@                  @#%,.@        X./  # ,  ";
                figura[13]="  ##  X          @#%,.@              @#%,.@          X   # , ,    ";
                figura[14]="| \"# #X            @#%,.@          @#%,.@            X ##     .";
                figura[15]=", ,`###X             @#%,.@      @#%,.@             ####' ,  ";
                figura[16]="  . ' ###              @#%.,@  @#%,.@              ###`\"     ,";
                figura[17]="    . \";\"               @#%.@#%,.@              , ;\"` ' .   ";
                figura[18]="  ,   ' |                 @#%,.@                   ,,.   ,    ";
                figura[19]="      ` ,,              @#%,.@  @@                 |`        ";
                figura[20]="                         @@@  @@@                  ,       ";

                //Dibujar la figura en pantalla
                Algoritms.ConsoleCommands.ClearScreen();
                for(int i=0; i<figura.length; i++){
                        System.out.println(figura[i]);
                }
                    try {
                        Thread.sleep((long) timeEspera);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Animations.class.getName()).log(Level.SEVERE, null, ex);
                    }

                figura[11]="X  \\...X     @#%,.@   |# # # % ; ; ;,|   @#%,.@     X.../  X  ";
                figura[12]=" X# \\.X ,      @#%,.@                  @#%,.@        X./  # |  ";
                figura[13]="  ##  X          @#%,.@              @#%,.@          X   # ,     ";
                figura[14]=". \"# #X            @#%,.@          @#%,.@           .X ##   . .";
                figura[15]=",  `###X             @#%,.@      @#%,.@             ####' |     ";
                figura[16]="  . | ###              @#%.,@  @#%,.@              ###`\"     ,  ";
                figura[17]="      \";\"               @#%.@#%,.@              , ;\"` ' .  | ";
                figura[18]="  ,   ' |                 @#%,.@                   ,,.   ,    ";
                figura[19]="      ` ,,              @#%,.@  @@                 .`      .  ";
                figura[20]="   ,                     @@@  @@@                  ,    ,   ";

                //Dibujar la figura en pantalla
                Algoritms.ConsoleCommands.ClearScreen();
                for(int i=0; i<figura.length; i++){
                        System.out.println(figura[i]);
                }
                    try {
                        Thread.sleep((long) timeEspera);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Animations.class.getName()).log(Level.SEVERE, null, ex);
                    }

                figura[11]="X  \\...X     @#%,.@   |# # # % ; ; ;,|   @#%,.@     X.../  X  ";
                figura[12]=" X# \\.X        @#%,.@                  @#%,.@        X./  # .  ";
                figura[13]="  ##  X          @#%,.@              @#%,.@          X   # , | .  ";
                figura[14]="  \"# #X            @#%,.@          @#%,.@            X ##     .";
                figura[15]="   `###X             @#%,.@      @#%,.@             ####'| ,  ";
                figura[16]="  .   ###              @#%.,@  @#%,.@              ###`\"   .  ,";
                figura[17]="      \";\"               @#%.@#%,.@              , ;\"` '    ";
                figura[18]=" |    '                   @#%,.@                      .    ";
                figura[19]="      `   |             @#%,.@  @@                 .`    |    ";
                figura[20]="  .    ,                 @@@  @@@               .    .  ,  ";

                //Dibujar la figura en pantalla
                Algoritms.ConsoleCommands.ClearScreen();
                for(int i=0; i<figura.length; i++){
                        System.out.println(figura[i]);
                }
                    try {
                        Thread.sleep((long) timeEspera);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Animations.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        }else{
            System.out.println("ERROR en DibujaCraneo, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso DibujaCraneo Terminado");
    }
    
    
    
    /**
     * Descripcion: Dibujar un craneo pequeño
     *
     * @param   tiempo tiempo en que la animacion se debe completar en milisegundos
     */
    public static void DibujaMiniCraneo(int tiempo){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            //Generar figura//
            String figura[] = new String[13];
            figura[0]="   _                   _ ";
            figura[1]=" _( )                 ( )_ ";
            figura[2]="(_, |      __ __      | ,_)  ";
            figura[3]="   \\'\\    /  ^  \\    /'/  ";
            figura[4]="    '\\'\\,/\\      \\,/'/'  ";
            figura[5]="      '\\| []   [] |/'  ";
            figura[6]="        (_  /^\\  _)  ";
            figura[7]="          \\  ~  /  ";
            figura[8]="          /HHHHH\\  ";
            figura[9]="        /'/{^^^}\\'\\  ";
            figura[10]="    _,/'/'  ^^^  '\\'\\,_";
            figura[11]="   (_, |           | ,_)  ";
            figura[12]="     (_)           (_)   ";
            
            
            //Calcular el tiempo en que la animacion se debe completar
            float timeEspera = tiempo/figura.length;
            
            //Dibujar la figura en pantalla
            for(int i=0; i<figura.length; i++){
                try {
                    System.out.println(figura[i]);
                    
                    Thread.sleep((long) timeEspera);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Animations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            System.out.println("ERROR en DibujaMiniCraneo, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso DibujaMiniCraneo Terminado");
    }
    
    
    
    
    /**
     * Descripcion: Dibujar una Piramide
     *
     * @param   version Valor a mostrar en la animacion
     * @param   pageContact Valor a mostrar en la animacion
     * @param   tiempo tiempo en que la animacion se debe completar en milisegundos
     */
    public static void DibujaTechnotitlan(int tiempo,String version,String pageContact){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            //Generar figura//
            String figura1[] = new String[13];
            figura1[0]="                  _____";
            figura1[1]="                 _|[]_|_";
            figura1[2]="               _/_/=|_\\_\\_";
            figura1[3]="             _/_ /==| _\\ _\\_";
            figura1[4]="           _/__ /===|_ _\\ __\\_";
            figura1[5]="_,       _/_ _ /====| ___\\  __\\_";
            figura1[6]="_)-    _/ __ _/=====|_ ___\\ ___ \\_";
            figura1[7]=" ´   _/ ___ _/======| ____ \\_  __ \\_";
            figura1[8]="----------------------------------------";
            figura1[9]="Product by: TECHNOTITLAN SYSTEMS©";
            figura1[10]="Release: "+version;
            figura1[11]="Official Page: "+pageContact;
            figura1[12]="----------------------------------------";
            
            String figura2[] = new String[13];
            figura2[0]="                  _____";
            figura2[1]="                 _|[]_|_";
            figura2[2]="               _/_/=|_\\_\\_";
            figura2[3]="             _/_ /==| _\\ _\\_";
            figura2[4]=",_,        _/__ /===|_ _\\ __\\_";
            figura2[5]="(_)-     _/_ _ /====| ___\\  __\\_";
            figura2[6]="´ ´    _/ __ _/=====|_ ___\\ ___ \\_";
            figura2[7]="     _/ ___ _/======| ____ \\_  __ \\_";
            figura2[8]="----------------------------------------";
            figura2[9]="Product by: TECHNOTITLAN SYSTEMS©";
            figura2[10]="Release: "+version;
            figura2[11]="Official Page: "+pageContact;
            figura2[12]="----------------------------------------";
            
            
            String figura3[] = new String[13];
            figura3[0]="                  _____";
            figura3[1]="                 _|[]_|_";
            figura3[2]="               _/_/=|_\\_\\_";
            figura3[3]=" ,_,         _/_ /==| _\\ _\\_";
            figura3[4]="-(_)-      _/__ /===|_ _\\ __\\_";
            figura3[5]=" ´ ´     _/_ _ /====| ___\\  __\\_";
            figura3[6]="       _/ __ _/=====|_ ___\\ ___ \\_";
            figura3[7]="     _/ ___ _/======| ____ \\_  __ \\_";
            figura3[8]="----------------------------------------";
            figura3[9]="Product by: TECHNOTITLAN SYSTEMS©";
            figura3[10]="Release: "+version;
            figura3[11]="Official Page: "+pageContact;
            figura3[12]="----------------------------------------";
            
            
            String figura4[] = new String[13];
            figura4[0]="                  _____";
            figura4[1]="                 _|[]_|_";
            figura4[2]="  ,_,          _/_/=|_\\_\\_";
            figura4[3]=" -(_)-       _/_ /==| _\\ _\\_";
            figura4[4]="  ´ ´      _/__ /===|_ _\\ __\\_";
            figura4[5]="         _/_ _ /====| ___\\  __\\_";
            figura4[6]="       _/ __ _/=====|_ ___\\ ___ \\_";
            figura4[7]="     _/ ___ _/======| ____ \\_  __ \\_";
            figura4[8]="----------------------------------------";
            figura4[9]="Product by: TECHNOTITLAN SYSTEMS©";
            figura4[10]="Release: "+version;
            figura4[11]="Official Page: "+pageContact;
            figura4[12]="----------------------------------------";
            
            
            String figura5[] = new String[13];
            figura5[0]="                  _____";
            figura5[1]="   ,_,           _|[]_|_";
            figura5[2]="  -(_)-        _/_/=|_\\_\\_";
            figura5[3]="   ´ ´       _/_ /==| _\\ _\\_";
            figura5[4]="           _/__ /===|_ _\\ __\\_";
            figura5[5]="         _/_ _ /====| ___\\  __\\_";
            figura5[6]="       _/ __ _/=====|_ ___\\ ___ \\_";
            figura5[7]="     _/ ___ _/======| ____ \\_  __ \\_";
            figura5[8]="----------------------------------------";
            figura5[9]="Product by: TECHNOTITLAN SYSTEMS©";
            figura5[10]="Release: "+version;
            figura5[11]="Official Page: "+pageContact;
            figura5[12]="----------------------------------------";
            
            String figura6[] = new String[13];
            figura6[0]="    ,_,           _____";
            figura6[1]="   -(_)-         _|[]_|_";
            figura6[2]="    ´ ´        _/_/=|_\\_\\_";
            figura6[3]="             _/_ /==| _\\ _\\_";
            figura6[4]="           _/__ /===|_ _\\ __\\_";
            figura6[5]="         _/_ _ /====| ___\\  __\\_";
            figura6[6]="       _/ __ _/=====|_ ___\\ ___ \\_";
            figura6[7]="     _/ ___ _/======| ____ \\_  __ \\_";
            figura6[8]="----------------------------------------";
            figura6[9]="Product by: TECHNOTITLAN SYSTEMS©";
            figura6[10]="Release: "+version;
            figura6[11]="Official Page: "+pageContact;
            figura6[12]="----------------------------------------";
            
            String figura7[] = new String[13];
            figura7[0]="    -(_)-         _____";
            figura7[1]="     ´ ´         _|[]_|_";
            figura7[2]="               _/_/=|_\\_\\_";
            figura7[3]="             _/_ /==| _\\ _\\_";
            figura7[4]="           _/__ /===|_ _\\ __\\_";
            figura7[5]="         _/_ _ /====| ___\\  __\\_";
            figura7[6]="       _/ __ _/=====|_ ___\\ ___ \\_";
            figura7[7]="     _/ ___ _/======| ____ \\_  __ \\_";
            figura7[8]="----------------------------------------";
            figura7[9]="Product by: TECHNOTITLAN SYSTEMS©";
            figura7[10]="Release: "+version;
            figura7[11]="Official Page: "+pageContact;
            figura7[12]="----------------------------------------";
            
            
            String figura8[] = new String[13];
            figura8[0]="      ´ ´         _____";
            figura8[1]="                 _|░░_|_";
            figura8[2]="               _/_/=|_\\_\\_";
            figura8[3]="             _/_ /==| _\\ _\\_";
            figura8[4]="           _/__ /===|_ _\\ __\\_";
            figura8[5]="         _/_ _ /====| ___\\  __\\_";
            figura8[6]="       _/ __ _/=====|_ ___\\ ___ \\_";
            figura8[7]="     _/ ___ _/======| ____ \\_  __ \\_";
            figura8[8]="----------------------------------------";
            figura8[9]="Product by: TECHNOTITLAN SYSTEMS©";
            figura8[10]="Release: "+version;
            figura8[11]="Official Page: "+pageContact;
            figura8[12]="----------------------------------------";
            
            String figura9[] = new String[13];
            figura9[0]="   *        ,     _____";
            figura9[1]="                 _|▒▒_|_";
            figura9[2]="       ,       _/_/=|_\\_\\_";
            figura9[3]="             _/_ /==| _\\ _\\_";
            figura9[4]="           _/__ /===|_ _\\ __\\_";
            figura9[5]="         _/_ _ /====| ___\\  __\\_";
            figura9[6]="       _/ __ _/=====|_ ___\\ ___ \\_";
            figura9[7]="     _/ ___ _/======| ____ \\_  __ \\_";
            figura9[8]="----------------------------------------";
            figura9[9]="Product by: TECHNOTITLAN SYSTEMS©";
            figura9[10]="Release: "+version;
            figura9[11]="Official Page: "+pageContact;
            figura9[12]="----------------------------------------";
           
            String figura10[] = new String[13];
            figura10[0]="            *     _____";
            figura10[1]="   *             _|██_|_";
            figura10[2]="       *       _/_/=|_\\_\\_";
            figura10[3]="           , _/_ /==| _\\ _\\_";
            figura10[4]="           _/__ /===|_ _\\ __\\_";
            figura10[5]="   ,     _/_ _ /====| ___\\  __\\_";
            figura10[6]="       _/ __ _/=====|_ ___\\ ___ \\_";
            figura10[7]="     _/ ___ _/======| ____ \\_  __ \\_";
            figura10[8]="----------------------------------------";
            figura10[9]="Product by: TECHNOTITLAN SYSTEMS©";
            figura10[10]="Release: "+version;
            figura10[11]="Official Page: "+pageContact;
            figura10[12]="----------------------------------------";
            
            
            String figura11[] = new String[13];
            figura11[0]="       ,     ,    _____";
            figura11[1]="   .        *    _|██_|_";
            figura11[2]="   *   .       _/_/=|_\\_\\_";
            figura11[3]=" .     *   * _/_ /==| _\\ _\\_";
            figura11[4]="           _/__ /===|_ _\\ __\\_";
            figura11[5]="   *     _/_ _ /====| ___\\  __\\_";
            figura11[6]="       _/ __ _/=====|_ ___\\ ___ \\_";
            figura11[7]="     _/ ___ _/======| ____ \\_  __ \\_";
            figura11[8]="----------------------------------------";
            figura11[9]="Product by: TECHNOTITLAN SYSTEMS©";
            figura11[10]="Release: "+version;
            figura11[11]="Official Page: "+pageContact;
            figura11[12]="----------------------------------------";
            
            
            String figura12[] = new String[13];
            figura12[0]="   ,              _____";
            figura12[1]="       ,         _|██_|_";
            figura12[2]="   .        *  _/_/=|_\\_\\_";
            figura12[3]="   *   .   . _/_ /==| _\\ _\\_";
            figura12[4]=" .     *   _/__ /===|_ _\\ __\\_";
            figura12[5]="         _/_ _ /====| ___\\  __\\_";
            figura12[6]="   *   _/ __ _/=====|_ ___\\ ___ \\_";
            figura12[7]="     _/ ___ _/======| ____ \\_  __ \\_";
            figura12[8]="----------------------------------------";
            figura12[9]="Product by: TECHNOTITLAN SYSTEMS©";
            figura12[10]="Release: "+version;
            figura12[11]="Official Page: "+pageContact;
            figura12[12]="----------------------------------------";
            
            String figura13[] = new String[13];
            figura13[0]="                  _____";
            figura13[1]="       ,         _|▒▒_|_";
            figura13[2]="               _/_/=|_\\_\\_";
            figura13[3]="   .       . _/_ /==| _\\ _\\_";
            figura13[4]=" . *   .   ./__ /===|_ _\\ __\\_";
            figura13[5]="       * _/_ _ /====| ___\\  __\\_";
            figura13[6]="       _/ __ _/=====|_ ___\\ ___ \\_";
            figura13[7]="   . _/ ___ _/======| ____ \\_  __ \\_";
            figura13[8]="----------------------------------------";
            figura13[9]="Product by: TECHNOTITLAN SYSTEMS©";
            figura13[10]="Release: "+version;
            figura13[11]="Official Page: "+pageContact;
            figura13[12]="----------------------------------------";
            
            String figura14[] = new String[13];
            figura14[0]="                  _____";
            figura14[1]="                 _|▒▒_|_";
            figura14[2]="   .           _/_/=|_\\_\\_";
            figura14[3]="           . _/_ /==| _\\ _\\_";
            figura14[4]="       .   _/__ /===|_ _\\ __\\_";
            figura14[5]="   .     _/_ _ /====| ___\\  __\\_";
            figura14[6]="  .    _/ __ _/=====|_ ___\\ ___ \\_";
            figura14[7]="     _/ ___ _/======| ____ \\_  __ \\_";
            figura14[8]="----------------------------------------";
            figura14[9]="Product by: TECHNOTITLAN SYSTEMS©";
            figura14[10]="Release: "+version;
            figura14[11]="Official Page: "+pageContact;
            figura14[12]="----------------------------------------";
            
            String figura15[] = new String[13];
            figura15[0]="      ´ ´         _____";
            figura15[1]="  .        .     _|░░_|_";
            figura15[2]="               _/_/=|_\\_\\_";
            figura15[3]="             _/_ /==| _\\ _\\_";
            figura15[4]="    .      _/__ /===|_ _\\ __\\_";
            figura15[5]="         _/_ _ /====| ___\\  __\\_";
            figura15[6]="       _/ __ _/=====|_ ___\\ ___ \\_";
            figura15[7]="     _/ ___ _/======| ____ \\_  __ \\_";
            figura15[8]="----------------------------------------";
            figura15[9]="Product by: TECHNOTITLAN SYSTEMS©";
            figura15[10]="Release: "+version;
            figura15[11]="Official Page: "+pageContact;
            figura15[12]="----------------------------------------";
            
            String figura16[] = new String[13];
            figura16[0]="      ´ ´         _____";
            figura16[1]="                 _|[]_|_";
            figura16[2]="               _/_/=|_\\_\\_";
            figura16[3]="             _/_ /==| _\\ _\\_";
            figura16[4]="           _/__ /===|_ _\\ __\\_";
            figura16[5]="         _/_ _ /====| ___\\  __\\_";
            figura16[6]="       _/ __ _/=====|_ ___\\ ___ \\_";
            figura16[7]="     _/ ___ _/======| ____ \\_  __ \\_";
            figura16[8]="----------------------------------------";
            figura16[9]="Product by: TECHNOTITLAN SYSTEMS©";
            figura16[10]="Release: "+version;
            figura16[11]="Official Page: "+pageContact;
            figura16[12]="----------------------------------------";
            
            //Hacer Animaciones//
            LTKeyboard oyente = new LTKeyboard();
            oyente.startListening();
            
            
            int animActual=0;
            while(oyente.getLastVaulePressed('|')=='|'){
                ConsoleCommands.ClearScreen();
                animActual=animActual+1;
                if(animActual==1){
                    for(int i=0; i<13; i++){
                        System.out.println(figura1[i]);
                    }
                }
                if(animActual==2){
                    for(int i=0; i<13; i++){
                        System.out.println(figura2[i]);
                    }
                }
                if(animActual==3){
                    for(int i=0; i<13; i++){
                        System.out.println(figura3[i]);
                    }
                }
                if(animActual==4){
                    for(int i=0; i<13; i++){
                        System.out.println(figura4[i]);
                    }
                }
                if(animActual==5){
                    for(int i=0; i<13; i++){
                        System.out.println(figura5[i]);
                    }
                }
                if(animActual==6){
                    for(int i=0; i<13; i++){
                        System.out.println(figura6[i]);
                    }
                }
                if(animActual==7){
                    for(int i=0; i<13; i++){
                        System.out.println(figura7[i]);
                    }
                }
                if(animActual==8){
                    for(int i=0; i<13; i++){
                        System.out.println(figura8[i]);
                    }
                }
                if(animActual==9){
                    for(int i=0; i<13; i++){
                        System.out.println(figura9[i]);
                    }
                }
                if(animActual==10){
                    for(int i=0; i<13; i++){
                        System.out.println(figura10[i]);
                    }
                }
                if(animActual==11){
                    for(int i=0; i<13; i++){
                        System.out.println(figura11[i]);
                    }
                }
                if(animActual==12){
                    for(int i=0; i<13; i++){
                        System.out.println(figura12[i]);
                    }
                }
                if(animActual==13){
                    for(int i=0; i<13; i++){
                        System.out.println(figura13[i]);
                    }
                }
                if(animActual==14){
                    for(int i=0; i<13; i++){
                        System.out.println(figura14[i]);
                    }
                }
                if(animActual==15){
                    for(int i=0; i<13; i++){
                        System.out.println(figura15[i]);
                    }
                }
                if(animActual==16){
                    for(int i=0; i<13; i++){
                        System.out.println(figura16[i]);
                    }
                    animActual=0;
                }

                try {
                    Thread.sleep((long) tiempo);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Animations.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            oyente.stopListening();
        }else{
            System.out.println("ERROR en DibujaPiramide, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso DibujaMiniCraneo Terminado");
    }
    
    
    
    /**
     * Descripcion: Animacion de una Inyeccion
     *
     * @param	tiempo  Tiempo que tarda la animacion en completarse
     * @param   mensaje Mensaje a agregar a la derecha de la animacion
     */
    public static void AnimacionInyection(int tiempo, String mensaje){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
    String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//	
    if(mensaje==null){
        mensaje="";
    }
	//Comenzar Proceso//
        if(condiciones==true){
            try {
                //Generar figura//
                String figura[] = new String[11];
                
                figura[0]= "╠═════█████═--";
                figura[1]= "╠═════█████═-~";
                figura[2]= " ╠════▓████═--";
                figura[3]= " ╠════▓████═-~";
                figura[4]= "  ╠═══▒▓███═--";
                figura[5]= "  ╠═══▒▓███═-~";
                figura[6]= "   ╠══▒▒▓██═--";
                figura[7]= "   ╠══▒▒▓██═-~";
                figura[8]= "    ╠═▒▒▒▓█═--";
                figura[9]= "    ╠═▒▒▒▓█═-~";
                figura[10]= "     ╠▒▒▒▒▓═- ";
                
                //Modificar figura
                for(int i=0; i<figura.length; i++){
                    figura[i] = figura[i].concat(" "+mensaje);
                }
                
                //Calcular tiempo de espera
                float timeEspera = tiempo/figura.length;
                
                //Mostrar Figura en pantalla
                for(int i=0; i<figura.length; i++){
                    System.out.print(figura[i]);
                    ConsoleCommands.ClearLine();
                    Thread.sleep((long) timeEspera);
                }System.out.println(figura[figura.length-1]);
                    
            } catch (InterruptedException ex) {
                Logger.getLogger(Animations.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("ERROR en AnimacionInyection, motivo: "+motivo);
	}
    //Terminar Proceso//
	//System.out.println("Proceso AnimacionInyection Terminado");
    }
}