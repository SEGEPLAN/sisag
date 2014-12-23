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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
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
@Table(name = "RRHH_TIPO_PUESTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RrhhTipoPuesto.findAll", query = "SELECT r FROM RrhhTipoPuesto r"),
    @NamedQuery(name = "RrhhTipoPuesto.findByIdTipoPuesto", query = "SELECT r FROM RrhhTipoPuesto r WHERE r.idTipoPuesto = :idTipoPuesto"),
    @NamedQuery(name = "RrhhTipoPuesto.findByNombre", query = "SELECT r FROM RrhhTipoPuesto r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "RrhhTipoPuesto.findByDescripcion", query = "SELECT r FROM RrhhTipoPuesto r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "RrhhTipoPuesto.findByRestrictiva", query = "SELECT r FROM RrhhTipoPuesto r WHERE r.restrictiva = :restrictiva")})
public class RrhhTipoPuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_PUESTO")
    private BigDecimal idTipoPuesto;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "RESTRICTIVA")
    private Character restrictiva;
   
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rrhhTipoPuesto", fetch = FetchType.EAGER)
    private List<RrhhNecesidadPuesto> rrhhNecesidadPuestoList;
    
    
    @Transient 
    private int total;

    public RrhhTipoPuesto() {
    }

    public RrhhTipoPuesto(BigDecimal idTipoPuesto) {
        this.idTipoPuesto = idTipoPuesto;
    }

    public BigDecimal getIdTipoPuesto() {
        return idTipoPuesto;
    }

    public void setIdTipoPuesto(BigDecimal idTipoPuesto) {
        this.idTipoPuesto = idTipoPuesto;
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

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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
        hash += (idTipoPuesto != null ? idTipoPuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RrhhTipoPuesto)) {
            return false;
        }
        RrhhTipoPuesto other = (RrhhTipoPuesto) object;
        if ((this.idTipoPuesto == null && other.idTipoPuesto != null) || (this.idTipoPuesto != null && !this.idTipoPuesto.equals(other.idTipoPuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.RrhhTipoPuesto[ idTipoPuesto=" + idTipoPuesto + " ]";
    }
    
}
