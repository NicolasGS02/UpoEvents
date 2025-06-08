/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import JerseyClients.ComentarioPublicacionesJerseyClient;
import Models.Comentariopublicaciones;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;

/**
 *
 * @author Pc
 */
public class CrearComentarioAction extends ActionSupport {

    private String user;
    private int idPublicacion;
    private String contenidoComentario;
    
    
    
    public CrearComentarioAction() {
    }
    
    public String execute() throws Exception {

        Comentariopublicaciones comentarioNuevo = new Comentariopublicaciones(null, this.user,this.idPublicacion , this.contenidoComentario, new Date());
        ComentarioPublicacionesJerseyClient comPublicClient = new ComentarioPublicacionesJerseyClient();
        comPublicClient.create_XML(comentarioNuevo);
        

        return SUCCESS;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public String getContenidoComentario() {
        return contenidoComentario;
    }

    public void setContenidoComentario(String contenidoComentario) {
        this.contenidoComentario = contenidoComentario;
    }
    
    
    
}
