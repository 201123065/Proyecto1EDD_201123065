
package webservice;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import Chofer.ChoferAVL;
import Estacion.EstacionAVL;
@WebService(serviceName = "WSGestionUsuario")
public class WSGestionUsuario {

    public WSGestionUsuario(){
        nuevo = new AdminAVL();
        piloto = new ChoferAVL();
        Estacion = new EstacionAVL();
    }
    
    @WebMethod(operationName = "Validar")
    public Boolean Validar(@WebParam(name = "Usuario") String Usuario, @WebParam(name = "Contrasena") String Contrasena, @WebParam(name = "Tipo") String Tipo) {
        if(Usuario!=""&&Contrasena!=""){
            if(Tipo.equals("Administrador")){
               return nuevo.Login(Usuario, Contrasena);
            }else if(Tipo.equals("Chofer")){
                return piloto.Login(Usuario, Contrasena);
            }else if(Tipo.equals("Estacion")){
                return Estacion.Login(Integer.parseInt(Usuario), Contrasena);
            }
        }
        return false;
    }
    AdminAVL nuevo;
    @WebMethod(operationName = "RegistroAdmin")
    public String RegistroAdmin(@WebParam(name = "Usuario") String Usuario, @WebParam(name = "pass") String pass) {
        nuevo.insertar(Usuario, pass);
        return "ingresado satisfactoriamente";
    }
    ChoferAVL piloto;
    @WebMethod(operationName = "RegistroChofer")
    public String RegistroChofer(@WebParam(name = "Clave") String Clave, @WebParam(name = "Nombre") String Nombre, @WebParam(name = "Apellido") String Apellido, @WebParam(name = "Pass") String Pass) {
        piloto.insertar(Clave, Nombre, Apellido,Pass);
        return "registrado";
    }
    EstacionAVL Estacion;
    @WebMethod(operationName = "RegistroEstacion")
    public String RegistroEstacion(@WebParam(name = "id") int id, @WebParam(name = "Nombre") String Nombre, @WebParam(name = "Pass") String Pass, @WebParam(name = "Tipo") String Tipo) {
        Estacion.insertar(id, Nombre, Pass,Tipo);
        return "Estacion Agregada Correctamente";
    }

  
    
    
    
}
