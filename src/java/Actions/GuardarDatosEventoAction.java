/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Actions;

import JerseyClients.EntradasJerseyClient;
import JerseyClients.EventosJerseyClient;
import Models.Entradas;
import Models.Eventos;
import com.opensymphony.xwork2.ActionSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author agarc
 */
public class GuardarDatosEventoAction extends ActionSupport {

    private String nombreEvento;
    private int capacidad;
    private String informacion;
    private String ubicacion;
    private String fecha;
    private Integer idOrganizacion;
    private int precio;
    private int idEvento;
    private int idEntrada;
    Eventos eve = new Eventos();
    EventosJerseyClient eClient = new EventosJerseyClient();
    EntradasJerseyClient entClient = new EntradasJerseyClient();

    public GuardarDatosEventoAction() {
    }

    public String execute() throws Exception {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha2 = formato.parse(fecha);
        Eventos original = eClient.find_XML(
                Eventos.class,
                Integer.toString(idEvento)
        );
        eve = new Eventos(idEvento, idOrganizacion, capacidad, nombreEvento, informacion, ubicacion, fecha2);
        eClient.edit_XML(original, Integer.toString(idEvento));

        Entradas entrada = entClient.find_XML(
                Entradas.class,
                Integer.toString(idEntrada)
        );
        entrada.setPrecio(precio);
        entClient.edit_XML(entrada, Integer.toString(idEntrada));
        return SUCCESS;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(Integer idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public Eventos getEve() {
        return eve;
    }

    public void setEve(Eventos eve) {
        this.eve = eve;
    }

    public EventosJerseyClient geteClient() {
        return eClient;
    }

    public void seteClient(EventosJerseyClient eClient) {
        this.eClient = eClient;
    }

    public EntradasJerseyClient getEntClient() {
        return entClient;
    }

    public void setEntClient(EntradasJerseyClient entClient) {
        this.entClient = entClient;
    }

}
