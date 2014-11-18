/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.seg;

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
public class SegPrivilegioPaginaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_privilegio")
    private BigInteger idPrivilegio;
    @Basic(optional = false)
    @Column(name = "id_asignacion_pagina")
    private BigInteger idAsignacionPagina;

    public SegPrivilegioPaginaPK() {
    }

    public SegPrivilegioPaginaPK(BigInteger idPrivilegio, BigInteger idAsignacionPagina) {
        this.idPrivilegio = idPrivilegio;
        this.idAsignacionPagina = idAsignacionPagina;
    }

    public BigInteger getIdPrivilegio() {
        return idPrivilegio;
    }

    public void setIdPrivilegio(BigInteger idPrivilegio) {
        this.idPrivilegio = idPrivilegio;
    }

    public BigInteger getIdAsignacionPagina() {
        return idAsignacionPagina;
    }

    public void setIdAsignacionPagina(BigInteger idAsignacionPagina) {
        this.idAsignacionPagina = idAsignacionPagina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrivilegio != null ? idPrivilegio.hashCode() : 0);
        hash += (idAsignacionPagina != null ? idAsignacionPagina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegPrivilegioPaginaPK)) {
            return false;
        }
        SegPrivilegioPaginaPK other = (SegPrivilegioPaginaPK) object;
        if ((this.idPrivilegio == null && other.idPrivilegio != null) || (this.idPrivilegio != null && !this.idPrivilegio.equals(other.idPrivilegio))) {
            return false;
        }
        if ((this.idAsignacionPagina == null && other.idAsignacionPagina != null) || (this.idAsignacionPagina != null && !this.idAsignacionPagina.equals(other.idAsignacionPagina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.core.entities.SegPrivilegioPaginaPK[ idPrivilegio=" + idPrivilegio + ", idAsignacionPagina=" + idAsignacionPagina + " ]";
    }
    
}
