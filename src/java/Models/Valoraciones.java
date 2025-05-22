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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "valoraciones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valoraciones.findAll", query = "SELECT v FROM Valoraciones v")
    , @NamedQuery(name = "Valoraciones.findByIdValoracion", query = "SELECT v FROM Valoraciones v WHERE v.idValoracion = :idValoracion")
    , @NamedQuery(name = "Valoraciones.findByIdEvento", query = "SELECT v FROM Valoraciones v WHERE v.idEvento = :idEvento")
    , @NamedQuery(name = "Valoraciones.findByCorreo", query = "SELECT v FROM Valoraciones v WHERE v.correo = :correo")
    , @NamedQuery(name = "Valoraciones.findByComentario", query = "SELECT v FROM Valoraciones v WHERE v.comentario = :comentario")
    , @NamedQuery(name = "Valoraciones.findByPuntuacion", query = "SELECT v FROM Valoraciones v WHERE v.puntuacion = :puntuacion")})
public class Valoraciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdValoracion")
    private Integer idValoracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdEvento")
    private int idEvento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "Comentario")
    private String comentario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Puntuacion")
    private int puntuacion;

    public Valoraciones() {
    }

    public Valoraciones(Integer idValoracion) {
        this.idValoracion = idValoracion;
    }

    public Valoraciones(Integer idValoracion, int idEvento, String correo, String comentario, int puntuacion) {
        this.idValoracion = idValoracion;
        this.idEvento = idEvento;
        this.correo = correo;
        this.comentario = comentario;
        this.puntuacion = puntuacion;
    }

    public Integer getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(Integer idValoracion) {
        this.idValoracion = idValoracion;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idValoracion != null ? idValoracion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valoraciones)) {
            return false;
        }
        Valoraciones other = (Valoraciones) object;
        if ((this.idValoracion == null && other.idValoracion != null) || (this.idValoracion != null && !this.idValoracion.equals(other.idValoracion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Valoraciones[ idValoracion=" + idValoracion + " ]";
    }
    
}
