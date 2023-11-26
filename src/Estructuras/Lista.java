/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Estructuras;
import Nodos.Nodo;
import java.util.Iterator;
/**
 *
 * @author usuario
 */
public class Lista<T> implements Iterable<T> {

    private Nodo<T> head;
    private int length;

    public Lista() {
        this.head = null;
        this.length = 0;
    }

    public Nodo getHead() {
        return head;
    }

    public void setHead(Nodo head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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
    
    public void insertBegin(T element) {
        Nodo<T> nodo = new Nodo(element);
        if (isEmpty()) {
            setHead(nodo);
        } else {
            nodo.setNext(getHead());
            setHead(nodo);
        }
        length++;
    }
    
    public void insertFinal(T element) {
        if (isEmpty()) {
            insertBegin(element);
        } else {
            Nodo<T> nodo = new Nodo(element);
            Nodo pointer = getHead();
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(nodo);
            length++;
        }
    }
    
    public void insertAtIndex(T element, int index) {
        if (isEmpty() || index == 0) {
            insertBegin(element);
        } else if (index > getLength()) {
            System.out.println("Índice inválido");
        } else {
            if (index == getLength()) {
                insertFinal(element);
            } else {
                Nodo<T> nodo = new Nodo(element);
                Nodo pointer = getHead();
                int cont = 0;
                while (cont < index - 1) {
                    pointer = pointer.getNext();
                    cont++;
                }
                Nodo temp = pointer.getNext();
                nodo.setNext(temp);
                pointer.setNext(nodo);
                length++;
            }
        }
    }
    
    public Nodo deleteBegin() {
        if(isEmpty()) {
            System.out.println("La lista esta vacia");
            return null;
        } else {
            Nodo pointer = getHead();
            setHead(pointer.getNext());
            pointer.setNext(null);
            length--;
            return pointer;
        }
    }
    
    public Nodo deleteFinal() {
        if (isEmpty()) {
            System.out.println("La lista esta vacia");
            return null;
        } else if (getLength() == 1) {
            return deleteBegin();
        } else {
            Nodo pointer = getHead();
            while (pointer.getNext().getNext() != null) {
                pointer = pointer.getNext();
            }
            Nodo temp = pointer.getNext();
            pointer.setNext(null);
            length--;
            return temp;
        }
    }
    
    public Nodo deleteAtIndex(int index) {
        
        if (index == 0) {
            return deleteBegin();
        } else if (index == getLength()) {
            return deleteFinal();
        } else if (index < getLength()) {
            Nodo pointer = getHead();
            for (int i = 0; i < index - 1; i++) {
                pointer = pointer.getNext();
            }
            Nodo temp = pointer.getNext();
            pointer.setNext(temp.getNext());
            temp.setNext(null);
            length--;
            return temp;
        } else {
            System.out.println("Index not valid");
            return null;
        }
    }
    
    public Nodo deleteElement(T element) {
        
        Nodo pointer = getHead();
        
        if (pointer.getElement() == element) {
            return deleteBegin();
        } else {
            while (pointer.getNext().getElement() != element) {
                pointer = pointer.getNext();
                if (pointer.getNext() == null) {
                    break;
                }
            }
            if (pointer.getNext() == null) {
                return null;
            }
            Nodo temp = pointer.getNext();
            pointer.setNext(temp.getNext());
            temp.setNext(null);
            length--;
            return temp;
        }

    }
    
    public void print() {
        
    }

    @Override
    public Iterator iterator() {
        return new ListaIterator(this);
    }

    
    
}

class ListaIterator<T> implements Iterator<T> {
    
    Nodo<T> pointer;

    public ListaIterator(Lista list) {
        pointer = list.getHead();
    }
    
    @Override
    public boolean hasNext() {
        return pointer != null;
    }

    @Override
    public T next() {
        T current = pointer.getElement();
        pointer = pointer.getNext();
        return current;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

}
