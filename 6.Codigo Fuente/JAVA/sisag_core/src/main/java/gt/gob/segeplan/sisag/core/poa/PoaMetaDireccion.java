/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.poa;

import gt.gob.segeplan.sisag.core.rrhh.RrhhUnidadAdministrativa;
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
@Table(name = "POA_META_DIRECCION", catalog = "", schema = "SCHE$SISAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PoaMetaDireccion.findAll", query = "SELECT p FROM PoaMetaDireccion p"),
    @NamedQuery(name = "PoaMetaDireccion.findByIdMeta", query = "SELECT p FROM PoaMetaDireccion p WHERE p.poaMetaDireccionPK.idMeta = :idMeta"),
    @NamedQuery(name = "PoaMetaDireccion.findByIdUnidad", query = "SELECT p FROM PoaMetaDireccion p WHERE p.poaMetaDireccionPK.idUnidad = :idUnidad"),
    @NamedQuery(name = "PoaMetaDireccion.findByObservaciones", query = "SELECT p FROM PoaMetaDireccion p WHERE p.observaciones = :observaciones"),
    @NamedQuery(name = "PoaMetaDireccion.findByRestrictiva", query = "SELECT p FROM PoaMetaDireccion p WHERE p.restrictiva = :restrictiva")})
public class PoaMetaDireccion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PoaMetaDireccionPK poaMetaDireccionPK;
    @Column(name = "observaciones")
    private String observaciones;
    @Column(name = "restrictiva")
    private Character restrictiva;
    @JoinColumn(name = "id_unidad", referencedColumnName = "id_unidad_admin", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private RrhhUnidadAdministrativa rrhhUnidadAdministrativa;
    @JoinColumn(name = "id_meta", referencedColumnName = "id_meta", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private PoaMeta poaMeta;

    public PoaMetaDireccion() {
    }

    public PoaMetaDireccion(PoaMetaDireccionPK poaMetaDireccionPK) {
        this.poaMetaDireccionPK = poaMetaDireccionPK;
    }

    public PoaMetaDireccion(BigInteger idMeta, BigInteger idUnidad) {
        this.poaMetaDireccionPK = new PoaMetaDireccionPK(idMeta, idUnidad);
    }

    public PoaMetaDireccionPK getPoaMetaDireccionPK() {
        return poaMetaDireccionPK;
    }

    public void setPoaMetaDireccionPK(PoaMetaDireccionPK poaMetaDireccionPK) {
        this.poaMetaDireccionPK = poaMetaDireccionPK;
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

    public RrhhUnidadAdministrativa getRrhhUnidadAdministrativa() {
        return rrhhUnidadAdministrativa;
    }

    public void setRrhhUnidadAdministrativa(RrhhUnidadAdministrativa rrhhUnidadAdministrativa) {
        this.rrhhUnidadAdministrativa = rrhhUnidadAdministrativa;
    }

    public PoaMeta getPoaMeta() {
        return poaMeta;
    }

    public void setPoaMeta(PoaMeta poaMeta) {
        this.poaMeta = poaMeta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (poaMetaDireccionPK != null ? poaMetaDireccionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoaMetaDireccion)) {
            return false;
        }
        PoaMetaDireccion other = (PoaMetaDireccion) object;
        if ((this.poaMetaDireccionPK == null && other.poaMetaDireccionPK != null) || (this.poaMetaDireccionPK != null && !this.poaMetaDireccionPK.equals(other.poaMetaDireccionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.core.entities.PoaMetaDireccion[ poaMetaDireccionPK=" + poaMetaDireccionPK + " ]";
    }
    
}
