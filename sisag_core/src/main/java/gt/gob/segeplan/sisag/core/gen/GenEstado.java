/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.gen;

import gt.gob.segeplan.sisag.core.rrhh.RrhhSolicitudCapacitacion;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "GEN_ESTADO", catalog = "", schema = "SCHE$SISAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenEstado.findAll", query = "SELECT g FROM GenEstado g"),
    @NamedQuery(name = "GenEstado.findByIdEstado", query = "SELECT g FROM GenEstado g WHERE g.idEstado = :idEstado"),
    @NamedQuery(name = "GenEstado.findByNombre", query = "SELECT g FROM GenEstado g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "GenEstado.findByDescripcion", query = "SELECT g FROM GenEstado g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "GenEstado.findByRestrictiva", query = "SELECT g FROM GenEstado g WHERE g.restrictiva = :restrictiva")})
public class GenEstado implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_estado")
    private BigDecimal idEstado;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "restrictiva")
    private Character restrictiva;
    @OneToMany(mappedBy = "idEstado", fetch = FetchType.EAGER)
    private List<RrhhSolicitudCapacitacion> rrhhSolicitudCapacitacionList;
    @OneToMany(mappedBy = "idEstado", fetch = FetchType.EAGER)
    private List<GenSolicitudFinaciera> genSolicitudFinacieraList;

    public GenEstado() {
    }

    public GenEstado(BigDecimal idEstado) {
        this.idEstado = idEstado;
    }

    public BigDecimal getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(BigDecimal idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    @XmlTransient
    public List<RrhhSolicitudCapacitacion> getRrhhSolicitudCapacitacionList() {
        return rrhhSolicitudCapacitacionList;
    }

    public void setRrhhSolicitudCapacitacionList(List<RrhhSolicitudCapacitacion> rrhhSolicitudCapacitacionList) {
        this.rrhhSolicitudCapacitacionList = rrhhSolicitudCapacitacionList;
    }

    @XmlTransient
    public List<GenSolicitudFinaciera> getGenSolicitudFinacieraList() {
        return genSolicitudFinacieraList;
    }

    public void setGenSolicitudFinacieraList(List<GenSolicitudFinaciera> genSolicitudFinacieraList) {
        this.genSolicitudFinacieraList = genSolicitudFinacieraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstado != null ? idEstado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenEstado)) {
            return false;
        }
        GenEstado other = (GenEstado) object;
        if ((this.idEstado == null && other.idEstado != null) || (this.idEstado != null && !this.idEstado.equals(other.idEstado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.core.entities.GenEstado[ idEstado=" + idEstado + " ]";
    }
    
}
