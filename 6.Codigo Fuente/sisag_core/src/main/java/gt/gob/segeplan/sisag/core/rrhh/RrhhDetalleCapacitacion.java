/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.rrhh;

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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "RRHH_DETALLE_CAPACITACION", catalog = "", schema = "SCHE$SISAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RrhhDetalleCapacitacion.findAll", query = "SELECT r FROM RrhhDetalleCapacitacion r"),
    @NamedQuery(name = "RrhhDetalleCapacitacion.findByIdDetalle", query = "SELECT r FROM RrhhDetalleCapacitacion r WHERE r.idDetalle = :idDetalle"),
    @NamedQuery(name = "RrhhDetalleCapacitacion.findByProblematica", query = "SELECT r FROM RrhhDetalleCapacitacion r WHERE r.problematica = :problematica"),
    @NamedQuery(name = "RrhhDetalleCapacitacion.findByTema", query = "SELECT r FROM RrhhDetalleCapacitacion r WHERE r.tema = :tema"),
    @NamedQuery(name = "RrhhDetalleCapacitacion.findByPrioridad", query = "SELECT r FROM RrhhDetalleCapacitacion r WHERE r.prioridad = :prioridad"),
    @NamedQuery(name = "RrhhDetalleCapacitacion.findByNivelEconomico", query = "SELECT r FROM RrhhDetalleCapacitacion r WHERE r.nivelEconomico = :nivelEconomico"),
    @NamedQuery(name = "RrhhDetalleCapacitacion.findByDuracion", query = "SELECT r FROM RrhhDetalleCapacitacion r WHERE r.duracion = :duracion"),
    @NamedQuery(name = "RrhhDetalleCapacitacion.findByIdCaracter", query = "SELECT r FROM RrhhDetalleCapacitacion r WHERE r.idCaracter = :idCaracter"),
    @NamedQuery(name = "RrhhDetalleCapacitacion.findByRestrictiva", query = "SELECT r FROM RrhhDetalleCapacitacion r WHERE r.restrictiva = :restrictiva")})
public class RrhhDetalleCapacitacion implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_detalle")
    private BigDecimal idDetalle;
    @Column(name = "problematica")
    private String problematica;
    @Column(name = "tema")
    private String tema;
    @Column(name = "prioridad")
    private Character prioridad;
    @Column(name = "nivel_economico")
    private Character nivelEconomico;
    @Column(name = "duracion")
    private BigDecimal duracion;
    @Column(name = "id_caracter")
    private String idCaracter;
    @Column(name = "restrictiva")
    private Character restrictiva;
    @JoinColumn(name = "id_solicitud_capacitacion", referencedColumnName = "id_solicitud_capacitacion")
    @ManyToOne(fetch = FetchType.EAGER)
    private RrhhSolicitudCapacitacion idSolicitudCapacitacion;
    @JoinColumn(name = "id_detalle", referencedColumnName = "id_caracter", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    private RrhhCaracterCapacitacion rrhhCaracterCapacitacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rrhhDetalleCapacitacion", fetch = FetchType.EAGER)
    private List<RrhhAsignaCapacitacion> rrhhAsignaCapacitacionList;

    public RrhhDetalleCapacitacion() {
    }

    public RrhhDetalleCapacitacion(BigDecimal idDetalle) {
        this.idDetalle = idDetalle;
    }

    public BigDecimal getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(BigDecimal idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getProblematica() {
        return problematica;
    }

    public void setProblematica(String problematica) {
        this.problematica = problematica;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Character getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Character prioridad) {
        this.prioridad = prioridad;
    }

    public Character getNivelEconomico() {
        return nivelEconomico;
    }

    public void setNivelEconomico(Character nivelEconomico) {
        this.nivelEconomico = nivelEconomico;
    }

    public BigDecimal getDuracion() {
        return duracion;
    }

    public void setDuracion(BigDecimal duracion) {
        this.duracion = duracion;
    }

    public String getIdCaracter() {
        return idCaracter;
    }

    public void setIdCaracter(String idCaracter) {
        this.idCaracter = idCaracter;
    }

    public Character getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(Character restrictiva) {
        this.restrictiva = restrictiva;
    }

    public RrhhSolicitudCapacitacion getIdSolicitudCapacitacion() {
        return idSolicitudCapacitacion;
    }

    public void setIdSolicitudCapacitacion(RrhhSolicitudCapacitacion idSolicitudCapacitacion) {
        this.idSolicitudCapacitacion = idSolicitudCapacitacion;
    }

    public RrhhCaracterCapacitacion getRrhhCaracterCapacitacion() {
        return rrhhCaracterCapacitacion;
    }

    public void setRrhhCaracterCapacitacion(RrhhCaracterCapacitacion rrhhCaracterCapacitacion) {
        this.rrhhCaracterCapacitacion = rrhhCaracterCapacitacion;
    }

    @XmlTransient
    public List<RrhhAsignaCapacitacion> getRrhhAsignaCapacitacionList() {
        return rrhhAsignaCapacitacionList;
    }

    public void setRrhhAsignaCapacitacionList(List<RrhhAsignaCapacitacion> rrhhAsignaCapacitacionList) {
        this.rrhhAsignaCapacitacionList = rrhhAsignaCapacitacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RrhhDetalleCapacitacion)) {
            return false;
        }
        RrhhDetalleCapacitacion other = (RrhhDetalleCapacitacion) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.core.entities.RrhhDetalleCapacitacion[ idDetalle=" + idDetalle + " ]";
    }
    
}
