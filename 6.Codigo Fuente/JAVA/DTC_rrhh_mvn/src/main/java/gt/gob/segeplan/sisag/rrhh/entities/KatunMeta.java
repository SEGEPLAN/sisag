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
@Table(name = "KATUN_META")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KatunMeta.findAll", query = "SELECT k FROM KatunMeta k"),
    @NamedQuery(name = "KatunMeta.findByIdKatunMeta", query = "SELECT k FROM KatunMeta k WHERE k.idKatunMeta = :idKatunMeta"),
    @NamedQuery(name = "KatunMeta.findByDescripcion", query = "SELECT k FROM KatunMeta k WHERE k.descripcion = :descripcion"),
    @NamedQuery(name = "KatunMeta.findByRestrictiva", query = "SELECT k FROM KatunMeta k WHERE k.restrictiva = :restrictiva")})
public class KatunMeta implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_KATUN_META")
    private BigDecimal idKatunMeta;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "RESTRICTIVA")
    private Character restrictiva;
    @OneToMany(mappedBy = "idKatunMeta", fetch = FetchType.LAZY)
    private List<KatunPrioridad> katunPrioridadList;
    @OneToMany(mappedBy = "idKatunMeta", fetch = FetchType.LAZY)
    private List<PoaMeta> poaMetaList;

    public KatunMeta() {
    }

    public KatunMeta(BigDecimal idKatunMeta) {
        this.idKatunMeta = idKatunMeta;
    }

    public BigDecimal getIdKatunMeta() {
        return idKatunMeta;
    }

    public void setIdKatunMeta(BigDecimal idKatunMeta) {
        this.idKatunMeta = idKatunMeta;
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
    public List<KatunPrioridad> getKatunPrioridadList() {
        return katunPrioridadList;
    }

    public void setKatunPrioridadList(List<KatunPrioridad> katunPrioridadList) {
        this.katunPrioridadList = katunPrioridadList;
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
        hash += (idKatunMeta != null ? idKatunMeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KatunMeta)) {
            return false;
        }
        KatunMeta other = (KatunMeta) object;
        if ((this.idKatunMeta == null && other.idKatunMeta != null) || (this.idKatunMeta != null && !this.idKatunMeta.equals(other.idKatunMeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.KatunMeta[ idKatunMeta=" + idKatunMeta + " ]";
    }
    
}
