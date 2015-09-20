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
public class ChoferAVL {
    private NodoChofer raiz;
    public ChoferAVL(){
        raiz=null;
    }
    
    public NodoChofer ObtenerRaiz(){
        return raiz;
    }
    
    
    
    int pos=0;
    public Boolean Buscar(String Usuario, String Contrasena, NodoChofer Nodo){
        if(Usuario.equals(Nodo.id)){
            return (Contrasena.equals(Nodo.Contraseña))?true:false;
        }else if(Usuario.length()>Nodo.id.length()){
            while((Usuario.charAt(pos)==Nodo.id.charAt(pos))&&Nodo.id.length()-1>pos){
                pos++;
            }
            if(Nodo.id.length()==pos){
                return false;
            }else{
                if(Usuario.charAt(pos)<Nodo.id.charAt(pos)){
                    return (Nodo.hijoIzquierdo==null)?false:
                            Buscar(Usuario, Contrasena, Nodo.hijoIzquierdo);
                }else{
                    return (Nodo.hijoDerecho==null)?false:
                            Buscar(Usuario, Contrasena, Nodo.hijoDerecho);
                }
            }
        }else{
            while((Usuario.charAt(pos)==Nodo.id.charAt(pos))&&Usuario.length()-1>pos){
                pos++;
            }
            if(Usuario.length()==pos){
                return false;
            }else{
                if(Usuario.charAt(pos)<Nodo.id.charAt(pos)){
                    return (Nodo.hijoIzquierdo==null)?false:
                            Buscar(Usuario, Contrasena, Nodo.hijoIzquierdo);
                }else{
                    return (Nodo.hijoDerecho==null)?false:
                            Buscar(Usuario, Contrasena, Nodo.hijoDerecho);
                }
            }
        }
    }
    
    public Boolean Login(String id, String clave){
        return(raiz!=null)?Buscar(id, clave, raiz):false;
    }
    
    
    public int obtenerFE(NodoChofer x){
        if(x==null)
        {
            return -1;
        }
        else{
            return x.fe;
        }
    }
    
    //rotacion simple a la izquierda
    
    public NodoChofer rotacionIzquierda(NodoChofer c){
        NodoChofer auxiliar= c.hijoIzquierdo;
        c.hijoIzquierdo=auxiliar.hijoDerecho;
        auxiliar.hijoDerecho=c;
        c.fe=Math.max(obtenerFE(c.hijoIzquierdo),obtenerFE(c.hijoDerecho))+1;
        auxiliar.fe=Math.max(obtenerFE(auxiliar.hijoIzquierdo),obtenerFE(auxiliar.hijoDerecho))+1;
        return auxiliar;
    }
    
    //rotacion simple a la derecha
    
    public NodoChofer rotacionDerecha(NodoChofer c){
        NodoChofer auxiliar= c.hijoDerecho;
        c.hijoDerecho=auxiliar.hijoIzquierdo;
        auxiliar.hijoIzquierdo=c;
        c.fe=Math.max(obtenerFE(c.hijoIzquierdo),obtenerFE(c.hijoDerecho))+1;
        auxiliar.fe=Math.max(obtenerFE(auxiliar.hijoIzquierdo),obtenerFE(auxiliar.hijoDerecho))+1;
        return auxiliar;
    }
    
    //rotacion doble derecha
    public NodoChofer rotacionDobleIzquierda(NodoChofer c){
        NodoChofer temporal;
        c.hijoIzquierdo=rotacionDerecha(c.hijoIzquierdo);
        temporal=rotacionIzquierda(c);
        return temporal;
    }
    //rotacion Doble a la izquierda
    public NodoChofer rotacionDobleDerecha(NodoChofer c){
        NodoChofer temporal;
        c.hijoDerecho=rotacionIzquierda(c.hijoDerecho);
        temporal=rotacionDerecha(c);
        return temporal;
    }
    
