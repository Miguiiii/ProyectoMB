/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Estructuras;
import Nodos.BHNode;
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
    
    public boolean isEmpty() {
        if (getSize() == 0) {
            return true;
        }
        return false;
    }
    
    private int parent(int index) {
        return (index - 1) / 2;
    }
    
    private int leftChild(int index) {
        return 2 * index + 1;
    }
    
    private int rightChild(int index) {
        return 2 * index + 2;
    }
    
    private void swap(int pIndex, int cIndex) {
        int cont = 0;
        int pointer = getHeap().getHead();
        while (cont < pIndex - 1) {
            pointer = getHeap().getArray()[pointer].getNext();
            cont++;
        }
        
    }
    
    public void minHeapify(int index) {
        
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
        heap.insertFinal(nodo);
        int current = size;
    }
    
}
