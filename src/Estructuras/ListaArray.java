/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Estructuras;
import Nodos.NodoArray;
/**
 *
 * @author usuario
 */
public class ListaArray<T> {

    private Integer head;
    private int maxSize;
    private int size;
    private NodoArray<T>[] array;

    public ListaArray(int maxSize) {
        this.head = null;
        this.maxSize = maxSize;
        this.size = 0;
        this.array = new NodoArray[0];
    }

    public Integer getHead() {
        return head;
    }

    public void setHead(Integer head) {
        this.head = head;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public NodoArray[] getArray() {
        return array;
    }

    public void setArray(NodoArray[] array) {
        this.array = array;
    }
    
    public boolean isEmpty() {
        return getHead() == null;
    }
    
    private int searchSpace() {
        for (int i = 0; i < getArray().length; i++) {
            if(getArray()[i] == null) {
                return i;
            }
        }
        return -1;
    }
    
    public void insertBegin(T element) {
        NodoArray<T> nodo = new NodoArray(element);
        if (isEmpty()) {
            if (getArray().length == 0) {
                setArray(new NodoArray[1]);
                getArray()[0] = nodo;
                setHead(0);
                size++;
            }
        } else if (getSize() == getMaxSize()) {
            System.out.println("El maximo tamaño ya fue alcanzado");
        } else {
            int position = searchSpace();
            if (position != -1) {
                nodo.setNext(getHead());
                getArray()[position] = nodo;
                setHead(position);
            } else {
                NodoArray[] newArray = new NodoArray[getSize() + 1];
                for (int i = 0; i < getSize(); i++) {
                    newArray[i] = getArray()[i];
                }
                nodo.setNext(getHead());
                setHead(newArray.length - 1);
                newArray[newArray.length - 1] = nodo;
                setArray(newArray);
            }
            size++;
        }
    }
    
    public void insertFinal(T element) {
        if (isEmpty()) {
            insertBegin(element);
        } else if (getSize() == getMaxSize()) {
            System.out.println("El maximo tamaño ya fue alcanzado");
        } else {
            NodoArray<T> nodo = new NodoArray(element);
            int position = searchSpace();
            if (position != -1) {
                
            } else {
                
            }
            size++;
        }
    }

    public void insertAtIndex(T element, int index) {
        NodoArray nodo = new NodoArray(element);
        if (isEmpty()) {
            insertBegin(element);
        } else if(getSize() == getMaxSize()) {
            System.out.println("El maximo tamaño ya fue alcanzado");
        } else if(index <= getArray().length) {
            int position = searchSpace();
            if (position != -1) {
                getArray()[position] = nodo;
                int cont = 0;
                int pointer = getHead();
                while (cont < index -1) {
                    pointer = getArray()[pointer].getNext();
                    cont++;
                }
                int temp = getArray()[pointer].getNext();
                getArray()[pointer].setNext(position);
                getArray()[position].setNext(temp);
            } else {
                NodoArray[] newArray = new NodoArray[getSize() + 1];
                for (int i = 0; i < getSize(); i++) {
                    newArray[i] = getArray()[i];
                }
                newArray[newArray.length - 1] = nodo;
                setArray(newArray);
                int cont = 0;
                int pointer = getHead();
                while (cont < index -1) {
                    pointer = getArray()[pointer].getNext();
                    cont++;
                }
                int temp = getArray()[pointer].getNext();
                getArray()[pointer].setNext(newArray.length - 1);
                getArray()[newArray.length - 1].setNext(temp);
                size++;
            }
        } else {
            System.out.println("Invalid index");
        }
    }


    public NodoArray deleteBegin() {
        if(isEmpty()) {
            System.out.println("The list is empty");
        } else {
            NodoArray pointer = getArray()[getHead()];
            Integer temp = pointer.getNext();
            getArray()[getHead()] = null;
            setHead(temp);
            pointer.setNext(null);
            size--; 
            return pointer;
        }
        return null;
    }

    public NodoArray deleteFinal() {
        return null;
    }

    public NodoArray deleteAtIndex(int index) {
        return null;
    }
    
    public void print() {
        Integer pointer = getHead();
        while (pointer != null) {
            System.out.print(" [ " + getArray()[pointer].getElement() + " ] ");
            pointer = getArray()[pointer].getNext();
        }
    }
    
    public void printInMemory() {
        for (int i = 0; i < getArray().length; i++) {
            System.out.print(" [ " + getArray()[i].getElement() + " ] ");
        }
        
    }
    
}
