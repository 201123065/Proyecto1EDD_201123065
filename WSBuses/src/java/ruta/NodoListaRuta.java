/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ruta;

/**
 *
 * @author marcosmayen
 */
public class NodoListaRuta {
    int id;
    String nombreRuta;
    Boolean Tipo;
    NodoListaRuta Anterior;
    NodoListaRuta Siguiente;
    public NodoListaRuta(int id,String nombre,Boolean tipo){
        new NodoListaRuta(id,nombre,tipo,null,null);
    }
    public NodoListaRuta(int id,String nombreRuta,Boolean Tipo, NodoListaRuta Izquierdo, NodoListaRuta Derecho){
        this.id=id;
        this.nombreRuta=nombreRuta;
        this.Anterior=Izquierdo;
        this.Siguiente=Derecho;
        this.Tipo=Tipo;
    }
}
