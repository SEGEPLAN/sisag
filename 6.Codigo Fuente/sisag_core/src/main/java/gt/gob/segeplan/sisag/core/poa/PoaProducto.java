/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.poa;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
@Table(name = "POA_PRODUCTO", catalog = "", schema = "SCHE$SISAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PoaProducto.findAll", query = "SELECT p FROM PoaProducto p"),
    @NamedQuery(name = "PoaProducto.findByIdProducto", query = "SELECT p FROM PoaProducto p WHERE p.idProducto = :idProducto"),
    @NamedQuery(name = "PoaProducto.findByDescripcion", query = "SELECT p FROM PoaProducto p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PoaProducto.findByInciso", query = "SELECT p FROM PoaProducto p WHERE p.inciso = :inciso"),
    @NamedQuery(name = "PoaProducto.findByRestrictiva", query = "SELECT p FROM PoaProducto p WHERE p.restrictiva = :restrictiva")})
public class PoaProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_producto")
    private BigDecimal idProducto;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "inciso")
    private BigInteger inciso;
    @Column(name = "restrictiva")
    private Character restrictiva;
    @OneToMany(mappedBy = "idProducto", fetch = FetchType.EAGER)
    private List<PoaSubProducto> poaSubProductoList;

    public PoaProducto() {
    }

    public PoaProducto(BigDecimal idProducto) {
        this.idProducto = idProducto;
    }

    public BigDecimal getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(BigDecimal idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getInciso() {
        return inciso;
    }

    public void setInciso(BigInteger inciso) {
        this.inciso = inciso;
    }

    public Character getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(Character restrictiva) {
        this.restrictiva = restrictiva;
    }

    @XmlTransient
    public List<PoaSubProducto> getPoaSubProductoList() {
        return poaSubProductoList;
    }

    public void setPoaSubProductoList(List<PoaSubProducto> poaSubProductoList) {
        this.poaSubProductoList = poaSubProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoaProducto)) {
            return false;
        }
        PoaProducto other = (PoaProducto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.core.entities.PoaProducto[ idProducto=" + idProducto + " ]";
    }
    
}
