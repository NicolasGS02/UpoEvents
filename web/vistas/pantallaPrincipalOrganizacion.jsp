<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Pantalla Principal de Organización</title>
    </head>
    <body>
        <h1>Bienvenido, Organización: <s:property value="organizacion.nombre"/></h1>
        <p>DEBUG: idOrganizacion en JSP = <s:property value="organizacion.idOrganizacion" /></p>
        <s:url id="urlShowCrearEvento" action="formCrearEvento">
            <s:param name="idOrganizacion" value="%{organizacion.idOrganizacion}"/>

        </s:url>

        <!-- Botón / enlace -->
        <a href="<s:property value="urlShowCrearEvento"/>">
            <button>Crear Nuevo Evento</button>
        </a>

        <hr/>


        <h2>Mis Eventos</h2>
        <s:if test="eventos == null or eventos.size() == 0">
            <p>Aún no existen eventos para esta organización.</p>
        </s:if>
        <s:else>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Capacidad</th>
                    <th>Información</th>
                    <th>Ubicación</th>
                    <th>Fecha</th>
                    <th>Acciones</th>
                </tr>
                <s:iterator value="eventos" status="st">
                    <tr>
                        <td><s:property value="idEvento"/></td>
                        <td><s:property value="capacidad"/></td>
                        <td><s:property value="informacion"/></td>
                        <td><s:property value="ubicacion"/></td>
                        <td><s:property value="fecha"/></td>
                        <td>
                            <!-- Botón para eliminar este evento -->
                            <s:url id="urlDeleteEvento" action="eliminarEvento">
                                <s:param name="idEvento" value="%{idEvento}" />
                                <s:param name="idOrganizacion" value="%{organizacion.idOrganizacion}"/>

                            </s:url>
                            <a href="<s:property value="urlDeleteEvento"/>">
                                <button>Eliminar Evento</button>
                            </a>



                        </td>
                    </tr>
                </s:iterator>
            </table>
        </s:else>


        <s:actionerror/>
    </body>
</html>
