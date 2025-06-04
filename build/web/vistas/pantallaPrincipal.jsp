<%-- 
    Document   : pantallaPrincipal
    Created on : 22-may-2025, 20:50:25
    Author     : Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <body>
        <h1>Bienvenido: <s:property value="user.nombre"></s:property> </h1>
    </body>
</html>
