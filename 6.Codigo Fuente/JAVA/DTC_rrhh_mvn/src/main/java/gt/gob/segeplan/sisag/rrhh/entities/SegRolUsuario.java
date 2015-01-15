/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gt.gob.segeplan.sisag.rrhh.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "SEG_ROL_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegRolUsuario.findAll", query = "SELECT s FROM SegRolUsuario s"),
    @NamedQuery(name = "SegRolUsuario.findByIdRol", query = "SELECT s FROM SegRolUsuario s WHERE s.segRolUsuarioPK.idRol = :idRol"),
    @NamedQuery(name = "SegRolUsuario.findByIdUsuario", query = "SELECT s FROM SegRolUsuario s WHERE s.segRolUsuarioPK.idUsuario = :idUsuario"),
    @NamedQuery(name = "SegRolUsuario.findByRestrictiva", query = "SELECT s FROM SegRolUsuario s WHERE s.restrictiva = :restrictiva")})
public class SegRolUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SegRolUsuarioPK segRolUsuarioPK;
    @Column(name = "RESTRICTIVA")
    private int restrictiva;
    @JoinColumn(name = "ID_USUARIO", referencedColumnName = "ID_USUARIO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SegUsuario segUsuario;
    @JoinColumn(name = "ID_ROL", referencedColumnName = "ID_ROL", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private SegRol segRol;

    public SegRolUsuario() {
    }

    public SegRolUsuario(SegRolUsuarioPK segRolUsuarioPK) {
        this.segRolUsuarioPK = segRolUsuarioPK;
    }

    public SegRolUsuario(BigInteger idRol, BigInteger idUsuario) {
        this.segRolUsuarioPK = new SegRolUsuarioPK(idRol, idUsuario);
    }

    public SegRolUsuarioPK getSegRolUsuarioPK() {
        return segRolUsuarioPK;
    }

    public void setSegRolUsuarioPK(SegRolUsuarioPK segRolUsuarioPK) {
        this.segRolUsuarioPK = segRolUsuarioPK;
    }

    public int getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(int restrictiva) {
        this.restrictiva = restrictiva;
    }

    public SegUsuario getSegUsuario() {
        return segUsuario;
    }

    public void setSegUsuario(SegUsuario segUsuario) {
        this.segUsuario = segUsuario;
    }

    public SegRol getSegRol() {
        return segRol;
    }

    public void setSegRol(SegRol segRol) {
        this.segRol = segRol;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (segRolUsuarioPK != null ? segRolUsuarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegRolUsuario)) {
            return false;
        }
        SegRolUsuario other = (SegRolUsuario) object;
        if ((this.segRolUsuarioPK == null && other.segRolUsuarioPK != null) || (this.segRolUsuarioPK != null && !this.segRolUsuarioPK.equals(other.segRolUsuarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.SegRolUsuario[ segRolUsuarioPK=" + segRolUsuarioPK + " ]";
    }
    
}
