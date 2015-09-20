/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.LogManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import webservice.WSGestionUsuario_Service;

/**
 *
 * @author marcosmayen
 */
@WebServlet(name = "SAutentifica", urlPatterns = {"/SAutentifica"})
public class SAutentificar extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WSBuses/WSGestionUsuario.wsdl")
    private WSGestionUsuario_Service service;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/WSBus/WSGestionUsuario.wsdl")
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String Usuario = request.getParameter("txtUsuario");
        String Contrasena = request.getParameter("txtPass");
        String Tipo = request.getParameter("TipoUsu");
        
        
        if(validar(Usuario, Contrasena, Tipo)==false){
            response.sendRedirect("index.jsp");
            
        }else{
            Cookie cookie = new Cookie("Usuario", Usuario);
            if(Tipo.equals("Administrador")){
                response.addCookie(cookie);
                HttpSession sesion = request.getSession();
                sesion.setAttribute("VentanaUsuario", Usuario);
                
                response.sendRedirect("main.jsp");
            }
            else if(Tipo.equals("Chofer")){
                HttpSession sesion = request.getSession();
                sesion.setAttribute("VentanaUsuario", Usuario);
                response.sendRedirect("VerBusAsignado.jsp");
                response.addCookie(cookie);
            }
            else if(Tipo.equals("Estación")){
                HttpSession sesion = request.getSession();
                sesion.setAttribute("VentanaUsuario", Usuario);
                response.sendRedirect("Estacion.jsp");
                response.addCookie(cookie);
            }
        }
            
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private Boolean validar(java.lang.String usuario, java.lang.String contrasena, java.lang.String tipo) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.WSGestionUsuario port = service.getWSGestionUsuarioPort();
        return port.validar(usuario, contrasena, tipo);
    }


    

}
