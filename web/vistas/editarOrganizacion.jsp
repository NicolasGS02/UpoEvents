<%-- 
    Document   : editarOrganizacion
    Created on : 07-jun-2025, 17:26:51
    Author     : agarc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>editar organizacion</title>
    </head>
    <body>

        <s:form action="editarOrg" method="get">
            <s:hidden name="idOrganizacion" value="%{idOrganizacion}"/>
            <s:textfield name="nombre" label="Nombre" value="%{org.nombre}"/>
            <s:textfield name="direccion" label="Dirección" value="%{org.direccion}"/>
            <s:textfield name="password" label="Contraseña" value="%{org.password}"/>
            <s:submit value="Editar"/>
        </s:form>

    </body>
</html>
