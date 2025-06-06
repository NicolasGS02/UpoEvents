package Actions;

import JerseyClients.EventosJerseyClient;
import com.opensymphony.xwork2.ActionSupport;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class EliminarEventoAction extends ActionSupport {

    private int idEvento;
    private int idOrganizacion;

   

    public EliminarEventoAction() {
    }

    @Override
    public void validate() {
        if (idEvento <= 0) {
            addFieldError("idEvento", "Id de evento inválido.");
        }
        if (idOrganizacion <= 0) {
            addFieldError("idOrganizacion", "Id de organización inválido.");
        }
    }

    @Override
    public String execute() {
        EventosJerseyClient eventoEliminado = new EventosJerseyClient();
        eventoEliminado.remove(Integer.toString(idEvento));
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
