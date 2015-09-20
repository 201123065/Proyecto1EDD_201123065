<%-- 
    Document   : index
    Created on : 15-sep-2015, 21:52:49
    Author     : marcosmayen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
	<meta charset="UTF-8">
	<title>Inicio</title>
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
        <section id="galeria">
            <div id="cont_galeria">
                            <div id="slidegaleria">
                                    <ul>
                                            <li>
                                                <img src="Imagenes/transm.png" width="345px" height="211px" alt=""/>
                                            </li>
                                    </ul>
                            </div><!-- fin del div slidegaleria -->
                            <h1><strong>El transporte del futuro</strong></h1>
                            <p>
                                Con total éxito se celebraron los ocho años de Transmetro, el sistema que desde sus 
                                inicios ha movilizado a 625 millones de usuarios y para conmemorar este aniversario 
                                se contó con la presencia de nuestro Alcalde Alvaro Arzú, y funcionarios de la Empresa 
                                Municipal de Transporte –EMT-.
                            </p>
                           
                    </div><!-- fin del div cont_galeria -->
            </section><!-- fin de la galeria -->
    <div class="nf"></div>
    <section id="contenido">
            <div id="cont_contenido">
                    <article id="post">
                            <h1><strong>Bienvenido</strong>
                            </h1>
                            <p>
                            <h2>Utilice su tarjeta SIGA para el ingreso a las estaciones según su categoría:</h2>
                            <ul>
                                
                                <li>Ciudadano</li>
                                <li>Infantil</li>
                                <li>Corporativa</li>
                                <li>Dorada</li>
                                <li>Estudiante</li>
                            </ul>
                            </br>
                            
                            <ul>
                                <li>Sea cortés con las personas de edad avanzada</li>
                                <li>con alguna capacidad física diferente</li>
                                <li>mujeres embarazadas o con niños en brazos</li>
                            </ul>

                            <h4>Los sillones amarillos son destinados especialmente para estos usuarios. Cédalos a quien los necesite.</h4>
                            </br>
                        

                    </article>
                    <aside id="slide">
                            <ul>
                                <li><a href="#"><img src="Imagenes/Bienvenido.png" alt="" width="200" height="50"/></a></li>
                                 
                            </ul>
                            <div id="icons_sociales">
                                <form action="SAutentifica" method="POST" >
                                    <table border ="0" syle="margin-left:28%;">
                                        <tr>
                                            <td>Usuario</td>
                                            <td><input type="text" name="txtUsuario" value="" required="requiered"/></td>
                                        </tr>
                                        <tr>
                                            <td>Contraseña</td>
                                            <td><input type="password" name="txtPass" value="" required="required" /></td>
                                        </tr>
                                        <tr>
                                            <td>Tipo</td>
                                            <td>
                                                <select name="TipoUsu">
                                                    <option value="Administrador">Administrador</option>
                                                    <option value="Chofer">Chofer</option>
                                                    <option value="Estación">Estacion</option>
                                                </select></td> 
                                            </td>
                                        </tr>
                                        <tr>
                                            <td><input type="submit" value="Ingresar" name="btnIngresar" /></td>
                                        </tr>

                                    </table>
                                </form>
                            </div><!-- fin del div icons_sociales -->
                    </aside>
            </div><!-- fin del div cont_contenido -->
    </section><!-- fin del section contenido -->
    <div class="nf"></div>
    
    <footer>
        <div id="cont_footer">
                <p>Maquetado Por <a href="http://twitter.com/ivlarks">Marcos Mayen</a></p>
        </div>
    </footer>
    </body>
</html>
