<%-- 
    Document   : mostrarPublicacionCompleta
    Created on : 07-jun-2025, 23:11:30
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
        <s:form action="vueltaAtras">
            <s:hidden name="correoUsuario" value="%{user}" />
            <s:submit value="Volver atrás" />
        </s:form>
        
        
        <h1><s:property value="%{publicacion.titulo}" /> </h1>

        <h3><s:property value="%{publicacion.contenido}" /></h3>
        
                <!-- Imagen del evento -->

        
        
        <p>Publicado el: <s:property value="%{publicacion.fechaPublicacion}" /> </p>
        
        <hr>
        <h1>Comentarios:</h1>
        <p>Deja un comentario:</p>
        <s:form action="crearComentario">
            
            <s:textarea name="contenidoComentario" ></s:textarea>
            <s:hidden name="idPublicacion" value="%{publicacion.idPublicacion}" />
            <s:hidden name="user" value="%{user}" />
            
            <s:file name="imagen"></s:file>
            <s:submit value="COMENTAR."></s:submit>
            
        </s:form>
        
        <hr>
        
        <s:iterator value="listadoComentarios" var="comentarios">
            
            
            <table>
                <h3>Usuario:<s:property value="#comentarios.correo" /></h3>
                <p><s:property value="#comentarios.comentario" /></p>
                <%-- IAMGEN VA AQUI --%>
                <p><s:property value="#comentarios.fechaComentario" /></p>
                <s:if test="#comentarios.correo == user">
                    <s:form action="editarComentarioUsuario">
                        
                        <s:hidden name="idComentario" value="%{#comentarios.idComentario}"></s:hidden>
                        <s:submit value="Editar comentario"></s:submit>
                        
                    </s:form>
                    
                    <s:form action="eliminarComentario">
                        <s:hidden name="idComentario" value="%{#comentarios.idComentario}"/>    
                        <s:submit value="Borrar Comentario" />
                    </s:form>
                        


                </s:if>
                
            </table>
            
            
        </s:iterator>
        

    </body>
</html>
