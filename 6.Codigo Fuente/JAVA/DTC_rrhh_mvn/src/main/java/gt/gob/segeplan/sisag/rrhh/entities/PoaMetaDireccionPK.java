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
public class PoaMetaDireccionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_META")
    private BigInteger idMeta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_UNIDAD")
    private BigInteger idUnidad;

    public PoaMetaDireccionPK() {
    }

    public PoaMetaDireccionPK(BigInteger idMeta, BigInteger idUnidad) {
        this.idMeta = idMeta;
        this.idUnidad = idUnidad;
    }

    public BigInteger getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(BigInteger idMeta) {
        this.idMeta = idMeta;
    }

    public BigInteger getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(BigInteger idUnidad) {
        this.idUnidad = idUnidad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMeta != null ? idMeta.hashCode() : 0);
        hash += (idUnidad != null ? idUnidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoaMetaDireccionPK)) {
            return false;
        }
        PoaMetaDireccionPK other = (PoaMetaDireccionPK) object;
        if ((this.idMeta == null && other.idMeta != null) || (this.idMeta != null && !this.idMeta.equals(other.idMeta))) {
            return false;
        }
        if ((this.idUnidad == null && other.idUnidad != null) || (this.idUnidad != null && !this.idUnidad.equals(other.idUnidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.PoaMetaDireccionPK[ idMeta=" + idMeta + ", idUnidad=" + idUnidad + " ]";
    }
    
}
