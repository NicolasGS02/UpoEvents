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
        <link rel="stylesheet" href="<s:url value='/CSS/pantallaPrincipalUsuarioCSS.css' />">
        <title>Inicio</title>
    </head>
    <body>
        <h1>UpoEvents</h1>
        <s:form action="vistaPrincipal">
            <s:submit value="Cerrar Sesión." cssClass="btn"></s:submit>       
        </s:form>

        <h2>Usuario: <s:property value="user.nombre"></s:property> </h2>

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
                                <s:hidden name="user" value="%{user.correo}" />

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

        <h3>Eventos disponibles :</h3>

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

                        <td>
                            <s:form action="detalleEventos">

                                
                                <s:hidden name="identificadorEvento" value="%{#evento.idEvento}" />
                                <s:hidden name="user" value="%{user.correo}" />

                                <s:submit value="Ver detalles."></s:submit>       
                            </s:form>
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
