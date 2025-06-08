<%-- 
    Document   : editarEvento
    Created on : 07-jun-2025, 18:20:51
    Author     : agarc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Editar Evento:</h1>
        <s:form action="editarEve" method="get">
            <s:hidden name="idEvento" value="%{idEvento}"/>
            <s:hidden name="idOrganizacion" value="%{eve.idOrganizacion}"/>
            <s:hidden name="idEntrada" value="%{idEntrada}"/>
            
            <s:textfield name="capacidad" label="Capacidad" value="%{eve.capacidad}"/>
            <s:textfield name="nombreEvento" label="Nombre" value="%{eve.nombreEvento}"/>
            <s:textarea name="informacion" label="Información" value="%{eve.informacion}"/>
            <s:textfield name="ubicacion" label="Ubicación" value="%{eve.ubicacion}"/>
            <s:textfield name="fecha" label="Fecha" value="%{eve.fecha}"/>
            <s:textfield name="precio" label="Precio" value="%{entrada.precio}"/>
            <s:submit value="Editar"/>
        </s:form>
    </body>
</html>
