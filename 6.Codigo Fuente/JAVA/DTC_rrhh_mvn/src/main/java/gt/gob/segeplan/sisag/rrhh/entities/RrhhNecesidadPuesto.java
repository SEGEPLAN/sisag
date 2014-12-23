/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gt.gob.segeplan.sisag.rrhh.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "RRHH_NECESIDAD_PUESTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RrhhNecesidadPuesto.findAll", query = "SELECT r FROM RrhhNecesidadPuesto r"),
    @NamedQuery(name = "RrhhNecesidadPuesto.findByIdNecesidad", query = "SELECT r FROM RrhhNecesidadPuesto r WHERE r.rrhhNecesidadPuestoPK.idNecesidad = :idNecesidad"),
    @NamedQuery(name = "RrhhNecesidadPuesto.findByIdTipoPuesto", query = "SELECT r FROM RrhhNecesidadPuesto r WHERE r.rrhhNecesidadPuestoPK.idTipoPuesto = :idTipoPuesto"),
    @NamedQuery(name = "RrhhNecesidadPuesto.findByTotal", query = "SELECT r FROM RrhhNecesidadPuesto r WHERE r.total = :total"),
    @NamedQuery(name = "RrhhNecesidadPuesto.findByRestrictiva", query = "SELECT r FROM RrhhNecesidadPuesto r WHERE r.restrictiva = :restrictiva")})
public class RrhhNecesidadPuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RrhhNecesidadPuestoPK rrhhNecesidadPuestoPK;
    @Column(name = "TOTAL")
    private int total;
    @Column(name = "RESTRICTIVA")
    private Character restrictiva;
    @JoinColumn(name = "ID_TIPO_PUESTO", referencedColumnName = "ID_TIPO_PUESTO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private RrhhTipoPuesto rrhhTipoPuesto;
    @JoinColumn(name = "ID_NECESIDAD", referencedColumnName = "ID_NECESIDAD", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private RrhhNecesidad rrhhNecesidad;
    
    
    

    public RrhhNecesidadPuesto() {
    }

    public RrhhNecesidadPuesto(RrhhNecesidadPuestoPK rrhhNecesidadPuestoPK) {
        this.rrhhNecesidadPuestoPK = rrhhNecesidadPuestoPK;
    }

    public RrhhNecesidadPuesto(BigInteger idNecesidad, BigInteger idTipoPuesto) {
        this.rrhhNecesidadPuestoPK = new RrhhNecesidadPuestoPK(idNecesidad, idTipoPuesto);
    }

    public RrhhNecesidadPuestoPK getRrhhNecesidadPuestoPK() {
        return rrhhNecesidadPuestoPK;
    }

    public void setRrhhNecesidadPuestoPK(RrhhNecesidadPuestoPK rrhhNecesidadPuestoPK) {
        this.rrhhNecesidadPuestoPK = rrhhNecesidadPuestoPK;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Character getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(Character restrictiva) {
        this.restrictiva = restrictiva;
    }

    public RrhhTipoPuesto getRrhhTipoPuesto() {
        return rrhhTipoPuesto;
    }

    public void setRrhhTipoPuesto(RrhhTipoPuesto rrhhTipoPuesto) {
        this.rrhhTipoPuesto = rrhhTipoPuesto;
    }

    public RrhhNecesidad getRrhhNecesidad() {
        return rrhhNecesidad;
    }

    public void setRrhhNecesidad(RrhhNecesidad rrhhNecesidad) {
        this.rrhhNecesidad = rrhhNecesidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rrhhNecesidadPuestoPK != null ? rrhhNecesidadPuestoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RrhhNecesidadPuesto)) {
            return false;
        }
        RrhhNecesidadPuesto other = (RrhhNecesidadPuesto) object;
        if ((this.rrhhNecesidadPuestoPK == null && other.rrhhNecesidadPuestoPK != null) || (this.rrhhNecesidadPuestoPK != null && !this.rrhhNecesidadPuestoPK.equals(other.rrhhNecesidadPuestoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.RrhhNecesidadPuesto[ rrhhNecesidadPuestoPK=" + rrhhNecesidadPuestoPK + " ]";
    }
    
}
