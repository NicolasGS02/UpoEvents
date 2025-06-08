<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Crear Nuevo Evento</title>
        <link rel="stylesheet" href="<s:url value='/CSS/crearEventoCSS.css' />">
    </head>
    <body>
        
        <div class="wrapper">
            

            <h1>Nuevo Evento para:<br/><s:property value="idOrganizacion"/></h1>
        

            <s:form action="crearEvento" method="post" accept-charset="UTF-8">
                <s:hidden name="idOrganizacion" value="%{idOrganizacion}"/>
                <table class="form-table">
                    <tr>
                        <td class="field-cell">
                            <s:textfield name="nombreEvento" id="nombre" label="Nombre"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="field-cell">
                            <s:textfield name="capacidad" id="capacidad" label="Capacidad"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="label-cell">
                            <s:textarea name="informacion" id="informacion" label="Información"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="field-cell">
                            <s:textfield name="ubicacion" id="ubicacion" label="Ubicación"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="field-cell">
                            <s:textfield name="fecha" id="fecha" placeholder="DD/MM/YYYY" label="Fecha"/>
                        </td>
                    </tr>
                    <tr>
                        <td class="field-cell">
                            <s:textfield name="precio" id="precio"  label="Precio de las Entradas(€)"/>
                        </td>
                    </tr>
                </table>
                <div class="buttons">
                    <button type="submit" class="btn btn-primary">Guardar Evento</button>
                    <a href="<s:url action='verOrganizacion'><s:param name='idOrganizacion' value='%{idOrganizacion}'/></s:url>" 
                       class="btn btn-secondary">Cancelar</a>
                    </div>
            </s:form>
        </div>
    </body>
</html>
