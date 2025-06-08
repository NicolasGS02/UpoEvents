/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import JerseyClients.EntradasJerseyClient;
import JerseyClients.EventosJerseyClient;
import Models.Entradas;
import Models.Eventos;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author agarc
 */
public class mostrarFormEditarEventoAction extends ActionSupport {
    private int idEvento;
    private Integer idOrganizacion;
    Eventos eve = new Eventos();
    private int idEntrada;
    Entradas a = new Entradas();
    EventosJerseyClient eClient = new EventosJerseyClient();
    EntradasJerseyClient aClient = new EntradasJerseyClient();
    
    public mostrarFormEditarEventoAction() {
    }
    
    public String execute() throws Exception {
        List<Entradas> listadoA = new ArrayList<>();
     GenericType<List<Entradas>> genericoEntradas = new GenericType<List<Entradas>>() {};
     listadoA = aClient.findAll_XML(genericoEntradas);
        for (int i = 0; i < listadoA.size(); i++) {
            if(listadoA.get(i).getIdEvento() == idEvento){
                idEntrada = listadoA.get(i).getIdEntrada();
                break;
            }
        }
     eve = eClient.find_XML(Eventos.class, Integer.toString(idEvento));
     
     a = aClient.find_XML(Entradas.class, Integer.toString(idEntrada));
     return SUCCESS;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public Integer getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(Integer idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    public Eventos getEve() {
        return eve;
    }

    public void setEve(Eventos eve) {
        this.eve = eve;
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public Entradas getA() {
        return a;
    }

    public void setA(Entradas a) {
        this.a = a;
    }

    public EventosJerseyClient geteClient() {
        return eClient;
    }

    public void seteClient(EventosJerseyClient eClient) {
        this.eClient = eClient;
    }

    public EntradasJerseyClient getaClient() {
        return aClient;
    }

    public void setaClient(EntradasJerseyClient aClient) {
        this.aClient = aClient;
    }
    
}
