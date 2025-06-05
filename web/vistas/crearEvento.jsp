<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Crear Nuevo Evento</title>
    
</head>
<body>
    <div class="wrapper">
        <!-- Título centrado -->
        <h1>Crear Evento para:<br/><s:property value="organizacionNombre"/></h1>

        <!-- Mensajes de error (si existen) -->
        <s:if test="hasFieldErrors()">
            <div class="error">
                <s:fielderror fieldName="evento.capacidad"/><br/>
                <s:fielderror fieldName="evento.informacion"/><br/>
                <s:fielderror fieldName="evento.ubicacion"/><br/>
                <s:fielderror fieldName="fechaEvento"/>
            </div>
        </s:if>

        <s:form action="crearEvento" method="post">
            <!-- Campo oculto para la organización -->
            <s:hidden name="evento.idOrganizacion" value="%{idOrganizacion}"/>

            <!-- Tabla centrada que alinea label y campo en paralelo -->
            <table class="form-table">
                <tr>
                    
                    <td class="field-cell">
                        <s:textfield name="evento.capacidad" id="capacidad" label="Capacidad"/>
                    </td>
                </tr>
                <tr>
                    <td class="label-cell">
                        <s:textarea name="evento.informacion" id="informacion" label="Información"/>
                    </td>
                </tr>
                <tr>
                    
                    <td class="field-cell">
                        <s:textfield name="evento.ubicacion" id="ubicacion" label="Ubicación"/>
                    </td>
                </tr>
                <tr>
                    
                    <td class="field-cell">
                        <s:textfield name="fechaEvento" id="fecha" placeholder="YYYY-MM-DD" label="Fecha"/>
                    </td>
                </tr>
            </table>

            <!-- Botones centrados debajo del formulario -->
            <div class="buttons">
                <button type="submit" class="btn btn-primary">Guardar Evento</button>
                <a href="<s:url action='verOrganizacion'><s:param name='idOrganizacion' value='%{idOrganizacion}'/></s:url>" 
                   class="btn btn-secondary">Cancelar</a>
            </div>
        </s:form>
    </div>
</body>
</html>
