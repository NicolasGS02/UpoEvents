<%-- 
    Document   : editarPublicacion
    Created on : 07-jun-2025, 18:21:00
    Author     : agarc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>editar publicacion</title>
    </head>
    <body>
        <h1>Editar Publicación</h1>

        <s:form action="editarPub" method="get">
            <s:hidden name="idPublicacion" value="%{idPublicacion}"/>
            <s:hidden name="idOrganizacion" value="%{pub.idOrganizacion}"/>
            <s:textfield name="titulo" label="Titulo" value="%{pub.titulo}"/>
            <s:textarea name="contenido" label="Contenido" value="%{pub.contenido}"/>
             
            <s:submit value="Editar"/>
        </s:form>

    </body>
</html>
