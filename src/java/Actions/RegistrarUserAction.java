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
 * @author agarc
 */
public class RegistrarUserAction extends ActionSupport {

    private String nombre;
    private String correo;
    private String password;
    private String escuela;
    private static final String EMAIL_REGEX
            = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
    UsuariosJerseyClient userClient = new UsuariosJerseyClient();

    public RegistrarUserAction() {
    }

    public String execute() throws Exception {
        Usuarios u = new Usuarios(correo, nombre, password,escuela);
        userClient.create_XML(u);
        return SUCCESS;
    }

    public void validate() {
        if (this.nombre == null || this.nombre.isEmpty()) {
            addFieldError("nombre", "Debe completar el campo con nombre para la cuenta");
        }
        if (this.nombre != null) {
            if (this.nombre.length() < 3) {
                addFieldError("nombre", "El numero de caracteres es minimo 3");
            }
            if (this.nombre.length() > 50) {
                addFieldError("nombre", "El numero de caracteres es maximo 50");
            }
        }
        if (this.escuela == null || this.escuela.isEmpty()) {
            addFieldError("escuela", "Debe completar el campo escuela para la cuenta");
        }

        if (this.nombre != null && !this.nombre.matches("[A-Za-zÁÉÍÓÚñáéíóú ]+")) {
            addFieldError("nombre", "El formato es incorrecto");
        }
        if (this.escuela != null && !this.escuela.matches("[A-Za-zÁÉÍÓÚñáéíóú ]+")) {
            addFieldError("escuela", "El formato es incorrecto");
        }
        if (this.escuela != null) {
            if (this.escuela.length() < 3) {
                addFieldError("escuela", "El numero de caracteres es minimo 3");
            }
            if (this.escuela.length() > 50) {
                addFieldError("escuela", "El numero de caracteres es maximo 50");
            }
        }
        if (this.correo == null || this.correo.trim().isEmpty()) {
            addFieldError("correo", "El correo electrónico es obligatorio.");
        }
        if (this.correo.length() > 254) {
            addFieldError("correo", "El correo electrónico no puede superar 254 caracteres.");
        }
        if (!this.correo.matches(EMAIL_REGEX)) {
            addFieldError("correo", "Formato de correo electrónico no válido.");
        }
        if (this.password == null || this.password.trim().isEmpty()) {
            addFieldError("password", "La contraseña es obligatoria.");

        }
        if (this.password.length() < 8) {
            addFieldError("password", "La contraseña debe tener al menos 8 caracteres.");
        } else if (this.password.length() > 64) {
            addFieldError("password", "La contraseña no puede superar 64 caracteres.");
        }
        if (this.password.contains(" ")) {
            addFieldError("password", "La contraseña no puede contener espacios.");
        }

    }

    public String getEscuela() {
        return escuela;
    }

    public void setEscuela(String escuela) {
        this.escuela = escuela;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
