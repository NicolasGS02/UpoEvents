/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Pc
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(Models.service.ComentariopublicacionesFacadeREST.class);
        resources.add(Models.service.EntradasFacadeREST.class);
        resources.add(Models.service.EntradausuariosFacadeREST.class);
        resources.add(Models.service.EventosFacadeREST.class);
        resources.add(Models.service.OrganizacionesFacadeREST.class);
        resources.add(Models.service.PublicacionesFacadeREST.class);
        resources.add(Models.service.UsuariosFacadeREST.class);
        resources.add(Models.service.ValoracionesFacadeREST.class);
    }
    
}
