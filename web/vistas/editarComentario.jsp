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
        <link rel="stylesheet" href="<s:url value='/CSS/editarComentarioCSS.css' />">

    </head>
    <body>
        <div class="wrapper">
        <h2>Modificando comentario en publicación: <s:property value="%{publicacionReferencia.titulo}" /></h2>
        <s:form action="actualizarComentario" >
            
            <s:textarea  name="nuevoComentario" value="%{comentarioModificar.comentario}" />
            <s:file name="imagenNueva"></s:file>
            <s:hidden name="idComentario" value="%{idComentario}"/>
            
            <s:submit value="Modificar Comentario" />
            
        </s:form>
        </div>

    </body>
</html>
