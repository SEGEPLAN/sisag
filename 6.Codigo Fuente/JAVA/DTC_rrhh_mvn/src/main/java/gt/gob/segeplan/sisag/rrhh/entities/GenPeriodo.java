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
@Table(name = "GEN_PERIODO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenPeriodo.findAll", query = "SELECT g FROM GenPeriodo g"),
    @NamedQuery(name = "GenPeriodo.findByIdPeriodo", query = "SELECT g FROM GenPeriodo g WHERE g.idPeriodo = :idPeriodo"),
    @NamedQuery(name = "GenPeriodo.findByMes", query = "SELECT g FROM GenPeriodo g WHERE g.mes = :mes"),
    @NamedQuery(name = "GenPeriodo.findByDescripcion", query = "SELECT g FROM GenPeriodo g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "GenPeriodo.findByRestrictiva", query = "SELECT g FROM GenPeriodo g WHERE g.restrictiva = :restrictiva")})
public class GenPeriodo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERIODO")
    private BigDecimal idPeriodo;
    @Size(max = 50)
    @Column(name = "MES")
    private String mes;
    @Size(max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "RESTRICTIVA")
    private Character restrictiva;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "genPeriodo", fetch = FetchType.EAGER)
    private List<PoaMetaPeriodo> poaMetaPeriodoList;
    @OneToMany(mappedBy = "idPeriodo", fetch = FetchType.EAGER)
    private List<GenSolicitudFinaciera> genSolicitudFinacieraList;
    @OneToMany(mappedBy = "perIdPeriodo", fetch = FetchType.EAGER)
    private List<GenPeriodo> genPeriodoList;
    @JoinColumn(name = "PER_ID_PERIODO", referencedColumnName = "ID_PERIODO")
    @ManyToOne(fetch = FetchType.EAGER)
    private GenPeriodo perIdPeriodo;

    public GenPeriodo() {
    }

    public GenPeriodo(BigDecimal idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public BigDecimal getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(BigDecimal idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
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
    public List<PoaMetaPeriodo> getPoaMetaPeriodoList() {
        return poaMetaPeriodoList;
    }

    public void setPoaMetaPeriodoList(List<PoaMetaPeriodo> poaMetaPeriodoList) {
        this.poaMetaPeriodoList = poaMetaPeriodoList;
    }

    @XmlTransient
    public List<GenSolicitudFinaciera> getGenSolicitudFinacieraList() {
        return genSolicitudFinacieraList;
    }

    public void setGenSolicitudFinacieraList(List<GenSolicitudFinaciera> genSolicitudFinacieraList) {
        this.genSolicitudFinacieraList = genSolicitudFinacieraList;
    }

    @XmlTransient
    public List<GenPeriodo> getGenPeriodoList() {
        return genPeriodoList;
    }

    public void setGenPeriodoList(List<GenPeriodo> genPeriodoList) {
        this.genPeriodoList = genPeriodoList;
    }

    public GenPeriodo getPerIdPeriodo() {
        return perIdPeriodo;
    }

    public void setPerIdPeriodo(GenPeriodo perIdPeriodo) {
        this.perIdPeriodo = perIdPeriodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeriodo != null ? idPeriodo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenPeriodo)) {
            return false;
        }
        GenPeriodo other = (GenPeriodo) object;
        if ((this.idPeriodo == null && other.idPeriodo != null) || (this.idPeriodo != null && !this.idPeriodo.equals(other.idPeriodo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.GenPeriodo[ idPeriodo=" + idPeriodo + " ]";
    }
    
}
