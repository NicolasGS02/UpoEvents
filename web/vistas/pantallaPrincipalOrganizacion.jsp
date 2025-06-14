<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Pantalla Principal de Organización</title>

        <link rel="stylesheet" href="<s:url value='/CSS/pantallaPrincipalOrganizacionCSS.css' />">
    </head>
    <body>
        <header>
           
            <s:url id="urlShowEditarDatosOrg" action="formEditOrg">
                <s:param name="idOrganizacion" value="%{idOrganizacion}"/>
            </s:url>
            <a href="<s:property value="urlShowEditarDatosOrg"/>">
                Editar datos Organización
            </a>

            <s:url id="urlShowCrearEvento" action="formCrearEvento">
                <s:param name="idOrganizacion" value="%{idOrganizacion}"/>
            </s:url>
            <a href="<s:property value="urlShowCrearEvento"/>">
                Crear Nuevo Evento
            </a>

            <s:url id="urlShowCrearPublicacion" action="formCrearPubli">
                <s:param name="idOrganizacion" value="%{idOrganizacion}"/>
            </s:url>
            <a href="<s:property value="urlShowCrearPublicacion"/>">
                Crear Nueva Publicación
            </a>

            <s:url id="urlLogin" action="vistaPrincipal"/> 
            <a href="<s:property value='urlLogin'/>" class="btnLogout">
                Cerrar Sesión
            </a>
        </header>


        <h1>Bienvenido, Organización: <s:property value="organizacion.nombre"/></h1>
        <h2>Mis Eventos</h2>
        <s:if test="eventos == null or eventos.size() == 0">
            <p>Aún no existen eventos para esta organización.</p>
        </s:if>
        <s:else>
            <table>
                <tr>

                    <th>Capacidad</th>
                    <th>Nombre</th>
                    <th>Información</th>
                    <th>Ubicación</th>
                    <th>Fecha</th>
                    <th>Precio</th>
                    <th>Acciones</th>
                </tr>
                <s:iterator value="eventos" var="eve">
                    <tr>

                        <td><s:property value="#eve.capacidad"/></td>
                        <td><s:property value="#eve.nombreEvento"/></td>
                        <td><s:property value="#eve.informacion"/></td>
                        <td><s:property value="#eve.ubicacion"/></td>
                        <td><s:property value="#eve.fecha"/></td>
                        <td>
                            <s:iterator value="entradas" var="en">
                                <s:if test="#en.idEvento == #eve.idEvento">
                                    <s:property value="#en.precio"/> €
                                </s:if>
                            </s:iterator>
                        </td>
                        <td>
                            <s:form action="eliminarEvento">
                                <s:hidden name="idEvento" value="%{#eve.idEvento}" />
                                <s:hidden name="idOrganizacion" value="%{organizacion.idOrganizacion}" ></s:hidden>

                                <s:submit value="Eliminar"></s:submit>       
                            </s:form>
                            <s:form action="formEditEve">
                                <s:hidden name="idEvento" value="%{#eve.idEvento}" />
                                <s:hidden name="idOrganizacion" value="%{#eve.idOrganizacion}" />
                                
                                <s:submit value="Editar"></s:submit>       
                            </s:form>
                        </td>
                    </tr>
                </s:iterator>
            </table>
        </s:else>
        <h2>Mis Publicaciones</h2>
        <s:if test="publicaciones == null or publicaciones.size() == 0">
            <p>Aún no existen publicaciones para esta organización.</p>
        </s:if>
        <s:else>
            <table>
                <tr>

                    <th>Titulo</th>
                    <th>Contenido</th>
                    <th>Fecha Publicación</th>

                    <th>Acciones</th>
                </tr>
                <s:iterator value="publicaciones" var="pub">
                    <tr>

                        <td><s:property value="#pub.titulo"/></td>
                        <td><s:property value="#pub.contenido"/></td>
                        <td><s:property value="#pub.fechaPublicacion"/></td>

                        <td>
                            <s:form action="eliminarPublicacion">
                                <s:hidden name="idPublicacion" value="%{#pub.idPublicacion}" />
                                <s:hidden name="idOrganizacion" value="%{organizacion.idOrganizacion}" ></s:hidden>

                                <s:submit value="Eliminar"></s:submit>       
                            </s:form>
                            <s:form action="formEditPub">
                                <s:hidden name="idPublicacion" value="%{#pub.idPublicacion}" />
                                <s:hidden name="idOrganizacion" value="%{#pub.idOrganizacion}" ></s:hidden>

                                <s:submit value="Editar"></s:submit>       
                            </s:form>


                        </td>
                    </tr>
                </s:iterator>
            </table>
        </s:else>

    </body>
</html>
