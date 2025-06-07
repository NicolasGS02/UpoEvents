/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import JerseyClients.UsuariosJerseyClient;
import Models.Usuarios;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Pc
 */
public class vueltaAtras extends ActionSupport {
    
    private String correoUsuario;
    private Usuarios user;
    
    public vueltaAtras() {
    }
    
    public String execute() throws Exception {
        
        UsuariosJerseyClient usuarioClient = new UsuariosJerseyClient();
        this.user = usuarioClient.find_XML(Usuarios.class, correoUsuario);
        
        return SUCCESS;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }
    
}
