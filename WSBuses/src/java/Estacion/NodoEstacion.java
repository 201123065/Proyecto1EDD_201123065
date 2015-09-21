/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estacion;

/**
 *
 * @author marcosmayen
 */
public class NodoEstacion {
    int id, fe,personas;
    String nombre,contrasena, Tipo;
    
    NodoEstacion hijoIzquierdo;
    NodoEstacion hijoDerecho;
    public NodoEstacion(int id,String nombre, String contrasena,int personas,String Tipo){
        this.personas=personas;
        this.id=id;
        this.Tipo=Tipo;
        this.nombre=nombre;
        this.contrasena=contrasena;
        this.fe=0;
        this.hijoIzquierdo=null;
        this.hijoDerecho=null;
    }
}
