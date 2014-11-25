/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.rrhh;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ludwin.ayala
 */
@Embeddable
public class RrhhAsignaCapacitacionPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_detalle_capacitacion")
    private BigInteger idDetalleCapacitacion;
    @Basic(optional = false)
    @Column(name = "id_persona")
    private BigInteger idPersona;

    public RrhhAsignaCapacitacionPK() {
    }

    public RrhhAsignaCapacitacionPK(BigInteger idDetalleCapacitacion, BigInteger idPersona) {
        this.idDetalleCapacitacion = idDetalleCapacitacion;
        this.idPersona = idPersona;
    }

    public BigInteger getIdDetalleCapacitacion() {
        return idDetalleCapacitacion;
    }

    public void setIdDetalleCapacitacion(BigInteger idDetalleCapacitacion) {
        this.idDetalleCapacitacion = idDetalleCapacitacion;
    }

    public BigInteger getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(BigInteger idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleCapacitacion != null ? idDetalleCapacitacion.hashCode() : 0);
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RrhhAsignaCapacitacionPK)) {
            return false;
        }
        RrhhAsignaCapacitacionPK other = (RrhhAsignaCapacitacionPK) object;
        if ((this.idDetalleCapacitacion == null && other.idDetalleCapacitacion != null) || (this.idDetalleCapacitacion != null && !this.idDetalleCapacitacion.equals(other.idDetalleCapacitacion))) {
            return false;
        }
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.core.entities.RrhhAsignaCapacitacionPK[ idDetalleCapacitacion=" + idDetalleCapacitacion + ", idPersona=" + idPersona + " ]";
    }
    
}
