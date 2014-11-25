/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.gen;

import gt.gob.segeplan.sisag.core.poa.PoaMeta;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "GEN_SOLICITUD_FINACIERA", catalog = "", schema = "SCHE$SISAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenSolicitudFinaciera.findAll", query = "SELECT g FROM GenSolicitudFinaciera g"),
    @NamedQuery(name = "GenSolicitudFinaciera.findByIdSolicitud", query = "SELECT g FROM GenSolicitudFinaciera g WHERE g.idSolicitud = :idSolicitud"),
    @NamedQuery(name = "GenSolicitudFinaciera.findByCodigo", query = "SELECT g FROM GenSolicitudFinaciera g WHERE g.codigo = :codigo"),
    @NamedQuery(name = "GenSolicitudFinaciera.findByIdFuenteFinanciamiento", query = "SELECT g FROM GenSolicitudFinaciera g WHERE g.idFuenteFinanciamiento = :idFuenteFinanciamiento"),
    @NamedQuery(name = "GenSolicitudFinaciera.findByMonto", query = "SELECT g FROM GenSolicitudFinaciera g WHERE g.monto = :monto"),
    @NamedQuery(name = "GenSolicitudFinaciera.findByDescripcion", query = "SELECT g FROM GenSolicitudFinaciera g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "GenSolicitudFinaciera.findByFechaRealizacion", query = "SELECT g FROM GenSolicitudFinaciera g WHERE g.fechaRealizacion = :fechaRealizacion"),
    @NamedQuery(name = "GenSolicitudFinaciera.findByFechaPago", query = "SELECT g FROM GenSolicitudFinaciera g WHERE g.fechaPago = :fechaPago"),
    @NamedQuery(name = "GenSolicitudFinaciera.findByRestrictiva", query = "SELECT g FROM GenSolicitudFinaciera g WHERE g.restrictiva = :restrictiva")})
public class GenSolicitudFinaciera implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_solicitud")
    private BigDecimal idSolicitud;
    @Column(name = "codigo")
    private BigInteger codigo;
    @Column(name = "id_fuente_financiamiento")
    private BigInteger idFuenteFinanciamiento;
    @Column(name = "monto")
    private BigDecimal monto;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_realizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRealizacion;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    @Column(name = "restrictiva")
    private Character restrictiva;
    @JoinColumn(name = "id_meta", referencedColumnName = "id_meta")
    @ManyToOne(fetch = FetchType.EAGER)
    private PoaMeta idMeta;
    @JoinColumn(name = "id_tipo_solicitud", referencedColumnName = "id_tipo_solicitud")
    @ManyToOne(fetch = FetchType.EAGER)
    private GenTipoSolicitud idTipoSolicitud;
    @JoinColumn(name = "id_periodo", referencedColumnName = "id_periodo")
    @ManyToOne(fetch = FetchType.EAGER)
    private GenPeriodo idPeriodo;
    @JoinColumn(name = "id_estado", referencedColumnName = "id_estado")
    @ManyToOne(fetch = FetchType.EAGER)
    private GenEstado idEstado;

    public GenSolicitudFinaciera() {
    }

    public GenSolicitudFinaciera(BigDecimal idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public BigDecimal getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(BigDecimal idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public BigInteger getCodigo() {
        return codigo;
    }

    public void setCodigo(BigInteger codigo) {
        this.codigo = codigo;
    }

    public BigInteger getIdFuenteFinanciamiento() {
        return idFuenteFinanciamiento;
    }

    public void setIdFuenteFinanciamiento(BigInteger idFuenteFinanciamiento) {
        this.idFuenteFinanciamiento = idFuenteFinanciamiento;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaRealizacion() {
        return fechaRealizacion;
    }

    public void setFechaRealizacion(Date fechaRealizacion) {
        this.fechaRealizacion = fechaRealizacion;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Character getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(Character restrictiva) {
        this.restrictiva = restrictiva;
    }

    public PoaMeta getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(PoaMeta idMeta) {
        this.idMeta = idMeta;
    }

    public GenTipoSolicitud getIdTipoSolicitud() {
        return idTipoSolicitud;
    }

    public void setIdTipoSolicitud(GenTipoSolicitud idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public GenPeriodo getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(GenPeriodo idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public GenEstado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(GenEstado idEstado) {
        this.idEstado = idEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSolicitud != null ? idSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenSolicitudFinaciera)) {
            return false;
        }
        GenSolicitudFinaciera other = (GenSolicitudFinaciera) object;
        if ((this.idSolicitud == null && other.idSolicitud != null) || (this.idSolicitud != null && !this.idSolicitud.equals(other.idSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.core.entities.GenSolicitudFinaciera[ idSolicitud=" + idSolicitud + " ]";
    }
    
}
