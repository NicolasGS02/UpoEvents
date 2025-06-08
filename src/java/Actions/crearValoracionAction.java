/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import JerseyClients.ValoracionesJerseyClient;
import Models.Valoraciones;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Pc
 */
public class crearValoracionAction extends ActionSupport {
    private String identificadorEvento;
    private String user;
    

    private int valoracion;
    private String comentario;
    
    
    
    public crearValoracionAction() {
    }
    
    public String execute() throws Exception {
        
        Valoraciones nuevaValoracion = new Valoraciones(null, Integer.parseInt(identificadorEvento) , user, comentario, valoracion);
        ValoracionesJerseyClient valoracionesClient = new ValoracionesJerseyClient();
        valoracionesClient.create_XML(nuevaValoracion);
    
        return SUCCESS;
    }

    public String getIdentificadorEvento() {
        return identificadorEvento;
    }

    public void setIdentificadorEvento(String identificadorEvento) {
        this.identificadorEvento = identificadorEvento;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
}
