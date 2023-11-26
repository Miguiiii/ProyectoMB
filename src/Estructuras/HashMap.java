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

    private ListaArray<Lista<HashNode<K, V>>> lBuckets;
    private int capacidad;
    private int size;

    public HashMap(int capacidad) {
        this.capacidad = capacidad;
        this.size = 0;
        this.lBuckets = new ListaArray(capacidad);
        
    }

    public ListaArray<Lista<HashNode<K, V>>> getBuckets() {
        return lBuckets;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode())%capacidad;
    }
    
    public Lista<V> getValuesOfKey(K key) {
        int index = getBucketIndex(key);
        Lista<HashNode<K, V>> bucket = getBuckets().getElmenetAtIndex(index);
        if (bucket == null) {
            System.out.println("No hay ningún elemento con esa key");
            return null;
        }
        for (int i = 0; i < bucket.getLength(); i++) {
            if (bucket.getElmenetAtIndex(i).getKey() == key) {
                return bucket.getElmenetAtIndex(i).getValues();
            }
        }
        System.out.println("No hay ningún elemento con esa key");
        return null;
    }
    
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Lista<HashNode<K, V>> bucket = getBuckets().getElmenetAtIndex(index);
        if (bucket == null) {
            bucket = new Lista();
            HashNode<K, V> nodo = new HashNode(key, value);
            bucket.insertBegin(nodo);
            getBuckets().insertBegin(bucket);
        } else {
            int i = 0;
            for (; i < bucket.getLength(); i++) {
                if (bucket.getElmenetAtIndex(i).getKey() == key) {
                    HashNode<K, V> entry = bucket.getElmenetAtIndex(i);
                    for (int j = 0; j < entry.getValues().getLength(); j++) {
                        if (entry.getValues().getElmenetAtIndex(j) == value) {
                            System.out.println("Este valor ya se encuentra dentro del mapa");
                            return;
                        }
                    }
                    entry.addValue(value);
                    break;
                }
            }
            if (i == bucket.getLength()) {
                HashNode<K, V> entry = new HashNode(key, value);
                bucket.insertBegin(entry);
            }
        }
        size++;
    }
    
    public V deleteValueInKey(K key, V value) {
        V eliminado = null;
        int index = getBucketIndex(key);
        Lista<HashNode<K, V>> bucket = getBuckets().getElmenetAtIndex(index);
        if (bucket == null) {
            System.out.println("No existe una entrada con esa key");
            return null;
        } else {
            int i = 0;
            for (; i < bucket.getLength(); i++) {
                if (bucket.getElmenetAtIndex(i).getKey() == key) {
                    HashNode<K, V> entry = bucket.getElmenetAtIndex(i);
                    for (int j = 0; j < entry.getValues().getLength(); j++) {
                        if (entry.getValues().getElmenetAtIndex(j) == value) {
                            eliminado = entry.getValues().getElmenetAtIndex(j);
                            entry.getValues().deleteElement(value);
                            if (entry.getValues().getLength() == 0) {
                                bucket.deleteAtIndex(i);
                            }
                            break;
                        }
                    }
                    
                }
            }
        }
        return eliminado;
    }
    
}
