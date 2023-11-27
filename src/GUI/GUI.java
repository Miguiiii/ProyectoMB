/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import Estructuras.*;
import Nodos.*;
import ProyectObj.*;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.swing_viewer.*;
import org.graphstream.ui.view.*;
import java.time.Clock;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author usuario
 */
public class GUI extends javax.swing.JFrame {

    
    private Clock timer;
    private BinaryHeap<Documento> colaImpresion;
    private Lista<Usuario> listaUsuarios;
    private Graph monticulo;
    private File currentFile;
    /**
     * Creates new form GUI
     */
    public GUI() {
        timer = Clock.systemDefaultZone();
        colaImpresion = new BinaryHeap(20);
        listaUsuarios = new Lista();
        monticulo = new SingleGraph("Cola de prioridad");
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        agregarUsuarioVisible(false);
        userSelection.validate();
        prioridadAltaButton.setActionCommand("prioridad_alta");
        prioridadMediaButton.setActionCommand("prioridad_media");
        prioridadBajaButton.setActionCommand("prioridad_baja");
    }

    private void setUserOptions() {
        elegirUsuario.removeAll();
        for (int i=0; i < listaUsuarios.getLength(); i++) {
            elegirUsuario.insert(listaUsuarios.getElmenetAtIndex(i).getName(), i);
        }
    }
    
