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
@Table(name = "ADSTBCG$DEPENDENCIAS", catalog = "", schema = "SCHE$ADSIS")
@XmlRootElement
public class RrhhUnidadAdministrativa implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADSCGDP$ID")
    private BigDecimal idUnidadAdmin;
    
    @Size(max = 100)
    @Column(name = "ADSCGDP$DESCRIPCION")
    private String nombre;
    
    @Column(name = "ADSCGDP$RESTRICTIVA")
    private Character restrictiva;
    @OneToMany(mappedBy = "idUnidadAdmin", fetch = FetchType.EAGER)
    private List<RrhhTipoPuesto> rrhhTipoPuestoList;
    @OneToMany(mappedBy = "idUnidadAdmin", fetch = FetchType.EAGER)
    private List<SegRol> segRolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rrhhUnidadAdministrativa", fetch = FetchType.EAGER)
    private List<PoaMetaDireccion> poaMetaDireccionList;
    
    @OneToMany(mappedBy = "idUnidad", fetch = FetchType.EAGER)
    private List<RrhhPersona> personaList;

    public RrhhUnidadAdministrativa() {
    }
    @XmlTransient
    public List<RrhhPersona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<RrhhPersona> personaList) {
        this.personaList = personaList;
    }

    public RrhhUnidadAdministrativa(BigDecimal idUnidadAdmin) {
        this.idUnidadAdmin = idUnidadAdmin;
    }

    public BigDecimal getIdUnidadAdmin() {
        return idUnidadAdmin;
    }

    public void setIdUnidadAdmin(BigDecimal idUnidadAdmin) {
        this.idUnidadAdmin = idUnidadAdmin;
    }

   

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   

    public Character getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(Character restrictiva) {
        this.restrictiva = restrictiva;
    }

    @XmlTransient
    public List<RrhhTipoPuesto> getRrhhTipoPuestoList() {
        return rrhhTipoPuestoList;
    }

    public void setRrhhTipoPuestoList(List<RrhhTipoPuesto> rrhhTipoPuestoList) {
        this.rrhhTipoPuestoList = rrhhTipoPuestoList;
    }

    @XmlTransient
    public List<SegRol> getSegRolList() {
        return segRolList;
    }

    public void setSegRolList(List<SegRol> segRolList) {
        this.segRolList = segRolList;
    }

    @XmlTransient
    public List<PoaMetaDireccion> getPoaMetaDireccionList() {
        return poaMetaDireccionList;
    }

    public void setPoaMetaDireccionList(List<PoaMetaDireccion> poaMetaDireccionList) {
        this.poaMetaDireccionList = poaMetaDireccionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadAdmin != null ? idUnidadAdmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RrhhUnidadAdministrativa)) {
            return false;
        }
        RrhhUnidadAdministrativa other = (RrhhUnidadAdministrativa) object;
        if ((this.idUnidadAdmin == null && other.idUnidadAdmin != null) || (this.idUnidadAdmin != null && !this.idUnidadAdmin.equals(other.idUnidadAdmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.RrhhUnidadAdministrativa[ idUnidadAdmin=" + idUnidadAdmin + " ]";
    }
    
}
