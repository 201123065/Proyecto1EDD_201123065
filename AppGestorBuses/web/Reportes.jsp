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
        <table border="0">
            <thead>
                <tr>
                    <th></th>
                    <th></th>
                    <th></th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td><input type="submit" value="Administrador AVL" name="adminAVL" /></td>
                    <td><input type="submit" value="Lista Estaciones" name="ListaEstacinoes" /></td>
                    <td><input type="submit" value="Choferes AVL" name="choferesAVL" /></td>
                </tr>
                <tr>
                    <td><select name="ListaChoferes">
                            <option>ListaChoferes</option>
                        </select></td>
                        <td><input type="submit" value="Lista de este chofer" name="ListaChofer" /></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>

    </body>
</html>
