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
@Table(name = "RRHH_PERSONA", catalog = "", schema = "SCHE$SISAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RrhhPersona.findAll", query = "SELECT r FROM RrhhPersona r"),
    @NamedQuery(name = "RrhhPersona.findByIdPersona", query = "SELECT r FROM RrhhPersona r WHERE r.idPersona = :idPersona"),
    @NamedQuery(name = "RrhhPersona.findByNombres", query = "SELECT r FROM RrhhPersona r WHERE r.nombres = :nombres"),
    @NamedQuery(name = "RrhhPersona.findByApellidos", query = "SELECT r FROM RrhhPersona r WHERE r.apellidos = :apellidos"),
    @NamedQuery(name = "RrhhPersona.findByDireccion", query = "SELECT r FROM RrhhPersona r WHERE r.direccion = :direccion"),
    @NamedQuery(name = "RrhhPersona.findByTelefono", query = "SELECT r FROM RrhhPersona r WHERE r.telefono = :telefono"),
    @NamedQuery(name = "RrhhPersona.findByCorreoElectronico", query = "SELECT r FROM RrhhPersona r WHERE r.correoElectronico = :correoElectronico"),
    @NamedQuery(name = "RrhhPersona.findByRestrictiva", query = "SELECT r FROM RrhhPersona r WHERE r.restrictiva = :restrictiva")})
public class RrhhPersona1 implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_PERSONA")
    private BigDecimal idPersona;
    @Size(max = 100)
    @Column(name = "NOMBRES")
    private String nombres;
    @Size(max = 100)
    @Column(name = "APELLIDOS")
    private String apellidos;
    @Size(max = 100)
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "TELEFONO")
    private Long telefono;
    @Size(max = 100)
    @Column(name = "CORREO_ELECTRONICO")
    private String correoElectronico;
    @Column(name = "RESTRICTIVA")
    private Character restrictiva;
    @JoinColumn(name = "ID_TIPO_PUESTO", referencedColumnName = "ID_TIPO_PUESTO")
    @ManyToOne(fetch = FetchType.EAGER)
    private RrhhTipoPuesto idTipoPuesto;
    @OneToMany(mappedBy = "idEncargado", fetch = FetchType.EAGER)
    private List<RrhhPersona1> rrhhPersonaList;
    @JoinColumn(name = "ID_ENCARGADO", referencedColumnName = "ID_PERSONA")
    @ManyToOne(fetch = FetchType.EAGER)
    private RrhhPersona1 idEncargado;
    @OneToMany(mappedBy = "idPersona", fetch = FetchType.EAGER)
    private List<SegUsuario> segUsuarioList;

    public RrhhPersona1() {
    }

    public RrhhPersona1(BigDecimal idPersona) {
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

    public Character getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(Character restrictiva) {
        this.restrictiva = restrictiva;
    }

    public RrhhTipoPuesto getIdTipoPuesto() {
        return idTipoPuesto;
    }

    public void setIdTipoPuesto(RrhhTipoPuesto idTipoPuesto) {
        this.idTipoPuesto = idTipoPuesto;
    }

    @XmlTransient
    public List<RrhhPersona1> getRrhhPersonaList() {
        return rrhhPersonaList;
    }

    public void setRrhhPersonaList(List<RrhhPersona1> rrhhPersonaList) {
        this.rrhhPersonaList = rrhhPersonaList;
    }

    public RrhhPersona1 getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(RrhhPersona1 idEncargado) {
        this.idEncargado = idEncargado;
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
        if (!(object instanceof RrhhPersona1)) {
            return false;
        }
        RrhhPersona1 other = (RrhhPersona1) object;
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
