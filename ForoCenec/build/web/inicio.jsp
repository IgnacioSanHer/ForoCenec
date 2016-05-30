<%-- 
    Document   : index
    Created on : 25-may-2015, 9:36:42
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>INICIO FORO</title>
    </head>
    <body>
        <form method="post" action="RecibirDatosEntrar">
        USUARIO:</br>
        <input type="text" name="usuarioExistente" id="usuario"></p>
        CONTRASEÑA:</br>
        <input type="password" name="passwordExistente" id="password"></p>        
        <input type="submit" value="ENTRAR" name="entrarForo" id="entrarForo"></p>
        </form>
        
        <form method="post" action="registrar.jsp">
        <input type="submit" value="¿AUN NO ESTAS REGISTRADO?" name="registrarse" id="registrarse"></p>
        </form>
    </body>
</html>
