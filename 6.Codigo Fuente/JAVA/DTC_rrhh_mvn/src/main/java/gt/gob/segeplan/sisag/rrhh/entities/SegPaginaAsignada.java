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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "SEG_PAGINA_ASIGNADA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegPaginaAsignada.findAll", query = "SELECT s FROM SegPaginaAsignada s"),
    @NamedQuery(name = "SegPaginaAsignada.findByIdAsignacion", query = "SELECT s FROM SegPaginaAsignada s WHERE s.idAsignacion = :idAsignacion"),
    @NamedQuery(name = "SegPaginaAsignada.findByRestrictiva", query = "SELECT s FROM SegPaginaAsignada s WHERE s.restrictiva = :restrictiva")})
public class SegPaginaAsignada implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_ASIGNACION")
    private BigDecimal idAsignacion;
    @Column(name = "RESTRICTIVA")
    private Character restrictiva;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO")
    @ManyToOne(fetch = FetchType.EAGER)
    private SegUsuario idUsuario;
    @JoinColumn(name = "ID_ROL", referencedColumnName = "ID_ROL")
    @ManyToOne(fetch = FetchType.EAGER)
    private SegRol idRol;
    @JoinColumn(name = "ID_PAGINA", referencedColumnName = "ID_PAGINA")
    @ManyToOne(fetch = FetchType.LAZY)
    private SegPagina idPagina;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segPaginaAsignada", fetch = FetchType.LAZY)
    private List<SegPrivilegioPagina> segPrivilegioPaginaList;

    public SegPaginaAsignada() {
    }

    public SegPaginaAsignada(BigDecimal idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public BigDecimal getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(BigDecimal idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Character getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(Character restrictiva) {
        this.restrictiva = restrictiva;
    }

    public SegUsuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(SegUsuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public SegRol getIdRol() {
        return idRol;
    }

    public void setIdRol(SegRol idRol) {
        this.idRol = idRol;
    }

    public SegPagina getIdPagina() {
        return idPagina;
    }

    public void setIdPagina(SegPagina idPagina) {
        this.idPagina = idPagina;
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
        hash += (idAsignacion != null ? idAsignacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegPaginaAsignada)) {
            return false;
        }
        SegPaginaAsignada other = (SegPaginaAsignada) object;
        if ((this.idAsignacion == null && other.idAsignacion != null) || (this.idAsignacion != null && !this.idAsignacion.equals(other.idAsignacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.SegPaginaAsignada[ idAsignacion=" + idAsignacion + " ]";
    }
    
}
