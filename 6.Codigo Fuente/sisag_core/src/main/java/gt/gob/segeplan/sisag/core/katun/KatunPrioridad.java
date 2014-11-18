/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.katun;

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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "KATUN_PRIORIDAD", catalog = "", schema = "SCHE$SISAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KatunPrioridad.findAll", query = "SELECT k FROM KatunPrioridad k"),
    @NamedQuery(name = "KatunPrioridad.findByIdKatunPrioridad", query = "SELECT k FROM KatunPrioridad k WHERE k.idKatunPrioridad = :idKatunPrioridad"),
    @NamedQuery(name = "KatunPrioridad.findByDescripcion", query = "SELECT k FROM KatunPrioridad k WHERE k.descripcion = :descripcion"),
    @NamedQuery(name = "KatunPrioridad.findByRestrictiva", query = "SELECT k FROM KatunPrioridad k WHERE k.restrictiva = :restrictiva")})
public class KatunPrioridad implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_katun_prioridad")
    private BigDecimal idKatunPrioridad;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "restrictiva")
    private Character restrictiva;
    @JoinColumn(name = "id_katun_meta", referencedColumnName = "id_katun_meta")
    @ManyToOne(fetch = FetchType.EAGER)
    private KatunMeta idKatunMeta;
    @OneToMany(mappedBy = "idKatunPrioridad", fetch = FetchType.EAGER)
    private List<KatunEje> katunEjeList;

    public KatunPrioridad() {
    }

    public KatunPrioridad(BigDecimal idKatunPrioridad) {
        this.idKatunPrioridad = idKatunPrioridad;
    }

    public BigDecimal getIdKatunPrioridad() {
        return idKatunPrioridad;
    }

    public void setIdKatunPrioridad(BigDecimal idKatunPrioridad) {
        this.idKatunPrioridad = idKatunPrioridad;
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

    public KatunMeta getIdKatunMeta() {
        return idKatunMeta;
    }

    public void setIdKatunMeta(KatunMeta idKatunMeta) {
        this.idKatunMeta = idKatunMeta;
    }

    @XmlTransient
    public List<KatunEje> getKatunEjeList() {
        return katunEjeList;
    }

    public void setKatunEjeList(List<KatunEje> katunEjeList) {
        this.katunEjeList = katunEjeList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKatunPrioridad != null ? idKatunPrioridad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KatunPrioridad)) {
            return false;
        }
        KatunPrioridad other = (KatunPrioridad) object;
        if ((this.idKatunPrioridad == null && other.idKatunPrioridad != null) || (this.idKatunPrioridad != null && !this.idKatunPrioridad.equals(other.idKatunPrioridad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.core.entities.KatunPrioridad[ idKatunPrioridad=" + idKatunPrioridad + " ]";
    }
    
}
