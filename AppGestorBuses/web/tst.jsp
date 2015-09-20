<%@ page import="java.io.*" %>
<HTML>
    <HEAD>
        <TITLE>carga archivo prueba</TITLE>
        <script type="text/javascript" src="./javascript/funcion.js"></script>
        
    </HEAD>

    <BODY>
        
        <BR>

        <form name="formulario" enctype="multipart/form-data"  method="POST">
            Selecciona el archivo:<input type="file" onchange="cargarArchivo(this)" name="archivo"><br/>
            <input type="submit" name="proceso" value="Cargar Archivo">
            <input type="hidden" name="nombre" value=""/>
            <iframe name="null" style="diplay:none;" ></iframe>
        </form>
        
        
        
        
    </BODY>
</HTML>