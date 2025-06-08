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
        <link rel="stylesheet" href="<s:url value='/CSS/crearEventoCSS.css' />">
    </head>
    <body>
        <div class="wrapper">
            <s:form action="editarOrg" method="get">
                <s:hidden name="idOrganizacion" value="%{idOrganizacion}"/>
                <table class="form-table">
                    <tr>
                        <td class="field-cell">
                            <s:textfield name="nombre" label="Nombre" value="%{org.nombre}"/> 
                        </td>
                    </tr>
                    <tr>
                        <td class="field-cell">
                            <s:textfield name="direccion" label="Dirección" value="%{org.direccion}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="field-cell">
                            <s:textfield name="password" label="Contraseña" value="%{org.password}"/>
                        </td>
                    </tr>
                </table>
                <div class="buttons">
                    <button type="submit" class="btn btn-primary">Editar</button>
                    <a href="<s:url action='verOrganizacion'><s:param name='idOrganizacion' value='%{idOrganizacion}'/></s:url>" 
                       class="btn btn-secondary">Cancelar</a>

                    </div>
            </s:form>

        </div>

    </body>
</html>
