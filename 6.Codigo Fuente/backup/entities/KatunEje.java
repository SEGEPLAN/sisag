/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gt.gob.segeplan.sisag.rrhh.entities;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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
    @NotNull
    @Column(name = "ID_KATUN_EJE")
    private BigDecimal idKatunEje;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "RESTRICTIVA")
    private Character restrictiva;
    @JoinColumn(name = "ID_KATUN_PRIORIDAD", referencedColumnName = "ID_KATUN_PRIORIDAD")
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
        return "gt.gob.segeplan.sisag.rrhh.entities.KatunEje[ idKatunEje=" + idKatunEje + " ]";
    }
    
}
