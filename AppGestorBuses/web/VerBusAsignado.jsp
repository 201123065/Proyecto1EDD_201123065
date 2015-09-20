<%-- 
    Document   : VerBusAsignado
    Created on : 17-sep-2015, 11:40:20
    Author     : marcosmayen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mis Rutas</title>
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
                        <form method="POST" action ="VerBusAsignado.jsp"> 
                            <select name="Fecha">
                                <option></option>
                            </select>
                            <input type="submit" value="Verificar" name="Verifica" />
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
