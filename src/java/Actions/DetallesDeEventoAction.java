/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import JerseyClients.EventosJerseyClient;
import JerseyClients.OrganizacionesJerseyClient;
import Models.Eventos;
import Models.Organizaciones;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Pc
 */
public class DetallesDeEventoAction extends ActionSupport {
    
    private String user;
    private String identificadorEvento;
    private Eventos evento;
    private Organizaciones org;
    
    public DetallesDeEventoAction() {
    }
    
    public String execute() throws Exception {
        
        //CONSEGUMOS EL EVENTO
        
        EventosJerseyClient eventoClient = new  EventosJerseyClient();
        this.evento = eventoClient.find_XML(Eventos.class,identificadorEvento);
        
        eventoClient.close();
        
        //CONSEGIMOS LA ORGANIZACION
        OrganizacionesJerseyClient organizacionClient = new OrganizacionesJerseyClient();
        this.org = organizacionClient.find_XML(Organizaciones.class,Integer.toString(evento.getIdOrganizacion()));
        
        organizacionClient.close();
        
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

    public Organizaciones getOrg() {
        return org;
    }

    public void setOrg(Organizaciones org) {
        this.org = org;
    }


    public Eventos getEvento() {
        return evento;
    }

    public void setEvento(Eventos evento) {
        this.evento = evento;
    }
    
}
