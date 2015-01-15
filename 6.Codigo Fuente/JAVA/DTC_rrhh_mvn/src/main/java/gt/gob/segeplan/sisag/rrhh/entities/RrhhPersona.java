/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gt.gob.segeplan.sisag.rrhh.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name = "SCHE$ADSIS.ADSTBCG$EMPLEADOS")
@XmlRootElement
public class RrhhPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADSCGEM$ID")
    private BigDecimal idPersona;
    @Size(max = 50)
    @Column(name = "ADSCGEM$NOMBRES")
    private String nombres;
    @Size(max = 50)
    @Column(name = "ADSCGEM$APELLIDOS")
    private String apellidos;
    @Size(max = 200)
    @Column(name = "ADSCGEM$DIRECCION")
    private String direccion;
    @Size(max = 25)
    @Column(name = "ADSCGEM$TELEFONO_1")
    private String telefono;
    @Size(max = 200)
    @Column(name = "ADSCGEM$EMAIL_1")
    private String correoElectronico;
    
    @Column(name = "ADSCGEM$RESTRICTIVA")
    private String restrictiva;
    
    @Column(name = "ADSCGEM$SEXO")
    private int sexo;
    
    @Column(name = "ADSCGEM$FECHA_NACIMIENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecNac;
    
    @Column(name = "ADSCGEM$USERID_ING")
    private String userIdIng;
    
    
    @OneToMany(mappedBy = "idPersona", fetch = FetchType.EAGER)
    private List<SegUsuario> segUsuarioList;
    
    
    @OneToMany(mappedBy = "rrhhPersona", fetch = FetchType.EAGER)
    private List<RrhhUnidadPersona> rrhhUnidadPersonas;
    
    
    @Transient 
    private RrhhUnidadPersona rrhhUnidadPersonaList;
    

    public RrhhPersona() {
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public Date getFecNac() {
        return fecNac;
    }

    public void setFecNac(Date fecNac) {
        this.fecNac = fecNac;
    }

    public String getUserIdIng() {
        return userIdIng;
    }

    public void setUserIdIng(String userIdIng) {
        this.userIdIng = userIdIng;
    }

    public String getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(String restrictiva) {
        this.restrictiva = restrictiva;
    }

    
    

    public RrhhUnidadPersona getRrhhUnidadPersonaList() {
        return rrhhUnidadPersonaList;
    }

    public void setRrhhUnidadPersonaList(RrhhUnidadPersona rrhhUnidadPersonaList) {
        this.rrhhUnidadPersonaList = rrhhUnidadPersonaList;
    }

    
    public List<RrhhUnidadPersona> getRrhhUnidadPersonas() {
        if(rrhhUnidadPersonaList==null){
        for(RrhhUnidadPersona r: rrhhUnidadPersonas){
            if(r.getRestrictiva().contains("N")){
                rrhhUnidadPersonaList = r;
            }
         }
        }
        return rrhhUnidadPersonas;
    }

    public void setRrhhUnidadPersonas(List<RrhhUnidadPersona> rrhhUnidadPersonas) {
        this.rrhhUnidadPersonas = rrhhUnidadPersonas;
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
