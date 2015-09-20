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
public class EstacionAVL {
     private NodoEstacion raiz;
    public EstacionAVL(){
        raiz=null;
    }
    
    public NodoEstacion ObtenerRaiz(){
        return raiz;
    }
    public Boolean Buscar(int id,String Contrasena, NodoEstacion Nodo){
        if(id==Nodo.id){
            return (Nodo.contrasena.equals(Contrasena))?true:false;
        }else if(id>Nodo.id){
            if(Nodo.hijoDerecho!=null){
                return Buscar(id,Contrasena, Nodo.hijoDerecho);
            }else {
                return false;
            }
            
        }else{
            if(Nodo.hijoIzquierdo!=null){
                return Buscar(id,Contrasena, Nodo.hijoIzquierdo);
            }else{
                return false;
            }
            
        }
    }
    
    public Boolean Login(int id,String clave){
        return(raiz!=null)?Buscar(id, clave, raiz):false;
    }
    
    
    
    public int obtenerFE(NodoEstacion x){
        if(x==null)
        {
            return -1;
        }
        else{
            return x.fe;
        }
    }
    
    //rotacion simple a la izquierda
    
    public NodoEstacion rotacionIzquierda(NodoEstacion c){
        NodoEstacion auxiliar= c.hijoIzquierdo;
        c.hijoIzquierdo=auxiliar.hijoDerecho;
        auxiliar.hijoDerecho=c;
        c.fe=Math.max(obtenerFE(c.hijoIzquierdo),obtenerFE(c.hijoDerecho))+1;
        auxiliar.fe=Math.max(obtenerFE(auxiliar.hijoIzquierdo),obtenerFE(auxiliar.hijoDerecho))+1;
        return auxiliar;
    }
    
    //rotacion simple a la derecha
    
    public NodoEstacion rotacionDerecha(NodoEstacion c){
        NodoEstacion auxiliar= c.hijoDerecho;
        c.hijoDerecho=auxiliar.hijoIzquierdo;
        auxiliar.hijoIzquierdo=c;
        c.fe=Math.max(obtenerFE(c.hijoIzquierdo),obtenerFE(c.hijoDerecho))+1;
        auxiliar.fe=Math.max(obtenerFE(auxiliar.hijoIzquierdo),obtenerFE(auxiliar.hijoDerecho))+1;
        return auxiliar;
    }
    
    //rotacion doble derecha
    public NodoEstacion rotacionDobleIzquierda(NodoEstacion c){
        NodoEstacion temporal;
        c.hijoIzquierdo=rotacionDerecha(c.hijoIzquierdo);
        temporal=rotacionIzquierda(c);
        return temporal;
    }
    //rotacion Doble a la izquierda
    public NodoEstacion rotacionDobleDerecha(NodoEstacion c){
        NodoEstacion temporal;
        c.hijoDerecho=rotacionIzquierda(c.hijoDerecho);
        temporal=rotacionDerecha(c);
        return temporal;
    }
    
    //metodo para insertar AVL
    public NodoEstacion insertarAVL(NodoEstacion nuevo, NodoEstacion subAr)
    {
        NodoEstacion nuevoPadre = subAr;
        if(nuevo.id<subAr.id){
            if(subAr.hijoIzquierdo==null){
                subAr.hijoIzquierdo=nuevo;
            }else{
                subAr.hijoIzquierdo=insertarAVL(nuevo,subAr.hijoIzquierdo);
                if(obtenerFE(subAr.hijoIzquierdo)-obtenerFE(subAr.hijoDerecho)==2){
                    if(nuevo.id<subAr.hijoIzquierdo.id){
                        nuevoPadre=rotacionIzquierda(subAr);
                    }else{
                        nuevoPadre=rotacionDobleIzquierda(subAr);
                    }
                }
            }
        }else if(nuevo.id>subAr.id){
            if(subAr.hijoDerecho==null){
                subAr.hijoDerecho=nuevo;
            }else{
                subAr.hijoDerecho=insertarAVL(nuevo,subAr.hijoDerecho);
                if(obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo)==2){
                    if(nuevo.id>subAr.hijoDerecho.id){
                        nuevoPadre=rotacionDerecha(subAr);
                    }else{
                        nuevoPadre=rotacionDobleDerecha(subAr);
                    }
                    
                }
            }
        }else{
            System.out.print("nodo duplicado");
        }
        //actualizando la altura
        if((subAr.hijoIzquierdo==null)&&(subAr.hijoDerecho!=null)){
            subAr.fe=subAr.hijoDerecho.fe+1;
        }else if((subAr.hijoDerecho==null)&&(subAr.hijoIzquierdo!=null)){
            subAr.fe=subAr.hijoIzquierdo.fe+1;
        }else{
            subAr.fe=Math.max(obtenerFE(subAr.hijoDerecho),obtenerFE(subAr.hijoIzquierdo))+1;
        }return nuevoPadre;
    }
    
    //metodo para insertar
    public void insertar(int d,String nombre, String clave,String Tipo){
        NodoEstacion nuevo = new NodoEstacion(d, nombre, clave,Tipo);
        if(raiz==null){
            raiz=nuevo;
        }else{
            raiz=insertarAVL(nuevo, raiz);
        }
    }
    
    
    public void inOrden(NodoEstacion a)
    {
        if(a!=null)
        {
            inOrden(a.hijoIzquierdo);
            System.out.print(a.id+",");
            inOrden(a.hijoDerecho);
        }
    }
    public void enOrden(NodoEstacion a)
    {
        if(a!=null){
            System.out.print(a.id+",");
            enOrden(a.hijoIzquierdo);
            enOrden(a.hijoDerecho);
        }
    }
    public void postOrden(NodoEstacion a){
        if(a!=null)
        {
            postOrden(a.hijoIzquierdo);
            postOrden(a.hijoDerecho);
            System.out.print(a.id+",");
        }
    }
}

