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
        <title>JSP Page</title>
    </head>
<body>

    <div>
        <!-- Imagen del evento -->
        <div>
            <%
                byte[] imagenBytes = (byte[]) request.getAttribute("evento.imagen");
                if(imagenBytes != null){
                    String base64Image = java.util.Base64.getEncoder().encodeToString(imagenBytes);
            %>
                <img src="data:image/jpeg;base64,<%= base64Image %>" alt="Imagen del Evento" width="150" />
            <%
                } else {
            %>
                <div>No hay imagen disponible.</div>
            <%
                }
            %>
        </div>

        <!-- Contenido principal -->
        <div>
            <h1>EVENTO: <s:property value="evento.nombreEvento" /></h1>
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
            <form>
                <s:hidden name="identificadorEvento" value="%{evento.idEvento}" />
                <s:submit value="Inscribirse" />
            </form>
        </div>
    </div>

</body>

</html>
