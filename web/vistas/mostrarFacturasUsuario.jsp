<%-- 
    Document   : mostrarFacturasUsuario
    Created on : 08-jun-2025, 17:26:44
    Author     : Pc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Facturas</title>
        <link rel="stylesheet" href="<s:url value='/CSS/facturasCSS.css' />">
    </head>
    <body>

        <s:form action="vueltaAtras">
            <s:hidden name="correoUsuario" value="%{user}" />
            <s:submit value="Volver atrás" />
        </s:form>


        <div class="facturas-container">
            <s:iterator value="listadoFacturas" var="facutas">
                <div class="factura-cuadro">
                    <h3>Usuario: <s:property value="%{user}" /></h3>
                    <p>Tarjeta: <s:property value="#facutas.tarjeta" /></p>
                    <p>Fecha Compra: <s:property value="#facutas.fechaCompra" /></p>
                </div>
            </s:iterator>
        </div>




    </body>
</html>
