package Actions;

import com.opensymphony.xwork2.ActionSupport;

public class mostrarFormEventAction extends ActionSupport {
    private Integer idOrganizacion;

    @Override
    public String execute() {
        return SUCCESS;
    }

    public Integer getIdOrganizacion() {
        return idOrganizacion;
    }
    public void setIdOrganizacion(Integer idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }
}
