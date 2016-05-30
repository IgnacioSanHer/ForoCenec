<%-- 
    Document   : mostrarComentarios
    Created on : 26-may-2015, 12:36:13
    Author     : alumno
--%>

<%@page import="java.util.Vector"%>
<%@page import="paqueteClases.Comentario"%>
<%@page import="paqueteClases.BaseDatos"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%  Vector vector_comentarios=new Vector();
    vector_comentarios=BaseDatos.cogerComentario();
    String comentarios="";
    for(int i=0;i<vector_comentarios.size();i++){
        comentarios+="<div class='comentario'><div id='arriba'>"+((Comentario)vector_comentarios.elementAt(i)).getUsuario()+""
                + " dijo el dia "+((Comentario)vector_comentarios.elementAt(i)).getFecha()+""
                + " a las "+((Comentario)vector_comentarios.elementAt(i)).getHora()+"</div><br>"
                +((Comentario)vector_comentarios.elementAt(i)).getComentario()+"</p></div>";
    }
    %>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estilos.css">
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>FORO CENEC</title>
    </head>
    <body>
        <form method="post" action="RecibirDatosComentar">
            <%=comentarios%>
            <input type="hidden" value="" name="usuario" id="usuario">
            <textarea id="areaComentario" name="areaComentario" rows="10" cols="70"></textarea></p>
            <input type="submit" id="comentar" value="COMENTAR">
        </form>
    </body>
</html>
