/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.rrhh;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "RRHH_CARACTER_CAPACITACION", catalog = "", schema = "SCHE$SISAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RrhhCaracterCapacitacion.findAll", query = "SELECT r FROM RrhhCaracterCapacitacion r"),
    @NamedQuery(name = "RrhhCaracterCapacitacion.findByIdCaracter", query = "SELECT r FROM RrhhCaracterCapacitacion r WHERE r.idCaracter = :idCaracter"),
    @NamedQuery(name = "RrhhCaracterCapacitacion.findByNombre", query = "SELECT r FROM RrhhCaracterCapacitacion r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "RrhhCaracterCapacitacion.findByRestrictiva", query = "SELECT r FROM RrhhCaracterCapacitacion r WHERE r.restrictiva = :restrictiva")})
public class RrhhCaracterCapacitacion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_caracter")
    private BigDecimal idCaracter;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "restrictiva")
    private Character restrictiva;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "rrhhCaracterCapacitacion", fetch = FetchType.EAGER)
    private RrhhDetalleCapacitacion rrhhDetalleCapacitacion;

    public RrhhCaracterCapacitacion() {
    }

    public RrhhCaracterCapacitacion(BigDecimal idCaracter) {
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

    public RrhhDetalleCapacitacion getRrhhDetalleCapacitacion() {
        return rrhhDetalleCapacitacion;
    }

    public void setRrhhDetalleCapacitacion(RrhhDetalleCapacitacion rrhhDetalleCapacitacion) {
        this.rrhhDetalleCapacitacion = rrhhDetalleCapacitacion;
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
        if (!(object instanceof RrhhCaracterCapacitacion)) {
            return false;
        }
        RrhhCaracterCapacitacion other = (RrhhCaracterCapacitacion) object;
        if ((this.idCaracter == null && other.idCaracter != null) || (this.idCaracter != null && !this.idCaracter.equals(other.idCaracter))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.core.entities.RrhhCaracterCapacitacion[ idCaracter=" + idCaracter + " ]";
    }
    
}
