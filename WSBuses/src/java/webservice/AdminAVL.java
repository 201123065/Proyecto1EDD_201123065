
package webservice;

import java.io.IOException;
import java.time.Clock;
import javax.crypto.spec.IvParameterSpec;
import javax.swing.JOptionPane;


/**
 *
 * @author marcosmayen
 */
public class AdminAVL {
     private NodoAdmin raiz;
    public AdminAVL(){
        raiz=null;
    }
    public NodoAdmin obtenerRaiz(){
        return raiz;
    }
    public void pruebaRaiz(){
        System.out.println(raiz.Correo);
    }
    public Boolean Buscar(String Usuario, String Contrasena, NodoAdmin Nodo){
        if(Usuario.equals(Nodo.Correo)){
            return (Contrasena.equals(Nodo.Contraseña))?true:false;
        }else if(Usuario.length()>Nodo.Correo.length()){
            while((Usuario.charAt(pos)==Nodo.Correo.charAt(pos))&&Nodo.Correo.length()-1>pos){
                pos++;
            }
            if(Nodo.Correo.length()==pos){
                return false;
            }else{
                if(Usuario.charAt(pos)<Nodo.Correo.charAt(pos)){
                    return (Nodo.HijoIzq==null)?false:
                            Buscar(Usuario, Contrasena, Nodo.HijoIzq);
                }else{
                    return (Nodo.HijoDer==null)?false:
                            Buscar(Usuario, Contrasena, Nodo.HijoDer);
                }
            }
        }else{
            while((Usuario.charAt(pos)==Nodo.Correo.charAt(pos))&&Usuario.length()-1>pos){
                pos++;
            }
            if(Usuario.length()==pos){
                return false;
            }else{
                if(Usuario.charAt(pos)<Nodo.Correo.charAt(pos)){
                    return (Nodo.HijoIzq==null)?false:
                            Buscar(Usuario, Contrasena, Nodo.HijoIzq);
                }else{
                    return (Nodo.HijoDer==null)?false:
                            Buscar(Usuario, Contrasena, Nodo.HijoDer);
                }
            }
        }
    }
    
    public Boolean Login(String Usuario, String Contrasena)
    {
        pos=0;
        if(raiz==null){insertar("admin", "admin");}
        return Buscar(Usuario,Contrasena,raiz);
        
    }
    public int obtenerFE(NodoAdmin x){
        if(x==null)
        {
            return -1;
        }
        else{
            return x.fe;
        }
    }  
    //rotacion simple a la izquierda
    public NodoAdmin rotacionIzquierda(NodoAdmin c){
        NodoAdmin auxiliar= c.HijoIzq;
        c.HijoIzq=auxiliar.HijoDer;
        auxiliar.HijoDer=c;
        c.fe=Math.max(obtenerFE(c.HijoIzq),obtenerFE(c.HijoDer))+1;
        auxiliar.fe=Math.max(obtenerFE(auxiliar.HijoIzq),obtenerFE(auxiliar.HijoDer))+1;
        return auxiliar;
    }  
    //rotacion simple a la derecha
    public NodoAdmin rotacionDerecha(NodoAdmin c){
        NodoAdmin auxiliar= c.HijoDer;
        c.HijoDer=auxiliar.HijoIzq;
        auxiliar.HijoIzq=c;
        c.fe=Math.max(obtenerFE(c.HijoIzq),obtenerFE(c.HijoDer))+1;
        auxiliar.fe=Math.max(obtenerFE(auxiliar.HijoIzq),obtenerFE(auxiliar.HijoDer))+1;
        return auxiliar;
    }
    //rotacion doble derecha
    public NodoAdmin rotacionDobleIzquierda(NodoAdmin c){
        NodoAdmin temporal;
        c.HijoIzq=rotacionDerecha(c.HijoIzq);
        temporal=rotacionIzquierda(c);
        return temporal;
    }
    //rotacion Doble a la izquierda
    public NodoAdmin rotacionDobleDerecha(NodoAdmin c){
        NodoAdmin temporal;
        c.HijoDer=rotacionIzquierda(c.HijoDer);
        temporal=rotacionDerecha(c);
        return temporal;
    }
    int pos=0;
   
    
    public void insertar(String Correo, String clave){
        NodoAdmin nuevo = new NodoAdmin(Correo,clave);
        pos=0;
        if(raiz==null){
            raiz=nuevo;
        }else{
            raiz=iavl(nuevo, raiz);
        }
    }
    String pNodo;
    int iz,der;
    public void inOrden(NodoAdmin a,int i)
    { 
        if(a!=null)
        {
            max=(max<i)?i-1:max;
            inOrden(a.HijoIzq,i+1);
            pRaiz=pRaiz+"node"+pos+"[label = \"<f0> |<f1> "+a.Correo+"|<f2> \"];\n";
            System.out.println(pRaiz);
            if(pos%2!=0){
                if(a.HijoIzq!=null&&a.HijoDer!=null){
                    iz=pos-(int) Math.pow(2,max-i);
                    der=pos+(int) Math.pow(2,max-i);
                    pNodo=pNodo+"\"node"+pos+"\":f0 -> \"node"+iz+"\":f1;\n"+
                            "\"node"+pos+"\":f2 -> \"node"+der+"\":f1;\n";
                }else if(a.HijoIzq==null&&a.HijoDer!=null){
                    pNodo=pNodo+"\"node"+(pos)+"\":f2 -> \"node"+(pos+1)+"\":f1;\n";
                }else if(a.HijoIzq!=null&&a.HijoDer==null){
                    pNodo=pNodo+"\"node"+(pos)+"\":f0 -> \"node"+(pos-1)+"\":f1;\n";
                }
            }if(a.HijoIzq==null&&a.HijoDer!=null){
                    pNodo=pNodo+"\"node"+(pos+1)+"\":f2 -> \"node"+(pos)+"\":f1;\n";
                }else if(a.HijoIzq!=null&&a.HijoDer==null){
                    pNodo=pNodo+"\"node"+(pos+1)+"\":f0 -> \"node"+(pos)+"\":f1;\n";
                    System.out.println(":v:");
                }
            pos++;
            inOrden(a.HijoDer,i+1);
            
        }
        i--;
        
    }
    
    
    
