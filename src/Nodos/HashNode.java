/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Nodos;
import Estructuras.*;
/**
 *
 * @author usuario
 */
public class HashNode<K, V> {
    
    private K key;
    private Lista<V> values;

    public HashNode(K key, V valor) {
        this.key = key;
        this.values = new Lista<V>();
        addValue(valor);
    }

    public K getKey() {
        return key;
    }

    public Lista<V> getValues() {
        return values;
    }
    
    public void addValue(V valor) {
        getValues().insertBegin(valor);
    }
    
}
