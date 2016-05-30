<%-- 
    Document   : registrar
    Created on : 25-may-2015, 10:16:11
    Author     : alumno
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script src="funciones.js"></script>
        <title>REGISTRATE</title>
    </head>
    <body>
        <form method="post" action="RecibirDatosRegistrar">
        USUARIO:</br>
        <input type="text" name="usuarioRegistrarse" id="usuarioRegistrarse"></p>
        CONTRASEÑA:</br>
        <input type="password" name="passwordRegistrarse" id="passwordRegistrarse" onMouseOut="javascript:repitePassword();" required></p>
        REPITE LA CONTRASEÑA:</br>
        <input type="password" name="passwordRepe" id="passwordRepe" onMouseOut="javascript:repitePassword();"></p>
        <input type="submit" name="registrarse" id="registrarse" value="REGISTRATE">
        </form>
    </body>
</html>
