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
            getBuckets().insertAtIndex(bucket, index);
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
                            size--;
                            if (entry.getValues().getLength() == 0) {
                                bucket.deleteAtIndex(i);
                            }
                            break;
                        }
                    }
                    if (eliminado == null) {
                        System.out.println("No existe ese valor asociado a la key dada");
                        return eliminado;
                    }
                    if (bucket.getLength() == 0) {
                        getBuckets().deleteAtIndex(index);
                        break;
                    }
                }
            }
            if (i == bucket.getLength() && eliminado == null) {
                System.out.println("No existe esa llave en el mapa");
                return eliminado;
            }
        }
        return eliminado;
    }
    
    public V deleteValue(V value) {
        
        for (int i = 0; i < getBuckets().getSize(); i++) {
            Lista<HashNode<K, V>> bucket = getBuckets().getElmenetAtIndex(i);
            for (int j = 0; j < bucket.getLength(); j++) {
                HashNode<K, V> entry = bucket.getElmenetAtIndex(j);
                Lista<V> valores = entry.getValues();
                for (int k = 0; k < valores.getLength(); k++) {
                    V current = valores.getElmenetAtIndex(k);
                    if (current == value) {
                        return deleteValueInKey(entry.getKey(), value);
                    }
                }
            }
        }
        System.out.println("No existe ese valor en el mapa");
        return null;
    }
    
}
