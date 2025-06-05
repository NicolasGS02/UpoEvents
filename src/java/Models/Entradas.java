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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Pc
 */
@Entity
@Table(name = "entradas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entradas.findAll", query = "SELECT e FROM Entradas e")
    , @NamedQuery(name = "Entradas.findByIdEntrada", query = "SELECT e FROM Entradas e WHERE e.idEntrada = :idEntrada")
    , @NamedQuery(name = "Entradas.findByIdEvento", query = "SELECT e FROM Entradas e WHERE e.idEvento = :idEvento")
    , @NamedQuery(name = "Entradas.findByPrecio", query = "SELECT e FROM Entradas e WHERE e.precio = :precio")})
public class Entradas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IdEntrada")
    private Integer idEntrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdEvento")
    private int idEvento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private long precio;

    public Entradas() {
    }

    public Entradas(Integer idEntrada) {
        this.idEntrada = idEntrada;
    }

    public Entradas(Integer idEntrada, int idEvento, long precio) {
        this.idEntrada = idEntrada;
        this.idEvento = idEvento;
        this.precio = precio;
    }

    public Integer getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(Integer idEntrada) {
        this.idEntrada = idEntrada;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntrada != null ? idEntrada.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entradas)) {
            return false;
        }
        Entradas other = (Entradas) object;
        if ((this.idEntrada == null && other.idEntrada != null) || (this.idEntrada != null && !this.idEntrada.equals(other.idEntrada))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Entradas[ idEntrada=" + idEntrada + " ]";
    }
    
}
