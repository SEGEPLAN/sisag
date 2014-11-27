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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
    @NotNull
    @Column(name = "ID_ESTADO")
    private BigDecimal idEstado;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "RESTRICTIVA")
    private Character restrictiva;
    @OneToMany(mappedBy = "idEstado", fetch = FetchType.EAGER)
    private List<RrhhNecesidad> rrhhNecesidadList;

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
    public List<RrhhNecesidad> getRrhhNecesidadList() {
        return rrhhNecesidadList;
    }

    public void setRrhhNecesidadList(List<RrhhNecesidad> rrhhNecesidadList) {
        this.rrhhNecesidadList = rrhhNecesidadList;
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
        return "gt.gob.segeplan.sisag.rrhh.entities.GenEstado[ idEstado=" + idEstado + " ]";
    }
    
}
