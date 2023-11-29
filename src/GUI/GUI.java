/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import Estructuras.*;
import Nodos.*;
import ProyectObj.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.swing_viewer.*;
import org.graphstream.ui.view.*;
import java.time.Clock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.tree.DefaultTreeCellRenderer;
/**
 *
 * @author usuario
 */
public class GUI extends javax.swing.JFrame {

    
    private Clock timer;
    private BinaryHeap<Documento> colaImpresion;
    private HashMap<String, BHNode<Documento>> mapaCola;
    private Lista<Usuario> listaUsuarios;
    private Graph monticulo;
    private File currentFile;
    private Usuario currentUser;
    DefaultTreeModel modelo;
    DefaultMutableTreeNode root;
    /**
     * Creates new form GUI
     */
    public GUI() {
        timer = Clock.systemDefaultZone();
        initComponents();
        currentFile = null;
        monticulo = new SingleGraph("Monticulo", false, true);
        colaImpresion = new BinaryHeap(20);
        listaUsuarios = new Lista();
        mapaCola = new HashMap(10);
        Viewer viewer = new SwingViewer(monticulo, Viewer.ThreadingModel.GRAPH_IN_ANOTHER_THREAD);
        viewer.enableAutoLayout();
        View view = viewer.addDefaultView(false);
        view.openInAFrame(false);
        graphDisplay.setLayout(new BorderLayout());
        graphDisplay.add((Component)view);
        usersTree.setRootVisible(false);
        sistemaPrincipal.setVisible(false);
        userSelection.setVisible(true);
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        agregarUsuarioVisible(false,"");
        userSelection.validate();
        prioridadAltaButton.setActionCommand("prioridad_alta");
        prioridadMediaButton.setActionCommand("prioridad_media");
        prioridadBajaButton.setActionCommand("prioridad_baja");
        escribirCola();
    }

    private void setUserOptions() {
        elegirUsuario.removeAll();
        for (int i=0; i < listaUsuarios.getLength(); i++) {
            elegirUsuario.insert(listaUsuarios.getElmenetAtIndex(i).getName(), i);
        }
    }
    
    private void setDeletePrintDocOptions() {
        deleteDocChoice.removeAll();
        printChoice.removeAll();
        for (int i=0; i < currentUser.getDocumentos().getLength(); i++) {
            deleteDocChoice.insert(currentUser.getDocumentos().getElmenetAtIndex(i).getName()+"."+currentUser.getDocumentos().getElmenetAtIndex(i).getType(), i);
            printChoice.insert(currentUser.getDocumentos().getElmenetAtIndex(i).getName()+"."+currentUser.getDocumentos().getElmenetAtIndex(i).getType(), i);
        }
    }

    private void setDeleteFromHeapOptions() {
        deleteFromHeapChoice.removeAll();
        Lista<BHNode<Documento>> inHeap = mapaCola.getValuesOfKey(currentUser.getName());
        if (inHeap == null) {
            return;
        }
        for (int i = 0; i < inHeap.getLength(); i++) {
            Documento item = inHeap.getElmenetAtIndex(i).getElement();
            deleteFromHeapChoice.insert(item.getName()+"."+item.getType(), i);
        }
    }
    
    private void agregarUsuarioVisible(boolean show, String label) {
        tiposPrioridad.clearSelection();
        nombreUsuario.setText("");
        prioridadAltaButton.setVisible(show);
        prioridadMediaButton.setVisible(show);
        prioridadBajaButton.setVisible(show);
        confirmarAgregar.setVisible(show);
        cancelarAgregar.setVisible(show);
        nombreUsuario.setVisible(show);
        addUserLabel.setVisible(show);
        SelectionLabel.setText(label);
    }
    
