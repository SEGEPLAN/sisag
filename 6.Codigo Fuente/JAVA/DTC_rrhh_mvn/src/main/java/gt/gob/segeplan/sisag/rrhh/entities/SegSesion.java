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
@Table(name = "SEG_SESION", catalog = "", schema = "SCHE$SISAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegSesion.findAll", query = "SELECT s FROM SegSesion s"),
    @NamedQuery(name = "SegSesion.findByIdSesion", query = "SELECT s FROM SegSesion s WHERE s.idSesion = :idSesion"),
    @NamedQuery(name = "SegSesion.findByHoraInicio", query = "SELECT s FROM SegSesion s WHERE s.horaInicio = :horaInicio"),
    @NamedQuery(name = "SegSesion.findByHoraFin", query = "SELECT s FROM SegSesion s WHERE s.horaFin = :horaFin"),
    @NamedQuery(name = "SegSesion.findByFechaSesion", query = "SELECT s FROM SegSesion s WHERE s.fechaSesion = :fechaSesion"),
    @NamedQuery(name = "SegSesion.findByRestrictiva", query = "SELECT s FROM SegSesion s WHERE s.restrictiva = :restrictiva")})
public class SegSesion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SESION")
    private BigDecimal idSesion;
    @Column(name = "HORA_INICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaInicio;
    @Column(name = "HORA_FIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaFin;
    @Column(name = "FECHA_SESION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSesion;
    @Column(name = "RESTRICTIVA")
    private Character restrictiva;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(fetch = FetchType.EAGER)
    private SegUsuario idUsuario;
    @OneToMany(mappedBy = "idSesion", fetch = FetchType.EAGER)
    private List<SegBitacora> segBitacoraList;

    public SegSesion() {
    }

    public SegSesion(BigDecimal idSesion) {
        this.idSesion = idSesion;
    }

    public BigDecimal getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(BigDecimal idSesion) {
        this.idSesion = idSesion;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public Date getFechaSesion() {
        return fechaSesion;
    }

    public void setFechaSesion(Date fechaSesion) {
        this.fechaSesion = fechaSesion;
    }

    public Character getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(Character restrictiva) {
        this.restrictiva = restrictiva;
    }

    public SegUsuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(SegUsuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<SegBitacora> getSegBitacoraList() {
        return segBitacoraList;
    }

    public void setSegBitacoraList(List<SegBitacora> segBitacoraList) {
        this.segBitacoraList = segBitacoraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSesion != null ? idSesion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegSesion)) {
            return false;
        }
        SegSesion other = (SegSesion) object;
        if ((this.idSesion == null && other.idSesion != null) || (this.idSesion != null && !this.idSesion.equals(other.idSesion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.SegSesion[ idSesion=" + idSesion + " ]";
    }
    
}
