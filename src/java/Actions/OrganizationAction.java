/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

/**
 *
 * @author agarc
 */
import com.opensymphony.xwork2.ActionSupport;
import Models.Organizaciones;
import Models.Eventos;
import Models.service.OrganizacionesFacadeREST;
import Models.service.EventosFacadeREST;
import java.util.ArrayList;
import java.util.List;

public class OrganizationAction extends ActionSupport {

    private Integer idOrganizacion;
    private Organizaciones organizacion;
    private List<Eventos> eventos;

    private OrganizacionesFacadeREST orgFacade = new OrganizacionesFacadeREST();
    private EventosFacadeREST evtFacade = new EventosFacadeREST();

    @Override
    public void validate() {
        // Validamos que se nos haya pasado correctamente el idOrganizacion (> 0)
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

        // 2) Intentamos cargar la organización desde la base de datos
        organizacion = orgFacade.find(idOrganizacion);
        if (organizacion == null) {
            addActionError("No existe la organización con Id = " + idOrganizacion);
            return ERROR;
        }

        // 3) Cargamos TODOS los eventos y luego filtramos los de esta organización
        List<Eventos> todos = evtFacade.findAll();
        eventos = new ArrayList<>();
        for (Eventos e : todos) {

            if (e.getIdOrganizacion() == idOrganizacion) {
                eventos.add(e);
            }

        }

        // 4) Si todo está OK, devolvemos SUCCESS para que Struts cargue la JSP
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
