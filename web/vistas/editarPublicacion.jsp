<%-- 
    Document   : editarPublicacion
    Created on : 07-jun-2025, 18:21:00
    Author     : agarc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="<s:url value='/CSS/crearEventoCSS.css' />">
        <title>editar publicacion</title>
    </head>
    <body>
        <div class="wrapper">
            <h1>Editar Publicación <s:property value="pub.titulo"/>:</h1>

            <s:form action="editarPub" method="get">
                <s:hidden name="idPublicacion" value="%{idPublicacion}"/>
                <s:hidden name="idOrganizacion" value="%{pub.idOrganizacion}"/>
                <table class="form-table">
                    <tr>
                        <td class="field-cell">
                            <s:textfield name="titulo" label="Titulo" value="%{pub.titulo}"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="field-cell">
                            <s:textarea name="contenido" label="Contenido" value="%{pub.contenido}"/>
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
