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
public class GuardarDatosOrgAction extends ActionSupport {
    private String nombre;
    private String direccion;
    private String password;
    private Integer idOrganizacion;
    Organizaciones org = new Organizaciones();
    OrganizacionesJerseyClient orgClient = new OrganizacionesJerseyClient();
    public GuardarDatosOrgAction() {
    }
    
    public String execute() throws Exception {
        org = new Organizaciones(idOrganizacion, nombre, direccion, password);
        orgClient.edit_XML(org, Integer.toString(org.getIdOrganizacion()));
        System.err.println("-----------" + org);
        return SUCCESS;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(int idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    public OrganizacionesJerseyClient getOrgClient() {
        return orgClient;
    }

    public void setOrgClient(OrganizacionesJerseyClient orgClient) {
        this.orgClient = orgClient;
    }
    
}
