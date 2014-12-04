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
@Table(name = "SEG_PRIVILEGIO_PAGINA", catalog = "", schema = "SCHE$SISAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegPrivilegioPagina.findAll", query = "SELECT s FROM SegPrivilegioPagina s"),
    @NamedQuery(name = "SegPrivilegioPagina.findByIdPrivilegio", query = "SELECT s FROM SegPrivilegioPagina s WHERE s.segPrivilegioPaginaPK.idPrivilegio = :idPrivilegio"),
    @NamedQuery(name = "SegPrivilegioPagina.findByIdAsignacionPagina", query = "SELECT s FROM SegPrivilegioPagina s WHERE s.segPrivilegioPaginaPK.idAsignacionPagina = :idAsignacionPagina"),
    @NamedQuery(name = "SegPrivilegioPagina.findByRestrictiva", query = "SELECT s FROM SegPrivilegioPagina s WHERE s.restrictiva = :restrictiva")})
public class SegPrivilegioPagina implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SegPrivilegioPaginaPK segPrivilegioPaginaPK;
    @Column(name = "RESTRICTIVA")
    private Character restrictiva;
    @JoinColumn(name = "ID_PRIVILEGIO", referencedColumnName = "ID_PRIVILEGIO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SegPrivilegio segPrivilegio;
    @JoinColumn(name = "ID_ASIGNACION_PAGINA", referencedColumnName = "ID_ASIGNACION", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SegPaginaAsignada segPaginaAsignada;

    public SegPrivilegioPagina() {
    }

    public SegPrivilegioPagina(SegPrivilegioPaginaPK segPrivilegioPaginaPK) {
        this.segPrivilegioPaginaPK = segPrivilegioPaginaPK;
    }

    public SegPrivilegioPagina(BigInteger idPrivilegio, BigInteger idAsignacionPagina) {
        this.segPrivilegioPaginaPK = new SegPrivilegioPaginaPK(idPrivilegio, idAsignacionPagina);
    }

    public SegPrivilegioPaginaPK getSegPrivilegioPaginaPK() {
        return segPrivilegioPaginaPK;
    }

    public void setSegPrivilegioPaginaPK(SegPrivilegioPaginaPK segPrivilegioPaginaPK) {
        this.segPrivilegioPaginaPK = segPrivilegioPaginaPK;
    }

    public Character getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(Character restrictiva) {
        this.restrictiva = restrictiva;
    }

    public SegPrivilegio getSegPrivilegio() {
        return segPrivilegio;
    }

    public void setSegPrivilegio(SegPrivilegio segPrivilegio) {
        this.segPrivilegio = segPrivilegio;
    }

    public SegPaginaAsignada getSegPaginaAsignada() {
        return segPaginaAsignada;
    }

    public void setSegPaginaAsignada(SegPaginaAsignada segPaginaAsignada) {
        this.segPaginaAsignada = segPaginaAsignada;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (segPrivilegioPaginaPK != null ? segPrivilegioPaginaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegPrivilegioPagina)) {
            return false;
        }
        SegPrivilegioPagina other = (SegPrivilegioPagina) object;
        if ((this.segPrivilegioPaginaPK == null && other.segPrivilegioPaginaPK != null) || (this.segPrivilegioPaginaPK != null && !this.segPrivilegioPaginaPK.equals(other.segPrivilegioPaginaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.SegPrivilegioPagina[ segPrivilegioPaginaPK=" + segPrivilegioPaginaPK + " ]";
    }
    
}
