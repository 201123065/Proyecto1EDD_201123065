<%-- 
    Document   : AsignaBus
    Created on : 16-sep-2015, 15:11:45
    Author     : marcosmayen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Asignar Ruta</title>
        <script type="text/javascript" src="./javascript/funcion.js"></script>
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
                        <form action="asignacionBus" method="POST">
                            <div id="asignacion">
                                
                        </div>
                        </form>
                        <form name="formulario" enctype="multipart/form-data"  method="POST">
                           
                            Selecciona el archivo:<input type="file" onchange="cargarArchivo(this)" name="archivo"><br/>
                            
                            <input type="submit" name="proceso" value="Cargar Archivo">
                            <input type="hidden" name="nombre" value=""/>
                            
                        </form>
                        
                    </div>
                </div>
            </div>
            <div>
                
            </div>
        </section>
            <div class="nf"></div>
        <section id="prefooter">
            <div id="cont_prefooter">
                <section id="state">
                
                </section> <!-- fin del section state -->
            </div><!-- fin del div cont_prefooter -->
    </section><!-- fin del section prefooter -->
            
    <input name="uploadedfile" type="file" />
    <input type="submit" value="Subir archivo" />
        <footer>
            <div id="cont_footer">
                    <p>Maquetado Por <a href="http://twitter.com/ivlarks">Marcos Mayen</a></p>
            </div>
        </footer>
    </body>
</html>


