<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Login Organización</title>
        <style>
            body {
                margin: 0;
                padding: 0;
                background-color: #f2f2f2;
                font-family: Arial, sans-serif;
            }
            .login-container {
                width: 320px;
                margin: 100px auto;
                background: #fff;
                border-radius: 5px;
                box-shadow: 0 2px 4px rgba(0,0,0,0.1);
                padding: 20px;
                box-sizing: border-box;
                text-align: center;
            }
            .login-container img {
                display: block;
                max-width: 150px;
                margin: 0 auto 20px auto; /* Centro horizontal y espacio inferior */
            }
            .login-container h2 {
                margin-top: 0;
                margin-bottom: 20px;
                color: #333;
            }
            .login-container table {
                width: 100%;
                border-collapse: collapse;
            }
            .login-container td {
                padding: 8px 0;
            }
            .login-container td:first-child {
                width: 100px;
                text-align: right;
                padding-right: 10px;
                font-weight: bold;
                color: #555;
            }
            .login-container td:last-child input {
                width: 100%;
                padding: 6px 8px;
                border: 1px solid #ccc;
                border-radius: 3px;
                box-sizing: border-box;
            }
            .error-messages {
                color: #dc3545;
                font-size: 13px;
                margin-bottom: 10px;
                text-align: center;
            }
            .btn {
                display: inline-block;
                width: 100%;
                padding: 8px 0;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 3px;
                font-size: 14px;
                cursor: pointer;
                text-decoration: none;
                text-align: center;
                margin-top: 15px;
            }
            .btn:hover {
                background-color: #0056b3;
            }
            .secondary-btn {
                
                background-color: #6c757d;
            }
            .secondary-btn:hover {
                background-color: #5a6268;
            }
        </style>
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
