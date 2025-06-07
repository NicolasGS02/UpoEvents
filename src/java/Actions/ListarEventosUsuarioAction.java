/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import JerseyClients.EntradaUsuariosJerseyClient;
import JerseyClients.EntradasJerseyClient;
import JerseyClients.EventosJerseyClient;
import Models.Entradas;
import Models.Entradausuarios;
import Models.Eventos;
import Models.Usuarios;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Pc
 */
public class ListarEventosUsuarioAction extends ActionSupport {
    
    //USER proveniente del otro
    private Usuarios user;
    
    private List<Eventos> todosEventos = new ArrayList<>();
    private List<Eventos> eventosUsuario = new ArrayList<>();
    private List<Entradausuarios> entradasDelUsuario = new ArrayList<>();
    private Entradas entradaCogida;
    
    
    
    
    public ListarEventosUsuarioAction() {
    }
    
    public String execute() throws Exception {
        
        //CARGAMOS TODOS LOS EVENTOS.
        EventosJerseyClient eventosClient = new EventosJerseyClient();
        GenericType<List<Eventos>> genericoEvento = new GenericType<List<Eventos>>() {};
        todosEventos = (List<Eventos>) eventosClient.findAll_XML(genericoEvento);
        
        //CARGAMOS LAS ENTRADAS QUE TIENE EL USUARIO YA ADQUIRIDAS.
        EntradaUsuariosJerseyClient entraUser = new EntradaUsuariosJerseyClient();
        GenericType<List<Entradausuarios>> genericoEntradaUsuario = new GenericType<List<Entradausuarios>>() {};
        entradasDelUsuario = (List<Entradausuarios>) entraUser.findAll_XML(genericoEntradaUsuario);
        
        //CREAMOS CONECCION CON LA TABLA "ENTRADAS"
        EntradasJerseyClient ent = new EntradasJerseyClient();
        
        
        //PROCEDEMOS A CREAR LA LISTA DEL LOS EVENTOSDEL USUARIO
        for (int i = 0; i < entradasDelUsuario.size(); i++) {
           
           String idEntrada = Integer.toString(entradasDelUsuario.get(i).getIdEntrada());
           entradaCogida = ent.find_XML(Entradas.class, idEntrada);
           
            for (int j = 0; j < todosEventos.size(); j++) {
                
                if(entradaCogida.getIdEvento() == todosEventos.get(j).getIdEvento() && user.getCorreo().equals(entradasDelUsuario.get(i).getCorreo())){
                    
                    eventosUsuario.add(todosEventos.get(j));
                    break;
                }
                
            }

        }
        
     
        eventosClient.close();
        entraUser.close();
        ent.close();
        
        return SUCCESS;
    }

    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }

    public List<Eventos> getTodosEventos() {
        return todosEventos;
    }

    public void setTodosEventos(List<Eventos> todosEventos) {
        this.todosEventos = todosEventos;
    }

    public List<Eventos> getEventosUsuario() {
        return eventosUsuario;
    }

    public void setEventosUsuario(List<Eventos> eventosUsuario) {
        this.eventosUsuario = eventosUsuario;
    }

    public List<Entradausuarios> getEntradasDelUsuario() {
        return entradasDelUsuario;
    }

    public void setEntradasDelUsuario(List<Entradausuarios> entradasDelUsuario) {
        this.entradasDelUsuario = entradasDelUsuario;
    }

    public Entradas getEntradaCogida() {
        return entradaCogida;
    }

    public void setEntradaCogida(Entradas entradaCogida) {
        this.entradaCogida = entradaCogida;
    }
    
}
