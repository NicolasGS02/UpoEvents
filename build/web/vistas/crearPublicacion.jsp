<%-- 
    Document   : crearPublicacion
    Created on : 07-jun-2025, 13:52:31
    Author     : agarc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>alta Publicacion</title>
    </head>
    <body>
        <h1>Nueva Publicación para:<br/><s:property value="idOrganizacion"/></h1>
        
        <s:form action="crearPublicacion" method="post">
              <s:hidden name="idOrganizacion" value="%{idOrganizacion}"/>
            <table class="form-table">
                <tr>
                    <td class="field-cell">
                        <s:textfield name="titulo" id="titulo" label="Titulo"/>
                    </td>
                </tr>
                <tr>
                    <td class="field-cell">
                        <s:textarea name="contenido" id="contenido" label="Contenido"/>
                    </td>
                </tr>
               
                
            </table>
            <div class="buttons">
                <button type="submit" class="btn btn-primary">Guardar Publicación</button>
                <a href="<s:url action='verOrganizacion'><s:param name='idOrganizacion' value='%{idOrganizacion}'/></s:url>" 
                   class="btn btn-secondary">Cancelar</a>
            </div>
        </s:form>
    </body>
</html>
