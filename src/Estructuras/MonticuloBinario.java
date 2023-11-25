/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Estructuras;
import Nodos.MBNodo;
/**
 *
 * @author usuario
 */
public class MonticuloBinario {
    
    private MBNodo root;

    public MonticuloBinario(MBNodo root) {
        this.root = root;
    }

    public MBNodo getRoot() {
        return root;
    }

    public void setRoot(MBNodo root) {
        this.root = root;
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    private MBNodo recursiveInsert(MBNodo nodo){
        return null;
    }
    
    public void insert(Object element, int prioridad){
        MBNodo nodo = new MBNodo(element, prioridad);
        if (isEmpty()){
            setRoot(nodo);
        } else {
            recursiveInsert(nodo);
        }
    }
    
}
