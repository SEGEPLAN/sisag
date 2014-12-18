/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gt.gob.segeplan.sisag.rrhh.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ludwin.ayala
 */
@Embeddable
public class RrhhNecesidadPuestoPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_NECESIDAD")
    private BigInteger idNecesidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_PUESTO")
    private BigInteger idTipoPuesto;

    public RrhhNecesidadPuestoPK() {
    }

    public RrhhNecesidadPuestoPK(BigInteger idNecesidad, BigInteger idTipoPuesto) {
        this.idNecesidad = idNecesidad;
        this.idTipoPuesto = idTipoPuesto;
    }

    public BigInteger getIdNecesidad() {
        return idNecesidad;
    }

    public void setIdNecesidad(BigInteger idNecesidad) {
        this.idNecesidad = idNecesidad;
    }

    public BigInteger getIdTipoPuesto() {
        return idTipoPuesto;
    }

    public void setIdTipoPuesto(BigInteger idTipoPuesto) {
        this.idTipoPuesto = idTipoPuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNecesidad != null ? idNecesidad.hashCode() : 0);
        hash += (idTipoPuesto != null ? idTipoPuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RrhhNecesidadPuestoPK)) {
            return false;
        }
        RrhhNecesidadPuestoPK other = (RrhhNecesidadPuestoPK) object;
        if ((this.idNecesidad == null && other.idNecesidad != null) || (this.idNecesidad != null && !this.idNecesidad.equals(other.idNecesidad))) {
            return false;
        }
        if ((this.idTipoPuesto == null && other.idTipoPuesto != null) || (this.idTipoPuesto != null && !this.idTipoPuesto.equals(other.idTipoPuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.RrhhNecesidadPuestoPK[ idNecesidad=" + idNecesidad + ", idTipoPuesto=" + idTipoPuesto + " ]";
    }
    
}
