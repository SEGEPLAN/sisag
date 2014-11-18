/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.seg;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author ludwin.ayala
 */
@Embeddable
public class SegRolUsuarioPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "id_rol")
    private BigInteger idRol;
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private BigInteger idUsuario;

    public SegRolUsuarioPK() {
    }

    public SegRolUsuarioPK(BigInteger idRol, BigInteger idUsuario) {
        this.idRol = idRol;
        this.idUsuario = idUsuario;
    }

    public BigInteger getIdRol() {
        return idRol;
    }

    public void setIdRol(BigInteger idRol) {
        this.idRol = idRol;
    }

    public BigInteger getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigInteger idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRol != null ? idRol.hashCode() : 0);
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegRolUsuarioPK)) {
            return false;
        }
        SegRolUsuarioPK other = (SegRolUsuarioPK) object;
        if ((this.idRol == null && other.idRol != null) || (this.idRol != null && !this.idRol.equals(other.idRol))) {
            return false;
        }
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.core.entities.SegRolUsuarioPK[ idRol=" + idRol + ", idUsuario=" + idUsuario + " ]";
    }
    
}
