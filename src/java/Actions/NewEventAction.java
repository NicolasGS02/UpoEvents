package Actions;

import com.opensymphony.xwork2.ActionSupport;
import JerseyClients.OrganizacionesJerseyClient;
import JerseyClients.EventosJerseyClient;
import Models.Eventos;
import Models.Organizaciones;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewEventAction extends ActionSupport {

    private Eventos evento = new Eventos();  
    private String fechaEvento;             

    private OrganizacionesJerseyClient orgClient = new OrganizacionesJerseyClient();
    private EventosJerseyClient evtClient = new EventosJerseyClient();

    @Override
    public String execute() {
        
        System.out.println(">>> NewEventAction.execute() INICIO ");
        System.out.println("   evento.idOrganizacion = " + evento.getIdOrganizacion());
        System.out.println("   evento.capacidad      = " + evento.getCapacidad());
        System.out.println("   evento.informacion    = " + evento.getInformacion());
        System.out.println("   evento.ubicacion      = " + evento.getUbicacion());
        System.out.println("   evento.fecha          = " + evento.getFecha());

        if (hasFieldErrors()) {
            System.out.println(">>> NewEventAction: hay errores de validación, retornando INPUT");
            return INPUT;
        }

      
        System.out.println(">>> NewEventAction: invocando evtClient.create_XML(evento)");
        try {
            evtClient.create_XML(evento);
            System.out.println(">>> NewEventAction: create_XML se ejecutó sin excepción.");
        } catch (Exception ex) {
            System.err.println(">>> NewEventAction: EXCEPCIÓN al llamar a create_XML: " + ex.getMessage());
            ex.printStackTrace();
            addActionError("Error al crear evento en el servicio REST: " + ex.getMessage());
            return ERROR;
        }

        System.out.println(">>> NewEventAction.execute() FIN -> SUCCESS");
        return SUCCESS;
    }

    @Override
    public void validate() {
        
        if (evento.getIdOrganizacion() <= 0) {
            addFieldError("evento.idOrganizacion", "Debe especificar una organización válida.");
        }

     
        if (evento.getCapacidad() <= 0) {
            addFieldError("evento.capacidad", "La capacidad debe ser un número entero positivo.");
        }

     
        if (evento.getInformacion() == null || evento.getInformacion().trim().isEmpty()) {
            addFieldError("evento.informacion", "Debe escribir la información del evento.");
        }

       
        if (evento.getUbicacion() == null || evento.getUbicacion().trim().isEmpty()) {
            addFieldError("evento.ubicacion", "Debe escribir la ubicación del evento.");
        }

      
        if (fechaEvento == null || fechaEvento.trim().isEmpty()) {
            addFieldError("fechaEvento", "Debe indicar la fecha del evento (YYYY-MM-DD).");
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            sdf.setLenient(false);
            try {
                Date parsed = sdf.parse(fechaEvento);
                evento.setFecha(parsed);
            } catch (ParseException ex) {
                addFieldError("fechaEvento", "Formato inválido. Debe ser YYYY-MM-DD.");
            }
        }
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

    public Eventos getEvento() {
        return evento;
    }

    public void setEvento(Eventos evento) {
        this.evento = evento;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }
}
