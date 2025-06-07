/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author agarc
 */
public class mostrarFormPubliAction extends ActionSupport {

    private Integer idOrganizacion;

    public mostrarFormPubliAction() {
    }

    public String execute() throws Exception {
        return SUCCESS;
    }

    public Integer getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(Integer idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

}