    private void agregarUsuarioVisible(boolean show) {
        prioridadAltaButton.setVisible(show);
        prioridadMediaButton.setVisible(show);
        prioridadBajaButton.setVisible(show);
        confirmarAgregar.setVisible(show);
        cancelarAgregar.setVisible(show);
        nombreUsuario.setVisible(show);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tiposPrioridad = new javax.swing.ButtonGroup();
        userSelection = new javax.swing.JPanel();
        elegirUsuario = new java.awt.Choice();
        archivoUsuarios = new java.awt.Button();
        agregarUsuario = new java.awt.Button();
        eliminarUsuario = new java.awt.Button();
        signIn = new java.awt.Button();
        guardarUsarios = new java.awt.Button();
        prioridadAltaButton = new javax.swing.JRadioButton();
        prioridadMediaButton = new javax.swing.JRadioButton();
        prioridadBajaButton = new javax.swing.JRadioButton();
        confirmarAgregar = new java.awt.Button();
        cancelarAgregar = new java.awt.Button();
        nombreUsuario = new java.awt.TextField();
        graphDisplay = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        elegirUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        elegirUsuario.setName(""); // NOI18N

        archivoUsuarios.setActionCommand("elegirArchivo");
        archivoUsuarios.setLabel("Cargar Usuarios");
        archivoUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivoUsuariosActionPerformed(evt);
            }
        });

        agregarUsuario.setLabel("Agregar Usuario");
        agregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarUsuarioActionPerformed(evt);
            }
        });

        eliminarUsuario.setLabel("Eliminar Usuario");
        eliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarUsuarioActionPerformed(evt);
            }
        });

        signIn.setLabel("Iniciar Sesion");
        signIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInActionPerformed(evt);
            }
        });

        guardarUsarios.setLabel("Guardar Usarios");
        guardarUsarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarUsariosActionPerformed(evt);
            }
        });

        tiposPrioridad.add(prioridadAltaButton);
        prioridadAltaButton.setText("Prioridad Alta");
        prioridadAltaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prioridadAltaButtonActionPerformed(evt);
            }
        });

        tiposPrioridad.add(prioridadMediaButton);
        prioridadMediaButton.setText("Prioridad Media");

        tiposPrioridad.add(prioridadBajaButton);
        prioridadBajaButton.setText("Prioridad Baja");

        confirmarAgregar.setLabel("Agregar");
        confirmarAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmarAgregarActionPerformed(evt);
            }
        });

        cancelarAgregar.setLabel("Cancelar");
        cancelarAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarAgregarActionPerformed(evt);
            }
        });

        nombreUsuario.setText("Nombre del Usuario");

        javax.swing.GroupLayout userSelectionLayout = new javax.swing.GroupLayout(userSelection);
        userSelection.setLayout(userSelectionLayout);
        userSelectionLayout.setHorizontalGroup(
            userSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userSelectionLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addComponent(archivoUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(guardarUsarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userSelectionLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(userSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userSelectionLayout.createSequentialGroup()
                        .addComponent(elegirUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(eliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userSelectionLayout.createSequentialGroup()
                        .addComponent(agregarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(143, 143, 143))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userSelectionLayout.createSequentialGroup()
                        .addComponent(signIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(141, 141, 141))
                    .addGroup(userSelectionLayout.createSequentialGroup()
                        .addGroup(userSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(userSelectionLayout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(confirmarAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userSelectionLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addGroup(userSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cancelarAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(userSelectionLayout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(userSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(prioridadMediaButton)
                                    .addComponent(prioridadBajaButton)
                                    .addComponent(prioridadAltaButton))))
                        .addGap(10, 10, 10))))
        );
        userSelectionLayout.setVerticalGroup(
            userSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userSelectionLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(userSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(guardarUsarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(archivoUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(agregarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(prioridadAltaButton)
                .addGap(13, 13, 13)
                .addGroup(userSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prioridadMediaButton)
                    .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(prioridadBajaButton)
                .addGap(24, 24, 24)
                .addGroup(userSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cancelarAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmarAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(userSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(elegirUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(eliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(signIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout graphDisplayLayout = new javax.swing.GroupLayout(graphDisplay);
        graphDisplay.setLayout(graphDisplayLayout);
        graphDisplayLayout.setHorizontalGroup(
            graphDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 385, Short.MAX_VALUE)
        );
        graphDisplayLayout.setVerticalGroup(
            graphDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(graphDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(userSelection, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(graphDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void archivoUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivoUsuariosActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setAcceptAllFileFilterUsed(false);
        fileChooser.setDialogTitle("Elija un archivo .csv con los usuarios");
        FileNameExtensionFilter restrict = new FileNameExtensionFilter("Only .csv files", "csv");
        fileChooser.addChoosableFileFilter(restrict);
        int r = fileChooser.showOpenDialog(null);
        if (r == JFileChooser.APPROVE_OPTION) {
            try {
                currentFile = new File(fileChooser.getSelectedFile().getAbsolutePath());
                BufferedReader br = new BufferedReader(new FileReader(currentFile));
                String line = br.readLine();
                line = br.readLine();
                while (line != null) {
                    String[] array = line.split(",");
                    Usuario newUser = new Usuario(array[0].strip(), array[1].strip());
                    System.out.println(array[0]+":"+array[1]);
                    listaUsuarios.insertFinal(newUser);
                    line = br.readLine();
                }
                setUserOptions();
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_archivoUsuariosActionPerformed

    private void agregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarUsuarioActionPerformed
        // TODO add your handling code here:
        agregarUsuarioVisible(true);
    }//GEN-LAST:event_agregarUsuarioActionPerformed

    private void signInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInActionPerformed
        // TODO add your handling code here:
        if (tiposPrioridad.getSelection() != null) {
            System.out.println(tiposPrioridad.getSelection().getActionCommand());
        }
        userSelection.setVisible(false);
    }//GEN-LAST:event_signInActionPerformed

    private void guardarUsariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarUsariosActionPerformed
        BufferedWriter writer = null;
        try {
            // TODO add your handling code here:
            String newCSV = "usuario, tipo";
            for (Usuario i:listaUsuarios) {
                newCSV += "\n" + i.getName() + ", " + i.getPrioridad();
            }   writer = new BufferedWriter(new FileWriter(currentFile));
            writer.write(newCSV);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_guardarUsariosActionPerformed

    private void eliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarUsuarioActionPerformed
        // TODO add your handling code here:
        int eliminar = elegirUsuario.getSelectedIndex();
        if (eliminar != -1) {
            Usuario eliminado = listaUsuarios.getElmenetAtIndex(eliminar);
            listaUsuarios.deleteAtIndex(eliminar);
            setUserOptions();
            System.out.println("Se ha eliminado al usuario " + eliminado.getName());
        } else {
            System.out.println("No se ha elegido a un usuario");
        }
    }//GEN-LAST:event_eliminarUsuarioActionPerformed

    private void prioridadAltaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prioridadAltaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_prioridadAltaButtonActionPerformed

    private void cancelarAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarAgregarActionPerformed
        // TODO add your handling code here:
        agregarUsuarioVisible(false);
    }//GEN-LAST:event_cancelarAgregarActionPerformed

    private void confirmarAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarAgregarActionPerformed
        // TODO add your handling code here:
        if (tiposPrioridad.getSelection() != null) {
            System.out.println(tiposPrioridad.getSelection().getActionCommand());
        }
        
        agregarUsuarioVisible(false);
    }//GEN-LAST:event_confirmarAgregarActionPerformed

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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                Clock timer = Clock.systemDefaultZone();
//                new GUI().setVisible(true);
//                BinaryHeap<Documento> colaImpresion = new BinaryHeap(20);
//                Lista<Usuario> listaUsuarios = new Lista();
//                Graph monticulo = new SingleGraph("Cola de prioridad");
                GUI app = new GUI();
                app.setSize(780, 420);
                app.setDefaultCloseOperation(GUI.EXIT_ON_CLOSE);
                app.setVisible(true);
                app.setLocationRelativeTo(null);
//                GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
//                GraphicsDevice device = graphics.getDefaultScreenDevice();
//                device.setFullScreenWindow(app);
            }
        });
    }
    
    public void graficarCola() {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button agregarUsuario;
    private java.awt.Button archivoUsuarios;
    private java.awt.Button cancelarAgregar;
    private java.awt.Button confirmarAgregar;
    private java.awt.Choice elegirUsuario;
    private java.awt.Button eliminarUsuario;
    private javax.swing.JPanel graphDisplay;
    private java.awt.Button guardarUsarios;
    private java.awt.TextField nombreUsuario;
    private javax.swing.JRadioButton prioridadAltaButton;
    private javax.swing.JRadioButton prioridadBajaButton;
    private javax.swing.JRadioButton prioridadMediaButton;
    private java.awt.Button signIn;
    private javax.swing.ButtonGroup tiposPrioridad;
    private javax.swing.JPanel userSelection;
    // End of variables declaration//GEN-END:variables
}
