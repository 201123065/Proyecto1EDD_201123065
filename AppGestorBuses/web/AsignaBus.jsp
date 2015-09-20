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
                                <table border="1">
                                    <tr><td colspan="4"><select name="idBus">
                                        <option>aca van los buses</option>
                                            </select></td>
                                    </tr>
                                    <tr>
                                        <td colspan="4">
                                            <select name="ruta">
                                                <option>aqui van las rutas</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="4"> <select name="chofer">
                                                <option>aca van los choferes</option>
                                            </select>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="4">Hora:</td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">inicio</td><td colspan="2">fin</td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <input type="text" name="Hinicial" value="" />
                                        </td>
                                        <td colspan="2">
                                            <input type="text" name="Hfinal" value=""/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>fecha:</td>
                                        <td colspan="3"><select name="Dia">
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                                <option>6</option>
                                                <option>7</option>
                                                <option>8</option>
                                                <option>9</option>
                                                <option>10</option>
                                                <option>11</option>
                                                <option>12</option>
                                                <option>13</option>
                                                <option>14</option>
                                                <option>15</option>
                                                <option>16</option>
                                                <option>17</option>
                                                <option>18</option>
                                                <option>19</option>
                                                <option>20</option>
                                                <option>21</option>
                                                <option>22</option>
                                                <option>23</option>
                                                <option>24</option>
                                                <option>25</option>
                                                <option>26</option>
                                                <option>27</option>
                                                <option>28</option>
                                                <option>29</option>
                                                <option>30</option>
                                                <option>31</option>
                                            </select>
                                            <select name="mes">
                                                <option>enero</option>
                                                <option>febrero</option>
                                                <option>marzo</option>
                                                <option>abril</option>
                                                <option>mayo</option>
                                                <option>junio</option>
                                                <option>julio</option>
                                                <option>agosto</option>
                                                <option>septiembre</option>
                                                <option>octubre</option>
                                                <option>noviembre</option>
                                                <option>diciembre</option>
                                            </select>
                                            <select name="año">
                                                <option>2015</option>
                                                <option>2016</option>
                                                <option>2017</option>
                                                <option>2018</option>
                                                <option>2019</option>
                                                <option>2020</option>
                                                <option>2021</option>
                                                <option>2022</option>
                                                <option>2023</option>
                                                <option>2024</option>
                                                <option>2025</option>
                                            </select>

                                        </td>
                                    </tr>
                                    <tr>
                                        <td><input type="submit" value="Asignar" name="Asignar" /></td>
                                    </tr>
                                </table>
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


