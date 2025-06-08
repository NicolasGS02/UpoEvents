/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import JerseyClients.FacturasJerseyClient;
import Models.Facturas;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Pc
 */
public class cargarFacturas extends ActionSupport {
    private String user;
    private List<Facturas> listadoFacturas = new ArrayList<>();
    
    
    public cargarFacturas() {
    }
    
    public String execute() throws Exception {
        
        FacturasJerseyClient facturasClient = new FacturasJerseyClient();
                GenericType<List<Facturas>> genericoFacturas = new GenericType<List<Facturas>>() {
        };
        listadoFacturas = facturasClient.findAll_XML(genericoFacturas);
        
        
        Iterator<Facturas> iterator = listadoFacturas.iterator();

        while (iterator.hasNext()) {
            Facturas valoracion = iterator.next();
            if (!valoracion.getCorreo().equals(user)) {
                iterator.remove();
            }
        }
        
        
        return SUCCESS;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<Facturas> getListadoFacturas() {
        return listadoFacturas;
    }

    public void setListadoFacturas(List<Facturas> listadoFacturas) {
        this.listadoFacturas = listadoFacturas;
    }
    
}
