package Actions;

import com.opensymphony.xwork2.ActionSupport;

public class mostrarFormEventAction extends ActionSupport {
    private Integer idOrganizacion;

    @Override
    public String execute() {
        // Depuración: imprime en consola
        System.out.println(">>> ShowCreateEventAction: idOrganizacion=" + idOrganizacion);
        return SUCCESS;
    }

    public Integer getIdOrganizacion() {
        return idOrganizacion;
    }
    public void setIdOrganizacion(Integer idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }
}
