<%-- 
    Document   : editarEvento
    Created on : 07-jun-2025, 18:20:51
    Author     : agarc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<s:url value='/CSS/crearEventoCSS.css' />">
        <title>Editar Evento</title>
    </head>
    <body>
        <div class="wrapper">
            <h1>Editar Evento <s:property value="eve.nombreEvento"/>:</h1>
            <s:form action="editarEve">
                <s:hidden name="idEvento" value="%{idEvento}"/>
                <s:hidden name="idOrganizacion" value="%{eve.idOrganizacion}"/>
                <s:hidden name="idEntrada" value="%{a.idEntrada}"/>
                <table class="form-table">
                    <tr>
                        <td class="field-cell">
                            <s:textfield name="capacidad" label="Capacidad" value="%{eve.capacidad}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="field-cell">
                            <s:textfield name="nombreEvento" label="Nombre" value="%{eve.nombreEvento}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="field-cell">
                            <s:textarea name="informacion" label="Información" value="%{eve.informacion}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="field-cell">
                            <s:textfield name="ubicacion" label="Ubicación" value="%{eve.ubicacion}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="field-cell">
                            <s:textfield name="fecha" label="Fecha" value="%{eve.fecha}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="field-cell">
                            <s:textfield name="precio" label="Precio" value="%{a.precio}"/>
                        </td>
                    </tr>
                </table>
                <div class="buttons">
                    <button type="submit" class="btn btn-primary">Guardar</button>
                    <a href="<s:url action='verOrganizacion'><s:param name='idOrganizacion' value='%{idOrganizacion}'/></s:url>" 
                       class="btn btn-secondary">Cancelar</a>
                    </div>

            </s:form>
        </div>

    </body>
</html>
