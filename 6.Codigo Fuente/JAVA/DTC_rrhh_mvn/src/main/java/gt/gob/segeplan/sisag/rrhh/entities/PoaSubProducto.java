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
@Table(name = "POA_SUB_PRODUCTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PoaSubProducto.findAll", query = "SELECT p FROM PoaSubProducto p"),
    @NamedQuery(name = "PoaSubProducto.findByIdSubProducto", query = "SELECT p FROM PoaSubProducto p WHERE p.idSubProducto = :idSubProducto"),
    @NamedQuery(name = "PoaSubProducto.findByDescripcion", query = "SELECT p FROM PoaSubProducto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PoaSubProducto.findByRestrictiva", query = "SELECT p FROM PoaSubProducto p WHERE p.restrictiva = :restrictiva")})
public class PoaSubProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_SUB_PRODUCTO")
    private BigDecimal idSubProducto;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "RESTRICTIVA")
    private Character restrictiva;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(fetch = FetchType.LAZY)
    private PoaProducto idProducto;
    @OneToMany(mappedBy = "idSubProducto", fetch = FetchType.LAZY)
    private List<PoaMeta> poaMetaList;

    public PoaSubProducto() {
    }

    public PoaSubProducto(BigDecimal idSubProducto) {
        this.idSubProducto = idSubProducto;
    }

    public BigDecimal getIdSubProducto() {
        return idSubProducto;
    }

    public void setIdSubProducto(BigDecimal idSubProducto) {
        this.idSubProducto = idSubProducto;
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

    public PoaProducto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(PoaProducto idProducto) {
        this.idProducto = idProducto;
    }

    @XmlTransient
    public List<PoaMeta> getPoaMetaList() {
        return poaMetaList;
    }

    public void setPoaMetaList(List<PoaMeta> poaMetaList) {
        this.poaMetaList = poaMetaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSubProducto != null ? idSubProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoaSubProducto)) {
            return false;
        }
        PoaSubProducto other = (PoaSubProducto) object;
        if ((this.idSubProducto == null && other.idSubProducto != null) || (this.idSubProducto != null && !this.idSubProducto.equals(other.idSubProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.PoaSubProducto[ idSubProducto=" + idSubProducto + " ]";
    }
    
}
