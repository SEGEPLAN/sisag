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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "SEG_PRIVILEGIO", catalog = "", schema = "SCHE$SISAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegPrivilegio.findAll", query = "SELECT s FROM SegPrivilegio s"),
    @NamedQuery(name = "SegPrivilegio.findByIdPrivilegio", query = "SELECT s FROM SegPrivilegio s WHERE s.idPrivilegio = :idPrivilegio"),
    @NamedQuery(name = "SegPrivilegio.findByNombre", query = "SELECT s FROM SegPrivilegio s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SegPrivilegio.findByDescripcion", query = "SELECT s FROM SegPrivilegio s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "SegPrivilegio.findByRestrictiva", query = "SELECT s FROM SegPrivilegio s WHERE s.restrictiva = :restrictiva")})
public class SegPrivilegio implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PRIVILEGIO")
    private BigDecimal idPrivilegio;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "RESTRICTIVA")
    private Character restrictiva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segPrivilegio", fetch = FetchType.EAGER)
    private List<SegPrivilegioPagina> segPrivilegioPaginaList;

    public SegPrivilegio() {
    }

    public SegPrivilegio(BigDecimal idPrivilegio) {
        this.idPrivilegio = idPrivilegio;
    }

    public BigDecimal getIdPrivilegio() {
        return idPrivilegio;
    }

    public void setIdPrivilegio(BigDecimal idPrivilegio) {
        this.idPrivilegio = idPrivilegio;
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
    public List<SegPrivilegioPagina> getSegPrivilegioPaginaList() {
        return segPrivilegioPaginaList;
    }

    public void setSegPrivilegioPaginaList(List<SegPrivilegioPagina> segPrivilegioPaginaList) {
        this.segPrivilegioPaginaList = segPrivilegioPaginaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPrivilegio != null ? idPrivilegio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegPrivilegio)) {
            return false;
        }
        SegPrivilegio other = (SegPrivilegio) object;
        if ((this.idPrivilegio == null && other.idPrivilegio != null) || (this.idPrivilegio != null && !this.idPrivilegio.equals(other.idPrivilegio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.SegPrivilegio[ idPrivilegio=" + idPrivilegio + " ]";
    }
    
}
