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
    </head>
    <body>
        
        <s:form action="vueltaAtras">
            <s:hidden name="correoUsuario" value="%{user}" />
            <s:submit value="Volver atrás" />
        </s:form>
    
    
            <s:iterator value="listadoFacturas" var="facutas">
            
                
                <table>
                    
                    <h3>Usuario:<s:property value="%{user}" /></h3>
                    <p>Tarjeta:<s:property value="#facutas.tarjeta" /></p>
                    <p>Valoracion: <s:property value="#facutas.fechaCompra" /></p>

                </table>


            </s:iterator>
    
    
        
    </body>
</html>
