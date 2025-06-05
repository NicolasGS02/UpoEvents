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

<h3>Tus futuros Eventos:</h3>
<%--Lista de eventos para el Usuario--%>
            
<s:if test="todosEventos != null && !todosEventos.isEmpty()">
    <table border="1">
        <tr>
            <th>Nombre</th>
            <th>Información</th>

        </tr>
        <s:iterator value="eventosUsuario" var="evento">
            <tr>
                <td><s:property value="#evento.nombreEvento" /></td>
                <td><s:property value="#evento.informacion" /></td>
                
                <td>
                    <s:form action="detalleEventos">

                        <s:hidden name="identificadorEvento" value="%{#evento.idEvento}" />
                        <s:hidden name="user" value="user" ></s:hidden>
                        
                        <s:submit value="Ver detalles."></s:submit>       
                    </s:form>
                </td>
            </tr>
        </s:iterator>
    </table>
</s:if>

<s:else>
    <p>No Te has registrado en Ningun Evento</p>
</s:else>


<%--Lista de eventos GLOBAL --%>
        
        <h3>TODOS los Eventos:</h3>

<s:if test="todosEventos != null && !todosEventos.isEmpty()">
    <table border="1">
        <tr>
            <th>Nombre</th>
            <th>Información</th>

        </tr>
        <s:iterator value="todosEventos" var="evento">
            <tr>
                <td><s:property value="#evento.nombreEvento" /></td>
                <td><s:property value="#evento.informacion" /></td>
            </tr>
        </s:iterator>
    </table>
</s:if>

<s:else>
    <p>No hay eventos disponibles.</p>
</s:else>
        
        
        
        
    </body>
</html>
