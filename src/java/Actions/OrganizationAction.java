package Actions;

import JerseyClients.EntradasJerseyClient;
import com.opensymphony.xwork2.ActionSupport;
import JerseyClients.OrganizacionesJerseyClient;
import JerseyClients.EventosJerseyClient;
import JerseyClients.PublicacionesJerseyClient;
import Models.Entradas;
import Models.Organizaciones;
import Models.Eventos;
import Models.Publicaciones;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;

public class OrganizationAction extends ActionSupport {

    private Integer idOrganizacion;        // llega desde la URL (?idOrganizacion=123)
    private Organizaciones organizacion;   // la organizacion que cargamos desde REST
    private List<Eventos> eventos;         // lista de todos los eventos de esa org
    private List<Entradas> entradas;
    private List<Publicaciones> publicaciones;
    private OrganizacionesJerseyClient orgClient = new OrganizacionesJerseyClient();
    private EventosJerseyClient evtClient = new EventosJerseyClient();
    private EntradasJerseyClient entClient = new EntradasJerseyClient();
    private PublicacionesJerseyClient pubClient = new PublicacionesJerseyClient();

    @Override
    public void validate() {
        if (idOrganizacion == null || idOrganizacion <= 0) {
            addFieldError("idOrganizacion", "Id de organización inválido.");
        }
    }

    @Override
    public String execute() {

        organizacion = orgClient.find_XML(Organizaciones.class, idOrganizacion.toString());

        GenericType<List<Eventos>> genericoEvento = new GenericType<List<Eventos>>() {
        };
        List<Eventos> todos = evtClient.findAll_XML(genericoEvento);

        //------
        eventos = new ArrayList<>();
        for (Eventos e : todos) {

            if (e.getIdOrganizacion() == idOrganizacion) {
                eventos.add(e);
            }
        }

        //listo las entradas para recoger el precio y asignarlo al evento
        GenericType<List<Entradas>> genericoEntradas = new GenericType<List<Entradas>>() {
        };
        List<Entradas> listadoEntradas = entClient.findAll_XML(genericoEntradas);
        entradas = listadoEntradas;
        
        //listar las publicaciones de una organizacion
        GenericType<List<Publicaciones>> genericoPublicaciones = new GenericType<List<Publicaciones>>() {
        };
        List<Publicaciones> allPublicaciones = pubClient.findAll_XML(genericoPublicaciones);

        publicaciones = new ArrayList<>();
        for (Publicaciones p : allPublicaciones) {
            if (p.getIdOrganizacion() == idOrganizacion) {
                publicaciones.add(p);
            }
        }
        return SUCCESS;
    }

    public List<Entradas> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entradas> entradas) {
        this.entradas = entradas;
    }

    public OrganizacionesJerseyClient getOrgClient() {
        return orgClient;
    }

    public void setOrgClient(OrganizacionesJerseyClient orgClient) {
        this.orgClient = orgClient;
    }

    public EventosJerseyClient getEvtClient() {
        return evtClient;
    }

    public void setEvtClient(EventosJerseyClient evtClient) {
        this.evtClient = evtClient;
    }

    public EntradasJerseyClient getEntClient() {
        return entClient;
    }

    public void setEntClient(EntradasJerseyClient entClient) {
        this.entClient = entClient;
    }

    public Integer getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(Integer idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    public Organizaciones getOrganizacion() {
        return organizacion;
    }

    public void setOrganizacion(Organizaciones organizacion) {
        this.organizacion = organizacion;
    }

    public List<Eventos> getEventos() {
        return eventos;
    }

    public void setEventos(List<Eventos> eventos) {
        this.eventos = eventos;
    }

    public List<Publicaciones> getPublicaciones() {
        return publicaciones;
    }

    public void setPublicaciones(List<Publicaciones> publicaciones) {
        this.publicaciones = publicaciones;
    }

    public PublicacionesJerseyClient getPubClient() {
        return pubClient;
    }

    public void setPubClient(PublicacionesJerseyClient pubClient) {
        this.pubClient = pubClient;
    }

}
