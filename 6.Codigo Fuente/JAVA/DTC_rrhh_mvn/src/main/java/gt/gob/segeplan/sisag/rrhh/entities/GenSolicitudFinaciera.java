/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gt.gob.segeplan.sisag.rrhh.entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "GEN_SOLICITUD_FINACIERA")
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
    @NotNull
    @Column(name = "ID_SOLICITUD")
    private BigDecimal idSolicitud;
    @Column(name = "CODIGO")
    private BigInteger codigo;
    @Column(name = "ID_FUENTE_FINANCIAMIENTO")
    private BigInteger idFuenteFinanciamiento;
    @Column(name = "MONTO")
    private BigDecimal monto;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "FECHA_REALIZACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRealizacion;
    @Column(name = "FECHA_PAGO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPago;
    @Column(name = "RESTRICTIVA")
    private Character restrictiva;
    @JoinColumn(name = "ID_META", referencedColumnName = "ID_META")
    @ManyToOne(fetch = FetchType.EAGER)
    private PoaMeta idMeta;
    @JoinColumn(name = "ID_TIPO_SOLICITUD", referencedColumnName = "ID_TIPO_SOLICITUD")
    @ManyToOne(fetch = FetchType.EAGER)
    private GenTipoSolicitud idTipoSolicitud;
    @JoinColumn(name = "ID_PERIODO", referencedColumnName = "ID_PERIODO")
    @ManyToOne(fetch = FetchType.EAGER)
    private GenPeriodo idPeriodo;

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
        return "gt.gob.segeplan.sisag.rrhh.entities.GenSolicitudFinaciera[ idSolicitud=" + idSolicitud + " ]";
    }
    
}
