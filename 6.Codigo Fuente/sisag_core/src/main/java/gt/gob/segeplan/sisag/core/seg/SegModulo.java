/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.seg;

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
@Table(name = "SEG_MODULO", catalog = "", schema = "SCHE$SISAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegModulo.findAll", query = "SELECT s FROM SegModulo s"),
    @NamedQuery(name = "SegModulo.findByIdModulo", query = "SELECT s FROM SegModulo s WHERE s.idModulo = :idModulo"),
    @NamedQuery(name = "SegModulo.findByNombre", query = "SELECT s FROM SegModulo s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SegModulo.findByDescripcion", query = "SELECT s FROM SegModulo s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "SegModulo.findByRestrictiva", query = "SELECT s FROM SegModulo s WHERE s.restrictiva = :restrictiva")})
public class SegModulo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_modulo")
    private BigDecimal idModulo;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "restrictiva")
    private Character restrictiva;
    @OneToMany(mappedBy = "idModulo", fetch = FetchType.EAGER)
    private List<SegPagina> segPaginaList;

    public SegModulo() {
    }

    public SegModulo(BigDecimal idModulo) {
        this.idModulo = idModulo;
    }

    public BigDecimal getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(BigDecimal idModulo) {
        this.idModulo = idModulo;
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
    public List<SegPagina> getSegPaginaList() {
        return segPaginaList;
    }

    public void setSegPaginaList(List<SegPagina> segPaginaList) {
        this.segPaginaList = segPaginaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idModulo != null ? idModulo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegModulo)) {
            return false;
        }
        SegModulo other = (SegModulo) object;
        if ((this.idModulo == null && other.idModulo != null) || (this.idModulo != null && !this.idModulo.equals(other.idModulo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.core.entities.SegModulo[ idModulo=" + idModulo + " ]";
    }
    
}
