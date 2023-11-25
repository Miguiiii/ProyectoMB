/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Nodos;

/**
 *
 * @author usuario
 */
public class MBNodo {

    private Object element;
    private MBNodo leftSon, rightSon;
    private int prioridad;
    
    public MBNodo(Object element, int prioridad){
        this.element = element;
        this.leftSon = null;
        this.rightSon = null;
        this.prioridad = prioridad;
    }

    public Object getElement() {
        return element;
    }

    public int getPrioridad() {
        return prioridad;
    }
    
    public MBNodo getLeftSon() {
        return leftSon;
    }

    public void setLeftSon(MBNodo leftSon) {
        this.leftSon = leftSon;
    }

    public MBNodo getRightSon() {
        return rightSon;
    }

    public void setRightSon(MBNodo rightSon) {
        this.rightSon = rightSon;
    }
    
    public boolean isLeaf(){
        return getLeftSon() == null && getRightSon() == null;
    }
    
}
