
package ruta;


public class Ruta {
    public NodoRuta inicio, fin,aux;
    public Ruta(){
        inicio=fin=aux=null;
    }
    public Boolean estaVacia(){
        return (inicio==null)?true:false;
    }
    
    
    
    
    public void Agrega(String id,NodoListaRuta n){
        if(!estaVacia())
        {
            //el puntero siguiente del fin anterior es fin
            fin=new NodoRuta(id,n,null,fin);
            fin.Anterior.Siguiente=fin;
            
        }else
        {
            aux=inicio=fin=new NodoRuta(id,n);
            
        }
    }
    
    
    
    public NodoRuta EliminarDato(String id) {
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
                NodoRuta temporal;
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
