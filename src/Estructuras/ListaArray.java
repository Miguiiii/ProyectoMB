/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Estructuras;
import Nodos.NodoArray;
import java.util.Iterator;
/**
 *
 * @author usuario
 */
public class ListaArray<T> implements Iterable<T> {

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
    
    public T getElmenetAtIndex(int index) {
        T element = null;
        int cont = 0;
        for (T i:this) {
            if (cont == index) {
                element = i;
                break;
            }
            cont++;
        }
        return element;
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
                int pointer = getHead();
                while (getArray()[pointer].getNext() != null) {
                    pointer = getArray()[pointer].getNext();
                }
                getArray()[position] = nodo;
                getArray()[pointer].setNext(position);
            } else {
                NodoArray[] newArray = new NodoArray[getSize() + 1];
                for (int i = 0; i < getSize(); i++) {
                    newArray[i] = getArray()[i];
                }
                newArray[newArray.length - 1] = nodo;
                setArray(newArray);
                int pointer = getHead();
                while (getArray()[pointer].getNext() != null) {
                    pointer = getArray()[pointer].getNext();
                }
                getArray()[pointer].setNext(newArray.length - 1);
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
                if (getArray()[pointer].getNext() != null) {
                    int temp = getArray()[pointer].getNext();
                    getArray()[position].setNext(temp);
                }
                getArray()[pointer].setNext(position);
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
                if (getArray()[pointer].getNext() != null) {
                    int temp = getArray()[pointer].getNext();
                    getArray()[newArray.length - 1].setNext(temp);
                }
                getArray()[pointer].setNext(newArray.length - 1);
            }
            size++;
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
        if(isEmpty()) {
            System.out.println("The list is empty");
        } else if (getSize() == 1) {
            return deleteBegin();
        } else {
            NodoArray pointer = getArray()[getHead()];
            while (getArray()[pointer.getNext()].getNext() != null) {
                pointer = getArray()[pointer.getNext()];
            }
            NodoArray temp = getArray()[pointer.getNext()];
            getArray()[pointer.getNext()] = null;
            pointer.setNext(null);
            size--;
            return temp;
        }
        return null;
    }

    public NodoArray deleteAtIndex(int index) {
        if(isEmpty()) {
            System.out.println("The list is empty");
        } else if (index == 0) {
            return deleteBegin();
        } else if (index <= getArray().length) {
            int cont = 0;
            int pointer = getHead();
            while (cont < index - 1) {
                pointer = getArray()[pointer].getNext();
                cont++;
            }
            NodoArray current = getArray()[pointer];
            NodoArray temp = getArray()[current.getNext()];
            getArray()[current.getNext()] = null;
            current.setNext(temp.getNext());
            temp.setNext(null);
            size--;
            return temp;
        } else {
            System.out.println("Invalid index");
        }
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
    
    @Override
    public Iterator iterator() {
        return new ArrayIterator(this);
    }
    
}

class ArrayIterator<T> implements Iterator<T> {
    
    NodoArray<T>[] array;
    Integer pointer;

    public ArrayIterator(ListaArray array) {
        pointer = array.getHead();
        this.array = array.getArray();
    }
    
    @Override
    public boolean hasNext() {
        return pointer != null;
    }

    @Override
    public T next() {
        NodoArray<T> current = array[pointer];
        pointer = current.getNext();
        return current.getElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

}
