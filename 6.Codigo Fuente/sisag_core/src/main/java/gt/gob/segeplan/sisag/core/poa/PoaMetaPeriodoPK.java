/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.poa;

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
public class PoaMetaPeriodoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_periodo")
    private BigInteger idPeriodo;
    @Basic(optional = false)
    @Column(name = "id_meta")
    private BigInteger idMeta;

    public PoaMetaPeriodoPK() {
    }

    public PoaMetaPeriodoPK(BigInteger idPeriodo, BigInteger idMeta) {
        this.idPeriodo = idPeriodo;
        this.idMeta = idMeta;
    }

    public BigInteger getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(BigInteger idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public BigInteger getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(BigInteger idMeta) {
        this.idMeta = idMeta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeriodo != null ? idPeriodo.hashCode() : 0);
        hash += (idMeta != null ? idMeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoaMetaPeriodoPK)) {
            return false;
        }
        PoaMetaPeriodoPK other = (PoaMetaPeriodoPK) object;
        if ((this.idPeriodo == null && other.idPeriodo != null) || (this.idPeriodo != null && !this.idPeriodo.equals(other.idPeriodo))) {
            return false;
        }
        if ((this.idMeta == null && other.idMeta != null) || (this.idMeta != null && !this.idMeta.equals(other.idMeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.core.entities.PoaMetaPeriodoPK[ idPeriodo=" + idPeriodo + ", idMeta=" + idMeta + " ]";
    }
    
}
