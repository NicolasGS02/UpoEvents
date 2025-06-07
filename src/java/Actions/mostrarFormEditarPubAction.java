/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import JerseyClients.PublicacionesJerseyClient;
import Models.Publicaciones;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author agarc
 */
public class mostrarFormEditarPubAction extends ActionSupport {
    
    private int idPublicacion;
    private Integer idOrganizacion;
    private Publicaciones pub = new Publicaciones();
    PublicacionesJerseyClient pubClient = new PublicacionesJerseyClient();
    public mostrarFormEditarPubAction() {
    }
    
    public String execute() throws Exception {
      pub = pubClient.find_XML(Publicaciones.class, Integer.toString(idPublicacion));
      return SUCCESS;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public Publicaciones getPub() {
        return pub;
    }

    public void setPub(Publicaciones pub) {
        this.pub = pub;
    }

    public PublicacionesJerseyClient getPubClient() {
        return pubClient;
    }

    public void setPubClient(PublicacionesJerseyClient pubClient) {
        this.pubClient = pubClient;
    }

    public void setIdOrganizacion(Integer idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }
    
}
