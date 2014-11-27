/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gt.gob.segeplan.sisag.rrhh.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "RRHH_NECESIDAD", catalog = "", schema = "SCHE$SISAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RrhhNecesidad.findAll", query = "SELECT r FROM RrhhNecesidad r"),
    @NamedQuery(name = "RrhhNecesidad.findByIdNecesidad", query = "SELECT r FROM RrhhNecesidad r WHERE r.idNecesidad = :idNecesidad"),
    @NamedQuery(name = "RrhhNecesidad.findByPrioridad", query = "SELECT r FROM RrhhNecesidad r WHERE r.prioridad = :prioridad"),
    @NamedQuery(name = "RrhhNecesidad.findByNivelConocimiento", query = "SELECT r FROM RrhhNecesidad r WHERE r.nivelConocimiento = :nivelConocimiento"),
    @NamedQuery(name = "RrhhNecesidad.findByDuracion", query = "SELECT r FROM RrhhNecesidad r WHERE r.duracion = :duracion"),
    @NamedQuery(name = "RrhhNecesidad.findByRestrictiva", query = "SELECT r FROM RrhhNecesidad r WHERE r.restrictiva = :restrictiva"),
    @NamedQuery(name = "RrhhNecesidad.findByProblemaNecesidad", query = "SELECT r FROM RrhhNecesidad r WHERE r.problemaNecesidad = :problemaNecesidad")})
public class RrhhNecesidad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_NECESIDAD")
    private BigDecimal idNecesidad;
    @Column(name = "PRIORIDAD")
    private Character prioridad;
    @Column(name = "NIVEL_CONOCIMIENTO")
    private Character nivelConocimiento;
    @Column(name = "DURACION")
    private BigDecimal duracion;
    @Column(name = "RESTRICTIVA")
    private Character restrictiva;
    @Size(max = 100)
    @Column(name = "PROBLEMA_NECESIDAD")
    private String problemaNecesidad;
    @JoinColumn(name = "ID_TEMA", referencedColumnName = "ID_TEMA")
    @ManyToOne(fetch = FetchType.EAGER)
    private RrhhTemaCurso idTema;
    @JoinColumn(name = "ID_SOLICITUD_CAPACITACION", referencedColumnName = "ID_SOLICITUD_CAPACITACION")
    @ManyToOne(fetch = FetchType.EAGER)
    private RrhhSolicitudCapacitacion idSolicitudCapacitacion;
    @JoinColumn(name = "ID_CARACTER", referencedColumnName = "ID_CARACTER")
    @ManyToOne(fetch = FetchType.EAGER)
    private RrhhCaracterNecesidad idCaracter;
    @JoinColumn(name = "ID_ESTADO", referencedColumnName = "ID_ESTADO")
    @ManyToOne(fetch = FetchType.EAGER)
    private GenEstado idEstado;
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

    public Character getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Character prioridad) {
        this.prioridad = prioridad;
    }

    public Character getNivelConocimiento() {
        return nivelConocimiento;
    }

    public void setNivelConocimiento(Character nivelConocimiento) {
        this.nivelConocimiento = nivelConocimiento;
    }

    public BigDecimal getDuracion() {
        return duracion;
    }

    public void setDuracion(BigDecimal duracion) {
        this.duracion = duracion;
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

    public RrhhCaracterNecesidad getIdCaracter() {
        return idCaracter;
    }

    public void setIdCaracter(RrhhCaracterNecesidad idCaracter) {
        this.idCaracter = idCaracter;
    }

    public GenEstado getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(GenEstado idEstado) {
        this.idEstado = idEstado;
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
