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
@Table(name = "SEG_PAGINA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegPagina.findAll", query = "SELECT s FROM SegPagina s"),
    @NamedQuery(name = "SegPagina.findByIdPagina", query = "SELECT s FROM SegPagina s WHERE s.idPagina = :idPagina"),
    @NamedQuery(name = "SegPagina.findByNombre", query = "SELECT s FROM SegPagina s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SegPagina.findByUrl", query = "SELECT s FROM SegPagina s WHERE s.url = :url"),
    @NamedQuery(name = "SegPagina.findByDescripcion", query = "SELECT s FROM SegPagina s WHERE s.descripcion = :descripcion"),
    @NamedQuery(name = "SegPagina.findByRestrictiva", query = "SELECT s FROM SegPagina s WHERE s.restrictiva = :restrictiva")})
public class SegPagina implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PAGINA")
    private BigDecimal idPagina;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 100)
    @Column(name = "URL")
    private String url;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "RESTRICTIVA")
    private Character restrictiva;
    @OneToMany(mappedBy = "idPagina", fetch = FetchType.EAGER)
    private List<SegPaginaAsignada> segPaginaAsignadaList;
    @OneToMany(mappedBy = "idPagina", fetch = FetchType.EAGER)
    private List<SegBitacora> segBitacoraList;
    @JoinColumn(name = "ID_TIPO_PAGINA", referencedColumnName = "ID_TIPO_PAGINA")
    @ManyToOne(fetch = FetchType.EAGER)
    private SegTipoPagina idTipoPagina;
    @JoinColumn(name = "ID_MODULO", referencedColumnName = "ID_MODULO")
    @ManyToOne(fetch = FetchType.EAGER)
    private SegModulo idModulo;

    public SegPagina() {
    }

    public SegPagina(BigDecimal idPagina) {
        this.idPagina = idPagina;
    }

    public BigDecimal getIdPagina() {
        return idPagina;
    }

    public void setIdPagina(BigDecimal idPagina) {
        this.idPagina = idPagina;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
    public List<SegPaginaAsignada> getSegPaginaAsignadaList() {
        return segPaginaAsignadaList;
    }

    public void setSegPaginaAsignadaList(List<SegPaginaAsignada> segPaginaAsignadaList) {
        this.segPaginaAsignadaList = segPaginaAsignadaList;
    }

    @XmlTransient
    public List<SegBitacora> getSegBitacoraList() {
        return segBitacoraList;
    }

    public void setSegBitacoraList(List<SegBitacora> segBitacoraList) {
        this.segBitacoraList = segBitacoraList;
    }

    public SegTipoPagina getIdTipoPagina() {
        return idTipoPagina;
    }

    public void setIdTipoPagina(SegTipoPagina idTipoPagina) {
        this.idTipoPagina = idTipoPagina;
    }

    public SegModulo getIdModulo() {
        return idModulo;
    }

    public void setIdModulo(SegModulo idModulo) {
        this.idModulo = idModulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagina != null ? idPagina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegPagina)) {
            return false;
        }
        SegPagina other = (SegPagina) object;
        if ((this.idPagina == null && other.idPagina != null) || (this.idPagina != null && !this.idPagina.equals(other.idPagina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.SegPagina[ idPagina=" + idPagina + " ]";
    }
    
}
