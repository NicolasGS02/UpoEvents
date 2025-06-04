<%-- 
    Document   : index.jsp
    Created on : 04-jun-2025, 21:58:59
    Author     : agarc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       
        <%
            // Redirige inmediatamente a la acción Struts que muestra el login
            response.sendRedirect("vistaPrincipal.action");
        %>

    </body>
</html>
