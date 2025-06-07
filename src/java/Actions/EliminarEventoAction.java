package Actions;

<<<<<<< Updated upstream
import com.opensymphony.xwork2.ActionSupport;
import Models.service.EventosFacadeREST;
=======
import JerseyClients.EntradaUsuariosJerseyClient;
import JerseyClients.EntradasJerseyClient;
import JerseyClients.EventosJerseyClient;
import Models.Entradas;
import Models.Entradausuarios;
import com.opensymphony.xwork2.ActionSupport;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.GenericType;
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
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
=======
        
        //BORRAMOS EL VENTO:
        EventosJerseyClient eventoEliminado = new EventosJerseyClient();
        eventoEliminado.remove(Integer.toString(idEvento));
        
        //BORRAMOS LA ENTRADA RELACIONADA CON ELLA:
        EntradasJerseyClient entradasClient = new EntradasJerseyClient();
        List<Entradas> listadoEntradas = new ArrayList<>();
        GenericType<List<Entradas>> genericoEntradas = new GenericType<List<Entradas>>() {};

        listadoEntradas = entradasClient.findAll_XML(genericoEntradas);
        //BORRAMOS TODAS LAS ENTRADAS QUE TENGAS RELACIONADAS DICHO EVENTO.
        int idEntrada = 0;
        for (int i = 0; i < listadoEntradas.size(); i++) {
            
            if(listadoEntradas.get(i).getIdEvento() == idEvento){
                idEntrada = listadoEntradas.get(i).getIdEntrada();
                entradasClient.remove(Integer.toString(listadoEntradas.get(i).getIdEntrada()));
            }
 
        }
        
        //BORRAMOS LA RELACION QUE PUEDA TENER CON LOS USUARIOS.
        List<Entradausuarios> listadoEntradasUsuario = new ArrayList<>();
        EntradaUsuariosJerseyClient entrUsuarioClient = new EntradaUsuariosJerseyClient();
        GenericType<List<Entradausuarios>> genericoEntradausuarios = new GenericType<List<Entradausuarios>>() {};
        
        listadoEntradasUsuario = entrUsuarioClient.findAll_XML(genericoEntradausuarios);
        
        for (int i = 0; i < listadoEntradasUsuario.size(); i++) {
            
            if(listadoEntradasUsuario.get(i).getIdEntrada()== idEntrada){
                entrUsuarioClient.remove(Integer.toString(listadoEntradasUsuario.get(i).getIdEntradaUsuario()));
            }
 
        }
        
        
        

        
        
        
        
>>>>>>> Stashed changes
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
