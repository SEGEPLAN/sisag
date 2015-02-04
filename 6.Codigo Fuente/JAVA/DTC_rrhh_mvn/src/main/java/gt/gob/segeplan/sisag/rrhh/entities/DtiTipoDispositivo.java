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
@Table(name = "DTI_TIPO_DISPOSITIVO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DtiTipoDispositivo.findAll", query = "SELECT d FROM DtiTipoDispositivo d"),
    @NamedQuery(name = "DtiTipoDispositivo.findById", query = "SELECT d FROM DtiTipoDispositivo d WHERE d.id = :id"),
    @NamedQuery(name = "DtiTipoDispositivo.findByDescripcion", query = "SELECT d FROM DtiTipoDispositivo d WHERE d.descripcion = :descripcion")})
public class DtiTipoDispositivo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "DTI_TIPO_DISPOSITIVO_GEN")
    @TableGenerator(name = "DTI_TIPO_DISPOSITIVO_GEN", table = "SECUENCIAS",
            pkColumnName = "ID", valueColumnName = "VALOR",
            pkColumnValue = "DTI_TIPO_DISPOSITIVO", allocationSize = 1)
    private BigDecimal id;
    @Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "idTipoDispositivo", fetch = FetchType.LAZY)
    private List<DtiDispositivo> dtiDispositivoList;

    public DtiTipoDispositivo() {
    }

    public DtiTipoDispositivo(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<DtiDispositivo> getDtiDispositivoList() {
        return dtiDispositivoList;
    }

    public void setDtiDispositivoList(List<DtiDispositivo> dtiDispositivoList) {
        this.dtiDispositivoList = dtiDispositivoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DtiTipoDispositivo)) {
            return false;
        }
        DtiTipoDispositivo other = (DtiTipoDispositivo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.DtiTipoDispositivo[ id=" + id + " ]";
    }
    
}