    //metodo para insertar AVL
    public NodoChofer iavl(NodoChofer nuevo, NodoChofer subAr)
    {
        NodoChofer nuevoPadre = subAr;
        if(nuevo.id.length()==subAr.id.length()){
            if(nuevo.id==subAr.id){
                System.out.println("nodo repetido");
            }else{
                while(nuevo.id.charAt(pos)==subAr.id.charAt(pos)&&pos<nuevo.id.length()){
                    pos++;
                }
                if(nuevo.id.charAt(pos)<subAr.id.charAt(pos)){
                    if(subAr.hijoIzquierdo==null){
                        subAr.hijoIzquierdo=nuevo;
                    }else{
                        subAr.hijoIzquierdo=iavl(nuevo, subAr.hijoIzquierdo);
                        if((obtenerFE(subAr.hijoIzquierdo)-obtenerFE(subAr.hijoDerecho))==2){
                            nuevoPadre=(nuevo.id.charAt(pos)>subAr.hijoIzquierdo.id.charAt(pos))?
                                    rotacionIzquierda(subAr):
                                     rotacionDobleIzquierda(subAr);
                        }
                    }
                }else {
                    if(subAr.hijoDerecho==null){
                        subAr.hijoDerecho=nuevo;
                    }else{
                        subAr.hijoDerecho=iavl(nuevo, subAr.hijoDerecho);
                        if((obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo))==2){
                            nuevoPadre= (nuevo.id.charAt(pos)>subAr.hijoDerecho.id.charAt(pos))?
                                    rotacionDerecha(subAr):
                                    rotacionDobleDerecha(subAr);
                        }
                    }
                }
            }
        }else if(nuevo.id.length()<subAr.id.length()){
            while((nuevo.id.charAt(pos)==subAr.id.charAt(pos))&&pos<nuevo.id.length()-1)
                pos++;
            if(pos==nuevo.id.length()-1){
                if(subAr.hijoIzquierdo==null){
                    subAr.hijoIzquierdo=nuevo;
                }else{
                    subAr.hijoIzquierdo=iavl(nuevo, subAr.hijoIzquierdo);
                    if((obtenerFE(subAr.hijoIzquierdo)-obtenerFE(subAr.hijoDerecho))==2){
                        nuevoPadre=(nuevo.id.charAt(pos)<subAr.hijoIzquierdo.id.charAt(pos))?
                                rotacionDerecha(subAr):
                                rotacionDobleDerecha(subAr);
                        
                    }
                }
            }else{
                if(nuevo.id.charAt(pos)<subAr.id.charAt(pos)){
                    if(subAr.hijoIzquierdo==null){
                        subAr.hijoIzquierdo=nuevo;
                    }else{
                        subAr.hijoIzquierdo=iavl(nuevo, subAr.hijoIzquierdo);
                            if((obtenerFE(subAr.hijoIzquierdo)-obtenerFE(subAr.hijoDerecho))==2){
                                nuevoPadre=(nuevo.id.charAt(pos)<subAr.hijoIzquierdo.id.charAt(pos))?
                                rotacionIzquierda(subAr):
                                rotacionDobleIzquierda(subAr);
                        }
                    }
                }else{
                    if(subAr.hijoDerecho==null){
                        subAr.hijoDerecho=nuevo;
                    }else{
                        subAr.hijoDerecho=iavl(nuevo, subAr.hijoDerecho);
                        if((obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo))==2){
                            nuevoPadre=(nuevo.id.charAt(pos)>subAr.hijoDerecho.id.charAt(pos))?
                               rotacionDerecha(subAr):
                               rotacionDobleDerecha(subAr);
                        }
                    }
                }
            }
        }else{
            while((nuevo.id.charAt(pos)==subAr.id.charAt(pos))&&subAr.id.length()-1>pos)
                pos++;
            if(pos==subAr.id.length()-1){
                if(subAr.id.charAt(pos)<nuevo.id.charAt(pos)){
                    if(subAr.hijoDerecho==null){
                        subAr.hijoDerecho=nuevo;
                    }else{
                        subAr.hijoDerecho=iavl(nuevo, subAr.hijoDerecho);
                        if((obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo))==2){
                            nuevoPadre=(nuevo.id.charAt(pos)>subAr.hijoDerecho.id.charAt(pos))?
                               rotacionDerecha(subAr):
                               rotacionDobleDerecha(subAr);
                        }
                    }
                
                }else{
                    if(nuevo.id.charAt(pos)<subAr.id.charAt(pos)){
                        if(subAr.hijoIzquierdo==null){
                            subAr.hijoIzquierdo=nuevo;
                        }else{
                            subAr.hijoIzquierdo=iavl(nuevo, subAr.hijoIzquierdo);
                                if((obtenerFE(subAr.hijoIzquierdo)-obtenerFE(subAr.hijoDerecho))==2){
                                    nuevoPadre=(nuevo.id.charAt(pos)<subAr.hijoIzquierdo.id.charAt(pos))?
                                    rotacionIzquierda(subAr):
                                    rotacionDobleIzquierda(subAr);
                            }
                        }
                    }else{
                        if(subAr.hijoDerecho==null){
                            subAr.hijoDerecho=nuevo;
                        }else{
                            subAr.hijoDerecho=iavl(nuevo, subAr.hijoDerecho);
                            if((obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo))==2){
                                nuevoPadre=(nuevo.id.charAt(pos)>subAr.hijoDerecho.id.charAt(pos))?
                                   rotacionDerecha(subAr):
                                   rotacionDobleDerecha(subAr);
                            }
                        }
                    }
                }
            }else{
                if(nuevo.id.charAt(pos)<subAr.id.charAt(pos)){
                    if(subAr.hijoIzquierdo==null){
                        subAr.hijoIzquierdo=nuevo;
                    }else{
                        subAr.hijoIzquierdo=iavl(nuevo, subAr.hijoIzquierdo);
                            if((obtenerFE(subAr.hijoIzquierdo)-obtenerFE(subAr.hijoDerecho))==2){
                                nuevoPadre=(nuevo.id.charAt(pos)<subAr.hijoIzquierdo.id.charAt(pos))?
                                rotacionIzquierda(subAr):
                                rotacionDobleIzquierda(subAr);
                        }
                    }
                }else{
                    if(subAr.hijoDerecho==null){
                        subAr.hijoDerecho=nuevo;
                    }else{
                        subAr.hijoDerecho=iavl(nuevo, subAr.hijoDerecho);
                        if((obtenerFE(subAr.hijoDerecho)-obtenerFE(subAr.hijoIzquierdo))==2){
                            nuevoPadre=(nuevo.id.charAt(pos)>subAr.hijoDerecho.id.charAt(pos))?
                               rotacionDerecha(subAr):
                               rotacionDobleDerecha(subAr);
                        }
                    }
                }
            }
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
    public void insertar(String d,String nombre, String apellido, String clave){
        NodoChofer nuevo = new NodoChofer(d, nombre, apellido,clave);
        if(raiz==null){
            raiz=nuevo;
        }else{
            raiz=iavl(nuevo, raiz);
        }
    }
    
    
    public void inOrden(NodoChofer a)
    {
        if(a!=null)
        {
            inOrden(a.hijoIzquierdo);
            System.out.print(a.id+",");
            inOrden(a.hijoDerecho);
        }
    }
    public void enOrden(NodoChofer a)
    {
        if(a!=null){
            System.out.print(a.id+",");
            enOrden(a.hijoIzquierdo);
            enOrden(a.hijoDerecho);
        }
    }
    public void postOrden(NodoChofer a){
        if(a!=null)
        {
            postOrden(a.hijoIzquierdo);
            postOrden(a.hijoDerecho);
            System.out.print(a.id+",");
        }
    }
}
