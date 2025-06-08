/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import JerseyClients.ComentarioPublicacionesJerseyClient;
import JerseyClients.PublicacionesJerseyClient;
import Models.Comentariopublicaciones;
import Models.Publicaciones;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Pc
 */
public class DetallesPublicacionAction extends ActionSupport {
    
    //Guardamos el login para la vuelta.
    private String user;
    
    private String idPublicacion;
    private Publicaciones publicacion;
    
    List<Comentariopublicaciones> listadoComentarios = new ArrayList<>();
    
    
    
    public DetallesPublicacionAction() {
    }
    
    public String execute() throws Exception {
        
        //Conseguir los datos de la publicacion
        PublicacionesJerseyClient publicacionClient = new PublicacionesJerseyClient();
        this.publicacion = publicacionClient.find_XML(Publicaciones.class, idPublicacion);
        
        
        //Ahora conseguimos los comentaruios
        ComentarioPublicacionesJerseyClient comPublicacionClient = new ComentarioPublicacionesJerseyClient();
        GenericType<List<Comentariopublicaciones>> genericoComPublicacion = new GenericType<List<Comentariopublicaciones>>() {};
        this.listadoComentarios = comPublicacionClient.findAll_XML(genericoComPublicacion);
        
        Iterator<Comentariopublicaciones> iterator = listadoComentarios.iterator();

       while (iterator.hasNext()) {
           Comentariopublicaciones comentario = iterator.next();
           if (!idPublicacion.equals(Integer.toString(comentario.getIdPublicacion()))) {
               iterator.remove(); 
           }
       }
        
        
        
        return SUCCESS;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(String idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public Publicaciones getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Publicaciones publicacion) {
        this.publicacion = publicacion;
    }

    public List<Comentariopublicaciones> getListadoComentarios() {
        return listadoComentarios;
    }

    public void setListadoComentarios(List<Comentariopublicaciones> listadoComentarios) {
        this.listadoComentarios = listadoComentarios;
    }
    
    
    
}
