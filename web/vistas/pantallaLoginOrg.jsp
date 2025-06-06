<%-- 
    Document   : pantallaLoginOrg
    Created on : 04-jun-2025, 19:01:49
    Author     : agarc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Organizacion</title>
        <link rel="stylesheet" href="<s:url value='/CSS/pantallaLoginOrgCSS.css' />">

    </head>
    <body>
        <div class="login-container">


            <s:form action="loginOrg">
                <img src="imagenes/lupo_400x400.jpg" alt="Logo Upo">

                <s:textfield name="identificador" label="Organizacion"></s:textfield>
                <s:password name="password" label="Contraseña"></s:password>
                <s:submit value="Log In" cssClass="btn"></s:submit>

            </s:form>
            <s:submit value="Registrarse" cssClass="btn secondary-btn" />

         
        </div>
    </body>
</html>
