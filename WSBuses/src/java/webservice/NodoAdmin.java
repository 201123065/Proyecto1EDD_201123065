/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

/**
 *
 * @author marcosmayen
 */
public class NodoAdmin {
    String Correo, Contraseña;
    int fe;
    NodoAdmin HijoIzq,HijoDer;
    public NodoAdmin(String Correo, String Contraseña){
        this.Contraseña=Contraseña;
        this.Correo=Correo;
        this.HijoIzq=null;
        this.HijoDer=null;
        
    }
}
