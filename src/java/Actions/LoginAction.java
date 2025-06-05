/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import JerseyClients.EventosJerseyClient;
import JerseyClients.UsuariosJerseyClient;
import Models.Eventos;

import Models.Usuarios;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import javax.ws.rs.core.GenericType;


/**
 *
 * @author Pc
 */
public class LoginAction extends ActionSupport {

    private String identificador;
    private String password;
    private Usuarios user;


    public LoginAction() {
    }

    public String execute() throws Exception {
        
        String respuesta = "success";

        UsuariosJerseyClient userControl = new UsuariosJerseyClient();
        
        //Comprobamos que no haya dejado algún valor del formulario Vacio.
        if (identificador.equals("") || password.equals("")) {

            respuesta = "error";
        } else {

            this.user = userControl.find_XML(Usuarios.class, identificador);
            
            //Miramos si la contraseña es la misma.
            if (!user.getPassword().equals(password)) {
                respuesta = "error";
            }

        }
        

        userControl.close();

        return respuesta;

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

    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }


}
