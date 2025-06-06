package Actions;

import JerseyClients.EntradasJerseyClient;
import com.opensymphony.xwork2.ActionSupport;
import JerseyClients.OrganizacionesJerseyClient;
import JerseyClients.EventosJerseyClient;
import Models.Entradas;
import Models.Eventos;
import Models.Organizaciones;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.text.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.GenericType;

public class NewEventAction extends ActionSupport {
    
    private String nombreEvento;
    private int capacidad;
    private String informacion;
    private String ubicacion;
    private String fecha;
    private int idOrganizacion;
    private int precio;
    private List<Eventos> listadoEventos = new ArrayList<>();
    private OrganizacionesJerseyClient orgClient = new OrganizacionesJerseyClient();
    private EventosJerseyClient evtClient = new EventosJerseyClient();
    private EntradasJerseyClient entClient = new EntradasJerseyClient();
    @Override
    public String execute() throws ParseException {
       
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        Date fecha2 = formato.parse(fecha);
        Eventos e = new Eventos(null, idOrganizacion, capacidad, nombreEvento, informacion, ubicacion, fecha2);
       
        evtClient.create_XML(e);
        
        //primero conseguir el id del evento que acabo de crear y luego Entradas a = new Entradas(null, idevento, precio); y crear la entrada con el create_XML
        
        GenericType<List<Eventos>> genericoEvento = new GenericType<List<Eventos>>() {};
        listadoEventos = (List<Eventos>) evtClient.findAll_XML(genericoEvento);
        Eventos idE = listadoEventos.get(listadoEventos.size() -1);
        Entradas a = new Entradas(null, idE.getIdEvento(), precio);
        entClient.create_XML(a);
        
        
        return SUCCESS;
    }
    
    @Override
    public void validate() {
        
        if (this.idOrganizacion <= 0) {
            addFieldError("idOrganizacion", "Debe especificar una organización válida.");
        }
        
        if (this.capacidad <= 0) {
            addFieldError("capacidad", "La capacidad debe ser un número entero positivo.");
        }
        
        if (this.informacion == null || this.informacion.trim().isEmpty()) {
            addFieldError("informacion", "Debe escribir la información del evento.");
        }
        
        if (this.ubicacion == null || this.ubicacion.trim().isEmpty()) {
            addFieldError("ubicacion", "Debe escribir la ubicación del evento.");
        }
        
        if (this.fecha == null) {
            addFieldError("fecha", "Debe indicar la fecha del evento (YYYY-MM-DD).");
        }
        if (this.precio <= 0) {
            addFieldError("precio", "Debe indicar un valor correcto");
        }
    }
    
    public String getNombreEvento() {
        return nombreEvento;
    }
    
    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }
    
    public int getCapacidad() {
        return capacidad;
    }
    
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public String getInformacion() {
        return informacion;
    }
    
    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
    
    public String getUbicacion() {
        return ubicacion;
    }
    
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public int getIdOrganizacion() {
        return idOrganizacion;
    }
    
    public void setIdOrganizacion(int idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
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

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
}
