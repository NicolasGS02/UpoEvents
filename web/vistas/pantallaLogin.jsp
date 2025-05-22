<%-- 
    Document   : pantallaLogin
    Created on : 22-may-2025, 13:32:39
    Author     : Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesion</title>
    </head>
    <body>
        
        <s:form action="login">
            <img src="imagenes/lupo_400x400.jpg" alt="Logo Upo">
            
            <s:textfield name="identificador" label="Usuario"></s:textfield>
            <s:password name="password" label="Contraseña"></s:password>
            <s:submit value="Log In"></s:submit>
            
        </s:form>
        <s:form action="">
            <s:submit value="Registrarse"></s:submit>
        </s:form>
      
    </body>
</html>
