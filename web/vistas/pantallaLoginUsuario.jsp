<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Iniciar Sesión</title>
    <link rel="stylesheet" href="<s:url value='/CSS/pantallaLoginOrgCSS.css' />">

    </head>
    <body>
        <div class="login-container">

            
            <h1>Upo Events</h1>
            <img src="imagenes/lupo_400x400.jpg" alt="Logo Upo">
            <s:form action="login" method="post">

               
                <table>
                    <tr>
                        <td><s:textfield name="identificador" id="identificador" label="Usuario"/></td>
                    </tr>
                    <tr>
                        <td><s:password name="password" id="password"  label="Contraseña"/></td>
                    </tr>
                </table>
                <br/>
                <s:submit value="Log In" cssClass="btn"/>
            </s:form>



            <s:form action="FormRegistrarUser">
                <s:submit value="Registrarse" cssClass="btn secondary-btn" />
            </s:form>



            <a href="<s:url action='formLoginOrg'/>" class="link-small">
                ¿Eres organización? Inicia sesión aquí
            </a>
        </div>
    </body>
</html>
