/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import JerseyClients.ComentarioPublicacionesJerseyClient;
import Models.Comentariopublicaciones;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Pc
 */
public class eliminarComentarioAction extends ActionSupport {
    private String user;
    private String idPublicacion;
    
    private int idComentario;
    
    
    
    
    public eliminarComentarioAction() {
    }
    
    public String execute() throws Exception {

    ComentarioPublicacionesJerseyClient comPublicCliente = new ComentarioPublicacionesJerseyClient();
    Comentariopublicaciones antiguo = comPublicCliente.find_XML(Comentariopublicaciones.class,Integer.toString(idComentario));
    
    comPublicCliente.remove( Integer.toString(antiguo.getIdComentario()));
    
    
        this.user = antiguo.getCorreo();
        this.idPublicacion = Integer.toString(antiguo.getIdPublicacion());
    
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

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }
    
    
    
    
}
