/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import JerseyClients.OrganizacionesJerseyClient;
import Models.Organizaciones;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author agarc
 */
public class mostrarFormEditarOrgAction extends ActionSupport {

    private Integer idOrganizacion;
    private Organizaciones org = new Organizaciones();
    OrganizacionesJerseyClient client = new OrganizacionesJerseyClient();
    

    public mostrarFormEditarOrgAction() {
    }

    public String execute() throws Exception {
       org = client.find_XML(Organizaciones.class, Integer.toString(idOrganizacion));
        System.err.println("-----------" + org);
        return SUCCESS;
    }

    public int getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(int idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    public Organizaciones getOrg() {
        return org;
    }

    public void setOrg(Organizaciones org) {
        this.org = org;
    }

    public OrganizacionesJerseyClient getClient() {
        return client;
    }

    public void setClient(OrganizacionesJerseyClient client) {
        this.client = client;
    }

}
