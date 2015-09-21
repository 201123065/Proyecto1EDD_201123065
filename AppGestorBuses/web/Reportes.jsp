<%-- 
    Document   : Reportes
    Created on : 16-sep-2015, 16:03:11
    Author     : marcosmayen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Reportes</h1>
        <form name="Reportes" action="verReportes" method="POST">
            AVL:
            <select name="TipoReporte">
                <option value="Administradores">Administrador</option>
                <option value="Choferes">Chofer</option>
                <option value="Estación">Estacion</option>
            </select>
            <input type="submit" value="Administrador AVL" name="adminAVL" />
        </form>
        

    </body>
</html>
