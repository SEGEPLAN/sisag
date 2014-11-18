/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.rrhh;

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
@Table(name = "RRHH_ASIGNA_CAPACITACION", catalog = "", schema = "SCHE$SISAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RrhhAsignaCapacitacion.findAll", query = "SELECT r FROM RrhhAsignaCapacitacion r"),
    @NamedQuery(name = "RrhhAsignaCapacitacion.findByIdDetalleCapacitacion", query = "SELECT r FROM RrhhAsignaCapacitacion r WHERE r.rrhhAsignaCapacitacionPK.idDetalleCapacitacion = :idDetalleCapacitacion"),
    @NamedQuery(name = "RrhhAsignaCapacitacion.findByIdPersona", query = "SELECT r FROM RrhhAsignaCapacitacion r WHERE r.rrhhAsignaCapacitacionPK.idPersona = :idPersona"),
    @NamedQuery(name = "RrhhAsignaCapacitacion.findByDescripcion", query = "SELECT r FROM RrhhAsignaCapacitacion r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "RrhhAsignaCapacitacion.findByRestrictiva", query = "SELECT r FROM RrhhAsignaCapacitacion r WHERE r.restrictiva = :restrictiva")})
public class RrhhAsignaCapacitacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RrhhAsignaCapacitacionPK rrhhAsignaCapacitacionPK;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "restrictiva")
    private Character restrictiva;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private RrhhPersona rrhhPersona;
    @JoinColumn(name = "id_detalle_capacitacion", referencedColumnName = "id_detalle", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private RrhhDetalleCapacitacion rrhhDetalleCapacitacion;

    public RrhhAsignaCapacitacion() {
    }

    public RrhhAsignaCapacitacion(RrhhAsignaCapacitacionPK rrhhAsignaCapacitacionPK) {
        this.rrhhAsignaCapacitacionPK = rrhhAsignaCapacitacionPK;
    }

    public RrhhAsignaCapacitacion(BigInteger idDetalleCapacitacion, BigInteger idPersona) {
        this.rrhhAsignaCapacitacionPK = new RrhhAsignaCapacitacionPK(idDetalleCapacitacion, idPersona);
    }

    public RrhhAsignaCapacitacionPK getRrhhAsignaCapacitacionPK() {
        return rrhhAsignaCapacitacionPK;
    }

    public void setRrhhAsignaCapacitacionPK(RrhhAsignaCapacitacionPK rrhhAsignaCapacitacionPK) {
        this.rrhhAsignaCapacitacionPK = rrhhAsignaCapacitacionPK;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(Character restrictiva) {
        this.restrictiva = restrictiva;
    }

    public RrhhPersona getRrhhPersona() {
        return rrhhPersona;
    }

    public void setRrhhPersona(RrhhPersona rrhhPersona) {
        this.rrhhPersona = rrhhPersona;
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
        hash += (rrhhAsignaCapacitacionPK != null ? rrhhAsignaCapacitacionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RrhhAsignaCapacitacion)) {
            return false;
        }
        RrhhAsignaCapacitacion other = (RrhhAsignaCapacitacion) object;
        if ((this.rrhhAsignaCapacitacionPK == null && other.rrhhAsignaCapacitacionPK != null) || (this.rrhhAsignaCapacitacionPK != null && !this.rrhhAsignaCapacitacionPK.equals(other.rrhhAsignaCapacitacionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.core.entities.RrhhAsignaCapacitacion[ rrhhAsignaCapacitacionPK=" + rrhhAsignaCapacitacionPK + " ]";
    }
    
}
