/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gt.gob.segeplan.sisag.rrhh.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
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
    @NamedQuery(name = "RrhhSolicitudCapacitacion.findByRestrictiva", query = "SELECT r FROM RrhhSolicitudCapacitacion r WHERE r.restrictiva = :restrictiva"),
    @NamedQuery(name = "RrhhSolicitudCapacitacion.findByFechaCrea", query = "SELECT r FROM RrhhSolicitudCapacitacion r WHERE r.fechaCrea = :fechaCrea")})
public class RrhhSolicitudCapacitacion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SOLICITUD_CAPACITACION")
    @GeneratedValue(generator = "RRHH_SOLICITUD_CAPACITACION_GEN")
    @TableGenerator(name = "RRHH_SOLICITUD_CAPACITACION_GEN", table = "SECUENCIAS",
            pkColumnName = "ID", valueColumnName = "VALOR",
            pkColumnValue = "RRHH_SOLICITUD_CAPACITACION", allocationSize = 1)
    private BigDecimal idSolicitudCapacitacion;
    @Column(name = "RESTRICTIVA")
    private Character restrictiva;
    @Column(name = "FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCrea;
    @JoinColumn(name = "USR_CREA", referencedColumnName = "ID_USUARIO")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegUsuario usrCrea;
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private GenDominios idEstado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSolicitudCapacitacion", fetch = FetchType.LAZY)
    private List<RrhhNecesidad> rrhhNecesidadList;

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

    public Character getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(Character restrictiva) {
        this.restrictiva = restrictiva;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public SegUsuario getUsrCrea() {
        return usrCrea;
    }

    public void setUsrCrea(SegUsuario usrCrea) {
        this.usrCrea = usrCrea;
    }

    public GenDominios getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(GenDominios idEstado) {
        this.idEstado = idEstado;
    }

    @XmlTransient
    public List<RrhhNecesidad> getRrhhNecesidadList() {
        return rrhhNecesidadList;
    }

    public void setRrhhNecesidadList(List<RrhhNecesidad> rrhhNecesidadList) {
        this.rrhhNecesidadList = rrhhNecesidadList;
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
        return "gt.gob.segeplan.sisag.rrhh.entities.RrhhSolicitudCapacitacion[ idSolicitudCapacitacion=" + idSolicitudCapacitacion + " ]";
    }
    
}
