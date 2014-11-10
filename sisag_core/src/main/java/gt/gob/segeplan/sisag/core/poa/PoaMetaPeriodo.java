/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.poa;

import gt.gob.segeplan.sisag.core.gen.GenPeriodo;
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
@Table(name = "POA_META_PERIODO", catalog = "", schema = "SCHE$SISAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PoaMetaPeriodo.findAll", query = "SELECT p FROM PoaMetaPeriodo p"),
    @NamedQuery(name = "PoaMetaPeriodo.findByIdPeriodo", query = "SELECT p FROM PoaMetaPeriodo p WHERE p.poaMetaPeriodoPK.idPeriodo = :idPeriodo"),
    @NamedQuery(name = "PoaMetaPeriodo.findByIdMeta", query = "SELECT p FROM PoaMetaPeriodo p WHERE p.poaMetaPeriodoPK.idMeta = :idMeta"),
    @NamedQuery(name = "PoaMetaPeriodo.findByResultadoProgramado", query = "SELECT p FROM PoaMetaPeriodo p WHERE p.resultadoProgramado = :resultadoProgramado"),
    @NamedQuery(name = "PoaMetaPeriodo.findByResultadoEjecutado", query = "SELECT p FROM PoaMetaPeriodo p WHERE p.resultadoEjecutado = :resultadoEjecutado"),
    @NamedQuery(name = "PoaMetaPeriodo.findByObservaciones", query = "SELECT p FROM PoaMetaPeriodo p WHERE p.observaciones = :observaciones"),
    @NamedQuery(name = "PoaMetaPeriodo.findByRestrictiva", query = "SELECT p FROM PoaMetaPeriodo p WHERE p.restrictiva = :restrictiva")})
public class PoaMetaPeriodo implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PoaMetaPeriodoPK poaMetaPeriodoPK;
    @Column(name = "resultado_programado")
    private BigInteger resultadoProgramado;
    @Column(name = "resultado_ejecutado")
    private BigInteger resultadoEjecutado;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "restrictiva")
    private Character restrictiva;
    @JoinColumn(name = "id_meta", referencedColumnName = "id_meta", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PoaMeta poaMeta;
    @JoinColumn(name = "id_periodo", referencedColumnName = "id_periodo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private GenPeriodo genPeriodo;

    public PoaMetaPeriodo() {
    }

    public PoaMetaPeriodo(PoaMetaPeriodoPK poaMetaPeriodoPK) {
        this.poaMetaPeriodoPK = poaMetaPeriodoPK;
    }

    public PoaMetaPeriodo(BigInteger idPeriodo, BigInteger idMeta) {
        this.poaMetaPeriodoPK = new PoaMetaPeriodoPK(idPeriodo, idMeta);
    }

    public PoaMetaPeriodoPK getPoaMetaPeriodoPK() {
        return poaMetaPeriodoPK;
    }

    public void setPoaMetaPeriodoPK(PoaMetaPeriodoPK poaMetaPeriodoPK) {
        this.poaMetaPeriodoPK = poaMetaPeriodoPK;
    }

    public BigInteger getResultadoProgramado() {
        return resultadoProgramado;
    }

    public void setResultadoProgramado(BigInteger resultadoProgramado) {
        this.resultadoProgramado = resultadoProgramado;
    }

    public BigInteger getResultadoEjecutado() {
        return resultadoEjecutado;
    }

    public void setResultadoEjecutado(BigInteger resultadoEjecutado) {
        this.resultadoEjecutado = resultadoEjecutado;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Character getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(Character restrictiva) {
        this.restrictiva = restrictiva;
    }

    public PoaMeta getPoaMeta() {
        return poaMeta;
    }

    public void setPoaMeta(PoaMeta poaMeta) {
        this.poaMeta = poaMeta;
    }

    public GenPeriodo getGenPeriodo() {
        return genPeriodo;
    }

    public void setGenPeriodo(GenPeriodo genPeriodo) {
        this.genPeriodo = genPeriodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (poaMetaPeriodoPK != null ? poaMetaPeriodoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoaMetaPeriodo)) {
            return false;
        }
        PoaMetaPeriodo other = (PoaMetaPeriodo) object;
        if ((this.poaMetaPeriodoPK == null && other.poaMetaPeriodoPK != null) || (this.poaMetaPeriodoPK != null && !this.poaMetaPeriodoPK.equals(other.poaMetaPeriodoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.core.entities.PoaMetaPeriodo[ poaMetaPeriodoPK=" + poaMetaPeriodoPK + " ]";
    }
    
}
