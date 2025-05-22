/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pc
 */
@Entity
@Table(name = "organizaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Organizaciones.findAll", query = "SELECT o FROM Organizaciones o")
    , @NamedQuery(name = "Organizaciones.findByIdOrganizacion", query = "SELECT o FROM Organizaciones o WHERE o.idOrganizacion = :idOrganizacion")
    , @NamedQuery(name = "Organizaciones.findByNombre", query = "SELECT o FROM Organizaciones o WHERE o.nombre = :nombre")
    , @NamedQuery(name = "Organizaciones.findByDireccion", query = "SELECT o FROM Organizaciones o WHERE o.direccion = :direccion")
    , @NamedQuery(name = "Organizaciones.findByPassword", query = "SELECT o FROM Organizaciones o WHERE o.password = :password")})
public class Organizaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdOrganizacion")
    private Integer idOrganizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Password")
    private String password;

    public Organizaciones() {
    }

    public Organizaciones(Integer idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    public Organizaciones(Integer idOrganizacion, String nombre, String direccion, String password) {
        this.idOrganizacion = idOrganizacion;
        this.nombre = nombre;
        this.direccion = direccion;
        this.password = password;
    }

    public Integer getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(Integer idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOrganizacion != null ? idOrganizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Organizaciones)) {
            return false;
        }
        Organizaciones other = (Organizaciones) object;
        if ((this.idOrganizacion == null && other.idOrganizacion != null) || (this.idOrganizacion != null && !this.idOrganizacion.equals(other.idOrganizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Organizaciones[ idOrganizacion=" + idOrganizacion + " ]";
    }
    
}
