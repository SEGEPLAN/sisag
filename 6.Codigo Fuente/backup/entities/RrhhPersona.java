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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "ADSTBCG$EMPLEADOS", catalog = "", schema = "SCHE$ADSIS")
@XmlRootElement

public class RrhhPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADSCGEM$ID")
    private BigDecimal idPersona;
    @Size(max = 100)
    @Column(name = "ADSCGEM$NOMBRES")
    private String nombres;
    @Size(max = 100)
    @Column(name = "ADSCGEM$APELLIDOS")
    private String apellidos;
    @Size(max = 100)
    @Column(name = "ADSCGEM$DIRECCION")
    private String direccion;
    @Column(name = "ADSCGEM$TELEFONO_1")
    private Long telefono;
    @Size(max = 100)
    @Column(name = "ADSCGEM$EMAIL_1")
    private String correoElectronico;
    @Column(name = "ADSCGEM$RESTRICTIVA")
    private String restrictiva;
    
    
    @JoinColumn(name = "ADSCGDP$ID", referencedColumnName = "ADSCGDP$ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private RrhhUnidadAdministrativa idUnidad;
    
    
    @OneToMany(mappedBy = "idPersona", fetch = FetchType.EAGER)
    private List<SegUsuario> segUsuarioList;

    public RrhhPersona() {
    }

    public RrhhUnidadAdministrativa getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(RrhhUnidadAdministrativa idUnidad) {
        this.idUnidad = idUnidad;
    }

    public RrhhPersona(BigDecimal idPersona) {
        this.idPersona = idPersona;
    }

    public BigDecimal getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(BigDecimal idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(String restrictiva) {
        this.restrictiva = restrictiva;
    }

    @XmlTransient
    public List<SegUsuario> getSegUsuarioList() {
        return segUsuarioList;
    }

    public void setSegUsuarioList(List<SegUsuario> segUsuarioList) {
        this.segUsuarioList = segUsuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RrhhPersona)) {
            return false;
        }
        RrhhPersona other = (RrhhPersona) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.RrhhPersona[ idPersona=" + idPersona + " ]";
    }
    
}