    private void setUserDisplay() {
//        usersDisplay.removeAll();
        modelo = (DefaultTreeModel) usersTree.getModel();
        DefaultMutableTreeNode raiz = (DefaultMutableTreeNode) modelo.getRoot();
        raiz.removeAllChildren();
        
        for (Usuario u:listaUsuarios) {
            DefaultMutableTreeNode usuario = new DefaultMutableTreeNode(u.getName());
            raiz.add(usuario);
            for (Documento d: u.getDocumentos()) {
                DefaultMutableTreeNode doc = new DefaultMutableTreeNode(d.getName());
                usuario.add(doc);
                doc.add(new DefaultMutableTreeNode(d.getType()));
                doc.add(new DefaultMutableTreeNode(d.getSize() + " páginas"));
                Lista<BHNode<Documento>> inHeap = mapaCola.getValuesOfKey(currentUser.getName());
                if (inHeap != null) {
                    for (int i = 0; i < inHeap.getLength(); i++) {
                        if (inHeap.getElmenetAtIndex(i).getElement().equals(d)) {
                            doc.add(new DefaultMutableTreeNode("Imprimiendo"));
                        }
                    }
                }
            }
        }
        modelo.reload();
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
        textArea1 = new java.awt.TextArea();
        displaysPane = new javax.swing.JTabbedPane();
        treeDisplay = new javax.swing.JSplitPane();
        usersTreeLeyend = new javax.swing.JPanel();
        usersTreePane = new javax.swing.JScrollPane();
        usersTree = new javax.swing.JTree();
        graphDisplay = new javax.swing.JPanel();
        colaDisplay = new javax.swing.JPanel();
        colaImpresoraLabel = new java.awt.TextArea();
        panelFondo = new javax.swing.JPanel();
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
        SelectionLabel = new java.awt.Label();
        addUserLabel = new java.awt.Label();
        sistemaPrincipal = new javax.swing.JPanel();
        signOut = new java.awt.Button();
        deleteFromHeap = new java.awt.Button();
        deleteDoc = new java.awt.Button();
        printChoice = new java.awt.Choice();
        sendToPrint = new java.awt.Button();
        deleteFromHeapChoice = new java.awt.Choice();
        printMin = new java.awt.Button();
        isPrioritario = new java.awt.Checkbox();
        newDocName = new java.awt.TextField();
        newDocType = new java.awt.TextField();
        newDocSize = new java.awt.TextField();
        addDocument = new java.awt.Button();
        deleteDocChoice = new java.awt.Choice();
        addDocNameLabel = new java.awt.Label();
        selectedUserLabel = new java.awt.Label();
        addDocTypeLabel = new java.awt.Label();
        addDocSizeLabel = new java.awt.Label();
        systemMessage = new java.awt.Label();
        cancelAddDocument = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 425));

        javax.swing.GroupLayout usersTreeLeyendLayout = new javax.swing.GroupLayout(usersTreeLeyend);
        usersTreeLeyend.setLayout(usersTreeLeyendLayout);
        usersTreeLeyendLayout.setHorizontalGroup(
            usersTreeLeyendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        usersTreeLeyendLayout.setVerticalGroup(
            usersTreeLeyendLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );

        treeDisplay.setLeftComponent(usersTreeLeyend);

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("Users");
        usersTree.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        usersTreePane.setViewportView(usersTree);

        treeDisplay.setRightComponent(usersTreePane);

        displaysPane.addTab("Usuarios y Documentos", treeDisplay);

        javax.swing.GroupLayout graphDisplayLayout = new javax.swing.GroupLayout(graphDisplay);
        graphDisplay.setLayout(graphDisplayLayout);
        graphDisplayLayout.setHorizontalGroup(
            graphDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
        );
        graphDisplayLayout.setVerticalGroup(
            graphDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 388, Short.MAX_VALUE)
        );

        displaysPane.addTab("Montículo Binario", graphDisplay);

        colaImpresoraLabel.setEditable(false);

        javax.swing.GroupLayout colaDisplayLayout = new javax.swing.GroupLayout(colaDisplay);
        colaDisplay.setLayout(colaDisplayLayout);
        colaDisplayLayout.setHorizontalGroup(
            colaDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(colaImpresoraLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
        );
        colaDisplayLayout.setVerticalGroup(
            colaDisplayLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(colaImpresoraLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
        );

        displaysPane.addTab("Cola Impresora", colaDisplay);

        panelFondo.setLayout(new java.awt.CardLayout());

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
        prioridadAltaButton.setSelected(false);
        prioridadAltaButton.setText("Prioridad Alta");

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

        nombreUsuario.setName("Nombre del Usuario"); // NOI18N

        addUserLabel.setText("Nombre del usuario:");

        javax.swing.GroupLayout userSelectionLayout = new javax.swing.GroupLayout(userSelection);
        userSelection.setLayout(userSelectionLayout);
        userSelectionLayout.setHorizontalGroup(
            userSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userSelectionLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(archivoUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(guardarUsarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userSelectionLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(userSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(userSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userSelectionLayout.createSequentialGroup()
                                .addComponent(confirmarAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(cancelarAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(72, 72, 72))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userSelectionLayout.createSequentialGroup()
                                .addComponent(elegirUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(eliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)))
                        .addGroup(userSelectionLayout.createSequentialGroup()
                            .addGroup(userSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(userSelectionLayout.createSequentialGroup()
                                    .addGap(109, 109, 109)
                                    .addComponent(signIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(userSelectionLayout.createSequentialGroup()
                                    .addGroup(userSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(SelectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(userSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(prioridadMediaButton)
                                        .addComponent(prioridadBajaButton)
                                        .addComponent(prioridadAltaButton))))
                            .addGap(34, 34, 34)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userSelectionLayout.createSequentialGroup()
                        .addComponent(agregarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(117, 117, 117))))
        );
        userSelectionLayout.setVerticalGroup(
            userSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, userSelectionLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(userSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(guardarUsarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(archivoUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(agregarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(userSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(userSelectionLayout.createSequentialGroup()
                        .addComponent(prioridadAltaButton)
                        .addGap(13, 13, 13)
                        .addComponent(prioridadMediaButton)
                        .addGap(16, 16, 16)
                        .addComponent(prioridadBajaButton))
                    .addGroup(userSelectionLayout.createSequentialGroup()
                        .addComponent(addUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SelectionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(userSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cancelarAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmarAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(userSelectionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(elegirUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(signIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(197, 197, 197))
        );

        panelFondo.add(userSelection, "card2");

        signOut.setLabel("Cerrar Sesión");
        signOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signOutActionPerformed(evt);
            }
        });

        deleteFromHeap.setLabel("Elimiar documento de la cola");
        deleteFromHeap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteFromHeapActionPerformed(evt);
            }
        });

        deleteDoc.setLabel("Eliminar Documento");
        deleteDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteDocActionPerformed(evt);
            }
        });

        sendToPrint.setLabel("Imprimir");
        sendToPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendToPrintActionPerformed(evt);
            }
        });

        printMin.setLabel("Liberar Impresora");
        printMin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printMinActionPerformed(evt);
            }
        });

        isPrioritario.setLabel("Prioritario");

        addDocument.setLabel("Crear Documento");
        addDocument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDocumentActionPerformed(evt);
            }
        });

        addDocNameLabel.setText("Nombre");

        selectedUserLabel.setAlignment(java.awt.Label.CENTER);

        addDocTypeLabel.setText("Tipo");

        addDocSizeLabel.setText("Páginas");

        cancelAddDocument.setLabel("Cancelar");
        cancelAddDocument.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelAddDocumentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout sistemaPrincipalLayout = new javax.swing.GroupLayout(sistemaPrincipal);
        sistemaPrincipal.setLayout(sistemaPrincipalLayout);
        sistemaPrincipalLayout.setHorizontalGroup(
            sistemaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sistemaPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sistemaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sistemaPrincipalLayout.createSequentialGroup()
                        .addGroup(sistemaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addDocNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addDocTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addDocSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(sistemaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(newDocSize, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(newDocType, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(newDocName, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addGroup(sistemaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addDocument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(sistemaPrincipalLayout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(cancelAddDocument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(71, 71, 71))
                    .addGroup(sistemaPrincipalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(sistemaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(systemMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteDocChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(sistemaPrincipalLayout.createSequentialGroup()
                .addGroup(sistemaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sistemaPrincipalLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(sistemaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(deleteDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(sistemaPrincipalLayout.createSequentialGroup()
                                .addComponent(printChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(isPrioritario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sendToPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(sistemaPrincipalLayout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(printMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
            .addGroup(sistemaPrincipalLayout.createSequentialGroup()
                .addGroup(sistemaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sistemaPrincipalLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(signOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sistemaPrincipalLayout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(sistemaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteFromHeapChoice, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(deleteFromHeap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(selectedUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        sistemaPrincipalLayout.setVerticalGroup(
            sistemaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sistemaPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(selectedUserLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(printMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(sistemaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(sistemaPrincipalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(sistemaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(sistemaPrincipalLayout.createSequentialGroup()
                                .addGroup(sistemaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newDocName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addDocNameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addGroup(sistemaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newDocType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(addDocTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addComponent(newDocSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(addDocSizeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(sistemaPrincipalLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(addDocument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelAddDocument, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(23, 23, 23)
                .addComponent(systemMessage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sistemaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(deleteDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteDocChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(sistemaPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sendToPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(isPrioritario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteFromHeapChoice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteFromHeap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        panelFondo.add(sistemaPrincipal, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(displaysPane)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(displaysPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        displaysPane.getAccessibleContext().setAccessibleName("tab1");

        pack();
        setLocationRelativeTo(null);
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
                    listaUsuarios.insertFinal(newUser);
                    line = br.readLine();
                }
                setUserOptions();
                br.close();
                setUserDisplay();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_archivoUsuariosActionPerformed

    private void agregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarUsuarioActionPerformed
        // TODO add your handling code here:
        agregarUsuarioVisible(true, "");
    }//GEN-LAST:event_agregarUsuarioActionPerformed

    private void signInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInActionPerformed
        // TODO add your handling code here:
        if (elegirUsuario.getItemCount() == 0) {
            SelectionLabel.setText("Eliga un usuario válido");
            return;
        }
        currentUser = listaUsuarios.getElmenetAtIndex(elegirUsuario.getSelectedIndex());
        userSelection.setVisible(false);
        sistemaPrincipal.setVisible(true);
        selectedUserLabel.setText("Inició sesión como " + currentUser.getName());
        newDocName.setText("");
        newDocType.setText("");
        newDocSize.setText("");
        systemMessage.setText("");
    }//GEN-LAST:event_signInActionPerformed

    private void guardarUsariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarUsariosActionPerformed
        
        
        BufferedWriter writer = null;
        try {
            // TODO add your handling code here:
            String newCSV = "usuario, tipo";
            for (Usuario i:listaUsuarios) {
                newCSV += "\n" + i.getName() + ", " + i.getPrioridad();
            }
            if (currentFile == null) {
                JFileChooser dirChooser = new JFileChooser();
                dirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                
                int r = dirChooser.showOpenDialog(null);
                if (r == JFileChooser.APPROVE_OPTION) {
                    System.out.println(dirChooser.getSelectedFile().getName());
                    currentFile = dirChooser.getSelectedFile();
                    if (!currentFile.getName().toLowerCase().endsWith(".csv")) {
                        currentFile = new File(currentFile.getParentFile(), currentFile.getName() + ".csv");
                    }
                }
            }
            
            writer = new BufferedWriter(new FileWriter(currentFile));
            writer.write(newCSV);
            writer.close();
            
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                writer.close();
                SelectionLabel.setText("Usuarios guardados");
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
            SelectionLabel.setText("Usuario " + eliminado.getName() + " eliminado");
            setUserDisplay();
        } else {
            SelectionLabel.setText("No se ha elegido a un usuario");
        }
    }//GEN-LAST:event_eliminarUsuarioActionPerformed

    private void cancelarAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarAgregarActionPerformed
        // TODO add your handling code here:
        agregarUsuarioVisible(false, "Se ha cancelado la operación");
    }//GEN-LAST:event_cancelarAgregarActionPerformed

    private void confirmarAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmarAgregarActionPerformed
        // TODO add your handling code here:
        if (tiposPrioridad.getSelection() != null && !nombreUsuario.getText().isEmpty()) {
            if (nombreUsuario.getText().contains(" ")) {
                SelectionLabel.setText("Usuario inválido");
                return;
            }
            listaUsuarios.insertFinal(new Usuario(nombreUsuario.getText(), tiposPrioridad.getSelection().getActionCommand()));
            agregarUsuarioVisible(false, "Usuario " + nombreUsuario.getText() + " agregado");
            setUserOptions();
            setUserDisplay();
        } else {
            SelectionLabel.setText("Rellene todos los campos");
        }
    }//GEN-LAST:event_confirmarAgregarActionPerformed

    private void signOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signOutActionPerformed
        // TODO add your handling code here:
        sistemaPrincipal.setVisible(false);
        userSelection.setVisible(true);
    }//GEN-LAST:event_signOutActionPerformed

    private void sendToPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendToPrintActionPerformed
        // TODO add your handling code here:
        int imprimir = printChoice.getSelectedIndex();
        if (imprimir != -1) {
            int prioridad = (int) timer.millis();
            if (isPrioritario.getState()) {
                if (currentUser.getPrioridad() == "prioridad_alta") {
                    prioridad -= 10000;
                } else if (currentUser.getPrioridad() == "prioridad_media") {
                    prioridad -= 5000;
                } else if (currentUser.getPrioridad() == "prioridad_baja") {
                    prioridad -= 1000;
                }
            }
            BHNode<Documento> nodo = new BHNode(currentUser.getDocumentos().getElmenetAtIndex(printChoice.getSelectedIndex()), prioridad);
            colaImpresion.insert(currentUser.getDocumentos().getElmenetAtIndex(printChoice.getSelectedIndex()), prioridad);
            mapaCola.put(currentUser.getName(), nodo);
            setDeleteFromHeapOptions();
            setUserDisplay();
            graficarCola();
            escribirCola();
        } else {
            systemMessage.setText("Este usuario no tiene documentos");
        }
    }//GEN-LAST:event_sendToPrintActionPerformed

    private void printMinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printMinActionPerformed
        // TODO add your handling code here:
        Documento extraido = colaImpresion.extractMin();
        if (extraido == null) {
            systemMessage.setText("La cola de impresión está vacía");
            return;
        }
        systemMessage.setText("Se imprimió el documento " + colaImpresion.extractMin().getName());
        graficarCola();
        escribirCola();
        setUserDisplay();
    }//GEN-LAST:event_printMinActionPerformed

    private void addDocumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDocumentActionPerformed
        // TODO add your handling code here:
        if (!newDocName.getText().isBlank() && !newDocType.getText().isBlank() && !newDocSize.getText().isBlank()) {
            Integer size;
            try {
                size = Integer.valueOf(newDocSize.getText());
            } catch (NumberFormatException e) {
                systemMessage.setText("El campo 'Páginas' tiene que contener números");
                return;
            }
            currentUser.addDocument(newDocName.getText(), newDocType.getText(), size);
            setUserDisplay();
            setDeletePrintDocOptions();
            newDocName.setText("");
            newDocType.setText("");
            newDocSize.setText("");
            systemMessage.setText("Documento " + newDocName.getText() + "añadido");
        } else {
            systemMessage.setText("Rellene todos los campos");
        }
    }//GEN-LAST:event_addDocumentActionPerformed

    private void cancelAddDocumentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelAddDocumentActionPerformed
        // TODO add your handling code here:
        newDocName.setText("");
        newDocType.setText("");
        newDocSize.setText("");
        systemMessage.setText("Operación Cancelada");
    }//GEN-LAST:event_cancelAddDocumentActionPerformed

    private void deleteDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteDocActionPerformed
        // TODO add your handling code here:
        int eliminar = deleteDocChoice.getSelectedIndex();
        if (eliminar != -1) {
            Documento eliminado = currentUser.getDocumentos().getElmenetAtIndex(eliminar);
            currentUser.getDocumentos().deleteAtIndex(eliminar);
            setDeletePrintDocOptions();
            setUserDisplay();
            systemMessage.setText("Se ha eliminado el documento "+eliminado.getName()+"."+eliminado.getType());
        } else {
            systemMessage.setText("Este usuario no tiene documentos");
        }
    }//GEN-LAST:event_deleteDocActionPerformed

    private void deleteFromHeapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteFromHeapActionPerformed
        // TODO add your handling code here:
        int eliminar = deleteFromHeapChoice.getSelectedIndex();
        if (eliminar != -1) {
            BHNode extraer = mapaCola.getValuesOfKey(currentUser.getName()).getElmenetAtIndex(eliminar);
            Documento extraido = colaImpresion.extractElement(extraer);
            if (extraido == null) {
                systemMessage.setText("Este archivo no se encuentra en la cola");
            } else {
                systemMessage.setText("Se ha eliminado "+extraido.getName()+"."+extraido.getType()+" de la cola");
                setUserDisplay();
                graficarCola();
                escribirCola();
                setDeleteFromHeapOptions();
            }
        } else {
            systemMessage.setText("Este usuario no tiene documentos en la cola");
        }
        
    }//GEN-LAST:event_deleteFromHeapActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        System.setProperty("org.graphstream.ui", "swing");
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
        monticulo.clear();
        
        ListaArray<BHNode<Documento>> heap = colaImpresion.getHeap();
        for (int i = 0; i < heap.getSize(); i++) {
            Documento doc = heap.getElmenetAtIndex(0).getElement();
            if (monticulo.getNode(doc.getName()) == null) {
                monticulo.addNode(doc.getName());
            }
            Node actual = monticulo.getNode(doc.getName());
            actual.setAttribute("ui.label", doc.getName());
            if (colaImpresion.leftChild(i) < colaImpresion.getSize()) {
                Documento leftSon = heap.getElmenetAtIndex(colaImpresion.leftChild(i)).getElement();
                monticulo.addEdge(doc.getName()+leftSon.getName(), doc.getName(), leftSon.getName());
            }
            if (colaImpresion.rightChild(i) < colaImpresion.getSize()) {
                Documento rightSon = heap.getElmenetAtIndex(colaImpresion.rightChild(i)).getElement();
                monticulo.addEdge(doc.getName()+rightSon.getName(), doc.getName(), rightSon.getName());
            }
        }
    }
    
    public void escribirCola() {
        ListaArray<BHNode<Documento>> cola = colaImpresion.getHeap();
        String colaText = "";
        if (cola.getSize() == 0) {
            colaImpresoraLabel.setText("La cola de impresión se encuentra vacía");
            return;
        }
        for (int i = 0; i < cola.getSize(); i++) {
            colaText += i+1+". ";
            colaText += cola.getElmenetAtIndex(i).getElement().getName()+"."+cola.getElmenetAtIndex(i).getElement().getType();
            colaText += " - "+cola.getElmenetAtIndex(i).getElement().getSize()+"hojas\n";
        }
        colaImpresoraLabel.setText(colaText);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Label SelectionLabel;
    private java.awt.Label addDocNameLabel;
    private java.awt.Label addDocSizeLabel;
    private java.awt.Label addDocTypeLabel;
    private java.awt.Button addDocument;
    private java.awt.Label addUserLabel;
    private java.awt.Button agregarUsuario;
    private java.awt.Button archivoUsuarios;
    private java.awt.Button cancelAddDocument;
    private java.awt.Button cancelarAgregar;
    private javax.swing.JPanel colaDisplay;
    private java.awt.TextArea colaImpresoraLabel;
    private java.awt.Button confirmarAgregar;
    private java.awt.Button deleteDoc;
    private java.awt.Choice deleteDocChoice;
    private java.awt.Button deleteFromHeap;
    private java.awt.Choice deleteFromHeapChoice;
    private javax.swing.JTabbedPane displaysPane;
    private java.awt.Choice elegirUsuario;
    private java.awt.Button eliminarUsuario;
    private javax.swing.JPanel graphDisplay;
    private java.awt.Button guardarUsarios;
    private java.awt.Checkbox isPrioritario;
    private java.awt.TextField newDocName;
    private java.awt.TextField newDocSize;
    private java.awt.TextField newDocType;
    private java.awt.TextField nombreUsuario;
    private javax.swing.JPanel panelFondo;
    private java.awt.Choice printChoice;
    private java.awt.Button printMin;
    private javax.swing.JRadioButton prioridadAltaButton;
    private javax.swing.JRadioButton prioridadBajaButton;
    private javax.swing.JRadioButton prioridadMediaButton;
    private java.awt.Label selectedUserLabel;
    private java.awt.Button sendToPrint;
    private java.awt.Button signIn;
    private java.awt.Button signOut;
    private javax.swing.JPanel sistemaPrincipal;
    private java.awt.Label systemMessage;
    private java.awt.TextArea textArea1;
    private javax.swing.ButtonGroup tiposPrioridad;
    private javax.swing.JSplitPane treeDisplay;
    private javax.swing.JPanel userSelection;
    private javax.swing.JTree usersTree;
    private javax.swing.JPanel usersTreeLeyend;
    private javax.swing.JScrollPane usersTreePane;
    // End of variables declaration//GEN-END:variables
}
