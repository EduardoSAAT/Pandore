/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graphic;

import Algoritms.Cad;
import Dinamic.VectorString;

/**
 *
 * @author Ing Lalux
 */
public class ErrorCatcher extends javax.swing.JFrame {
    boolean state = false; //False no hay Error, True existe Error en el Systema
    Dinamic.VectorString PilaErrores;
    
    
    
    
    /**
     * Descripcion: Mostrar la pila de Error en la Ventana
     * Se muestra en caso de que existan errores, si no existen no se muestra
     */
    public void showError(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            if(state==true){
                this.setVisible(true);
            
                textMensaje.setText("");

                for(int i=0; i<PilaErrores.Longitud(); i++){
                    //Imprimri el Espacio Tabulador
                        textMensaje.append(Cad.Repeat("    ", i));
                    //Imprimir el mensaje
                        textMensaje.append(PilaErrores.getValue(i,"null Error"));
                    //Imprimir el salto de linea
                        textMensaje.append("\n");
                }
            }
        }else{
            System.out.println("ERROR en showError, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso showError Terminado con EXITO");
    	}else{
            System.out.println("Proceso showError Terminado con FALLO");
    	}
    }
    
    
    
    /**
     * Descripcion: Numeror de Errores en el Systema Actualmente
     *
     * @return	0 a n
     */
    public int numberErrors (){
    //Variables Locales e Inicializacion//
        boolean condiciones=true;
	String motivo="Indeterminado";
        int salida=0;
    //Comprobar Condiciones Iniciales//
	//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            if(state==true){
                salida=PilaErrores.Longitud();
            }
	}else{
            System.out.println("ERROR en numberErrors, motivo: "+motivo+", valor regresado: "+salida);
	}
    //Terminar Proceso//
        return salida;
    }
    
    
    
    /**
     * Descripcion: Mostrar la pila de Error en Consola
     * Se muestra en caso de que existan errores, si no existen no se muestra
     */
    public void showErrorConsole(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
	//Comenzar Proceso//
        if(condiciones==true){
            if(state==true){;
                System.out.println("Lista de Errores que Bloquean el Sistema");

                String temp="";
                for(int i=0; i<PilaErrores.Longitud(); i++){
                    //Imprimri el Espacio Tabulador
                        temp = Cad.Repeat("    ",i);
                    //Imprimir el mensaje
                        temp = temp + PilaErrores.getValue(i,"nullError");
                    //Imprimir el salto de linea
                        System.out.println(temp);
                }
            }
        }else{
            System.out.println("ERROR en showErrorConsole, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso showErrorConsole Terminado con EXITO");
    	}else{
            System.out.println("Proceso showErrorConsole Terminado con FALLO");
    	}
    }
    
    
    /**
     * Descripcion: Terminar de Monitoriar los Errores
     *
     */
    public void StopMonitoring(){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            this.dispose();
        }else{
            System.out.println("ERROR en StopMonitoring, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            System.out.println("Proceso StopMonitoring Terminado con EXITO");
    	}else{
        	System.out.println("Proceso StopMonitoring Terminado con FALLO");
    	}
    }
    
    
    /**
     * Descripcion: Agregar un Error a la Pila de Errores
     *
     * @param error Error nuevo a Agregar
     */
    public void addError(String error){
    //Variables Locales e Inicializacion//
    boolean condiciones=true;
	String motivo="Indeterminado";
    //Comprobar Condiciones Iniciales//
		//no hay condiciones Iniciales
	//Comenzar Proceso//
        if(condiciones==true){
            state=true;
            PilaErrores.addVauleRigth(error);
        }else{
            System.out.println("ERROR en addError, motivo: "+motivo);
	}
    //Terminar Proceso//
    	if(condiciones==true){
            //System.out.println("Proceso addError Terminado con EXITO");
    	}else{
            System.out.println("Proceso addError Terminado con FALLO");
    	}
    }
    
    
    
    /**
     * Creates new form Mensajes
     */
    public ErrorCatcher() {
        initComponents();
        PilaErrores = new VectorString(0);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textMensaje = new javax.swing.JTextArea();
        botonOK = new javax.swing.JButton();
        textCommando = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        textMensaje.setColumns(20);
        textMensaje.setRows(5);
        textMensaje.setTabSize(3);
        jScrollPane1.setViewportView(textMensaje);

        botonOK.setText("OK");
        botonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonOKActionPerformed(evt);
            }
        });

        textCommando.setText("Comando.....");
        textCommando.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCommandoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(textCommando)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(botonOK)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonOK)
                    .addComponent(textCommando, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textCommandoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCommandoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCommandoActionPerformed

    private void botonOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonOKActionPerformed
        this.dispose();
    }//GEN-LAST:event_botonOKActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ErrorCatcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ErrorCatcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ErrorCatcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ErrorCatcher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ErrorCatcher().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonOK;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField textCommando;
    private javax.swing.JTextArea textMensaje;
    // End of variables declaration//GEN-END:variables
}
