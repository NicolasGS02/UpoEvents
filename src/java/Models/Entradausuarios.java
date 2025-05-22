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
@Table(name = "entradausuarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Entradausuarios.findAll", query = "SELECT e FROM Entradausuarios e")
    , @NamedQuery(name = "Entradausuarios.findByCorreo", query = "SELECT e FROM Entradausuarios e WHERE e.correo = :correo")
    , @NamedQuery(name = "Entradausuarios.findByIdEntrada", query = "SELECT e FROM Entradausuarios e WHERE e.idEntrada = :idEntrada")
    , @NamedQuery(name = "Entradausuarios.findByIdFactura", query = "SELECT e FROM Entradausuarios e WHERE e.idFactura = :idFactura")
    , @NamedQuery(name = "Entradausuarios.findByIdEntradaUsuario", query = "SELECT e FROM Entradausuarios e WHERE e.idEntradaUsuario = :idEntradaUsuario")})
public class Entradausuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdEntrada")
    private int idEntrada;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdFactura")
    private int idFactura;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IdEntradaUsuario")
    private Integer idEntradaUsuario;

    public Entradausuarios() {
    }

    public Entradausuarios(Integer idEntradaUsuario) {
        this.idEntradaUsuario = idEntradaUsuario;
    }

    public Entradausuarios(Integer idEntradaUsuario, String correo, int idEntrada, int idFactura) {
        this.idEntradaUsuario = idEntradaUsuario;
        this.correo = correo;
        this.idEntrada = idEntrada;
        this.idFactura = idFactura;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getIdEntrada() {
        return idEntrada;
    }

    public void setIdEntrada(int idEntrada) {
        this.idEntrada = idEntrada;
    }

    public int getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getIdEntradaUsuario() {
        return idEntradaUsuario;
    }

    public void setIdEntradaUsuario(Integer idEntradaUsuario) {
        this.idEntradaUsuario = idEntradaUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntradaUsuario != null ? idEntradaUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Entradausuarios)) {
            return false;
        }
        Entradausuarios other = (Entradausuarios) object;
        if ((this.idEntradaUsuario == null && other.idEntradaUsuario != null) || (this.idEntradaUsuario != null && !this.idEntradaUsuario.equals(other.idEntradaUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Models.Entradausuarios[ idEntradaUsuario=" + idEntradaUsuario + " ]";
    }
    
}
