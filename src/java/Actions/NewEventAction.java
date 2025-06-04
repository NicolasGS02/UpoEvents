package Actions;

import com.opensymphony.xwork2.ActionSupport;
import Models.Eventos;
import Models.Organizaciones;
import Models.service.EventosFacadeREST;
import Models.service.OrganizacionesFacadeREST;
import java.util.Date;

public class NewEventAction extends ActionSupport {

    private Eventos evento = new Eventos();

    private String organizacionNombre;

    private OrganizacionesFacadeREST orgFacade = new OrganizacionesFacadeREST();
    private EventosFacadeREST evtFacade = new EventosFacadeREST();

    public String createForm() {

        Integer idOrg = evento.getIdOrganizacion();
        if (idOrg == null || idOrg <= 0) {
            addActionError("Id de organización inválido para crear evento.");
            return ERROR;
        }

        Organizaciones org = orgFacade.find(idOrg);
        if (org == null) {
            addActionError("No existe la organización con Id = " + idOrg);
            return ERROR;
        }
        organizacionNombre = org.getNombre();
        return INPUT;  // INPUT hace que Struts muestre /vistas/crearEvento.jsp
    }

    @Override
    public String execute() {
        // Si validate() marcó algún FieldError, Struts retornará INPUT.
        if (hasFieldErrors()) {
            return INPUT;
        }

        Integer idOrg = evento.getIdOrganizacion();
        Organizaciones org = orgFacade.find(idOrg);
        if (org == null) {
            addActionError("La organización con Id = " + idOrg + " no existe.");
            return ERROR;
        }

        evtFacade.create(evento);

        return SUCCESS;
    }

    @Override
    public void validate() {
        if (evento.getCapacidad() <= 0) {
            addFieldError("evento.capacidad", "La capacidad debe ser un número entero positivo.");
        }
        if (evento.getInformacion() == null || evento.getInformacion().trim().isEmpty()) {
            addFieldError("evento.informacion", "Debe escribir la información del evento.");
        }
        if (evento.getUbicacion() == null || evento.getUbicacion().trim().isEmpty()) {
            addFieldError("evento.ubicacion", "Debe escribir la ubicación del evento.");
        }
        if (evento.getFecha() == null) {
            addFieldError("evento.fecha", "Debe indicar la fecha del evento (YYYY-MM-DD).");
        }
    }

    public Eventos getEvento() {
        return evento;
    }

    public void setEvento(Eventos evento) {
        this.evento = evento;
    }

    public String getOrganizacionNombre() {
        return organizacionNombre;
    }

    public void setOrganizacionNombre(String organizacionNombre) {
        this.organizacionNombre = organizacionNombre;
    }
}
