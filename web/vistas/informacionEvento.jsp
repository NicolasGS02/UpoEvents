<%-- 
    Document   : informacionEvento
    Created on : 05-jun-2025, 18:00:08
    Author     : Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Información</title>
        <link rel="stylesheet" href="<s:url value='/CSS/informacionEventoCSS.css' />">
    </head>
    <body>

        <div class="boton-volver-izquierda">
            <s:form action="vueltaAtras">
                <s:hidden name="correoUsuario" value="%{user}" />
                <s:submit value="Volver atrás" />
            </s:form>
        </div>




        <div>
            <!-- Imagen del evento -->
            <div>
                <%
                    byte[] imagenBytes = (byte[]) request.getAttribute("evento.imagen");
                    if (imagenBytes != null) {
                        String base64Image = java.util.Base64.getEncoder().encodeToString(imagenBytes);
                %>
                <img src="data:image/jpeg;base64,<%= base64Image%>" alt="Imagen del Evento" width="150" />
                <%
                } else {
                %>
                <div>No hay imagen disponible.</div>
                <%
                    }
                %>
            </div>

            <!-- Contenido principal -->
            <div class="evento-info">
                <h1>EVENTO: <s:property value="evento.nombreEvento" /></h1>
                <h3>ORGANIZADO POR: <s:property value="%{org.nombre}" /></h3>
                <h3>Valoración actual: <s:property value="mediaValoraciones" /></h3>
                <p><s:property value="evento.informacion" /></p>
            </div>


            <!-- Fila con detalles tipo tarjetas -->
            <div>
                <div>
                    <p>⏰</p>
                    <h3><s:property value="evento.capacidad" /></h3>
                    <p>Número de Participantes</p>
                </div>

                <div>
                    <p>📍</p>
                    <h3><s:property value="evento.ubicacion" /></h3>
                    <p>Ubicación</p>
                </div>

                <div>
                    <p>📅</p>
                    <h3><s:property value="evento.fecha" /></h3>
                    <p>Fecha del evento</p>
                </div>
            </div>

            <!-- Botón de acción -->
            <div>
                <s:if test="noPermitir != true">
                    <s:form action="InscribirUsuario">


                        <s:hidden name="identificadorEvento" value="%{evento.idEvento}" />
                        <s:hidden name="correoUsuario" value="%{user}" />

                        <s:submit value="Inscribirse" />    



                    </s:form>
                </s:if>

                <hr>

                <div class="valoracion-evento">
                    <h2>Valoraciones del evento:</h2>

                    <s:form action="dejarValoracionEvento">
                        <s:textarea name="comentario" label="Reseña:" />
                        <s:textfield name="valoracion" label="Valoración (1 al 5)" />
                        <s:hidden name="identificadorEvento" value="%{evento.idEvento}" />
                        <s:hidden name="user" value="%{user}" />
                        <s:submit value="Valorar." />
                    </s:form>
                </div>


                <s:iterator value="listaValoraciones" var="valoraciones">

                    <div class="valoracion-cuadro">
                        <h3>Usuario: <s:property value="#valoraciones.correo" /></h3>
                        <p><s:property value="#valoraciones.comentario" /></p>
                        <p>Valoración: <s:property value="#valoraciones.Puntuacion" /></p>
                        <%-- IMAGEN VA AQUÍ SI LA AÑADES --%>

                        <s:if test="#valoraciones.correo == user">
                            <s:form action="eliminarValoracion">
                                <s:hidden name="idValoracion" value="%{#valoraciones.idValoracion}"/>    
                                <s:submit value="Borrar Valoración" cssClass="btn btn-delete"/>
                            </s:form>
                        </s:if>
                    </div>

                </s:iterator>





            </div>
        </div>

    </body>

</html>
