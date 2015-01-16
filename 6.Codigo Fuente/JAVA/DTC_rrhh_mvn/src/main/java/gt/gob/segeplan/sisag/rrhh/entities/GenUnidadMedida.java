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
@Table(name = "GEN_UNIDAD_MEDIDA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenUnidadMedida.findAll", query = "SELECT g FROM GenUnidadMedida g"),
    @NamedQuery(name = "GenUnidadMedida.findByIdUnidadMedida", query = "SELECT g FROM GenUnidadMedida g WHERE g.idUnidadMedida = :idUnidadMedida"),
    @NamedQuery(name = "GenUnidadMedida.findByDescripcion", query = "SELECT g FROM GenUnidadMedida g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "GenUnidadMedida.findByRestrictiva", query = "SELECT g FROM GenUnidadMedida g WHERE g.restrictiva = :restrictiva")})
public class GenUnidadMedida implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_UNIDAD_MEDIDA")
    private BigDecimal idUnidadMedida;
    @Size(max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "RESTRICTIVA")
    private Character restrictiva;
    @OneToMany(mappedBy = "idUnidadMedida", fetch = FetchType.LAZY)
    private List<PoaMeta> poaMetaList;

    public GenUnidadMedida() {
    }

    public GenUnidadMedida(BigDecimal idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public BigDecimal getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(BigDecimal idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Character getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(Character restrictiva) {
        this.restrictiva = restrictiva;
    }

    @XmlTransient
    public List<PoaMeta> getPoaMetaList() {
        return poaMetaList;
    }

    public void setPoaMetaList(List<PoaMeta> poaMetaList) {
        this.poaMetaList = poaMetaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadMedida != null ? idUnidadMedida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenUnidadMedida)) {
            return false;
        }
        GenUnidadMedida other = (GenUnidadMedida) object;
        if ((this.idUnidadMedida == null && other.idUnidadMedida != null) || (this.idUnidadMedida != null && !this.idUnidadMedida.equals(other.idUnidadMedida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.GenUnidadMedida[ idUnidadMedida=" + idUnidadMedida + " ]";
    }
    
}
