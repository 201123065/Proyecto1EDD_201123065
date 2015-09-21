<%-- 
    Document   : creaAdmin
    Created on : 21-sep-2015, 1:43:26
    Author     : marcosmayen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Asignar Ruta</title>
        <link rel="stylesheet" href="Codigo.css">
    </head>
    <body>
        <header>
            <div id="cont_header">
                <div id="logo">
                    <a href="#"><img src="Imagenes/tu.jpg" alt="" width="70px" height="70px"/></a>
                </div><!-- fin del logo -->
            </div><!-- fin del div cont-header -->
        </header>
        
        <section id="contenido">
            <div id="cont_contenido">
                <div id="gridAdmin">
                    <div class="fullcelda">
                        <form action="RegistraAdmin" method="POST">
                            <table border="0">
                                <tr>
                                    <td>Correo</td>
                                    <td><input type="text" name="id" value="" required="requied" /></td>
                                </tr>
                                <tr>
                                    <td>Contraseña</td>
                                    <td><input type="text" name="txtPass" value=""required="requied" /></td>
                                </tr>
                                <tr>
                                    <td>confirmar contraseña</td>
                                    <td><input type="text" name="txtConfirm" value="" required="requied"/></td>
                                </tr>                         
                                <tr>
                                    <td>Agregar</td>
                                    <td><input type="submit" value="Agregar" name="btnAgregar" /></td>
                                </tr>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </section>
            <div class="nf"></div>
        <section id="prefooter">
            <div id="cont_prefooter">
                    <section id="state">
                            
                    </section> <!-- fin del section state -->
            </div><!-- fin del div cont_prefooter -->
    </section><!-- fin del section prefooter -->
            <form enctype="multipart/form-data" action="uploader.php" method="POST">
    <input name="uploadedfile" type="file" />
    <input type="submit" value="Subir archivo" />
        <footer>
            <div id="cont_footer">
                    <p>Maquetado Por <a href="http://twitter.com/ivlarks">Marcos Mayen</a></p>
            </div>
        </footer>
    </body>
</html>
