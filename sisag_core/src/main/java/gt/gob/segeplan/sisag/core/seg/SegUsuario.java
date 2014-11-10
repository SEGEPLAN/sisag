/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.seg;

import gt.gob.segeplan.sisag.core.rrhh.RrhhPersona;
import gt.gob.segeplan.sisag.core.rrhh.RrhhSolicitudCapacitacion;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "SEG_USUARIO", catalog = "", schema = "SCHE$SISAG")
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
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    @Column(name = "id_usuario")
    private BigDecimal idUsuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "pwd")
    private String pwd;
    @Column(name = "pregunta")
    private String pregunta;
    @Column(name = "respuesta")
    private String respuesta;
    @Column(name = "estado")
    private Character estado;
    @Column(name = "email")
    private String email;
    @Column(name = "telefono")
    private Long telefono;
    @Column(name = "restrictiva")
    private Character restrictiva;
    @OneToMany(mappedBy = "usrCrea", fetch = FetchType.EAGER)
    private List<RrhhSolicitudCapacitacion> rrhhSolicitudCapacitacionList;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.EAGER)
    private List<SegPaginaAsignada> segPaginaAsignadaList;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.EAGER)
    private List<SegSesion> segSesionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "segUsuario", fetch = FetchType.EAGER)
    private List<SegRolUsuario> segRolUsuarioList;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona")
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

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
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
        return "gt.gob.segeplan.sisag.core.entities.SegUsuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
