/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Estructuras;
import Nodos.HashNode;
/**
 *
 * @author usuario
 */
public class HashMap<K, V> {

    private ListaArray<Lista<HashNode<K, V>>> buckets;
    private int capacidad;
    private int size;

    public HashMap(int capacidad) {
        this.capacidad = capacidad;
        this.size = 0;
        this.buckets = new ListaArray(capacidad);
        
    }
    
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode())%capacidad;
    }
    
}
