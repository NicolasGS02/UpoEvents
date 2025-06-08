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
public class LoginOrgAction extends ActionSupport {

    private String identificador;
    private String password;
    private Organizaciones org;

    public LoginOrgAction() {
    }

    public String execute() throws Exception {

        OrganizacionesJerseyClient userControl = new OrganizacionesJerseyClient();

      
        this.org = userControl.find_XML(Organizaciones.class, identificador);

        return SUCCESS;

    }

    public void validate() {
        if(this.identificador == null || this.identificador.trim().isEmpty()){
            addFieldError("identificador", "El identificador es obligatorio");
        }
        if(this.password == null || this.password.trim().isEmpty()){
            addFieldError("password", "La contraseña es obligatoria");
        }
       
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Organizaciones getOrg() {
        return org;
    }

    public void setOrg(Organizaciones org) {
        this.org = org;
    }

}
