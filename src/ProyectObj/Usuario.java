/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ProyectObj;

import Estructuras.*;
/**
 *
 * @author usuario
 */
public class Usuario {

    private String name;
    private String prioridad;
    private Lista<Documento> documentos;

    public Usuario(String name, String prioridad) {
        this.name = name;
        this.prioridad = prioridad;
        this.documentos = new Lista();
    }

    public String getName() {
        return name;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public Lista<Documento> getDocumentos() {
        return documentos;
    }   
    
    public void addDocument(String name, String type, int size) {
        Documento doc = new Documento(name, type, size);
        documentos.insertBegin(doc);
    }
    
    public Documento deleteDocument(Documento doc) {
        documentos.deleteElement(doc);
        return doc;
    }
    
}
