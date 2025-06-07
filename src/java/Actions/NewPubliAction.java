/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import JerseyClients.PublicacionesJerseyClient;
import Models.Publicaciones;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author agarc
 */
public class NewPubliAction extends ActionSupport {

    private int idOrganizacion;
    private String titulo;
    private String contenido;
    private Date fechaPublicacion;
    private byte[] imagen;
    
    PublicacionesJerseyClient publiNueva = new PublicacionesJerseyClient();

    public NewPubliAction() {
    }

    public String execute() throws Exception {
       Date fechaActual = new Date();
        Publicaciones p = new Publicaciones(null, idOrganizacion, titulo, contenido, fechaActual);
        System.out.println("<-------------" + p);
        publiNueva.create_XML(p);
        return SUCCESS;
    }

    public void validate() {
        if (this.contenido == null || this.contenido.trim().isEmpty()) {
            addFieldError("contenido", "Debe escribir el contenido de la publicación.");
        }
       
    }

    public int getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(int idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
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

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

   

    public PublicacionesJerseyClient getPubliNueva() {
        return publiNueva;
    }

    public void setPubliNueva(PublicacionesJerseyClient publiNueva) {
        this.publiNueva = publiNueva;
    }

    

    

}
