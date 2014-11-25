/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.rrhh;

import gt.gob.segeplan.sisag.core.seg.SegUsuario;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
public class RrhhPersona implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_persona")
    private BigDecimal idPersona;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private Long telefono;
    @Column(name = "correo_electronico")
    private String correoElectronico;
    @Column(name = "restrictiva")
    private Character restrictiva;
    @JoinColumn(name = "id_tipo_puesto", referencedColumnName = "id_tipo_puesto")
    @ManyToOne(fetch = FetchType.EAGER)
    private RrhhTipoPuesto idTipoPuesto;
    @OneToMany(mappedBy = "idEncargado", fetch = FetchType.EAGER)
    private List<RrhhPersona> rrhhPersonaList;
    @JoinColumn(name = "id_encargado", referencedColumnName = "id_persona")
    @ManyToOne(fetch = FetchType.EAGER)
    private RrhhPersona idEncargado;
    @OneToMany(mappedBy = "idPersona", fetch = FetchType.EAGER)
    private List<SegUsuario> segUsuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "rrhhPersona", fetch = FetchType.EAGER)
    private List<RrhhAsignaCapacitacion> rrhhAsignaCapacitacionList;

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
    public List<RrhhPersona> getRrhhPersonaList() {
        return rrhhPersonaList;
    }

    public void setRrhhPersonaList(List<RrhhPersona> rrhhPersonaList) {
        this.rrhhPersonaList = rrhhPersonaList;
    }

    public RrhhPersona getIdEncargado() {
        return idEncargado;
    }

    public void setIdEncargado(RrhhPersona idEncargado) {
        this.idEncargado = idEncargado;
    }

    @XmlTransient
    public List<SegUsuario> getSegUsuarioList() {
        return segUsuarioList;
    }

    public void setSegUsuarioList(List<SegUsuario> segUsuarioList) {
        this.segUsuarioList = segUsuarioList;
    }

    @XmlTransient
    public List<RrhhAsignaCapacitacion> getRrhhAsignaCapacitacionList() {
        return rrhhAsignaCapacitacionList;
    }

    public void setRrhhAsignaCapacitacionList(List<RrhhAsignaCapacitacion> rrhhAsignaCapacitacionList) {
        this.rrhhAsignaCapacitacionList = rrhhAsignaCapacitacionList;
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
        return "gt.gob.segeplan.sisag.core.entities.RrhhPersona[ idPersona=" + idPersona + " ]";
    }
    
}