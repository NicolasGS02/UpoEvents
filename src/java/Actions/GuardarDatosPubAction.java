/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import JerseyClients.PublicacionesJerseyClient;
import Models.Publicaciones;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;

/**
 *
 * @author agarc
 */
public class GuardarDatosPubAction extends ActionSupport {

    private String titulo;
    private String contenido;
    private int idPublicacion;
    private Integer idOrganizacion;
    Publicaciones pub = new Publicaciones();
    PublicacionesJerseyClient pubClient = new PublicacionesJerseyClient();

    public GuardarDatosPubAction() {
    }

    public String execute() throws Exception {
        pub = new Publicaciones(idPublicacion, idOrganizacion, titulo, contenido, new Date());
        pubClient.edit_XML(pub, Integer.toString(pub.getIdPublicacion()));
        
        return SUCCESS;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public Integer getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(Integer idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
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

}
