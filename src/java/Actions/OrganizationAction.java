package Actions;
import com.opensymphony.xwork2.ActionSupport;
import JerseyClients.OrganizacionesJerseyClient;
import JerseyClients.EventosJerseyClient;
import Models.Organizaciones;
import Models.Eventos;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;

public class OrganizationAction extends ActionSupport {

    private Integer idOrganizacion;        // llega desde la URL (?idOrganizacion=123)
    private Organizaciones organizacion;   // la organizacion que cargamos desde REST
    private List<Eventos> eventos;         // lista de todos los eventos de esa org

    private OrganizacionesJerseyClient orgClient = new OrganizacionesJerseyClient();
    private EventosJerseyClient evtClient = new EventosJerseyClient();

    @Override
    public void validate() {
        if (idOrganizacion == null || idOrganizacion <= 0) {
            addFieldError("idOrganizacion", "Id de organización inválido.");
        }
    }

    @Override
    public String execute() {
      
        if (hasFieldErrors()) {
            return ERROR;
        }

       
        organizacion = orgClient.find_XML(Organizaciones.class, idOrganizacion.toString());
        if (organizacion == null) {
            addActionError("No existe la organización con Id = " + idOrganizacion);
            return ERROR;
        }

       //PREGUNTARLE A NICO
       
        GenericType<List<Eventos>> genericoEvento = new GenericType<List<Eventos>>() {};
        List<Eventos> todos = evtClient.findAll_XML(genericoEvento);
        
        //------

        eventos = new ArrayList<>();
        for (Eventos e : todos) {
           
            if (e.getIdOrganizacion() == idOrganizacion) {
                eventos.add(e);
            }
        }

       
        return SUCCESS;
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
}
