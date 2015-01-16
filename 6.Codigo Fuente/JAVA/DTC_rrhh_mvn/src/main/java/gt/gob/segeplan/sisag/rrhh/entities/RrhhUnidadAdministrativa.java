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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "SCHE$ADSIS.ADSTBCG$DEPENDENCIAS")
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
    private String descripcion;
    @Column(name = "ADSCGDP$RESTRICTIVA")
    private String restrictiva;
    
    @Transient 
    private RrhhSolicitudCapacitacion solicitudDNC;
    
    
    @OneToMany(mappedBy = "idUnidadAdmin", fetch = FetchType.LAZY)
    private List<SegRol> segRolList;
    
//    @OneToMany(mappedBy = "idUnidad", fetch = FetchType.EAGER)
//    private List<RrhhPersona> rrhhPersonaList;
    
    
    @OneToMany(mappedBy = "rrhhUnidadAdmin", fetch = FetchType.LAZY)
    private List<RrhhUnidadPersona> rrhhUnidadPersonaList;

    public RrhhUnidadAdministrativa() {
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


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(String restrictiva) {
        this.restrictiva = restrictiva;
    }

    @XmlTransient 
    public List<RrhhUnidadPersona> getRrhhUnidadPersonaList() {
        return rrhhUnidadPersonaList;
    }

    public void setRrhhUnidadPersonaList(List<RrhhUnidadPersona> rrhhUnidadPersonaList) {
        this.rrhhUnidadPersonaList = rrhhUnidadPersonaList;
    }

    
    
    
    @XmlTransient
    public List<SegRol> getSegRolList() {
        return segRolList;
    }

    public void setSegRolList(List<SegRol> segRolList) {
        this.segRolList = segRolList;
    }


//    @XmlTransient
//    public List<RrhhPersona> getRrhhPersonaList() {
//        return rrhhPersonaList;
//    }
//
//    public void setRrhhPersonaList(List<RrhhPersona> rrhhPersonaList) {
//        this.rrhhPersonaList = rrhhPersonaList;
//    }

    public RrhhSolicitudCapacitacion getSolicitudDNC() {
        return solicitudDNC;
    }

    public void setSolicitudDNC(RrhhSolicitudCapacitacion solicitudDNC) {
        this.solicitudDNC = solicitudDNC;
    }

    
}
