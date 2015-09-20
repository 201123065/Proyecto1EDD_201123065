<%-- 
    Document   : Agregar
    Created on : 16-sep-2015, 7:35:04
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
        <h1>Hello World!</h1>
        <form name="AddAdmin" action="SRegistro" method="POST">
            <table border="0">
                <tr>
                    <td>Correo</td>
                    <td><input type="text" name="txtCorreo" value="" /></td>
                </tr>
                <tr>
                    <td>Contraseña</td>
                    <td><input type="password" name="txtPass" value="" /> </td>
                </tr>
                <tr>
                    <td>Confirmar Contraseña</td>
                    <td><input type="password" name="ConfirmaC" value="" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Agregar" name="btnAdd" /></td>
                </tr>
            </table>
        </form>
    </body>
</html>
