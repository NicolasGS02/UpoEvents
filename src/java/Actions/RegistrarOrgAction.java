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
public class RegistrarOrgAction extends ActionSupport {
    private String nombre;
    private String direccion;
    private String password;
    
    OrganizacionesJerseyClient orgClient = new OrganizacionesJerseyClient();
    public RegistrarOrgAction() {
    }
    
    public String execute() throws Exception {
        System.out.println("datos form ------- " + nombre + direccion + password);
        Organizaciones org = new Organizaciones(null, nombre, direccion, password);
        orgClient.create_XML(org);
        return SUCCESS;
    }
    public void validate(){
        if(this.nombre == null || this.nombre.isEmpty()){
            addFieldError("nombre", "Debe completar el campo con nombre para la organización");
        }
        if(this.direccion == null || this.direccion.isEmpty()){
            addFieldError("direccion", "Debe completar el campo con dirección para la organización");
        }
        if(this.password == null || this.password.isEmpty()){
            addFieldError("password", "Debe completar el campo con una contraseña valida");
        }
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
    
}
