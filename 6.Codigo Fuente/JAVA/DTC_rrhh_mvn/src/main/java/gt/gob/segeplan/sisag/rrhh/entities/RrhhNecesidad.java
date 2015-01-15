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
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "RRHH_NECESIDAD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RrhhNecesidad.findAll", query = "SELECT r FROM RrhhNecesidad r"),
    @NamedQuery(name = "RrhhNecesidad.findByIdNecesidad", query = "SELECT r FROM RrhhNecesidad r WHERE r.idNecesidad = :idNecesidad"),
    @NamedQuery(name = "RrhhNecesidad.findByHorasDia", query = "SELECT r FROM RrhhNecesidad r WHERE r.horasDia = :horasDia"),
    @NamedQuery(name = "RrhhNecesidad.findByRestrictiva", query = "SELECT r FROM RrhhNecesidad r WHERE r.restrictiva = :restrictiva"),
    @NamedQuery(name = "RrhhNecesidad.findByProblemaNecesidad", query = "SELECT r FROM RrhhNecesidad r WHERE r.problemaNecesidad = :problemaNecesidad"),
    @NamedQuery(name = "RrhhNecesidad.findByTotalHoras", query = "SELECT r FROM RrhhNecesidad r WHERE r.totalHoras = :totalHoras"),
    @NamedQuery(name = "RrhhNecesidad.findByUsrCrea", query = "SELECT r FROM RrhhNecesidad r WHERE r.usrCrea = :usrCrea"),
    @NamedQuery(name = "RrhhNecesidad.findByUsrModifica", query = "SELECT r FROM RrhhNecesidad r WHERE r.usrModifica = :usrModifica"),
    @NamedQuery(name = "RrhhNecesidad.findByFechaCrea", query = "SELECT r FROM RrhhNecesidad r WHERE r.fechaCrea = :fechaCrea"),
    @NamedQuery(name = "RrhhNecesidad.findByFechaModifica", query = "SELECT r FROM RrhhNecesidad r WHERE r.fechaModifica = :fechaModifica")})
public class RrhhNecesidad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_NECESIDAD", nullable = false)
    @GeneratedValue(generator = "RRHH_NECESIDAD_GEN")
    @TableGenerator(name = "RRHH_NECESIDAD_GEN", table = "SECUENCIAS",
            pkColumnName = "ID", valueColumnName = "VALOR",
            pkColumnValue = "RRHH_NECESIDAD", allocationSize = 1)
    private BigDecimal idNecesidad;
    @Column(name = "HORAS_DIA")
    private BigDecimal horasDia;
    @Column(name = "RESTRICTIVA")
    private Character restrictiva;
    @Size(max = 500)
    @Column(name = "PROBLEMA_NECESIDAD")
    private String problemaNecesidad;
    @Column(name = "TOTAL_HORAS")
    private BigInteger totalHoras;
    @Column(name = "USR_CREA")
    private BigInteger usrCrea;
    @Column(name = "USR_MODIFICA")
    private BigInteger usrModifica;
    @Column(name = "FECHA_CREA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCrea;
    @Column(name = "FECHA_MODIFICA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModifica;
    @JoinColumn(name = "ID_TEMA", referencedColumnName = "ID_TEMA")
    @ManyToOne(fetch = FetchType.EAGER)
    private RrhhTemaCurso idTema;
    @JoinColumn(name = "ID_SOLICITUD_CAPACITACION", referencedColumnName = "ID_SOLICITUD_CAPACITACION")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private RrhhSolicitudCapacitacion idSolicitudCapacitacion;
    @JoinColumn(name = "ID_PRIORIDAD", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private GenDominios idPrioridad;
    @JoinColumn(name = "ID_CARACTER", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private GenDominios idCaracter;
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private GenDominios idEstado;
    @JoinColumn(name = "ID_DISPONIBILIDAD", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private GenDominios idDisponibilidad;
    @JoinColumn(name = "ID_NIVEL_CONOCIMIENTO", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private GenDominios idNivelConocimiento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rrhhNecesidad", fetch = FetchType.EAGER)
    private List<RrhhNecesidadPuesto> rrhhNecesidadPuestoList;
    
   
    

    public RrhhNecesidad() {
    }

    public RrhhNecesidad(BigDecimal idNecesidad) {
        this.idNecesidad = idNecesidad;
    }

    public BigDecimal getIdNecesidad() {
        return idNecesidad;
    }

    public void setIdNecesidad(BigDecimal idNecesidad) {
        this.idNecesidad = idNecesidad;
    }

    public BigDecimal getHorasDia() {
        return horasDia;
    }

    public void setHorasDia(BigDecimal horasDia) {
        this.horasDia = horasDia;
    }

    public Character getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(Character restrictiva) {
        this.restrictiva = restrictiva;
    }

    public String getProblemaNecesidad() {
        return problemaNecesidad;
    }

    public void setProblemaNecesidad(String problemaNecesidad) {
        this.problemaNecesidad = problemaNecesidad;
    }

    public BigInteger getTotalHoras() {
        return totalHoras;
    }

    public void setTotalHoras(BigInteger totalHoras) {
        this.totalHoras = totalHoras;
    }

    public BigInteger getUsrCrea() {
        return usrCrea;
    }

    public void setUsrCrea(BigInteger usrCrea) {
        this.usrCrea = usrCrea;
    }

    public BigInteger getUsrModifica() {
        return usrModifica;
    }

    public void setUsrModifica(BigInteger usrModifica) {
        this.usrModifica = usrModifica;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public Date getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(Date fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    public RrhhTemaCurso getIdTema() {
        return idTema;
    }

    public void setIdTema(RrhhTemaCurso idTema) {
        this.idTema = idTema;
    }

    public RrhhSolicitudCapacitacion getIdSolicitudCapacitacion() {
        return idSolicitudCapacitacion;
    }

    public void setIdSolicitudCapacitacion(RrhhSolicitudCapacitacion idSolicitudCapacitacion) {
        this.idSolicitudCapacitacion = idSolicitudCapacitacion;
    }

    public GenDominios getIdPrioridad() {
        return idPrioridad;
    }

    public void setIdPrioridad(GenDominios idPrioridad) {
        this.idPrioridad = idPrioridad;
    }

    public GenDominios getIdCaracter() {
        return idCaracter;
    }

    public void setIdCaracter(GenDominios idCaracter) {
        this.idCaracter = idCaracter;
    }

    public GenDominios getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(GenDominios idEstado) {
        this.idEstado = idEstado;
    }

    public GenDominios getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(GenDominios idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public GenDominios getIdNivelConocimiento() {
        return idNivelConocimiento;
    }

    public void setIdNivelConocimiento(GenDominios idNivelConocimiento) {
        this.idNivelConocimiento = idNivelConocimiento;
    }

    
    
    
    @XmlTransient
    public List<RrhhNecesidadPuesto> getRrhhNecesidadPuestoList() {
        return rrhhNecesidadPuestoList;
    }

    public void setRrhhNecesidadPuestoList(List<RrhhNecesidadPuesto> rrhhNecesidadPuestoList) {
        this.rrhhNecesidadPuestoList = rrhhNecesidadPuestoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNecesidad != null ? idNecesidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RrhhNecesidad)) {
            return false;
        }
        RrhhNecesidad other = (RrhhNecesidad) object;
        if ((this.idNecesidad == null && other.idNecesidad != null) || (this.idNecesidad != null && !this.idNecesidad.equals(other.idNecesidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.RrhhNecesidad[ idNecesidad=" + idNecesidad + " ]";
    }
    
}
