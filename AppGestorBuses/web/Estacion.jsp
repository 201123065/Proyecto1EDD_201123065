<%-- 
    Document   : EstacionClave
    Created on : 16-sep-2015, 15:47:52
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
        <h1>Estaci&oacute;n clave</h1>
        <form action="Hora" method="POST">
            <select name="Bus">
                <option>buses que deben llegar a esta estacion</option>
            </select>
            <input type="text" name="hora" value="" />
            personas:<input type="text" name="noPersonas" value="" />
            
        </form>
    </body>
</html>
