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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "SEG_USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegUsuario.findAll", query = "SELECT s FROM SegUsuario s"),
    @NamedQuery(name = "SegUsuario.findByIdUsuario", query = "SELECT s FROM SegUsuario s WHERE s.idUsuario = :idUsuario"),
    @NamedQuery(name = "SegUsuario.findByNombre", query = "SELECT s FROM SegUsuario s WHERE s.nombre = :nombre"),
    @NamedQuery(name = "SegUsuario.findByPwd", query = "SELECT s FROM SegUsuario s WHERE s.pwd = :pwd"),
    @NamedQuery(name = "SegUsuario.findByPregunta", query = "SELECT s FROM SegUsuario s WHERE s.pregunta = :pregunta"),
    @NamedQuery(name = "SegUsuario.findByRespuesta", query = "SELECT s FROM SegUsuario s WHERE s.respuesta = :respuesta"),
    @NamedQuery(name = "SegUsuario.findByEstado", query = "SELECT s FROM SegUsuario s WHERE s.estado = :estado"),
    @NamedQuery(name = "SegUsuario.findByEmail", query = "SELECT s FROM SegUsuario s WHERE s.email = :email"),
    @NamedQuery(name = "SegUsuario.findByTelefono", query = "SELECT s FROM SegUsuario s WHERE s.telefono = :telefono"),
    @NamedQuery(name = "SegUsuario.findByRestrictiva", query = "SELECT s FROM SegUsuario s WHERE s.restrictiva = :restrictiva")})
public class SegUsuario implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_USUARIO", nullable = false)
    @GeneratedValue(generator = "SEG_USUARIO_GEN")
    @TableGenerator(name = "SEG_USUARIO_GEN", table = "SECUENCIAS",
            pkColumnName = "ID", valueColumnName = "VALOR",
            pkColumnValue = "SEG_USUARIO", allocationSize = 1)
    private BigDecimal idUsuario;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 100)
    @Column(name = "PWD")
    private String pwd;
    @Size(max = 100)
    @Column(name = "PREGUNTA")
    private String pregunta;
    @Size(max = 100)
    @Column(name = "RESPUESTA")
    private String respuesta;
    @Column(name = "ESTADO")
    private int estado;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Correo electrónico no válido")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TELEFONO")
    private Long telefono;
    @Column(name = "RESTRICTIVA")
    private Character restrictiva;
    @OneToMany(mappedBy = "usrCrea", fetch = FetchType.EAGER)
    private List<RrhhSolicitudCapacitacion> rrhhSolicitudCapacitacionList;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.EAGER)
    private List<SegPaginaAsignada> segPaginaAsignadaList;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.EAGER)
    private List<SegSesion> segSesionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segUsuario", fetch = FetchType.EAGER)
    private List<SegRolUsuario> segRolUsuarioList;
    @JoinColumn(name = "ID_PERSONA", referencedColumnName = "ADSCGEM$ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private RrhhPersona idPersona;

    public SegUsuario() {
    }

    public SegUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public BigDecimal getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(BigDecimal idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Character getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(Character restrictiva) {
        this.restrictiva = restrictiva;
    }

    @XmlTransient
    public List<RrhhSolicitudCapacitacion> getRrhhSolicitudCapacitacionList() {
        return rrhhSolicitudCapacitacionList;
    }

    public void setRrhhSolicitudCapacitacionList(List<RrhhSolicitudCapacitacion> rrhhSolicitudCapacitacionList) {
        this.rrhhSolicitudCapacitacionList = rrhhSolicitudCapacitacionList;
    }

    @XmlTransient
    public List<SegPaginaAsignada> getSegPaginaAsignadaList() {
        return segPaginaAsignadaList;
    }

    public void setSegPaginaAsignadaList(List<SegPaginaAsignada> segPaginaAsignadaList) {
        this.segPaginaAsignadaList = segPaginaAsignadaList;
    }

    @XmlTransient
    public List<SegSesion> getSegSesionList() {
        return segSesionList;
    }

    public void setSegSesionList(List<SegSesion> segSesionList) {
        this.segSesionList = segSesionList;
    }

    @XmlTransient
    public List<SegRolUsuario> getSegRolUsuarioList() {
        return segRolUsuarioList;
    }

    public void setSegRolUsuarioList(List<SegRolUsuario> segRolUsuarioList) {
        this.segRolUsuarioList = segRolUsuarioList;
    }

    public RrhhPersona getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(RrhhPersona idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegUsuario)) {
            return false;
        }
        SegUsuario other = (SegUsuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.SegUsuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
