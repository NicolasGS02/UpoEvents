<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Login Organización</title>

        <link rel="stylesheet" href="<s:url value='/CSS/pantallaLoginOrgCSS.css' />">

    </head>
    <body>
        <div class="login-container">
            <!-- Mensajes de error del Action, si existen -->
            <s:if test="hasActionErrors()">
                <div class="error-messages">
                    <s:actionerror/>
                </div>
            </s:if>

            <!-- Logo centrado -->
            <img src="imagenes/lupo_400x400.jpg" alt="Logo Upo">

            <!-- Título -->
            <h2>Login Organización</h2>

            <!-- Formulario de login de organización -->
            <s:form action="loginOrg" method="post">
                <table>
                    <tr>

                        <td><s:textfield name="orgId" id="orgId" label="OrgID"/></td>
                    </tr>
                    <tr>

                        <td><s:password name="orgPassword" id="orgPassword" label="Contraseña"/></td>
                    </tr>
                </table>
                <s:submit value="Ingresar" cssClass="btn"/>
            </s:form>

            <s:form action="" method="get">
                <s:submit value="Registrarse" cssClass="btn secondary-btn" />
            </s:form>     

        </div>
    </body>
</html>
