<%-- 
    Document   : pantallaPrincipal
    Created on : 22-may-2025, 20:50:25
    Author     : Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
    </head>
    <h1>UpoEvents</h1>
    
    
    <body>
        <h1>Bienvenido: <s:property value="user.nombre"></s:property> </h1>
        
        <%--Lista de eventos --%>
        
        <h3>Lista de Eventos:</h3>

<s:if test="todosEventos != null && !todosEventos.isEmpty()">
    <table border="1">
        <tr>
            <th>Nombre</th>
            <th>Ubicación</th>
            <th>Fecha</th>
            <th>Capacidad</th>
            <th>Información</th>
            <th>Imagen</th>
        </tr>
        <s:iterator value="todosEventos" var="evento">
            <tr>
                <td><s:property value="#evento.nombreEvento" /></td>
                <td><s:property value="#evento.ubicacion" /></td>
                <td><s:date name="#evento.fecha" format="dd/MM/yyyy" /></td>
                <td><s:property value="#evento.capacidad" /></td>
                <td><s:property value="#evento.informacion" /></td>
                <td>
                    <s:if test="#evento.imagen != null">
                        <img src="data:image/png;base64,<s:property value="@org.apache.commons.codec.binary.Base64@encodeBase64String(#evento.imagen)" />" width="100" height="100"/>
                    </s:if>
                    <s:else>No hay imagen</s:else>
                </td>
            </tr>
        </s:iterator>
    </table>
</s:if>

<s:else>
    <p>No hay eventos disponibles.</p>
</s:else>
        
        
        
        
    </body>
</html>
