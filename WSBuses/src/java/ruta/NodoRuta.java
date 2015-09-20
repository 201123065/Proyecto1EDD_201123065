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
public class NodoRuta {
    String nombreRuta;
    NodoRuta Anterior;
    NodoRuta Siguiente;
    NodoListaRuta Estacion;
    public NodoRuta(String nombre,NodoListaRuta Estacion){
        new NodoRuta(nombre,Estacion,null,null);
    }
    public NodoRuta(String nombre,NodoListaRuta Estacion, NodoRuta izquierdo, NodoRuta Derecho){
        this.nombreRuta=nombre;
        this.Estacion=Estacion;
        this.Anterior=izquierdo;
        this.Siguiente=Derecho;
        
    }
    
}
