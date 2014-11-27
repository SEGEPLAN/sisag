/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gt.gob.segeplan.sisag.rrhh.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "RRHH_CARACTER_NECESIDAD", catalog = "", schema = "SCHE$SISAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RrhhCaracterNecesidad.findAll", query = "SELECT r FROM RrhhCaracterNecesidad r"),
    @NamedQuery(name = "RrhhCaracterNecesidad.findByIdCaracter", query = "SELECT r FROM RrhhCaracterNecesidad r WHERE r.idCaracter = :idCaracter"),
    @NamedQuery(name = "RrhhCaracterNecesidad.findByNombre", query = "SELECT r FROM RrhhCaracterNecesidad r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "RrhhCaracterNecesidad.findByRestrictiva", query = "SELECT r FROM RrhhCaracterNecesidad r WHERE r.restrictiva = :restrictiva")})
public class RrhhCaracterNecesidad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_CARACTER")
    private BigDecimal idCaracter;
    @Size(max = 25)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "RESTRICTIVA")
    private Character restrictiva;
    @OneToMany(mappedBy = "idCaracter", fetch = FetchType.EAGER)
    private List<RrhhNecesidad> rrhhNecesidadList;

    public RrhhCaracterNecesidad() {
    }

    public RrhhCaracterNecesidad(BigDecimal idCaracter) {
        this.idCaracter = idCaracter;
    }

    public BigDecimal getIdCaracter() {
        return idCaracter;
    }

    public void setIdCaracter(BigDecimal idCaracter) {
        this.idCaracter = idCaracter;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(Character restrictiva) {
        this.restrictiva = restrictiva;
    }

    @XmlTransient
    public List<RrhhNecesidad> getRrhhNecesidadList() {
        return rrhhNecesidadList;
    }

    public void setRrhhNecesidadList(List<RrhhNecesidad> rrhhNecesidadList) {
        this.rrhhNecesidadList = rrhhNecesidadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCaracter != null ? idCaracter.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RrhhCaracterNecesidad)) {
            return false;
        }
        RrhhCaracterNecesidad other = (RrhhCaracterNecesidad) object;
        if ((this.idCaracter == null && other.idCaracter != null) || (this.idCaracter != null && !this.idCaracter.equals(other.idCaracter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.RrhhCaracterNecesidad[ idCaracter=" + idCaracter + " ]";
    }
    
}
