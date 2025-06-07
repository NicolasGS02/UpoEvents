/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import JerseyClients.ComentarioPublicacionesJerseyClient;
import JerseyClients.PublicacionesJerseyClient;
import JerseyClients.UsuariosJerseyClient;
import Models.Comentariopublicaciones;
import Models.Entradausuarios;
import Models.Usuarios;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author agarc
 */
public class EliminarPublicacionAction extends ActionSupport {

    private int idPublicacion;
    private int idOrganizacion;
    private String correo;

    public EliminarPublicacionAction() {
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public int getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(int idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    @Override
    public void validate() {
        if (idPublicacion <= 0) {
            addFieldError("idPublicacion", "Id de evento inválido.");
        }
        if (idOrganizacion <= 0) {
            addFieldError("idOrganizacion", "Id de organización inválido.");
        }
    }

    public String execute() throws Exception {
        //se borra la publicacion
        PublicacionesJerseyClient publiEliminada = new PublicacionesJerseyClient();
        publiEliminada.remove(Integer.toString(idPublicacion));

        //se borran los comentarios de la publicacion
        ComentarioPublicacionesJerseyClient comentPubliEliminar = new ComentarioPublicacionesJerseyClient();
        List<Comentariopublicaciones> listadoComments = new ArrayList<>();
        GenericType<List<Comentariopublicaciones>> genericoComents = new GenericType<List<Comentariopublicaciones>>() {
        };

        listadoComments = comentPubliEliminar.findAll_XML(genericoComents);

        //se borra la relacion con el usuario que comenta la publicacion.
        List<Usuarios> listadoUsuario = new ArrayList<>();
        UsuariosJerseyClient UsuarioClient = new UsuariosJerseyClient();
        GenericType<List<Usuarios>> genericousuarios = new GenericType<List<Usuarios>>() {
        };

        listadoUsuario = UsuarioClient.findAll_XML(genericousuarios);

        for (int i = 0; i < listadoUsuario.size(); i++) {

            if (listadoUsuario.get(i).getCorreo().equals(correo)) {
                UsuarioClient.remove((listadoUsuario.get(i).getCorreo()));
            }

        }

        return SUCCESS;
    }

}
