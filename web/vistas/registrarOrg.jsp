<%-- 
    Document   : registrarOrg
    Created on : 06-jun-2025, 17:14:21
    Author     : agarc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>registro org</title>
        <link rel="stylesheet" href="<s:url value='/CSS/editarComentarioCSS.css' />">

    </head>
    <body>
        <div class="wrapper">
        <s:fielderror/>
        <h1>Crear nueva cuenta para su Organización:</h1>
        <s:form action="procesarForm">
            <s:textfield name="nombre" label="Nombre"/>
            <s:textfield name="direccion" label="Dirección"/>
            <s:password name="password" label="Contraseña"/>
            <s:submit name="Registrar"/>
        </s:form>
        </div>
    </body>
</html>
