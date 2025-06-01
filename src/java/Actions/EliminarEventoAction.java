package Actions;

import com.opensymphony.xwork2.ActionSupport;
import Models.service.EventosFacadeREST;

public class EliminarEventoAction extends ActionSupport {

    private Integer idEvento;
    private Integer idOrganizacion;

    private EventosFacadeREST evtFacade = new EventosFacadeREST();

    @Override
    public void validate() {
        if (idEvento == null || idEvento <= 0) {
            addFieldError("idEvento", "Id de evento inválido");
        }
        if (idOrganizacion == null || idOrganizacion <= 0) {
            addFieldError("idOrganizacion", "Id de organización inválido");
        }
    }

    @Override
    public String execute() {
        // 1) Si hubo errores de validación, devolvemos ERROR
        if (hasFieldErrors()) {
            return ERROR;
        }

        // 2) Verificamos existencia del evento
        boolean existe = (evtFacade.find(idEvento) != null);
        if (!existe) {
            addActionError("El evento con Id " + idEvento + " no existe");
            return ERROR;
        }

        // 3) Borramos el evento
        evtFacade.remove(idEvento);

        // 4) Redirigimos a verOrganizacion con SUCCESS
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
