<%-- 
    Document   : registrarUsuario
    Created on : 06-jun-2025, 17:14:11
    Author     : agarc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Regustrar Usuario</title>
        <link rel="stylesheet" href="<s:url value='/CSS/editarComentarioCSS.css' />">

    </head>
    <body>
        <div class="wrapper">
            
        <h1>Crear nueva cuenta de usuario:</h1>
        <s:form action="procesarFormUser">
            <s:textfield name="correo" label="Correo"/>

            <s:textfield name="nombre" label="Nombre"/>
            <s:password name="password" label="Password"/>

            <s:textfield name="escuela" label="Escuela a la que pertenece"/>

            <s:submit name="Registrar"/>
        </s:form>
        
        </div>
    </body>
</html>
