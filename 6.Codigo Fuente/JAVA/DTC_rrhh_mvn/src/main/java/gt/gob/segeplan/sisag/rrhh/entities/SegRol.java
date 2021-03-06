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
@Table(name = "SEG_ROL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegRol.findAll", query = "SELECT s FROM SegRol s"),
    @NamedQuery(name = "SegRol.findByIdRol", query = "SELECT s FROM SegRol s WHERE s.idRol = :idRol"),
    @NamedQuery(name = "SegRol.findByNombre", query = "SELECT s FROM SegRol s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SegRol.findByDescripcion", query = "SELECT s FROM SegRol s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "SegRol.findByRestrictiva", query = "SELECT s FROM SegRol s WHERE s.restrictiva = :restrictiva")})
public class SegRol implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ROL")
    private BigDecimal idRol;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "RESTRICTIVA")
    private int restrictiva;
    @OneToMany(mappedBy = "idRol", fetch = FetchType.LAZY)
    private List<SegPaginaAsignada> segPaginaAsignadaList;
    @JoinColumn(name = "ID_UNIDAD_ADMIN", referencedColumnName = "ADSCGDP$ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private RrhhUnidadAdministrativa idUnidadAdmin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segRol", fetch = FetchType.LAZY)
    private List<SegRolUsuario> segRolUsuarioList;

    public SegRol() {
    }

    public SegRol(BigDecimal idRol) {
        this.idRol = idRol;
    }

    public BigDecimal getIdRol() {
        return idRol;
    }

    public void setIdRol(BigDecimal idRol) {
        this.idRol = idRol;
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

    public int getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(int restrictiva) {
        this.restrictiva = restrictiva;
    }

    @XmlTransient
    public List<SegPaginaAsignada> getSegPaginaAsignadaList() {
        return segPaginaAsignadaList;
    }

    public void setSegPaginaAsignadaList(List<SegPaginaAsignada> segPaginaAsignadaList) {
        this.segPaginaAsignadaList = segPaginaAsignadaList;
    }

    public RrhhUnidadAdministrativa getIdUnidadAdmin() {
        return idUnidadAdmin;
    }

    public void setIdUnidadAdmin(RrhhUnidadAdministrativa idUnidadAdmin) {
        this.idUnidadAdmin = idUnidadAdmin;
    }

    @XmlTransient
    public List<SegRolUsuario> getSegRolUsuarioList() {
        return segRolUsuarioList;
    }

    public void setSegRolUsuarioList(List<SegRolUsuario> segRolUsuarioList) {
        this.segRolUsuarioList = segRolUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRol != null ? idRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegRol)) {
            return false;
        }
        SegRol other = (SegRol) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.SegRol[ idRol=" + idRol + " ]";
    }
    
}
