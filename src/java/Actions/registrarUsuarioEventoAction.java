/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import JerseyClients.EntradaUsuariosJerseyClient;
import JerseyClients.EntradasJerseyClient;
import JerseyClients.FacturasJerseyClient;
import JerseyClients.UsuariosJerseyClient;
import Models.Entradas;
import Models.Entradausuarios;
import Models.Facturas;
import Models.Usuarios;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.GenericType;

/**
 *
 * @author Pc
 */
public class registrarUsuarioEventoAction extends ActionSupport {
    
        
    //valor para que después vuelva a la pantalla principal
    private Usuarios user;
    
    private String correoUsuario;
    private String identificadorEvento;
    
    
    private List<Facturas> listadoFacturas;
    private List<Entradas> listadoEntradas;
    private Entradas entrada;
    
    
    public registrarUsuarioEventoAction() {
    }
    
    public String execute() throws Exception {
       
                //Registramos la factura.
        Facturas facturaGenerada = new Facturas(null, correoUsuario,"**** **** ****", new Date());
        FacturasJerseyClient facturaClient = new FacturasJerseyClient();
        facturaClient.create_XML(facturaGenerada);
        
        
        
        
         //Recuperamos el valor recien creado de la factura.

        GenericType<List<Facturas>> genericoFactura = new GenericType<List<Facturas>>() {};
        listadoFacturas = facturaClient.findAll_XML(genericoFactura);
        
        int ultimoIdGenerado = 0;
        for (int i = 0; i < listadoFacturas.size(); i++) {
            
            if(ultimoIdGenerado < listadoFacturas.get(i).getIdFactura()){
                ultimoIdGenerado = listadoFacturas.get(i).getIdFactura();
            }
        }
        //Conseguimos primero la entrada correspondiente al evento. 
       
        EntradasJerseyClient entradaClient = new EntradasJerseyClient();     
        
        GenericType<List<Entradas>> genericoEntradas = new GenericType<List<Entradas>>() {};
        
        listadoEntradas = entradaClient.findAll_XML(genericoEntradas);
        
        for (int i = 0; i < listadoEntradas.size(); i++) {
            
            if((Integer.toString(listadoEntradas.get(i).getIdEvento()).equals(identificadorEvento))){              
                this.entrada = listadoEntradas.get(i);
                break;
            }
                
        }
 

        System.out.println(">>>>>>>VALOR DE LA ENTRADA: " + entrada.getIdEntrada());
        
        
        
        //Creamos la entrada para el usuario.       
        EntradaUsuariosJerseyClient entrUsuarioClient = new EntradaUsuariosJerseyClient();
        Entradausuarios entradaComprada = new Entradausuarios(null,correoUsuario,entrada.getIdEntrada(),ultimoIdGenerado);
        
        entrUsuarioClient.create_XML(entradaComprada);     
        
        //RECUPERAMOS USUARIO.

        
        UsuariosJerseyClient userClient = new UsuariosJerseyClient();
        this.user = userClient.find_XML(Usuarios.class, correoUsuario);
        
        return SUCCESS;
    }

    public Usuarios getUser() {
        return user;
    }

    public void setUser(Usuarios user) {
        this.user = user;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getIdentificadorEvento() {
        return identificadorEvento;
    }

    public void setIdentificadorEvento(String identificadorEvento) {
        this.identificadorEvento = identificadorEvento;
    }

    public List<Facturas> getListadoFacturas() {
        return listadoFacturas;
    }

    public void setListadoFacturas(List<Facturas> listadoFacturas) {
        this.listadoFacturas = listadoFacturas;
    }

    public Entradas getEntrada() {
        return entrada;
    }

    public void setEntrada(Entradas entrada) {
        this.entrada = entrada;
    }
    
    
    
    
}
