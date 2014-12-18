/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gt.gob.segeplan.sisag.rrhh.entities;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "ADSTBCG$EMPLEADOS_DEPEND", catalog = "", schema = "SCHE$ADSIS")
@XmlRootElement
public class RrhhPersonaDependencia implements Serializable {
     private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RrhhPersonaDependenciaPK RrhhPersonaDependenciaPK;
    
    @JoinColumn(name = "ADSCGED$ID_DEPENDENCIA", referencedColumnName = "ADSCGED$ID_DEPENDENCIA", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private RrhhUnidadAdministrativa rrhhUnidadAdministrativa;
    @JoinColumn(name = "ADSCGED$ID_EMPLEADO", referencedColumnName = "ADSCGED$ID_EMPLEADO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private RrhhPersona RrhhPersona;

    public RrhhPersonaDependencia() {
    }

    public RrhhPersonaDependenciaPK getRrhhPersonaDependenciaPK() {
        return RrhhPersonaDependenciaPK;
    }

    public void setRrhhPersonaDependenciaPK(RrhhPersonaDependenciaPK RrhhPersonaDependenciaPK) {
        this.RrhhPersonaDependenciaPK = RrhhPersonaDependenciaPK;
    }

    public RrhhUnidadAdministrativa getRrhhUnidadAdministrativa() {
        return rrhhUnidadAdministrativa;
    }

    public void setRrhhUnidadAdministrativa(RrhhUnidadAdministrativa rrhhUnidadAdministrativa) {
        this.rrhhUnidadAdministrativa = rrhhUnidadAdministrativa;
    }

    public RrhhPersona getRrhhPersona() {
        return RrhhPersona;
    }

    public void setRrhhPersona(RrhhPersona RrhhPersona) {
        this.RrhhPersona = RrhhPersona;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.RrhhPersonaDependenciaPK != null ? this.RrhhPersonaDependenciaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RrhhPersonaDependencia other = (RrhhPersonaDependencia) obj;
        if (this.RrhhPersonaDependenciaPK != other.RrhhPersonaDependenciaPK && (this.RrhhPersonaDependenciaPK == null || !this.RrhhPersonaDependenciaPK.equals(other.RrhhPersonaDependenciaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RrhhPersonaDependencia{" + "RrhhPersonaDependenciaPK=" + RrhhPersonaDependenciaPK + '}';
    }

    
   

    
    
    
}
