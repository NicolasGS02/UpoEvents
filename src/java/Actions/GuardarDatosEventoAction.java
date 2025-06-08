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
import java.time.LocalDate;
import java.time.ZoneId;
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
    Entradas entrada = new Entradas();
    EventosJerseyClient eClient = new EventosJerseyClient();
    EntradasJerseyClient entClient = new EntradasJerseyClient();
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yy");
    Date fecha2;

    public GuardarDatosEventoAction() {
    }

    public String execute() throws Exception {
        fecha2 = formato.parse(fecha);
        eve = new Eventos(idEvento, idOrganizacion, capacidad, nombreEvento, informacion, ubicacion, fecha2);

        eClient.edit_XML(eve, Integer.toString(eve.getIdEvento()));

        entrada = new Entradas(idEntrada, idEvento, precio);

        entClient.edit_XML(entrada, Integer.toString(entrada.getIdEntrada()));
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

    public Entradas getEntrada() {
        return entrada;
    }

    public void setEntrada(Entradas entrada) {
        this.entrada = entrada;
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

    public SimpleDateFormat getFormato() {
        return formato;
    }

    public void setFormato(SimpleDateFormat formato) {
        this.formato = formato;
    }

    public Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }

  
}
