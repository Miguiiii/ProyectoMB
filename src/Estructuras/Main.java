/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Estructuras;
import InterfazGráfica.Panel;
import ProyectObj.*;

/**
 *
 * @author usuario
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
//        System.out.println("Hello World");
//        Lista<Documento> lDocumentos = new Lista();
//        Documento doc = new Documento("Tarea 1", "pdf", 4);
//        System.out.println(doc.getName());
//        lDocumentos.insertFinal(doc);
//        doc = new Documento("Tarea 2", "excel", 1);
//        System.out.println(doc.getName());
//        lDocumentos.insertFinal(doc);
//        doc = new Documento("Tarea 3", "word", 3);
//        System.out.println(doc.getName());
//        lDocumentos.insertFinal(doc);
//        
//        for (Documento i: lDocumentos) {
//            System.out.println(i.getType());
//        }
          
          ListaArray<String> list = new ListaArray(5);
          String var = "Hello";
          for (int i = 0; i<5; i++) {
              list.insertBegin(var);
              var += "o";
          }
          System.out.println(list.getSize());
          System.out.println("In Order");
          list.print();
          System.out.println("\nIn Memory");
          list.printInMemory();
          System.out.println("\nDelete");
          list.deleteBegin();
          System.out.println(list.getSize());
          list.insertBegin("HI");
          System.out.println(list.getSize());
          System.out.println("In Order");
          list.print();
          System.out.println("\nIn Memory");
          list.printInMemory();
          

//            String ex = "Vincenzo";
//            System.out.println(ex.hashCode());
//            System.out.println(Math.abs(ex.hashCode()));
//            System.out.println(Math.abs(ex.hashCode())%20);

    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });
    }
    
}
