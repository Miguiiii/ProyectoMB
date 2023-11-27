/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Estructuras;
import Nodos.BHNode;
import Nodos.NodoArray;
/**
 *
 * @author usuario
 */
public class BinaryHeap<T> {
    
    private ListaArray<BHNode<T>> heap;
    private int size;
    private int maxSize;

    public BinaryHeap(int maxSize) {
        this.maxSize = maxSize;
        this.size = 0;
        this.heap = new ListaArray(this.maxSize);
    }

    public ListaArray<BHNode<T>> getHeap() {
        return heap;
    }

    public void setHeap(ListaArray<BHNode<T>> heap) {
        this.heap = heap;
    }
    
    public int getSize() {
        return size;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public BHNode getMin() {
        return getHeap().getElmenetAtIndex(0);
    }
    
    public boolean isEmpty() {
        if (getSize() == 0) {
            return true;
        }
        return false;
    }
    
    public int parent(int index) {
        return (index - 1) / 2;
    }
    
    public int leftChild(int index) {
        return 2 * index + 1;
    }
    
    public int rightChild(int index) {
        return 2 * index + 2;
    }
    
    private void swap(int pIndex, int cIndex) {
        NodoArray anterior, padre, hijo;
        anterior = padre = hijo = null;
        int cont = 0;
        Integer pointer = getHeap().getHead();
        while (cont != cIndex) {
            if (pIndex != 0 && cont == pIndex - 1) {
                anterior = getHeap().getArray()[pointer];
            } if (cont == pIndex) {
                padre = getHeap().getArray()[pointer];
            }
            pointer = getHeap().getArray()[pointer].getNext();
            cont++;
        }
        hijo = getHeap().getArray()[pointer];
        pointer = hijo.getNext();
        if (pIndex == 0) {
            hijo.setNext(getHeap().getHead());
            getHeap().setHead(padre.getNext());
        } else {
            hijo.setNext(anterior.getNext());
            anterior.setNext(padre.getNext());
        }
        padre.setNext(pointer);
    }
    
    public void minHeapify(int index) {
        int lChild = leftChild(index);
        int rChild = rightChild(index);
        
        int smallest = index;
        
        if (lChild < getSize() && getHeap().getElmenetAtIndex(lChild).getPrioridad() < getHeap().getElmenetAtIndex(smallest).getPrioridad()) {
            smallest = lChild;
        } if (rChild < getSize() && getHeap().getElmenetAtIndex(rChild).getPrioridad() < getHeap().getElmenetAtIndex(smallest).getPrioridad()) {
            smallest = rChild;
        }
        
        if (smallest != index) {
            swap(index, smallest);
            minHeapify(smallest);
        }
    }
    
    public void insert(T element, int prioridad) {
        if (getSize() == getMaxSize()) {
            ListaArray<BHNode<T>> newHeap = new ListaArray(getMaxSize() + 5);
            for (int i = 0; i < getSize(); i++) {
                newHeap.insertAtIndex(getHeap().getElmenetAtIndex(i), i);
            }
            setHeap(newHeap);
        }
        BHNode<T> nodo = new BHNode(element, prioridad);
        int current = size;
        getHeap().insertFinal(nodo);
        size++;
        
        while (current != 0 && getHeap().getElmenetAtIndex(current).getPrioridad() < getHeap().getElmenetAtIndex(parent(current)).getPrioridad()) {
            swap(parent(current), current);
            current = parent(current);
        }
    }
    
    public BHNode extractMin() {
        BHNode min = getHeap().getElmenetAtIndex(0);
        getHeap().deleteBegin();
        size--;
        getHeap().insertBegin(getHeap().getElmenetAtIndex(size - 1));
        getHeap().deleteFinal();
        minHeapify(0);
        return min;
    }
    
    public BHNode extractElement(BHNode extract) {
        Lista<T> colaElementos = new Lista();
        Lista<Integer> colaPrioridades = new Lista();
        
        while (!getHeap().getElmenetAtIndex(0).equals(extract)) {
            colaElementos.insertFinal(getHeap().getElmenetAtIndex(0).getElement());
            colaPrioridades.insertFinal(getHeap().getElmenetAtIndex(0).getPrioridad());
            extractMin();
        }
        
        BHNode eliminado = extractMin();
        
        for (int i = 0; i < colaElementos.getLength(); i++) {
            T newElement = colaElementos.getElmenetAtIndex(0);
            int newPrioridad = colaPrioridades.getElmenetAtIndex(0);
            insert(newElement, newPrioridad);
            colaElementos.deleteBegin();
            colaPrioridades.deleteBegin();
        }
        
        return eliminado;
    }
    
    public void print() {
        getHeap().print();
    }
    
}
