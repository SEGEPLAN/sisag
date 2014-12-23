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
@Table(name = "RRHH_TEMA_CURSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RrhhTemaCurso.findAll", query = "SELECT r FROM RrhhTemaCurso r"),
    @NamedQuery(name = "RrhhTemaCurso.findByIdTema", query = "SELECT r FROM RrhhTemaCurso r WHERE r.idTema = :idTema"),
    @NamedQuery(name = "RrhhTemaCurso.findByNombre", query = "SELECT r FROM RrhhTemaCurso r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "RrhhTemaCurso.findByDescripcion", query = "SELECT r FROM RrhhTemaCurso r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "RrhhTemaCurso.findByRestrictiva", query = "SELECT r FROM RrhhTemaCurso r WHERE r.restrictiva = :restrictiva")})
public class RrhhTemaCurso implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_TEMA", nullable = false)
    @GeneratedValue(generator = "RRHH_TEMA_CURSO_GEN")
    @TableGenerator(name = "RRHH_TEMA_CURSO_GEN", table = "SECUENCIAS",
            pkColumnName = "ID", valueColumnName = "VALOR",
            pkColumnValue = "RRHH_TEMA_CURSO", allocationSize = 1)
    private BigDecimal idTema;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Size(max = 100)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "RESTRICTIVA")
    private int restrictiva;
    @OneToMany(mappedBy = "idTema", fetch = FetchType.EAGER)
    private List<RrhhNecesidad> rrhhNecesidadList;
    @JoinColumn(name = "ID_META", referencedColumnName = "ID_META")
    @ManyToOne(fetch = FetchType.EAGER)
    private PoaMeta idMeta;

    public RrhhTemaCurso() {
    }

    public RrhhTemaCurso(BigDecimal idTema) {
        this.idTema = idTema;
    }

    public BigDecimal getIdTema() {
        return idTema;
    }

    public void setIdTema(BigDecimal idTema) {
        this.idTema = idTema;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(int restrictiva) {
        this.restrictiva = restrictiva;
    }

    @XmlTransient
    public List<RrhhNecesidad> getRrhhNecesidadList() {
        return rrhhNecesidadList;
    }

    public void setRrhhNecesidadList(List<RrhhNecesidad> rrhhNecesidadList) {
        this.rrhhNecesidadList = rrhhNecesidadList;
    }

    public PoaMeta getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(PoaMeta idMeta) {
        this.idMeta = idMeta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTema != null ? idTema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RrhhTemaCurso)) {
            return false;
        }
        RrhhTemaCurso other = (RrhhTemaCurso) object;
        if ((this.idTema == null && other.idTema != null) || (this.idTema != null && !this.idTema.equals(other.idTema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.RrhhTemaCurso[ idTema=" + idTema + " ]";
    }
    
}
