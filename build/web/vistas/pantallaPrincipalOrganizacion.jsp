<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Detalles de la Organización</title>
        <style>
            /* =========================
               CSS para la vista principal
               ========================= */
            body {
                font-family: Arial, sans-serif;
                background-color: #f2f2f2;
                margin: 0;
                padding: 0;
            }
            .container {
                width: 90%;
                max-width: 1000px;
                margin: 40px auto;
                background-color: #fff;
                border-radius: 4px;
                box-shadow: 0 2px 4px rgba(0,0,0,0.1);
                padding: 20px;
            }
            h1 {
                margin-top: 0;
                margin-bottom: 10px;
                color: #333;
                text-align: center;
            }
            .info-org {
                margin-bottom: 30px;
                padding: 15px;
                background-color: #e9ecef;
                border-radius: 4px;
            }
            .info-org p {
                margin: 6px 0;
                color: #333;
                font-size: 15px;
            }
            .btn-crear-evento {
                display: inline-block;
                margin-bottom: 20px;
                padding: 8px 16px;
                background-color: #28a745;
                color: #fff;
                text-decoration: none;
                border-radius: 3px;
                font-size: 14px;
            }
            .btn-crear-evento:hover {
                background-color: #218838;
            }
            table.eventos {
                width: 100%;
                border-collapse: collapse;
            }
            table.eventos th,
            table.eventos td {
                padding: 12px 8px;
                border-bottom: 1px solid #ddd;
                text-align: left;
            }
            table.eventos th {
                background-color: #007bff;
                color: #fff;
                font-weight: normal;
            }
            table.eventos tr:hover {
                background-color: #f1f1f1;
            }
            .acciones-evento a {
                margin-right: 8px;
                font-size: 14px;
                text-decoration: none;
                color: #dc3545;
            }
            .acciones-evento a:hover {
                text-decoration: underline;
            }
            .sin-eventos {
                text-align: center;
                padding: 20px;
                color: #666;
                font-style: italic;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Organización: <s:property value="organizacion.nombre" /></h1>

            <!-- Información básica de la organización -->
            <div class="info-org">
                <p><strong>Id. Organización:</strong> <s:property value="organizacion.idOrganizacion" /></p>
                <p><strong>Nombre:</strong> <s:property value="organizacion.nombre" /></p>
                <p><strong>Dirección:</strong> <s:property value="organizacion.direccion" /></p>
                <!-- No mostramos password por seguridad -->
            </div>

            <!-- Botón para crear nuevo evento -->
            <a href="<s:url action='formCrearEvento'> 
                   <s:param name='idOrganizacion' value='%{organizacion.idOrganizacion}'/> 
               </s:url>"
               class="btn-crear-evento">
                + Crear Evento
            </a>

            <!-- Si no hay eventos, mensaje amigable -->
            <s:if test="eventos == null || eventos.empty">
                <div class="sin-eventos">
                    No hay eventos registrados para esta organización.
                </div>
            </s:if>

            <!-- Tabla de eventos existentes -->
            <s:if test="eventos != null && !eventos.empty">
                <table class="eventos">
                    <thead>
                        <tr>
                            <th>Id Evento</th>
                            <th>Capacidad</th>
                            <th>Información</th>
                            <th>Ubicación</th>
                            <th>Fecha</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="eventos" var="ev">
                            <tr>
                                <td><s:property value="#ev.idEvento" /></td>
                                <td><s:property value="#ev.capacidad" /></td>
                                <td><s:property value="#ev.informacion" /></td>
                                <td><s:property value="#ev.ubicacion" /></td>
                                <td><s:property value="#ev.fecha" /></td>
                                <td class="acciones-evento">
                                    <!-- Botón Eliminar: invoca el action eliminarEvento -->
                                    <a href="<s:url action='eliminarEvento'>
                                           <s:param name='idEvento' value='#ev.idEvento' />
                                           <s:param name='idOrganizacion' value='%{organizacion.idOrganizacion}'/>
                                       </s:url>">
                                        Eliminar
                                    </a>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:if>
        </div>
    </body>
</html>
