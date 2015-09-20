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
public class ListaRuta {
   public NodoListaRuta inicio,fin,aux;
   public ListaRuta(){
       inicio=fin=aux=null;
   }
   public Boolean estaVacia(){
       return (inicio==null)?true:false;
   }
   public void Agregar(int id,String Nombre, Boolean Tipo){
        if(!estaVacia())
        {
            fin=new NodoListaRuta(id, Nombre, Tipo, fin,null);
            fin.Anterior.Siguiente=fin;
           
        }else
        {
            aux=inicio=fin=new NodoListaRuta(id, Nombre, Tipo);
        }
    }
    public NodoListaRuta EliminarDato(String id) {
        if(!estaVacia())
        {
            aux=inicio;
            if(inicio==fin && id==inicio.nombreRuta )
            {
                inicio=fin=aux=null;
            }
            else if(id==inicio.nombreRuta)
            {
                inicio=inicio.Siguiente;
                inicio.Anterior=null;
                aux=inicio;
            }
            else
            {
                NodoListaRuta temporal;
                temporal=aux.Siguiente;
                while(temporal!=null&&temporal.nombreRuta!=id )
                {
                    aux=aux.Siguiente;
                    temporal=temporal.Siguiente;
                }
                if(temporal!=null)
                {
                    if(temporal.Siguiente==null)
                    {
                        fin.Anterior.Siguiente=null;
                        fin=fin.Anterior;
                        aux=fin;
                     
                    }
                    else
                    {
                        aux.Siguiente=temporal.Siguiente;
                        temporal.Siguiente.Anterior=aux;
                    }
                }/**/
            }
        }
        return aux;
    }
   
}
