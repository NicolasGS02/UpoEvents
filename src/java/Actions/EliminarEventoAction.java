package Actions;

import JerseyClients.EventosJerseyClient;
import com.opensymphony.xwork2.ActionSupport;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class EliminarEventoAction extends ActionSupport {

    private Integer idEvento;
    private Integer idOrganizacion;

    private EventosJerseyClient evtClient = new EventosJerseyClient();

    public EliminarEventoAction() {
    }

    @Override
    public void validate() {
        if (idEvento == null || idEvento <= 0) {
            addFieldError("idEvento", "Id de evento inválido.");
        }
        if (idOrganizacion == null || idOrganizacion <= 0) {
            addFieldError("idOrganizacion", "Id de organización inválido.");
        }
    }

    @Override
    public String execute() {
        if (hasFieldErrors()) {
            return ERROR;
        }

        try {
          
            evtClient.remove(idEvento.toString());
        } catch (Exception e) {
            addActionError("Error al borrar el evento con Id = " + idEvento);
            return ERROR;
        }
       
        return SUCCESS;
    }

    
    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public Integer getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(Integer idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }
}
