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
 * @author Pc
 */
@Entity
@Table(name = "comentariopublicaciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comentariopublicaciones.findAll", query = "SELECT c FROM Comentariopublicaciones c")
    , @NamedQuery(name = "Comentariopublicaciones.findByIdComentario", query = "SELECT c FROM Comentariopublicaciones c WHERE c.idComentario = :idComentario")
    , @NamedQuery(name = "Comentariopublicaciones.findByCorreo", query = "SELECT c FROM Comentariopublicaciones c WHERE c.correo = :correo")
    , @NamedQuery(name = "Comentariopublicaciones.findByIdPublicacion", query = "SELECT c FROM Comentariopublicaciones c WHERE c.idPublicacion = :idPublicacion")
    , @NamedQuery(name = "Comentariopublicaciones.findByComentario", query = "SELECT c FROM Comentariopublicaciones c WHERE c.comentario = :comentario")
    , @NamedQuery(name = "Comentariopublicaciones.findByFechaComentario", query = "SELECT c FROM Comentariopublicaciones c WHERE c.fechaComentario = :fechaComentario")})
public class Comentariopublicaciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdComentario")
    private Integer idComentario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdPublicacion")
    private int idPublicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Comentario")
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Column(name = "imagen")
    private byte[] imagen;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FechaComentario")
    @Temporal(TemporalType.DATE)
    private Date fechaComentario;

    public Comentariopublicaciones() {
    }

    public Comentariopublicaciones(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public Comentariopublicaciones(Integer idComentario, String correo, int idPublicacion, String comentario, byte[] imagen, Date fechaComentario) {
        this.idComentario = idComentario;
        this.correo = correo;
        this.idPublicacion = idPublicacion;
        this.comentario = comentario;
        this.imagen = imagen;
        this.fechaComentario = fechaComentario;
    }

    public Integer getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(Integer idComentario) {
        this.idComentario = idComentario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(int idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public Date getFechaComentario() {
        return fechaComentario;
    }

    public void setFechaComentario(Date fechaComentario) {
        this.fechaComentario = fechaComentario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idComentario != null ? idComentario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comentariopublicaciones)) {
            return false;
        }
        Comentariopublicaciones other = (Comentariopublicaciones) object;
        if ((this.idComentario == null && other.idComentario != null) || (this.idComentario != null && !this.idComentario.equals(other.idComentario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Comentariopublicaciones[ idComentario=" + idComentario + " ]";
    }
    
}
