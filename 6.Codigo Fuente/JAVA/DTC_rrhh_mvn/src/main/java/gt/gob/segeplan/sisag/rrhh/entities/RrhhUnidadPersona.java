/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gt.gob.segeplan.sisag.rrhh.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "SCHE$ADSIS.ADSTBCG$EMPLEADOS_DEPEND")
@XmlRootElement

public class RrhhUnidadPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RrhhUnidadPersonaPK rrhhRrhhUnidadPersonaPK;
    
    @Column(name = "ADSCGED$RESTRICTIVA")
    private String restrictiva;
    
    @Column(name = "ADSCGED$FEC_ING")
   @Temporal(TemporalType.TIMESTAMP)
    private Date fecIngreso;
    
    @Column(name = "ADSCGED$USERID_ING")
    private String userIdIng;
    
    @JoinColumn(name = "ADSCGED$ID_DEPENDENCIA", referencedColumnName = "ADSCGDP$ID", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private RrhhUnidadAdministrativa rrhhUnidadAdmin;
    
    @JoinColumn(name = "ADSCGED$ID_EMPLEADO", referencedColumnName = "ADSCGEM$ID", insertable = false, updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private RrhhPersona rrhhPersona;

    public RrhhUnidadPersona() {
    }

    public String getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(String restrictiva) {
        this.restrictiva = restrictiva;
    }

    public Date getFecIngreso() {
        return fecIngreso;
    }

    public void setFecIngreso(Date fecIngreso) {
        this.fecIngreso = fecIngreso;
    }

    public String getUserIdIng() {
        return userIdIng;
    }

    public void setUserIdIng(String userIdIng) {
        this.userIdIng = userIdIng;
    }

    public RrhhUnidadAdministrativa getRrhhUnidadAdmin() {
        return rrhhUnidadAdmin;
    }

    public void setRrhhUnidadAdmin(RrhhUnidadAdministrativa rrhhUnidadAdmin) {
        this.rrhhUnidadAdmin = rrhhUnidadAdmin;
    }

    public RrhhUnidadPersonaPK getRrhhRrhhUnidadPersonaPK() {
        return rrhhRrhhUnidadPersonaPK;
    }

    public void setRrhhRrhhUnidadPersonaPK(RrhhUnidadPersonaPK rrhhRrhhUnidadPersonaPK) {
        this.rrhhRrhhUnidadPersonaPK = rrhhRrhhUnidadPersonaPK;
    }

    public RrhhPersona getRrhhPersona() {
        return rrhhPersona;
    }

    public void setRrhhPersona(RrhhPersona rrhhPersona) {
        this.rrhhPersona = rrhhPersona;
    }

    
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rrhhRrhhUnidadPersonaPK != null ? rrhhRrhhUnidadPersonaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RrhhUnidadPersona)) {
            return false;
        }
        RrhhUnidadPersona other = (RrhhUnidadPersona) object;
        if ((this.rrhhRrhhUnidadPersonaPK == null && other.rrhhRrhhUnidadPersonaPK != null) || (this.rrhhRrhhUnidadPersonaPK != null && !this.rrhhRrhhUnidadPersonaPK.equals(other.rrhhRrhhUnidadPersonaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RrhhUnidadPersona{" + "rrhhRrhhUnidadPersonaPK=" + rrhhRrhhUnidadPersonaPK + '}';
    }

    

}
