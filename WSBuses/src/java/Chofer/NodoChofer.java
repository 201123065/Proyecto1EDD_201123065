/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chofer;

/**
 *
 * @author marcosmayen
 */
public class NodoChofer {
    int  fe;
    String id, nombre, apellido, Contraseña;
    
    NodoChofer hijoIzquierdo,hijoDerecho;
    public NodoChofer(String id,String nombre, String apellido, String Contraseña){
        this.id=id;
        this.nombre=nombre;
        this.apellido=apellido;
        this.Contraseña=Contraseña;
        this.fe=0;
        this.hijoIzquierdo=null;
        this.hijoDerecho=null;
    }
}
