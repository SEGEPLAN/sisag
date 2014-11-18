/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.rrhh;

import gt.gob.segeplan.sisag.core.gen.GenEstado;
import gt.gob.segeplan.sisag.core.poa.PoaMeta;
import gt.gob.segeplan.sisag.core.seg.SegUsuario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "RRHH_SOLICITUD_CAPACITACION", catalog = "", schema = "SCHE$SISAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RrhhSolicitudCapacitacion.findAll", query = "SELECT r FROM RrhhSolicitudCapacitacion r"),
    @NamedQuery(name = "RrhhSolicitudCapacitacion.findByIdSolicitudCapacitacion", query = "SELECT r FROM RrhhSolicitudCapacitacion r WHERE r.idSolicitudCapacitacion = :idSolicitudCapacitacion"),
    @NamedQuery(name = "RrhhSolicitudCapacitacion.findByCorrelativo", query = "SELECT r FROM RrhhSolicitudCapacitacion r WHERE r.correlativo = :correlativo"),
    @NamedQuery(name = "RrhhSolicitudCapacitacion.findByTotalPersonal", query = "SELECT r FROM RrhhSolicitudCapacitacion r WHERE r.totalPersonal = :totalPersonal"),
    @NamedQuery(name = "RrhhSolicitudCapacitacion.findByRestrictiva", query = "SELECT r FROM RrhhSolicitudCapacitacion r WHERE r.restrictiva = :restrictiva")})
public class RrhhSolicitudCapacitacion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_solicitud_capacitacion")
    private BigDecimal idSolicitudCapacitacion;
    @Column(name = "correlativo")
    private String correlativo;
    @Column(name = "total_personal")
    private BigInteger totalPersonal;
    @Column(name = "restrictiva")
    private Character restrictiva;
    @JoinColumn(name = "usr_crea", referencedColumnName = "id_usuario")
    @ManyToOne(fetch = FetchType.EAGER)
    private SegUsuario usrCrea;
    @JoinColumn(name = "id_unidad_administrativa", referencedColumnName = "id_unidad_admin")
    @ManyToOne(fetch = FetchType.EAGER)
    private RrhhUnidadAdministrativa idUnidadAdministrativa;
    @JoinColumn(name = "id_meta", referencedColumnName = "id_meta")
    @ManyToOne(fetch = FetchType.EAGER)
    private PoaMeta idMeta;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(fetch = FetchType.EAGER)
    private GenEstado idEstado;
    @OneToMany(mappedBy = "idSolicitudCapacitacion", fetch = FetchType.EAGER)
    private List<RrhhDetalleCapacitacion> rrhhDetalleCapacitacionList;

    public RrhhSolicitudCapacitacion() {
    }

    public RrhhSolicitudCapacitacion(BigDecimal idSolicitudCapacitacion) {
        this.idSolicitudCapacitacion = idSolicitudCapacitacion;
    }

    public BigDecimal getIdSolicitudCapacitacion() {
        return idSolicitudCapacitacion;
    }

    public void setIdSolicitudCapacitacion(BigDecimal idSolicitudCapacitacion) {
        this.idSolicitudCapacitacion = idSolicitudCapacitacion;
    }

    public String getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(String correlativo) {
        this.correlativo = correlativo;
    }

    public BigInteger getTotalPersonal() {
        return totalPersonal;
    }

    public void setTotalPersonal(BigInteger totalPersonal) {
        this.totalPersonal = totalPersonal;
    }

    public Character getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(Character restrictiva) {
        this.restrictiva = restrictiva;
    }

    public SegUsuario getUsrCrea() {
        return usrCrea;
    }

    public void setUsrCrea(SegUsuario usrCrea) {
        this.usrCrea = usrCrea;
    }

    public RrhhUnidadAdministrativa getIdUnidadAdministrativa() {
        return idUnidadAdministrativa;
    }

    public void setIdUnidadAdministrativa(RrhhUnidadAdministrativa idUnidadAdministrativa) {
        this.idUnidadAdministrativa = idUnidadAdministrativa;
    }

    public PoaMeta getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(PoaMeta idMeta) {
        this.idMeta = idMeta;
    }

    public GenEstado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(GenEstado idEstado) {
        this.idEstado = idEstado;
    }

    @XmlTransient
    public List<RrhhDetalleCapacitacion> getRrhhDetalleCapacitacionList() {
        return rrhhDetalleCapacitacionList;
    }

    public void setRrhhDetalleCapacitacionList(List<RrhhDetalleCapacitacion> rrhhDetalleCapacitacionList) {
        this.rrhhDetalleCapacitacionList = rrhhDetalleCapacitacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitudCapacitacion != null ? idSolicitudCapacitacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RrhhSolicitudCapacitacion)) {
            return false;
        }
        RrhhSolicitudCapacitacion other = (RrhhSolicitudCapacitacion) object;
        if ((this.idSolicitudCapacitacion == null && other.idSolicitudCapacitacion != null) || (this.idSolicitudCapacitacion != null && !this.idSolicitudCapacitacion.equals(other.idSolicitudCapacitacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.core.entities.RrhhSolicitudCapacitacion[ idSolicitudCapacitacion=" + idSolicitudCapacitacion + " ]";
    }
    
}
