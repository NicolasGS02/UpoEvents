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
public class borrarValoracionAction extends ActionSupport {
    private String user;
    private String identificadorEvento;
    
    private int idValoracion;
    
    
    public borrarValoracionAction() {
    }
    
    public String execute() throws Exception {

        ValoracionesJerseyClient valoracionClient = new ValoracionesJerseyClient();
        Valoraciones val = valoracionClient.find_XML(Valoraciones.class,Integer.toString(idValoracion));
        valoracionClient.remove(Integer.toString(idValoracion));
        
        this.user = val.getCorreo();
        this.identificadorEvento = Integer.toString(val.getIdEvento());

        return SUCCESS;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getIdentificadorEvento() {
        return identificadorEvento;
    }

    public void setIdentificadorEvento(String identificadorEvento) {
        this.identificadorEvento = identificadorEvento;
    }

    public int getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(int idValoracion) {
        this.idValoracion = idValoracion;
    }
    
}
