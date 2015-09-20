<%-- 
    Document   : main
    Created on : 15-sep-2015, 22:05:04
    Author     : marcosmayen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<meta charset="UTF-8">
	<title>Indice</title>
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
                    <div class="celda">
                        <h1>Buses</h1>
                        <ul>
                            <li><h2><a href="CreaBuses.jsp">Crear</a></h2></li>
                            <li><h2><a href="AsignaBus.jsp">Asignar</a></h2></li>
                            <li><h2><a href="Ruta.jsp">Ruta</a></h2></li>
                        </ul>
                    </div>
                    <div class="celda">
                        <h1>Choferes</h1>
                        <ul>
                            <li><h2><a href="CreaChofer.jsp">Crear</a></h2></li>
                        </ul>
                    </div>
                    <div class="celda">
                        <h1>Estación</h1>
                        <ul>
                            <li><h2><a href="Estacion.jsp">Crear</a></h2></li>
                            <li><h2><a href="AsignaBus.jsp">Asignar</a></h2></li>
                            <li><h2><a href="Ruta.jsp">Ruta</a></h2></li>
                        </ul>
                    </div>
                    <div class="celda">
                        <h1>Administrador</h1>
                        <ul>
                            <li><h2><a href="Estacion.jsp">Crear</a></h2></li>
                            <li><h2><a href="AsignaBus.jsp">Asignar</a></h2></li>
                            <li><h2><a href="Ruta.jsp">Ruta</a></h2></li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>
            <div class="nf"></div>
        <section id="prefooter">
            <div id="cont_prefooter">
                    <section id="state">Bienvenido 
                        <%Cookie[] cook = request.getCookies();
                        out.println(cook[1].getValue()+" ");%>
                    </section> <!-- fin del section state -->
            </div><!-- fin del div cont_prefooter -->
            <div><a href="index.jsp">Cerrar Sesion</a></div>
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
