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

/**
 *
 * @author Pc
 */
public class prepararComentarioAction extends ActionSupport {
     
    private String idComentario;
    private Comentariopublicaciones comentarioModificar;
    private Publicaciones publicacionReferencia;
    
    public prepararComentarioAction() {
    }
    
    public String execute() throws Exception {
        
        
        //Cogemos comentario a modficar
        ComentarioPublicacionesJerseyClient comPublicCliente = new ComentarioPublicacionesJerseyClient();
        this.comentarioModificar = comPublicCliente.find_XML(Comentariopublicaciones.class, idComentario);
        
        //Cogemos la publicacion correspondiente.
        PublicacionesJerseyClient publicacionClient = new PublicacionesJerseyClient();
        this.publicacionReferencia = publicacionClient.find_XML(Publicaciones.class,Integer.toString( comentarioModificar.getIdPublicacion()));
        
        
        return SUCCESS;
    }

    public String getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(String idComentario) {
        this.idComentario = idComentario;
    }



    public Comentariopublicaciones getComentarioModificar() {
        return comentarioModificar;
    }

    public void setComentarioModificar(Comentariopublicaciones comentarioModificar) {
        this.comentarioModificar = comentarioModificar;
    }

    public Publicaciones getPublicacionReferencia() {
        return publicacionReferencia;
    }

    public void setPublicacionReferencia(Publicaciones publicacionReferencia) {
        this.publicacionReferencia = publicacionReferencia;
    }


    
}
