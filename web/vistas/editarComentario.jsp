<%-- 
    Document   : editarComentario
    Created on : 08-jun-2025, 2:41:31
    Author     : Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Comentario</title>
    </head>
    <body>
        <h2>Modificando comentario en publicación: <s:property value="%{publicacionReferencia.titulo}" /></h2>
        <s:form action="actualizarComentario" >
            
            <s:textfield name="nuevoComentario" value="%{comentarioModificar.comentario}" />
            <s:file name="imagenNueva"></s:file>
            <s:hidden name="idComentario" value="%{idComentario}"/>
            
            <s:submit value="Modificar Comentario" />
            
        </s:form>
    </body>
</html>