    String pRaiz;
    int max;
    public String retornaArbol(NodoAdmin a){
        pRaiz=pNodo="";
        pos=0;
        iz=der=max=0;
        inOrden(a,0);
        return pRaiz+pNodo;
    }
    public void preOrden(NodoAdmin a)
    {
        if(a!=null){
            System.out.println("node"+pos+"[label = \"<f0> |<f1> "+a.Correo+"|<f2> \"];");
            pos++;
            preOrden(a.HijoIzq);
            preOrden(a.HijoDer);
        }
    }
    public void postOrden(NodoAdmin a){
        if(a!=null)
        {
            postOrden(a.HijoIzq);
            postOrden(a.HijoDer);
            System.out.print(a.Correo+",");
        }
    }
    
    
    public NodoAdmin iavl(NodoAdmin nuevo, NodoAdmin subAr){
        NodoAdmin nuevoPadre = subAr;
        if(nuevo.Correo.length()==subAr.Correo.length()){
            if(nuevo.Correo==subAr.Correo){
                System.out.println("nodo repetido");
            }else{
                while(nuevo.Correo.charAt(pos)==subAr.Correo.charAt(pos)&&pos<nuevo.Correo.length()){
                    pos++;
                }
                if(nuevo.Correo.charAt(pos)<subAr.Correo.charAt(pos)){
                    if(subAr.HijoIzq==null){
                        subAr.HijoIzq=nuevo;
                    }else{
                        subAr.HijoIzq=iavl(nuevo, subAr.HijoIzq);
                        if((obtenerFE(subAr.HijoIzq)-obtenerFE(subAr.HijoDer))==2){
                            nuevoPadre=(nuevo.Correo.charAt(pos)<subAr.HijoIzq.Correo.charAt(pos))?
                                    rotacionIzquierda(subAr):
                                     rotacionDobleIzquierda(subAr);
                        }
                    }
                }else {
                    if(subAr.HijoDer==null){
                        subAr.HijoDer=nuevo;
                    }else{
                        subAr.HijoDer=iavl(nuevo, subAr.HijoDer);
                        if((obtenerFE(subAr.HijoDer)-obtenerFE(subAr.HijoIzq))==2){
                            nuevoPadre= (nuevo.Correo.charAt(pos)>subAr.HijoDer.Correo.charAt(pos))?
                                    rotacionDerecha(subAr):
                                    rotacionDobleDerecha(subAr);
                        }
                    }
                }
            }
        }else if(nuevo.Correo.length()<subAr.Correo.length()){
            while((nuevo.Correo.charAt(pos)==subAr.Correo.charAt(pos))&&pos<nuevo.Correo.length()-1)
                pos++;
            if(pos==nuevo.Correo.length()-1){
                if(subAr.HijoIzq==null){
                    subAr.HijoIzq=nuevo;
                }else{
                    subAr.HijoIzq=iavl(nuevo, subAr.HijoIzq);
                    if((obtenerFE(subAr.HijoIzq)-obtenerFE(subAr.HijoDer))==2){
                        nuevoPadre=(nuevo.Correo.charAt(pos)<subAr.HijoIzq.Correo.charAt(pos))?
                                rotacionDerecha(subAr):
                                rotacionDobleDerecha(subAr);
                        
                    }
                }
            }else{
                if(nuevo.Correo.charAt(pos)<subAr.Correo.charAt(pos)){
                    if(subAr.HijoIzq==null){
                        subAr.HijoIzq=nuevo;
                    }else{
                        subAr.HijoIzq=iavl(nuevo, subAr.HijoIzq);
                            if((obtenerFE(subAr.HijoIzq)-obtenerFE(subAr.HijoDer))==2){
                                nuevoPadre=(nuevo.Correo.charAt(pos)<subAr.HijoIzq.Correo.charAt(pos))?
                                rotacionIzquierda(subAr):
                                rotacionDobleIzquierda(subAr);
                        }
                    }
                }else{
                    if(subAr.HijoDer==null){
                        subAr.HijoDer=nuevo;
                    }else{
                        subAr.HijoDer=iavl(nuevo, subAr.HijoDer);
                        if((obtenerFE(subAr.HijoDer)-obtenerFE(subAr.HijoIzq))==2){
                            nuevoPadre=(nuevo.Correo.charAt(pos)>subAr.HijoDer.Correo.charAt(pos))?
                               rotacionDerecha(subAr):
                               rotacionDobleDerecha(subAr);
                        }
                    }
                }
            }
        }else{
            while((nuevo.Correo.charAt(pos)==subAr.Correo.charAt(pos))&&subAr.Correo.length()-1>pos)
                pos++;
            if(pos==subAr.Correo.length()-1){
                if(subAr.Correo.charAt(pos)<nuevo.Correo.charAt(pos)){
                    if(subAr.HijoDer==null){
                        subAr.HijoDer=nuevo;
                    }else{
                        subAr.HijoDer=iavl(nuevo, subAr.HijoDer);
                        if((obtenerFE(subAr.HijoDer)-obtenerFE(subAr.HijoIzq))==2){
                            nuevoPadre=(nuevo.Correo.charAt(pos)>subAr.HijoDer.Correo.charAt(pos))?
                               rotacionDerecha(subAr):
                               rotacionDobleDerecha(subAr);
                        }
                    }
                
                }else{
                    if(nuevo.Correo.charAt(pos)<subAr.Correo.charAt(pos)){
                        if(subAr.HijoIzq==null){
                            subAr.HijoIzq=nuevo;
                        }else{
                            subAr.HijoIzq=iavl(nuevo, subAr.HijoIzq);
                                if((obtenerFE(subAr.HijoIzq)-obtenerFE(subAr.HijoDer))==2){
                                    nuevoPadre=(nuevo.Correo.charAt(pos)<subAr.HijoIzq.Correo.charAt(pos))?
                                    rotacionIzquierda(subAr):
                                    rotacionDobleIzquierda(subAr);
                            }
                        }
                    }else{
                        if(subAr.HijoDer==null){
                            subAr.HijoDer=nuevo;
                        }else{
                            subAr.HijoDer=iavl(nuevo, subAr.HijoDer);
                            if((obtenerFE(subAr.HijoDer)-obtenerFE(subAr.HijoIzq))==2){
                                nuevoPadre=(nuevo.Correo.charAt(pos)>subAr.HijoDer.Correo.charAt(pos))?
                                   rotacionDerecha(subAr):
                                   rotacionDobleDerecha(subAr);
                            }
                        }
                    }
                }
            }else{
                if(nuevo.Correo.charAt(pos)<subAr.Correo.charAt(pos)){
                    if(subAr.HijoIzq==null){
                        subAr.HijoIzq=nuevo;
                    }else{
                        subAr.HijoIzq=iavl(nuevo, subAr.HijoIzq);
                            if((obtenerFE(subAr.HijoIzq)-obtenerFE(subAr.HijoDer))==2){
                                nuevoPadre=(nuevo.Correo.charAt(pos)<subAr.HijoIzq.Correo.charAt(pos))?
                                rotacionIzquierda(subAr):
                                rotacionDobleIzquierda(subAr);
                        }
                    }
                }else{
                    if(subAr.HijoDer==null){
                        subAr.HijoDer=nuevo;
                    }else{
                        subAr.HijoDer=iavl(nuevo, subAr.HijoDer);
                        if((obtenerFE(subAr.HijoDer)-obtenerFE(subAr.HijoIzq))==2){
                            nuevoPadre=(nuevo.Correo.charAt(pos)>subAr.HijoDer.Correo.charAt(pos))?
                               rotacionDerecha(subAr):
                               rotacionDobleDerecha(subAr);
                        }
                    }
                }
            }
        }
        
        //actualizando la altura
        if((subAr.HijoIzq==null)&&(subAr.HijoDer!=null)){
            subAr.fe=subAr.HijoDer.fe+1;
        }else if((subAr.HijoDer==null)&&(subAr.HijoIzq!=null)){
            subAr.fe=subAr.HijoIzq.fe+1;
        }else{
            subAr.fe=Math.max(obtenerFE(subAr.HijoDer),obtenerFE(subAr.HijoIzq))+1;
        }return nuevoPadre;
    }
    
}
