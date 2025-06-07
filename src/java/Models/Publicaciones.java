/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author agarc
 */
@Entity
@Table(name = "publicaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publicaciones.findAll", query = "SELECT p FROM Publicaciones p")
    , @NamedQuery(name = "Publicaciones.findByIdPublicacion", query = "SELECT p FROM Publicaciones p WHERE p.idPublicacion = :idPublicacion")
    , @NamedQuery(name = "Publicaciones.findByIdOrganizacion", query = "SELECT p FROM Publicaciones p WHERE p.idOrganizacion = :idOrganizacion")
    , @NamedQuery(name = "Publicaciones.findByTitulo", query = "SELECT p FROM Publicaciones p WHERE p.titulo = :titulo")
    , @NamedQuery(name = "Publicaciones.findByContenido", query = "SELECT p FROM Publicaciones p WHERE p.contenido = :contenido")
    , @NamedQuery(name = "Publicaciones.findByFechaPublicacion", query = "SELECT p FROM Publicaciones p WHERE p.fechaPublicacion = :fechaPublicacion")})
public class Publicaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdPublicacion")
    private Integer idPublicacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdOrganizacion")
    private int idOrganizacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Contenido")
    private String contenido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaPublicacion")
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;
    @Lob
    @Column(name = "Imagen")
    private byte[] imagen;

    public Publicaciones() {
    }

    public Publicaciones(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public Publicaciones(Integer idPublicacion, int idOrganizacion, String titulo, String contenido, Date fechaPublicacion) {
        this.idPublicacion = idPublicacion;
        this.idOrganizacion = idOrganizacion;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Integer getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(Integer idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public int getIdOrganizacion() {
        return idOrganizacion;
    }

    public void setIdOrganizacion(int idOrganizacion) {
        this.idOrganizacion = idOrganizacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPublicacion != null ? idPublicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publicaciones)) {
            return false;
        }
        Publicaciones other = (Publicaciones) object;
        if ((this.idPublicacion == null && other.idPublicacion != null) || (this.idPublicacion != null && !this.idPublicacion.equals(other.idPublicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Publicaciones[ idPublicacion=" + idPublicacion + " ]";
    }
    
}
