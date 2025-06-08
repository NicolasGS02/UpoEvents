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
public class GuardarDatosComentarioAction extends ActionSupport {
    
    //PARA REDIRECT CORRECTO
    private String user;
    private String idPublicacion;
    
    private int idComentario;
    private String nuevoComentario;
    
    
    public GuardarDatosComentarioAction() {
    }
    
    public String execute() throws Exception {
        

        ComentarioPublicacionesJerseyClient comPublicCliente = new ComentarioPublicacionesJerseyClient();
        
        Comentariopublicaciones antiguo = comPublicCliente.find_XML(Comentariopublicaciones.class,Integer.toString(idComentario));
        
        Comentariopublicaciones actualizado = new Comentariopublicaciones(antiguo.getIdComentario(),antiguo.getCorreo(),antiguo.getIdPublicacion(),nuevoComentario,new Date());
        
        comPublicCliente.edit_XML(actualizado, Integer.toString(idComentario));
        
        comPublicCliente.close();
        
        this.user = actualizado.getCorreo();
        this.idPublicacion = Integer.toString(actualizado.getIdPublicacion());
        
        return SUCCESS;
    }

    public String getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(String idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    
    
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getNuevoComentario() {
        return nuevoComentario;
    }

    public void setNuevoComentario(String nuevoComentario) {
        this.nuevoComentario = nuevoComentario;
    }
    
}
