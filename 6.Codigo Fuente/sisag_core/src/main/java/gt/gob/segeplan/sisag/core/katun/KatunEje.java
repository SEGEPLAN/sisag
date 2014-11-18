/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.katun;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "KATUN_EJE", catalog = "", schema = "SCHE$SISAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KatunEje.findAll", query = "SELECT k FROM KatunEje k"),
    @NamedQuery(name = "KatunEje.findByIdKatunEje", query = "SELECT k FROM KatunEje k WHERE k.idKatunEje = :idKatunEje"),
    @NamedQuery(name = "KatunEje.findByDescripcion", query = "SELECT k FROM KatunEje k WHERE k.descripcion = :descripcion"),
    @NamedQuery(name = "KatunEje.findByRestrictiva", query = "SELECT k FROM KatunEje k WHERE k.restrictiva = :restrictiva")})
public class KatunEje implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_katun_eje")
    private BigDecimal idKatunEje;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "restrictiva")
    private Character restrictiva;
    @JoinColumn(name = "id_katun_prioridad", referencedColumnName = "id_katun_prioridad")
    @ManyToOne(fetch = FetchType.EAGER)
    private KatunPrioridad idKatunPrioridad;

    public KatunEje() {
    }

    public KatunEje(BigDecimal idKatunEje) {
        this.idKatunEje = idKatunEje;
    }

    public BigDecimal getIdKatunEje() {
        return idKatunEje;
    }

    public void setIdKatunEje(BigDecimal idKatunEje) {
        this.idKatunEje = idKatunEje;
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

    public KatunPrioridad getIdKatunPrioridad() {
        return idKatunPrioridad;
    }

    public void setIdKatunPrioridad(KatunPrioridad idKatunPrioridad) {
        this.idKatunPrioridad = idKatunPrioridad;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKatunEje != null ? idKatunEje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KatunEje)) {
            return false;
        }
        KatunEje other = (KatunEje) object;
        if ((this.idKatunEje == null && other.idKatunEje != null) || (this.idKatunEje != null && !this.idKatunEje.equals(other.idKatunEje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.core.entities.KatunEje[ idKatunEje=" + idKatunEje + " ]";
    }
    
}
