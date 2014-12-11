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
@Table(name = "SEG_TIPO_PAGINA", catalog = "", schema = "SCHE$SISAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegTipoPagina.findAll", query = "SELECT s FROM SegTipoPagina s"),
    @NamedQuery(name = "SegTipoPagina.findByIdTipoPagina", query = "SELECT s FROM SegTipoPagina s WHERE s.idTipoPagina = :idTipoPagina"),
    @NamedQuery(name = "SegTipoPagina.findByNombre", query = "SELECT s FROM SegTipoPagina s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SegTipoPagina.findByDescripcion", query = "SELECT s FROM SegTipoPagina s WHERE s.descripcion = :descripcion")})
public class SegTipoPagina implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TIPO_PAGINA")
    private BigDecimal idTipoPagina;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "idTipoPagina", fetch = FetchType.EAGER)
    private List<SegPagina> segPaginaList;

    public SegTipoPagina() {
    }

    public SegTipoPagina(BigDecimal idTipoPagina) {
        this.idTipoPagina = idTipoPagina;
    }

    public BigDecimal getIdTipoPagina() {
        return idTipoPagina;
    }

    public void setIdTipoPagina(BigDecimal idTipoPagina) {
        this.idTipoPagina = idTipoPagina;
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
        hash += (idTipoPagina != null ? idTipoPagina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegTipoPagina)) {
            return false;
        }
        SegTipoPagina other = (SegTipoPagina) object;
        if ((this.idTipoPagina == null && other.idTipoPagina != null) || (this.idTipoPagina != null && !this.idTipoPagina.equals(other.idTipoPagina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.SegTipoPagina[ idTipoPagina=" + idTipoPagina + " ]";
    }
    
}
