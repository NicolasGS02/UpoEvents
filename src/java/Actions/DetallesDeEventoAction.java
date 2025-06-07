/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import JerseyClients.EntradaUsuariosJerseyClient;
import JerseyClients.EntradasJerseyClient;
import JerseyClients.EventosJerseyClient;
import JerseyClients.OrganizacionesJerseyClient;
import JerseyClients.UsuariosJerseyClient;
import Models.Entradas;
import Models.Entradausuarios;
import Models.Eventos;
import Models.Organizaciones;
import Models.Usuarios;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Pc
 */
public class DetallesDeEventoAction extends ActionSupport {
    
    private boolean noPermitir;
    private String user;
    private String identificadorEvento;
    private Eventos evento;
    private Organizaciones org;
    
    public DetallesDeEventoAction() {
    }
    
    public String execute() throws Exception {
        
        //CONSEGUMOS EL EVENTO
        
        EventosJerseyClient eventoClient = new  EventosJerseyClient();
        this.evento = eventoClient.find_XML(Eventos.class,identificadorEvento);
        
        eventoClient.close();
        
        //CONSEGIMOS LA ORGANIZACION
        OrganizacionesJerseyClient organizacionClient = new OrganizacionesJerseyClient();
        this.org = organizacionClient.find_XML(Organizaciones.class,Integer.toString(evento.getIdOrganizacion()));
        
        organizacionClient.close();
        
        UsuariosJerseyClient usuariosClient = new UsuariosJerseyClient();
        Usuarios nuestro = usuariosClient.find_XML(Usuarios.class, user);
        
        
        //FILTRAMOS POR SI YA ESTÁ INSCRITO EN EL EVENTO.
        
        List<Eventos> todosEventos = new ArrayList<>();
        EventosJerseyClient eventosClient = new EventosJerseyClient();
        GenericType<List<Eventos>> genericoEvento = new GenericType<List<Eventos>>() {};
        todosEventos = (List<Eventos>) eventosClient.findAll_XML(genericoEvento);
        
        
        
        
        List<Entradausuarios> entradasDelUsuario = new ArrayList<>();
                //CARGAMOS LAS ENTRADAS QUE TIENE EL USUARIO YA ADQUIRIDAS.
        EntradaUsuariosJerseyClient entraUser = new EntradaUsuariosJerseyClient();
        GenericType<List<Entradausuarios>> genericoEntradaUsuario = new GenericType<List<Entradausuarios>>() {};
        entradasDelUsuario = (List<Entradausuarios>) entraUser.findAll_XML(genericoEntradaUsuario);
        
        //CREAMOS CONECCION CON LA TABLA "ENTRADAS"
        EntradasJerseyClient ent = new EntradasJerseyClient();
        List<Eventos> eventosUsuario = new ArrayList<>();
        
        
        //PROCEDEMOS A CREAR LA LISTA DEL LOS EVENTOSDEL USUARIO
        for (int i = 0; i < entradasDelUsuario.size(); i++) {
           Entradas entradaCogida;
           String idEntrada = Integer.toString(entradasDelUsuario.get(i).getIdEntrada());
           entradaCogida = ent.find_XML(Entradas.class, idEntrada);
           
            for (int j = 0; j < todosEventos.size(); j++) {
                
                if(entradaCogida.getIdEvento() == todosEventos.get(j).getIdEvento() && nuestro.getCorreo().equals(entradasDelUsuario.get(i).getCorreo())){
                    
                    eventosUsuario.add(todosEventos.get(j));
                    break;
                }
                
            }

        }
        
        if(eventosUsuario.contains(evento)){
            this.noPermitir = true;
        }
        
        
        
        
        return SUCCESS;
    }

    public String getIdentificadorEvento() {
        return identificadorEvento;
    }

    public void setIdentificadorEvento(String identificadorEvento) {
        this.identificadorEvento = identificadorEvento;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Organizaciones getOrg() {
        return org;
    }

    public void setOrg(Organizaciones org) {
        this.org = org;
    }


    public Eventos getEvento() {
        return evento;
    }

    public void setEvento(Eventos evento) {
        this.evento = evento;
    }

    public boolean isNoPermitir() {
        return noPermitir;
    }

    public void setNoPermitir(boolean noPermitir) {
        this.noPermitir = noPermitir;
    }



    
    
    
}
